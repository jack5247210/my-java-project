package com.example.myproject.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.example.myproject.constants.ReplyMessage;
import com.example.myproject.constants.Type;
import com.example.myproject.dao.FillinDao;
import com.example.myproject.dao.QuestionDao;
import com.example.myproject.dao.UserDao;
import com.example.myproject.entity.Fillin;
import com.example.myproject.entity.Question;
import com.example.myproject.entity.User;
import com.example.myproject.req.FeedbackReq;
import com.example.myproject.req.FillinReq;
import com.example.myproject.res.BasicRes;
import com.example.myproject.res.FeedbackRes;
import com.example.myproject.res.FeedbackUserVo;
import com.example.myproject.res.GetFeedbackUserRes;
import com.example.myproject.vo.AnswerVo;

@Service
public class FillinService {
	@Autowired
	private FillinDao fillinDao;

	@Autowired
	private UserDao userDao;
	@Autowired
	private QuestionDao questionDao;

	@Transactional(rollbackFor = Exception.class) // 也可以加在類別上，每個方法都有回溯這個效果
	public BasicRes fillin(FillinReq req) {

		BasicRes res = checkParams(req);
		if (res != null) {
			return res;
		}
		try {
			// 新增資料：
			for (AnswerVo vo : req.getAnswerVoList()) {
				fillinDao.insert(req.getQuizId(), vo.getQuestion().getQuestionId(), req.getUserphone(), vo.getAnswer());
			}

		} catch (Exception e) {
			throw e;

		}

		return new BasicRes(ReplyMessage.SUCCESS.getCode(), //
				ReplyMessage.SUCCESS.getMessage());
	}

	private BasicRes checkParams(FillinReq req) {
		if (req.getQuizId() <= 0) {
			return new BasicRes(ReplyMessage.QUIZ_ID_ERROR.getCode(), //
					ReplyMessage.QUIZ_ID_ERROR.getMessage());
		}
		if (!StringUtils.hasText(req.getName())) {
			return new BasicRes(ReplyMessage.USER_NAME_ERROR.getCode(), //
					ReplyMessage.USER_NAME_ERROR.getMessage());
		}
		if (req.getAge() <= 18) {
			return new BasicRes(ReplyMessage.USER_AGE_ERROR.getCode(), //
					ReplyMessage.USER_AGE_ERROR.getMessage());
		}
		if (!StringUtils.hasText(req.getUserphone())) {
			return new BasicRes(ReplyMessage.USER_PHONE_ERROR.getCode(), //
					ReplyMessage.USER_PHONE_ERROR.getMessage());
		}
		// 要檢查每一個 答案
		for (AnswerVo vo : req.getAnswerVoList()) {
			// 檢查必填但沒有答案（沒有選項或者沒有答案）
			if (vo.getQuestion().isRequired()) {
				if (vo.getNumber() <= 0 || !StringUtils.hasText(vo.getAnswer())) {
					return new BasicRes(ReplyMessage.ANSWER_REQUIRED.getCode(), //
							ReplyMessage.ANSWER_REQUIRED.getMessage());
				}
			}
			// 檢查選項與答案是否匹配,看看是不是對應的quesion中的選項和我選的選擇是不是要一致的(前提是答案要有值）
//		--》是選擇題且有答案的情況下，檢查是否與question中的選項匹配
			if (Type.isChoiceType(vo.getQuestion().getType())) {
				if (StringUtils.hasText(vo.getAnswer())) {
					if (StringUtils.hasText(vo.getAnswer())) {

					}

				}

			}

		}
		return null;

	}

	public GetFeedbackUserRes getAllFillinUsers(int quizId) {
		if (quizId <= 0) {
			return new GetFeedbackUserRes(ReplyMessage.QUIZ_ID_ERROR.getCode(), //
					ReplyMessage.QUIZ_ID_ERROR.getMessage());
		}
		List<Fillin> list = fillinDao.getByQuizId(quizId);
		List<AnswerVo> answerVoList = new ArrayList<>();
		Map<String, FeedbackUserVo> map = new HashMap<>();
		List<FeedbackUserVo> userVoList = new ArrayList<>();
		Map<String, List<AnswerVo>> answerVomap = new HashMap<>();
		for (Fillin fillin : list) {
			if (!map.containsKey(fillin.getUserphone())) {
				/*
				 * 使用 map 可以防止同一位使用者有多題的作答時，會產生多個 FeedbackUserVo， 因為是同一位使用者對同一張問卷作答多題
				 */
				/* 新的使用者必須要重置 List<AnswerVo> answerVoList */
				User user = userDao.getByPhone(fillin.getUserphone());
				answerVoList = new ArrayList<>();
				FeedbackUserVo userVo = new FeedbackUserVo(user.getUserphone(), user.getName(), //
						fillin.getFillinTime(), answerVoList, user.getAge());
				userVoList.add(userVo);
				map.put(fillin.getUserphone(), userVo);
				answerVomap.put(fillin.getUserphone(), answerVoList);
			}
			List<Question> questionList = questionDao.getByQuizId(quizId);
			for (Question question : questionList) {
				/* 比對 question_id: 一樣的就把答案放到 AnswerVo */
				if (fillin.getQuestionId() == question.getQuestionId()) {
					AnswerVo answerVo = new AnswerVo(question, fillin.getAnswer());
					/* 取出特定使用者舊的 answerVoList */
					answerVoList = answerVomap.get(fillin.getUserphone());
					/* 增加新的 answerVo */
					answerVoList.add(answerVo);
					/* 把新的 answerVoList 放回到 answerVomap 中 */
					answerVomap.put(fillin.getUserphone(), answerVoList);
				}
			}
		}
		return new GetFeedbackUserRes(ReplyMessage.SUCCESS.getCode(), //
				ReplyMessage.SUCCESS.getMessage(), userVoList);
	}
	//補上
		public FeedbackRes feedback(FeedbackReq req) {
			/* 參數檢查 */
			/* 透過 quizId 取得所有問題 */
			List<Question> /* questionsList縮寫等於= */ quList = questionDao.getByQuizId(req.getQuizId());
			List<Fillin> fillinList = fillinDao.getByQuizIdAndUserphone(req.getQuizId(), req.getUserphone());
			User user = userDao.getByPhone(req.getUserphone());
			if (user == null) {
				return new FeedbackRes(ReplyMessage.USER_NOT_FOUND.getCode(), //
						ReplyMessage.USER_NOT_FOUND.getMessage());
			}
			List<AnswerVo> answerVoList = new ArrayList<>();
			FeedbackRes res = new FeedbackRes(ReplyMessage.SUCCESS.getCode(), //
					ReplyMessage.SUCCESS.getMessage(), //
					req.getQuizId(), user.getName(), //
					user.getUserphone(), user.getAge(), answerVoList);
			
			/* 把答案匹配到對應的問題上面 */
			
			for (Question qu : quList) {
				AnswerVo vo = new AnswerVo(qu);// vo 中一定會包含 question，但不一定會有使用者的答案(因為若不是必選他可能部會作答而空白)
				for (Fillin fillin : fillinList) {
					if(qu.getQuestionId() == fillin.getQuestionId()) {
						/*若兩個QuestionIdID, 把Ans 放到 vo 中*/
						vo.setAnswer(fillin.getAnswer());
						answerVoList.add(vo);
						/* 有匹配到相同題號, 就可以跳過剩下 fillin (題目)的比對*/
						break;
					}
				}
			}
			return res;
		}
}

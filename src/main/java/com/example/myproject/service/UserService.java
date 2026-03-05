package com.example.myproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.example.myproject.constants.ReplyMessage;
import com.example.myproject.dao.UserDao;
import com.example.myproject.entity.User;
import com.example.myproject.req.LoginReq;
import com.example.myproject.req.RegisterReq;
import com.example.myproject.res.BasicRes;
import com.example.myproject.res.LoginRes;

@Service
public class UserService {

    // 密碼加密器
    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    @Autowired
    private UserDao userDao;

    // 登入方法
    public LoginRes login(LoginReq req) {
        // 1. 檢查電話號碼是否為空
        if (!StringUtils.hasText(req.getUserphone())) {
            return new LoginRes(
                ReplyMessage.USER_PHONE_ERROR.getCode(),
                ReplyMessage.USER_PHONE_ERROR.getMessage()
            );
        }

        // 2. 檢查密碼是否為空
        if (!StringUtils.hasText(req.getPassword())) {
            return new LoginRes(
                ReplyMessage.USER_PASSWORD_ERROR.getCode(),
                ReplyMessage.USER_PASSWORD_ERROR.getMessage()
            );
        }

        // 3. 根據電話號碼查詢使用者
        User user = userDao.getByPhone(req.getUserphone());
        if (user == null) {
            // 失敗時也回傳 LoginRes（只是 code 不是成功）
            return new LoginRes(
                ReplyMessage.USER_NOT_FOUND.getCode(),
                ReplyMessage.USER_NOT_FOUND.getMessage(),
                false,  // admin 預設 false
                null    // 手機號碼 null
            );
        }

        // 5. 比對密碼（明碼 vs 資料庫加密密碼）
        boolean isMatch = encoder.matches(req.getPassword(), user.getPassword());
        if (!isMatch) {
            return new LoginRes(
                ReplyMessage.USER_PASSWORD_ERROR.getCode(),
                ReplyMessage.USER_PASSWORD_ERROR.getMessage(),
                false, null
            );
        }

        // 7. 登入成功
     // 成功時回傳 LoginRes，帶入真實的管理員狀態與手機號碼
        return new LoginRes(
            ReplyMessage.SUCCESS.getCode(),
            ReplyMessage.SUCCESS.getMessage(),
            user.isAdmin(),         // 從資料庫取得
            user.getUserphone()
        );
    }

    // 註冊方法
    public BasicRes register(RegisterReq req) {
        BasicRes res = checkParams(req);
        if (res != null) {
            return res;
        }
        int count = userDao.getPhoneCount(req.getUserphone());
        if (count == 1) {
            return new BasicRes(
                ReplyMessage.USER_PHONE_EXISTED.getCode(),
                ReplyMessage.USER_PHONE_EXISTED.getMessage()
            );
        }
        try {
            userDao.insert(
                req.getUserphone(),
                req.getName(),
                req.getAge(),
                encoder.encode(req.getPassword())
            );
        } catch (Exception e) {
            throw e;
        }
        return new BasicRes(
            ReplyMessage.SUCCESS.getCode(),
            ReplyMessage.SUCCESS.getMessage()
        );
    }

    // 註冊參數檢查
    private BasicRes checkParams(RegisterReq req) {
        if (!StringUtils.hasText(req.getUserphone())) {
            return new BasicRes(
                ReplyMessage.USER_PHONE_ERROR.getCode(),
                ReplyMessage.USER_PHONE_ERROR.getMessage()
            );
        }
        if (!StringUtils.hasText(req.getPassword())) {
            return new BasicRes(
                ReplyMessage.USER_PASSWORD_ERROR.getCode(),
                ReplyMessage.USER_PASSWORD_ERROR.getMessage()
            );
        }
        if (!StringUtils.hasText(req.getName())) {
            return new BasicRes(
                ReplyMessage.USER_NAME_ERROR.getCode(),
                ReplyMessage.USER_NAME_ERROR.getMessage()
            );
        }
        if (req.getAge() <= 18) {
            return new BasicRes(
                ReplyMessage.USER_AGE_ERROR.getCode(),
                ReplyMessage.USER_AGE_ERROR.getMessage()
            );
        }
        return null;
    }
    
}
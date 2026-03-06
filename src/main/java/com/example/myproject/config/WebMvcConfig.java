package com.example.myproject.config;

// 導入 Spring 的配置相關類別
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * WebMvcConfig 是 Spring MVC 的全域設定類別
 * 實作 WebMvcConfigurer 介面，可以覆寫方法來客製化 MVC 行為
 * 
 * 這裡主要用來設定 CORS (跨來源資源共享)，
 * 讓前端 Angular (http://localhost:4200) 可以順利呼叫後端 API。
 */
@Configuration  // 標記這是一個設定類別，Spring 啟動時會自動載入
public class WebMvcConfig implements WebMvcConfigurer {

    /**
     * addCorsMappings 方法用於設定 CORS 規則
     * 它會攔截所有請求，並在回應中加入指定的 CORS 標頭
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        
        // registry.addMapping("/**") 表示對所有 API 路徑生效
        registry.addMapping("/**")
                
                // allowedOrigins 允許哪些來源（前端網址）存取
                // 這裡設為 "http://localhost:4200" 是 Angular 開發伺服器的預設位置
                // 注意：當 allowCredentials(true) 時，這裡不能使用 "*"，必須指定單一來源
                .allowedOrigins("http://localhost:4200")
                
                // allowedMethods 允許哪些 HTTP 方法
                // 包括 GET, POST, PUT, DELETE, OPTIONS
                // OPTIONS 是瀏覽器發送預檢請求時會用到的方法，一定要包含
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                
                // allowedHeaders 允許哪些自訂標頭
                // "*" 表示允許所有常見標頭 (如 Content-Type, Authorization 等)
                .allowedHeaders("*")
                
                // allowCredentials 是否允許前端攜帶 Cookie / Session 資訊
                // 設為 true 才能維持登入狀態 (session)
                .allowCredentials(true);
    }
}
package com.yitian.demo2.config;

import com.google.common.base.Predicate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.web.servlet.error.BasicErrorController;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.method.HandlerMethod;
import springfox.documentation.RequestHandler;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

//import static springfox.documentation.builders.PathSelectors.regex;


@Configuration
public class SwaggerConfig {
    @Value("${spring.application.name}")
    private String applicationName;

    @Bean
//	@ConditionalOnMissingBean(Docket.class)
    public Docket createRestApiPro() {
        Predicate<RequestHandler> predicate = new Predicate<RequestHandler>() {
            @Override
            public boolean apply(RequestHandler input) {
                Class<?> declaringClass = input.declaringClass();
                if (declaringClass == BasicErrorController.class )// 排除
                    return false;
//                if (AbstractEndpointMvcAdapter.class.isAssignableFrom(declaringClass) || MvcEndpoint.class.isAssignableFrom(declaringClass)) // 父类
//                    return false;
                if (declaringClass.isAnnotationPresent(RestController.class)) // 被注解的类
                    return true;
                HandlerMethod handlerMethod = input.getHandlerMethod();
                if( handlerMethod.hasMethodAnnotation(ResponseBody.class)){
                    return true;
                }
                return false;
            }
        };
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).useDefaultResponseMessages(false).select().apis(predicate).build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title(applicationName + "接口信息").version("1.0").build();
    }

}

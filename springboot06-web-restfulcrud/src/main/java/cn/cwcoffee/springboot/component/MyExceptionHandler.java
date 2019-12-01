package cn.cwcoffee.springboot.component;

import cn.cwcoffee.springboot.Exception.UserNotExistException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * created by coffeecw 2019/12/01
 */
@ControllerAdvice
public class MyExceptionHandler {

    //返回定制的json数据
   /* @ResponseBody
    @ExceptionHandler(UserNotExistException.class)
    public Map<String,Object> handleException(Exception e){
        Map<String,Object> map = new HashMap<>();
        map.put("code","user notExist");
        map.put("message",e.getMessage());
        return map;
    }*/

    //转发到/error进行自适应响应效果处理
    @ExceptionHandler(UserNotExistException.class)
    public String handleException(Exception e, HttpServletRequest request) {
        Map<String, Object> map = new HashMap<>();
        //传入我们自己的错误状态码  4xx 5xx，否则就不会进入定制错误页面的解析流程
        /**
         * Integer statusCode = (Integer) request
         .getAttribute("javax.servlet.error.status_code");
         */
        request.setAttribute("javax.servlet.error.status_code",500);
        map.put("code", "user notExist");
        map.put("message", e.getMessage());

        request.setAttribute("ext",map);
        //转发到/error
        return "forward:/error";
    }
}

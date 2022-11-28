package com.Zijin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * 获取请求参数的方式：
 * 1、通过servletAPI获取
 * 只需要在控制器方法的形参位置设置HttpServletRequest类型的形参
 * 就可以在控制器方法中使用request对象请求参数
 * 2、通过控制器方法的形参获取
 * 只需要在控制器方法的形参位置，设置一个形参，形参的名字和请求参数的名字一致即可
 *3、@RequestParam：将请求参数和控制器方法的形参绑定
 * 三个属性：value required defaultvalue
 * value：设置和形参绑定的请求参数的名字
 * required：设置是否必须传输value所对应的请求参数
 * 默认值为true，表示value所对应的请求参数必须传输，否则页面报错
 * 400
 * 若设置为false，则当前请求不是必须传输value所指定的请求参数，
 * 若没有传输，则注解所标识的形参的值为null
 * defaultValue：不管required属性值为true或false，当value所指定的请求参数没有传输或传输的值
 * 为""时，则使用默认值为形参赋值
 *
 *4、@RequestHeader
 * 5、@CookieValue
 * 6、通过POJO获取请求参数
 * 可以在控制器方法的形参位置设置一个实体类类型的形参，此时若浏览器传输的请求参数的参数名和实 体类中的属性名一致，那么请求参数就会为此属性赋值
 * 7、设置CharacteEncodingFilter解决乱码问题
 *
 *
 */
@Controller
public class TestParamController {

    @RequestMapping("/param/servletAPI")
    public String getParamServletAPI(HttpServletRequest request){
        HttpSession session=request.getSession();//设置编码前不能获得任何参数
        String username=request.getParameter("username");
        String password= request.getParameter("password");
        System.out.println("username:"+username+",password:"+password);
        return "success";

    }

    @RequestMapping("/param")
    public String getParam(@RequestParam(value = "username",required = false,defaultValue = "hello") String username,
                           String password,
                           @RequestHeader("referer") String referer,
                           @CookieValue("JSESSIONID") String  jsessionId
                           ){
        System.out.println("username:"+username+",password:"+password);
        System.out.println("referer:"+referer);
        System.out.println("jsessionId"+jsessionId);
        return "success";
    }
}

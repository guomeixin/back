package com.neuedu.controller;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import com.neuedu.pojo.Message;
import com.neuedu.pojo.User;
import com.neuedu.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
   @Resource
    UserService userService;
   @GetMapping("/login")
    public String goLogin(){
       return "user/login";
   }
   @PostMapping("/login")
   @ResponseBody
   public Message  doLogin(User user, HttpServletResponse response) throws IOException {
       //判断用户登录信息
       Message message =null;
       User login=userService.login(user);
       if(login==null)
           message = new Message(0,"用户名不存在" );
       else{
           if(!login.getPassword().equals(user.getPassword())){
               message = new Message(0,"密码输入错误" );
           }else {
               message = new Message(1,"登陆成功" );
           }
       }
       /*FastJsonConfig fastJsonConfig = new FastJsonConfig();
       //SerializerFeature.DisableCircularReferenceDetect
       response.getWriter().print(JSONObject.toJSONString(message));
       */
       return message;

   }
  @GetMapping("/list")
    public String list(ModelMap modelMap){
      modelMap.addAttribute("list", userService.list());
       return "user/list";
   }
   @GetMapping("/getList")
    public List<User> getList(){
       return userService.list();
   }
   /* @GetMapping("/add")
    public String  add(){
        return "user/add";
    }
    @GetMapping("/update")
    public String update(){
        return "user/update";
    }*/

}

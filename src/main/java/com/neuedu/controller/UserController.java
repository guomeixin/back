package com.neuedu.controller;


import com.neuedu.pojo.User;
import com.neuedu.service.UserService;
import com.neuedu.util.Message;
import com.neuedu.util.MyUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

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
   public Message doLogin(User user, String code, HttpServletResponse response, HttpSession session) throws IOException {
       //判断用户登录信息
       Message message =null;
       User login = userService.login(user);
       if(login==null)
           message = new Message(0,"用户名不存在" );
       else{
           if(!login.getPassword().equals(user.getPassword())){
               message = new Message(0,"密码输入错误" );
           }else {
               if (session.getAttribute("img") == null)
                   message = new Message(0, "登录超时");
               else {
                   String img = session.getAttribute("img").toString();
                   if (!img.equalsIgnoreCase(code))
                       //忽略大小写
                       message = new Message(0, "验证码输入错误");
                    else
                        message = new Message(1, "登陆成功");
               }
           }
       }
       //FastJsonConfig fastJsonConfig = new FastJsonConfig();
        //SerializerFeature.DisableCircularReferenceDetect
        //System.out.println(JSONObject.toJSONString(message));
       // return JSONObject.toJSONString(message);
       //response.getWriter().print(JSONObject.toJSONString(message));
       return message;
   }
   @GetMapping("/img")
   public void getImg(HttpServletResponse response,HttpSession session) throws IOException {
       char[] array = MyUtil.getStr();
       BufferedImage image = new BufferedImage(100,43 ,BufferedImage.TYPE_INT_RGB );
       Graphics2D graphics=image.createGraphics();
       graphics.setColor(Color.BLACK);
       graphics.fillRect(0,0 ,100 ,43 );
       graphics.setColor(Color.WHITE);
       graphics.setFont(new Font("微软雅黑", Font.BOLD, 32));
       graphics.drawString(new String(array),5 ,30 );
       session.setAttribute("img",new String(array) );
       ImageIO.write(image, "JPG",response.getOutputStream());
   }

   @GetMapping("/list")
    public String list(){
     // modelMap.addAttribute("list", userService.list());
       return "user/list";
   }
   @GetMapping("/getList")
   @ResponseBody
    public Message getList(User user){
       return new Message(1,(userService.list(user));
   }
}

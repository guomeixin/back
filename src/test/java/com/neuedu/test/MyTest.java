package com.neuedu.test;

import com.neuedu.pojo.User;
import com.neuedu.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)//启动时，先运行此类
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class MyTest {
    @Resource
    UserService userService;
    @Test
    public void   method(){
      /*  User user = new User();
        user.setLogin_id("002");
        user.setName("111");
        user.setPhone("1254325");
        user.setPassword("123123");
        user.setSex(1);
        user.setBirthday(new Date());
        user.setEmail("werwrw@qq.com");
        user.setAddress("天津");
        user.setIs_del(1);
        System.out.println(userService.add(user));*/

    List<User> users = new ArrayList<User>();
     for(int i=1;i<=100;i++){
         User user = new User();
         user.setLogin_id("r1"+i);
         user.setName("n"+i);
         user.setSex(1);
         user.setEmail("wer@qq.com");
         user.setPhone("4564"+i);
         user.setPassword("123456");
         user.setBirthday(new Date());
         user.setAddress("hidsuf");
         user.setIs_del(1);
         users.add(user);
     }
        System.out.println(userService.batch(users));
    }
}

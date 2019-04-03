package com.neuedu.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.exception.InvalidConfigurationException;
import org.mybatis.generator.exception.XMLParserException;
import org.mybatis.generator.internal.DefaultShellCallback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)//启动时，先运行此类
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class MyTest {
   /* @Resource
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
     //批量添加
    /*List<User> users = new ArrayList<User>();
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
    }*/

    @Test
    public void generator(){
        List<String> warnings = new ArrayList<>();
        boolean overwrite = true;
        //指定逆向工程配置文件
        File configFile = new File(System.getProperty("user.dir")+"/src/test/resources/mybatis-generator.xml");
        ConfigurationParser cp = new ConfigurationParser(warnings);
        Configuration config = null;
        try {
            config = cp.parseConfiguration(configFile);
            DefaultShellCallback callback = new DefaultShellCallback(overwrite);
            MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config,
                    callback, warnings);
            myBatisGenerator.generate(null);
            System.out.println("生成完成");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (XMLParserException e) {
            e.printStackTrace();
        } catch (InvalidConfigurationException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

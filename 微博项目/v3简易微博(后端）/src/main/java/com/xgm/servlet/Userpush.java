package com.xgm.servlet;

import com.xgm.mapper.UserMapper;
import com.xgm.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

import static java.lang.System.out;

public class Userpush {
    @WebServlet("/useradd")
    public static class useradd extends HttpServlet {
        public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
            response.setContentType("application/x-www-form-urlencoded;charset=utf-8");


            String name = request.getParameter("name");
            String password = request.getParameter("password");

            String resource = "mybatis-config.xml";
            InputStream inputStream = Resources.getResourceAsStream(resource);
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

            //2、获取sqlSession对象
            SqlSession sqlSession = sqlSessionFactory.openSession();

            //3.执行添加
            UserMapper userMapper=sqlSession.getMapper(UserMapper.class);


            //输出流
            PrintWriter out = response.getWriter();

            User test=userMapper.getUser(name);
            if(test!=null){
                out.println("{\"success\": false}");
                return;
            }
            User user = new User();
            user.setName(name);
            user.setPassword(password);
            out.println("{\"success\": true}");
            userMapper.add(user);

            sqlSession.commit();












        }
        public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
            doGet(request, response);
        }



    }
}

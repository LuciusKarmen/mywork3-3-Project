package com.xgm.servlet;

import com.xgm.mapper.TipMapper;
import com.xgm.mapper.UserMapper;
import com.xgm.pojo.Tip;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;

public class Tippush {
    @WebServlet("/tipadd")
    public static class TipaddServlet extends HttpServlet {
        public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            response.setContentType("application/x-www-form-urlencoded;charset=utf-8");

            String name = request.getParameter("name");
            String id = request.getParameter("id");
            Integer like=Integer.parseInt(request.getParameter("like"));
            String content = request.getParameter("content");
            String time = request.getParameter("time");
            String img = request.getParameter("img");

            String resource = "mybatis-config.xml";
            InputStream inputStream = Resources.getResourceAsStream(resource);
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

            //2、获取sqlSession对象
            SqlSession sqlSession = sqlSessionFactory.openSession();

            //3.执行添加
            TipMapper tipMapper = sqlSession.getMapper(TipMapper.class);

            Tip tip = new Tip();
            tip.setName(name);
            tip.setId(id);
            tip.setLike(like);
            tip.setContent(content);
            tip.setTime(time);
            tip.setImg(img);
            tipMapper.insertTip(tip);

            sqlSession.commit();


        }
        public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            doGet(request, response);
        }
    }
}

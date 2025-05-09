package com.xgm.servlet;

import com.xgm.mapper.TipMapper;
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

public class Tiplike {
    @WebServlet("/tiplike")
    public static class tiplike extends HttpServlet {
        public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
            response.setContentType("application/x-www-form-urlencoded;charset=utf-8");


            String id = request.getParameter("id");


            String resource = "mybatis-config.xml";
            InputStream inputStream = Resources.getResourceAsStream(resource);
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

            //2、获取sqlSession对象
            SqlSession sqlSession = sqlSessionFactory.openSession();

            //3.执行添加
            TipMapper tipMapper = sqlSession.getMapper(TipMapper.class);

            tipMapper.updateLike(id);
            sqlSession.commit();


        }

        public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
            doGet(request, response);
        }
    }
}

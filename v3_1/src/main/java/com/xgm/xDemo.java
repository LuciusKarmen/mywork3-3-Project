package com.xgm;

import com.xgm.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class mybatisdemo {
    public static void main(String[] args) throws IOException {
        //1、加载配置文件
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2、获取sqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //3.执行查询
        List<User> users=sqlSession.selectList("test.selectBlog");

        System.out.println(users);

        sqlSession.close();

    }
}

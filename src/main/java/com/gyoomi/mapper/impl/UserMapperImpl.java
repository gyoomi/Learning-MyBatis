/**
 * Copyright © 2018, LeonKeh
 * <p>
 * All Rights Reserved.
 */

package com.gyoomi.mapper.impl;

import com.gyoomi.entity.User;
import com.gyoomi.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

/**
 * 类功能描述
 *
 * @author Leon
 * @version 2018/11/12 22:00
 */
public class UserMapperImpl implements UserMapper {

    private static final String NAME_SPACE = "UserMapper.";
    private static SqlSessionFactory ssf;
    private static Reader reader;

    static {
        try {
            reader = Resources.getResourceAsReader("mybatis-config.xml");
            ssf = new SqlSessionFactoryBuilder().build(reader);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public User save(User user) {
        SqlSession sqlSession = ssf.openSession();
        int rows = sqlSession.insert(NAME_SPACE + "save", user);
        sqlSession.commit();
        if (rows > 0) {
            return user;
        } else {
            return null;
        }
    }
}

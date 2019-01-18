/**
 * Copyright © 2019, LeonKeh
 * <p>
 * All Rights Reserved.
 */

package com.gyoomi.mapper.impl;

import com.gyoomi.entity.Blog;
import com.gyoomi.mapper.BlogMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

/**
 * 类功能描述
 *
 * @author Leon
 * @version 2019/1/18 11:09
 */
public class BlogMapperImpl implements BlogMapper {

    private static final String NAME_SPACE = "BlogMapper.";
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
    public List<Blog> findByList() {
        SqlSession sqlSession = ssf.openSession();
        List<Blog> objects = sqlSession.selectList(NAME_SPACE + "findByList");
        return objects;
    }
}

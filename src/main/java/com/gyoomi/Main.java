/**
 * Copyright © 2018, TaoDing
 * <p>
 * All Rights Reserved.
 */

package com.gyoomi;

import com.gyoomi.entity.Blog;
import com.gyoomi.entity.User;
import com.gyoomi.mapper.BlogMapper;
import com.gyoomi.mapper.UserMapper;
import com.gyoomi.mapper.impl.BlogMapperImpl;
import com.gyoomi.mapper.impl.UserMapperImpl;

import java.util.Date;
import java.util.List;

/**
 * 类功能描述
 *
 * @author Leon
 * @version 2018/11/12 16:38
 */
public class Main {

    private static UserMapper userMapper;

    static {
        userMapper = new UserMapperImpl();
    }

    public static void main(String[] args) {
        BlogMapper blogMapper = new BlogMapperImpl();
        List<Blog> byList = blogMapper.findByList();
        System.out.println(byList);
    }

    public void test01() {
        UserMapper userMapper = new UserMapperImpl();
        User user = new User();
        user.setPassword("123");
        user.setCreateDate(new Date());
        user.setDeptment("研发部门");
        user.setEmail("123@qq.com");
        user.setStatus(1);
        user.setUserName("张三");
        user.setPhone("13888888888");
        user.setRemark("系统默认用户");
        User userToReturn = userMapper.save(user);
        System.out.println(userToReturn);
    }
}

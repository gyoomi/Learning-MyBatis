package com.gyoomi.note.reflector;

import com.gyoomi.entity.User;
import org.apache.ibatis.reflection.factory.DefaultObjectFactory;

/**
 * ObjectFactory工厂
 *
 * @author Leon
 * @version 2019/4/15 22:29
 */
public class Main03ObjectFactory {

    public static void main(String[] args) throws Exception {
        DefaultObjectFactory defaultObjectFactory = new DefaultObjectFactory();
        User user = defaultObjectFactory.create(User.class);
        System.out.println(user);
    }
}

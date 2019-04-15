package com.gyoomi.note.reflector;

import com.gyoomi.entity.User;
import org.apache.ibatis.reflection.Reflector;

/**
 * Reflector的理解
 *
 * @author Leon
 * @version 2019/4/15 21:52
 */
public class Main01 {

    public static void main(String[] args) {
        Reflector reflector = new Reflector(User.class);
        System.out.println(reflector);
    }
}

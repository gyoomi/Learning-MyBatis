package com.gyoomi.note.reflector;

import com.gyoomi.entity.User;
import org.apache.ibatis.reflection.TypeParameterResolver;

import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * TypeParameterizedResolver的理解
 *
 * @author Leon
 * @version 2019/4/15 21:54
 */
public class Main02 {
    private List<User> list = new ArrayList<>();


    public static void main(String[] args) throws Exception {
        Field listField = Main02.class.getDeclaredField("list");
        Type type = TypeParameterResolver.resolveFieldType(listField, Main02.class);
        System.out.println(type);
    }

    public List<User> getList() {
        return list;
    }

    public void setList(List<User> list) {
        this.list = list;
    }
}

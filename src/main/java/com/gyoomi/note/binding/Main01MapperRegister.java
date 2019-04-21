package com.gyoomi.note.binding;

import org.apache.ibatis.binding.MapperRegistry;

/**
 * 类功能描述
 *
 * @author Leon
 * @version 2019/4/21 0:12
 */
public class Main01MapperRegister {

    public static void main(String[] args) {
        MapperRegistry mapperRegistry = new MapperRegistry(null);
        System.out.println(mapperRegistry);
    }
}

package com.gyoomi.note.type;

import org.apache.ibatis.type.TypeAliasRegistry;

/**
 * TypeAliasHandler:
 *     支持为一个类添加别名，后面通过别名来进行这个类的引用。
 *
 * @author Leon
 * @version 2019/4/16 22:50
 */
public class Main03TypeAliasHandler {

    public static void main(String[] args) throws Exception {
        TypeAliasRegistry aliasRegistry = new TypeAliasRegistry();
        System.out.println(aliasRegistry);
        // 扫描固定包下的@Alias注解。进行类的别名注册。
        aliasRegistry.registerAliases("");
    }
}

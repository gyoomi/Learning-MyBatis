/**
 * Copyright © 2019, LeonKeh
 * <p>
 * All Rights Reserved.
 */

package com.gyoomi.note.type;

import org.apache.ibatis.type.TypeHandlerRegistry;

/**
 * TypeHandlerRegistry
 *     用来管理众多的TypeHandler类。
 *
 *
 * @author Leon
 * @version 2019/4/16 14:12
 */
public class Main02TypeHandlerRegistry {

    public static void main(String[] args) throws Exception {
        TypeHandlerRegistry typeHandlerRegistry = new TypeHandlerRegistry();
        System.out.println(typeHandlerRegistry);
    }
}

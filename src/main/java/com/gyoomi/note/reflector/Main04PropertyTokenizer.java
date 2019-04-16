/**
 * Copyright © 2019, LeonKeh
 * <p>
 * All Rights Reserved.
 */

package com.gyoomi.note.reflector;

import org.apache.ibatis.reflection.property.PropertyTokenizer;

/**
 * PropertyTokenizer工具：通常用来解析order[0].item[0].name的这样的表达式
 *
 * @author Leon
 * @version 2019/4/16 9:56
 */
public class Main04PropertyTokenizer {

    public static void main(String[] args) {
        String fullName= "order[0].item[0].name";
        PropertyTokenizer propertyTokenizer = new PropertyTokenizer(fullName);
        System.out.println(propertyTokenizer);
    }
}

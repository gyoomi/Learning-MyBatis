/**
 * Copyright © 2019, LeonKeh
 * <p>
 * All Rights Reserved.
 */

package com.gyoomi.note.reflector;

import org.apache.ibatis.reflection.property.PropertyNamer;

/**
 * PropertyNamer：
 *     静态方法，进行完成呢方法名到属性名的转换。
 *     及其一些其他的转换。
 *
 * @author Leon
 * @version 2019/4/16 10:02
 */
public class Main05PropertyNamer {

    public static void main(String[] args) throws Exception {
        String methodGet = "getName";
        String s = PropertyNamer.methodToProperty(methodGet);
        System.out.println(s);
    }
}

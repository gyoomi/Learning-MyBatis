package com.gyoomi.note.binding;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.reflection.ParamNameResolver;
import org.apache.ibatis.session.Configuration;

import java.lang.reflect.Method;

/**
 * 类功能描述
 *
 * @author Leon
 * @version 2019/4/21 14:21
 */
public class Main02ParamNameResolver {

    /**
     *
     * <li>aMethod(@Param("M") int a, @Param("N") int b) -&gt; {{0, "M"}, {1, "N"}}</li>
     * <li>aMethod(int a, int b) -&gt; {{0, "0"}, {1, "1"}}</li>
     * <li>aMethod(int a, RowBounds rb, int b) -&gt; {{0, "0"}, {2, "1"}}</li>
     *
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        Class<?> clazz = Class.forName("com.gyoomi.note.binding.Main02ParamNameResolver");
        Method[] methods = clazz.getDeclaredMethods();
        // main
        ParamNameResolver paramNameResolver1 = new ParamNameResolver(new Configuration(), methods[0]);
        // testMethod
        ParamNameResolver paramNameResolver2 = new ParamNameResolver(new Configuration(), methods[1]);
        Object namedParams1 = paramNameResolver1.getNamedParams(new Object[]{new String[]{}});
        Object namedParams = paramNameResolver2.getNamedParams(new Object[]{1, "teststr", "testbbbb"});
        System.out.println(paramNameResolver1);
    }

    public Object testMethod(int a, String str, @Param("p3") String bb) {
        System.out.println("111111111111111");
        return new Object();
    }
}

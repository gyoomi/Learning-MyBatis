package com.gyoomi.note.io;

import org.apache.ibatis.io.Resources;

import java.nio.charset.Charset;

/**
 * 其实是对ClassLoader对象的包装，使用类加载器来完成一些资源加载的工作。
 * 然后Resources类是对ClassLoaderWrapper类的进一步封装。其实就是提供了一些静态方法的工具类而已。
 *
 *
 * @author Leon
 * @version 2019/4/18 23:29
 */
public class Main01ClassLoaderWrapper {

    public static void main(String[] args) throws Exception {
        Resources.setCharset(Charset.defaultCharset());
        Charset charset = Resources.getCharset();
        System.out.println(charset);
    }
}

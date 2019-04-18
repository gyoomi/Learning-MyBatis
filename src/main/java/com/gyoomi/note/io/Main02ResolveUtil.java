package com.gyoomi.note.io;

import com.gyoomi.entity.User;
import org.apache.ibatis.io.ResolverUtil;

/**
 * ResolverUtil工具类的使用
 *     可以根据指定的条件，查询指定包下的类。其实的条件都是接口Test的子类来表示的。也可以自定义条件。
 *     默认使用的当前线程上下文的类加载器。可以自定义指定修改。
 *
 *
 * @author Leon
 * @version 2019/4/18 23:37
 */
public class Main02ResolveUtil {

    public static void main(String[] args) throws Exception {
        ResolverUtil<User> userResolverUtil = new ResolverUtil<>();
        userResolverUtil.findImplementations(User.class, "pack1");
        userResolverUtil.find(new ResolverUtil.Test() {
            @Override
            public boolean matches(Class<?> type) {
                return false;
            }
        }, "test1");
    }
}

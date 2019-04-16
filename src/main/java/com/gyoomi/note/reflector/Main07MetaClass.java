/**
 * Copyright © 2019, LeonKeh
 * <p>
 * All Rights Reserved.
 */

package com.gyoomi.note.reflector;

import org.apache.ibatis.reflection.DefaultReflectorFactory;
import org.apache.ibatis.reflection.MetaClass;

/**
 * MetaClass：Reflector和PropertyTokenizer的组合使用，主要完成对复杂属性表达式的解析及获取指定熟悉的详细信息
 *
 * @author Leon
 * @version 2019/4/16 10:46
 */
public class Main07MetaClass {

    public static void main(String[] args) throws Exception {
        MetaClass metaClass = MetaClass.forClass(User.class, new DefaultReflectorFactory());
        boolean b = metaClass.hasGetter("order.id");
        boolean bb = metaClass.hasGetter("order.name");
        System.out.println(b);
        // true
        System.out.println(bb);
        // false
    }

    static class User {
        private int id;
        private String name;
        private int age;
        private Order order;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public Order getOrder() {
            return order;
        }

        public void setOrder(Order order) {
            this.order = order;
        }
    }

    static class Order {
        private int id;
        private String orderName;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getOrderName() {
            return orderName;
        }

        public void setOrderName(String orderName) {
            this.orderName = orderName;
        }
    }
}




























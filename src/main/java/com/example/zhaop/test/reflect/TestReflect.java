package com.example.zhaop.test.reflect;

import com.example.zhaop.test.controller.TestController;

public class TestReflect extends TestController {

    static int num = 1;

    static {
        System.out.println("Base -- >> " + num);
    }

    public static void main(String[] args) {

        try {
            // 获取类的完整路径
            String clazz1 = TestReflect.class.getName();
            System.out.println("---getName--->>> " + clazz1);

            Package packagea = TestReflect.class.getPackage();
            System.out.println("---package--->>> " + packagea.toString());

            String simpleName = TestReflect.class.getSimpleName();
            System.out.println("---simpleName--->>> " + simpleName);

            Class cc = TestReflect.class.getSuperclass();
            System.out.println("---Class--->>> " + cc);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

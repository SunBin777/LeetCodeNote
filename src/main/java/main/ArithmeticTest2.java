package main;

import java.io.IOException;
import java.io.InputStream;

/**
 * Create by 孙斌 on 2019/11/8.
 */
public class ArithmeticTest2 {

    public static void main(String[] args) {
        //不用lambda表达式的匿名类编写方式
        Runnable runnable1 = new Runnable() {
            @Override
            public void run() {

            }
        };

        //lambda匿名类编写方式
        //lambda表达式    (参数列表)->{方法体}
        Runnable runnable =() ->{

        };
        new Thread(runnable).start();

        //更加简单的lambda表达式  可以通过()->选择接口并且实现
        new Thread(() -> {
            System.out.println();
        }).start();

        //更加简单的lambda表达式  可以通过()->选择接口并且实现
        // 左边是类名 ::  右边是具体的静态方法
        new Thread(System.out :: println).start();
    }
}

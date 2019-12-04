package java8Character;

/**
 * Create by 孙斌 on 2019/11/12.
 */

/**
 * 函数是编程
 */
@FunctionalInterface
public interface TestInterFace {

    /**
     *  1.8之后可以编写函数式编程
     *  当被@FunctionalInterface修饰之后只能有一个抽象方法
     *  除了被default和static修饰过的拥有方法体的参数   包含Object中所有的抽象方法都可以重写
     * @param name
     * @param name1
     */
    void asd(String name, String name1);
    //void asd1(String name, String name1);

    boolean equals(Object o);

    /**
     * 测试1.8之后的新特性
     *
     * default关键字修饰的可以被子类重写
     * 子类可以不被实现，不被实现被调用的情况下调用本方法
     *
     * static关键字不可以被子类重写
     *
     *
     *
     * @param name
     * @return
     */
    default String defaultAasd(String name){
        return name + ":测试";
    }

    static String staticAasd(String name){
        return name + ":测试";
    }
}

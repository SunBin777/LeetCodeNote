package main;

/**
 * Create by 孙斌 on 2019/11/5.
 */
public class ArithmeticTest1 {

    public static void main(String[] args){
        System.out.println("&");
        System.out.println(2 & 2);
        System.out.println(2 & 3); //0010   0011    0010
        System.out.println(2 & 11);//0010   1011    0010
        System.out.println(11 & 3);//1011   0011    0011

        System.out.println();

        System.out.println("&=");
        System.out.println(2==1 & 1==2);
        System.out.println(2==2 & 3==3);
        System.out.println(2==12 & 12==11);
        System.out.println(2==2 & 12==11);
        System.out.println(2==12 & 12==12);

        System.out.println();

        System.out.println("|");
        System.out.println(2 | 2);
        System.out.println(2 | 3); // 0010 0011 0011
        System.out.println(2 | 11);// 1010 1011 1011
        System.out.println(11 | 2);// 1011 0010 1011
        System.out.println(3 | 3); // 0011 0011 0011

        System.out.println();

        System.out.println("|=");
        System.out.println(2==1 | 1==2);
        System.out.println(2==2 | 3==3);
        System.out.println(2==12 | 12==11);
        System.out.println(12==12 | 12==11);
        System.out.println(2==12 | 12==12);

        System.out.println();


        System.out.println("^");
        System.out.println(2 ^ 2); //0010  0010  0000
        System.out.println(2 ^ 3); //0010  0011  0001
        System.out.println(2 ^ 11);//0010  1011  1001
        System.out.println(11 ^ 2);//1011  0010  1001

        System.out.println();

        System.out.println("^=");
        System.out.println(2==1 ^ 1==2);
        System.out.println(2==2 ^ 3==3);
        System.out.println(2==12 ^ 12==11);
        System.out.println(12==12 ^ 12==12);

    }
}

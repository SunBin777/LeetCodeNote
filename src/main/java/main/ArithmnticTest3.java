package main;

/**
 * Create by 孙斌 on 2019/11/14.
 */
public class ArithmnticTest3 {

    public static void main(String[] args) {
        ArithmnticTest3 arithmnticTest3 = new ArithmnticTest3();
        StringBuilder sb = new StringBuilder();
        sb.append("123");
        System.out.println(sb);
        arithmnticTest3.asd(sb);
        System.out.println(sb);
    }

    public void asd(StringBuilder sb){
        System.out.println(sb);
        sb.append("456");
        System.out.println(sb);
    }
}

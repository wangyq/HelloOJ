package com.siwind.interview;

/**
 * Created by wang on 2015/4/24.
 *
 描述
 A string s is LUCKY if and only if the number of different characters in s is a fibonacci number. Given a string consisting of only lower case letters, output all its lucky non-empty substrings in lexicographical order. Same substrings should be printed once.

 输入
 A string consisting no more than 100 lower case letters.

 输出
 Output the lucky substrings in lexicographical order, one per line. Same substrings should be printed once.

 样例输入
 aabcd
 样例输出
 a
 aa
 aab
 aabc
 ab
 abc
 b
 bc
 bcd
 c
 cd
 d

 */
public class FibString {

    public static void doLuckString(String str){
        int i=0,j=0,k=0;
        int fib1=1,fib2=1;
        int difnum = 0;

        //int num[] = new int[str.length()]; //number of different characters!

        //num[0] = 1;

        while (i<str.length()) {
            j = i;  //start from location of i.

            while (j < str.length()) {
                if (i == j) {
                    //num[j] = 1;
                    difnum = 1;
                    fib1 = 1;
                    fib2 = 2;
                } else {
                    for (k = i; k < j; k++) {//
                        if (str.charAt(k) == str.charAt(j)) {
                            break;
                        }
                    }//end of different
                    if (k >= j) {
                        difnum++;

                        if( difnum > fib1 ){
                            int tmp = fib1;
                            fib1 = fib2;
                            fib2 = tmp + fib1;
                        }
                    }
                }//end of update num
                if (difnum == fib1 ) {

                    String substr = str.substring(i, j + 1);
                    String str1 = str.substring(0,j);
                    if( !str1.contains(substr)) {
                        System.out.println(substr);
                    }
                }
                j++; //move to next character!
            }//end of while
            i++;
        };

    }

    public static void test(){
        String str = "aabcdefbedgcdg";//aabcd,
        doLuckString(str);
    }
    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        test();
    }
}

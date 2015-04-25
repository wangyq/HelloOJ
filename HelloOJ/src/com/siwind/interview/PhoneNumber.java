package com.siwind.interview;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

/**
 * Created by wang on 2015/4/24.

 描述
 The numberic keypad on your mobile phone looks like below:

 1 2 3
 4 5 6
 7 8 9
   0
 Suppose you are holding your mobile phone with single hand. Your thumb points at digit 1. Each time you can 1) press the digit your thumb pointing at, 2) move your thumb right, 3) move your thumb down. Moving your thumb left or up is not allowed.

 By using the numeric keypad under above constrains, you can produce some numbers like 177 or 480 while producing other numbers like 590 or 52 is impossible.

 Given a number K, find out the maximum number less than or equal to K that can be produced.

 输入
 The first line contains an integer T, the number of testcases.

 Each testcase occupies a single line with an integer K.



 For 50% of the data, 1 <= K <= 999.

 For 100% of the data, 1 <= K <= 10500, t <= 20.

 输出
 For each testcase output one line, the maximum number less than or equal to the corresponding K that can be produced.

 样例输入
 3
 25
 83
 131
 样例输出
 25
 80
 129

 */
public class PhoneNumber {

    static int[][] location = new int[][]{{3,1},{0,0},{0,1},{0,2},{1,0},{1,1},{1,2},{2,0},{2,1},{2,2}};
//    static  int[][] validNum = new int[][]{
//            {10,11,12,13,14,15,16,17,18,19},
//            {20,22,23,25,26,28,29},
//            {33,36,39},
//            {40,44,45,46,47,48,49},
//            {50,55,56,58,59},
//            {66,69},
//            {70,78,79},
//            {80,88,89},
//            {99}
//    };

    public static boolean isValid(int a, int b){ // is a <= b ?
        boolean bOK = false;
        bOK = (location[a][0] <= location[b][0]) && (location[a][1]<=location[b][1]);

        return bOK;
    }

    public static int getClosestNum(int first,int next){ //here location of first > loation of next

        int v = 0;
        if( first==3 || first==6 || first==9){
            v = (first-1)*10 + 9;
        }
        else{
            v = first*10;
        }
        return v;
//        int max = first*10 + next;
//        int i;
//        boolean bFind = false;
//
//        do{
//            for(i=validNum[first-1].length-1;i>=0;i--){
//                if( validNum[first-1][i]<=max){
//                    bFind = true;
//                    break;
//                }
//            }
//            if( !bFind ){
//                first--;
//            }
//        }while (!bFind);
//        return validNum[first-1][i];
    }
    public static int findMaxNum(int num){
        int base = num;
        int first, next;
        Stack<Integer> st = new Stack<Integer>();

        if( num <= 20 ){
            return num;
        }

        while (base>0){ //
            st.push(base%10);
            base /=10;
        }

        next = st.pop();
        base = 0;

        do{
            first = next;
            next = st.pop();

            if( isValid(first,next) ){
                base = base * 10 + first; //update base!
                if( st.isEmpty()){
                    base = base*10 + next;
                }
            }
           else{//we must find a valid value!
                int v = getClosestNum(first,next);
                first = v/10;
                next = v%10;
                base = base*10 + first;
                base = base*10 + next;
                //if( next>0 ) next = 9; //here no need now!
                if (st.size()>0){
                    for(int i=0;i<st.size();i++) {
                        base = base * 10 + next;
                    }
                    st.clear();
                }
            }

        }while(!st.isEmpty());


        return base;
    }

    public static  void test(){
        int n = 1458423;//1458423
        int v = findMaxNum(n);
        System.out.println(v);
    }

    public  static  void input(){//
        Scanner sc = new Scanner(System.in);
        int cases = sc.nextInt();
        while(cases>0){
            cases--;
            int n = sc.nextInt();

            System.out.println(findMaxNum(n));

        }
    }

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        test();
    }
}

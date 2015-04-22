package com.siwind.interview;

import java.util.Scanner;

/**
 * Created by wang on 2015/4/21.
 */
public class StorageCenter {

    static int m, n;
    static int matric[][] = null;

    static int m_m[] = null;
    static int m_n[] = null;

    /**
     * M N
     * x x x ... (number of N integer, each is a cost number)
     * ...
     * x x x ... (last M lines )
     *
     * where:
     *   0< M <= 500, 0< N<=500, and cost number is  0<= C <= 500000
     *
     *
     =====================
     1 1
     6

     Answer: 0 0
     ==============
     2 3
     0 5 1
     2 0 0

     A: 0 1
     ================
     4 6
     1 0 5 2 3 1
     2 3 0 3 1 4
     3 0 1 4 2 2
     4 2 0 2 1 3

     A: 1 3

     ================
     5 9
     1 0 5 2 3 1 2 0 3
     2 3 0 3 1 4 1 3 2
     3 0 1 4 2 2 0 2 5
     4 2 0 2 1 3 2 4 1
     3 2 1 2 1 0 2 4 1

     A: 2 4

     */
    public static void input(){

        Scanner sc = new Scanner(System.in);
        m = sc.nextInt();
        n = sc.nextInt();

        m_m = new int[m];
        m_n = new int[n];
        matric = new int[m][n];

        for(int k=0;k<m;k++ ) m_m[k] = 0;
        for(int k=0;k<n;k++ ) m_n[k] = 0;

        for(int i=0;i<m;i++){ //for m lines
            for(int j=0;j<n;j++){ //for n columns
                int c = sc.nextInt();  //read a cost.
                m_m[i] += c;
                m_n[j] += c;
                matric[i][j] = c;

            }
        }
    }

    /**
     * find a optimal location for costs point.
     * @param cost
     * @return
     */
    public static int findOptLocation(int cost[]){
        int len = cost.length;
        int loc = 0;

        int delta_left = 0, delta_right = 0;

        for(int i=1;i<len;i++){//initial value!
            delta_right += cost[i];
        }

        while( loc<len ){

            //should we go right for one step?
            if( delta_left + cost[loc] > delta_right ){
                break;
            }

            delta_left += cost[loc];
            loc++;  //go right
            delta_right -= cost[loc];
        }

        return loc;
    }


    public static void SolutionOptLocation(){
        int line = findOptLocation(m_m);
        int column = findOptLocation(m_n);

        System.out.println(line+" " + column);
    }

    public static int getCostInXY(int x, int y){
        int cost = 0;
        int dist = 0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                dist = Math.abs(x-i) + Math.abs(y-j);
                cost += dist*matric[i][j];
            }
        }
        return cost;
    }
    /**
     * Brute force to find the answer!
     */
    public static void SolutionOptLocationBruteForce(){
        int cost[][]=new int[m][n];
        int min = getCostInXY(0,0);
        int x=0,y=0;

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                cost[i][j] = getCostInXY(i,j);  //find all cost in every one place!
                if( min > cost[i][j]){
                    min = cost[i][j];
                    x = i;
                    y = j;
                }
            }
        }

        System.out.println("Location is: " + x + " " + y);
        System.out.println("Costs is: ");
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                System.out.print(cost[i][j]+" ");
            }
            System.out.println();
        }
    }

    public static void testoneline(){
        //int cost[] = {3,1,2,3,2};
        //int cost[] = {2,3,2,1,3};
        int cost[] = {1,2,4};

        int loc = findOptLocation(cost);
        System.out.println(loc);

    }
    public static void test(){
        //testoneline();
        input();
        SolutionOptLocation();
        SolutionOptLocationBruteForce();
    }

    /**
     *
     * @param args
     */
    public static void main(String[] args) {

        test();
    }
}

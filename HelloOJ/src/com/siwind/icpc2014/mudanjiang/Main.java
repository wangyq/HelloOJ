/**
 * 
 */
package com.siwind.icpc2014.mudanjiang;

import java.util.Scanner;

/**
 * @author wang
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int numCases = in.nextInt();
		for( int i=0;i<numCases;i++){
			testcase(in);
		}
	}

	/**
	 * 
	 * @param in
	 */
	public static void testcase(Scanner in){
		//first line!
		int n, m, A=0, B=0, k;
		int min,max;
		
		n = in.nextInt();
		m = in.nextInt();
		
		for(k=0;k<n-1;k++){
			A += in.nextInt();  //first total score
		}
		
		for(k=0;k<m;k++){
			B += in.nextInt();  //first total score
		}
		
		min = (int) Math.ceil((B+1.0)/m);
		max = (int) Math.floor((A-1.0)/(n-1)) ;
		//System.out.println("A=" + A + ", B="+B);
		System.out.println(min + " " + max);
	}
}

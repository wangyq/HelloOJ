package com.siwind.algorithm;

import java.io.File;
import java.util.Scanner;

//public class Main {
public class SearchDimesion {

	public static void printMatrix(int n, int[][] data){
		int i,j;
		System.out.println("n="+n);
		for(i=0;i<n;i++){
			for(j=0;j<n;j++){
				System.out.print(data[i][j]+ " " );
			}
			System.out.println();
		}
	}
	/**
	 * 
	 */
	public static void runCase(){
		int i,j,x=0,n=0;
		int[][] data = null;
		try {
			//Scanner in = new Scanner(System.in);
			Scanner in = new Scanner(new File("searchdimesion.txt"));
			
			x = in.nextInt();
			n = in.nextInt();
			data = new int[n][n];
			
			for(i=0;i<n;i++){
				for(j=0;j<n;j++){
					data[i][j] = in.nextInt(); 
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		}finally{
			
		}
	
		printMatrix(n, data);
		
		//begin search now!
		i=0;j=n-1;
		
		while(i<n && j>=0 ){
			if( x > data[i][j] ) i++;
			else if( x < data[i][j]) j--;
			else {
				System.out.println("Found: "+ i + " " + j);
				i++;
			}
		}
		/*
		while(true){
			//search for i direction
			while( (x > data[i][j]) && i<n ) i++;

			if( i<n &&x == data[i][j] ){
					System.out.println("Found: "+ i + " " + j);
					i++;  //for the following to adjust range!!
			}
			
			if( i>= n ) break;
			
			//search for j direction
			while( j>=0 && data[i][j]>x ) j--;
			if( j>=0 && data[i][j]== x ){
				System.out.println("Found: "+ i + " " + j);
				j--;  //for the following to adjust range!!
			}
			if( j<0 ) break;

		}
		*/
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		runCase();
	}

}

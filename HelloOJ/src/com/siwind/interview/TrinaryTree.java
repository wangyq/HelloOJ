package com.siwind.interview;

public class TrinaryTree {

	/**
	 *         0
	 *       3      2       1
	 *     4 5 6  7 8 9  10 11 12             
	 */
	//static double log3=Math.log(3);
	
	/**
	 * get the level of node n. level is begin from 0,1,...
	 * 
	 * @param n
	 * @return
	 */
	static int getLevel(int n){
		int l = 0;
		while(n>0){
			n = (n-1)/3;
			l++;
		}
		return l;
	}
	
	static int exchange(int n){
		int sum = 0;
		int l = getLevel(n);
		
		sum = 1;
		for(int i=1;i<=l;i++){
			sum *= 3;
		}
		sum = 2*sum -2;
		return sum - n;
	}
	
	
//	static int exchange(int n){
//		int level = (int)((Math.log(2*n+1)/log3)-1.0);
//		int sum = 1;
//		
//		level += 1;
//		for(int i=1;i<=level;i++){
//			sum *= 3;
//		}
//		sum = 2*sum - 2;
//		
//		return sum - n;
//	}

	static int parent(int n){
		int p = (n-1)/3;
		return exchange(p);
	}
	
	static int comm_parent(int n, int m){
		if( n>m ){//make sure n <= m
			int t = n;
			n = m;
			m = t;
		}
		if( n == m ) return n;
		return comm_parent(n, parent(m));
	}
	
	static void test_common_parent(int n, int m){
		
		int p = comm_parent(n,m);
		System.out.println(p);
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		test_common_parent(13,15);
	}

}

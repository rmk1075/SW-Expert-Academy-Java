package coding_test.java.SWExpertAcademy.problem3752;

import java.util.ArrayList;
import java.util.Scanner;

public class Solution {

	ArrayList<Integer> scores = new ArrayList();
	
	public static void main(String[] args) {
		/*
		 * find the number of possible cases with a score that students can get
		 * N: number of problems
		 * -> each problem has allocated point
		 */
	
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int i = 0; i < T; i++) {
			run(sc, i);
		}
		
	}
	
	public static void run(Scanner sc, int testCase) {
		int N = sc.nextInt();
		int arr[] = new int[N];
		
		for(int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		
		for(int i = 1; i < N; i++) {
			//find(arr, i);
		}
		
		//arraylist <- put in the sum value of each case / compare with the .contain(...)
		//finally take the length of arraylist
	}
	
	//this method should be changed as void type and append the value to the arraylist point when if the list being class variable
	public static void find(int[] arr, int i) {
		if(i == 0) return;
		
		return ;
	}
}
package coding_test.java.SWExpertAcademy.problem1849;

import java.util.Scanner;

public class Solution {

	static int T; // T: test case 偃熱
	static int N, M; // N: 價Ы 偃熱, M: 橾曖 識 偃熱
	static Integer[][] n;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		T = sc.nextInt();
		for(int i = 0; i < T; i++) {
			N = sc.nextInt();
			M = sc.nextInt();
			
			System.out.print("#" + (i+1));
			n = new Integer[N][N];
			for(int m = 0; m < M; m++) {
				String c = sc.next();
				int a = sc.nextInt();
				int b = sc.nextInt();
				
				if(c == "!") {
					//!
					n[a][b] = sc.nextInt();
					n[b][a] = -(n[a][b]); 
				} else if(c == "?") {
					//?
					int[] visit = new int[N];
					Integer ans = find(a, b, visit);
					System.out.print(" " + ans);
				}
			}
			System.out.println();
		}
	}
	
	public static Integer find(int a, int b, int[] visit) {
		if(n[a][b] != null) return n[a][b];
		if(visit[a] == 1) return null;

		Integer ans = 0;
		visit[a] = 1;
		for(int i = 0; i < n.length; i++) {
			if(visit[i] == 0 && n[a][i] != null) {
				Integer temp = find(i, b, visit);
				if(temp != null) ans = n[a][i] + temp;
				visit[i] = 0;
			}
		}
		if(ans == 0) return null;
		
		return ans;
	}
}
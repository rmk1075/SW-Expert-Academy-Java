package coding_test.java.SWExpertAcademy.problem1247;

import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
	
	static int T;
	static int N;
	static int distance;
	static int[] start;
	static int[] destination;
	static int[] visit;
	static ArrayList<Integer> x;
	static ArrayList<Integer> y;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		T = sc.nextInt();
		for(int i = 1; i <= T; i++) {
			distance = 10000;
			N = sc.nextInt();
			x = new ArrayList<Integer>();
			y = new ArrayList<Integer>();
			start = new int[2];
			destination = new int[2];
			
			start[0] = sc.nextInt();
			start[1] = sc.nextInt();
			destination[0] = sc.nextInt();
			destination[1] = sc.nextInt();
			for(int n = 0; n < N; n++) {
				x.add(sc.nextInt());
				y.add(sc.nextInt());
			}
			
			for(int n = 0; n < N; n++) {
				visit = new int[N];
				int dis = calculateDistance(x.get(n), start[0], y.get(n), start[1]);
				dfs(n, dis, 1);
			}
			
			System.out.println("#" + i + " " + distance);
		}
	}

	public static void dfs(int i, int dis, int count) {
		System.out.println(x.get(i) + " " + y.get(i));
		
		if(visit[i] == 2) return;
		
		visit[i] = 1;		
		if(count == N) {
			int ans = dis + calculateDistance(x.get(i), destination[0], y.get(i), destination[1]);
			if(ans < distance) distance = ans;
			visit[i] = 1;
			return ;
		}
		
		for(int j = 0; j < x.size(); j++) {
			if(visit[j] == 0) {
				dfs(j, dis+calculateDistance(x.get(i), x.get(j), y.get(i), y.get(j)), count+1);
			}
		}
		visit[i] = 2;
		
		return ;
	}
	
	public static int calculateDistance(int x1, int x2, int y1, int y2) {
		return Math.abs(x1 - x2) + Math.abs(y1 -y2);
	}
}

package coding_test.java.SWExpertAcademy.problem1849;

import java.util.ArrayList;
import java.util.Scanner;

public class Solution {

	static int T; // T: test case 개수
	static int N, M; // N: 샘플 개수, M: 일의 총 개수
	static Integer[][] n;
	static ArrayList<Integer> list;
	static int[] visit;
	static boolean check = false;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		T = sc.nextInt();
		for(int i = 0; i < T; i++) {
			N = sc.nextInt();
			M = sc.nextInt();
			
			System.out.print("#" + (i+1));
			n = new Integer[N][N];
            list = new ArrayList(N);
			for(int m = 0; m < M; m++) {
				String c = sc.next();
				int a = sc.nextInt();
				int b = sc.nextInt();
				
				int x, y;
				if(!list.contains(a)) {
					list.add(a);
				}
				x = list.indexOf(a);

				if(!list.contains(b)) {
					list.add(b);
				}
				y = list.indexOf(b);
                
				if(c.equals("!")) {
					//!
					n[x][y] = sc.nextInt();
					n[y][x] = -(n[x][y]);
					
					//입력된 값에 대해서 전체 행렬에 연산을 진행하도록 한다
					for(int l = 0; l < n.length; l++) {
						if(n[l][x] != null && n[l][y] == null) {
							n[l][y] = n[l][x] + n[x][y];
							n[y][l] = -n[l][y];
						}
					}
				} else if(c.equals("?")) {
					//?
					visit = new int[N];
					Integer ans = find(x, y, visit);
					if(ans == null) {
						System.out.print(" UNKNOWN");
					} else {
						System.out.print(" " + ans);
					}
					check = false;
                }
			}
			System.out.println();
		}
		
		sc.close();
	}
	
	public static Integer find(int a, int b, int[] visit) {
		if(visit[a] == 1) return null;
		if(a == b) return 0;
		if(n[a][b] != null) {
			check = true;
			return n[a][b];
		}

		visit[a] = 1;
		Integer ans = 0;
		for(int i = 0; i < n.length; i++) {
			if(visit[i] == 0 && n[a][i] != null) {
				Integer temp = find(i, b, visit);
				if(temp != null) ans = n[a][i] + temp;
				visit[i] = 0;
			}
			
			if(check == true) break;
		}
		if(ans == 0) return null;
		
		return ans;
	}
}
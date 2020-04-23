import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int T, N, L, ing[][] = new int[21][2], dp[][] = new int[21][10001];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			for(int i = 1; i <= N; i++) {
				st = new StringTokenizer(br.readLine());
				ing[i][0] = Integer.parseInt(st.nextToken());
				ing[i][1] = Integer.parseInt(st.nextToken());
				for(int j = 1; j <= L; j++) dp[i][j] = 0;
			}

			for(int i = 1; i <= N; i++) {
				for(int j = 1; j <= L; j++) {
					if(j < ing[i][1]) dp[i][j] = dp[i-1][j];
					else dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-ing[i][1]] + ing[i][0]);
				}
			}

			sb.append("#" + t + " " + dp[N][L] + "\n");
		}
		System.out.println(sb);
	}
}

// import java.util.Scanner;

// class Solution {
// 	static int T, N, L, maxPoint; // N: number of ingredients, L: limit calories
// 	static int[] visited;
// 	static int[][] ingredients;
// 	public static void main(String args[]) throws Exception {
// 		Scanner sc = new Scanner(System.in);
// 		T = sc.nextInt();
		
// 		for(int t = 0; t < T; t++) {
// 			maxPoint = 0;
// 			N = sc.nextInt();
// 			L = sc.nextInt();
// 			ingredients = new int[N][2]; // 0: points, 1: calories
// 			visited = new int[N];

// 			for(int i = 0; i < N; i++) {
// 				ingredients[i][0] = sc.nextInt();
// 				ingredients[i][1] = sc.nextInt();
// 			}

// 			find(0, 0, 0);

// 			System.out.printf("#%d %d\n", t+1, maxPoint);
// 		}

// 		sc.close();
// 	}

// 	public static void find(int point, int cal, int index) {
// 		if(L < cal) return;

// 		if(index == N) {
// 			maxPoint = Math.max(maxPoint, point);
// 			return ;
// 		} 

// 		find(point+ingredients[index][0], cal+ingredients[index][1], index+1);
// 		find(point, cal, index+1);
// 	}
// }
/////////////////////////////////////////////

/////////////////////////////////////////////
// import java.util.Scanner;

// class Solution {
// 	static int T, N, L, maxPoint; // N: number of ingredients, L: limit calories
// 	static int[] visited;
// 	static int[][] ingredients;
// 	public static void main(String args[]) throws Exception {
// 		Scanner sc = new Scanner(System.in);
// 		T = sc.nextInt();
		
// 		for(int t = 0; t < T; t++) {
// 			maxPoint = 0;
// 			N = sc.nextInt();
// 			L = sc.nextInt();
// 			ingredients = new int[N][2]; // 0: points, 1: calories
// 			visited = new int[N];

// 			for(int i = 0; i < N; i++) {
// 				ingredients[i][0] = sc.nextInt();
// 				ingredients[i][1] = sc.nextInt();
// 			}

// 			find(0, 0, 0);

// 			// for(int i = 0; i < N; i++) {
// 			// 	visited[i] = 1;
// 			// 	find(ingredients[i][0], ingredients[i][1], i);
// 			// 	visited[i] = 0;
// 			// }

// 			System.out.printf("#%d %d", t+1, maxPoint);
// 		}

// 		sc.close();
// 	}

// 	public static void find(int point, int cal, int index) {
// 		if(L < cal) return;

// 		if(index == N) {
// 			maxPoint = Math.max(maxPoint, point);
// 			return ;
// 		} 

// 		find(point+ingredients[index][0], cal+ingredients[index][1], index+1);
// 		find(point, cal, index+1);

// 		// for(int i = 0; i < N; i++) {
// 		// 	if(visited[i] == 0) {
// 		// 		visited[i] = 1;
// 		// 		find(point + ingredients[i][0], cal + ingredients[i][1], i);
// 		// 		visited[i] = 0;
// 		// 	}
// 		// }
// 	}
// }
//////////////////////////////////////

////////////////////////////////////
// import java.util.Scanner;

// class Solution {
// 	static int T, N, L, maxPoint; // N: number of ingredients, L: limit calories
// 	// static int[] visited;
// 	static int[][] ingredients;
// 	public static void main(String args[]) throws Exception {
// 		Scanner sc = new Scanner(System.in);
// 		T = sc.nextInt();
		
// 		for(int t = 0; t < T; t++) {
// 			maxPoint = 0;
// 			N = sc.nextInt();
// 			L = sc.nextInt();
// 			ingredients = new int[N][2]; // 0: points, 1: calories
// 			// visited = new int[N];

// 			for(int i = 0; i < N; i++) {
// 				ingredients[i][0] = sc.nextInt();
// 				ingredients[i][1] = sc.nextInt();
// 			}

// 			for(int i = 0; i < N; i++) {
// 				find(ingredients[i][0], ingredients[i][1], i);
// 				// System.out.println();
// 			}

// 			System.out.printf("#%d %d", t+1, maxPoint);
// 		}

// 		sc.close();
// 	}

// 	public static void find(int point, int cal, int index) {
// 		// System.out.print(index + "\t" + point + "\n");
// 		maxPoint = Math.max(maxPoint, point);

// 		for(int i = index+1; i < N; i++) {
// 			if(cal + ingredients[i][1] <= L) {
// 				find(point + ingredients[i][0], cal + ingredients[i][1], i);
// 			}
// 			// if(visited[i] == 0 && cal + ingredients[i][1] <= L) {
// 			// 	visited[i] = 1;
// 			// 	find(point + ingredients[i][0], cal + ingredients[i][1], i);
// 			// 	visited[i] = 0;
// 			// }
// 		}
// 	}
// }
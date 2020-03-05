import java.util.Scanner;

public class Solution {
    static int T, N, M, ans;
    static int[][] graph;
    static boolean[] visit;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        T = sc.nextInt();
        for(int t = 1; t <= T; t++) {
            ans = Integer.MAX_VALUE;
            N = sc.nextInt();
            M = sc.nextInt();

            // 1 ~ N
            graph = new int[N+1][N+1];
            for(int i = 0; i < M; i++) graph[sc.nextInt()][sc.nextInt()] = sc.nextInt();

            for(int i = 1; i <= N; i++) {                
                visit = new boolean[N+1];
                dfs(i, i, 0);
            }

            sb.append("#" + t + " " + ((ans == Integer.MAX_VALUE) ? -1 : ans) + "\n");
        }

        sc.close();
        System.out.println(sb.toString());
    }

    public static void dfs(int current, int dest, int distance) {
        if(current == dest && visit[current]) {
            ans = Math.min(ans, distance);
            return ;
        }

        if(visit[current] || ans <= distance) return ;

        visit[current] = true;
        for(int i = 1; i <= N; i++) {
            if(graph[current][i] == 0) continue;
            dfs(i, dest, distance + graph[current][i]);
        }
    }
}

// import java.util.LinkedList;
// import java.util.Queue;
// import java.util.Scanner;

// class Node {
//     int idx, length;

//     Node(int idx, int length) {
//         this.idx = idx;
//         this.length = length;
//     }
// }

// public class Solution {
//     static int T, N, M;
//     static int[][] graph;
//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);
//         StringBuilder sb = new StringBuilder();

//         T = sc.nextInt();
//         for(int t = 1; t <= T; t++) {
//             N = sc.nextInt();
//             M = sc.nextInt();

//             graph = new int[N][N];
//             for(int i = 0; i < M; i++) graph[sc.nextInt()-1][sc.nextInt()-1] = sc.nextInt();

//             int minLength = Integer.MAX_VALUE;
//             Queue<Node> nodes = new LinkedList<>();
//             for(int n = 0; n < N; n++) {
//                 nodes.clear();
//                 nodes.offer(new Node(n, 0));

//                 int visited = 0;
//                 visited |= (1 << n);

//                 while(!nodes.isEmpty()) {
//                     Node node = nodes.poll();
//                     if(minLength < node.length) continue;

//                     if(graph[node.idx][n] != 0) minLength = Math.min(minLength, node.length + graph[node.idx][n]);

//                     for(int i = 0; i < N; i++) {
//                         if(graph[node.idx][i] != 0 && ((visited & (1 << i)) == 0)) {
//                             visited |= (1 << i);
//                             nodes.offer(new Node(i, node.length + graph[node.idx][i]));
//                         }
//                     }
//                 }
//             }

//             if(minLength == Integer.MAX_VALUE) sb.append("#" + t + " -1\n");
//             else sb.append("#" + t + " " + minLength + "\n");
//         }
//         sc.close();
//         System.out.println(sb.toString());
//     }
// }

// import java.io.BufferedReader;
// import java.io.IOException;
// import java.io.InputStreamReader;
// import java.util.LinkedList;
// import java.util.Queue;
// import java.util.StringTokenizer;

// class Node {
//     int idx, length;

//     Node(int idx, int length) {
//         this.idx = idx;
//         this.length = length;
//     }
// }

// public class Solution {
//     static int T, N, M;
//     static int[][] graph;
//     public static void main(String[] args) throws IOException {
//         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//         StringBuilder sb = new StringBuilder();

//         T = Integer.parseInt(br.readLine().trim());
//         for(int t = 1; t <= T; t++) {
//             StringTokenizer st = new StringTokenizer(br.readLine().trim());
//             N = Integer.parseInt(st.nextToken());
//             M = Integer.parseInt(st.nextToken());

//             graph = new int[N][N];
//             for(int i = 0; i < M; i++) {
//                 st = new StringTokenizer(br.readLine().trim());
//                 graph[Integer.parseInt(st.nextToken())-1][Integer.parseInt(st.nextToken())-1] = Integer.parseInt(st.nextToken());
//             }

//             int minLength = Integer.MAX_VALUE;
//             Queue<Node> nodes = new LinkedList<>();
//             for(int n = 0; n < N; n++) {
//                 nodes.clear();
//                 nodes.offer(new Node(n, 0));

//                 boolean[] visited = new boolean[N];
//                 visited[n] = true;

//                 while(!nodes.isEmpty()) {
//                     Node node = nodes.poll();
//                     if(minLength < node.length) continue;

//                     if(graph[node.idx][n] != 0) minLength = Math.min(minLength, node.length + graph[node.idx][n]);

//                     for(int i = 0; i < N; i++) {
//                         if(graph[node.idx][i] != 0 && !visited[i]) {
//                             visited[i] = true;
//                             nodes.offer(new Node(i, node.length + graph[node.idx][i]));
//                         }
//                     }
//                 }
//             }

//             if(minLength == Integer.MAX_VALUE) sb.append("#" + t + " -1\n");
//             else sb.append("#" + t + " " + minLength + "\n");
//         }

//         System.out.println(sb.toString());
//     }
// }
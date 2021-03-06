import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Edge implements Comparable<Edge> {
    int a, b;
    double len;

    Edge(int a, int b, double len) {
        this.a = a;
        this.b = b;
        this.len = len;
    }

    @Override
    public int compareTo(Edge o) {
        return (this.len < o.len) ? -1 : 1;
    }
}

public class Solution {
    static int T, N, parent[] = new int[1000], map[][] = new int[1000][2];
    static PriorityQueue<Edge> pq = new PriorityQueue<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < N; i++) map[i][0] = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < N; i++) map[i][1] = Integer.parseInt(st.nextToken());
            double E = Double.parseDouble(br.readLine());

            pq.clear();
            for(int i = 0; i < N; i++) {
                parent[i] = i;
                for(int j = i+1; j < N; j++) pq.offer(new Edge(i, j, Math.pow(map[i][0] - map[j][0], 2) + Math.pow(map[i][1] - map[j][1], 2)));
            }

            int cnt = 0;
            double ans = 0;
            while(!pq.isEmpty() && cnt < N-1) {
                Edge edge = pq.poll();

                if(check(edge.a) == check(edge.b)) continue;
                parent[check(edge.b)] = check(edge.a);
                ans += edge.len;
                cnt++;
            }
            sb.append("#" + t + " " + Math.round(ans * E) +"\n");
        }
        System.out.println(sb);
    }

    public static int check(int idx) {
        if(parent[idx] == idx) return idx;
        return parent[idx] = check(parent[idx]);
    }
}


// import java.io.BufferedReader;
// import java.io.IOException;
// import java.io.InputStreamReader;
// import java.util.PriorityQueue;
// import java.util.StringTokenizer;

// class Edge implements Comparable<Edge> {
//     int index1, index2;
//     double l;

//     Edge(int index1, int index2, double l) {
//         this.index1 = index1;
//         this.index2 = index2;
//         this.l = l;
//     }

//     @Override
//     public int compareTo(Edge o) {
//         return (this.l - o.l < 0) ? -1 : 1;
//     }
// }

// public class Solution {
//     static int T, N;
//     static int[][] islands;
//     public static void main(String[] args) throws IOException {
//         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//         StringBuilder sb = new StringBuilder();
//         T = Integer.parseInt(br.readLine());
//         for(int t = 1; t <= T; t++) {
//             N = Integer.parseInt(br.readLine());
//             islands = new int[N][3];
//             for(int i = 0; i < 2; i++) {
//                 StringTokenizer st = new StringTokenizer(br.readLine());
//                 for(int j = 0; j < N; j++) {
//                     islands[j][i] = Integer.parseInt(st.nextToken());
//                 }
//             }
//             double E = Double.parseDouble(br.readLine());
            
//             PriorityQueue<Edge> pq = new PriorityQueue<>();
//             for(int i = 0; i < N; i++) {
//                 islands[i][2] = i;
//                 for(int j = i+1; j < N; j++) pq.offer(new Edge(i, j, Math.pow(islands[i][0] - islands[j][0], 2) + Math.pow(islands[i][1] - islands[j][1], 2)));
//             }

//             double L = 0;
//             while(!pq.isEmpty()) {
//                 if(check()) break;

//                 Edge e = pq.poll();
//                 int index1 = find(e.index1), index2 = find(e.index2);
//                 if(index1 == index2) continue;

//                 islands[index2][2] = index1;
//                 L += e.l;
//             }

//             sb.append("#" + t + " " + Math.round(E * L) + "\n");
//         }

//         System.out.println(sb.toString());
//     }

//     public static boolean check() {
//         int tmp = islands[0][2];
//         for(int i = 1; i < N; i++) {
//             if(islands[i][2] != tmp) return false;
//         }

//         return true;
//     }

//     public static int find(int x) {
//         if(islands[x][2] == x) return x;
//         return islands[x][2] = find(islands[x][2]);
//     }
// }
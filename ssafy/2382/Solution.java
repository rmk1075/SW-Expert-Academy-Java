import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Virus implements Comparable<Virus> {
    int x, y, num, d;
    boolean death = false;

    Virus(int x, int y, int num, int d) {
        this.x = x;
        this.y = y;
        this.num = num;
        this.d = d;
    }

    @Override
    public int compareTo(Virus o) {
        if(this.death && o.death) return 0;
        if(this.death) return 1;
        if(o.death) return -1;
        return this.num - o.num;
    }
}

public class Solution {
    static int T, N, M, K, map[][];
    static int[] dx = { -1, 1, 0, 0 }, dy = { 0, 0, -1, 1 };
    static Virus[] viruses;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            map = new int[N][N];
            viruses = new Virus[K];

            for (int i = 0; i < N; i++) Arrays.fill(map[i], -1);
            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken()), y = Integer.parseInt(st.nextToken()), num = Integer.parseInt(st.nextToken());
                viruses[i] = new Virus(x, y, num, Integer.parseInt(st.nextToken()) - 1);
            }
            Arrays.sort(viruses);

            int x, y, d, cnt = 0;
            while (0 < M-- && cnt < K) {
                for (int i = 0; i < K; i++) {
                    if (viruses[i].death) break;

                    d = viruses[i].d;
                    x = viruses[i].x + dx[d];
                    y = viruses[i].y + dy[d];
                    if (x == 0 || y == 0 || x == N - 1 || y == N - 1) {
                        viruses[i].num /= 2;
                        viruses[i].d = (d % 2 == 0) ? d + 1 : d - 1;
                    }

                    viruses[i].x = x;
                    viruses[i].y = y;
                    if (map[x][y] != -1) {
                        viruses[i].num += viruses[map[x][y]].num;
                        viruses[map[x][y]].death = true;
                        cnt++;
                    }

                    map[x][y] = i;
                }
                Arrays.sort(viruses);
                for (int i = 0; i < K; i++) {
                    if (viruses[i].death) break;
                    map[viruses[i].x][viruses[i].y] = -1;
                }
            }

            int ans = 0;
            for (int i = 0; i < K; i++) {
                if (viruses[i].death) break;
                ans += viruses[i].num;
            }
            sb.append("#" + t + " " + ans + "\n");
        }
        System.out.println(sb);
    }
}


// import java.io.BufferedReader;
// import java.io.IOException;
// import java.io.InputStreamReader;
// import java.util.ArrayList;
// import java.util.Collections;
// import java.util.List;
// import java.util.StringTokenizer;

// class Virus implements Comparable<Virus> {
//     int i, j, num, cnt, dir;
    
//     Virus(int num, int i, int j, int cnt, int dir) {
//         this.num = num;
//         this.i = i;
//         this.j = j;
//         this.cnt = cnt;
//         this.dir = dir;
//     }

//     public int compareTo(Virus o) {
//         if (this.num == o.num) {
//             return o.cnt - this.cnt;
//         }
//         return this.num - o.num;
//     }

// }

// public class Solution {
//     static int N, M, K;
//     static int di[] = {-1, 1, 0, 0 }, dj[] = {0, 0, -1, 1 };
//     static List<Virus> list;

//     public static void main(String[] args) throws IOException {
//         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//         StringBuilder sb = new StringBuilder();
//         int TC = Integer.parseInt(br.readLine());

//         for (int tc = 1; tc <= TC; tc++) {
//             StringTokenizer st = new StringTokenizer(br.readLine());
//             N = Integer.parseInt(st.nextToken());
//             M = Integer.parseInt(st.nextToken());
//             K = Integer.parseInt(st.nextToken());

//             list = new ArrayList();
//             for (int k = 0; k < K; k++) {
//                 st = new StringTokenizer(br.readLine());
//                 int i = Integer.parseInt(st.nextToken());
//                 int j = Integer.parseInt(st.nextToken());
//                 list.add(new Virus(i * N + j, i, j, Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()) - 1));
//             }

//             for (int time = 0; time < M; time++) {
//                 for (int idx = 0; idx < list.size(); idx++) {
//                     Virus virus = list.get(idx);
//                     virus.i = virus.i + di[virus.dir];
//                     virus.j = virus.j + dj[virus.dir];
//                     virus.num = (virus.i * N) + virus.j;

//                     if (virus.i == 0 || virus.j == 0 || virus.i == N - 1 || virus.j == N - 1) {
//                         virus.cnt /= 2;
//                         virus.dir = (virus.dir % 2 == 0) ? virus.dir+1 : virus.dir-1;
//                         if (virus.cnt == 0) {
//                             list.remove(idx);
//                             idx--;
//                         }
//                     }
//                 }

//                 Collections.sort(list);
//                 for (int idx = 0; idx < list.size() - 1; idx++) {
//                     Virus now = list.get(idx);
//                     Virus next = list.get(idx + 1);
//                     if (now.num == next.num) {
//                         now.cnt += next.cnt;
//                         list.remove(idx + 1);
//                         idx--;
//                     }
//                 }
//             }

//             int total = 0;
//             for (int p = 0; p < list.size(); p++) {
//                 total += list.get(p).cnt;
//             }
//             sb.append("#" + tc + " " + total + "\n");
//         }
//         System.out.println(sb.toString());
//     }
// }

// import java.io.BufferedReader;
// import java.io.IOException;
// import java.io.InputStreamReader;
// import java.util.Arrays;
// import java.util.PriorityQueue;
// import java.util.StringTokenizer;

// class Micro implements Comparable<Micro> {
//     int x, y, cnt, d;

//     Micro(int x, int y, int cnt, int d) {
//         this.x = x;
//         this.y = y;
//         this.cnt = cnt;
//         this.d = d;
//     }

//     @Override
//     public int compareTo(Micro o) {
//         return o.cnt <= this.cnt ? 1 : -1;
//     }
// }

// public class Solution {
//     static int T, N, M, K;
//     static int[] dx = {-1, 1, 0, 0}, dy = {0, 0, -1, 1};
//     static int[][] map;
//     public static void main(String[] args) throws IOException {
//         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//         StringBuilder sb = new StringBuilder();

//         T = Integer.parseInt(br.readLine());
//         for(int t = 1; t <= T; t++) {
//             StringTokenizer st = new StringTokenizer(br.readLine());
//             N = Integer.parseInt(st.nextToken());
//             M = Integer.parseInt(st.nextToken());
//             K = Integer.parseInt(st.nextToken());
            
//             map = new int[N][N];            
//             PriorityQueue<Micro> micros = new PriorityQueue<>();
//             for(int i = 0; i < K; i++){
//                 st = new StringTokenizer(br.readLine());
//                 Micro micro = new Micro(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())-1);
//                 micros.offer(micro);
//                 map[micro.x][micro.y] = micro.cnt;
//             }
            
//             int[][] tempMap = new int[N][N];
//             int count = 0;
//             while(!micros.isEmpty()) {
//                 if(count == M) break;

//                 PriorityQueue<Micro> tempQ = new PriorityQueue<>();
//                 while(!micros.isEmpty()) {
//                     Micro micro = micros.poll();
//                     if(micro.cnt < map[micro.x][micro.y]) continue;

//                     micro.x += dx[micro.d];
//                     micro.y += dy[micro.d];

//                     // if wall
//                     if(micro.x == 0 || micro.y == 0 || micro.x == N-1 || micro.y == N-1) {
//                         micro.cnt /= 2;
//                         if(micro.d % 2 == 0) micro.d++;
//                         else micro.d--;

//                         tempMap[micro.x][micro.y] = micro.cnt;
//                         tempQ.offer(micro);
//                         continue;
//                     }

//                     // single or not
//                     if(tempMap[micro.x][micro.y] == 0) {
//                         tempMap[micro.x][micro.y] = micro.cnt;
//                         tempQ.offer(micro);
//                         continue;
//                     }

//                     micro.cnt += tempMap[micro.x][micro.y];
//                     tempMap[micro.x][micro.y] = micro.cnt;
//                     tempQ.offer(micro);
//                 }

//                 for(int i = 0; i < N; i++) {
//                     map[i] = Arrays.copyOf(tempMap[i], N);
//                     Arrays.fill(tempMap[i], 0);
//                 }

//                 while(!tempQ.isEmpty()) micros.offer(tempQ.poll());
//                 count++;
//             }

//             int sum = 0;
//             for(Micro micro : micros) {
//                 if(micro.cnt < map[micro.x][micro.y]) continue;
//                 sum += micro.cnt;
//             }
//             sb.append("#" + t + " " + sum + "\n");
//         }

//         System.out.println(sb.toString());
//     }
// }
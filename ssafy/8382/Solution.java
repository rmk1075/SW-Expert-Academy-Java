import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Location {
    int x, y, cnt;

    Location(int x, int y, int cnt) {
        this.x = x;
        this.y = y;
        this.cnt = cnt;
    }
}

public class Solution {
    static int T, minDistance;
    static int[] dx = { -1, 1, 0, 0 };
    static int[] dy = { 0, 0, 1, -1 };
    static int[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken()) + 100;
            int y1 = Integer.parseInt(st.nextToken()) + 100;
            int x2 = Integer.parseInt(st.nextToken()) + 100;
            int y2 = Integer.parseInt(st.nextToken()) + 100;

            if (x1 == x2 && y1 == y2) {
                sb.append("#" + t + " 0\n");
                continue;
            }

            minDistance = Math.abs(x1-x2) + Math.abs(y1-y2);

            visited = new int[201][201];            
            visited[x1][y1] |= (1 << 0);
            visited[x1][y1] |= (1 << 1);

            Queue<Location> queue = new LinkedList<>();
            queue.add(new Location(x1, y1, 0));
            queue.add(new Location(x1, y1, 1));

            int size, count = 1;
            loop: while (!queue.isEmpty()) {
                size = queue.size();
                while (0 < size--) {
                    Location current = queue.poll();

                    int x, y, a = 2, b = 4, c = 0;
                    if(current.cnt == 0) {
                        a = 0;
                        b = 2;
                        c = 1;
                    }

                    for(int d = a; d < b; d++) {
                        x = current.x + dx[d];
                        y = current.y + dy[d];

                        if (x == x2 && y == y2) break loop;
                        if (x < 0 || y < 0 || x == visited.length || y == visited.length || (visited[x][y] & (1 << c)) != 0) continue;

                        // TODO: minDistance
                        if(minDistance + 1 < Math.abs(x2 - x) + Math.abs(y2 - y)) continue;
                        minDistance = Math.min(minDistance, Math.abs(x2 - x) + Math.abs(y2 - y));

                        visited[x][y] |= (1 << c);
                        queue.offer(new Location(x, y, c));
                    }
                }
                count++;
            }
            sb.append("#" + t + " " + count + "\n");
        }
        System.out.println(sb.toString());
    }
}

// import java.io.BufferedReader;
// import java.io.IOException;
// import java.io.InputStreamReader;
// import java.util.LinkedList;
// import java.util.Queue;
// import java.util.StringTokenizer;

// class Location {
//     int x, y, cnt;

//     Location(int x, int y, int cnt) {
//         this.x = x;
//         this.y = y;
//         this.cnt = cnt;
//     }
// }

// public class Solution {
//     static int T;
//     static int[] dx = { -1, 1, 0, 0 };
//     static int[] dy = { 0, 0, 1, -1 };
//     static int[][] visited;

//     public static void main(String[] args) throws IOException {
//         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//         StringBuilder sb = new StringBuilder();
//         StringTokenizer st;

//         T = Integer.parseInt(br.readLine());
//         for (int t = 1; t <= T; t++) {
//             st = new StringTokenizer(br.readLine());
//             int x1 = Integer.parseInt(st.nextToken()) + 100;
//             int y1 = Integer.parseInt(st.nextToken()) + 100;
//             int x2 = Integer.parseInt(st.nextToken()) + 100;
//             int y2 = Integer.parseInt(st.nextToken()) + 100;

//             if (x1 == x2 && y1 == y2) {
//                 sb.append("#" + t + " 0\n");
//                 continue;
//             }

//             visited = new int[201][201];            
//             visited[x1][y1] |= (1 << 0);
//             visited[x1][y1] |= (1 << 1);

//             Queue<Location> queue = new LinkedList<>();
//             queue.add(new Location(x1, y1, 0));
//             queue.add(new Location(x1, y1, 1));

//             int size, count = 1;
//             loop: while (!queue.isEmpty()) {
//                 size = queue.size();
//                 while (0 < size--) {
//                     Location current = queue.poll();

//                     int x, y, a = 2, b = 4, c = 0;
//                     if(current.cnt == 0) {
//                         a = 0;
//                         b = 2;
//                         c = 1;
//                     }

//                     for(int d = a; d < b; d++) {
//                         x = current.x + dx[d];
//                         y = current.y + dy[d];

//                         if (x == x2 && y == y2) break loop;
//                         if (x < 0 || y < 0 || x == visited.length || y == visited.length || (visited[x][y] & (1 << c)) != 0) continue;
//                         visited[x][y] |= (1 << c);
//                         queue.offer(new Location(x, y, c));
//                     }
//                 }
//                 count++;
//             }
//             sb.append("#" + t + " " + count + "\n");
//         }
//         System.out.println(sb.toString());
//     }
// }

// import java.io.BufferedReader;
// import java.io.IOException;
// import java.io.InputStreamReader;
// import java.util.LinkedList;
// import java.util.Queue;
// import java.util.StringTokenizer;

// class Location {
//     int x, y, cnt;

//     Location(int x, int y, int cnt) {
//         this.x = x;
//         this.y = y;
//         this.cnt = cnt;
//     }
// }

// public class Solution {
//     static int T;
//     static int[] dx = { -1, 1, 0, 0 };
//     static int[] dy = { 0, 0, 1, -1 };
//     static boolean[][][] visited;

//     public static void main(String[] args) throws IOException {
//         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//         StringBuilder sb = new StringBuilder();
//         StringTokenizer st;

//         T = Integer.parseInt(br.readLine());
//         for (int t = 1; t <= T; t++) {
//             st = new StringTokenizer(br.readLine());
//             int x1 = Integer.parseInt(st.nextToken()) + 100;
//             int y1 = Integer.parseInt(st.nextToken()) + 100;
//             int x2 = Integer.parseInt(st.nextToken()) + 100;
//             int y2 = Integer.parseInt(st.nextToken()) + 100;

//             if (x1 == x2 && y1 == y2) {
//                 sb.append("#" + t + " 0\n");
//                 continue;
//             }

//             visited = new boolean[201][201][2];
//             visited[x1][y1][0] = true;
//             visited[x1][y1][1] = true;

//             Queue<Location> queue = new LinkedList<>();
//             queue.add(new Location(x1, y1, 0));
//             queue.add(new Location(x1, y1, 1));

//             int size, count = 1;
//             loop: while (!queue.isEmpty()) {
//                 size = queue.size();
//                 while (0 < size--) {
//                     Location current = queue.poll();

//                     int x, y, a = 2, b = 4, c = 0;
//                     if(current.cnt == 0) {
//                         a = 0;
//                         b = 2;
//                         c = 1;
//                     }

//                     for(int d = a; d < b; d++) {
//                         x = current.x + dx[d];
//                         y = current.y + dy[d];

//                         if (x == x2 && y == y2) break loop;
//                         if (x < 0 || y < 0 || x == visited.length || y == visited.length || visited[x][y][c]) continue;
//                         visited[x][y][c] = true;
//                         queue.offer(new Location(x, y, c));
//                     }
//                 }
//                 count++;
//             }
//             sb.append("#" + t + " " + count + "\n");
//         }
//         System.out.println(sb.toString());
//     }
// }
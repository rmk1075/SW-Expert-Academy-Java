import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Location {
    int x, y;

    Location(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Solution {
    static int T, N, minDistance;
    static int[] visited;
    static Location[] spots;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            
            spots = new Location[N+2];
            spots[0] = new Location(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            spots[N+1] = new Location(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            
            for(int i = 1; i <= N; i++) {
                spots[i] = new Location(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            }
            
            // combination
            minDistance = Integer.MAX_VALUE;
            visited = new int[N+2];
            visited[0] = visited[N+1] = 1;
            find(0, 0, 0);

            sb.append("#" + t + " " + minDistance + "\n");
        }

        System.out.println(sb.toString());
    }

    public static void find(int index, int count, int sum) {

        if(minDistance <= sum) return ;

        if(count == N) {
            minDistance = Math.min(minDistance, sum + Math.abs(spots[index].x - spots[N+1].x) + Math.abs(spots[index].y - spots[N+1].y));
            return ;
        }

        for(int i = 1; i < N+1; i++) {
            if(visited[i] == 0) {
                visited[i] = 1;
                if(count == 0) find(i, count+1, sum + Math.abs(spots[i].x - spots[0].x) + Math.abs(spots[i].y - spots[0].y));
                else find(i, count+1, sum + Math.abs(spots[i].x - spots[index].x) + Math.abs(spots[i].y - spots[index].y));
                visited[i] = 0;
            }
        }
    }
}
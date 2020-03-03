import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Log {
    int l, r, s;

    Log(int l, int r, int s) {
        this.l = l;
        this.r = r;
        this.s = s;
    }
}

public class Solution {
    static int T, N, X, M, ansSum;
    static int[] hamsters, ans;
    static Log[] conditions;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            X = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            hamsters = new int[N];
            
            conditions = new Log[M];
            for(int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                conditions[i] = new Log(Integer.parseInt(st.nextToken())-1, Integer.parseInt(st.nextToken())-1, Integer.parseInt(st.nextToken()));
            }
            
            ansSum = -1;
            ans = new int[N];
            dfs(0, 0);

            if(ansSum != -1) {
                sb.append("#" + t);
                for(int h : ans) sb.append(" " + h);
                sb.append("\n");
            }
            else sb.append("#" + t + " -1\n");
        }

        System.out.println(sb.toString());
    }

    public static void dfs(int index, int sum) {
        if(index == N) {
            if(sum < ansSum) return ;

            // compare hamsters with conditions
            for(Log condition : conditions) {
                int temp = 0;
                for(int i = condition.l; i <= condition.r; i++) {
                    temp += hamsters[i];
                }
                if(temp != condition.s) return ;
            }

            for(int i = 0; i < N; i++) ans[i] = hamsters[i];
            ansSum = sum;
            return ;
        }

        for(int i = X; -1 < i; i--) {
            hamsters[index] = i;
            dfs(index + 1, sum + i);
        }
    }
}
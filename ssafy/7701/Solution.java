import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

class Element implements Comparable<Element> {
    String str;

    Element(String str) {
        this.str = str;
    }

    @Override
    public int compareTo(Element o) {
        if (this.str.length() == o.str.length())
            return (this.str.compareTo(o.str) < 0) ? -1 : 1;
        return (this.str.length() < o.str.length()) ? -1 : 1;
    }
}

public class Solution {
    static int T, N;
    static Set<String> names;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            names = new HashSet<>();
            N = Integer.parseInt(br.readLine());
            for (int i = 0; i < N; i++)
                names.add(br.readLine());

            PriorityQueue<Element> pq = new PriorityQueue<>();
            for (String str : names)
                pq.offer(new Element(str));

            sb.append("#" + t + "\n");
            while (!pq.isEmpty())
                sb.append(pq.poll().str + "\n");
        }

        System.out.println(sb.toString());
    }
}
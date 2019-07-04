import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int n = in.nextInt();
        int m = in.nextInt();
        int[] x = new int[m];
        int[] y = new int[m];
        for (int i = 0; i < m; i++) {
            x[i] = in.nextInt();
            y[i] = in.nextInt();
        }
        Solver solver=new Solver();
        if (solver.isBipartite(n, m, x, y)){
            out.println("Yes");
            int[] ans=solver.getColor();
            for (int i = 0; i <ans.length; i++) {
                out.println(ans[i]);
            }
        }
        else {
            out.println("No");
        }
        out.close();
    }
}

class Solver {
    private int[] color;

    public int[] getColor() {
        return color;
    }

    public boolean isBipartite(int n, int m, int[] x, int[] y) {
        color = new int[n];
        ArrayList<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            graph[x[i] - 1].add(y[i] - 1);
            graph[y[i] - 1].add(x[i] - 1);
        }

        for (int i = 0; i < n; i++) {
            if (color[i] == 0) {
                LinkedList<Integer> queue = new LinkedList<>();
                queue.add(i);
                final int RED = 1;
                final int BLUE = 2;
                color[i] = RED;
                while (!queue.isEmpty()) {
                    int cur = queue.poll();
                    for (int neighbor : graph[cur]) {
                        if (color[neighbor] == 0) {
                            queue.add(neighbor);
                            color[neighbor] = color[cur] == RED ? BLUE : RED;
                        }
                        else if (color[neighbor]==color[cur]){
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
}

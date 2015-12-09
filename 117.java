import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Arrays;

class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

        int size = 'z' - 'a' + 1;
        int[][] g = new int[size][size]; // stores shortest street between two intersections
        for (int[] gi : g) {
            Arrays.fill(gi, 1000000000);
        }
        int[] c = new int[size]; // number of outgoing streets for each intersection

        int[] odds = new int[2];
        int oddCount = 0;

        int totalLength = 0;

        String street;
        while ((street = in.readLine()) != null) {
            if (street.equals("deadend")) {
                // calculate
                for (int i = 0; i < c.length; i++) {
                    if (c[i] % 2 == 1) {
                        odds[oddCount++] = i;
                    }
                }

                int result = totalLength;

                if (oddCount > 0) {
                    result += shortestPath(g, odds[0], odds[1]);
                }

                out.println(result);

                // reset
                for (int[] gi : g) {
                    Arrays.fill(gi, 1000000000);
                }
                Arrays.fill(c, 0);
                oddCount = 0;
                totalLength = 0;
            } else {
                // add street to model
                int length = street.length();
                int intersection1 = street.charAt(0) - 'a';
                int intersection2 = street.charAt(length - 1) - 'a';
                c[intersection1]++;
                c[intersection2]++;
                if (g[intersection1][intersection2] > length) {
                    g[intersection1][intersection2] = g[intersection2][intersection1] = length;
                }
                totalLength += length;
            }
        }

        out.flush();
    }

    private static int shortestPath(int[][] g, int n1, int n2) {
        // g is dist
        for (int i = 0; i < g.length; i++) {
            g[i][i] = 0;
        }
        for (int k = 0; k < g.length; k++) {
            for (int i = 0; i < g.length; i++) {
                for (int j = 0; j < g.length; j++) {
                    if (g[i][j] > g[i][k] + g[k][j]) {
                        g[i][j] = g[i][k] + g[k][j];
                    }
                }
            }
        }
        return g[n1][n2];
    }

}

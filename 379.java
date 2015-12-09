import java.io.*;
import java.util.Scanner;

class Main {

    //region Common IO

    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static StreamTokenizer tin = new StreamTokenizer(in);
    static PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

    static String readLine() throws IOException {
        return in.readLine();
    }

    static Scanner readScanner() throws IOException {
        return new Scanner(readLine());
    }

    static double readDouble() throws IOException {
        tin.nextToken();
        return tin.nval;
    }

    static int readInt() throws IOException {
        return (int) readDouble();
    }

    static int readLong() throws IOException {
        return (int) readDouble();
    }

    //endregion

    static int[][] BOARD = {
            {0, 0, 1, 2, 3, 0, 0},
            {0, 0, 4, 5, 6, 0, 0},
            {7, 8, 9, 10, 11, 12, 13},
            {14, 15, 16, 17, 18, 19, 20},
            {21, 22, 23, 24, 25, 26, 27},
            {0, 0, 28, 29, 30, 0, 0},
            {0, 0, 31, 32, 33, 0, 0},
    };

    static int[][] INDEXES = new int[33][2];
    static {
        for (int i = 0; i < BOARD.length; i++) {
            for (int j = 0; j < BOARD[i].length; j++) {
                int index = BOARD[i][j];
                if (index != 0) {
                    INDEXES[index - 1][0] = i;
                    INDEXES[index - 1][1] = j;
                }
            }
        }
    }

    static int[][] CHECK_ORDER = {
            {1, 0},
            {0, 1},
            {0, -1},
            {-1, 0},
    };

    public static void main(String[] args) throws Exception {
        out.println("HI Q OUTPUT");

        // Solution
        for (int t = readInt(); t > 0; t--) {
            // Handle test case
            boolean[][] pegs = new boolean[BOARD.length][BOARD.length];

            // Read input
            for (int i = readInt(); i != 0; i = readInt()) {
                pegs[INDEXES[i - 1][0]][INDEXES[i - 1][1]] = true;
            }

            MainLoop:
            while (true) {
                for (int i = BOARD.length - 1; i >= 0; i--) {
                    for (int j = BOARD[i].length - 1; j >= 0; j--) {
                        if (BOARD[i][j] != 0 && !pegs[i][j]) {
                            for (int[] delta : CHECK_ORDER) {
                                // Jump from
                                int i1 = i + 2 * delta[0];
                                int j1 = j + 2 * delta[1];

                                // Jump over
                                int i2 = i + delta[0];
                                int j2 = j + delta[1];

                                // Move
                                if (hasPeg(pegs, i1, j1) && hasPeg(pegs, i2, j2)) {
                                    pegs[i][j] = true;
                                    pegs[i1][j1] = pegs[i2][j2] = false;
                                    continue MainLoop;
                                }
                            }
                        }
                    }
                }
                break;
            }

            int sum = 0;
            for (int i = 0; i < BOARD.length; i++) {
                for (int j = 0; j < BOARD[i].length; j++) {
                    if (pegs[i][j]) {
                        sum += BOARD[i][j];
                    }
                }
            }

            out.println(sum);
        }

        out.println("END OF OUTPUT");
        out.flush();
    }

    private static boolean hasPeg(boolean[][] pegs, int i, int j) {
        return isHole(i, j) && pegs[i][j];
    }

    private static boolean isHole(int i, int j) {
        return i >= 0 && i < BOARD.length && j >= 0 && j < BOARD[i].length && BOARD[i][j] != 0;
    }

}

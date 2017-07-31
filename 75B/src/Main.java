
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.InputStream;

public class Main {

    public static void main(String[] args) {
        InputReader in = new InputReader(System.in);
        PrintWriter out = new PrintWriter(System.out);
        TaskA solver = new TaskA();
        solver.solve(1, in, out);
        out.close();
    }

    public static class TaskA {

        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int r = in.nextInt(), c = in.nextInt(), command = in.nextInt();
            int[][] array = new int[r + 1][c + 1];

            //Reading ints
            for (int i = 1; i < r+1; i++) {
                for (int j = 1; j < c+1; j++) {
                    array[i][j] = in.nextInt();
                }
            }

            for (int i = 0; i < command; i++) {
                String check = in.next();
                if (check.equals("c")) {
                    //reading coloms
                    int l = in.nextInt(), m = in.nextInt();

                    int temp[] = new int[r + 1];

                    for (int j = 1; j < r + 1; j++) {
                        temp[j] = array[j][l];
                    }

                    //swapping colom
                    for (int j = 1; j < r + 1; j++) {
                        array[j][l] = array[j][m];
                        array[j][m] = temp[j];
                    }

                } else if (check.equals("r")) {
                    //reading rows
                    int l = in.nextInt(), m = in.nextInt();

                    int temp[] = new int[c+1];

                    for (int j = 1; j < c + 1; j++) {
                        temp[j] = array[l][j];
                    }

                    //swapping coloum
                    for (int j = 1; j < c + 1; j++) {
                        array[l][j] = array[m][j];
                        array[m][j] = temp[j];
                    }
                } else {
                    int l = in.nextInt(), m = in.nextInt();
                    out.println(array[l][m]);
                }
            }
        }

    }
}

class InputReader {

    public BufferedReader reader;
    public StringTokenizer tokenizer;

    public InputReader(InputStream stream) {
        reader = new BufferedReader(new InputStreamReader(stream), 32768);
        tokenizer = null;
    }

    public String next() {
        while (tokenizer == null || !tokenizer.hasMoreTokens()) {
            try {
                tokenizer = new StringTokenizer(reader.readLine());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return tokenizer.nextToken();
    }

    public int nextInt() {
        return Integer.parseInt(next());
    }

}

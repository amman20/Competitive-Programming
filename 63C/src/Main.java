
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Main {

    public static void main(String[] args) {
        InputReader in = new InputReader(System.in);
        PrintWriter out = new PrintWriter(System.out);
        TaskA solver = new TaskA();
        solver.solve(1, in, out);
        out.close();
    }

    static class TaskA {

        public void solve(int testNumber, InputReader input, PrintWriter out) {
            int moves = input.nextInt();
            ArrayList<Integer> list = new ArrayList();
            HashMap<Character,pair> res ;
            int good, bad;
            String num;
            num = input.next();
            if (num.length() < 4) {
                if (num.contains("0")) {
                    out.println("Incorrect data");
                    return;
                } else {
                    num = "0" + num;
                }
            }

            list.add(Integer.parseInt(num));
            good = input.nextInt();
            bad = input.nextInt();

            if (good == 4 && bad == 0) {
                out.println(list.get(0));
                return;
            }

            while (moves-- > 0) {
                num = input.next();
                if (num.length() < 4) {
                    if (num.contains("0")) {
                        out.println("Incorrect data");
                        return;
                    } else {
                        num = "0" + num;
                    }
                }
                list.add(Integer.parseInt(num));
                //always have just two
                if (list.size() >= 2) {
                    list.remove(0);
                }
                if (!isUnique(num)) {
                    out.println("Incorrect data");
                    return;
                } 
                res = getMatches(num,list.get(0)+"");
                if (res. == 0) {
                    if (good > 0 || bad > 0) {
                        out.println("Incorrect data");
                        return;
                    }
                }
               
                
            }

        }

        public static HashMap getMatches(String num,String old) {
            HashMap<Character,pair> res = new HashMap();
            int matches = 0;
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    if (num.charAt(i) == num.charAt(j)) {
                        res.put(num.charAt(i), new pair());
                    }
                    matches += num.charAt(i) == num.charAt(j) ? 1 : 0;
                }
            }
            return matches;
        }

        public static boolean isUnique(String num) {
            HashSet<Character> set = new HashSet();
            for (int i = 0; i < 4; i++) {
                set.add(num.charAt(i));
            }
            return set.size() == 4;
        }
    }
}

class pair{
    int oldindx;
    int newIndx;
    public pair(int oldindx,int newindx){
        this.oldindx = oldindx;
        this.newIndx = newindx;
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

    public long nextLong() {
        return Long.parseLong(next());
    }

}

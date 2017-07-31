package Message;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;

class Main {

    public static void main(String[] args) {//ACCepted
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader input = new InputReader(inputStream);
        PrintWriter output = new PrintWriter(outputStream);
        int m = input.nextInt();
        //Class that contains the letter, and its symbol.
        MatchedLetter[] allLetters = new MatchedLetter[m];
        int debugging = 0;

        //Reading all letters and symbols and putting them in the class.
        for (int i = 0; i < m; i++) {
            allLetters[i] = new MatchedLetter();
            allLetters[i].letter = input.next().charAt(0);
            for (int j = 0; j < allLetters[i].image.length; j++) {
                allLetters[i].image[j] = input.next().toCharArray();
            }
        }
        int n = input.nextInt();
        for (int i = 0; i < n; i++) {

            char[][] alienSymbol = new char[10][10];
            //Reading the current symbol.
            for (int j = 0; j < alienSymbol.length; j++) {
                alienSymbol[j] = input.next().toCharArray();
            }
            int correctIdx = -1;
            int lowestWrong = 21;
            char[][] test = new char[10][10];
            if (debugging != 0) {
                System.out.println("0: ");
            }
            A:
            //Comparing with
            for (int l = 0; l < allLetters.length; l++) { //Loop over all possible letters.
                int wrong = 0;
                for (int j = 0; j < alienSymbol.length; j++) {
                    for (int k = 0; k < alienSymbol[j].length; k++) {
                        if (allLetters[l].image[j][k] != alienSymbol[j][k]) { //If the given symbol doesn't match the one we have in class, increase wrong.
                            wrong++;
                        }
                        if (wrong > 20) { //If the noise is more than 20, try the next symbol in class.
                            continue A;
                        }
                    }
                }
                if (debugging != 0) {

                    System.out.println("Letter " + allLetters[l].letter);
                    System.out.println("Wrong: " + wrong);
                }
                if (wrong < lowestWrong) { //If the current letter has less noise than the previous one, change the index of the correct one.
                    lowestWrong = wrong;
                    correctIdx = l;
                }
            }
            if (debugging != 0) {

                System.out.println("1lowestWrong: " + lowestWrong);
                System.out.println("correctIdx: " + correctIdx);

                ////////////////////////////////// 270 Percent.
                System.out.println("270: ");

            }
            for (int w = 0; w < alienSymbol.length; w++) { //Rotate the current symbol to 270 degrees
                for (int j = 0, l = test.length - 1; j < alienSymbol[w].length; j++, l--) {
                    test[l][w] = alienSymbol[w][j];
                }
            }

            A:
            for (int l = 0; l < allLetters.length; l++) { //Do the same comparision with the 270 rotated symbol.
                int wrong = 0;
                for (int j = 0; j < test.length; j++) {
                    for (int k = 0; k < test[j].length; k++) {
                        if (allLetters[l].image[j][k] != test[j][k]) {
                            wrong++;
                        }
                        if (wrong > 20) {
                            continue A;
                        }
                    }
                }
                if (debugging != 0) {

                    System.out.println("Letter " + allLetters[l].letter);
                    System.out.println("Wrong: " + wrong);
                }
                if (wrong < lowestWrong) {
                    lowestWrong = wrong;
                    correctIdx = l;
                }
            }
            if (debugging != 0) {

                System.out.println("4lowestWrong: " + lowestWrong);
                System.out.println("correctIdx: " + correctIdx);
                ///////////////////////////////////// 180 Percent.
                System.out.println("180: ");
            }
            for (int w = 0, k = test.length - 1; w < alienSymbol.length; w++, k--) { //Rotate the current symbol to 180 degree.
                for (int j = 0, l = test.length - 1; j < alienSymbol[w].length; j++, l--) {
                    test[k][l] = alienSymbol[w][j];
                }
            }
            A:
            for (int l = 0; l < allLetters.length; l++) { //Do the same comparision with the 180 rotated symbol.
                int wrong = 0;
                B:
                for (int j = 0; j < test.length; j++) {
                    for (int k = 0; k < test[j].length; k++) {
                        if (allLetters[l].image[j][k] != test[j][k]) {
                            wrong++;
                        }
                        if (wrong > 20) {
                            continue A;
                        }
                    }
                }
                if (debugging != 0) {

                    System.out.println("Letter " + allLetters[l].letter);
                    System.out.println("Wrong: " + wrong);
                }
                if (wrong < lowestWrong) {
                    lowestWrong = wrong;
                    correctIdx = l;
                }
            }
            if (debugging != 0) {

                System.out.println("3lowestWrong: " + lowestWrong);
                System.out.println("correctIdx: " + correctIdx);
                ////////////////////////////////////// 90 percent.
                System.out.println("90: ");
            }
            //90 percent.
            for (int w = 0, k = test.length - 1; w < alienSymbol.length; w++, k--) { //Rotate the symbol to 90 degrees.
                for (int j = 0; j < alienSymbol[w].length; j++) {
                    test[j][k] = alienSymbol[w][j];
                }
            }
            A:
            for (int l = 0; l < allLetters.length; l++) { //Do the same comparision again!
                int wrong = 0;
                for (int j = 0; j < test.length; j++) {
                    for (int k = 0; k < test[j].length; k++) {
                        if (allLetters[l].image[j][k] != test[j][k]) {
                            wrong++;
                        }
                        if (wrong > 20) {
                            continue A;
                        }
                    }
                }
                if (debugging != 0) {

                    System.out.println("Letter " + allLetters[l].letter);
                    System.out.println("Wrong: " + wrong);
                }
                if (wrong < lowestWrong) {
                    lowestWrong = wrong;
                    correctIdx = l;
                }
            }
            if (debugging != 0) {

                System.out.println("2lowestWrong: " + lowestWrong);
                System.out.println("correctIdx: " + correctIdx);
            }
            if (correctIdx != -1) { //Print the letter of the symbol.
                output.print(allLetters[correctIdx].letter);
            }
        }
        output.println();
        output.close();
    }

    static class MatchedLetter {

        char letter;
        char[][] image = new char[10][10];
    }

    static class InputReader {

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

        public String nextLine() throws IOException {
            return reader.readLine();
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }

    }

}

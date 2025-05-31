import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader("data_prog_contest_problem_2.txt"))) {
            String line = br.readLine();

            int n = Integer.parseInt(line.trim());

            int[] arr = new int[n];
            int idx = 0;
            while (idx < n) {
                String row = br.readLine();

                String[] parts = row.trim().split("\\s+");

                System.out.println(parts[149]);

                for (String part : parts) {
                    if (!part.isEmpty() && idx < n) {
                        arr[idx++] = Integer.parseInt(part);
                    }
                }
            }

            boolean[] seen = new boolean[27];
            int uniqueCount = 0;
            int answer = -1;
            for (int i = 0; i < n; i++) {
                int x = arr[i];
                if (x >= 1 && x <= 26 && !seen[x]) {
                    seen[x] = true;
                    uniqueCount++;
                    if (uniqueCount == 26) {
                        answer = i + 1;
                        break;
                    }
                }
            }

            System.out.println(answer == -1 ? "NONE" : answer);
        }
    }
}
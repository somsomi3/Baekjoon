import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] a = br.readLine().split(":");
        String[] b = br.readLine().split(":");

        int si1 = Integer.parseInt(a[0]);
        int bun1 = Integer.parseInt(a[1]);
        int cho1 = Integer.parseInt(a[2]);

        int si2 = Integer.parseInt(b[0]);
        int bun2 = Integer.parseInt(b[1]);
        int cho2 = Integer.parseInt(b[2]);

        int now = si1 * 3600 + bun1 * 60 + cho1;
        int target = si2 * 3600 + bun2 * 60 + cho2;

        int diff = target - now;
        if (diff <= 0) diff += 24 * 3600;

        int si = diff / 3600;
        int bun = (diff % 3600) / 60;
        int cho = diff % 60;

        System.out.printf("%02d:%02d:%02d", si, bun, cho);
    }
}
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int aSize = sc.nextInt();
        int bSize = sc.nextInt();

        Set<Integer> A = new HashSet<>();
        Set<Integer> B = new HashSet<>();

        for (int i = 0; i < aSize; i++) {
            A.add(sc.nextInt());
        }

        for (int i = 0; i < bSize; i++) {
            B.add(sc.nextInt());
        }

        // A - B
        Set<Integer> diffAB = new HashSet<>(A);
        diffAB.removeAll(B);

        // B - A
        Set<Integer> diffBA = new HashSet<>(B);
        diffBA.removeAll(A);

        int result = diffAB.size() + diffBA.size();
        System.out.println(result);
    }
}

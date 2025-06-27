import java.io.*;
import java.util.*;

public class Main {
    static class Gem implements Comparable<Gem> {
        int weight, value;

        public Gem(int weight, int value) {
            this.weight = weight;
            this.value = value;
        }

        @Override
        public int compareTo(Gem o) {
            // 가치가 높은 순 → 무게는 낮은 순
            if (this.value == o.value) return this.weight - o.weight;
            return o.value - this.value;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 보석 개수
        int K = Integer.parseInt(st.nextToken()); // 가방 개수

        PriorityQueue<Gem> gems = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int weight = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            gems.offer(new Gem(weight, value));
        }

        TreeSet<Integer> bags = new TreeSet<>();
        HashMap<Integer, Integer> bagCount = new HashMap<>();

        for (int i = 0; i < K; i++) {
            int capacity = Integer.parseInt(br.readLine());
            bags.add(capacity);
            bagCount.put(capacity, bagCount.getOrDefault(capacity, 0) + 1);
        }

        long totalValue = 0;

        while (!gems.isEmpty()) {
            Gem gem = gems.poll();
            Integer suitableBag = bags.ceiling(gem.weight); // 무게 이상인 가장 작은 가방

            if (suitableBag == null) continue;

            totalValue += gem.value;

            // 가방 사용 처리
            int count = bagCount.get(suitableBag) - 1;
            if (count == 0) {
                bags.remove(suitableBag);
                bagCount.remove(suitableBag);
            } else {
                bagCount.put(suitableBag, count);
            }
        }

        System.out.println(totalValue);
    }
}

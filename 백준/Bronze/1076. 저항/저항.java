import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Integer> map = new HashMap<>();
        map.put("black", 0);
        map.put("brown", 1);
        map.put("red", 2);
        map.put("orange", 3);
        map.put("yellow", 4);
        map.put("green", 5);
        map.put("blue", 6);
        map.put("violet", 7);
        map.put("grey", 8);
        map.put("white", 9);

        long value = 0;

        value += map.get(br.readLine()) * 10;
        value += map.get(br.readLine());

        int mul = map.get(br.readLine());
        for (int i = 0; i < mul; i++) {
            value *= 10;
        }

        System.out.println(value);
    }
}

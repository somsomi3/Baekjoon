import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        for (int a = 2; a <= 100; a++) {
            for (int b = 2; b < a; b++) {
                for (int c = b; c < a; c++) {
                    for (int d = c; d < a; d++) {

                        if (a*a*a == b*b*b + c*c*c + d*d*d) {
                            System.out.println(
                                "Cube = " + a +
                                ", Triple = (" + b + "," + c + "," + d + ")"
                            );
                        }
                    }
                }
            }
        }
    }
}

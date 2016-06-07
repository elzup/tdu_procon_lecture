package chap04.binarysearch;

import java.util.Scanner;

// sqrt n を二分探索で求める
public class BinarySearchSqrt {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        // validation
        if (n < 1) {
            System.out.println("invalid input.");
            return;
        }
        double l = 0;
        double r = n;
        // 精度をどこまで求めるか
        double accuracy = 0.00000000001;
        double o = 0;
        while (r - l > accuracy) {
            o ++;
            double m = (l + r) / 2;
            double t = m * m;
            if (t < n) {
                l = m + accuracy;
            } else {
                r = m - accuracy;
            }
        }
        double res = (l + r) / 2;
        System.out.println(res);
        System.out.println("O: " + o);
    }
}

package chap02.dfs;

import java.util.Scanner;

public class Main {
    static int w, h, c;
    static int[][] map;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            w = sc.nextInt();
            h = sc.nextInt();
            if (w == 0 && h == 0) {
                break;
            }
            map = new int[h][w];

            int sx = 0;
            int sy = 0;
            // 2次配列で受け取る
            for (int i = 0; i < h; i++) {
                String line = sc.next();
                for (int j = 0; j < w; j++) {
                    char c = line.charAt(j);
                    // 文字ごとに適切な値を初期値として受け取る
                    // '#' 赤のマス              -> 1
                    // '.' 黒のマス, '@' 初期位置 -> 0
                    if (c == '#') {
                        map[i][j] = 1;
                    } else if (c == '.') {
                        map[i][j] = 0;
                    } else {
                        // スタート位置の保存
                        sx = j;
                        sy = i;
                        map[i][j] = 0;
                    }
                }
            }
            // printArray(map);
            c = 0;
            check(sy, sx);
            System.out.println(c);
        }
    }

    public static void check(int y, int x) {
        if (y < 0 || x < 0 || y >= h || x >= w) {
            return;
        }
        if (map[y][x] == 1) {
            return;
        }
        map[y][x] = 1;
        c++;
        check(y + 1, x);
        check(y - 1, x);
        check(y, x + 1);
        check(y, x - 1);
    }

    // 2次配列の dump 関数
    public static void printArray(int[][] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}

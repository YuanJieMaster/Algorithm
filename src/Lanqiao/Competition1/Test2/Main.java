package Lanqiao.Competition1.Test2;

import java.util.Scanner;
// 1:无需package
// 2: 类名必须Main, 不可修改

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();
        int times = (m-1) / (n-1);
        int more = (m - 1) % (n - 1);
        System.out.println((times % 2 == 0)? more+1: n-more);
        scan.close();
    }
}
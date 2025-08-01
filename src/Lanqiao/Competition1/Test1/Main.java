package Lanqiao.Competition1.Test1;

import java.util.Scanner;
// 1:无需package
// 2: 类名必须Main, 不可修改

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int sum = 0;
        for (int i = 0; i <= 7/2; i++) {
            sum += i*2+1;
        }
        System.out.println(sum);
        scan.close();
    }
}
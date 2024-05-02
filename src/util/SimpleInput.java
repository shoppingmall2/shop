package util;

import java.util.Scanner;

public class SimpleInput {

    static Scanner scan = new Scanner(System.in);

    // 문자열 입력을 처리
    public static String input(String message) {
        System.out.print(message);
        return scan.nextLine();
    }

    // 엔터를 누르기 전까지 멈춰있는 기능
    public static void stopInput() {
        System.out.println("\n==========엔터를 누르면 계속 ...===========");
        scan.nextLine();
    }

}

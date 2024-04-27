package kibeom;

public class ConsoleColor {

    // ANSI Escape 코드로 색상 지정
    public static final String RESET = "\033[0m";
    public static final String BLACK = "\033[0;30m";
    public static final String RED = "\033[0;31m";
    public static final String GREEN = "\033[0;32m";
    public static final String YELLOW = "\033[0;33m";
    public static final String BLUE = "\033[0;34m";
    public static final String PURPLE = "\033[0;35m";
    public static final String CYAN = "\033[0;36m";
    public static final String WHITE = "\033[0;37m";

    public static void main(String[] args) {
        // 텍스트에 색상 적용
        System.out.println(RED + "빨간색 텍스트" + RESET);
        System.out.println(GREEN + "초록색 텍스트" + RESET);
        System.out.println(YELLOW + "노란색 텍스트" + RESET);
        System.out.println(BLUE + "파란색 텍스트" + RESET);
        System.out.println(PURPLE + "보라색 텍스트" + RESET);
        System.out.println(CYAN + "하늘색 텍스트" + RESET);
        System.out.println(WHITE + "흰색 텍스트" + RESET);
    }
}

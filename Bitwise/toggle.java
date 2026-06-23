import java.util.Scanner;
// i|p = 10 , o|p = 5 => 10 = 1010 flip = 0101 => 5
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int bits = Integer.toBinaryString(n).length();
        int mask = (1 << bits) - 1;

        int result = n ^ mask;

        System.out.println(result);
    }
}

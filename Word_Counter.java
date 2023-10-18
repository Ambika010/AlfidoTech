import java.util.Scanner;

public class Word_Counter {
    public static void main(String[] args) {
        System.out.println("Enter String");
        Scanner s = new Scanner(System.in);
        String str = s.nextLine();
        int count = 1;
        for (int i = 0; i < str.length() - 1; i++) {
            if (str.charAt(i) == ' ' && str.charAt(i + 1) != ' ') {
                count++;
            }
        }
        System.out.println("String having words:" + count);
    }

}

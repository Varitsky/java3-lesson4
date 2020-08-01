import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите число повторов (int>0): ");
        int repeat = scanner.nextInt();
        scanner.close();

        new Thread(new ABC.basicCharThenAnotherChar('A', 'B', repeat)).start();
        new Thread(new ABC.basicCharThenAnotherChar('B', 'C', repeat)).start();
        new Thread(new ABC.basicCharThenAnotherChar('C', 'A', repeat)).start();
    }
}


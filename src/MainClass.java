import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;



public class MainClass {
    private static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        String temp;
        while (true) {
            System.out.println("""
                    Для конвертации числа из десятичной системы счисления в шестнадцатиричную введите - "16"
                    Для конвертации числа из десятичной системы счисления в двоичную введите - "2"
                    Для конвертации числа из двоичной системы счисления в десятеричную введите- "10"
                    Для выхода из программы введите - "0\"""");

            temp = bufferedReader.readLine().trim();
            if (temp.equals("0")) {
                System.out.println("Работа программы завершена");
                bufferedReader.close();
                break;
            } else if (temp.equals("16")) {
                toHex();
            } else if (temp.equals("2")) {
                toBinary();
            } else if (temp.equals("10")) {
                toDecimal();
            } else {
                System.out.println("Некоректный ввод");
                System.out.println("________________");
            }
        }
    }

    public static void toHex() throws IOException {
        System.out.println("Введите целое число от 0 до 10000");
        StringBuilder result = new StringBuilder();
        int number;
        try {
            number = Integer.parseInt(bufferedReader.readLine().trim());
            if (number == 0) {
                System.out.println("Результат конвертации: 0");
                System.out.println("________________________________________");
            } else if (number >= 0 & number <= 10000) {
                while (number != 0) {
                    int temp = number % 16;
                    if (temp == 10) {
                        result.append("A");
                    } else if (temp == 11) {
                        result.append("B");
                    } else if (temp == 12) {
                        result.append("C");
                    } else if (temp == 13) {
                        result.append("D");
                    } else if (temp == 14) {
                        result.append("E");
                    } else if (temp == 15) {
                        result.append("F");
                    } else {
                        result.append(temp);
                    }
                    number /= 16;
                }
                System.out.println("Результат конвертации: " + result.reverse());
                System.out.println("________________________________________");
            } else {
                System.out.println("Некоректный ввод");
                System.out.println("________________");
            }
        } catch (NumberFormatException e) {
            System.out.println("Некоректный ввод");
            System.out.println("________________");
        }
    }

    public static void toBinary() throws IOException {
        System.out.println("Введите целое число от 0 до 10000");
        int number;
        try {
            number = Integer.parseInt(bufferedReader.readLine().trim());
            if (number == 0) {
                System.out.println("Результат конвертации: 0");
                System.out.println("________________________________________");
            } else if (number >= 0 & number <= 10000) {
                StringBuilder result = new StringBuilder();
                while (number != 0) {
                    result.append(number % 2);
                    number /= 2;
                }
                System.out.println("Результат конвертации: " + result.reverse());
                System.out.println("________________________________________");
            } else {
                System.out.println("Некоректный ввод");
                System.out.println("________________");
            }

        } catch (NumberFormatException e) {
            System.out.println("Некоректный ввод");
            System.out.println("________________");
        }
    }

    public static void toDecimal() throws IOException {
        System.out.println("Введите число в двоичной системе счисления");
        String number = bufferedReader.readLine().trim();
        if (number.matches("[01]+")) {
            long result = 0;
            for (int i = 0; i < number.length(); i++) {
                result += (long) Math.pow(2, number.length() - i - 1) * Integer.parseInt(String.valueOf(number.charAt(i)));
            }
            System.out.println("Результат конвертации: " + result);
            System.out.println("________________________________________");
        } else {
            System.out.println("Некоректный ввод");
            System.out.println("________________");
        }
    }
}

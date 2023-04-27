package qa.dmikhaylov.tasks;

import java.util.Scanner;

import static java.lang.Math.sqrt;

/*
    Написать программу, вычисляющую корни квадратного уравнения вида
    ax ² + bx + c = 0, где a, b и c - целочисленные параметры функции run.

    Вывести корни квадратного уравнения на консоль.
    Если их два, то перечислить каждый с новой строки в консоли (просто использовать два раза System.out.println).
    Если дискриминант отрицательный, вывести на консоль сообщение "нет корней".
    При решении создать и использовать следующие функции:
    - функция isPositive, определяющая, является ли число положительным
    - функция isZero, определяющая, является ли число нулём
    - функция discriminant, вычисляющая дискриминант
    Обращайте внимание, что параметры все целочисленные, а корни могут иметь дробную часть.
 */
public class Task2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите значения аргументов a, b и c:");
        run(scanner.nextInt(), scanner.nextInt(), scanner.nextInt());
    }

    public static void run(int a, int b, int c) {
        int descr = discriminant(a, b, c);
        if (descr == 0) {
            isZero(a, b);
        } else if (descr > 0) {
            isPositive(a, b, descr);
        } else {
            System.out.println("нет корней");
        }
    }

    public static void isPositive(int a, int b, int descr) {
        System.out.println("x1: " + ((-b + sqrt(descr)) / (2 * a)));
        System.out.println("x2: " + ((-b - sqrt(descr)) / (2 * a)));
    }

    public static void isZero(int a, int b) {
        System.out.println("x: " + ((-b + sqrt(0)) / (2 * a)));
    }

    public static int discriminant(int a, int b, int c) {
        return b * b - 4 * a * c;
    }
}

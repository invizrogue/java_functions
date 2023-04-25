package qa.dmikhaylov.tasks;

import java.util.Scanner;

/*
    Имеются трм числа - день, месяц и год, вводимые пользователем с консоли.
    Вывести дату следующего дня в формате "День.Месяц.Год".
    Учесть переход на следующий месяц, а также следующий год.
    Форматирование строки "День.Месяц.Год" вынести в отдельную функцию.
 */
public class Task1 {
    public static void main(String[] args) {
//        int day = 29;
//        int month = 2;
//        int year = 1980;
        Scanner scanner = new Scanner(System.in);
        int day = scanner.nextInt();
        int month = scanner.nextInt();
        int year = scanner.nextInt();

        int maxDays = getMaxMonthDays(month, year);
        if (!(day <= maxDays && day >= 1)) System.out.println("Переданы неверные начальные параметры");
        else {
            System.out.println(getNextDate(day, month, year, maxDays));
        }
    }

    public static String getNextDate(int day, int month, int year, int maxDays) {
        if (++day > maxDays) {
            day = 1;
            month++;
        }
        if (month == 13) {
            month = 1;
            year++;
        }
        return stringify(day) + "." + stringify(month) + "." + year;
    }

    public static String stringify(int value) {
        return value > 9 ? "" + value : "0" + value;
    }

    public static int getMaxMonthDays(int month, int year) {
        boolean isLeapYear = (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
        return switch (month) {
            case 1, 3, 5, 7, 8, 10, 12 -> 31;
            case 4, 6, 9, 11 -> 30;
            case 2 -> isLeapYear ? 29 : 28;
            default -> 0;
        };
    }
}

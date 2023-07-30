package aaagt.creational.logger;


import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Logger logger = Logger.getInstance();

        logger.log("Просим пользователя ввести входные данные для списка");
        int limit = requestIntNumber("Введите размер списка: ");
        int top = requestIntNumber("Введите верхнюю границу для значений: ");

        logger.log("Создаём и наполняем список");
        Random random = new Random();
        List<Integer> nums = random
                .ints(0, top)
                .limit(limit)
                .boxed()
                .toList();

        logger.log("Просим пользователя ввести входные данные для списка");
        int treshold = requestIntNumber("Введите порог для фильтра: ");

        logger.log("Запускаем фильтрацию");
        Filter filter = new Filter(treshold);
        List<Integer> result = filter.filterOut(nums);

        logger.log("Выводим результат на экран");
        String resultReport = result
                .stream()
                .map(String::valueOf)
                .collect(Collectors.joining(" "));
        logger.log("Отфильтрованный список: " + resultReport);

        logger.log("Завершаем программу");
    }


    private static int requestIntNumber(String message) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(message);
        return Integer.parseInt(scanner.nextLine());
    }
}

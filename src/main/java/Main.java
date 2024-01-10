import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Calculator calculator = new Calculator();

        int numberOfPeople = 0;
        boolean isValidNumberOfPeople = false;

        while (!isValidNumberOfPeople) {
            try {
                System.out.println("Количество людей в компании?");
                numberOfPeople = Integer.parseInt(scanner.nextLine());

                if (numberOfPeople > 1) {
                    isValidNumberOfPeople = true;
                } else {
                    System.out.println("Введите число больше 1.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Ошибка ввода. Введите корректное количество людей.");
            }
        }

        String productName;

        while (true) {
            System.out.println("Добавьте название товара (или введите 'завершить' для завершения):");
            productName = scanner.nextLine();

            if (productName.equalsIgnoreCase("завершить")) {
                break;
            }

            double productPrice = 0;
            boolean isValidPrice = false;

            while (!isValidPrice) {
                try {
                    System.out.println("Укажите стоимость товара:");
                    productPrice = Double.parseDouble(scanner.nextLine());

                    if (productPrice >= 0) {
                        isValidPrice = true;
                    } else {
                        System.out.println("Стоимость не может быть отрицательной!");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Ошибка ввода. Введите корректную стоимость товара.");
                }
            }

            calculator.addProduct(productName, productPrice);
        }

        System.out.println("Добавленные товары:");
        for (Map.Entry<String, Double> entry : calculator.getProducts().entrySet()) {
            String formattedPrice = Formatter.formatPrice(entry.getValue());
            System.out.println(entry.getKey() + ": " + formattedPrice + " " + Formatter.rublesDeclension(entry.getValue()));
        }

        String formattedTotalCost = Formatter.formatPrice(calculator.calculateTotalCost());
        System.out.println("Общая стоимость: " + formattedTotalCost + " " + Formatter.rublesDeclension(calculator.calculateTotalCost()));

        String formattedCostPerPerson = Formatter.formatPrice(calculator.calculateCostPerPerson(numberOfPeople));
        System.out.println("Каждый человек должен заплатить: " + formattedCostPerPerson + " " + Formatter.rublesDeclension(calculator.calculateCostPerPerson(numberOfPeople)));
    }
}
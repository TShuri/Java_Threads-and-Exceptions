import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Menu {
    private static MyIntList myIntList;
    private static Scanner scanner = new Scanner(System.in);
    private static String fileName;

    private static int inputSelect(int level) { // Функция проверки корректного ввода команды меню
        System.out.print("->".repeat(level) + " ");
        int _select = -1;
        try {
            _select = Integer.parseInt(scanner.nextLine());
        }
        catch (NumberFormatException ex) {
            System.out.println("Ошибка! Вводите только значения из пунктов меню");
            _select = inputSelect(level);
        }
        return _select;
    }
    private static int inputNumb(int level) { // Функция проверки корректного ввода числа для заданий A и B
        System.out.print("->".repeat(level) + " ");
        int _numb = -1;
        try {
            _numb = Integer.parseInt(scanner.nextLine());
        }
        catch (NumberFormatException ex) {
            System.out.println("Ошибка! Вводите только число");
            _numb = inputNumb(level);
        }
        return _numb;
    }
    private static String inputStrList(int level) { // Функция проверки корректного ввода списка
        System.out.print("->".repeat(level) + " ");
        String _strList = new String(scanner.nextLine());
        try {
            for (String item : _strList.split(" ")) {
                Integer.parseInt(item);
            }
        } catch (NumberFormatException ex) {
            System.out.println("Вводите список чисел через пробел!");
            _strList = inputStrList(level);
        }
        return _strList;
    }
    private static String inputFileName(int level) { // Функция ввода имени названия файла
        System.out.print("->".repeat(level) + " ");
        String _fileName = new String(scanner.nextLine());
        return _fileName;
    }
    private static List<Integer> toList(int level, String _strList) { // Функция создания списка из строки
        List<Integer> _list = new ArrayList<Integer>();
        for (String item : _strList.split(" ")) {
            _list.add(Integer.parseInt(item));
        }
        return _list;
    }
    public static void mainMenu() { // Главное меню
        int select = -1;
        do {
            try {
                System.out.println("-> Главное меню");
                System.out.println("-> 1 - Создать новый список");
                System.out.println("-> 2 - Вывести список");
                System.out.println("-> 3 - Сохранить список в файл");
                System.out.println("-> 4 - Выполнить задания");
                System.out.println("-> 0 - Выход из программы");
                select = inputSelect(1);
                switch (select) {
                    case 1:
                        inputListMenu();
                        break;
                    case 2:
                        myIntList.printList();
                        break;
                    case 3:
                        System.out.println("->-> Введите название файла");
                        fileName = inputFileName(2);
                        FileManager.saveToFile(myIntList, fileName);
                        break;
                    case 4:
                        taskMenu();
                        break;
                    case 0:
                        break;
                    default:
                        System.out.println("Нет такого пункта меню");
                }
            } catch (NullPointerException ex) {
                System.out.println("Сначала необходимо создать список!");
            }
        } while (select != 0);
    }
    private static void inputListMenu() { // Меню ввода списка
        int select = -1;
        String strList;
        List<Integer> list;
        do {
            try {
                System.out.println("->-> Меню ввода списка");
                System.out.println("->-> 1 - Автоматическая генерация списка");
                System.out.println("->-> 2 - Прочитать список с файла");
                System.out.println("->-> 3 - Ручной ввод");
                System.out.println("->-> 0 - Назад");
                select = inputSelect(2);
                switch (select) {
                    case 1:
                        myIntList = new MyIntList();
                        break;
                    case 2:
                        System.out.println("->->-> Введите название файла");
                        fileName = inputFileName(3);
                        list = FileManager.loadFromFile(fileName);
                        if (list != null) {
                            myIntList = new MyIntList(list);
                        }
                        break;
                    case 3:
                        System.out.println("->->-> Ручной ввод");
                        System.out.println("->->-> Вводите числа через пробел");
                        strList = inputStrList(3);
                        list = toList(3, strList);
                        myIntList = new MyIntList(list);
                        break;
                    case 0:
                        break;
                    default:
                        System.out.println("Нет такого пункта меню");
                }
            } catch (NewException ex) {
                System.out.println("Не получится создать список из одного числа");
            }
        } while (select != 0);
    }
    private static void taskMenu() { // Меню выбора задания
        int select = -1;
        do {
            System.out.println("->-> Меню выбора задания");
            System.out.println("->-> 1 - Задание A (Вывод чисел больше/меньше чем X)");
            System.out.println("->-> 2 - Задание B (Есть ли в списке число равное/неравное X)");
            System.out.println("->-> 3 - Задание C (Удалить дубликаты чисел)");
            System.out.println("->-> 4 - Задание D (Проверка упорядоченности списка)");
            System.out.println("->-> 0 - Назад");
            select = inputSelect(2);
            switch (select) {
                case 1:
                    menuForTaskA();
                    break;
                case 2:
                    menuForTaskB();
                    break;
                case 3:
                    Logic.removeDuplicates(myIntList);
                    break;
                case 4:
                    Logic.order(myIntList);
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Нет такого пункта меню");
            }
        } while (select != 0);
    }
    private static void menuForTaskA() { // Меню для задания A
        int select = -1;
        int numb = 0;
        do {
            System.out.println("->->-> Задание А");
            System.out.println("->->-> 1 - Вывод чисел больше чем (>0)");
            System.out.println("->->-> 2 - Вывод чисел меньше чем (<10)\"");
            System.out.println("->->-> 0 - Назад");
            select = inputSelect(3);
            switch (select) {
                case 1:
                    System.out.println("->->->-> Введите число");
                    numb = inputNumb(4);
                    Logic.compare(myIntList, ">", numb);
                    break;
                case 2:
                    System.out.println("->->->-> Введите число");
                    numb = inputNumb(4);
                    Logic.compare(myIntList, "<", numb);
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Нет такого пункта меню");
            }
        } while (select != 0);
    }
    private static void menuForTaskB() { // Меню для задания B
        int select = -1;
        int numb = 0;
        do {
            System.out.println("->->-> Задание B");
            System.out.println("->->-> 1 - Есть ли в списке число равное(=0)");
            System.out.println("->->-> 2 - Есть ли в списке число неравное(!=0)");
            System.out.println("->->-> 0 - Назад");
            select = inputSelect(3);
            switch (select) {
                case 1:
                    System.out.println("->->->-> Введите число");
                    numb = inputNumb(4);
                    Logic.equals(myIntList, "=", numb);
                    break;
                case 2:
                    System.out.println("->->->-> Введите число");
                    numb = inputNumb(4);
                    Logic.equals(myIntList, "!=", numb);
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Нет такого пункта меню");
            }
        } while (select != 0);
    }
}

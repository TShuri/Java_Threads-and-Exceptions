import java.util.*;

public class Logic {
    static private List<Integer> utility = new ArrayList<Integer>(); // Дополнительный список для вывода

    public static void compare(MyIntList _myIntList, String condition, int numb) { // Функция сравнения (Задание a)
        for (int x : _myIntList.list){ // Проход по списку чисел
            if (((condition.startsWith(">")) && (x > numb)) || ((condition.startsWith("<")) && (x < numb))) {
                utility.add(x); // Если элемент списка удовлетворяет условию, то добавляется в доп список
            }
        }
        if (utility.size() == 0) {
            System.out.println("Answer: Нет чисел удовлетворяющих условию");
        } else {
            System.out.print("Answer: ");
            for (var x : utility) { // Вывод списка чисел удовлетворяющих условию
                System.out.print(x + " ");
            }
            System.out.println(); // Переход на следующую строку консоли
        }
        utility.clear();
    }
    public static void equals(MyIntList _myIntList, String condition, int numb) { // Задание b
        boolean equal = true; // Переменная-флаг для определения условия сравнения
        if (condition.equals("!=")) {
            equal = false;
        }
        for (int x : _myIntList.list) {
            if ( ( (equal == true) && (x == numb) ) || ( (equal == false) && (x != numb) ) ) {
                System.out.println("Answer: В массиве есть такое число");
                return;
            }
        }
        System.out.println("Answer: В массиве нет такого числа");
    }
    public static void removeDuplicates(MyIntList _myIntList) { // Задание c
        for (int x : _myIntList.list) { // Цикл добавления чисел из массива в список
            if (utility.contains(x) == false) { // Если числа нет в списке, то добавляем его
                utility.add(x);
                System.out.print(x + " "); // Вывод списка чисел удовлетворяющих условию
            }
        }
        System.out.println();
        utility.clear();
    }
    public static void order(MyIntList _myIntList) { // Задание d
        utility.addAll(_myIntList.list); // Добавляем все элементы из нашего списка в вспомогательный
        Collections.sort(utility); // Сортируем по возрастанию вспомогательный список
        if (utility.equals(_myIntList.list)) { // Если списки равны
            System.out.println("Answer: Список упорядочен по возрастанию");
            utility.clear();
            return;
        }
        Collections.reverse(utility);
        if (utility.equals(_myIntList.list)) { // Если списки равны
            System.out.println("Answer: Список упорядочен по убыванию");
            utility.clear();
            return;
        }
        System.out.println("Answer: Список не упорядочен");
        utility.clear();
    }
}
import java.util.ArrayList;
import java.util.List;

public class MyIntList {
    public int size;
    public List<Integer> list;

    public MyIntList() { // Конструктор по умолчанию - Автоматическая генерация списка чисел
        this.size = 10;
        this.list = new ArrayList<Integer>();
        for (int i = 0; i < size; i++) {
            list.add((int) (Math.random() * 10) + 1);
        }
        printList();
    }
    public MyIntList(List<Integer> parList) throws NewException { // Конструктор с параметром - Ручной ввод чисел
        this.size = parList.size();
        this.list = new ArrayList<Integer>();
        for (int item : parList) {
            list.add(item);
        }
        if (size == 1) { // Не даем пользователю ввести список только из одного числа
            throw new NewException("Список состоит только из одного числа!");
        }
        printList();
    }
    public MyIntList(MyIntList other) { // Конструктор клонирования
        this.size = other.size;
        this.list = new ArrayList<Integer>(other.getList());
    }
    public void printList() { // Функция вывода списка
        System.out.print("Len: " + size + " List: ");
        for (int x : this.list) {
            System.out.print(x + " ");
        }
        System.out.println();
    }
    private List<Integer> getList() {
        return list;
    } // Функция возвращения списка
}



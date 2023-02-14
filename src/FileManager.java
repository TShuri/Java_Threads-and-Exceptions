import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileManager {
    public static void saveToFile(MyIntList _myIntList, String fileName) { // Функция сохранения в файл
        if (_myIntList instanceof MyIntList) { // Если список не создан, то не и файл не будет создан
            try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(fileName))) {
                dos.writeInt(_myIntList.size);
                for (int item : _myIntList.list) {
                    dos.writeInt(item);
                }
                System.out.println("Список успешно сохранен в файл: " + fileName);
            } catch (FileNotFoundException e) {
                System.out.println("Ошибка сохранения! Нельзя сохранить в файл с указанным именем");
            } catch (IOException e) {
                System.out.println("Ошибка записи в файл!");
            }
        } else {
            System.out.println("Ошибка сохранения! Список не создан");
        }
    }

    public static List<Integer> loadFromFile(String fileName) { // Функция чтения из файла
        List<Integer> _list = null;
        try (DataInputStream dis = new DataInputStream(new FileInputStream(fileName))) {
            int _size = dis.readInt();
            _list = new ArrayList<Integer>();
            for (int i = 0; i < _size; i++) {
                _list.add(dis.readInt());
            }
        } catch (FileNotFoundException e) {
            System.out.println("Ошибка чтения! Не существует файл с указанным именем");
        } catch (IOException e) {
            System.out.println("Ошибка чтения из файла!");
        }
        return _list;
    }
}

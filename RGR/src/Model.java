import java.io.*;
import java.time.MonthDay;
import java.util.*;

public class Model {

        public static List<String> getValueFromCache(Map<MonthDay, List<String>> cache, java.time.Month month, int day) {
            MonthDay key = MonthDay.of(month, day);
            List<String> values = new ArrayList<>();//создаем пустой лист, которые вернут в люьм случае
            if (cache.containsKey(key)) {
                values = cache.get(key);
              //  System.out.println("Значения для " + key + ": " + values);

            } else {
                System.out.println("Для " + key + " нет значений в кэше.");

            }
            return values;
        }
        public static void writeHashToFile(String filename, Map<MonthDay, List<String>> hashMap) throws IOException {
            FileOutputStream fileOut = new FileOutputStream(filename);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);

            // Запись хэша в файл
            out.writeObject(hashMap);

            out.close();
            fileOut.close();
            System.out.println("Сохранено");
        }
        public static void readHashFromFile(String filename, Map<MonthDay, List<String>> hashMap) throws IOException, ClassNotFoundException {
            FileInputStream fileIn = new FileInputStream(filename);
            ObjectInputStream in = new ObjectInputStream(fileIn);

            // Считывание хэша из файла
            Map<MonthDay, List<String>> data = (Map<MonthDay, List<String>>) in.readObject();
            hashMap.putAll(data);

            in.close();
            fileIn.close();
        }


        static Map<MonthDay, List<String>> hashMap = new HashMap<>();
        public Model() {


            try {
                readHashFromFile("hash_file.dat",hashMap);
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }


        }

}





package Task_01;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
В методе main считать с консоли имя файла, который содержит слова, разделенные пробелом.
В методе getLine используя StringBuilder расставь все слова в таком порядке, чтобы последняя буква данного слова совпадала с первой буквой следующего не учитывая регистр.
Каждое слово должно участвовать 1 раз.
Считай, что абсолютно все слова из исходного списка могут (и должны!) быть включены в результат (лишних слов нет).
Метод getLine должен возвращать любой правильный вариант при наличии нескольких таковых (см. пример).
Слова разделять пробелом.
Вывести полученную строку на экран.

Пример тела входного файла:
Киев Нью-Йорк Амстердам Вена Мельбурн

Результат:
Амстердам Мельбурн Нью-Йорк Киев Вена
или
Вена Амстердам Мельбурн Нью-Йорк Киев
или
Мельбурн Нью-Йорк Киев Вена Амстердам
и т.п.
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader reader = new BufferedReader(new FileReader(read.readLine()));
        String[] strings = reader.readLine().split(" ");
        StringBuilder result = getLine(strings);
        System.out.println(result.toString());
        read.close();
        reader.close();
    }

    public static StringBuilder getLine(String[] words) {
        StringBuilder nullresult = new StringBuilder("");
        if (words == null || words.length == 0)
            return nullresult;
        int countlist = 0;
        StringBuilder result = new StringBuilder();
        List<String> list = new ArrayList<>();
        for (int i = 0; i < words.length; i++)
            list.add(words[i]);
        while (true) {
            Collections.shuffle(list);
            for (int i = 0; i < list.size() - 1; i++) {
                String string1 = list.get(i).substring(list.get(i).length() - 1);
                //  System.out.print(string1);
                String string2 = list.get(i + 1).substring(0, 1);
                //  System.out.print(string2);
                if (string1.equalsIgnoreCase(string2)) {
                    countlist++;
                }
            }
            //  System.out.println(" " + countlist);
            if (countlist + 1 == list.size())
                break;
            else
                countlist = 0;
        }
        for (String string : list)
            result.append(string + " ");

        String sder = result.toString().trim();
        result = new StringBuilder(sder);
        return result;
    }
}

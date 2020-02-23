# JavaTasks
---
# Task01
--
Программа сортировки слов.
В методе main считывается с консоли имя файла, который содержит слова, разделенные пробелом (любой txt файл с вашим набором слов).
В методе getLine используя StringBuilder расставляются все слова в таком порядке, чтобы последняя буква данного слова совпадала с первой буквой следующего не учитывая регистр.
Каждое слово должно участвовать 1 раз.
Считается, что абсолютно все слова из исходного списка могут (и должны!) быть включены в результат (лишних слов нет).
Метод getLine возвращает любой правильный вариант при наличии нескольких таковых (см. пример).
Слова разделяются пробелом.
Полученная строка выводится на экран.

Пример тела входного файла:
Киев Нью-Йорк Амстердам Вена Мельбурн

Результат:
Амстердам Мельбурн Нью-Йорк Киев Вена
или
Вена Амстердам Мельбурн Нью-Йорк Киев
или
Мельбурн Нью-Йорк Киев Вена Амстердам
и т.п.
------

# Task02
Задача на применение анонимных классов

1. Требуется восстановить логику метода someAction для поля solutionAction.
2. Пример вывода:
     * 5
     * 4
     * 3
     * 2
     * 1
     * class FirstClass, method someAction
     * class SecondClass, method someAction
     * Specific action for anonymous SecondClass, param = 0
     * Count of created Action objects is 2
     * class SecondClass, method someAction
     * Specific action for anonymous SecondClass, param = -1
     * Count of created Action objects is 3

3. Подсказка: метод someAction анонимного класса поля solutionAction должен вызвать метод сабкласса FirstClass, если param > 0, иначе вызвать метод сабкласса SecondClass.
-----

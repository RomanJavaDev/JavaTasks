package Task_03;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Solution {
    public static class CustomizedComparator<T> implements Comparator<T> {
        private Comparator<T>[] comparators;

        public CustomizedComparator(Comparator...comparators) {
            this.comparators = comparators;
        }
        @Override
        public int compare(T o1, T o2) {
            int result = 0;
            for (Comparator comparator : comparators) {
                result = comparator.compare(o1, o2);
                if (result != 0) {
                    break;
                }
            }
            return result;
        }
    }

    public static void main(String[] args) {
        ArrayList<Human> humans = new ArrayList<>();
        humans.add(new Human("Анатолий Булкин", 90, 123));
        humans.add(new Human("Анатолий Булкин", 90,124));
        humans.add(new Human("Анатолий Вассерман",  77,122));
        humans.add(new Human("Анатолий Вассерман",  76,122));
        humans.add(new Human("Бешкек Абдурасул", 6,120));
        humans.add(new Human("Анатолий Вассерман",  64,160));
        humans.add(new Human("Василий Теркин", 7,111));
        humans.add(new Human("Василий Теркин", 7,114));

        Comparator<Human> nameComparator = new Comparator<Human>() {
            @Override
            public int compare(Human o1, Human o2) {
                return o1.name.compareTo(o2.name);
            }
        };
        Comparator<Human> ageComparator = new Comparator<Human>() {
            @Override
            public int compare(Human o1, Human o2) {
                return o1.age - o2.age;
            }
        };
        Comparator<Human> IQComparator = new Comparator<Human>() {
            @Override
            public int compare(Human o1, Human o2) {
                return o1.IQ - o2.IQ;
            }
        };
        Collections.sort(humans, new CustomizedComparator(nameComparator, ageComparator, IQComparator));
        for (int i = 0; i < humans.size(); i++) {
            System.out.println(humans.get(i).name + " " + humans.get(i).age + " " + humans.get(i).IQ);
        }
    }
    public static class Human {
        public String name;
        public int age;
        public int IQ;

        public Human(String name, int age, int IQ) {
            this.name = name;
            this.age = age;
            this.IQ = IQ;
        }
    }
}

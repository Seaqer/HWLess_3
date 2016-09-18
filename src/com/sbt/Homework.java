package com.sbt;

import java.util.*;

/**
 * Created by Артём on 18.09.2016.
 */
public class Homework {


    private final String TEXT = "Dynamic arrays benefit from many of the advantages of arrays, including good \n" +
            "locality of reference and data cache utilization, compactness (low memory use), and random access. They usually have only a small fixed additional overhead for storing information about the \n" +
            "size and capacity. This makes dynamic arrays an attractive tool for building cache-friendly data structures. However, in languages like Python or Java that enforce reference semantics, the \n" +
            "dynamic array generally will not store the actual data, but rather it will store references to the data that resides in other areas of memory. ";


    /**
     * Task №1
     * Выводит количество различных слов в файле.
     */
    public void getAllWords() {
        String[] words = TEXT.split("[^\\w-]+");
        HashSet<String> notRepeatedWords = new HashSet<>(Arrays.asList(words));

        System.out.println(notRepeatedWords.size());
    }

    /**
     * Task №2
     * Выводит на экран список различных слов файла, отсортированный по возрастанию их длины.
     */
    public void getSortedWords() {
        String[] words = TEXT.split("[^\\w-]+");
        TreeSet<String> sortWords = new TreeSet<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() == o2.length())
                    return o1.compareTo(o2);
                else if (o1.length() > o2.length())
                    return 1;
                else
                    return -1;
            }
        });

        sortWords.addAll(Arrays.asList(words));
        for (String word : sortWords) System.out.println(word);
    }

    /**
     * Task №3
     * Выводит на экран сколько раз каждое слово встречается в файле.
     */
    public void getNumberWords() {
        String[] words = TEXT.split("\\W+");
        Map<String, Integer> numberWords = new HashMap<String, Integer>();

        for (String word : words) {
            if (numberWords.containsKey(word)) {
                int count = numberWords.get(word);
                numberWords.put(word, ++count);
            } else {
                numberWords.put(word, 1);
            }
        }

        for (Map.Entry<String, Integer> entry : numberWords.entrySet()) {
            System.out.printf("%s - %d раз\n", entry.getKey(), entry.getValue());
        }
    }

    /**
     * Task №4
     * Выводит на экран все строки в обратном порядке.
     */
    public void getReversLines() {
        ArrayList<String> lines = new ArrayList<>(Arrays.asList(TEXT.split("\n")));
        ListIterator<String> iterator = lines.listIterator(lines.size());

        while (iterator.hasPrevious()) {
            System.out.println(iterator.previous());
        }
    }

    /**
     * Task №5
     */
    public void getIterator() {
        ArrayList<String> lines = new ArrayList<>(Arrays.asList(TEXT.split("\n")));
        Iterator<String> iterator = new ArrayListIterator(lines);

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    /**
     * Task №6
     * Выводит на экран строки, номера которых задаются пользователем в произвольном порядке.
     */
    public void showLines(String[] lineNumbers) {
        ArrayList<String> lines = new ArrayList<>(Arrays.asList(TEXT.split("\n")));

        for (String numberLine : lineNumbers) {
            int number = Integer.parseInt(numberLine);
            if (number < 1 || number > lines.size()) throw new NoSuchElementException(numberLine);
            System.out.println(lines.get(number - 1));
        }
    }

    /**
     * Iterator ArrayList<String>
     */
    private class ArrayListIterator implements Iterator<String> {
        private ArrayList<String> array;
        private int cursor;
        private int expectedModCount;


        public ArrayListIterator(ArrayList<String> array) {
            this.array = array;
            cursor = array.size();
            expectedModCount = array.size();
        }

        public String next() {
            cursor--;

            if (array.size() != expectedModCount) {
                throw new ConcurrentModificationException();
            }
            if (cursor < 0) {
                throw new NoSuchElementException();
            }
            return array.get(cursor);
        }

        public boolean hasNext() {
            return cursor > 0;
        }
    }
}

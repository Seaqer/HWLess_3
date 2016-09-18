package com.sbt;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner inConsole = new Scanner(System.in);
        Homework myHW = new Homework();

        while (true) {
            System.out.println("Номер задания 1-6: ");
            switch (Integer.parseInt(inConsole.nextLine())) {
                case 1:
                    myHW.getAllWords();
                    break;
                case 2:
                    myHW.getSortedWords();
                    break;
                case 3:
                    myHW.getNumberWords();
                    break;
                case 4:
                    myHW.getReversLines();
                    break;
                case 5:
                    myHW.getIterator();
                    break;
                case 6:
                    System.out.println("Введите строки: ");
                    String[] str = inConsole.nextLine().split("\\D+");
                    myHW.showLines(str);
                    break;
                default:
                    return;

            }
        }
    }
}


package com.example.dictionarytest;
import java.util.Scanner;

public class denemeKismi {
    private static final dictionaryEng engDictionary = new dictionaryEng();
    private static final dictionaryFra fraDictionary = new dictionaryFra();
    private static final dictionaryTur turDictionary = new dictionaryTur();
    private static final dictionaryEll ellDictionary = new dictionaryEll();
    private static final dictionarySwe sweDictionary = new dictionarySwe();
    private static final dictionaryDeu deuDictionary = new dictionaryDeu();
    private static final dictionaryIta itaDictionary = new dictionaryIta();

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String tryWord = input.next().toLowerCase();
        char firstLetter = tryWord.charAt(0);
        int alphabet = (char) ((int) firstLetter);
        System.out.println(alphabet);

        long startTime = System.nanoTime();

        Thread queryThread = new Thread(() -> {
            if (97 <= alphabet && alphabet <= 122) {
                System.out.println(turDictionary.isItTurkish(tryWord));
                System.out.println("-----------------------------------------------------------------");
                System.out.println(engDictionary.isItEnglish(tryWord));
                System.out.println("-----------------------------------------------------------------");
                System.out.println(fraDictionary.isItFrench(tryWord));
                System.out.println("-----------------------------------------------------------------");
                System.out.println(sweDictionary.isItSwedish(tryWord));
                System.out.println("-----------------------------------------------------------------");
                System.out.println(deuDictionary.isItDeutsch(tryWord));
                System.out.println("-----------------------------------------------------------------");
                System.out.println(itaDictionary.isItItalian(tryWord));
                System.out.println("-----------------------------------------------------------------");
            } else {
                System.out.println(turDictionary.isItTurkish(tryWord));
                System.out.println("-----------------------------------------------------------------");
                System.out.println(ellDictionary.isItGreek(tryWord));
                System.out.println("-----------------------------------------------------------------");
                System.out.println(sweDictionary.isItSwedish(tryWord));
                System.out.println("-----------------------------------------------------------------");
            }
        });

        queryThread.start();

        try {
            queryThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        long endTime = System.nanoTime();
        long durationMillis = (endTime - startTime) / 1000000;
        double durationSeconds = durationMillis / 1000.0;
        System.out.println("Working time: " + durationMillis + " milisecond");
        System.out.println("Working time: " + durationSeconds + " second");
    }
}

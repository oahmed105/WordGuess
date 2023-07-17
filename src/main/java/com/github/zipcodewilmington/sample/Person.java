package com.github.zipcodewilmington.sample;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Person {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random rand = new Random();
        ArrayList<Character> playerGuesses = new ArrayList<>();
        ArrayList<String> words = new ArrayList<>(Arrays.asList("excuse", "facade", "recording", "useful", "case",
                "fist", "remark", "blast", "bomb", "pardon"));

        public static void playGame() {

            String word = words.get(rand.nextInt(words.size()));
            System.out.println("Let's Play Hangman!");
            System.out.println(word);

            printWordState(word, playerGuesses);

            while (true) {
                if (!getPlayerGuess(scanner, word, playerGuesses)) {
                    wrongCount--;
                }
                if (wrongCount >= 6) {
                    System.out.println("You Lose!");
                    break;
                }

                if (printWordState(word, playerGuesses)) {
                    System.out.println("You Win!");
                    break;
                }

//            System.out.println("Please enter your word guess: ");
//            if (scanner.nextLine().equals(word)) {
//                System.out.println("You Win!");
//                break;
//            }
            }
        }
    }

    public static boolean printWordState(String word, ArrayList<Character> playerGuesses) {
        int count = 0;
        for (int i = 0; i < word.length(); i++) {
            if (playerGuesses.contains(word.charAt(i))) {
                System.out.print(word.charAt(i));
                count++;
            }
            else {
                System.out.print("-");
            }
        }
        System.out.println();
        return (word.length() == count);
    }

    public static boolean getPlayerGuess(Scanner scanner, String word, ArrayList<Character> playerGuesses) {
        System.out.println("Please enter a letter: ");
        String letterGuess = scanner.nextLine();
        playerGuesses.add(letterGuess.charAt(0));

        return word.contains(letterGuess);
    }

    public static void tries(String word) {
        int wordLength = word.length();

    }


}
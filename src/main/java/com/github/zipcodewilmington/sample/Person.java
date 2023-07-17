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

            String word = words.get(rand.nextInt(words.size()));
            System.out.println("Let's Play Hangman!");
            System.out.println(word);

            printWordState(word, playerGuesses);
            tries(word);

            while (true) {
                if (!getPlayerGuess(scanner, word, playerGuesses)) {


                }
                if (false) {
                    System.out.println("You Lose!");
                    break;
                }

                if (printWordState(word, playerGuesses)) {
                    System.out.println("You Win!");
//                    break;
                    System.out.println("Would you like to play again? yes/no");
                    String yesOrNo = scanner.nextLine();
                    if (yesOrNo == "yes") {
                        continue;
                    } else {
                        break;

                    }
                }

//            System.out.println("Please enter your word guess: ");
//            if (scanner.nextLine().equals(word)) {
//                System.out.println("You Win!");
//                break;
//            }
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

    public static int tries(String word) {
        int wordLength = word.length();
        System.out.println("You have " + wordLength + " guesses remaining");
        return wordLength--;
    }


}
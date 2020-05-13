package com.company;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        String[] languages = {"C", "C++", "C#", "Python", "Go", "Rust", "JavaScript", "PHP", "Swift", "Java"};
        System.out.println("Hello World");
        int controlCode;
        int n = (int) (Math.random() * 1_000_000);
        System.out.println(n);

        n *= 3;
        n = n + 0b10101;
        n = n + 0xFF;
        n *= 6;
        if (n % 9 != 0)
            controlCode = n % 9;
        else controlCode = 9;
        System.out.println(n);
        System.out.println(controlCode);
        System.out.println(n);
        System.out.println("Willy-nilly, this semester I will learn " + languages[controlCode]);


        //Validate arguments

        final int alphabetMaxSize = 256;
        int alphabetCounter = 0;
        char[] alphabet = new char[alphabetMaxSize];

        for (int i = 0; i < 2; i++) {
            boolean check = true;
            for (int j = 0; j < args[i].length(); j++) {
                if (checkDigit(args[i].charAt(j)) == false) {
                    check = false;
                    break;
                }
            }
            if (check == true) {
                System.out.println("Al " + i + " lea argument este valid\n");
            } else {
                System.out.println("Al " + i + " lea argument nu este valid\n");
            }
        }

        for (int i = 2; i < args.length; i++) {
            char character = args[i].charAt(0);
            int argumentLength = args[i].length();

            if (checkLetter(character) == true && argumentLength == 1) {
                System.out.println("Al " + i + " lea argument este valid\n");
                alphabet[alphabetCounter++] = character;
            } else {
                System.out.println("Al " + i + " lea argument nu este valid\n");
            }
        }

        System.out.println(alphabet);

        //create array of strings
        int numberOfWords = Integer.parseInt(args[0]);
        int numberOfLetters = Integer.parseInt(args[1]);
        System.out.println(numberOfWords + " " + numberOfLetters);
        String words[] = generate(numberOfWords, numberOfLetters, alphabetCounter, alphabet);

        for (String word : words) {
            System.out.println(word);
        }

        boolean neighbors[][] = new boolean[numberOfWords][numberOfWords];

        for (int i = 0; i < numberOfWords; i++) {
            for (int j = 0; j < numberOfWords; j++) {
                neighbors[i][j] = neighbor(words[i], words[j]);
            }
        }


        displayMatrix(numberOfWords, neighbors);
        displayMaxNeighbors(numberOfWords, neighbors);
        System.out.println(checkAllNeighbors(numberOfWords, neighbors));

        boolean viz[] = new boolean[numberOfWords];

        dfs(numberOfWords, neighbors, viz, 0);
        checkConnected(numberOfWords, viz);
        displayComponent(numberOfWords, viz, words);

        boolean exist = true;

        while (exist) {
            exist = false;
            boolean[] newViz = new boolean[numberOfWords];
            for (int i = 0; i < viz.length; i++) {
                if (viz[i] == false) {
                    dfs(numberOfWords, neighbors, newViz, i);
                    exist = true;
                    break;
                }
            }
            displayComponent(numberOfWords, newViz, words);
        }


    }

    public static boolean checkLetter(char c) {
        if (c >= 'a' && c <= 'z') return true;
        return false;
    }

    public static boolean checkDigit(char c) {
        if (c >= '0' && c <= '9') return true;
        return false;
    }

    public static String[] generate(int n, int k, int length, char[] alphabet) {
        String[] words = new String[n];

        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            int copyOfk = k;
            while (copyOfk > 0) {
                int position = (int) ((Math.random() * length) % 10);
                sb.append(alphabet[position]);
                copyOfk--;
            }
            words[i] = sb.toString();

        }

        return words;
    }

    public static boolean neighbor(String string1, String string2) {
        for (int i = 0; i < string1.length(); i++) {
            char c = string1.charAt(i);
            if (string2.indexOf(c) >= 0) return true;
        }
        return false;
    }

    public static void displayMatrix(int n, boolean[][] matrix) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void displayMaxNeighbors(int n, boolean[][] matrix) {
        int maxNeighbors = 0;
        for (int i = 0; i < n; i++) {
            int numberOfNeighbors = 0;
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == true)
                    numberOfNeighbors++;
            }
            if (maxNeighbors < numberOfNeighbors)
                maxNeighbors = numberOfNeighbors;
        }

        System.out.println(maxNeighbors);
    }

    public static boolean checkAllNeighbors(int n, boolean[][] matrix) {
        int numberOfNeighbors = 0;
        for (int j = 0; j < n; j++)
            if (matrix[0][j] == true)
                numberOfNeighbors++;
        for (int i = 1; i < n; i++) {
            int nr = 0;
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == true)
                    nr++;
            }
            if (nr != numberOfNeighbors) return false;
        }
        return true;
    }

    public static void dfs(int n, boolean[][] matrix, boolean[] viz, int currentNode) {
        viz[currentNode] = true;
        for (int i = 0; i < n; i++) {
            if (i == currentNode) continue;
            if (matrix[currentNode][i] == true && viz[i] == false) {
                viz[i] = true;
                dfs(n, matrix, viz, i);
            }
        }
    }

    public static void checkConnected(int n, boolean[] viz) {
        boolean check = true;
        for (int i = 0; i < n; i++) {
            if (viz[i] == false) {
                check = false;
                break;
            }
        }
        if (check == true)
            System.out.println("Connected");
        else System.out.println("Is not connected");
    }

    public static void displayComponent(int n, boolean[] viz, String[] words) {
        for (int i = 0; i < n; i++)
            if (viz[i] == true)
                System.out.print(words[i] + " ");
        System.out.println();
    }
}

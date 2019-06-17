package com.company;

public class TextResult {

    int totalNumberOfWords;
    int[] dictionary;

    public void print(){

        System.out.println("The total number of words is: " + totalNumberOfWords);
        System.out.println();
        for (int i = 1; i < dictionary.length; i++) {
            System.out.println("The total number of words of length " + i + " : " + dictionary[i]);
        }

    }

}

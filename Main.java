package com.fhw.TextTwist;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static int totalPoints(String[] words, String unscram){
        int score = 0;
        int letterCount = 0;
        int sixers = 0;

        // create array list from unscrambled string
        String[] splitString = unscram.split("");

        // loop through the array of answers
        for(int i=0; i<words.length; i++){
            // Create a list of letters of the unscrambled word
            ArrayList<String> strList = new ArrayList<String>(Arrays.asList(splitString));
            // split each answer into an array of its letters
            String[] letters = words[i].split("");
            // iterate over the array of letters
            for(int j=0; j< letters.length; j++){
                // check if the array list of the unscrambled word contains the letter
                if(strList.contains(letters[j])){
                    // If it does, remove the letter from the list and add to the letter count
                    strList.remove(letters[j]);
                    letterCount ++;
                }
            }
            // Check if the letter count is equal to the length of the answer
            if(letterCount == letters.length){
                // Add to the score based on the letterCount
                switch(letterCount){
                    case 3:
                        score += 1;
                        break;
                    case 4:
                        score += 2;
                        break;
                    case 5:
                        score += 3;
                        break;
                    case 6:
                        score += 4;
                        sixers ++;
                        if(sixers > 1){
                            score += 50;
                        }
                        if(words[i].equals(unscram)){
                            score += 50;
                        }
                        break;
                }

            }
            // Reset the letter count
            letterCount = 0;
        }

        return score;
    }

    public static void main(String[] args) {
	// write your code here

        System.out.println(totalPoints(new String[]{"cat", "create", "sat"}, "caster"));
        System.out.println(totalPoints(new String[]{"trance", "recant"}, "recant"));
        System.out.println(totalPoints(new String[]{"dote", "dotes", "toes", "set", "dot", "dots", "sted"}, "tossed"));

    }
}

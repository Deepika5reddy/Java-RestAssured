package Basics;

import java.util.Arrays;

public class ReverseWordsInSentence {



    public static void main(String args[])
    {
        String sentence = "hello I am Deepika" ;

        String[] words = sentence.split(" ");
        //System.out.println(Arrays.toString(words));

        StringBuilder reversedSentence = new StringBuilder();
        for (String word : words)
        {
            String reverseword = new StringBuilder(word).reverse().toString();
            reversedSentence.append(reverseword).append(" ");


        }
        System.out.println(reversedSentence.toString().trim());

    }
}

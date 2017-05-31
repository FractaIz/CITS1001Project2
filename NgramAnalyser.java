import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

import java.util.HashSet;
import java.util.Arrays;


import java.util.Map;
import java.util.Iterator;
/**
 * Perform n-gram analysis of a string.
 * 
 * Analyses the frequency with which distinct n-grams, of length n,
 * appear in an input string. For the purposes of all analyses of the input
 * string, the final n-1 n-grams appearing in the string should be
 * "filled out" to a length of n characters, by adding
 * a sequence of contiguous characters from the start of the string.
 * e.g. "abbc" includes "bca" and "cab" in its 3-grams
 * 
 * @author Tom Copcutt 22248715, Clayton Duncan
 * @version 30/5/2017
 */
public class NgramAnalyser
{
    /** dictionary of all distinct n-grams and their frequencies */
    private HashMap<String,Integer> ngram;

    /** number of distinct characters in the input */
    private int alphabetSize;

    /** n-gram size for this object (new field) */
    private int ngramSize;

    /** input length for this object (new field) */
    private int inputLength;

    /** 
     * Analyse the frequency with which distinct n-grams, of length n,
     * appear in an input string. 
     * n-grams at the end of the string wrap to the front
     * e.g. "abbbbc" includes "bca" and "cab" in its 3-grams
     * @param int n size of n-grams to create
     * @param String inp input string to be modelled
     */
    public NgramAnalyser(int n, String inp) {
        if(inp != null && inp != "" && n > 0 && n <= inp.length()) {
            this.ngramSize = n;
            this.inputLength = inp.length();
            this.ngram = new HashMap<>(inp.length(), inp.length());

            for (int i = 0; i < inp.length(); i++) { //loops through each character in inp
                    String currentNGram = ""; //new nGram starting at ith position
                    for (int j = i; j-i < n ; j++) { //starting from the ith character, loop n characters after this
                        currentNGram = currentNGram.concat(inp.substring(j%inp.length(), j%inp.length()+1)); //concatonates the jth char to currNGram
                    }
                    if (ngram.containsKey(currentNGram)) { //if the ngram exists, add one to its frequency
                        ngram.put(currentNGram, ngram.get(currentNGram) +1);
                    } else {
                        ngram.put(currentNGram, 1); //otherwise create a key for this ngram
                    }
            }
            
            //Prints the ngram
            Set set = ngram.entrySet();
            Iterator iterator = set.iterator();
            while(iterator.hasNext()) {
                Map.Entry mentry = (Map.Entry)iterator.next();
                System.out.print("key is: "+ mentry.getKey() + " & Value is: ");
                System.out.println(mentry.getValue());
            }

            //Alphabet size calculation
            if (n != 1) {
            NgramAnalyser alpha = new NgramAnalyser(inp);
            this.alphabetSize = alpha.getDistinctNgramCount(); //find alphabet size by getting number of distinct 1-grams 
            } else {
                this.alphabetSize = this.getDistinctNgramCount(); // 1-grams are simply a list of distinct characters, also bottoms recursion.
            }
        } else {
            throw new IllegalArgumentException("ngram size must be between 1 and the length of the input string. Input string must not be null or empty.");
        }
    }

    /** 
     * Analyses the input text for n-grams of size 1.
     */
    public NgramAnalyser(String inp) {
        this(1,inp);
    }

    /**
     * @return int the size of the alphabet of a given input
     */
    public int getAlphabetSize() {
        return alphabetSize;
    }

    /**
     * @return the total number of distinct n-grams appearing
     *         in the input text.
     */
    public int getDistinctNgramCount() {
        //TODO replace this line with your code
        return ngram.size();
    }

    /** 
     * @return Return a set containing all the distinct n-grams
     *         in the input string.
     */
    public Set<String> getDistinctNgrams() {
        //TODO replace this line with your code
        return ngram.keySet();
    }

    /**
     * @return the total number of n-grams appearing
     *         in the input text (not requiring them to be distinct)
     */
    public int getNgramCount() {
        //TODO replace this line with your code
        return this.inputLength;
    }

    /** Return the frequency with which a particular n-gram appears
     * in the text. If it does not appear at all, return 0.
     * 
     * @param ngram The n-gram to get the frequency of
     * @return The frequency with which the n-gram appears.
     */
    public int getNgramFrequency(String ngram) {
        //TODO replace this line with your code
        return this.ngram.get(ngram);
    }



    /**
     * Generate a summary of the ngrams for this object.
     * @return a string representation of the n-grams in the input text 
     * comprising the ngram size and then each ngram and its frequency
     * where ngrams are presented in alphabetical order.     
     */
    public String toString() {
        //TODO replace this line with your code
        return null;
    }

}

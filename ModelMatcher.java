import java.util.HashMap;
import java.util.Collection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

/**
 * Report the average log likelihood of a test String occuring in a 
 * given Markov model and detail the calculated values behind this statistic.
 * 
 * @author Tom Copcutt 22248715, Clayton Duncan
 * @version 30/5/2017
 */
public class ModelMatcher
{

    /** log likelihoods for a teststring under a given model */
    private HashMap<String,Double> logLikelihoodMap;
    /** summary statistic for this setting */
    private double averageLogLikelihood;  
        
    /**
     * Constructor to initialise the fields for the log likelihood map for 
     * a test string and a given Markov model and 
     * the average log likelihood summary statistic
     * @param MarkovModel model a given Markov model object
     * @param String teststring
     */
    public ModelMatcher(MarkovModel model, String testString) {
        //TODO 
        //MarkovModel model2 = new MarkovModel(model.getK(), testString);
        NgramAnalyser ngram = new NgramAnalyser(model.getK()+1, testString);
        String[] keys = ngram.getDistinctNgrams().toArray(new String[0]);
        //Arrays.sort(keys);
        logLikelihoodMap = new HashMap<>(ngram.getDistinctNgrams().size(), ngram.getDistinctNgrams().size());


        //System.out.println(ngram.getDistinctNgrams().size());
        for (int i  = 0; i < ngram.getDistinctNgrams().size(); i++) {
            double logEstimate = Math.log10(model.laplaceEstimate(keys[i]));
            logLikelihoodMap.put(keys[i], logEstimate*ngram.getNgramFrequency(keys[i]));
            //System.out.print(logEstimate + " ");
            //System.out.println(ngram.getNgramFrequency(keys[i]));
        }

        averageLogLikelihood = averageLogLikelihood(logLikelihoodMap, ngram.getNgramCount());
    }

    /** 
     * Helper method that calculates the average log likelihood statistic
     * given a HashMap of strings and their Laplace probabilities
     * and the total number of ngrams in the model.
     * 
     * @param logs map of ngram strings and their log likelihood
     * @param ngramCount int number of ngrams in the original test string
     * @return average log likelihood: the total of loglikelihoods 
     *    divided by the ngramCount
     */
    private double averageLogLikelihood(HashMap<String,Double> logs, int ngramCount) {
        double likelihood = 0;
        for(Map.Entry<String, Double> entry : logs.entrySet()) {
            likelihood += entry.getValue();
        }
        likelihood = likelihood/ngramCount;
        return likelihood;
    }
    
    /** 
     * Helper method to calculate the total log likelihood statistic
     * given a HashMap of strings and their Laplace probabilities
     * and the total number of ngrams in the model.
     * 
     * @param logs map of ngram strings and their log likelihood
     * @return total log likelihood: the sum of loglikelihoods in logs 
     */
    private double totalLogLikelihood(HashMap<String,Double> logs) {
        double likelihood = 0;
        for(Map.Entry<String, Double> entry : logs.entrySet()) {
            likelihood += entry.getValue();
        }
        return likelihood;
    }

    
    /**
     * @return the average log likelihood statistic
     */
    public double getAverageLogLikelihood() {
        return averageLogLikelihood;
    }
    
    /**
     * @return the log likelihood value for a given ngram from the input string
     */
    public double getLogLikelihood(String ngram) {
        return (logLikelihoodMap.get(ngram));
    }
    
    
    /**
     * Make a String summarising the log likelihood map and its statistics
     * @return String of ngrams and their loglikeihood differences between the models
     * The likelihood table should be ordered from highest to lowest likelihood
     */
    public String toString() 
   {
      String ans =   "";
        ans = ans.concat("\n" + (double) Math.round(getAverageLogLikelihood() *10000d)/10000d );

        String[] keys = logLikelihoodMap.keySet().toArray(new String[0]);
        /*
        Could make strings of each number and the connected key with value first, sort, then decode the strings agains
        */


        //String answer = Integer.toString(ngramSize);
        for (int i =0; i < logLikelihoodMap.keySet().size();i++) {
            ans = ans.concat("\n" + keys[i] + " ");
            ans = ans.concat((double) Math.round(this.getLogLikelihood(keys[i]) *10000d)/10000d  + "");
        }

//Math.round(model.laplaceEstimate("aab") * 10000)
        return ans;
    }
}

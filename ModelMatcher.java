import java.util.HashMap;
import java.util.Collection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

/**
 * Report the average log likelihood of a test String occuring in a 
 * given Markov model and detail the calculated values behind this statistic.
 * 
 * @author Tom Copcutt 22248715, Clayton Duncan 22251348
 * @version 3/6/2017
 */
public class ModelMatcher {

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
        NgramAnalyser ngram = new NgramAnalyser(model.getK()+1, testString);
        String[] keys = ngram.getDistinctNgrams().toArray(new String[0]);
        logLikelihoodMap = new HashMap<>(ngram.getDistinctNgrams().size(), ngram.getDistinctNgrams().size());

        for (int i  = 0; i < ngram.getDistinctNgrams().size(); i++) {
            double logEstimate = Math.log10(model.laplaceEstimate(keys[i]));
            logLikelihoodMap.put(keys[i], logEstimate*ngram.getNgramFrequency(keys[i]));
        }
        averageLogLikelihood = averageLogLikelihood(logLikelihoodMap, ngram.getNgramCount());
    }

    /** 
     * Helper method that calculates the average log likelihood statistic
     * given a HashMap of strings and their Laplace probabilities
     * and the total number of ngrams in the model.
     * 
     * @param HashMap<String,Double> logs map of ngram strings and their log likelihood
     * @param int ngramCount int number of ngrams in the original test string
     * @return double average log likelihood: the total of loglikelihoods 
     *    divided by the ngramCount
     */
    private double averageLogLikelihood(HashMap<String,Double> logs, int ngramCount) {
        double likelihood = 0;

        for(Map.Entry<String, Double> entry : logs.entrySet()) {
            likelihood += entry.getValue();
        }
        return likelihood/ngramCount;
    }
    
    /** 
     * Helper method to calculate the total log likelihood statistic
     * given a HashMap of strings and their Laplace probabilities
     * and the total number of ngrams in the model.
     * 
     * @param HashMap<String,Double> logs map of ngram strings and their log likelihood
     * @return double total log likelihood: the sum of loglikelihoods in logs 
     */
    private double totalLogLikelihood(HashMap<String,Double> logs) {
        double likelihood = 0;
        for(Map.Entry<String, Double> entry : logs.entrySet()) {
            likelihood += entry.getValue();
        }
        return likelihood;
    }

    /**
     * @return double the average log likelihood statistic
     */
    public double getAverageLogLikelihood() {
        return averageLogLikelihood;
    }
    
    /**
     * @param String ngram to find log likelihood for
     * @return double the log likelihood value for a given ngram from the input string
     */
    public double getLogLikelihood(String ngram) {
        if (logLikelihoodMap.containsKey(ngram)) {
            return (logLikelihoodMap.get(ngram));
        } else {return 0;}
    }
    
    /**
     * Make a String summarising the log likelihood map and its statistics
     * @return String of ngrams and their loglikeihood differences between the models
     * The likelihood table should be ordered from highest to lowest likelihood
     */
    public String toString() {
      String ans = Double.toString((double) Math.round(getAverageLogLikelihood() *10000d)/10000d);
        String[] list = new String[logLikelihoodMap.keySet().size()];
        String[] keys = logLikelihoodMap.keySet().toArray(new String[0]);

        for(int i = 0; i < logLikelihoodMap.size(); i++) { //places numbers first for ordering
            String key = keys[i];
            Double value = getLogLikelihood(keys[i]);
            list[i] = value.toString() + "\n" + key;
        }
        Arrays.sort(list); //sorts into descending log likelihood order
        for (int i = 0; i < logLikelihoodMap.keySet().size(); i++) {
            String lines[] = list[i].split("\\r?\\n");
            ans = ans.concat("\n" + lines[1] + " " + (double)Math.round(Double.valueOf(lines[0])*10000)/10000 );
        } //resplits string array and concatonates ngram then log likelihood to the return string.
        return ans;
    }
}

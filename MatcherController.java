import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;
import java.io.*;

/** Create and manipulate Markov models and model matchers for lists of training data 
 * a test data String and generate output from it for convenient display.
 * 
 * @author Tom Copcutt 22248715, Clayton Duncan 
 * @version 30/5/2017
 *
 */
public class MatcherController {

    /** list of training data string used to generate markov models */
    ArrayList<String> trainingDataList;
    /** test data to be matched with the models */
    String testData;
    /** order of the markov models*/
    int k;
    /** generated list of markov models for the given training data*/
    ArrayList<MarkovModel> modelList;
    /** generated list of matchers for the given markov models and test data*/
    ArrayList<ModelMatcher> matcherList;
   

    /** 
     * Generate models for analysis
     * @param k order of the markov models to be used
     * @param testData String to check against different models
     * @throw unchecked exceptions if the input order or data inputs are invalid
     */
    public MatcherController(int k, ArrayList<String> trainingDataList, String testData) 
    {
      //TODO
        if (trainingDataList.size() != 0 && testData != "" && testData != null && k != 0) {
            this.k = k;
            this.trainingDataList = trainingDataList;
            this.testData = testData;
            modelList = new ArrayList<>();
            for (int i =0; i < trainingDataList.size(); i++) {
                modelList.add(new MarkovModel(k, trainingDataList.get(i)));
            }
            matcherList = new ArrayList<>();
            for (int i = 0; i < trainingDataList.size(); i++) {
                matcherList.add(new ModelMatcher(modelList.get(i), testData));
            }







        } else {
            throw new IllegalArgumentException("input order or data inputs are invalid");
        }

    }

 

    /** 
     * @return a string containing all lines from a file 
     * ff file contents can be got, otherwise null
     * This method should process any exceptions that arise.
     */
    private  static String getFileContents(String filename) {
        //TODO 
        //String string  = Files.lines(filename);

        return null;
    }

 

    /**
     * @return the ModelMatcher object that has the highest average loglikelihood
     * (where all candidates are trained for the same test string
     */
    public ModelMatcher getBestMatch(ArrayList<ModelMatcher> candidates) {
        //TODO
        ModelMatcher best = candidates.get(0);
        for (int i = 1; i < candidates.size(); i++) {
            if (best.getAverageLogLikelihood() < candidates.get(i).getAverageLogLikelihood()) {
                best = candidates.get(i);
            }
        }

        return best;
    }

    /** 
     * @return String an *explanation* of
     * why the test string is the match from the candidate models
     */
    public String explainBestMatch(ModelMatcher best) {
        //TODO
        String ans = "from all the candidates, " + best.getAverageLogLikelihood() + "is greater than the average log likelyhoods of all other candidates. This indicates that the string contained in this ModelMatcher bears the closest resemblence to the test string.";
        return ans;
    }

    /**
     * Display an error to the user in a manner appropriate
     * for the interface being used.
     * 
     * @param message
     */
    public void displayError(String message) {
        // LEAVE THIS METHOD EMPTY
        // ¯\_( ͡° ͜ʖ ͡°)_/¯ ok then
    }

}

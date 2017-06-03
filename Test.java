import java.io.*;
import java.util.ArrayList;

public class Test {
	 
  public static void main(String[] args)throws IOException {
  	MarkovModel model = new MarkovModel(2,"aabcabaacaac");
        ModelMatcher match = new ModelMatcher(model,"aabbcaac");
        System.out.println((int)Math.round(Math.abs(match.getAverageLogLikelihood()*10000)));
    }
}
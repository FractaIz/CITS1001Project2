import java.io.*;
public class Main {
	 
  public static void main(String[] args)throws IOException {
  	/*
		NgramAnalyser a = new NgramAnalyser(2, "aaabccd");
    	System.out.println(a.toString());

    MarkovModel b = new MarkovModel(2, "aaabccd");
    b.simpleEstimate("aab");
	   

    MarkovModel b = new MarkovModel(2, "aaabccd");
    System.out.println(b.simpleEstimate("aab"));

    //NgramAnalyser a = new NgramAnalyser(2, "aaabccd");
    //System.out.println(a.getNgramFrequency("aaa"));
	
 NgramAnalyser a = new NgramAnalyser(2, "aaabccd");
      System.out.println(a.getNgramFrequency("v"));

    
	   MarkovModel model = new MarkovModel(2, "aabcabaacaac");
    System.out.printf("%.4f\n", model.laplaceEstimate("aac"));
    System.out.printf("%.4f\n", model.laplaceEstimate("aaa"));
    System.out.printf("%.4f\n", model.laplaceEstimate("aab"));
*/
      NgramAnalyser a = new NgramAnalyser(2, "aaabccd");
     // System.out.println(a.toString());
      MarkovModel model = new MarkovModel(2, "aabcabaacaac");
      System.out.printf(model.toString());
  }
}

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
	
    MarkovModel model = new MarkovModel(2, "aabcabaacaac");
    System.out.printf("%.4f\n", model.simpleEstimate("aac"));
    System.out.printf("%.4f\n", model.simpleEstimate("aaa"));
    System.out.printf("%.4f\n", model.laplaceEstimate("aab"));
*/
    NgramAnalyser a = new NgramAnalyser(2, "aaabccd");
      System.out.println(a.getNgramFrequency("vf"));
	

  }
}

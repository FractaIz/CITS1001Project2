import java.io.*;
import java.util.ArrayList;

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
      //System.out.printf(model.toString());

      System.out.println(model.n1gram.getNgramCount());



      ModelMatcher match = new ModelMatcher(model, "aabbcaac");




      ArrayList<String> n = new ArrayList<>();
      n.add("bacbabbabca");
      n.add("H$%*(UREIJGNKDF");
      n.add("aaaaaaaaa");
      n.add("babacbacbab");
      n.add("aab");
      n.add("bacbaabacbacbcabcbabbabcbacbabbbabca");
      n.add("bacbabbaabca");

      MatcherController con = new MatcherController(2,n, "babacbacbb");
  }
}

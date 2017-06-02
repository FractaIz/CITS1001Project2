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
*//*
      NgramAnalyser a = new NgramAnalyser(2, "aaabccd");
     // System.out.println(a.toString());
      MarkovModel model = new MarkovModel(2, "aabcabaacaac");
      //System.out.printf(model.toString());

      System.out.println(model.n1gram.getNgramCount());



      ModelMatcher match = new ModelMatcher(model, "aabbcaac");
      System.out.println(match.getAverageLogLikelihood());




      

      ProjectTest test = new ProjectTest();
      test.testSensibleToStringSize();
      
      NgramAnalyser test = new NgramAnalyser(2, "aabaaabc");
        System.out.println(test.getAlphabetSize()+1);
        System.out.println(countLines(test.toString()));
        System.out.println(test.toString());



        MarkovModel model = new MarkovModel(2,"aabcabaacaac");
        //assertEquals((int) Math.round(model.laplaceEstimate("aac")*10000), (int)(0.5000*10000));
        System.out.println((int) Math.round(model.simpleEstimate("aaa") * 10000));
        System.out.println((int)(0.1667*10000));
        //assertEquals((int) Math.round(model.laplaceEstimate("aaa") * 10000), (int)(0.1667*10000));
        //assertEquals((int) Math.round(model.laplaceEstimate("aab") * 10000), (int)(0.3333*10000));
*/
        ArrayList<String> n = new ArrayList<>();
      n.add("bacbabbabca");
      n.add("H$%*(UREIJGNKDF");
      n.add("aaaaaaaaa");
      n.add("babacbacbab");
      n.add("aab");
      n.add("bacbaabacbacbcabcbabbabcbacbabbbabca");
      n.add("bacbabbaabca");

      MatcherController con = new MatcherController(2,n, "babacbacbb");
      System.out.println(con.toString());
  }
  private static int countLines(String str) {
        if(str == null || str.isEmpty()) {
            return 0;
        }
        int lines = 1;
        int pos = 0;
        while ((pos = str.indexOf("\n", pos) + 1) != 0) {
            lines++;
        }
        return lines;
    }
}

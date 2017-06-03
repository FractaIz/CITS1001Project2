import java.io.*;
import java.util.ArrayList;

public class Main {
	 
  public static void main(String[] args)throws IOException {
  	
		NgramAnalyser a = new NgramAnalyser(2, "aaabccd");
    	System.out.println(a.toString());

    MarkovModel b = new MarkovModel(2, "aaabccd");
    b.simpleEstimate("aab");
	   

    System.out.println(b.simpleEstimate("aab"));

    //NgramAnalyser a = new NgramAnalyser(2, "aaabccd");
    //System.out.println(a.getNgramFrequency("aaa"));
	
      System.out.println(a.getNgramFrequency("v"));
	    MarkovModel model = new MarkovModel(2, "aabcabaacaac");
      System.out.printf("%.4f\n", model.laplaceEstimate("aac"));
      System.out.printf("%.4f\n", model.laplaceEstimate("aaa"));
      System.out.printf("%.4f\n", model.laplaceEstimate("aab"));

      System.out.println(a.toString());
      System.out.println(model.toString());

      System.out.println(model.n1gram.getNgramCount());



      ModelMatcher match = new ModelMatcher(model, "aabbcaac");
      System.out.println(match.getAverageLogLikelihood());

      NgramAnalyser test = new NgramAnalyser(2, "aabaaabc");
        System.out.println(test.getAlphabetSize()+1);
        System.out.println(test.toString());



        //System.out.println((int) Math.round(model.simpleEstimate("aaa") * 10000));
        //System.out.println((int)(0.1667*10000));
        System.out.println(model.simpleEstimate("aac"));
        System.out.println((int) Math.round(model.simpleEstimate("aac")*10000));
        System.out.println(model.simpleEstimate("aaa"));
        System.out.println((int) Math.round(model.simpleEstimate("aaa") * 10000));
        System.out.println(model.simpleEstimate("aab"));
        System.out.println((int) Math.round(model.simpleEstimate("aab") * 10000));


        ArrayList<String> n = new ArrayList<>();
      n.add("bacbabbabca");
      n.add("H$%*(UREIJGNKDF");
      n.add("aaaaaaaaa");
      n.add("babacbacbab");
      n.add("aab");
      n.add("bacbaabacbacbcabcbabbabcbacbabbbabca");
      n.add("bacbabbaabca");
       MatcherController con = new MatcherController(2,n, "babacbacbb");
      
        System.out.println(match.toString());
        //System.out.println((int)Math.round(Math.abs(match.getAverageLogLikelihood()*10000)));
    }
    /*
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
    */
}

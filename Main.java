import java.io.*;
public class Main {
	 
  public static void main(String[] args)throws IOException {
  	
		NgramAnalyser a = new NgramAnalyser(2, "aaabccd");
    	System.out.println(a.toString());
	

	/*
    MarkovModel b = new MarkovModel(2, "aaabccd");
    b.simpleEstimate("aab");
	*/

  }
}

import java.io.*;
public class Main {
	 
  public static void main(String[] args)throws IOException {

		NgramAnalyser a = new NgramAnalyser(3, "cab bad");
    System.out.println(a.getAlphabetSize());
  }
}

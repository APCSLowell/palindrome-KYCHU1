import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files

public class PalindromeChecker {
public void tester()
{
  //String lines[] = loadStrings("palindromes.txt");
  String[] lines = new String[6]; 
    try{
        File myFile = new File("palindromes.txt");
        Scanner myReader = new Scanner(myFile);
        int counter = 0;
        while (myReader.hasNextLine()) {
            String data = myReader.nextLine();
            lines[counter] = data;
            counter++;
        }
        myReader.close();
    }
    catch (FileNotFoundException e) {
        System.out.println("An error occurred.");
        e.printStackTrace();
    }
  System.out.println("there are " + lines.length + " lines");
  for (int i=0; i < lines.length; i++) 
  {
    if(palindrome(lines[i])==true)
    {
      System.out.println(lines[i] + " IS a palindrome.");
    }
    else
    {
      System.out.println(lines[i] + " is NOT a palindrome.");
    }
  }
}
public boolean palindrome(String word)
{
  word = noCapitals(word);
  word = noSpaces(word);
  word = onlyLetters(word);
  String boob = new String ();
  boob = noSpaces(boob);
  boob = onlyLetters(boob);
  if (word.equals(reverse(word))){
    return true;
  }
  return false;
}
public String reverse(String str)
{
    String bob = new String ();
    for (int i = str.length(); i > 0; i--){
    bob = bob + str.substring(i-1, i);
  }
  return bob.toLowerCase();
}
  public String noSpaces(String sWord){
  String boob = new String();
  for (int i = 0; i < sWord.length(); i++){
    if (sWord.substring(i,i+1).equals(" ") == false){
      boob = boob + sWord.substring(i,i+1);
    }
  }
  return boob;
}

public String onlyLetters(String sString){
  String stewy = new String();
  for(int i = 0; i < sString.length(); i++){
    if(Character.isLetter(sString.charAt(i)) == true){
      stewy += sString.charAt(i);
    }
  }
  return stewy;
}

public String noCapitals(String sWord){
  return sWord.toLowerCase();
}

}

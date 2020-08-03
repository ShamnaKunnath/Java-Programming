import java.util.*;
import edu.duke.*;

public class VigenereBreaker {
    public String sliceString(String message, int whichSlice, int totalSlices) {
        //REPLACE WITH YOUR CODE
        StringBuilder s=new StringBuilder(message);
        StringBuilder ans=new StringBuilder();
        for(int i=whichSlice;i<message.length();i+=totalSlices){
            ans.append(s.charAt(i));
        }
        return ans.toString();
    }

    public int[] tryKeyLength(String encrypted, int klength, char mostCommon) {
        int[] key = new int[klength];
        CaesarCracker cc=new CaesarCracker();
        //WRITE YOUR CODE HERE
        for(int i=0;i<klength;i++){
            key[i]=cc.getKey(sliceString(encrypted,i,klength));
        }
        return key;
    }

    public void breakVigenere () {
        //WRITE YOUR CODE HERE
    }
    public void tester(){
        FileResource fr=new FileResource("Data/athens_keyflute.txt");
        int[] key =tryKeyLength(fr.asString(),5,'e');
        System.out.print("[");
        for(int i=0;i<key.length;i++){
           System.out.print(key[i]+", "); 
        }
        System.out.println("]");
    }
    
}

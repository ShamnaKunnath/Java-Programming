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
        int k=0;
        //WRITE YOUR CODE HERE
        for(int i=0;i<klength;i++){
            key[k++]=cc.getKey(sliceString(encrypted,i,klength));
        }
        return key;
    }

    public void breakVigenere () {
        //WRITE YOUR CODE HERE
    }
    
}

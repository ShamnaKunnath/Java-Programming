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
    public HashSet readDictionary(FileResource fr){
        HashSet<String> h=new HashSet<String>();
        for(String line: fr.lines()){
            line=line.toLowerCase();
            h.add(line);
        }
        return h;
    }
    public int countWords(String message, HashSet<String> dictionary){
        String[] s=message.split("\\W");
        int c=0;
        for(int i=0;i<s.length;i++){
            
            if(dictionary.contains(s[i].toLowerCase())){
                c++;
            }
        }
        return c;
    }
    public String breakForLanguage(String encrypted,HashSet<String> dictionary){
        int max=0;
        int res=0;
        String ans="";
        for(int i=1;i<101;i++){
            int[] key=tryKeyLength(encrypted,i,'e');
            VigenereCipher vc=new VigenereCipher(key);
            String dmsg=vc.decrypt(encrypted);
            int count=countWords(dmsg,dictionary);
            if(count>max){
                max=count;
                ans=dmsg;
                res=key.length;
            }
        }
        System.out.println("key: "+res+"valid words: "+max);
        
        return ans;
    }
    public void breakVigenere () {
        //WRITE YOUR CODE HERE
        FileResource fr=new FileResource("messages/secretmessage2.txt");
        String str=fr.asString();
        FileResource english=new FileResource("dictionaries/English");
        HashSet h=readDictionary(english);
        //int keylength=4;
        //int[] key=tryKeyLength(str, 4,'e');
        //VigenereCipher vc=new VigenereCipher(key);
        System.out.println(breakForLanguage(str,h).substring(0,100));
        int[] key=tryKeyLength(str,38,'e');
        VigenereCipher vc=new VigenereCipher(key);
        String dmsg=vc.decrypt(str);
        int count=countWords(dmsg,h);
        System.out.println("no of valid words: "+count); 
    }
    public void tester(){
        FileResource fr=new FileResource("messages/secretmessage1.txt");
        int[] key =tryKeyLength(fr.asString(),4,'e');
        System.out.print("[");
        for(int i=0;i<key.length;i++){
           System.out.print(key[i]+", "); 
        }
        System.out.println("]");
    }
    
}

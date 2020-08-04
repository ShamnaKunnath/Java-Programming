
/**
 * Write a description of CaesarBreaker here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.io.*;
import edu.duke.*;
import java.util.*;
public class CaesarBreaker {
    public int[] countLetters(String message){
        String alph="abcdefghijklmnopqrstuvwxyz";
        int [] counts=new int[26];
        for(int k=0;k<message.length();k++){
            char ch=Character.toLowerCase(message.charAt(k));
            int dex=alph.indexOf(ch);
            if(dex!=-1){
                counts[dex]+=1;
            }
        }
        return counts;
    }
    
    public String decrypt(String encrypted){
       // CaeserCipher cc= new CaeserCipher();
        int[] freqs=countLetters(encrypted);
        int maxDex=maxIndex(freqs);
        int dkey=maxDex-4;
        if(maxDex<4){
            dkey=26-(4-maxDex);
        }
        //return cc.encrypt(encrypted,26-dkey);
        return "";
    }
    public int maxIndex(int[] vals){
        int maxDex=0;
        for(int k=0;k<vals.length;k++){
            if(vals[k]>vals[maxDex]){
                maxDex=k;
            }
        }
        return maxDex;
    }
    public String halfOfString(String parameter, int start){
        StringBuilder s=new StringBuilder(parameter);
        StringBuilder result=new StringBuilder();
        for(int i=start;i<parameter.length();i+=2){
            result.append(s.charAt(i));
        }
        return result.toString();
    }
    public int getKey(String s){
        return maxIndex(countLetters(s));
    }
    public String decryptTwoKeys(String encrypted){
       CaesarCipher cc1 = new CaesarCipher();
       CaesarCipher cc2 = new CaesarCipher();
       
       String message1 = halfOfString(encrypted,0);
       String message2 = halfOfString(encrypted,1);
       StringBuilder theAnswer = new StringBuilder(encrypted);
       int key1= getKey(message1);
       int key2= getKey(message2);
       
       String d_message1=cc1.encrypt(message1,(26-key1));
       String d_message2=cc1.encrypt(message2,(26-key2));
       
       //build up the final answer
       
       for (int k=0; k<(message1.length());k++){
           theAnswer.setCharAt((2*k), d_message1.charAt(k) );
           }
           
       for (int k=0; k<(message2.length());k++){
           theAnswer.setCharAt((2*k)+1, d_message2.charAt(k) );
           }
           
       System.out.println(key1+" "+key2+" " + theAnswer.toString());    
        
    
       return theAnswer.toString();    
    }
    public String tempp(String encrypted){
        String firstHalf=halfOfString(encrypted,0);
        String secondHalf=halfOfString(encrypted,1);
        int key1=getKey(firstHalf);
        int key2=getKey(secondHalf);
        System.out.println("First key: "+key1+"\n"+"Second Key: "+
        key2);
        //CaeserCipher cc= new CaeserCipher();
        //return cc.encryptTwoKeys(encrypted,key1,key2);
        return "";
    }
    public void testDecrypt(String message){
        System.out.println(message+" : "+decrypt(message));
        
    }
    public void test(){
        FileResource fr = new FileResource();
        String s=decryptTwoKeys(fr.asString());
        //String s=decryptTwoKeys("Akag tjw Xibhr awoa aoee xakex znxag xwko");
        System.out.println(s);
    }
    
}

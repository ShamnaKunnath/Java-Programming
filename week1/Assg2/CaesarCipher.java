import edu.duke.*;
import java.io.*;
public class CaesarCipher {

    public String encrypt(String input, int key) {
        //Make a StringBuilder with message (encrypted)
        StringBuilder encrypted = new StringBuilder(input);
        //Write down the alphabet
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        //Compute the shifted alphabet
        String shiftedAlphabet = alphabet.substring(key)+
        alphabet.substring(0,key);
        //Count from 0 to < length of encrypted, (call it i)
        for(int i = 0; i < encrypted.length(); i++) {
            //Look at the ith character of encrypted (call it currChar)
            char currChar = encrypted.charAt(i);
            //Find the index of currChar in the alphabet (call it idx)
            int idx = alphabet.indexOf( Character.toUpperCase(currChar));
            //If currChar is in the alphabet
            if(idx != -1){
                //Get the idxth character of shiftedAlphabet (newChar)
                char newChar = shiftedAlphabet.charAt(idx);
                //Replace the ith character of encrypted with newChar
                if(Character.isLowerCase(currChar)){
                    encrypted.setCharAt(i, Character.toLowerCase(newChar));
                }
                else{
                    encrypted.setCharAt(i, newChar);
                }
            }
            //Otherwise: do nothing
        }
        //Your answer is the String inside of encrypted
        return encrypted.toString();
    }
 public boolean isEven(int n){
    if ((n % 2) == 0) return true; else return false; 
}
 public String encryptTwoKeys(String input, int key1, int key2){
 String encrypt1 = encrypt(input, key1);
 String encrypt2 = encrypt(input, key2);
 StringBuilder encrypted= new StringBuilder(input);
 
    for (int i=0; i< input.length();i=i+1){
        if (isEven(i))
            encrypted.setCharAt(i, encrypt1.charAt(i));
            
        if (!isEven(i))encrypted.setCharAt(i, encrypt2.charAt(i));
    }
    
    return encrypted.toString();   
 }
    public void testCaesar() {
        int key = 15;
        //FileResource fr = new FileResource();
        //String message = fr.asString();
        String message="At noon be in the conference room with your hat on for a surprise party. YELL LOUD!";
        String encrypted = encrypt(message, key);
        System.out.println(encrypted);
        
    }
    public void testencryptTwoKeys(){
        System.out.println(encryptTwoKeys("Top ncmy qkff vi vguv vbg ycpx",24,6));
    }
}


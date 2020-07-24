import java.io.*;
/**
 * Write a description of wordplay here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class wordplay {
    public boolean isVowel(char ch){
        if(ch=='a'||ch=='A'||ch=='e'||ch=='E'||ch=='i'||ch=='I'||ch=='o'||ch=='O'||ch=='u'||ch=='U'){
            return true;
        }
        return false;
    }
    public String replaceVowels(String phrase,char ch){
        StringBuilder result=new StringBuilder(phrase);
        for(int i=0;i<phrase.length();i++){
            if(isVowel(result.charAt(i))){
                result.setCharAt(i,ch);
            }
        }
        return result.toString();
    }
    public String emphasize(String phrase,char ch){
        StringBuilder result=new StringBuilder(phrase);
        for(int i=0;i<phrase.length();i++){
            if((Character.toLowerCase(result.charAt(i))==ch) || (Character.toUpperCase(result.charAt(i))==ch)){
                if(i%2==0){
                    result.setCharAt(i,'*');
                }
                else{
                    result.setCharAt(i,'+');
                }
            }
        }
         return result.toString();
    }
    public void testIsVowel(){
        System.out.println("A :"+isVowel('A'));
        System.out.println("b :"+isVowel('b'));
        System.out.println("a :"+isVowel('a'));
        System.out.println("F :"+isVowel('F'));
        
    }
    public void testreplaceVowels(){
        System.out.println(replaceVowels("Hello world",'@'));
    }
    public void testemphasize(){
        System.out.println(emphasize("dna ctgaaactga",'a'));
        System.out.println(emphasize("Mary Bella Abracadabra",'a'));
    }
}

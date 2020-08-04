import java.io.*;
import edu.duke.*;
/**
 * Write a description of WordLengths here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class WordLengths {
    public void countWordLengths(FileResource resource,int [] counts){
        for(String word : resource.words()){
            int len=word.length();
            StringBuilder s=new StringBuilder(word);
            if(!Character.isLetter(s.charAt(0))){
                len--;
            }
            if(!Character.isLetter(s.charAt(word.length()-1))){
                len--;
            }
            
            if(len<counts.length-1){
                counts[len]++;
            }
            else{
                counts[counts.length-1]++;
            }
        }
            }
    public int indexOfMax(int [] values){
        int max=0;
        int result=0;
        for(int i=0;i<values.length;i++){
            if(values[i]>max){
                max=values[i];
                result=i;
            }
        }
        return result;
    }
    public void  testCountWordLengths(){
        FileResource fr=new FileResource();
        int[] counts = new int[31];
        countWordLengths(fr,counts);
        for(int i=0;i<counts.length;i++){
            if(counts[i]>0){
                System.out.println(counts[i] +" words of length "+i);
            }
        }
        System.out.println("longest word of length "+indexOfMax(counts));

    }
}

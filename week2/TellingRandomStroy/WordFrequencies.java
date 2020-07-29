import java.util.*;
import java.io.*;
import edu.duke.*;
/**
 * Write a description of WordFrequencies here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class WordFrequencies {
    private ArrayList<String> myWords;
    private ArrayList<Integer> myFreqs;
    public WordFrequencies(){
        myWords=new ArrayList<String>();
        myFreqs=new ArrayList<Integer>();
    }
    public void findUnique(){
        myWords.clear();
        myFreqs.clear();
        FileResource fr=new FileResource();
        for (String word : fr.words()) {
            word=word.toLowerCase();
            int index=myWords.indexOf(word);
            if(index==-1){
                myWords.add(word);
                myFreqs.add(1);
            }
            else{
                myFreqs.set(index,myFreqs.get(index)+1);
            }
        }
        
    }
    public int findIndexOfMax(){
        int max=0;
        int index=0;
        for(int i=0;i<myFreqs.size();i++){
            if(myFreqs.get(i)>max){
                max=myFreqs.get(i);
                index=i;
            }
        }
        return index;
    }
    public void tester(){
        findUnique();
        System.out.println(myWords.size());
        //for(int i=0;i<myWords.size();i++){
         //   System.out.println(myFreqs.get(i)+"\t"+myWords.get(i));
        //}
        int index=findIndexOfMax();
        System.out.println("The word that occurs the most often and its count are:"+
        myWords.get(index)+" "+myFreqs.get(index));
    }

}

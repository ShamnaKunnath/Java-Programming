import java.util.*;
import java.io.*;
import edu.duke.*;
/**
 * Write a description of CharactersInPlay here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CharactersInPlay {
    private ArrayList<String> myWords;
    private ArrayList<Integer> myFreqs;
     public CharactersInPlay(){
        myWords=new ArrayList<String>();
        myFreqs=new ArrayList<Integer>();
    }
    public void update(String person){
            int index=myWords.indexOf(person);
            if(index==-1){
                myWords.add(person);
                myFreqs.add(1);
            }
            else{
                myFreqs.set(index,myFreqs.get(index)+1);
            }
        }
    public void findAllCharacters(){
        myWords.clear();
        myFreqs.clear();
        FileResource fr=new FileResource();
        for (String line : fr.lines()) {
            int index=line.indexOf(".");
            if(index!=-1){
                update(line.substring(0,index));
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
        int threshold=10;
        findAllCharacters();
        //for(int i=0;i<myWords.size();i++){
        //    if(myFreqs.get(i)>threshold){
         //       System.out.println(myWords.get(i)+"\t"+myFreqs.get(i));
         //   }
        //}
        int index=findIndexOfMax();
        System.out.println("most speaking parts"+myWords.get(index)+"\t"+
        myFreqs.get(index));
        int num1=10;
        int num2=15;
        System.out.println("Characters with speaking parts lies between"+num1+
        "and"+num2+":");
        charactersWithNumParts(num1,num2);
    }
    public void charactersWithNumParts(int num1, int num2){
        for(int i=0;i<myWords.size();i++){
            if(myFreqs.get(i)>=num1 && myFreqs.get(i)<=num2){
                System.out.println(myWords.get(i)+"\t"+myFreqs.get(i));
            }
        }
    }
}

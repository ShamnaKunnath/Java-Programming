import java.util.*;
import java.io.*;
import edu.duke.*;
/**
 * Write a description of WordsInFiles here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class WordsInFiles {
    private HashMap<String, ArrayList<String>> map; 
    public WordsInFiles(){
        map=new HashMap<String, ArrayList<String>>();
    }
    private void addWordsFromFile(File f){
        FileResource fr= new FileResource(f);
        for(String w: fr.words()){
            if(!map.keySet().contains(w)){
                ArrayList<String> list=new ArrayList<String>();
                list.add(f.getName());
                map.put(w,list);
            }
            else{
                if(!map.get(w).contains(f.getName())){
                    map.get(w).add(f.getName());
                }
            }
        }
    }
    public void buildWordFileMap(){
        map.clear();
        DirectoryResource dr=new DirectoryResource();
        for(File f: dr.selectedFiles()){
            addWordsFromFile(f);
        }
    }
    public int maxNumber(){
        int max=0;
        for(String s: map.keySet()){
            int listSize=map.get(s).size();
            if(listSize>max){
                max=listSize;
            }
        }
        return max;
    }
    public ArrayList<String> wordsInNumFiles(int number){
        ArrayList<String> list=new ArrayList<String>();
        for(String s: map.keySet()){
            if(map.get(s).size()==number){
                list.add(s);
            }
        }
        return list;
    }
    public void printFilesIn(String word){
        ArrayList<String> list=map.get(word);
        for(String f :list){
            System.out.println(f);
        }
    }
    public void tester(){
         buildWordFileMap();
         int max=maxNumber();
         System.out.println(max);
         ArrayList<String> list=wordsInNumFiles(max);
         System.out.println("no of words present in "+max+" files "+list.size());
         list=wordsInNumFiles(4);
         System.out.println("no of words present in 4 files "+list.size());
         for(String w :list){
            //System.out.println(w+":");
            //printFilesIn(w);
            //System.out.println("\n");
        }
        System.out.println("laid:\n");
        printFilesIn("laid");
        System.out.println("\n");
        System.out.println("tree:\n");
        printFilesIn("tree");
      
    }
}

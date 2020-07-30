import edu.duke.*;
import java.util.*;
/**
 * Write a description of wordFrequenciesMap here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class wordFrequenciesMap {
    
    public void countWords(){
        FileResource fr = new FileResource();
        HashMap<String, Integer> map= new HashMap<String, Integer>();
        for(String w : fr.words()){
            w=w.toLowerCase();
            if(map.keySet().contains(w)){
                map.put(w,map.get(w)+1);
            }
            else{
                map.put(w,1);
            }
        }
        for(String w : map.keySet()){
            int occ=map.get(w);
            if(occ>500){
                System.out.println(occ+"\t"+w);
            }
        }
        //System.out.println("total "+total);
    }
}

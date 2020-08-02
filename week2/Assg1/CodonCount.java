import java.util.*;
import edu.duke.*;
/**
 * Write a description of CodonCount here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CodonCount {
    private HashMap<String, Integer> map; 
    public CodonCount(){
        map=new HashMap<String, Integer>();
    }
    public void buildCodonMap(int start, String dna){
        map.clear();
        int end=start+3;
        String temp="";
        while(end-1<dna.length()){
            temp=dna.substring(start,end);
            if(map.keySet().contains(temp)){
                map.put(temp,map.get(temp)+1);
            }
            else{
                map.put(temp,1);
            }
            start=end;
            end=start+3;
        }
    }
    public String getMostCommonCodon(){
        int max=0;
        String ans="";
        for(String s: map.keySet()){
           if(map.get(s)>max){
               max=map.get(s);
               ans=s;
           }
        }
        return ans;
    }
    public void printCodonCounts(int start, int end){
        for(String s: map.keySet()){
            if(map.get(s)>=start && map.get(s)<=end){
                System.out.println(s+" "+map.get(s));
            }
        }
    }
    public void tester(){
        FileResource fr = new FileResource();
        String dna=fr.asString();
        dna=dna.toUpperCase();
        dna=dna.trim();
        System.out.println(dna.length());
        int c=0;
        int start=1;
        int end=5;
        String s="";
        while(c<3){
            buildCodonMap(c,dna);
            s=getMostCommonCodon();
            System.out.println("Reading frame starting with "+c+" results in "+
            map.size()+" unique codons"+"\n"+"and most common codon is "+
            s+" with count "+map.get(s)+"\n"+"Counts of codons between "+
            start+" "+end+" inclusive are:"+"\n");
            for(String st: map.keySet()){
                System.out.println(st+" "+map.get(st));
            }
            c++;
            System.out.println("\n"+"\n");
        
        }
    }
}

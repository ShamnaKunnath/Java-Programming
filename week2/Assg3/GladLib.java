import edu.duke.*;
import java.util.*;

public class GladLib {
    private HashMap<String, ArrayList<String>> myMap;
    private ArrayList<String> seenWordList;
    private ArrayList<String> seenLabelList;
    private int count;
    private Random myRandom;
    
    private static String dataSourceURL = "http://dukelearntoprogram.com/course3/data";
    private static String dataSourceDirectory = "../UsingGladLibs/data/";
    
    public GladLib(){
        myMap=new HashMap<String, ArrayList<String>>();
        initializeFromSource(dataSourceDirectory);
        myRandom = new Random();
    }
    
    public GladLib(String source){
        initializeFromSource(source);
        myRandom = new Random();
    }
    
    private void initializeFromSource(String source) {
        String[] labels={"adjective","animal","color","country","fruit","name",
            "noun","timeframe","verb"};
            for(String s: labels){
                ArrayList<String> list=readIt(source+"/"+s+".txt");
                myMap.put(s,list);
            }
        seenWordList= new ArrayList<String>();
        seenLabelList= new ArrayList<String>();
        count=0;
    }
    
    private String randomFrom(ArrayList<String> source){
        int index = myRandom.nextInt(source.size());
        return source.get(index);
    }
    
    private String getSubstitute(String label) {
        if (label.equals("number")){
            return ""+myRandom.nextInt(50)+5;
        }
        return randomFrom(myMap.get(label));
    }
    
    private String processWord(String w){
        int first = w.indexOf("<");
        int last = w.indexOf(">",first);
        if (first == -1 || last == -1){
            return w;
        }
        String s=w.substring(first+1,last);
        if(!seenLabelList.contains(s)){
            seenLabelList.add(s);
        }
        String sub = getSubstitute(s);
        String prefix = w.substring(0,first);
        String suffix = w.substring(last+1);
        int index=seenWordList.indexOf(sub);
        while(index!=-1){
            count++;
            sub=getSubstitute(s);
            index=seenWordList.indexOf(sub);
        }
        seenWordList.add(sub);
        return prefix+sub+suffix;
    }
    
    private void printOut(String s, int lineWidth){
        int charsWritten = 0;
        for(String w : s.split("\\s+")){
            if (charsWritten + w.length() > lineWidth){
                System.out.println();
                charsWritten = 0;
            }
            System.out.print(w+" ");
            charsWritten += w.length() + 1;
        }
    }
    
    private String fromTemplate(String source){
        String story = "";
        if (source.startsWith("http")) {
            URLResource resource = new URLResource(source);
            for(String word : resource.words()){
                story = story + processWord(word) + " ";
            }
        }
        else {
            FileResource resource = new FileResource(source);
            for(String word : resource.words()){
                story = story + processWord(word) + " ";
            }
        }
        return story;
    }
    
    private ArrayList<String> readIt(String source){
        ArrayList<String> list = new ArrayList<String>();
        if (source.startsWith("http")) {
            URLResource resource = new URLResource(source);
            for(String line : resource.lines()){
                list.add(line);
            }
        }
        else {
            FileResource resource = new FileResource(source);
            for(String line : resource.lines()){
                list.add(line);
            }
        }
        return list;
    }
    private int totalWordsInMap(){
        int ans=0;
        for(String s: myMap.keySet()){
            ans+=myMap.get(s).size();
        }
        return ans;
    }
    private int totalWordsConsidered(){
        int ans=0;
        System.out.println("no used labels "+seenLabelList.size()+" used labels are:");
        for(String s: seenLabelList){
            System.out.println(s);
            if(!s.equals("number")){
                ans+=myMap.get(s).size();
            }
        }
        return ans;
    }
    public void makeStory(){
        System.out.println("\n");
        String story = fromTemplate("../UsingGladLibs/data/madtemplate2.txt");
        printOut(story, 60);
        System.out.println("\n");
        System.out.println("total number of words that were replaced "+count);
        for(int i=0;i<seenWordList.size();i++){
            System.out.println(seenWordList.get(i));
        }
        System.out.println("total words in map: "+totalWordsInMap());
        System.out.println("total words in labels used: "+totalWordsConsidered());
    }
    
    


}

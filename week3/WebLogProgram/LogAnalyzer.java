
/**
 * Write a description of class LogAnalyzer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.*;
import edu.duke.*;

public class LogAnalyzer
{
     private ArrayList<LogEntry> records;
     
     public LogAnalyzer() {
         // complete constructor
         records=new ArrayList<LogEntry>();
     }
        
     public void readFile(String filename) {
         // complete method
         FileResource fr=new FileResource(filename);
         for(String line: fr.lines()){
             records.add(WebLogParser.parseEntry(line));
         }
     }
     public int countUniqueIPs(){
         ArrayList<String> uniqueIP=new ArrayList<String>();
         for(LogEntry le :records){
             String ipAddr=le.getIpAddress();
             if(!uniqueIP.contains(ipAddr)){
                uniqueIP.add(ipAddr);
             }
         }
         return uniqueIP.size();
     }
     public void printAllHigherThanNum(int number){
         for(LogEntry le: records){
            if(le.getStatusCode()>number){
             System.out.println(le);   
            }
        }
     }
     public ArrayList<String> uniqueIPVisitsOnDay(String someday){
         ArrayList<String> uniqueIP=new ArrayList<String>();
         for(LogEntry le: records){
            Date d=le.getAccessTime();
            String str=d.toString();
            if(someday.equals(str.substring(4,10))){
                String ipAddr=le.getIpAddress();
                if(!uniqueIP.contains(ipAddr)){
                   uniqueIP.add(ipAddr); 
                }
            }
         }
         return uniqueIP;
     }
     
     public int countUniqueIPsInRange(int low, int high){
         int ans=0;
         ArrayList<String> uniqueIP=new ArrayList<String>();
         for(LogEntry le: records){
            if(le.getStatusCode()>=low && le.getStatusCode()<=high){
                String ipAddr=le.getIpAddress();
                if(!uniqueIP.contains(ipAddr)){
                   uniqueIP.add(ipAddr); 
                   ans++;
                }
            }
                
         }
         return ans;
     }
     public HashMap<String,Integer> countVisitPerIP(){
        HashMap<String,Integer> counts=new HashMap<String,Integer>();
        for(LogEntry le: records){
            String ipAddr=le.getIpAddress();
            if(counts.containsKey(ipAddr)){
                counts.put(ipAddr,counts.get(ipAddr)+1);
            }
            else{
                counts.put(ipAddr,1);
            }
        }
        return counts;
    }
    public int mostNumberVisitsByIP(HashMap<String,Integer> map){
        int max=0;
        for(Integer i :map.values()){
            if(i>max){
                max=i;
            }
        }
        return max;
    }
    public ArrayList<String> iPsMostVisits(HashMap<String,Integer> map){
        ArrayList<String> ip=new ArrayList<String>();
        int val=mostNumberVisitsByIP(map);
        for(String s: map.keySet()){
            if(map.get(s)==val){
                ip.add(s);
            }
        }
        return ip;
    }
    public HashMap<String, ArrayList<String>> iPsForDays(){
        HashMap<String, ArrayList<String>> list=new HashMap<String, ArrayList<String>>();
        for(LogEntry le: records){
            Date date=le.getAccessTime();
            String str=date.toString();
            str=str.substring(4,10);
            String ipAddr=le.getIpAddress();
            ArrayList<String> ar=new ArrayList<String>();;
            if(!list.containsKey(str)){
                ar.add(ipAddr);
                list.put(str,ar);
            }
            else{
                ar=list.get(str);
                ar.add(ipAddr);
                list.put(str,ar);
            }
        }
        return list;
        
    }
    public String dayWithMostIPVisits(HashMap<String, ArrayList<String>> map){
        int max=0;
        String result="";
        for(String s: map.keySet()){
            int length=map.get(s).size();
            if(length>max){
                result=s;
            }
        }
        return result;
    }
    public ArrayList<String> iPsWithMostVisitsOnDay(HashMap<String, ArrayList<String>> map
    ,String date){
        ArrayList<String> ipAddr=map.get(date);
        HashMap<String,Integer> counts=new HashMap<String,Integer>();
        for(String s: ipAddr){
            if(counts.containsKey(s)){
                counts.put(s,counts.get(s)+1);
            }
            else{
                counts.put(s,1);
            }
        }
        return iPsMostVisits(counts);
        
    }
     public void printAll() {
         for (LogEntry le : records) {
             System.out.println(le);
         }
     }
     
     
}

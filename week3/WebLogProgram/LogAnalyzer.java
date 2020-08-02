
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
     public void printAll() {
         for (LogEntry le : records) {
             System.out.println(le);
         }
     }
     
     
}


/**
 * Write a description of class Tester here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.*;

public class Tester
{
    public void testLogEntry() {
        LogEntry le = new LogEntry("1.2.3.4", new Date(), "example request", 200, 500);
        System.out.println(le);
        LogEntry le2 = new LogEntry("1.2.100.4", new Date(), "example request 2", 300, 400);
        System.out.println(le2);
    }
    
    public void testLogAnalyzer() {
        // complete method
        LogAnalyzer le=new LogAnalyzer();
        le.readFile("short-test_log");
        le.printAll();
    }
    public void uniqueIP(){
        LogAnalyzer le=new LogAnalyzer();
        le.readFile("short-test_log");
        System.out.println("No of unique IPs: "+le.countUniqueIPs());
    }
    
    public void testprintAllHigherThanNum(){
    int number=400;
    System.out.println("LogEntries with status code greater than "+number);
    LogAnalyzer le=new LogAnalyzer();
    le.readFile("weblog1_log");
    le.printAllHigherThanNum(number);
    }
    
    public void testUniqueIPVisitsOnDay(){
    LogAnalyzer le=new LogAnalyzer();
    le.readFile("weblog1_log");
    //System.out.println(le.uniqueIPVisitsOnDay("Sep 14"));
    //System.out.println(le.uniqueIPVisitsOnDay("Sep 30"));
    System.out.println(le.uniqueIPVisitsOnDay("Mar 24").size());
    }
    
    public void testCountUniqueIPsInRange(){
        LogAnalyzer le=new LogAnalyzer();
        le.readFile("weblog1_log");
        //System.out.println(le.countUniqueIPsInRange(200,299));
        System.out.println(le.countUniqueIPsInRange(300,399));
    }
}

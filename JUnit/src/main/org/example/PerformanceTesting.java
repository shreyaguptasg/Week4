package org.example;

public class PerformanceTesting {
   public String longRunningTask() throws InterruptedException{
       Thread.sleep(1500);
       return "Task Completed";
   }
}

package Day2.QueueInterface;

import java.util.Comparator;
import java.util.PriorityQueue;

class Patient{
    String name;
    int severity;

    Patient(String name, int severity){
        this.name=name;
        this.severity=severity;
    }

    @Override
    public String toString(){
        return name + " " +severity;
    }

}
public class HospitalTriageSystem {
    public static void main(String[] args) {
        PriorityQueue<Patient> queue = new PriorityQueue<>(Comparator.comparing(p -> -p.severity));
        queue.add(new Patient("John",3));
        queue.add(new Patient("Alice",5));
        queue.add(new Patient("Bob",2));
        System.out.println("Order of treatment : ");
        while(!queue.isEmpty()){
            System.out.println(queue.poll());
        }

    }
}

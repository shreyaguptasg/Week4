package Day2.MapInterface;

import java.util.*;

class Employee{
    private String name;
    private String department;

    Employee(String name, String department){
        this.name=name;
        this.department=department;
    }
    public String getName(){
        return name;
    }
    public String getDepartment(){
        return department;
    }
}
public class GroupObjectsByProperty {
    public static void groupByProperty(List<Employee> list){
        Map<String,String> map = new HashMap<>();
        for(Employee emp : list){
            String key = emp.getName();
            String value = emp.getDepartment();
            if(map.containsKey(value)){
                map.put(value, "["+map.get(value)+ ", " + key + "]");
            }
            else{
                map.put(value,key);
            }
        }
        System.out.println(map);
    }
    public static void main(String[] args) {
        Employee e1 = new Employee("Alice", "HR");
        Employee e2 = new Employee("Bob", "IT");
        Employee e3 = new Employee("Carol", "HR");
        List<Employee> emp = new ArrayList<>(Arrays.asList(e1,e2,e3));
        groupByProperty(emp);
    }
}

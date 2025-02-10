package Day1.AIDrivenResumeScreeningSystem;

import java.util.ArrayList;
import java.util.List;

//Create an abstract class JobRole
// (SoftwareEngineer, DataScientist, ProductManager).
abstract class JobRole{
    private String role;

    public JobRole(String role){
        this.role=role;
    }

    public String getRole(){
        return role;
    }

    @Override
    public  String toString(){
        return getClass().getSimpleName() + ": " + role;
    }
}

class SoftwareEngineer extends JobRole{
    public SoftwareEngineer(String role){
        super(role);
    }
}

class DataScientist extends JobRole{
    public DataScientist(String role){
        super(role);
    }
}

class ProductManager extends JobRole{
    public ProductManager(String role){
        super(role);
    }
}

//Implement a generic class Resume<T extends JobRole> to process resumes dynamically.
class Resume<T extends JobRole> {
     private List<T> roles =  new ArrayList<>();

     public void addRoles(T role){
         roles.add(role);
     }

     public List<T> getRoles(){
         return roles;
     }
}

//Utility class to display all items using wildcards
class RoleUtil{
    public static void displayRoles(List<? extends JobRole> roles){
        for(JobRole role : roles){
            System.out.println(role);
        }
    }
}

public class AIDrivenResumeScreeningSystem {
    public static void main(String[] args) {
      Resume<SoftwareEngineer> softwareEngineer = new Resume<>();
      softwareEngineer.addRoles(new SoftwareEngineer("SDE2"));

      Resume<DataScientist> dataScientist = new Resume<>();
      dataScientist.addRoles(new DataScientist("Junior Analyst"));

      Resume<ProductManager> productManager = new Resume<>();
      productManager.addRoles(new ProductManager("Senior Manager"));

      System.out.println("Software Engineer Role");
      RoleUtil.displayRoles(softwareEngineer.getRoles());

        System.out.println("Data Scientist Role ");
        RoleUtil.displayRoles(dataScientist.getRoles());

        System.out.println("Product Manager Role");
        RoleUtil.displayRoles(productManager.getRoles());

    }
}

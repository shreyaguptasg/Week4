package Day4.CustomException;
class CustomExceptionDemo extends Exception{
    public CustomExceptionDemo(String message){
        super(message);
    }
}
public class CustomException {
    public static void validateAge(int age) throws CustomExceptionDemo{
        if(age<18){
            throw new CustomExceptionDemo("Age must be under 18 or above");
        }
        System.out.println("Access Granted!");
    }
    public static void main(String[] args) {
        try{
            validateAge(19);
        } catch (CustomExceptionDemo e) {
            System.out.println("Caught custom exception: " + e.getMessage());
        }
    }
}

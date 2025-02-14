package Day4.MultipleCatchBlocks;

public class MultipleCatchBlocks {
    public static void operations(int[] array, int index){
        try {

            for (int i = 0; i < array.length; i++) {
                System.out.println(array[i]);
            }
            System.out.println(array[index]);
        }
        catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Exception: Invalid index!");
        }
        catch(NullPointerException e) {
            System.out.println("Array is not initialized!");
        }

    }
    public static void main(String[] args) {
        int[] arr= {1,2,3} ;
        int index = 4;
        operations(arr, index);
    }
}

import java.util.*;

public class Operation {

    private int length;

    public Operation(int length) {
        this.length = length;
    }

    public int[] createArray(int length){
        Random rnd = new Random();

        int [] array = new int [length];

        for (int i = 0; i < length; i++) {
            array[i] = rnd.nextInt(99) + 1;
        }
        return array;
    }

    public int[] getSortedArrayUp(int[] array){
        int temp;
        // сортировка по возрастанию
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] > array[j]){
                    temp = array[j];
                    array[j] = array[i];
                    array[i] = temp;
                }
            }
        }
        return array;
    }

    public int[] getSortedArrayDown(int[] array){
        int temp;
        // сортировка по убыванию
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] < array[j]){
                    temp = array[j];
                    array[j] = array[i];
                    array[i] = temp;
                }
            }
        }
        return array;
    }

    public void getPrinted(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + "  ");
        }
        System.out.println();
    }

}

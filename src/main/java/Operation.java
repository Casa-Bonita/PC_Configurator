import java.util.*;

public class Operation {

    private int length;

    public Operation(int length) {
        this.length = length;
    }

    public int[] getArray(int length){
        Random rnd = new Random();

        int [] array = new int [length];

        System.out.println("Элементы НЕотсортированного массива:");
        for (int i = 0; i < length; i++) {
            array[i] = rnd.nextInt(29) + 1;
            System.out.print(array[i] + "  ");
        }
        return array;
    }



    public void getSortedArrayUp(int[] array){
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

        System.out.println("\n" + "Элементы отсортированного массива:");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + "  ");
        }

    }

}

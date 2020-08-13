import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Main {

    private static final Dimension DIMENSION = new Dimension (600, 100);

    public static void main(String[] args) {

        JFrame frame = new JFrame ("Утилита сортировки массива");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(DIMENSION);
        frame.setLayout(new FlowLayout(FlowLayout.LEFT));

        JPanel panel = new JPanel();
        panel.setSize(DIMENSION);
        panel.setMinimumSize(new Dimension(DIMENSION));
        panel.setMaximumSize(new Dimension(DIMENSION));
        panel.setPreferredSize(new Dimension(DIMENSION));

        panel.add(new JLabel("Введите количество элементов в массиве"));

        JTextField textField = new JTextField();
        textField.setSize(100, 30);
        textField.setPreferredSize(new Dimension(100, 30));

        JButton button1 = new JButton("Ввод");
        button1.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent actionEvent){
                if(textField.getText().length() == 0){
                    System.err.println("Некорректный ввод!");
                    return;
                }

                String input = textField.getText();

                try{
                    int length = Integer.parseInt(input);
                    System.out.println("Размер массива = " + length);

//                    int [] array = getArray(length);
//                    getSortedArrayUp(array);
                    Operation operation = new Operation(length);
                    int [] array = operation.getArray(length);
                    operation.getSortedArrayUp(array);

                }catch(NumberFormatException ex){
                    System.out.println("Некорретный ввод, необходимо ввести число");
                    ex.printStackTrace();
                }
                button1.setEnabled(false);
            }
        });

        JButton button2 = new JButton("Сброс");
        button2.addActionListener(actionEvent -> button1.setEnabled(true));

        frame.setResizable(true);
        frame.setVisible(true);

        panel.add(textField);
        panel.add(button1);
        panel.add(button2);
        frame.add(panel);

    }

//    public static int[] getArray(int length){
//        Random rnd = new Random();
//
//        int [] array = new int [length];
//
//        System.out.println("Элементы НЕотсортированного массива:");
//        for (int i = 0; i < length; i++) {
//            array[i] = rnd.nextInt(29) + 1;
//            System.out.print(array[i] + "  ");
//        }
//        return array;
//    }
//
//    public static void getSortedArrayUp(int[] array){
//        int temp;
//        // сортировка по возрастанию
//        for (int i = 0; i < array.length - 1; i++) {
//            for (int j = i + 1; j < array.length; j++) {
//                if (array[i] > array[j]){
//                    temp = array[j];
//                    array[j] = array[i];
//                    array[i] = temp;
//                }
//            }
//        }
//
//        System.out.println("\n" + "Элементы отсортированного массива:");
//        for (int i = 0; i < array.length; i++) {
//            System.out.print(array[i] + "  ");
//        }
//
//    }
}

import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class UserInterface {

    private Dimension DIMENSION;
    private Dimension DIMENSION_FIELD;
    private int [] array;
    private int length = 0;

    public UserInterface(Dimension DIMENSION, Dimension DIMENSION_FIELD) {
        this.DIMENSION = DIMENSION;
        this.DIMENSION_FIELD = DIMENSION_FIELD;
    }

    public void createUI(){
        JFrame frame = new JFrame ("Утилита сортировки массива");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(new Dimension(DIMENSION));
        frame.setLayout(new FlowLayout(FlowLayout.LEFT));

        JPanel panel = new JPanel();
        panel.setLayout(new MigLayout());
        panel.setSize(DIMENSION);
        panel.setMinimumSize(new Dimension(DIMENSION));
        panel.setMaximumSize(new Dimension(DIMENSION));
        panel.setPreferredSize(new Dimension(DIMENSION));

        JTextField textField = new JTextField();
        textField.setSize(new Dimension(DIMENSION_FIELD));
        textField.setMinimumSize(new Dimension(DIMENSION_FIELD));
        textField.setMaximumSize(new Dimension(DIMENSION_FIELD));
        textField.setPreferredSize(new Dimension(DIMENSION_FIELD));


        JButton button1 = new JButton("Ввод размера массива");
        button1.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent actionEvent){
                if(textField.getText().length() == 0){
                    System.err.println("Некорректный ввод!");
                    return;
                }

                String input = textField.getText();

                try{
                    length = Integer.parseInt(input);
                    if(length <= 0){
                        System.out.println("Некорретный ввод, введена отрицательная или нулевая размерность.");
                        return;
                    }

                    System.out.println("Размер массива = " + length);

                    Operation operation = new Operation(length);
                    array = operation.createArray(length);

                }catch(NumberFormatException ex){
                    System.out.println("Некорретный ввод, необходимо ввести число");
                    ex.printStackTrace();
                }

            }
        });

        JButton button2 = new JButton("Сброс");
        button2.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent actionEvent){
                String temp = textField.getText();
                textField.setText("");
            }
        });


        JButton button3 = new JButton("сортировка по ВОЗРАСТАНИЮ");
        button3.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent actionEvent){

                Operation operation = new Operation(length);
                //int [] array = operation.createArray(length);

                System.out.println("\n" + "Элементы НЕотсортированного массива:");
                operation.getPrinted(array);

                array = operation.getSortedArrayUp(array);

                System.out.println("\n" + "Элементы отсортированного массива по ВОЗРАСТАНИЮ:");
                operation.getPrinted(array);

            }
        });

        JButton button4 = new JButton("сортировка по УБЫВАНИЮ");
        button4.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent actionEvent){

                Operation operation = new Operation(length);
                //int [] array = operation.createArray(length);

                System.out.println("\n" + "Элементы НЕотсортированного массива:");
                operation.getPrinted(array);

                array = operation.getSortedArrayDown(array);

                System.out.println("\n" + "Элементы отсортированного массива по УБЫВАНИЮ:");
                operation.getPrinted(array);

            }
        });



        frame.setResizable(true);
        frame.setVisible(true);

        panel.add(new JLabel("Введите количество элементов в массиве"), "span, align center, wrap");
        panel.add(textField);
        panel.add(button1, "wrap 20px");
        panel.add(button2,"span, align center, wrap 20px");
        panel.add(button3, "align center");
        panel.add(button4, "align center");
        frame.add(panel, "align center");


    }
}
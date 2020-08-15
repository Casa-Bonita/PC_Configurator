import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        Dimension DIMENSION = new Dimension (450, 300);
        Dimension DIMENSION_FIELD = new Dimension (150, 30);

        UserInterface ui = new UserInterface(DIMENSION, DIMENSION_FIELD);
        ui.createUI();

    }
}
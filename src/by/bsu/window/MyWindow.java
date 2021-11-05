package by.bsu.window;

import by.bsu.progression.Progression;
import by.bsu.progression.children.Exponential;
import by.bsu.progression.children.Liner;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.io.IOException;

public class MyWindow extends JFrame {

    private final JRadioButton radioLinear = new JRadioButton("Linear",true);
    private final JRadioButton radioExponential = new JRadioButton("Exponential");
    private final JTextField editFirstElement = new JTextField("1",10);
    private final JTextField editDenominator = new JTextField("1",10);
    private final JButton buttonSave = new JButton("save");

    private Progression progression = new Liner(Double.parseDouble(editFirstElement.getText()),
            Double.parseDouble(editDenominator.getText()), 5);
    private final JLabel labelProgression = new JLabel(progression.toString());

    public MyWindow(){
        super("Progressions");
        setBounds(100, 100, 400, 200);
        //чтобы кнопки корректно работали
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ButtonGroup bg=new ButtonGroup();
        bg.add(radioLinear);
        bg.add(radioExponential);
        addFunctionality();
        //поменял фон label
        labelProgression.setBackground(Color.WHITE);
        labelProgression.setOpaque(true);

        //дальше распределние по блокам и выстраивание их в колонну
        JPanel show = new JPanel(new FlowLayout(FlowLayout.LEFT));


        show.add(labelProgression);

        JPanel value = new JPanel(new FlowLayout(FlowLayout.LEFT));
        value.add(new JLabel("first element:"));
        value.add(editFirstElement);
        value.add(new JLabel("denominator:"));
        value.add(editDenominator);

        JPanel type = new JPanel(new FlowLayout(FlowLayout.LEFT));
        type.add(radioLinear);
        type.add(radioExponential);

        JPanel save = new JPanel(new FlowLayout(FlowLayout.LEFT));
        save.add(buttonSave);

        JPanel contents = new JPanel(new GridLayout(4,1,0,5));
        contents.add(show);
        contents.add(type);
        contents.add(value);
        contents.add(save);

        setContentPane(contents);
    }

    private void addFunctionality(){

        radioLinear.addActionListener(event-> {
            progression = new Liner(Double.parseDouble(editFirstElement.getText()),
                Double.parseDouble(editDenominator.getText()), 5);
            labelProgression.setText(progression.toString());
        });

        radioExponential.addActionListener(event-> {
            progression = new Exponential(Double.parseDouble(editFirstElement.getText()),
                    Double.parseDouble(editDenominator.getText()), 5);
            labelProgression.setText(progression.toString());
        });

        editFirstElement.addFocusListener(new CustomListener());

        editDenominator.addFocusListener(new CustomListener());

        buttonSave.addActionListener(event -> {
            JFileChooser fileChooser = new JFileChooser("./resources");
            fileChooser.setFileFilter(new FileNameExtensionFilter("*.TXT","*.*"));
            if ( fileChooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION ) {
                try {
                    progression.writeToFile(fileChooser.getSelectedFile().toString());
                }
               catch ( IOException e ) {
                   System.out.println("Ошибка при нажатии Save, fileChooser виноват");
               }

            }
        });
    }

    public static class CustomListener implements FocusListener {

        @Override
        public void focusGained(FocusEvent e) {
            System.out.println("вводите же...");
        }

        @Override
        public void focusLost(FocusEvent e) {

        }
    }

}

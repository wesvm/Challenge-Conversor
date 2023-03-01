package views.items;

import converter.TemperatureConverter;
import views.Home;

import javax.swing.*;
import java.awt.*;

public class TemperatureConverterView extends TemperatureConverter {
    private final JFrame frame;

    public TemperatureConverterView(){
        frame = new JFrame("Challenge ONE Alura - Convertidor ");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500,250);
        frame.setLocationRelativeTo(null);
        ImageIcon icon = new ImageIcon("src/assets/imgs/aluraicon.jpg");
        frame.setIconImage(icon.getImage());

        JPanel panel = new JPanel();
        panel.setLayout(null);

        Color darkBlue = Color.decode("#0077be");
        Color lightGray = Color.decode("#f5f5f5");
        Color darkGray = Color.decode("#333333");

        JLabel lblAmount = new JLabel("Temperatura a convertir: ");
        lblAmount.setBounds(20, 20 , 150, 25);
        panel.add(lblAmount);

        JTextField txtAmount = new JTextField();
        txtAmount.setBounds(200, 20, 200, 25);
        panel.add(txtAmount);

        String[] grades = {"Celsius", "Kelvin", "Fahrenheit"};

        JLabel lblFromSelection = new JLabel("From: ");
        lblFromSelection.setBounds(40,60,120,25);
        panel.add(lblFromSelection);
        JComboBox<String> fromSelection = new JComboBox<>(grades);
        fromSelection.setBackground(lightGray);
        fromSelection.setForeground(darkGray);
        fromSelection.setBounds(80,60,150,25);
        fromSelection.setSelectedItem("Celsius");
        panel.add(fromSelection);

        JLabel lblToSelection = new JLabel("To: ");
        lblToSelection.setBounds(240,60,120,25);
        panel.add(lblToSelection);
        JComboBox<String> toSelection = new JComboBox<>(grades);
        toSelection.setBackground(lightGray);
        toSelection.setForeground(darkGray);
        toSelection.setBounds(280,60,150,25);
        toSelection.setSelectedItem("Kelvin");
        panel.add(toSelection);

        JButton button = new JButton("Convertir");
        button.setBounds(80, 120, 150, 25);
        button.setFont(new Font("Arial", Font.BOLD, 12));
        button.setBackground(darkBlue);
        button.setForeground(Color.white);
        panel.add(button);

        JLabel lblResult = new JLabel("");
        lblResult.setBounds(20, 160, 500, 25);
        lblResult.setForeground(darkGray);
        panel.add(lblResult);

        button.addActionListener(e -> {
            try {
                double value = Double.parseDouble(txtAmount.getText());
                String from = (String) fromSelection.getSelectedItem();
                String to = (String) toSelection.getSelectedItem();
                String op = from + "To" + to;

                String result = getTemperatureConverter(op ,value);

                lblResult.setText(value + " " + from + " = " + result + " " + to);

            }catch (Exception ex){
                txtAmount.setText("");
                lblResult.setText("");
                JOptionPane.showMessageDialog(panel,"Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        JButton bt = new JButton("Regresar");
        bt.setBounds(250, 120, 150, 25);
        bt.setFont(new Font("Arial", Font.BOLD, 12));
        bt.setBackground(Color.RED);
        bt.setForeground(Color.white);
        panel.add(bt);

        bt.addActionListener(e -> {
            frame.dispose();
            Home home = new Home();
            home.displayHome();
        });

        frame.add(panel);

    }

    public JFrame getTemperatureConverterView(){
        return frame;
    }

}

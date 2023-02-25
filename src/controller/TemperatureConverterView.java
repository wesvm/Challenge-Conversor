package controller;

import models.TemperatureConverter;

import javax.swing.*;

public class TemperatureConverterView extends TemperatureConverter {
    private final JPanel panel;

    public TemperatureConverterView(){
        panel = new JPanel();
        panel.setLayout(null);

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
        fromSelection.setBounds(80,60,120,25);
        fromSelection.setSelectedItem("Celsius");
        panel.add(fromSelection);

        JLabel lblToSelection = new JLabel("To: ");
        lblToSelection.setBounds(220,60,120,25);
        panel.add(lblToSelection);
        JComboBox<String> toSelection = new JComboBox<>(grades);
        toSelection.setBounds(260,60,120,25);
        toSelection.setSelectedItem("Kelvin");
        panel.add(toSelection);

        JButton button = new JButton("Convertir");
        button.setBounds(140, 100, 150, 25);
        panel.add(button);

        JLabel lblResult = new JLabel("");
        lblResult.setBounds(20, 140, 500, 25);
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

    }

    public JPanel getTemperatureConverterView(){
        return panel;
    }

}

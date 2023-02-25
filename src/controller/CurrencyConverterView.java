package controller;
import models.ConfigReader.ComboBoxItem;
import models.CurrencyConverter;
import javax.swing.*;

public class CurrencyConverterView extends CurrencyConverter {

    private final JPanel panel;
    public CurrencyConverterView() {

        panel = new JPanel();
        panel.setLayout(null);

        JLabel lblAmount = new JLabel("Monto a convertir: ");
        lblAmount.setBounds(20, 20 , 150, 25);
        panel.add(lblAmount);

        JTextField txtAmount = new JTextField();
        txtAmount.setBounds(200, 20, 200, 25);
        panel.add(txtAmount);

        ComboBoxItem[] currencies = {
                new ComboBoxItem("USD", "Dolares Americanos"),
                new ComboBoxItem("EUR", "Euros"),
                new ComboBoxItem("GBP", "Libras esterlinas"),
                new ComboBoxItem("JPY", "Yen Japones"),
                new ComboBoxItem("KRW", "Won Surcoreano"),
                new ComboBoxItem("PEN", "Nuevos Soles")
        };

        JLabel lblFromSelection = new JLabel("From: ");
        lblFromSelection.setBounds(40,60,120,25);
        panel.add(lblFromSelection);
        JComboBox<ComboBoxItem> fromSelection = new JComboBox<>(currencies);
        fromSelection.setBounds(80,60,120,25);

        fromSelection.setSelectedItem(new ComboBoxItem("PEN", "Nuevos Soles"));
        panel.add(fromSelection);

        JLabel lblToSelection = new JLabel("To: ");
        lblToSelection.setBounds(220,60,120,25);
        panel.add(lblToSelection);
        JComboBox<ComboBoxItem> toSelection = new JComboBox<>(currencies);
        toSelection.setBounds(260,60,120,25);

        toSelection.setSelectedItem(new ComboBoxItem("USD", "Dolares Americanos"));
        panel.add(toSelection);

        JButton button = new JButton("Convertir");
        button.setBounds(140, 100, 150, 25);
        panel.add(button);

        JLabel lblResult = new JLabel("");
        lblResult.setBounds(20, 140, 300, 25);
        panel.add(lblResult);

        button.addActionListener(e -> {
            try {
                double amount = Double.parseDouble(txtAmount.getText());

                if(amount < 0){
                    throw new IllegalArgumentException("For input negative number: " + amount);
                }

                ComboBoxItem fromSelected = (ComboBoxItem) fromSelection.getSelectedItem();
                ComboBoxItem toSelected = (ComboBoxItem) toSelection.getSelectedItem();
                assert fromSelected != null;
                assert toSelected != null;

                String from = fromSelected.getKey();
                String to = toSelected.getKey();

                String result = getStringConvertedAmount(amount, from, to);
                lblResult.setText(amount + " " + from + " = " + result + " " + to);

            }catch (Exception ex){
                txtAmount.setText("");
                lblResult.setText("");
                JOptionPane.showMessageDialog(panel,"Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

    }

    public JPanel getCurrencyConverterView(){
        return panel;
    }

}

package views.items;
import converter.ConfigReader.ComboBoxItem;
import converter.CurrencyConverter;
import views.Home;

import javax.swing.*;
import java.awt.*;

public class CurrencyConverterView extends CurrencyConverter {

    private final JFrame frame;
    public CurrencyConverterView() {

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

        panel.setBackground(lightGray);

        JLabel lblAmount = new JLabel("Monto a convertir: ");
        lblAmount.setBounds(20, 20 , 150, 25);
        lblAmount.setForeground(darkGray);
        panel.add(lblAmount);

        JTextField txtAmount = new JTextField();
        txtAmount.setBounds(200, 20, 200, 25);
        panel.add(txtAmount);

        ComboBoxItem[] currencies = {
                new ComboBoxItem("PEN", "Nuevos Soles"),
                new ComboBoxItem("USD", "Dolares Americanos"),
                new ComboBoxItem("EUR", "Euros"),
                new ComboBoxItem("GBP", "Libras esterlinas"),
                new ComboBoxItem("JPY", "Yen Japones"),
                new ComboBoxItem("KRW", "Won Surcoreano")

        };

        JLabel lblFromSelection = new JLabel("From: ");
        lblFromSelection.setBounds(40,60,120,25);
        lblFromSelection.setForeground(darkGray);
        panel.add(lblFromSelection);
        JComboBox<ComboBoxItem> fromSelection = new JComboBox<>(currencies);
        fromSelection.setBackground(lightGray);
        fromSelection.setForeground(darkGray);
        fromSelection.setBounds(80,60,150,25);

        fromSelection.setSelectedItem(currencies[0]);
        panel.add(fromSelection);

        JLabel lblToSelection = new JLabel("To: ");
        lblToSelection.setBounds(240,60,120,25);
        lblToSelection.setForeground(darkGray);
        panel.add(lblToSelection);
        JComboBox<ComboBoxItem> toSelection = new JComboBox<>(currencies);
        toSelection.setBackground(lightGray);
        toSelection.setForeground(darkGray);
        toSelection.setBounds(280,60,150,25);

        toSelection.setSelectedItem(currencies[1]);
        panel.add(toSelection);

        JButton button = new JButton("Convertir");
        button.setBounds(80, 120, 150, 25);
        button.setFont(new Font("Arial", Font.BOLD, 12));
        button.setBackground(darkBlue);
        button.setForeground(Color.white);
        panel.add(button);

        JLabel lblResult = new JLabel("");
        lblResult.setBounds(20, 160, 300, 25);
        lblResult.setForeground(darkGray);
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
                lblResult.setText(  amount + " " + from + " = " + result + " " + to);

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

    public JFrame getCurrencyConverterView(){
        return frame;
    }


}

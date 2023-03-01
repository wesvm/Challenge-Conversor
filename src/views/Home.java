package views;
import views.items.CurrencyConverterView;
import views.items.TemperatureConverterView;
import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class Home {

    public void displayHome(){
        JFrame frame = new JFrame("Challenge ONE Alura - Bienvenida");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500,250);
        frame.setLocationRelativeTo(null);

        ImageIcon icon = new ImageIcon("src/assets/imgs/aluraicon.jpg");
        frame.setIconImage(icon.getImage());

        Color darkBlue = Color.decode("#0077be");
        Color lightGray = Color.decode("#f5f5f5");
        Color darkGray = Color.decode("#333333");

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(lightGray);

        JLabel welcomeLabel = new JLabel("Bienvenido al Convertidor");
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 24));
        welcomeLabel.setForeground(darkGray);
        welcomeLabel.setBounds(100, 0, 300, 100);
        panel.add(welcomeLabel);

        JLabel infoLabel = new JLabel("Challenge ONE Back End - Java");
        infoLabel.setForeground(darkGray);
        infoLabel.setBounds(150, 40, 300, 100);
        panel.add(infoLabel);

        JLabel cLabel = new JLabel("Seleccione el convertidor de: ");
        cLabel.setForeground(darkGray);
        cLabel.setBounds(80, 70, 300, 100);
        panel.add(cLabel);

        String[] items = {"Moneda", "Temperatura"};
        JComboBox<String> comboBox = new JComboBox<>(items);
        comboBox.setBackground(lightGray);
        comboBox.setForeground(darkGray);
        comboBox.setBounds(250,110,150,25);
        panel.add(comboBox);

        JButton btnShow = new JButton("Abrir convertidor");
        btnShow.setBackground(darkBlue);
        btnShow.setForeground(Color.white);
        btnShow.setBounds(160, 150, 150 ,30);
        panel.add(btnShow);
        btnShow.addActionListener(e -> {
            frame.dispose();
            displayConverter((String) Objects.requireNonNull(comboBox.getSelectedItem()));
        });

        frame.add(panel);
        frame.setVisible(true);
    }

    public void displayConverter(String s){

        CurrencyConverterView currencyPanel = new CurrencyConverterView();
        TemperatureConverterView temperaturePanel = new TemperatureConverterView();

        JFrame frame = new JFrame();

        switch (s) {
            case "Moneda" -> {
                frame = currencyPanel.getCurrencyConverterView();
                frame.setVisible(true);
            }
            case "Temperatura" -> {
                frame = temperaturePanel.getTemperatureConverterView();
                frame.setVisible(true);
            }
            case "Longitud" -> System.out.println("long");
            default -> System.out.println("idk");
        }
    }
}

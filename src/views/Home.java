package views;
import controller.CurrencyConverterView;
import controller.TemperatureConverterView;
import javax.swing.*;
import java.awt.*;

public class Home {

    public void displayHome(){

        JFrame frame = new JFrame("Challenge ONE Alura - Bienvenida");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500,250);
        frame.setLocationRelativeTo(null);

        ImageIcon icon = new ImageIcon("src/assets/imgs/aluraicon.jpg");
        frame.setIconImage(icon.getImage());

        JPanel panel = new JPanel();
        panel.setLayout(null);
        JLabel welcomeLabel = new JLabel("Bienvenido al Convertidor");
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 24));
        welcomeLabel.setBounds(100, 0, 300, 100);
        panel.add(welcomeLabel);

        JLabel infoLabel = new JLabel("Challenge ONE Back End - Java");
        infoLabel.setBounds(150, 50, 300, 100);
        panel.add(infoLabel);

        JButton btnShow = new JButton("Abrir convertidor");
        btnShow.setBounds(170, 150, 150 ,30);
        panel.add(btnShow);
        btnShow.addActionListener(e -> {
            frame.dispose();
            displayConverter();
        });

        frame.add(panel);
        frame.setVisible(true);

    }

    public void displayConverter(){
        JFrame frame = new JFrame("Challenge ONE Alura - Convertidor ");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500,250);
        frame.setLocationRelativeTo(null);

        ImageIcon icon = new ImageIcon("src/assets/imgs/aluraicon.jpg");
        frame.setIconImage(icon.getImage());

        JTabbedPane tabbedPane = new JTabbedPane();

        CurrencyConverterView panel = new CurrencyConverterView();
        TemperatureConverterView temperaturePanel = new TemperatureConverterView();

        tabbedPane.addTab("Convertidor de divisas", panel.getCurrencyConverterView());
        tabbedPane.addTab("Convertidor de temperatura", temperaturePanel.getTemperatureConverterView());

        frame.add(tabbedPane);
        frame.setVisible(true);
    }

}

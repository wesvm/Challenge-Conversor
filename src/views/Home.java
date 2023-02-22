package views;
import controller.CurrencyConverter.CurrencyConverterView;
import controller.TemperatureConverter.TemperatureConverterView;
import javax.swing.*;

public class Home {

    public void displayHome(){

        JFrame frame = new JFrame("Challenge ONE Alura - Convertidor ");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500,250);
        frame.setLocationRelativeTo(null);

        JTabbedPane tabbedPane = new JTabbedPane();

        CurrencyConverterView panel = new CurrencyConverterView();
        TemperatureConverterView temperaturePanel = new TemperatureConverterView();

        tabbedPane.addTab("Convertidor de divisas", panel.getCurrencyConverterView());
        tabbedPane.addTab("Convertidor de temperatura", temperaturePanel.getTemperatureConverterView());

        frame.add(tabbedPane);
        frame.setVisible(true);

    }

}

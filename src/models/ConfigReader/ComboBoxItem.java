package models.ConfigReader;

public class ComboBoxItem {

    private final String key;
    private final String value;
    public ComboBoxItem(String key, String value) {
        this.key = key;
        this.value = value;
    }
    public String getKey() { return key; }
    public String getValue() { return value; }

    @Override
    public String toString() { return value; }

}

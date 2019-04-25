package Base;

public enum GlobalProperties {

    REPORTPATH("reportPath", "//Reports"), THREADS("threadsName", "REMOTECHROME");

    private final String propertyName;

    private final String defaultValue;

    GlobalProperties(String propertyName, String defaultValue) {
        this.propertyName = propertyName;
        this.defaultValue = defaultValue;
    }

    GlobalProperties(String propertyName) {
        this(propertyName, "");

    }

    public String getValue() {
        return System.getProperty(propertyName, defaultValue);
    }
}

package common;

public enum DriverType {

    Chrome("Chrome"), Firefox("Firefox"), IE("IE"), Edge("Edge");

    private final String value;

    DriverType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}


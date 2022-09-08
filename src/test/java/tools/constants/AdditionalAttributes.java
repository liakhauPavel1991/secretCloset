package tools.constants;

public enum AdditionalAttributes {
    BOUNDS("bounds");

    private final String attribute;

    AdditionalAttributes(String attribute) {
        this.attribute = attribute;
    }

    @Override
    public String toString() {
        return attribute;
    }
}

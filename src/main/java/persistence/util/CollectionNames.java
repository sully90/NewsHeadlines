package persistence.util;

public enum CollectionNames {
    TEST("test");

    // Cannot be null
    private String name;

    CollectionNames(String inName) {
        name = inName;
    }

    public String getName() {
        return name;
    }
}

package de.zebrajaeger.buildsign.display;

/**
 * @author Lars Brandt
 */
public enum DisplayType {
    BUILD_DISPLAY("BuildDisplay"), UNKNOWN("unkonwn");

    private String typeName;

    DisplayType(String typeName) {
        this.typeName = typeName;
    }

    public String getTypeName() {
        return typeName;
    }

    public static DisplayType findByName(String name) {
        for (DisplayType t : DisplayType.values()) {
            if (t.getTypeName().equals(name)) {
                return t;
            }
        }
        return UNKNOWN;
    }
}

package by.epam.tc.bean.entity;

public class AgeRestriction {
    private String description;
    private String name;
    private String minimalAge;

    public String getDescription() {
        return description;
    }

    public String getName() {
        return name;
    }

    public String getMinimalAge() {
        return minimalAge;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMinimalAge(String minimalAge) {
        this.minimalAge = minimalAge;
    }
}

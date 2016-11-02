package by.epam.tc.bean;

public abstract class Product {
    private String name;
    private String description;
    private String country;
    private String releaseDate;
    private float averageMark;

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public void setAverageMark(float averageMark) {
        this.averageMark = averageMark;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getCountry() {
        return country;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public float getAverageMark() {
        return averageMark;
    }
}

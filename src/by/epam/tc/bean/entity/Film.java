package by.epam.tc.bean.entity;


import by.epam.tc.bean.Product;

public class Film extends Product {

    private AgeRestriction ageRestriction;
    private String producer;
    private String image;
    private String trailer;
    private String budget;
    private String boxOffice;

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setTrailer(String trailer) {
        this.trailer = trailer;
    }

    public void setBudget(String budget) {
        this.budget = budget;
    }

    public void setBoxOffice(String boxOffice) {
        this.boxOffice = boxOffice;
    }

    public String getProducer() {

        return producer;
    }

    public String getImage() {
        return image;
    }

    public String getTrailer() {
        return trailer;
    }

    public String getBudget() {
        return budget;
    }

    public String getBoxOffice() {
        return boxOffice;
    }

    public void setAgeRestriction(AgeRestriction ageRestriction) {
        this.ageRestriction = ageRestriction;
    }

    public AgeRestriction getAgeRestriction() {
        return ageRestriction;
    }
}

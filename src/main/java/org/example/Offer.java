package org.example;

public class Offer {
    private int id;
    private String offerTitle;
    private String offerDescription;
    private String firstDate;
    private String lastDate;
    private Double price;

    public Offer(String offerTitle, String offerDescription, String firstDate, String lastDate, Double price) {
        this.offerTitle = offerTitle;
        this.offerDescription = offerDescription;
        this.firstDate = firstDate;
        this.lastDate = lastDate;
        this.price = price;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getOfferTitle() {
        return offerTitle;
    }
    public void setOfferTitle(String offerTitle) {
        this.offerTitle = offerTitle;
    }
    public String getOfferDescription() {
        return offerDescription;
    }
    public void setOfferDescription(String offerDescription) {
        this.offerDescription = offerDescription;
    }
    public String getFirstDate() {
        return firstDate;
    }
    public void setFirstDate(String firstDate) {
        this.firstDate = firstDate;
    }
    public String getLastDate() {
        return lastDate;
    }
    public void setLastDate(String lastDate) {
        this.lastDate = lastDate;
    }
    public Double getPrice() {
        return price;
    }
    public void setPrice(Double price) {
        this.price = price;
    }
}

package bg.softuni.mobilelele.model.view;

import bg.softuni.mobilelele.model.entity.enums.EngineEnum;
import bg.softuni.mobilelele.model.entity.enums.TransmissionEnum;

import java.math.BigDecimal;

public class OfferSummaryViewModel {

    private String imageUrl;
    private Integer mileage;
    private BigDecimal price;
    private EngineEnum engine;
    private TransmissionEnum transmission;
    private Integer year;
    private String model;

    public String getImageUrl() {
        return imageUrl;
    }

    public OfferSummaryViewModel setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    public Integer getMileage() {
        return mileage;
    }

    public OfferSummaryViewModel setMileage(Integer mileage) {
        this.mileage = mileage;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public OfferSummaryViewModel setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public EngineEnum getEngine() {
        return engine;
    }

    public OfferSummaryViewModel setEngine(EngineEnum engine) {
        this.engine = engine;
        return this;
    }

    public TransmissionEnum getTransmission() {
        return transmission;
    }

    public OfferSummaryViewModel setTransmission(TransmissionEnum transmission) {
        this.transmission = transmission;
        return this;
    }

    public Integer getYear() {
        return year;
    }

    public OfferSummaryViewModel setYear(Integer year) {
        this.year = year;
        return this;
    }

    public String getModel() {
        return model;
    }

    public OfferSummaryViewModel setModel(String model) {
        this.model = model;
        return this;
    }
}

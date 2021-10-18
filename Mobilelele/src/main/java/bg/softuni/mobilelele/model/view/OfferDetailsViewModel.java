package bg.softuni.mobilelele.model.view;

import bg.softuni.mobilelele.model.entity.enums.EngineEnum;
import bg.softuni.mobilelele.model.entity.enums.TransmissionEnum;

import java.math.BigDecimal;
import java.time.Instant;

public class OfferDetailsViewModel {

    private Long id;
    private String imageUrl;
    private Integer mileage;
    private BigDecimal price;
    private EngineEnum engine;
    private TransmissionEnum transmission;
    private Instant created;
    private Instant modified;
    private Integer year;
    private ModelViewModel model;
    private UserViewModel seller;

    public OfferDetailsViewModel() {
    }

    public Long getId() {
        return id;
    }

    public OfferDetailsViewModel setId(Long id) {
        this.id = id;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public OfferDetailsViewModel setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    public Integer getMileage() {
        return mileage;
    }

    public OfferDetailsViewModel setMileage(Integer mileage) {
        this.mileage = mileage;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public OfferDetailsViewModel setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public EngineEnum getEngine() {
        return engine;
    }

    public OfferDetailsViewModel setEngine(EngineEnum engine) {
        this.engine = engine;
        return this;
    }

    public TransmissionEnum getTransmission() {
        return transmission;
    }

    public OfferDetailsViewModel setTransmission(TransmissionEnum transmission) {
        this.transmission = transmission;
        return this;
    }

    public Instant getCreated() {
        return created;
    }

    public OfferDetailsViewModel setCreated(Instant created) {
        this.created = created;
        return this;
    }

    public Instant getModified() {
        return modified;
    }

    public OfferDetailsViewModel setModified(Instant modified) {
        this.modified = modified;
        return this;
    }

    public Integer getYear() {
        return year;
    }

    public OfferDetailsViewModel setYear(Integer year) {
        this.year = year;
        return this;
    }

    public ModelViewModel getModel() {
        return model;
    }

    public OfferDetailsViewModel setModel(ModelViewModel model) {
        this.model = model;
        return this;
    }

    public UserViewModel getSeller() {
        return seller;
    }

    public OfferDetailsViewModel setSeller(UserViewModel seller) {
        this.seller = seller;
        return this;
    }
}

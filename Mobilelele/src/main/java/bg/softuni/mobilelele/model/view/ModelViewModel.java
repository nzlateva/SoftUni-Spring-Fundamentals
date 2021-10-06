package bg.softuni.mobilelele.model.view;

public class ModelViewModel {

    private String name;
    private String brandName;

    public ModelViewModel() {
    }

    public String getName() {
        return name;
    }

    public ModelViewModel setName(String name) {
        this.name = name;
        return this;
    }

    public String getBrandName() {
        return brandName;
    }

    public ModelViewModel setBrandName(String brandName) {
        this.brandName = brandName;
        return this;
    }
}

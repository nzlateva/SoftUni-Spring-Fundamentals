package bg.softuni.shoppinglist.model.binding;

import bg.softuni.shoppinglist.model.entity.enums.CategoryEnum;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class ProductAddBindingModel {

    @NotBlank
    @Size(min = 3, max = 20, message = "Product name must be between 3 and 20 characters!")
    private String name;

    @NotBlank
    @Size(min = 5, message = "Description must be more than 5 characters!")
    private String description;

    @NotNull
    @Positive(message = "Price must be a positive number!")
    private BigDecimal price;

    @FutureOrPresent(message = "The date cannot be in the past!")
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private LocalDateTime neededBefore;

    @NotNull
    private CategoryEnum category;


    public ProductAddBindingModel() {
    }

    public String getName() {
        return name;
    }

    public ProductAddBindingModel setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public ProductAddBindingModel setDescription(String description) {
        this.description = description;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public ProductAddBindingModel setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public LocalDateTime getNeededBefore() {
        return neededBefore;
    }

    public ProductAddBindingModel setNeededBefore(LocalDateTime neededBefore) {
        this.neededBefore = neededBefore;
        return this;
    }

    public CategoryEnum getCategory() {
        return category;
    }

    public ProductAddBindingModel setCategory(CategoryEnum category) {
        this.category = category;
        return this;
    }
}

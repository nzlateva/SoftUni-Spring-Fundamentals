package bg.softuni.coffeeshop.model.binding;

import bg.softuni.coffeeshop.model.entity.enums.CategoryEnum;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class OrderAddBindingModel {

    @NotBlank
    @Size(min = 3, max = 20)
    private String name;

    @NotNull
    @Positive
    private BigDecimal price;

    @PastOrPresent
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private LocalDateTime orderTime;

    @NotNull
    private CategoryEnum category;

    @NotBlank
    @Size(min = 5)
    private String description;


    public OrderAddBindingModel() {
    }

    public String getName() {
        return name;
    }

    public OrderAddBindingModel setName(String name) {
        this.name = name;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public OrderAddBindingModel setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public LocalDateTime getOrderTime() {
        return orderTime;
    }

    public OrderAddBindingModel setOrderTime(LocalDateTime orderTime) {
        this.orderTime = orderTime;
        return this;
    }

    public CategoryEnum getCategory() {
        return category;
    }

    public OrderAddBindingModel setCategory(CategoryEnum category) {
        this.category = category;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public OrderAddBindingModel setDescription(String description) {
        this.description = description;
        return this;
    }
}

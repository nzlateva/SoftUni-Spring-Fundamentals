package bg.softuni.coffeeshop.model.service;

import bg.softuni.coffeeshop.model.entity.enums.CategoryEnum;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class OrderServiceModel {

    private Long id;
    private String name;
    private BigDecimal price;
    private LocalDateTime orderTime;
    private CategoryEnum category;
    private String description;

    public OrderServiceModel() {
    }

    public Long getId() {
        return id;
    }

    public OrderServiceModel setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public OrderServiceModel setName(String name) {
        this.name = name;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public OrderServiceModel setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public LocalDateTime getOrderTime() {
        return orderTime;
    }

    public OrderServiceModel setOrderTime(LocalDateTime orderTime) {
        this.orderTime = orderTime;
        return this;
    }

    public CategoryEnum getCategory() {
        return category;
    }

    public OrderServiceModel setCategory(CategoryEnum category) {
        this.category = category;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public OrderServiceModel setDescription(String description) {
        this.description = description;
        return this;
    }
}

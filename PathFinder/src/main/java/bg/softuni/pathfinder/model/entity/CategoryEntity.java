package bg.softuni.pathfinder.model.entity;

import bg.softuni.pathfinder.model.entity.enums.CategoryEnum;

import javax.persistence.*;

@Entity
@Table(name = "categories")
public class CategoryEntity extends BaseEntity {

    @Column(columnDefinition = "TEXT")
    private String description;

    @Enumerated(EnumType.STRING)
    private CategoryEnum name;

    public CategoryEntity() {
    }

    public String getDescription() {
        return description;
    }

    public CategoryEntity setDescription(String description) {
        this.description = description;
        return this;
    }

    public CategoryEnum getName() {
        return name;
    }

    public CategoryEntity setName(CategoryEnum name) {
        this.name = name;
        return this;
    }
}

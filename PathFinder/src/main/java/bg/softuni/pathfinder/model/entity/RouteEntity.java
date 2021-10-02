package bg.softuni.pathfinder.model.entity;

import bg.softuni.pathfinder.model.entity.enums.LevelEnum;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "routes")
public class RouteEntity extends BaseEntity{

    @Column(nullable = false, unique = true)
    private String name;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(columnDefinition = "LONGTEXT")
    private String gpxCoordinates;

    private String videoUrl;

    @Enumerated(EnumType.STRING)
    private LevelEnum level;

    @ManyToOne
    private UserEntity author;

    @ManyToMany
    private Set<CategoryEntity> categories;


    public RouteEntity() {
    }


    public String getName() {
        return name;
    }

    public RouteEntity setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public RouteEntity setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getGpxCoordinates() {
        return gpxCoordinates;
    }

    public RouteEntity setGpxCoordinates(String gpxCoordinates) {
        this.gpxCoordinates = gpxCoordinates;
        return this;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public RouteEntity setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
        return this;
    }

    public LevelEnum getLevel() {
        return level;
    }

    public RouteEntity setLevel(LevelEnum level) {
        this.level = level;
        return this;
    }

    public UserEntity getAuthor() {
        return author;
    }

    public RouteEntity setAuthor(UserEntity author) {
        this.author = author;
        return this;
    }

    public Set<CategoryEntity> getCategories() {
        return categories;
    }

    public RouteEntity setCategories(Set<CategoryEntity> categories) {
        this.categories = categories;
        return this;
    }
}

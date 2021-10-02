package bg.softuni.pathfinder.model.entity;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "comments")
public class Comment extends BaseEntity {

    private boolean approved;

    private Instant created;

    @Column(columnDefinition = "TEXT")
    private String textContent;

    @ManyToOne
    private UserEntity author;

    @ManyToOne
    private RouteEntity route;

    public Comment() {
    }


}

package SpringBoot_BoardProject.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import lombok.Data;

@Data
@Entity
@IdClass(SpringBoot_BoardProject.entities.BoardViewId.class)
public class BoardView {
    @Id
    private Long seq;

    @Id
    @Column(name="_uid")
    private Integer uid;
}

package SpringBoot_BoardProject.repositories;

import SpringBoot_BoardProject.entities.HashTag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HashTagRepository extends JpaRepository<HashTag, String> {
}

package SpringBoot_BoardProject.repositories;

import SpringBoot_BoardProject.entities.Configs;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConfigsRepository extends JpaRepository<Configs, String> {

}

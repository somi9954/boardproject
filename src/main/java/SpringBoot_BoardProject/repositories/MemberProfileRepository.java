package SpringBoot_BoardProject.repositories;

import SpringBoot_BoardProject.entities.MemberProfile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberProfileRepository extends JpaRepository<MemberProfile, Long> {
}

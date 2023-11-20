package SpringBoot_BoardProject.repositories;

import SpringBoot_BoardProject.entities.Member;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface MemberRepository extends CrudRepository<Member, Long> {

    Optional<Member> findByEmail(String email);
}

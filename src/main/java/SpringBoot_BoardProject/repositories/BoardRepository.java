package SpringBoot_BoardProject.repositories;

import SpringBoot_BoardProject.commons.constants.BoardAuthority;
import SpringBoot_BoardProject.entities.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface BoardRepository extends JpaRepository<Board, String>, QuerydslPredicateExecutor<Board> {

}
package SpringBoot_BoardProject.models.board;

import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import SpringBoot_BoardProject.entities.BoardData;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class BoardListService {
    @PersistenceContext
    private EntityManager em;

    public List<BoardData> getList() {
        JPAQueryFactory queryFactory = new JPAQueryFactory(em);

        SpringBoot_BoardProject.entities.QBoardData boardData = SpringBoot_BoardProject.entities.QBoardData.boardData;
        JPAQuery<BoardData> query = queryFactory.selectFrom(boardData)
                .leftJoin(boardData.member)
                .fetchJoin();

        List<BoardData> items = query.fetch();

        return items;

    }
}

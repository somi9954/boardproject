package SpringBoot_BoardProject.jpaex;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import SpringBoot_BoardProject.commons.constants.MemberType;
import SpringBoot_BoardProject.entities.BoardData;
import SpringBoot_BoardProject.entities.Member;
import SpringBoot_BoardProject.models.board.BoardListService;
import SpringBoot_BoardProject.repositories.BoardDataRepository;
import SpringBoot_BoardProject.repositories.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@Transactional
@TestPropertySource(properties = "spring.profiles.active=test")
public class Ex02 {

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private BoardDataRepository boardDataRepository;

    @PersistenceContext
    private EntityManager em;

    @Autowired
    private BoardListService listService;

    @BeforeEach
    void init() {
        Member member = Member.builder()
                .email("user01@test.org")
                .password("12345678")
                .userNm("사용자01")
                .mtype(MemberType.USER)
                .mobile("0100000000")
                .build();

        memberRepository.saveAndFlush(member);

        List<BoardData> items = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            BoardData item = BoardData.builder()
                    .subject("제목" + i)
                    .content("내용" + i)
                    .member(member)
                    .build();
            items.add(item);
        }

        boardDataRepository.saveAllAndFlush(items);
        em.clear();
    }

    @Test
    void test1() {
        List<BoardData> items = boardDataRepository.findAll(); // 10개 // 1차 쿼리
        for (BoardData item : items) {
            Member member = item.getMember();
            String email = member.getEmail(); // 2차 쿼리
            System.out.println(email);
        }
    }

    @Test
    void test2() {
        List<BoardData> items = boardDataRepository.getList2();

    }

    @Test
    void test3() {
        List<BoardData> items = listService.getList();
    }

    @Test
    void test4() {
        List<BoardData> items = boardDataRepository.findBySubjectContaining("목");
    }
}

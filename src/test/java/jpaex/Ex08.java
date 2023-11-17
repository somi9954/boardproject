package jpaex;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import SpringBoot_BoardProject.commons.constants.MemberType;
import SpringBoot_BoardProject.entities.BoardData;
import SpringBoot_BoardProject.entities.Member;
import SpringBoot_BoardProject.repositories.BoardDataRepository;
import SpringBoot_BoardProject.repositories.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

@SpringBootTest
@TestPropertySource(properties = "spring.profiles.active=test")
public class Ex08 {
    @Autowired
    private BoardDataRepository boardDataRepository;

    @Autowired
    private MemberRepository memberRepository;

    @PersistenceContext
    private EntityManager em;

    @BeforeEach
    void init() {
        Member member = Member.builder()
                .email("user01@test.org")
                .password("123456")
                .userNm("사용자01")
                .mtype(MemberType.USER)
                .build();
        memberRepository.saveAndFlush(member);

        BoardData item = BoardData.builder()
                .subject("제목")
                .content("내용")
                .member(member)
                .build();
        boardDataRepository.saveAndFlush(item);
        em.clear();
    }

    @Test
    void test1() {
        BoardData data = boardDataRepository.findById(1L).orElse(null);

        Member member = data.getMember();
        String email = member.getEmail(); // 2차 쿼리 실행
        System.out.println(email);
    }
}

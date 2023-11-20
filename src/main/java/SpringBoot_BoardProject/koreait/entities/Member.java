package SpringBoot_BoardProject.koreait.entities;

import SpringBoot_BoardProject.koreait.commons.constants.MemberType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data @Builder
@NoArgsConstructor @AllArgsConstructor
public class Member extends Base {

    @Id @GeneratedValue
    private Long userNo;

    @Column(length=65, unique = true, nullable = false)
    private String email;

    @Column(length=65, nullable = false)
    private String password;

    @Column(length=40, nullable=false)
    private String userNm;

    @Column(length=11)
    private String mobile;

    @Enumerated(EnumType.STRING)
    @Column(length=15, nullable = false)
    private MemberType mtype = MemberType.USER;
}

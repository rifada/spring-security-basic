package me.holytiger.springsecuritybasic.member;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class MemberDAOTest {

    @Autowired
    private MemberRepository memberRepository;

    @Test
    @DisplayName("신규가입")
    public void newMember() {
        Member member = new Member();

        member.setUsername("holytiger");
        member.setPassword("holytiger");
        member.setRole("ADMIN");

        memberRepository.save(member);
    }
}

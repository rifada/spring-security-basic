package me.holytiger.springsecuritybasic.member;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class MemberService implements UserDetailsService {

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public Member save(Member member) {
        member.setPassword(passwordEncoder.encode(member.getPassword()));
        Member newMember = memberRepository.save(member);
        return newMember;
    }

    public List<Member> findAll() {
        return memberRepository.findAll();
    }

    /**
     * UserDetails 서비르르 implements 하면 나오는 메소드
     * 파라미터는 자동으로 username 으로 받아서
     * 사용자 테이블에 해당 username으로 사용자객체 불러와서 비교한다
     * password는 security 자체적으로 비교해준다(filter 어딘가에서?)
     */
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {

        Member member = memberRepository.findByUsername(s);

        log.debug(member.toString());

        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        authorities.add(new SimpleGrantedAuthority(member.getRole()));

        /**
         * UserDetails를 return 해야하지만,
         * org.springframework.security.core.userdetails.User 객체가
         * UserDetails를 implement 하여 아래의 생성자로 호출하여 객체 리턴해준다.
         */
        return new User(member.getUsername(), member.getPassword(), authorities);
    }
}

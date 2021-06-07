package me.holytiger.springsecuritybasic.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/member")
public class MemberController {

    @Autowired
    private MemberService memberService;

    @GetMapping("/test")
    public String test() {
        return "Hello Security!!";
    }

    @PostMapping("/new")
    public Member newMember(Member member) {
        return memberService.save(member);
    }

    @GetMapping("/list")
    public List<Member> listMember() {
        return memberService.findAll();
    }
}

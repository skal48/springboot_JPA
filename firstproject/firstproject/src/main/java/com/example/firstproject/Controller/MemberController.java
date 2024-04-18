package com.example.firstproject.Controller;

import com.example.firstproject.DTO.MemberForm;
import com.example.firstproject.entity.Member;
import com.example.firstproject.repository.MemberRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;

@Controller
@Slf4j
public class MemberController {
  @Autowired
  private MemberRepository memberRepository;

  @GetMapping("/members")
  public String signupPage() {
    return "members/new";
  }

  @PostMapping("/join")
  public String Join(MemberForm memberForm) {
    //System.out.println(memberForm.toString());

    Member member = memberForm.toEntity();
    //System.out.println(member.toString());
    log.info(member.toString());
    Member saved = memberRepository.save(member);
    //System.out.println(saved.toString());
    log.info(saved.toString());
    return "";
  }

  @GetMapping("/member/{id}")
  public String show(@PathVariable Long id, Model model) {
    Member memberEntity = memberRepository.findById(id).orElse(null);
    model.addAttribute("member", memberEntity);
    return "member/show";
  }

  @GetMapping("/members")
  public String index(Model model){
    ArrayList<Member> memberArrayList = memberRepository.findAll();
    model.addAttribute("memberArrayList", memberArrayList);
    return "member/index";
  }
}

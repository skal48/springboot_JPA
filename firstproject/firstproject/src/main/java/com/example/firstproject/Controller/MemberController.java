package com.example.firstproject.Controller;

import com.example.firstproject.DTO.MemberForm;
import com.example.firstproject.entity.Member;
import com.example.firstproject.repository.MemberRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j
public class MemberController {
  @Autowired
  private MemberRepository memberRepository;

  @GetMapping("/members")
  public String members(){
    return "members/new";
  }

  @PostMapping("/join")
  public String memberJoin(MemberForm memberForm){
    //System.out.println(memberForm.toString());

    Member member = memberForm.toEntity();
    //System.out.println(member.toString());
    log.info(member.toString());
    Member saved = memberRepository.save(member);
    //System.out.println(saved.toString());
    log.info(saved.toString());
    return"members/new";
  }

}

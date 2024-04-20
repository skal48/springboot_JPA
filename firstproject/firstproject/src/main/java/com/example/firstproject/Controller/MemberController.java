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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;

@Controller
@Slf4j
public class MemberController {
  @Autowired
  private MemberRepository memberRepository;
  @GetMapping("/members/new")
  public String newMemberFrom(){
    return "members/new";
  }
  @GetMapping("/signup")
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
    return "redirect:/members/"+ saved.getId();
  }

  @GetMapping("/members/{id}")
  public String show(@PathVariable Long id, Model model) {
    Member memberEntity = memberRepository.findById(id).orElse(null);
    model.addAttribute("member", memberEntity);
    return "members/show";
  }

  @GetMapping("/members")
  public String index(Model model){
    ArrayList<Member> memberArrayList = memberRepository.findAll();
    model.addAttribute("memberArrayList", memberArrayList);
    return "members/index";
  }

  @GetMapping("/members/{id}/edit")
  public String edit(@PathVariable Long id, Model model){
    Member memberEntity = memberRepository.findById(id).orElse(null);
    model.addAttribute("member", memberEntity);
    return "members/edit";
  }

  @PostMapping("/members/update")
  public String update(MemberForm memberForm) {
    Member memberEntity = memberForm.toEntity();
    Member target = memberRepository.findById(memberEntity.getId()).orElse(null);

    if(target != null){
      memberRepository.save(memberEntity);
    }
    return "redirect:/members/" + memberEntity.getId();
  }

  @GetMapping("/members/{id}/delete")
  public String delete(@PathVariable Long id, RedirectAttributes attr){
    Member target = memberRepository.findById(id).orElse(null);
    if (target != null) {
      memberRepository.delete(target);
      attr.addFlashAttribute("msg", "삭제됐습니다!");
    }
    return "redirect:/members";
  }
}

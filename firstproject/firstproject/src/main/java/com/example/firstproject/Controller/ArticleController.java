package com.example.firstproject.Controller;

import com.example.firstproject.DTO.ArticleForm;
import com.example.firstproject.entity.Article;
import com.example.firstproject.repository.ArticleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@Slf4j
public class ArticleController {
  @Autowired //스프링부트가 미리 생성해 놓은 리파지터리 객체 주입
  private ArticleRepository articleRepository;


  @GetMapping("/articles/new")
  public String newArticleForm() {
    return "article/new";
  }

  @PostMapping("/articles/create")
  public String CreateArticle(ArticleForm form) {
    //System.out.println(form.toString());
    // 1. DTO를 엔티티로 변환
    Article article = form.toEntity();
    log.info(article.toString());
    //System.out.println(article.toString());
    // 2. 리파지터리로 엔티티를 DB에 저장
    Article saved = articleRepository.save(article);
    //System.out.println(saved.toString());
    log.info(saved.toString());
    return "redirect:/articles/" + saved.getId();
  }

  @GetMapping("/articles/{id}")
  public String show(@PathVariable Long id, Model model) {
    log.info("id: " + id);
    //1. id를 조회해서 데이터 가져오기
    Article articleEntity = articleRepository.findById(id).orElse(null);
    //2. 모델에 데이터 등록하기
    model.addAttribute("article", articleEntity);
    //3. 뷰 페이지 반환하기
    return "article/show";
  }

  @GetMapping("/articles")
  public String index(Model model) {
    //1. 모든 데이터 가져오기
    //List<Article> articleEntityList= (List<Article>)articleRepository.findAll() 다운캐스팅
    //Iterable<Article> articleEntityList = articleRepository.findAll() 업캐스팅(List-> Iterable)
    ArrayList<Article> articleEntityList = articleRepository.findAll();
    //2. 모델에 데이터 등록하기
    model.addAttribute("articleList", articleEntityList);
    //3. 뷰 페이지 설정하기
    return "article/index";
  }

  @GetMapping("/articles/{id}/edit")
  public String edit(@PathVariable Long id, Model model) {
    Article articleEntity = articleRepository.findById(id).orElse(null);
    model.addAttribute("article", articleEntity);
    return "article/edit";
  }

  @PostMapping("/articles/update")
  public String update(ArticleForm form){
    log.info(form.toString());
    //1.DTO를 엔티티로 변환하기
    Article articleEntity = form.toEntity();
    //2.엔티티를 DB에 저장하기
    //2-1. DB에서 기존 데이터 가져오기
    Article target = articleRepository.findById(articleEntity.getId()).orElse(null);
    //2-2. 기존 데이터 값을 갱신하기
    if (target != null) { // 클릭을 통한 수정은 null 값이 나오지 않으나
                          // 정상적인 요청뿐만 아니라 비정상적인 수정요청을 하는 경우 잘못된 id를 입력하는 경우가 있음
                          // 수정시 입력 대상의 존대 여부를 검증하도록 if 조건문을 넣음
      articleRepository.save(articleEntity);
    }

    //3.수정 결과 페이지로 리다이렉트하기

    return "redirect:/articles/"+articleEntity.getId();
  }
}

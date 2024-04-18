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

  @GetMapping("/article/new")
  public String newArticleForm(){
    return "article/new";
  }

  @PostMapping("/article/create")
  public String CreateArticle(ArticleForm form){
    //System.out.println(form.toString());
    // 1. DTO를 엔티티로 변환
    Article article = form.toEntity();
    log.info(article.toString());
    //System.out.println(article.toString());
    // 2. 리파지터리로 엔티티를 DB에 저장
    Article saved = articleRepository.save(article);
    //System.out.println(saved.toString());
    log.info(saved.toString());
    return "article/new";
  }

  @GetMapping("/article/{id}")
  public String show(@PathVariable Long id, Model model){
    log.info("id: " + id);
    //1. id를 조회해서 데이터 가져오기
    Article articleEntity = articleRepository.findById(id).orElse(null);
    //2. 모델에 데이터 등록하기
    model.addAttribute("article", articleEntity);
    //3. 뷰 페이지 반환하기
    return "article/show";
  }
  @GetMapping("/articles")
  public String index(Model model){
    //1. 모든 데이터 가져오기
    //List<Article> articleEntityList= (List<Article>)articleRepository.findAll() 다운캐스팅
    //Iterable<Article> articleEntityList = articleRepository.findAll() 업캐스팅(List-> Iterable)
    ArrayList<Article> articleEntityList = articleRepository.findAll();
    //2. 모델에 데이터 등록하기
    model.addAttribute("articleList", articleEntityList);
    //3. 뷰 페이지 설정하기
    return "article/index";
  }


}

package com.example.firstproject.repository;

import com.example.firstproject.entity.Article;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface ArticleRepository extends CrudRepository<Article, Long> {
  @Override
  ArrayList<Article> findAll(); //Iterable -> ArrayList
  //오버라이딩 상위클래스가 가지고 있는 메서드를 하위 클래스가 재정의 해서 사용하는 것
}

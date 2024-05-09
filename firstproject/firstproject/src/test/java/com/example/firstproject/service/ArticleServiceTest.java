package com.example.firstproject.service;

import com.example.firstproject.DTO.ArticleForm;
import com.example.firstproject.entity.Article;
import com.example.firstproject.repository.ArticleRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class ArticleServiceTest {
  @Autowired
  ArticleService articleService;

  @Test
  void index() {
    // 1. 예상 데이터
    Article a = new Article(1L, "aaa", "1111");
    Article b = new Article(2L, "bbb", "2222");
    Article c = new Article(3L, "ccc", "3333");
    List<Article> expected = new ArrayList<Article>(Arrays.asList(a, b, c));
    // 2. 실제 데이터
    List<Article> articles = articleService.index();
    // 3. 비교 및 검증
    assertEquals(expected.toString(), articles.toString());
  }

  @Test
  void show_성공_존재하는_id_입력() {
    // 1. 예상데이터
    Long id = 1L;
    Article expected = new Article(id, "aaa", "1111");
    // 2. 실제데이터
    Article article = articleService.show(id);
    // 3. 비교 및 검증
    assertEquals(expected.toString(), article.toString());
  }

  @Test
  void show_실패_존재하지_않는_id_입력() {
    // 1. 예상데이터
    Long id = -1L;
    Article expected = null;
    // 2. 실제데이터
    Article article = articleService.show(id);
    // 3. 비교 및 검증
    assertEquals(expected, article);
  }

  @Test
  @Transactional
  void create_성공_title과_cotent만_있는_dto_입력() {
    // 1. 예상데이터
    String title = "dddd";
    String content = "4444";
    ArticleForm dto = new ArticleForm(null, title, content);
    Article expected = new Article(4L, title, content);
    // 2. 실제데이터
    Article article = articleService.create(dto);
    // 3. 비교 및 검증
    assertEquals(expected.toString(), article.toString());
  }
  @Test
  @Transactional
  void create_실패_title과_cotent만_있는_dto_입력() {
    // 1. 예상데이터
    Long id = 4L;
    String title = "dddd";
    String content = "4444";
    ArticleForm dto = new ArticleForm(id, title, content);
    Article expected = null;
    // 2. 실제데이터
    Article article = articleService.create(dto);
    // 3. 비교 및 검증
    assertEquals(expected, article);
  }

  @Test
  @Transactional
  void updated_성공_존재하는_id와_title_cotent만_있는_dto_입력() {
    // 1. 예상데이터
    Long id = 1L;
    String title = "aaaaaaaa";
    String content = "555555";
    ArticleForm dto = new ArticleForm(id, title, content);
    Article expected = new Article(id, title, content);
    // 2. 실제데이터
    Article article = articleService.updated(id, dto);
    // 3. 비교 및 검증
    assertEquals(expected.toString(), article.toString());
  }
  @Test
  @Transactional
  void updated_성공_존재하는_id와_title만_있는_dto_입력() {
    // 1. 예상데이터
    Long id = 1L;
    String title = "aaaaaaaa";
    String content = articleService.show(id).getContent();
    ArticleForm dto = new ArticleForm(id, title, content);
    Article expected = new Article(id, title, content);
    // 2. 실제데이터
    Article article = articleService.updated(id, dto);
    // 3. 비교 및 검증
    assertEquals(expected.toString(), article.toString());
  }
  @Test
  @Transactional
  void updated_성공_존재하지_않는_id와_dto_입력() {
    // 1. 예상데이터
    Long id = 4L;
    String title = "aaaaaaaa";
    String content = "444444";
    ArticleForm dto = new ArticleForm(id, title, content);
    Article expected = null;
    // 2. 실제데이터
    Article article = articleService.updated(id, dto);
    // 3. 비교 및 검증
    assertEquals(expected, article);
  }

  @Test
  @Transactional
  void deleted_성공_존재하는_id_입력() {
    // 1. 예상데이터
    Long id = 1L;
    Article expected = new Article(id, "aaa","1111");
    // 2. 실제데이터
    Article article = articleService.deleted(id);
    // 3. 비교 및 검증
    assertEquals(expected.toString(), article.toString());
  }
  @Test
  @Transactional
  void deleted_실패_존재하지_않는_id_입력() {
    // 1. 예상데이터
    Long id = 4L;
    Article expected = null;
    // 2. 실제데이터
    Article article = articleService.deleted(id);
    // 3. 비교 및 검증
    assertEquals(expected, article);
  }
}
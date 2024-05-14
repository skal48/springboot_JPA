package com.example.firstproject.repository;

import com.example.firstproject.entity.Article;
import com.example.firstproject.entity.Comment;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@DataJpaTest
class CommentRepositoryTest {
  @Autowired
  CommentRepository commentRepository;

  @Test
  @DisplayName("특정 게시글의 모든 댓글 조회")
  void findByArticleId() {
    /* Case 1: 4번 게시글의 모든  댓글 조회 */
    {
      // 1. 입력 데이터 준비
      Long articleId = 4L;
      // 2. 실제 데이터
      List<Comment> comments = commentRepository.findByArticleId(articleId);
      // 3. 예상 데이터
      Article article = new Article(4L, "당신의 인생 영화는?", "댓글 고");
      Comment a = new Comment(1L, article, "park", "굿 윌 헌팅");
      Comment b = new Comment(2L, article, "kim", "아이 엠 샘");
      Comment c = new Comment(3L, article, "choi", "쇼생크 탈출");
      List<Comment> expected = Arrays.asList(a, b, c);
      // 4. 비교 및 검증
      assertEquals(expected.toString(), comments.toString(),"4번 글의 모든 댓글을 출력!");
    }
    /*Case 2: 1번 게시글의 모든 댓글 조회*/
    {
      // 1. 입력 데이터 준비
      Long articleId = 1L;
      // 2. 실제 데이터
      List<Comment> comments = commentRepository.findByArticleId(articleId);
      // 3. 예상 데이터
      Article article = new Article(1L, "aaa", "1111");
      List<Comment> expected = Arrays.asList();
      // 4. 비교 및 검증
      assertEquals(expected.toString(), comments.toString(),"1번 글은 댓글이 없음");
    }
    /* Case 3: 9번 게시글의 모든  댓글 조회 */
    {
      // 1. 입력 데이터 준비
      Long articleId = 9L;
      // 2. 실제 데이터
      List<Comment> comments = commentRepository.findByArticleId(articleId);
      // 3. 예상 데이터
      Article article = null;
      List<Comment> expected = Arrays.asList();
      // 4. 비교 및 검증
      assertEquals(expected.toString(), comments.toString(),"9번 글과 댓글이 없음");
    }
    /* Case 4: 999번 게시글의 모든  댓글 조회 */
    {
      // 1. 입력 데이터 준비
      Long articleId = 999L;
      // 2. 실제 데이터
      List<Comment> comments = commentRepository.findByArticleId(articleId);
      // 3. 예상 데이터
      Article article = null;
      List<Comment> expected = Arrays.asList();
      // 4. 비교 및 검증
      assertEquals(expected.toString(), comments.toString(),"999번 글과 댓글이 없음");
    }
    /* Case 1: -1번 게시글의 모든  댓글 조회 */
    {
      // 1. 입력 데이터 준비
      Long articleId = -1L;
      // 2. 실제 데이터
      List<Comment> comments = commentRepository.findByArticleId(articleId);
      // 3. 예상 데이터
      Article article = null;
      List<Comment> expected = Arrays.asList();
      // 4. 비교 및 검증
      assertEquals(expected.toString(), comments.toString(),"-1번 글과 댓글이 없음");
    }
  }

  @Test
  @DisplayName("특정 닉네임의 모든 댓글 조회")
  void findByNickname() {
    /*Case 1:"Park"의 모든 댓글 조회*/
    {
      //1. 입력 데이터 준비
      String nickname = "park";
      //2. 실제 데이터
      List<Comment> comments = commentRepository.findByNickname(nickname);
      //3. 예상 데이터
      Comment a = new Comment(1L, new Article(4L, "당신의 인생 영화는?", "댓글 고"),
              nickname, "굿 윌 헌팅");
      Comment b = new Comment(4L, new Article(5L, "당신의 소울 푸드는?", "댓글 고고"),
              nickname, "치킨");
      Comment c = new Comment(7L, new Article(6L, "당신의 취미는?", "댓글 고고고"),
              nickname, "조깅");
      List<Comment> expected = Arrays.asList(a, b, c);
      //4. 비교 및 검증
      assertEquals(expected.toString(), comments.toString(), "park의 모든 댓글을 출력!");
    }
    /*Case 2:"kim"의 모든 댓글 조회*/
    {
      //1. 입력 데이터 준비
      String nickname = "kim";
      //2. 실제 데이터
      List<Comment> comments = commentRepository.findByNickname(nickname);
      //3. 예상 데이터
      Comment a = new Comment(2L, new Article(4L, "당신의 인생 영화는?", "댓글 고"),
              nickname, "아이 엠 샘");
      Comment b = new Comment(5L, new Article(5L, "당신의 소울 푸드는?", "댓글 고고"),
              nickname, "샤브샤브");
      Comment c = new Comment(8L, new Article(6L, "당신의 취미는?", "댓글 고고고"),
              nickname, "유투브 시청");
      List<Comment> expected = Arrays.asList(a, b, c);
      //4. 비교 및 검증
      assertEquals(expected.toString(), comments.toString(), "kim의 모든 댓글을 출력!");
    }
    /*Case 3: null 의 모든 댓글 조회*/
    {
      //1. 입력 데이터 준비
      String nickname = null;
      //2. 실제 데이터
      List<Comment> comments = commentRepository.findByNickname(nickname);
      //3. 예상 데이터
      List<Comment> expected = Arrays.asList();
      //4. 비교 및 검증
      assertEquals(expected.toString(), comments.toString(), "null의 모든 댓글을 출력!");
    }
    /*Case 2:""의 모든 댓글 조회*/
    {
      //1. 입력 데이터 준비
      String nickname = "";
      //2. 실제 데이터
      List<Comment> comments = commentRepository.findByNickname(nickname);
      //3. 예상 데이터
      List<Comment> expected = Arrays.asList();
      //4. 비교 및 검증
      assertEquals(expected.toString(), comments.toString(), "\"\"의 모든 댓글을 출력!");
    }
  }
}
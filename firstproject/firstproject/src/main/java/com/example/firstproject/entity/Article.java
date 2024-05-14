package com.example.firstproject.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity //DB가 해당 객체를 인식하도록 / 해당 클래스로 테이블을 만들어라
@Getter
public class Article {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY) //strategy = GenerationType.IDENTITY DB가 id 자동생성
  private Long id;
  @Column
  private String title;
  @Column
  private String content;

  public void patch(Article article) {
    if (article.title != null) {
      this.title = article.title;
    }
    if(article.content != null){
      this.content = article.content;
    }
  }
}

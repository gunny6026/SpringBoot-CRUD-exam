package com.cos.board.model;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;




@Data //-> getter, setter, 합친거 + toString() 구현
//@Getter
//@Setter
@AllArgsConstructor // 전체 파라메터를
@NoArgsConstructor // 파라메타가 없는 생사자
@Builder // 빌더 패던
@Entity  // ORM(Object Relational Mapping)
public class Board {
	
	@Id// 기본키 설정
	@GeneratedValue(strategy =GenerationType.IDENTITY) // 해당 데이터베이스 번호 증가 전략을 따라가기
	private int id;
	private String title;
	private String content;
	private int readCount;
	@CreationTimestamp
	private Timestamp createDate;
	
	
	

}

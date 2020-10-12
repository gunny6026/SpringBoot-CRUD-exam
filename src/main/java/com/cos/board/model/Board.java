package com.cos.board.model;

import java.sql.Timestamp;

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
@Builder
public class Board {
	
	
	private int id;
	private String title;
	private String conetent;
	private int readCount;
	private Timestamp createDate;
	

}

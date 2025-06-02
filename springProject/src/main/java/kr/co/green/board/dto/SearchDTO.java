package kr.co.green.board.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@NoArgsConstructor
public class SearchDTO {
	private String category = "title";
	private String text = "";
}

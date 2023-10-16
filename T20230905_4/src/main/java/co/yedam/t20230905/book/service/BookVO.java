package co.yedam.t20230905.book.service;

import lombok.Data;

@Data
public class BookVO {
	private String bkCode;
	private String bkTitle;
	private String bkAuthor;
	private String bkPress;
	private int bkPrice;
}

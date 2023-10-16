package co.micol.T20230905.book.service;

public class BookVO {
	private String bkCode;
	private String bkTitle;
	private String bkAuthor;
	private String bkPress;
	private int bkPrice;
	
	public BookVO(String bkCode, String bkTitle, String bkAuthor, String bkPress, int bkPrice) {
		super();
		this.bkCode = bkCode;
		this.bkTitle = bkTitle;
		this.bkAuthor = bkAuthor;
		this.bkPress = bkPress;
		this.bkPrice = bkPrice;
	}
}


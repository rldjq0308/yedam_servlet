package co.yedam.T20230905.book.service;

import java.util.List;

public interface BookService {
	List<BookVO> bookList();
	boolean bookAdd(BookVO vo);
	boolean bookDel(String code); 
}

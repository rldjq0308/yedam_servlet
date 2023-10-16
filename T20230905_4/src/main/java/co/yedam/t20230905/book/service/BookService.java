package co.yedam.t20230905.book.service;

import java.util.List;

public interface BookService {
	public List<BookVO> listBook();

	public boolean addBook(BookVO vo);

	public BookVO getBook(String bkCode);

	public boolean deleteBook(String bkCode);
}

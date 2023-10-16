package co.micol.T20230905.book.service;

import java.util.List;

public interface BookService {
	public boolean bookInsert(BookVO vo);
	public boolean bookDelete(String bkCode);
	public List<BookVO> bookSelectList();
}

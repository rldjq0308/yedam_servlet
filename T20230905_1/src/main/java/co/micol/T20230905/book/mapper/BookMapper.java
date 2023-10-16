package co.micol.T20230905.book.mapper;

import java.util.List;

import co.micol.T20230905.book.service.BookVO;

public interface BookMapper {
	public int bookInsert(BookVO vo);
	public int bookDelete(String bkCode);
	public List<BookVO> bookSelectList();
}

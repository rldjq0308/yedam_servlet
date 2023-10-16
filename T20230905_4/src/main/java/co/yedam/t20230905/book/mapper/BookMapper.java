package co.yedam.t20230905.book.mapper;

import java.util.List;

import co.yedam.t20230905.book.service.BookVO;

public interface BookMapper {
	public List<BookVO> list();
	
	public int insert(BookVO vo);
	
	public BookVO select(String bkCode);
	
	public int delete(String bkCode);
	
}

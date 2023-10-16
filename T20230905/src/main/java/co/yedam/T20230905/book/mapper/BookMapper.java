package co.yedam.T20230905.book.mapper;

import java.util.List;

import co.yedam.T20230905.book.service.BookVO;

public interface BookMapper {
	List<BookVO> list();
	int insert(BookVO vo);
	int delete(String code); 
}

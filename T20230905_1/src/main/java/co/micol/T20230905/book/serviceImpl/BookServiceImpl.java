package co.micol.T20230905.book.serviceImpl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import co.micol.T20230905.book.mapper.BookMapper;
import co.micol.T20230905.book.service.BookService;
import co.micol.T20230905.book.service.BookVO;
import co.micol.T20230905.common.DataSource;

public class BookServiceImpl implements BookService {
    private SqlSession sqlSession = DataSource.getInstance().openSession(true);
    private BookMapper map = sqlSession.getMapper(BookMapper.class);
    
	@Override
	public boolean bookInsert(BookVO vo) {
		return map.bookInsert(vo) == 1;
	}

	@Override
	public boolean bookDelete(String bkCode) {
		return map.bookDelete(bkCode) == 1;
	}

	@Override
	public List<BookVO> bookSelectList() {
		return map.bookSelectList();
	}

}

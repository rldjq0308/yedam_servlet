package co.yedam.t20230905.book.serviceImpl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import co.yedam.t20230905.book.mapper.BookMapper;
import co.yedam.t20230905.book.service.BookService;
import co.yedam.t20230905.book.service.BookVO;
import co.yedam.t20230905.common.DataSources;

public class BookServiceImpl implements BookService {
	private SqlSession sqlSession = DataSources.getInstance().openSession(true);
	private BookMapper map = sqlSession.getMapper(BookMapper.class);

	@Override
	public List<BookVO> listBook() {
		return map.list();
	}

	@Override
	public boolean addBook(BookVO vo) {
		return map.insert(vo) == 1;
	}

	@Override
	public BookVO getBook(String bkCode) {
		return map.select(bkCode);
	}

	@Override
	public boolean deleteBook(String bkCode) {
		return map.delete(bkCode) == 1;
	}

}

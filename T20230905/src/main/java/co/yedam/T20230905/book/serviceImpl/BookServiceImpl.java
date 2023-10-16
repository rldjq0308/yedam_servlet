package co.yedam.T20230905.book.serviceImpl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import co.yedam.T20230905.book.mapper.BookMapper;
import co.yedam.T20230905.book.service.BookService;
import co.yedam.T20230905.book.service.BookVO;
import co.yedam.T20230905.common.DataSources;

public class BookServiceImpl implements BookService {
	private SqlSession sqlSession = DataSources.getInstance().openSession(true);
	private BookMapper map = sqlSession.getMapper(BookMapper.class);
	
	
	@Override
	public List<BookVO> bookList() {
		// TODO Auto-generated method stub
		return map.list();
	}

	@Override
	public boolean bookAdd(BookVO vo) {
		// TODO Auto-generated method stub
		return map.insert(vo) == 1;
	}

	@Override
	public boolean bookDel(String code) {
		// TODO Auto-generated method stub
		return map.delete(code) == 1;
	}

}

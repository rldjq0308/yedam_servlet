package co.micol.example.notice.serviceImpl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import co.micol.example.common.DataSources;
import co.micol.example.notice.mapper.NoticeMapper;
import co.micol.example.notice.service.NoticeService;
import co.micol.example.notice.service.NoticeVO;

public class NoticeServiceImpl implements NoticeService {
	private SqlSession sqlSession = DataSources.getInstance().openSession(true);
	private NoticeMapper map = sqlSession.getMapper(NoticeMapper.class);
	
	@Override
	public List<NoticeVO> noticeSelectList() {
		// TODO Auto-generated method stub
		return map.noticeSelectList();
	}

	@Override
	public List<NoticeVO> noticeSelectList(String key, String val) {
		// TODO Auto-generated method stub
		return map.noticeSelectList(key,val);
	}
	
	@Override
	public List<NoticeVO> noticeSearchList(String key, String val) {
		// TODO Auto-generated method stub
		return map.noticeSearchList(key,val);
	}
	
	@Override
	public NoticeVO noticeSelect(NoticeVO vo) {
		// TODO Auto-generated method stub
		noticeUpdateHit(vo.getNoticeId());
		return map.noticeSelect(vo);
	}

	@Override
	public int noticeInsert(NoticeVO vo) {
		// TODO Auto-generated method stub
		return map.noticeInsert(vo);
	}

	@Override
	public int noticeUpdate(NoticeVO vo) {
		// TODO Auto-generated method stub
		return map.noticeUpdate(vo);
	}

	@Override
	public int noticeDelete(NoticeVO vo) {
		// TODO Auto-generated method stub
		return map.noticeDelete(vo);
	}

	@Override
	public void noticeUpdateHit(int id) {
		map.noticeUpdateHit(id);
	}
	
}

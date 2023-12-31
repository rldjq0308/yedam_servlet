package co.micol.example.notice.service;

import java.util.List;

public interface NoticeService {
	List<NoticeVO> noticeSelectList();
	List<NoticeVO> noticeSelectList(String key, String val); //검색
	
	List<NoticeVO> noticeSearchList(String key, String val); //검색
	NoticeVO noticeSelect(NoticeVO vo);
	int noticeInsert(NoticeVO vo);
	int noticeUpdate(NoticeVO vo);
	int noticeDelete(NoticeVO vo);
	
	void noticeUpdateHit(int id); //조회수 증가
}

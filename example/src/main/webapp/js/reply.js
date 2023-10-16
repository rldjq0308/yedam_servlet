/**
 * reply.js
 */

class Reply {
	notUse() {
		fetch('AjaxReplyList.do?noticeId=' + noticeId)
			.then(resolve => resolve.json())
			.then(json => {
				console.log(json);
			})
			.catch(console.log);
	}

	// 댓글목록.
	replyList(noticeId, callback) {
/*		$.getJSON('AjaxReplyList.do?noticeId=' + noticeId, function(data) {
			callback(data);
		})*/
		
		$.ajax({
			url:'AjaxReplyList.do?noticeId=' + noticeId,
			success: function(data){
				callback(data);
			}
		})
	}
	
	// 댓글등록. 파라미터: 게시글번호, 댓글내용, 댓글작성자, 
	replyAdd(param={noticeId, reply, replyer}, callback, errorcall){
/*		$.post('AjaxReplyAdd.do',param, function(data){
			callback(data);
		})*/
		
		$.ajax({
			url:'AjaxReplyAdd.do',
			data: param,
			success: function(data){
				callback(data);
			}
		})
	}
	
	// 단건조회. param = replyId;
	replySearch(replyId, callback){
		$.getJSON('AjaxReplySearch.do?rno=' + replyId, function(data) {
			callback(data);
		})
	}
	
	// 수정
	replyEdit(param = {rno, noticeId, reply, replyer}, callback){
		$.ajax({
			url: 'AjaxReplyEdit.do',
			data: param,
			success: function(data){
				callback(data);
			}
		})
	}
	
	// 삭제
	replyDel(param = {rno}, callback){
		$.ajax({
			url: 'AjaxDelete.do',
			data: param,
			success: function(data){
				callback(data);
			}
		})
	}
	
	//문자열 -> 날짜포맷으로 변경.
	displayDateTime(dateStr){
		var mils = Date.parse(dateStr);
		var today =  new Date(mils);
		console.log(today.getDate());
		
		var yyyy = today.getFullYear();
		var mm = "0" + (today.getMonth() + 1);
		var dd = "0" + today.getDate();
		var hh = "0" + today.getHours();
		var mi = "0" + today.getMinutes();
		var ss= "0" + today.getSeconds();
		
		return yyyy + "-"  + mm.slice(-2) + "-" + dd.slice(-2) + " " +
		hh.slice(-2) + ":" +mi.slice(-2) + ":" + ss.slice(-2)
	}
}



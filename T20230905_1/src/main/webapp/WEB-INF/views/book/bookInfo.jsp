<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.0/jquery.min.js"></script>
</head>
<body>
	<table border="1">
		<thead>
		</thead>
		<tbody>
			<tr>
				<td>도서코드</td>
				<td><input type="text" name="code"></td>
				<td rowspan="5">
    				<button name="addBtn">저장</button>
    				<button name="delSelectedBtn">선택삭제</button>
				</td>
			</tr>
			<tr>
				<td>도서명</td>
				<td><input type="text" name="title"></td>
			</tr>
			<tr>
				<td>저자</td>
				<td><input type="text" name="author"></td>
			</tr>
			<tr>
				<td>출판사</td>
				<td><input type="text" name="press"></td>
			</tr>
			<tr>
				<td>금액</td>
				<td><input type="text" name="price"></td>
			</tr>
		</tbody>
	</table>
	<table border="1">
		<thead>
            <tr>
                <th><input type="checkbox" name = "selectCheck"></th>
                <th>도서코드</th>
                <th>도서명</th>
                <th>저자</th>
                <th>출판사</th>
                <th>가격</th>
                <th>삭제</th>
            </tr>
        </thead>
        <tbody id="list">

        </tbody>
	</table>
	
	<script>
		$(function(){
			$.ajax({
				url: "AjaxBookList.do",
				success: function(data){
					data.map(book => $("#list").append(makeBookList(book)));
				}
			})
			
			$('button[name=addBtn]').on('click',insertBook);
			$('button[name=delSelectedBtn]').on('click',deleteSelectedBook);
			
		    $("input:checkbox[name=selectCheck]").change(switchChecked);
		})
		
		function makeBookList(book){
	        const fields = ['bkCode','bkTitle','bkAuthor','bkPress','bkPrice'];
			var tr = $('<tr>');
            const td = $('<td>').append($('<input>').attr('type','checkbox').attr('name','delcheck').get(0));
            tr.append(td.get(0));
            
            fields.forEach(field => {
                const td = $('<td>').text(book[field]);
                tr.append(td.get(0));
            })
            
            const delBtn = $('<button>').attr('name','delBtn').attr('name','delcheck').text('삭제');
            delBtn.on('click',deleteBook);
			const btnTd = $('<td>').append(delBtn.get(0));
            tr.append(btnTd.get(0));
            
			return tr.get(0);
		}
		
		function insertBook(){
			var code = $('input[name=code]');
			var title = $('input[name=title]');
			var author = $('input[name=author]');
			var press = $('input[name=press]');
			var price = $('input[name=price]');
			
			if (!code || !title || !author || !press || !price){
				alert("값을 입력하세요");
				return;
			}
			
			var param = {code:code.val(),title:title.val(),author: author.val(), press:press.val(),price:price.val()};
			$.ajax({
				url: "AjaxBookInsert.do",
				data:param,
				success: function(data){
					$("#list").append(makeBookList(data.data));
					code.val('');
					title.val('');
					author.val('');
					press.val('');
					price.val('');
				}
			})
		}
		
		function deleteBook(){
			var tr = $(this).closest('tr');
			var code = tr.children(':eq(1)').text();
			deleteAjax(code,function(data){
				tr.remove();
			})
		}
		
		function deleteAjax(code, callback){
			$.ajax({
				url: "AjaxBookDelete.do?code=" + code,
				success: function(data){
					callback(data);
				}
			})
		}
		
		// 선택된 데이터 삭제
		function deleteSelectedBook(){
            var checks = $('input:checkbox[name=delcheck]:checked').get();
            for(var i in checks){
            	var tr = $(checks[i]).closest('tr').remove();
    			var code = tr.children(':eq(1)').text();
    			deleteAjax(code,function(data){
    				tr.remove();
    			})
            }
		}
		
		function switchChecked(){
			var ischecked = ($(this).is(':checked')) ? true : false;
			$('input:checkbox[name=delcheck]').prop("checked",ischecked);
		}
	</script>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.0/jquery.min.js"></script>
<meta charset="UTF-8">
<title>Insert title here</title>

<style>
#header-section{
	min-height: 250px;
}
.input-header{
	min-width: 60%;
	min-height: 30px;
	padding:5px;
	margin:3px;
}
label{
	display: inline-block;
	min-width: 250px;
	background-color: #E0E0E0;
	padding: 10px;
	text-align: center;
}
button{
	min-width: 150px;
	min-height: 30px;
}
.btn-header{
	margin-left:150px;
}

table{
	min-width: 90vw;
	margin-left: 5vw;
	margin-top: 2vh;
	text-align: center;
}

table th{
	background-color: gray;
	color: white;
}
.delBtn{
	width: 200px;
}

</style>

</head>
<body>
<section id="header-section">
	<div><label for="code">도서코드</label><input type="text" id="code" name="code" class="input-header"/></div>
	<div><label for="title">도서명</label><input type="text" id="title" name="title" class="input-header"/> 
		<button id="addBtn" name="addBtn" class="btn-header">저장</button>	
	</div>
	<div><label for="author">저자</label><input type="text" id="author" name="author" class="input-header"/>
		<button id="delSelect" name="delSelect" class="btn-header">선택삭제</button>
	</div>
	<div><label for="press">출판사</label><input type="text" id="press" name="press" class="input-header"/></div>
	<div><label for="price">금액</label><input type="text" id="price" name="price" class="input-header"/></div>
</section>
<section id="body-section">
	<table border="1">
		<thead>
			<tr>
				<th><input type="checkbox"/></th>
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
</section>
<script>
$(document).ready(function(){
	$.ajax({
		type:"post",
		url: "BookList",
		contentType: "application/x-www-form-urlencoded;charset=UTF-8",
		success: function(data){
			for(let i =0; i < data.length; i++){			
				var innerHtml = "";
				innerHtml += '<tr data-code='+ data[i].bkCode +'>';
				innerHtml += '<td><input type="checkbox"/></td>';
				innerHtml += '<td>'+ data[i].bkCode + '</td>';
				innerHtml += '<td>'+ data[i].bkTitle + '</td>';
				innerHtml += '<td>'+ data[i].bkAuthor + '</td>';
				innerHtml += '<td>'+ data[i].bkPress + '</td>';
				innerHtml += '<td>'+ data[i].bkPrice + '</td>';
				innerHtml += '<td class="delBtn"><button>삭제</button></td>';
				innerHtml += '</tr>'
				
				$('#list').append(innerHtml);
			}
			
		}
	})	
})

$('#addBtn').on('click',function(){	
	$.ajax({
		type:"post",
		url: "BookAdd",
		data: {code: $('#code').val() , title: $('#title').val() ,author: $('#author').val() ,press: $('#press').val() ,price: $('#price').val() },
		contentType: "application/x-www-form-urlencoded;charset=UTF-8",
		success: function(data){
			console.log(data);
			var innerHtml = "";
			innerHtml += '<tr data-code='+ data.res.bkCode +'>';
			innerHtml += '<td><input type="checkbox"/></td>';
			innerHtml += '<td>'+ data.res.bkCode + '</td>';
			innerHtml += '<td>'+ data.res.bkTitle + '</td>';
			innerHtml += '<td>'+ data.res.bkAuthor + '</td>';
			innerHtml += '<td>'+ data.res.bkPress + '</td>';
			innerHtml += '<td>'+ data.res.bkPrice + '</td>';
			innerHtml += '<td class="delBtn"><button>삭제</button></td>';
			innerHtml += '</tr>'
			
			$('#list').append(innerHtml);
		}
	})
});


$(document).on("click",'.delBtn',function() {
	$.ajax({
		type:"post",
		url: "BookDel",
		data: {code: $(this).parent().data('code')},
		contentType: "application/x-www-form-urlencoded;charset=UTF-8",
		success: function(data){		
		}
	})
	$(this).parent().remove();
});


$(document).on('click','#delSelect',function(){	
	console.log($('#list tr td input').eq(0).parent().parent());
	
	for(let i = 0 ; i < $('#list').length; i++){
		if($('#list tr td input').eq(i).is(":checked")){
			var delCode = $('#list tr td input').eq(0).parent().parent().data('code');
			$.ajax({
				type:"post",
				url: "BookDel",
				data: {code: delCode},
				contentType: "application/x-www-form-urlencoded;charset=UTF-8",
				success: function(data){		
				}
			})
			$('#list tr td input').eq(i).remove();
		}
	}
});


/*
    function makeCenterInfo(data){		
        const tr = document.createElement('tr');
        fields.forEach(field=>{
			const td = document.createElement('td');
			td.innerText = center[field];	
            tr.appendChild(td);
        })
        const td = document.createElement('td');
        const chk = document.createElement('input');
        chk.setAttribute('type','checkbox');
        td.appendChild(chk);
        tr.appendChild(td);

        return tr;
    }

    // 선택삭제 이벤트.
    // 1.이벤트 등록 2.대상선택 3.checked속성의 true를 찾아서 remove().
    document.querySelector('button[name=delBtn]').addEventListener('click',delSelectedTr);

    function delSelectedTr(e){
        document.querySelectorAll('#list tr input:checked').forEach(item => item.parentElement.parentElement.remove());
    }
    */
    
</script>
</body>
</html>
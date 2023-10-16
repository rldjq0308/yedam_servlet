/**
 * book.js
 */

class Book {
	bookList(callback) {
		$.ajax({
			url: '../BookList.do',
			success: function(data) {
				callback(data);
			}
		})
	}

	bookAdd(param = { bkCode, bkTitle, bkAuthor, bkPress, bkPrice }, callback, errorcall) {
		$.ajax({
			url: '../BookAdd.do',
			data: param,
			success: function(data) {
				callback(data);
			},
			error: function(err) {
				errorcall(err);
			}
		})
	}

	bookDelete(bkCode, callback) {
		$.ajax({
			url: '../BookDelete.do?bkCode=' + bkCode,
			success: function(data) {
				callback(data);
			}
		})
	}

	bookSearch(bkCode, callback) {
		$.ajax({
			url: '../BookSearch.do?bkCode=' + bkCode,
			success: function(data) {
				callback(data);
			}
		})
	}
}
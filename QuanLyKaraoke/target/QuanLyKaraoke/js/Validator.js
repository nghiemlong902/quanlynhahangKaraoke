/**
 * 
 */
// Doi tuong validator
function Validator(options) {

	var selectorRules = {};

	// Hàm thực hiện validate
	function validate(inputElement, rule) {
		var errorMessage;
		var ErrorElement = inputElement.parentElement.querySelector(options.errorSelector);

		// Lấy ra các rules của selector
		var rules = selectorRules[rule.selector];

		//Lặp qua từng rule và kiểm tra
		// Nếu có lỗi thì dừng việc kiểm tra 
		for (var i = 0; i < rules.length; i++) {
			errorMessage = rules[i](inputElement.value);
			if (errorMessage) {
				break;
			}
		}
		if (errorMessage) {
			ErrorElement.innerText = errorMessage;
			inputElement.parentElement.classList.add('invalid');
		} else {
			ErrorElement.innerText = '';
			inputElement.parentElement.classList.remove('invalid');
		}
		return !errorMessage;
	}
	// ------------------------------------------------
	// Lấy element của form cần validate
	var formElement = document.querySelector(options.form);
	if (formElement) {
		formElement.onsubmit = function(e) {
			e.preventDefault();
			var isFormValid = true;
			options.rules.forEach(function(rule) {
				var inputElement = formElement.querySelector(rule.selector);
				var isValid = validate(inputElement, rule);
				if (!isValid) {
					isFormValid = false;
				}
			});
			if (isFormValid) {
				//Truong hop submit voi js
				if (typeof options.onSubmit === 'function') {
					let enableInputs = formElement.querySelectorAll('[name]');
					let formValues = Array.from(enableInputs).reduce(function(values, input) {
						return (values[input.name] = input.value) && values;
					}, {});
					options.onSubmit(formValues);
					// Submit mac dinh
				} else {
					//Submit voi hanhvimacdinh
					formElement.submit();
				}
			}
		}
		// Xử lý lặp qua mỗi rule và xử lý ( lắng nghe sự kiện blur, input, )
		options.rules.forEach(function(rule) {
			// Lưu lại các rule trong mỗi input
			if (Array.isArray(selectorRules[rule.selector])) {
				selectorRules[rule.selector].push(rule.test);
			} else {
				selectorRules[rule.selector] = [rule.test];
			}
			var inputElement = formElement.querySelector(rule.selector);
			if (inputElement) {
				// Xử lý trường hợp blur khỏi input
				inputElement.onblur = function() {
					validate(inputElement, rule)
				}
				// Xử lý mỗi khi nhập
				inputElement.oninput = function() {
					let ErrorElement = inputElement.parentElement.querySelector('.form-message');
					ErrorElement.innerText = '';
					inputElement.parentElement.classList.remove('invalid');
				}
			}

		})
		console.log(selectorRules);
	}
}
//----------------------------------------------------------------------------
// Dinh nghia rules
// Nguyen tac rules
//1. Khi co loi thi tra ra message loi, khong co loi khong tra ra gi ca(undifined)
Validator.isRequired = function(selector) {
	return {
		selector: selector,
		test: function(value) {
			return value.trim() ? undefined : "Không được để trống trường này"
		}
	};
}
// Rules Email
Validator.isEmail = function(selector) {
	return {
		selector: selector,
		test: function(value) {
			var regex = /^(([^<>()[\]\\.,;:\s@"]+(\.[^<>()[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
			return regex.test(value) ? undefined : 'Sai định dạng email'
		}
	};
}

// Rules Mã Khách Hàng
Validator.isMaKH = function(selector) {
	return {
		selector: selector,
		test: function(value) {
			let regex = /[KH][0-9]{6}/;
			return regex.test(value) ? undefined : 'Vui lòng nhập đúng định dạng khách hàng'
		}
	};
}

// Rules số điện thoại 
Validator.isPhone = function(selector) {
	return {
		selector: selector,
		test: function(value) {
			let regex = /((091|090)+([0-9]{7})\b)/;
			let regex1 = /(((\+|)84)|0)(90|91)+([0-9]{7})\b/;
			if (regex.test(value) || regex1.test(value)) {
				return undefined;
			}
			else {
				return 'Vui lòng nhập đúng định dạng số điện thoại';
			}
			//return (regex.test(value) || regex1.test(value)) ? undefined : 'Vui lòng nhập đúng định dạng số điện thoại'
		}
	};
}

// Rules email 
//Validator.isEmail = function(selector) {
//	return {
//		selector: selector,
//		test: function(value) {
//			let regex = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
//		return regex.test(value) ? undefined : 'Email is valid'
//		}
//	};
//}

// Rule > 0
Validator.isDuong = function(selector) {
	return {
		selector: selector,
		test: function(value) {
			//let regex = /[1-9][0-9]*/;
			//return regex.test(value) ? undefined : 'Vui lòng định dạng số lớn hơn 0 '
			let giatri = parseInt(value);
			console.log(giatri)
			if (giatri > 0) {
				return undefined;
			} else {
				return 'Vui lòng định dạng số lớn hơn 0 ';
			}
		}
	};
}

// IsDay
Validator.isDay = function(selector) {
	return {
		selector: selector,
		test: function(value) {
			let regex = /^(?:(?:31(\/|-|\.)(?:0?[13578]|1[02]))\1|(?:(?:29|30)(\/|-|\.)(?:0?[1,3-9]|1[0-2])\2))(?:(?:1[6-9]|[2-9]\d)?\d{2})$|^(?:29(\/|-|\.)0?2\3(?:(?:(?:1[6-9]|[2-9]\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|^(?:0?[1-9]|1\d|2[0-8])(\/|-|\.)(?:(?:0?[1-9])|(?:1[0-2]))\4(?:(?:1[6-9]|[2-9]\d)?\d{2})$/;
			return regex.test(value) ? undefined : 'Vui lòng nhập đúng định dạng ngày'
		}
	};
}

//IsFormat : format định dạng 24h

Validator.isFormat = function(selector) {
	return {
		selector: selector,
		test: function(value) {
			let regex = /^(1[0-2]|0?[1-9]):([0-5]?[0-9])(●?[AP]M)?$/;
			return regex.test(value) ? undefined : 'Vui lòng nhập đúng định dạng 24h '
		}
	};
}



// Rule mật khẩu
Validator.Minlength = function(selector, min) {
	return {
		selector: selector,
		test: function(value) {
			return value.length >= min ? undefined : 'Vui lòng nhập đủ ${min} kí tự'
		}
	};
}

// Rule xác nhận mật khẩu
Validator.isConfim = function(selector, getConfimValue) {
	return {
		selector: selector,
		test: function(value) {
			return value === getConfimValue() ? undefine : 'Giá trị nhập vào không chính xác'
		}
	};
}

// Rule ngày tháng lớn hơn hoặc = ngày hiện tại
Validator.isLogic = function(selector) {
	return {
		selector: selector,
		test: function(value) {
			console.log("Is value" + value);
			var curDate = new Date();

			// Lấy ngày hiện tại
			var curDay = curDate.getDate();
			if (curDay < 10) {
				curDay = "0" + curDate.getDate();
			}

			// Lấy tháng hiện tại
			curMonth = curDate.getMonth() + 1;
			if (curMonth < 10) {
				curMonth = "0" + (curDate.getMonth() + 1);
			}

			// Lấy năm hiện tại
			var curYear = curDate.getFullYear();
			if (curYear < 10) {
				curYear = "0" + (curDate.getFullYear());
			}
			var date1 = curYear + '-' + curMonth + '-' + curDay;
			console.log(date1);
			if (value >= date1) {
				return undefined;
			} else {
				return 'Ngay xuat phat phai lon hon ngay hien tai';
			}

		}
	};
}
// Rules email 
Validator.isDienThoai = function(selector) {
	return {
		selector: selector,
		test: function(value) {
			let regex = /(0123)+([0-9]{6})/;
			return regex.test(value) ? undefined : 'Nhap Dung dinh dang'
		}
	};
}
Validator.isSoDienThoaiTuan = function(selector) {
	return {
		selector: selector,
		test: function(value) {
			let regex = /^(0?)(3[2-9]|5[6|8|9]|7[0|6-9]|8[0-6|8|9]|9[0-4|6-9])[0-9]{7}$/;
			return regex.test(value) ? undefined : 'Phone is valid'
		}
	};
}

Validator.isDateEndGreaterThanStart = function(selectorStart, selectorEnd) {
	return {
		selector: selectorEnd,
		test: function(value) {
			let start = new Date(Date.parse($(selectorStart).val()));
			let end = new Date(Date.parse(value));
			if (end >= start) {
				return undefined;
			} else {
				return 'Ngày kết thúc phải lớn hơn hoặc bằng ngày bắt đầu';
			}
		}
	};
};




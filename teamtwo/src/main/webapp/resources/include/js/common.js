/**
 * 
 */

function changeVerifyCode(img) {
	/*
	 * 生成四位的随机数
	 */
	 img.src = "../Kaptcha?" + Math.floor(Math.random() * 100);
}

function getQueryString(name){
	var reg = new RegExp("(^|&)"+name+"=([^&]*)(&|$)");
	var r = window.location.search.substr(1).match(reg);
	if(r != null){
		return decodeURIComponent(r[2]);
	}
	return'';
}
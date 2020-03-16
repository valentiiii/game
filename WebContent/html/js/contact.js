// userの問い合わせ送信ボタン押下時
function userdt() {

	// 名前を取得
	var name = document.getElementById("name");
	// アドレスを取得
	var address = document.getElementById("address");
	// 問い合わせ内容を取得
	var content = document.getElementById("content");

	//アドレスに使用できない文字を判別するための正規表現
	var regexp = /^[A-Za-z0-9]+[\w-]+@[\w\.-]+\.\w{2,}$/;

	// 空白削除
	name.value = name.value.trim();
	address.value = address.value.trim();
	content.value = content.value.trim();

	// 名前が未入力の場合
	if (name.value == "") {
		alert("名前を入力してください");
		name.focus();
		return false;

	// アドレスが未入力の場合またはアドレスに@が含まれないまたは使用できない文字が含まれる場合
	} else if ((address.value == "" )||!(address.value.includes("@"))||!(address.value.match(regexp)))
			/*(address.value.match(/^[A-Za-z0-9]*$/)))*/{
		if(address.value == "" ){
			alert("アドレスを入力してください");
		}else if(!(address.value.includes("@"))){
			alert("アドレスを正しく入力してください");
		}else if(!(address.value.match(regexp))){
			alert("アドレスに使用できない文字が含まれています");
		}

		address.focus();
		return false;

	// 問い合わせ内容が未入力の場合
	} else if (content.value == "") {
		alert("問い合わせ内容を入力してください");
		content.focus();
		return false;

	}

	// ダイアログを表示
	return window.confirm('送信しますか？');
}
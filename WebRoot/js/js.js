//全选——反选
	function xuanzhong(){
		var str=document.getElementsByName("box");
		if(!!$("#checkbox").attr("checked")){
			for(var i=0;i<str.length;i++){
				str[i].checked=true;
			}
		}else{
			for(var i=0;i<str.length;i++){
				str[i].checked=false;
			}
		}
	}
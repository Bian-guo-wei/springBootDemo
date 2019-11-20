$(function(){
    //flushOneline();
});
function flushOneline(){
	$.ajax({
    	url : pcpath+'/publicUser/flushOnline',  
    	type:"POST",
    	dataType:"json",//json--返回json数据类型；xml--返回xml
    	data:{
    		loginFlag : "consult"
        },
        success : function(data, textStatus) {
			if (data.stauts == "1002") {
				$.Zebra_Dialog('该账号已在别处登录', {
	                'type': 'information',
	                'title': '在线信息',
					'onClose' : function() {
						window.location.href = pcpath+"/publicUser/sspLogin";
					}
	            });
			}
		},
        error : function(e) {
        	
        }
    });
	setTimeout("flushOneline()",20000);
}

<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title></title>
<script type="text/javascript">
	$(document).ready(function() {
		//         如果页面内容高度小于屏幕高度，div#footer将绝对定位到屏幕底部，否则div#footer保留它的正常静态定位
		if ($(document.body).height() < $(window).height()) {
			footerHeight = $("#footer").height();
			footerTop = ($(window).scrollTop() + $(window).height() - footerHeight - 40) + "px";
			//             $("#footer").css({ position: "absolute",left:"0" }).stop().css({top:footerTop}).stop().css({width:"100%"});
		}
		var obj = {
			name : '${sessionScope.unitId}' + "_footer",
			type : "1"
		};
		$.ajax({
			type : "post",
			dataType : "json",
			url : "${pageContext.request.contextPath}/publicUser/selectUnitBannerByName",
			data : obj,
			success : function(data, textStatus) {
				var bottom = data.footer;
				if (bottom != null && bottom != '') {
					$("#footer").html(bottom);
				} else {
					var date = new Date;
					var year = date.getFullYear();
					$("#footer").html("Copyright © " + year + " 学科服务平台");
				}
			}
		});
	});
</script>
</head>
<body>
	<div class="foot" align="center" id="footer"></div>
</body>
</html>
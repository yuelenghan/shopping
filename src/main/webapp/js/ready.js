/**
* 页面加载完毕时默认执行函数
* Author: H.yIng & Update Time: 2012-04-13
* Email: hyingreborn@qq.com
**/
$(function(){
	//制作期状态开关
	mydebug(true);
	
	//导航
	$(".nav a").hover(
	  function () {
		$(this).addClass("hover");
		$(this).parent().find('ul').fadeIn();
	  },
	  function () {
		$(this).removeClass("hover");
		$(this).parent().find('ul').hide();
	  }
	);
	//二级导航
	$(".nav li ul").hover(
	  function () {
		$(this).show();
		$(this).parent().find('a').addClass("hover");
		$(this).find('a').removeClass("hover");
	  },
	  function () {
		$(this).hide();
		$(this).parent().find('a').removeClass("hover");
	  }
	);
	
	//tab
	
	//筛选
	
	//翻页
	
});
$(function () {
        $("#txtBeginDate").calendar({
            controlId: "divDate",                                 // 弹出的日期控件ID，默认: $(this).attr("id") + "Calendar"
            speed: 200,                                           // 三种预定速度之一的字符串("slow", "normal", or "fast")或表示动画时长的毫秒数值(如：1000),默认：200
            complement: true,                                     // 是否显示日期或年空白处的前后月的补充,默认：true
            readonly: true,                                       // 目标对象是否设为只读，默认：true
            upperLimit: new Date(),                               // 日期上限，默认：NaN(不限制)
            lowerLimit: new Date("2011/01/01"),                   // 日期下限，默认：NaN(不限制)
            callback: function () {                               // 点击选择日期后的回调函数
            }
        });
        $("#txtEndDate").calendar();
    });

$('#money-manage').click(function(){
	$('.money-operate').slideDown();
	$('.back').fadeIn();
})
$('.close').click(function(){
	$('.money-operate').slideUp();
	$('.back').fadeOut();
})

$('#user_message').click(function(){
	$('.change-umessage').slideDown();
	$('.back').fadeIn();
})
$('.close').click(function(){
	$('.change-umessage').slideUp();
	$('.back').fadeOut();
})

$('#mamber-delay').click(function(){
	$('.member-delay').slideDown();
	$('.back').fadeIn();
})
$('.close').click(function(){
	$('.member-delay').slideUp();
	$('.back').fadeOut();
})

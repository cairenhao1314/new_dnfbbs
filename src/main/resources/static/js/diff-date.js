// 时间戳转换成刚刚、几分钟前、几小时前、几天前
function getDateDiff(dateTimeStamp){
    var result;
    var minute = 1000 * 60;
    var hour = minute * 60;
    var day = hour * 24;
    var halfamonth = day * 15;
    var month = day * 30;
    var now = new Date().getTime();

    //将 yyyy-MM-dd hh:mm:ss 转为date对象
    var thisTime = new Date(dateTimeStamp.replace(/-/g, '/'));

    var diffValue = now - thisTime;
    if(diffValue < 0){
        return;
    }
    var monthC =diffValue/month;
    var weekC =diffValue/(7*day);
    var dayC =diffValue/day;
    var hourC =diffValue/hour;
    var minC =diffValue/minute;
    if(monthC>=1){
        result = "" + dateTimeStamp.substr(0,10);
    }
    else if(weekC>=1){
        result = "" + dateTimeStamp.substr(0,10);
    }
    else if(dayC>=1){
        if (parseInt(dayC) == 1){
            result="昨天 "+dateTimeStamp.substr(10,9);
        }else if (parseInt(dayC) == 2){
            result="前天 "+dateTimeStamp.substr(10,9);
        }else{
            result=""+ parseInt(dayC) +"天前";
        }
    }
    else if(hourC>=1){
        result=""+ parseInt(hourC) +"小时前";
    }
    else if(minC>=1){
        result=""+ parseInt(minC) +"分钟前";
    }else{
        result="刚刚";
    }
    return result;
};
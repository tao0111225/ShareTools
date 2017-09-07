var cheerio = require('cheerio'),
    fs = require('fs');

// 读取书签html文件
fs.readFile('bookmarks_2017_8_6.html', 'utf-8',function(err,data){
    if(err){
        console.log("error");
    }else{
        parse(data);
    }
});

/**
	文件夹：单独提出来
	
	或者怎么跟上一级有联系

*/


var SingleArr = [];

function parse(html){

    // 加载html，使用常用的$符号
    var $ = cheerio.load(html);

    // 获取最外层的dt标签
    var $dl = $("dl").first();
    var $dt = $dl.children("dt").eq(0);

    // 从dt开始遍历dom树，生成对象
    var obj = foo($dt,"root");

    // 将对象转化为json字符串，添加额外参数使json格式更易阅读
    var s = JSON.stringify(SingleArr, null, 4);
	
	
	
	console.log(SingleArr);

    // 将json字符串写入json文件
    fs.writeFileSync('output.json', s);

    function foo($dt,fname){

        // h3标签为文件夹名称
        var $h3 = $dt.children("h3");

        if($h3.length == 0){

            // a标签为网址
            var $a = $dt.children("a");

            // 返回该书签的名称和网址组成的对象
            return $a.length > 0 ? {"name": $a.text(),"href": $a.attr('href'),"fname": fname,"isFolder": false } : null;
        }

        var h3 = $h3.text();
     //   var arr = [];
       // var objArr = [];

        // 获取下一级dt标签集合
        var $dl = $dt.children("dl");
        var $dtArr = $dl.children("dt");
        for(var i = 0; i < $dtArr.length; i++){

            // 遍历下一级dt标签
            var tmp = foo($dtArr.eq(i),h3);
			if(tmp.length == 0) continue ;

            // 将返回的对象push至子文件数组
            SingleArr.push(tmp);
        }

        // 创建文件夹与子文件数组的键值对
        //obj[h3] = arr;
	//	objArr.push(arr);
		
		//
		var folderName = {"fname": fname,"name": h3,"isFolder": true};
		SingleArr.push(folderName);

		/**
			SingleArr  只有一个list。
		*/
		

		
        // 返回该对象
        return "";
    }
}
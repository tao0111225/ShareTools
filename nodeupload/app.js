var fs = require('fs');
var express = require('express');
var multer  = require('multer');
var cheerio = require('cheerio');
var superagent = require('superagent');

var app = express();

var createFolder = function(folder){
    try{
        fs.accessSync(folder); 
    }catch(e){
        fs.mkdirSync(folder);
    }  
};

var uploadFolder = './upload/';

createFolder(uploadFolder);

// 通过 filename 属性定制
var storage = multer.diskStorage({
    destination: function (req, file, cb) {
        cb(null, uploadFolder);    // 保存的路径，备注：需要自己创建
    },
    filename: function (req, file, cb) {
        // 将保存文件名设置为 字段名 + 时间戳，比如 logo-1478521468943
        cb(null, file.fieldname + '-' + Date.now()+".html");  
    }
});

// 通过 storage 选项来对 上传行为 进行定制化
var upload = multer({ storage: storage })

// 单图上传
app.post('/upload', upload.single('logo'), function(req, res, next){
    var file = req.file;
	console.log('FileType%s :', file.mimetype);
    console.log('sourceoldName%s :', file.originalname);
    console.log('FileSize%s :', file.size);
    console.log('FilePath%s :', file.path);
	// 文件名
	console.log('filename %s :',file.filename)
	// 开始解析上传书签
	readHtml(file.path,file.filename);
    res.send({ret_code: '0'});
});

app.get('/form', function(req, res, next){
    var form = fs.readFileSync('./form.html', {encoding: 'utf8'});
    res.send(form);
});

app.listen(7777);

function readHtml(FileName,filename){
	// 读取书签html文件
fs.readFile(FileName, 'utf-8',function(err,data){
    if(err){
        console.log("error");
    }else{
        parse(data,filename);
    }
});
}
var SingleArr = [];

function parse(html,filename){

    // 加载html，使用常用的$符号
    var $ = cheerio.load(html);

    // 获取最外层的dt标签
    var $dl = $("dl").first();
    var $dt = $dl.children("dt").eq(0);

  // 从dt开始遍历dom树，生成对象
    var obj = foo($dt,"root");

    // 将对象转化为json字符串，添加额外参数使json格式更易阅读
    var s = JSON.stringify(SingleArr, null, 4);

	senFileTreeList(filename,s);
	
    // 将json字符串写入json文件
      fs.writeFileSync('./analysisHtml/'+filename+'.json', s);
	
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
		var folderName = {"fName": fname,"childName": h3,"isFolder": true};
		SingleArr.push(folderName);

		/**
			SingleArr  只有一个list。
		*/
		

		
        // 返回该对象
        return "";
    }
}

/**
  发送
	文件夹路径,
	文本内容
  到服务器
*/
function senFileTreeList(FilePathstr,FileContentstr){
	superagent.post('http://localhost:8888/bookmark/ParseBookMarkConversionTrees')
		.type('form')
		.send({FilePath : FilePathstr})
		.send({FileContent : FileContentstr})
		.end(function(err, res){
			 // todo 可以 优化  网页响应
			if(err){
				console.log('error');
			}else{
				console.log('success');  
			}
		})

}




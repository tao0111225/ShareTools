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

// ͨ�� filename ���Զ���
var storage = multer.diskStorage({
    destination: function (req, file, cb) {
        cb(null, uploadFolder);    // �����·������ע����Ҫ�Լ�����
    },
    filename: function (req, file, cb) {
        // �������ļ�������Ϊ �ֶ��� + ʱ��������� logo-1478521468943
        cb(null, file.fieldname + '-' + Date.now()+".html");  
    }
});

// ͨ�� storage ѡ������ �ϴ���Ϊ ���ж��ƻ�
var upload = multer({ storage: storage })

// ��ͼ�ϴ�
app.post('/upload', upload.single('logo'), function(req, res, next){
    var file = req.file;
	console.log('FileType%s :', file.mimetype);
    console.log('sourceoldName%s :', file.originalname);
    console.log('FileSize%s :', file.size);
    console.log('FilePath%s :', file.path);
	// �ļ���
	console.log('filename %s :',file.filename)
	// ��ʼ�����ϴ���ǩ
	readHtml(file.path,file.filename);
    res.send({ret_code: '0'});
});

app.get('/form', function(req, res, next){
    var form = fs.readFileSync('./form.html', {encoding: 'utf8'});
    res.send(form);
});

app.listen(7777);

function readHtml(FileName,filename){
	// ��ȡ��ǩhtml�ļ�
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

    // ����html��ʹ�ó��õ�$����
    var $ = cheerio.load(html);

    // ��ȡ������dt��ǩ
    var $dl = $("dl").first();
    var $dt = $dl.children("dt").eq(0);

  // ��dt��ʼ����dom�������ɶ���
    var obj = foo($dt,"root");

    // ������ת��Ϊjson�ַ�������Ӷ������ʹjson��ʽ�����Ķ�
    var s = JSON.stringify(SingleArr, null, 4);

	senFileTreeList(filename,s);
	
    // ��json�ַ���д��json�ļ�
      fs.writeFileSync('./analysisHtml/'+filename+'.json', s);
	
    function foo($dt,fname){

         // h3��ǩΪ�ļ�������
        var $h3 = $dt.children("h3");

        if($h3.length == 0){

            // a��ǩΪ��ַ
            var $a = $dt.children("a");

            // ���ظ���ǩ�����ƺ���ַ��ɵĶ���
            return $a.length > 0 ? {"name": $a.text(),"href": $a.attr('href'),"fname": fname,"isFolder": false } : null;
        }

        var h3 = $h3.text();
     //   var arr = [];
       // var objArr = [];

        // ��ȡ��һ��dt��ǩ����
        var $dl = $dt.children("dl");
        var $dtArr = $dl.children("dt");
        for(var i = 0; i < $dtArr.length; i++){

            // ������һ��dt��ǩ
            var tmp = foo($dtArr.eq(i),h3);
			if(tmp.length == 0) continue ;

            // �����صĶ���push�����ļ�����
            SingleArr.push(tmp);
        }

        // �����ļ��������ļ�����ļ�ֵ��
        //obj[h3] = arr;
	//	objArr.push(arr);
		
		//
		var folderName = {"fName": fname,"childName": h3,"isFolder": true};
		SingleArr.push(folderName);

		/**
			SingleArr  ֻ��һ��list��
		*/
		

		
        // ���ظö���
        return "";
    }
}

/**
  ����
	�ļ���·��,
	�ı�����
  ��������
*/
function senFileTreeList(FilePathstr,FileContentstr){
	superagent.post('http://localhost:8888/bookmark/ParseBookMarkConversionTrees')
		.type('form')
		.send({FilePath : FilePathstr})
		.send({FileContent : FileContentstr})
		.end(function(err, res){
			 // todo ���� �Ż�  ��ҳ��Ӧ
			if(err){
				console.log('error');
			}else{
				console.log('success');  
			}
		})

}




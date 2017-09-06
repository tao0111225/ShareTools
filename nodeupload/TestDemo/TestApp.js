var fs = require('fs');
var express = require('express');
var multer = require('multer')

var app = express();
var upload = multer({
    dest: 'upload/'
});

// ��ͼ�ϴ�
//multer��single()�е����Ʊ����Ǳ��ϴ��ֶε�name���ơ�
app.post('/upload', upload.single('logo'), function(req, res, next) {

    var file = req.file;
    console.log('�ļ����ͣ�%s', file.mimetype);
    console.log('ԭʼ�ļ�����%s', file.originalname);
    console.log('�ļ���С��%s', file.size);
    console.log('�ļ�����·����%s', file.path);

    res.send({
        ret_code: '0'
    });
});

app.get('/form', function(req, res, next) {
    var form = fs.readFileSync('./form.html', {
        encoding: 'utf8'
    });
    res.send(form);
});

app.listen(9999);


var cheerio = require('cheerio'),
    fs = require('fs');

// ��ȡ��ǩhtml�ļ�
fs.readFile('bookmarks_2017_9_8.html', 'utf-8',function(err,data){
    if(err){
        console.log("error");
    }else{
        parse(data);
    }
});

function parse(html){

    // ����html��ʹ�ó��õ�$����
    var $ = cheerio.load(html);

    // ��ȡ������dt��ǩ
    var $dl = $("dl").first();
    var $dt = $dl.children("dt").eq(0);

    // ��dt��ʼ����dom�������ɶ���
    var obj = foo($dt);

    // ������ת��Ϊjson�ַ�������Ӷ������ʹjson��ʽ�����Ķ�
    var s = JSON.stringify(obj, null, 4);

    // ��json�ַ���д��json�ļ�
    fs.writeFileSync('BookTreeHtmloutput.json', s);

    function foo($dt){

        // h3��ǩΪ�ļ�������
        var $h3 = $dt.children("h3");

        if($h3.length == 0){

            // a��ǩΪ��ַ
            var $a = $dt.children("a");

            // ���ظ���ǩ�����ƺ���ַ��ɵĶ���
            return $a.length > 0 ? {"name": $a.text(),"href": $a.attr('href')} : null;
        }

        var h3 = $h3.text();
        var arr = [];
        var obj = {};

        // ��ȡ��һ��dt��ǩ����
        var $dl = $dt.children("dl");
        var $dtArr = $dl.children("dt");
        for(var i = 0; i < $dtArr.length; i++){

            // ������һ��dt��ǩ
            var tmp = foo($dtArr.eq(i));

            // �����صĶ���push�����ļ�����
            arr.push(tmp);
        }

        // �����ļ��������ļ�����ļ�ֵ��
        obj[h3] = arr;

        // ���ظö���
        return obj;
    }
}
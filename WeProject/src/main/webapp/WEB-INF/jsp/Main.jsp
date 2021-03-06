<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<!DOCTYPE html >
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>demo</title>
    <meta name="Keywords" content="demo"/>
    <meta name="Description" content="demo"/>
    <meta http-equiv="Expires" content="-1">
    <meta http-equiv="Pragma" content="no-cache">
    <meta http-equiv="Cache-Control" content="no-cache">
    <meta name="format-detection" content="telephone=no">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <meta content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0;" name="viewport"/>

    <script src="../js/jquery-3.2.1.min.js" language="javascript" type="text/javascript"></script>
    <link href="../Weblib/font-awesome-4.7.0/css/font-awesome.min.css" rel="stylesheet">

    <script>
        $(function () {
            $(window).scroll(function () {
                //$("body").css({"background-position":"center "+$(window).scrollTop()+""});
                if ($(window).scrollTop() >= 0) {
                    $(".nav").addClass("fixedNav");
                } else {
                    $(".nav").removeClass("fixedNav");
                }
            });
        });
    </script>


    <style type="text/css">
        a, a:hover {
            text-decoration: none
        }

        html {
            -webkit-font-smoothing: antialiased
        }

        body, button, dd, dl, dt, form, h1, h2, h3, h4, h5, h6, input, li, ol, p, td, textarea, th, ul {
            margin: 0;
            padding: 0
        }

        body, button, input, select, textarea {
            font: 14px \5FAE\8F6F\96C5\9ED1, arial, \5b8b\4f53
        }

        h1, h2, h3, h4, h5, h6 {
            font-size: 100%
        }

        address, cite, dfn, em, i, var {
            font-style: normal
        }

        kbd, pre, samp {
            font-family: courier new, courier, monospace, arial, \5b8b\4f53
        }

        form {
            display: inline
        }

        small {
            font-size: 12px
        }

        ol, ul {
            list-style: none
        }

        a {
            color: #333
        }

        sup {
            vertical-align: text-top
        }

        sub {
            vertical-align: text-bottom
        }

        img {
            vertical-align: top;
            border: 0;
            -ms-interpolation-mode: bicubic
        }

        button, input, select, textarea {
            font-size: 100%;
            outline: 0
        }

        table {
            border-collapse: collapse;
            border-spacing: 0
        }

        textarea {
            resize: none
        }

        .clearfix {
            *zoom: 1
        }

        .clearfix:after {
            content: '\20';
            display: block;
            height: 0;
            clear: both
        }

        .hidden {
            display: none
        }

        body {
            background: -moz-linear-gradient(left, #30cfbd, #38789e);
        }

        div.nav {
            background: #000000;
            height: 57px;
            line-height: 57px;
            color: #ffffff;
            text-align: center;
            font-family: "微软雅黑", "黑体";
            font-size: 30px;
        }

        div.fixedNav {
            position: fixed;
            top: 0px;
            left: 0px;
            width: 100%;
            z-index: 100000;
            _position: absolute;
            _top: expression(eval(document.documentElement.scrollTop));
        }

        .container-2 {
            width: 300px;
            vertical-align: middle;
            white-space: nowrap;
            position: relative;
        }

        .container-2 input#search {
            width: 50px;
            height: 50px;
            background: #2b303b;
            border: none;
            font-size: 10pt;
            float: left;
            color: #262626;
            padding-left: 38px;
            -webkit-border-radius: 5px;
            -moz-border-radius: 5px;
            border-radius: 5px;
            color: #fff;

            -webkit-transition: width .55s ease;
            -moz-transition: width .55s ease;
            -ms-transition: width .55s ease;
            -o-transition: width .55s ease;
            transition: width .55s ease;
        }

        .container-2 .icon {
            position: absolute;
            top: 50%;
            margin-left: 17px;
            margin-right: 5px;
            margin-top: 17px;
            z-index: 1;
            color: #4f5b66;
        }

        .container-2 input#search::-webkit-input-placeholder {
            color: #65737e;
        }

        .container-2 input#search:-moz-placeholder { /* Firefox 18- */
            color: #65737e;
        }

        .container-2 input#search::-moz-placeholder { /* Firefox 19+ */
            color: #65737e;
        }

        .container-2 input#search:-ms-input-placeholder {
            color: #65737e;
        }

        .container-2 input#search:focus, .container-2 input#search:active {
            outline: none;
            width: 300px;
        }

        .container-2:hover input#search {
            width: 300px;
        }

        .container-2:hover .icon {
            color: #93a2ad;
        }

        .person {
            width: 140px;
            height: 200px;
            margin: 15px auto;
            background: #fff;
            text-align: center;
        }

        .content {
            width: 1064px;
            margin: 0 auto;
            height: 1000px;
            overflow: hidden;
        }

        .content-left {
            width: 144px;
            height: 186px;
            float: left;
            background: #fff;
            position: fixed;
        }

        .content-left li {
            height: 36px;
            line-height: 36px;
            text-align: center;
            color: #847264;
            border-bottom: 1px solid #f3f3f3;
        }

        .content-left li:last-child {
            border: none;
        }

        .content-right {
            width: 900px;
            height: 900px;
            float: right;
        }

        .search {
            margin-top: 15px;
            width: 300px;
            height: 50px;
            padding-right: 10px;
        }

        .stuly {
            background: #fff;
            height: 900px;
        }

        .stuly p {
            text-align: center;
            line-height: 60px;
        }

        .stuly ul {
            overflow: hidden;
            padding: 16px;
        }

        .stuly ul li {
            margin: 0 16px 16px;
            width: 110px;
            height: 110px;
            border: 1px solid #f3f3f3;
            float: left;
            background: #f1f1f1;
            text-align: center;
        }
    </style>
</head>
<body>
<div class="nav">导航栏</div>
<div class="person">个人资料</div>
<div class="content">
    <div class="content-left">
        <ul>
            <li>11111</li>
            <li>22222</li>
            <li>33333</li>
            <li>44444</li>
            <li>...</li>
        </ul>
    </div>
    <div class="content-right">

        <div class="search">
            <div class="container-2">
                <span class="icon"><i class="fa fa-search"></i></span>
                <input type="search" id="search" placeholder=" Search..."/>
            </div>

        </div>
        <div class="stuly">
            <p>PM学习交流</p>
            <ul>
                <li>内容</li>
                <li>内容</li>
                <li>内容</li>
                <li>内容</li>
                <li>内容</li>
                <li>内容</li>
                <li>内容</li>
                <li>内容</li>
                <li>内容</li>
                <li>内容</li>
                <li>内容</li>
                <li>内容</li>
                <li>内容</li>
                <li>内容</li>
                <li>内容</li>
                <li>内容</li>
                <li>内容</li>
                <li>内容</li>
                <li>内容</li>
                <li>内容</li>
                <li>内容</li>
            </ul>
        </div>
    </div>
</div>


</body>
</html>

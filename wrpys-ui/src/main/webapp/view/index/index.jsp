<%@ page language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <%@include file="../default/inc.jsp" %>
    <title>index</title>
</head>

<body>
<table id="tableObj" lay-filter="test"></table>
<script>
    //一般直接写在一个js文件中
    layui.use(['table'], function () {
        var table = layui.table;

        //第一个实例
        table.render({
            elem: '#tableObj'
            , height: 500
            , url: contentPath + '/test/findReqTextMessage'
            , page: true
            , cols: [[
                {field: 'toUserName', title: 'ToUserName', width: '20%', align: 'center'}
                , {field: 'fromUserName', title: 'FromUserName', width: '20%', align: 'center'}
                , {field: 'msgType', title: 'MsgType', width: '10%', align: 'center'}
                , {field: 'content', title: 'Content', width: '29%', align: 'center'}
                , {field: 'createTime', title: 'CreateTime', width: '20%', sort: true, align: 'center'}
            ]]
        });

    });
</script>
</body>
</html>
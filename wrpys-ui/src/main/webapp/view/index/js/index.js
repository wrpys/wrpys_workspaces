/**
 * Created by wrp on 2017/12/6.
 */
layui.use(['common', 'table'], function () {
    var table = layui.table;

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

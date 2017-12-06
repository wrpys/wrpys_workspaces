/**
 * Created by wrp on 2017/12/6.
 */
layui.define(['jquery'], function(exports){
    var common = {
        printLog: function (msg) {
            alert(msg);
        }
    };
    exports('common', common);
});
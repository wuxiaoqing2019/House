$(function(){
    //使用datagrid显示区域
    $('#dg').datagrid({
        title:"管理员信息",
        url:'getUser',  //服务器地址
        pagination:true,  //启用分页
        toolbar:"#ToolBar",  //工具栏
        rownumbers:true,  //显示行号
        //singleSelect:true,  //实现单行选择
        pageList:[3,6,9,15,20], //设置每页大小
        pageSize:3, //每页三条
        columns:[[
            {field:'ck',checkbox:true,width:100,align:'left'},
            {field:'id',title:'编号',width:100,align:'left'},
            {field:'name',title:'名称',width:100,align:'left'},
            {field:'telephone',title:'电话',width:100,align:'left'},
            {field:'opt',title:'操作',width:100,align:'left',
                formatter:function(value,row,index){
                    //发送同步请求
                    // return "<a href=\"delDistrict?id="+row.id+"\" class=\"easyui-linkbutton\" iconCls=\"icon-ok\">删除</a>";
                    //发送异步请求Ajax
                    return "<a href=\"javascript:DelType("+row.id+")\" class=\"easyui-linkbutton\" iconCls=\"icon-ok\">删除</a>";

                }}
        ]]
    });
});


/*实现Datagrid的搜索功能*/
function search(){
    //实现搜索查询
    //datagrid的load方法是重新加载，它会将查询条件，随着页码,页大小
    //一起发送到当前控制所指定的服务器地址进行处理
    //$("#dg").datagrid("load",传查询条件:{键:值,键:值});
    var s_name=$("#s_name").val();
    var s_tel=$("#s_tel").val();
    var s_startage=$("#s_startage").val();
    var s_endage=$("#s_endage").val();

    $("#dg").datagrid("load",{"name":s_name,"telephone":s_tel,"startAge":s_startage,"endAge":s_endage});

}
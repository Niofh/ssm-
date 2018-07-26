<%--
  Created by IntelliJ IDEA.
  User: oufuhua
  Date: 2018/7/23
  Time: 下午10:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>学生</title>
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">


    <link rel="stylesheet" href="${basePath}/mricode.pagination.css">

    <script src="https://cdn.bootcss.com/jquery/1.11.0/jquery.min.js"></script>
    <script src="${basePath}/mricode.pagination.js"></script>
    <script src="${basePath}/artTemplate/template-web-4.12.1.js"></script>
</head>
<body>
<div>
    <input type="text" name="name" id="name">
    <button id="btn">查询</button>
    <table id="table" class="table ">

    </table>
    <div id="page" class="m-pagination"></div>
</div>
<script id="test" type="text/html">
    <thead>
    <tr>
        <td>学生名称</td>
        <td>年龄</td>
        <td>性别</td>
        <td>地址</td>
    </tr>
    </thead>
    <tbody>
    {{each dataList item index }}
    <tr>
        <td>{{item.stuName}}</td>
        <td>{{item.age}}</td>
        <td>{{item.gender}}</td>
        <td>{{item.address}}</td>
    </tr>
    {{/each}}
    </tbody>
</script>
<script>
    $("#page").pagination({
        pageIndex: 0,
        pageSize: 1,
        showInfo: true,
        showJump: true,
        showPageSizes: true,
        loadFirstPage: true,
        showFirstLastBtn: true,
        firstBtnText: '首页',
        lastBtnText: '尾页',
        nextBtnText: '下一页',
        prevBtnText: '上一页',
        infoFormat: '总共 <span class="red">{total}</span> 条数据，每页显示',
        noInfoText: "暂无数据",
        pageElementSort: ['$page', '$info', '$size', '$kuozhang', '$jump'],
        pageSizeItems: [1, 5, 10, 20],
        remote: {
            url: 'http://localhost:8080/studentList',
            pageParams: function (data) {
                return {
                    name: $("#name").val().trim(),
                    pageIndex: data.pageIndex,
                    pageSize: data.pageSize
                };
            },
            success: function (data) {
                var html = template("test", data);
                $("#table").html(html)
            },
            totalName: 'totalRecord'
        }
    });
    $("#btn").on('click', function () {
        $("#page").pagination("remote")
    })
</script>
</body>
</html>

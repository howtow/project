<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2022/5/14
  Time: 下午 05:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<c:set var="contextRoot" value="${pageContext.request.contextPath}"/>
<link href="${contextRoot}/css/adminPage.css" rel="stylesheet">
<%--<jsp:include page="${contextRoot}/adminPage.jsp"/>--%>
<html>
<head>
    <title>更新會員資料</title>
    <link rel="stylesheet" href="https://unicons.iconscout.com/release/v4.0.0/css/line.css">
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"
            integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css"
          integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn" crossorigin="anonymous">

    <style>
        html,body{
            margin: 0px;
            padding: 0px;
        }
        .header{
            height: 100px;
            width: auto;
            background-color: #3C85E8;
            border: solid 1px black;

        }
        .info{
            text-align: justify;
        }
    </style>
</head>
<body>
<div class="container-fluid header ">
    <div class="row">
    <h1 class="info">會員資料</h1>
    </div>
</div>

<div class="container">
    <div class="row">
        <div class="col-1">
        </div>
        <div style="top:0;left: 0;" class="col-11 mt-3">
            <form:form action="${contextRoot}/postEditCustomer" modelAttribute="customerBean" method="POST">
                <div class="form-group">
                    <label for="customerEmail">電子信箱</label>
                    <form:input type="email" class="form-control" id="customerEmail" aria-describedby="emailHelp" path="email" cssStyle="width: 300px"/>
                </div>
                <div class="form-group">
                    <label for="customerPassword">密碼</label>
                    <form:input type="text" class="form-control" id="customerPassword" path="password" cssStyle="width: 300px"/>
                </div>
                <div class="form-group">
                    <label for="customerName">姓名</label>
                    <form:input type="text" class="form-control" id="customerName" aria-describedby="emailHelp" path="userName" cssStyle="width: 300px"/>
                </div>
                <div class="form-group">
                    <label for="customerPhone">電話</label>
                    <form:input type="text" class="form-control" id="customerPhone" aria-describedby="emailHelp" path="phone" cssStyle="width: 300px"/>
                </div>
                <div class="form-group">
                    <label for="customerBirthday">生日</label>
                    <form:input type="date" class="form-control" id="customerBirthday"  path="birthday"  pattern="yyyy-MM-dd" cssStyle="width: 300px"/>
                </div>
                <div class="form-group">
                    <label for="customerPhone">國家</label>
                    <form:input type="text" class="form-control" id="customerPhone"  path="nationality" cssStyle="width: 300px"/>
                </div>
                <div class="form-group">
                    <label>性別</label>
                    <form:input type="text" class="form-control" id="customerPhone"  path="gender" cssStyle="width: 300px"/>
<%--                    <form:select  path="gender">--%>
<%--                    <form:options value="男" label="男"/>--%>
<%--                    <form:options value="女" label="女"/>--%>
<%--                    </form:select>--%>
                </div>
                <div class="form-group">
                    <label for="customerAddress">地址</label>
                    <form:input type="text" class="form-control" id="customerAddress"  path="address" cssStyle="width: 500px"/>
                </div>
                <div class="form-group">
                    <label for="customerCreditCard">信用卡號</label>
                    <form:input type="text" class="form-control" id="customerCreditCard"  path="creditCard" cssStyle="width: 300px"/>
                </div>
                <div class="form-group">
                    <label for="customerState">不知道是啥</label>
                    <form:input type="text" class="form-control" id="customerState"  path="state" cssStyle="width: 300px"/>
                </div>

                <input type="submit" value="送出">
            </form:form>
        </div>
    </div>
</div>





<%--<script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"--%>
<%--        integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"--%>
<%--        crossorigin="anonymous"></script>--%>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"
        integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.min.js"
        integrity="sha384-VHvPCCyXqtD5DqJeNxl2dtTyhF78xXNXdkwX1CZeRusQfRKp+tA7hAShOK/B/fQ2"
        crossorigin="anonymous"></script>

</body>
</html>

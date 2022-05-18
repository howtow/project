<%--
  Created by IntelliJ IDEA.
  User: iii
  Date: 2022/5/13
  Time: 下午 04:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>更新旅館資料</title>
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-1">
        </div>
        <div style="top:0;left: 0;" class="col-11 mt-3">
            <form:form action="${contextRoot}/postEditHotel" modelAttribute="hotelBean" method="POST">
                <%--                沒加id欄位編輯會變成新增--%>
                <div class="form-group">
                    <label >ID</label>
                    <form:input type="text" class="form-control"  aria-describedby="emailHelp" path="hotelId" cssStyle="width: 300px" readonly="true"/>
                </div>
                <form:errors path="email"/>
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
                        <%--                    <form:input type="text" class="form-control" id="customerPhone"  path="gender" cssStyle="width: 300px"/>--%>
                    <form:select  path="gender">
                        <form:option value="男" label="男"/>
                        <form:option value="女" label="女"/>
                    </form:select>
                </div>
                <div class="form-group">
                    <label for="customerAddress">地址</label>
                    <form:input type="text" class="form-control" id="customerAddress"  path="address" cssStyle="width: 500px"/>
                </div>
                <div class="form-group">
                    <label for="customerCreditCard">信用卡號</label>
                    <form:input type="text" class="form-control" id="customerCreditCard"  path="creditCard" cssStyle="width: 300px" pattern="[0-9]{13,16}" />
                </div>
                <div class="form-group">
                    <form:input type="hidden" class="form-control" id="customerState"  path="state" cssStyle="width: 300px"/>
                </div>

                <input type="submit" value="送出">
            </form:form>
        </div>
    </div>
</div>
</body>
</html>

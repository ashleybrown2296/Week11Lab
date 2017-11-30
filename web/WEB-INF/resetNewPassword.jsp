<%-- 
    Document   : resetNewPassword
    Created on : Nov 20, 2017, 1:11:07 PM
    Author     : 679918
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <title>Reset Password</title>
    </head>
    <body>
        <h1>Enter a new Password</h1>
        <form name="reset" method="post">
            <p><input type="text" name="newpassword" value=""></p>
        <input type="hidden" name="uuid" value="${uuid}">
        <input type="submit" value="Submit">
        </form>
    ${message}    
    </body>
</html>

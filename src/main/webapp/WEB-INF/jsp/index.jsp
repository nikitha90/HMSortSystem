<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<head>
    <meta charset="UTF-8">
    <title>Sort Numbers Application</title>
    <style>
        .sampleTextStyle {
            font-style: italic;
            font-size: smaller;
            font-family: 'Times New Roman';
            color: darkblue;
        }

        .tableHeadertext {
            font-family: 'Comic Sans MS';
            font-size: xx-large;
            color: darkblue;
        }

        .inputLabel {
            font-size: 14px;
            font-family: "Lucida Calligraphy";
        }

    </style>
</head>
<body>
<form action="/hm/sortNumbers" method="post">

    <br/>
    <br/>
    <br/>
    <div align="center">
        <span> <label class="tableHeadertext"> HM Sort System </label> </span>
    </div>
    <br/>
    <table align="center">

        <tr>
            <td><span><label class="inputLabel"> Please enter numbers to be sorted </label> </span>
                <span style="font-family: 'Lucida Calligraphy'; font-size: x-small">  (max 50 numbers) :</span>
            </td>
            <td><input type="text" name="inputNumbers"/></td>
        </tr>
        <tr></tr>
        <tr></tr>
        <tr></tr>
        <tr></tr>
        <tr></tr>
        <tr>
            <td><label class="sampleTextStyle">Number sequences to be separated by comma (Ex: 1,4,15, 8)</label></td>
            <td></td>
        </tr>
        <tr></tr>
        <tr></tr>
        <tr></tr>
        <tr></tr>
        <tr></tr>
        <tr>
            <td></td>
            <td align="right"><input type="submit" value="Sort"/></td>
        </tr>
    </table>
</form>

<br/>
<br/>
<br/>

<form action="/hm/viewHistory" method="get">

    <table align="center">
        <tr>
            <td class="inputLabel"> Click the button to view sort History:</td>
            <td></td><td></td><td></td><td></td><td></td><td></td><td></td>
            <td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td>
            <td></td><td></td><td></td><td></td><td></td><td></td>
            <td></td><td></td><td></td><td></td><td></td><td></td>
            <td></td><td></td><td></td><td></td>
            <td align="right"><input type="submit" value="View Sort History"></td>
        </tr>
    </table>
</form>
</body>
</html>

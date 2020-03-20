<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Sort Numbers Application</title>
    <style>
        .tableHeadertext {
            font-family: 'Comic Sans MS';
            font-size: xx-large;
            color: darkblue;
        }

        .inputLabel {
            font-size: 16px;
            font-family: "Lucida Calligraphy";
        }
    </style>
</head>
<body>
<h4 class="tableHeadertext" align="center"> Sort System Results </h4>
<table align="center">

    <tr>
        <td><label class="inputLabel"> Actual list before sorting : </label></td>
        <td> ${actualList} </td>
    </tr>
    <tr></tr>
    <tr></tr>
    <tr></tr>
    <tr></tr>
    <tr></tr>
    <tr></tr>
    <tr></tr>
    <tr></tr>
    <tr>
        <td><label class="inputLabel"> Sorted List : </label></td>
        <td> ${sortedList} </td>
    </tr>
    <tr></tr>
    <tr></tr>
    <tr></tr>
    <tr></tr>
    <tr></tr>
    <tr></tr>
    <tr></tr>
    <tr></tr>
    <tr>
        <td><label class="inputLabel"> <span>Time taken to sort </span> <span style="font-size: small">(in ms): </span> </label></td>
        <td> ${sortTime} </td>
    </tr>
    <tr></tr>
    <tr></tr>
    <tr></tr>
    <tr></tr>
    <tr></tr>
    <tr></tr>
    <tr></tr>
    <tr></tr>
    <tr>
        <td><label class="inputLabel"> No of positions shifted: </label></td>
        <td> ${shiftPositions} </td>
    </tr>
    <tr></tr>
    <tr></tr>
    <tr></tr>
    <tr></tr>
    <tr></tr>
    <tr></tr>
    <tr></tr>
    <tr></tr>
    <tr>
        <td> <a href="/index"> Click and try different set of sequence </a> </td>
    </tr>
</table>
</body>
</html>
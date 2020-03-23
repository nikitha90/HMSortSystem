<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Arrays"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
            font-size: 20px;
            font-family: "Lucida Calligraphy";
        }

        .historyData {
              font-size: 16px;
              font-family: 'Comic Sans MS';
                }
    </style>
</head>
<body>
<h4 class="tableHeadertext" align="center"> Sort History Results </h4>
<table align = "center" border = "1">
<thead>
<tr bgcolor="#f5f5dc" class="inputLabel">
			<th>Actual List</th>
			<th>Sorted List</th>
			<th>Sort Time (in ms)</th>
			<th>Positions Shifted</th>
</tr>
</thead>
<tbody>
<c:forEach var="listItems" items="${sortHistorySortedList}">
<tr class="historyData">
<td><label>${listItems.inputList}</label></td>
<td><label>${listItems.sortedList}</label></td>
<td align="center"><label>${listItems.sortTime}</label></td>
<td align="center"><label>${listItems.shiftPositions}</label></td>
</tr>
</c:forEach>
</tbody>
</table>
<br/>
<br/>
<table align = "center">
<tr>
<td> <a href="/index"> Go back to Home Page </a> </td>
</tr>
</table>
</body>
</html>
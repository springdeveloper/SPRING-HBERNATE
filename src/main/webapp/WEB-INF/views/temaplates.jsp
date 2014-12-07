<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>EM</title>
<script src= "http://ajax.googleapis.com/ajax/libs/angularjs/1.2.26/angular.min.js"></script>
</head>
<body>
<div ng-app="" ng-controller="customersController">
 
   <table>
  <tr ng-repeat="x in names">
    <td>{{ x.id }}</td>
    <td>{{ x.name }}</td>
  </tr>
</table>
   </div>
  
<script>
function customersController($scope,$http) {
    var site = "http://localhost:8086/Hibenate_springmvc";
    var page = "/rest/student/dummy";
    $http.get(site + page)
    .success(function(response) {$scope.names = response.messages;});
}
</script>
</body>
</html>
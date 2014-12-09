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
    <table class="add-task">
					<tr>
						<td> Name:</td>
						<td><input type="text" ng-model="person.name"/></td>
					</tr>
					<tr>
						<td>Address:</td>
						<td><input type="text" ng-model="person.address"/></td>
					</tr>
                    <tr>
						<td> Phone:</td>
						<td><input type="text" ng-model="person.phoneno"/></td>
					</tr>
					
					
					<tr>
						<td><br/><button ng-click="addTask()" class="btn-panel-big">Add New Task</button></td>
					</tr>
				</table>	
   </div>
  
<script>
function customersController($scope,$http) {
    var site = "http://localhost:8086/SPRING-HBERNATE";
    var page = "/rest/student/dummy";
    $http.get(site + page)
    .success(function(response) {$scope.names = response.messages;});




$scope.addTask = function addTask() {
		
		 $http.post('http://localhost:8086/SPRING-HBERNATE/rest/student/create/',$scope.person).
		  success(function(data) {
			 alert("Task added"+data);
					 
		    });
                    
                 $http.get(site + page)
                .success(function(response) {$scope.names = response.messages;});
     
                    
                    
		}
	};








</script>
</body>
</html>
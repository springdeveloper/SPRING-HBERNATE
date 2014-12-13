<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>EM</title>
        <link href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css" rel="stylesheet">   
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
<link rel="stylesheet" 
href="http://cdn.datatables.net/1.10.2/css/jquery.dataTables.min.css"></style>
<script type="text/javascript" 
src="http://cdn.datatables.net/1.10.2/js/jquery.dataTables.min.js"></script>
<script type="text/javascript" 
src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
        <script src= "http://ajax.googleapis.com/ajax/libs/angularjs/1.2.26/angular.min.js"></script>
    </head>
    <body>
        <div ng-app="" ng-controller="customersController">

<table class="table table-striped">
<thead>
<th>S.No</th>
<th>Name</th>
<th>Address</th>
<th>Phone No</th>
<th>Edit</th>
<th>Delete</th>
</thead>
<tbody>
                  <tr ng-repeat="x in names">
                 <td>{{$index }}</td>
                        
                        <td>{{ x.name}}</td>
                      <td>{{ x.address}}</td>
                       <td>{{ x.phoneno}}</td>
                    <td> <button class="btn btn-danger" ng-click="edite(x)">Edit</button></td>
                     <td> <button class="btn btn-danger" ng-click="delet(x)">Delet</button></td>
                   
                      </tr>
                           </tbody>
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

<input type="hidden" ng-model="person.id"/>
                <tr>
                    <td><br/><button ng-click="addTask()" class="btn-panel-big">{{values}}</button></td>
                </tr>
            </table>
     
        
        </div>

        <script>
            function customersController($scope, $http) {
            	$scope.values="Add";
                var site = "http://localhost:8080/Hibenate_springmvc";
                var page = "/rest/student/dummy";
                $http.get(site + page)
                        .success(function (response) {
                            $scope.names = response.messages;
                        });


                $scope.load = function load() {

                    var site = "http://localhost:8080/Hibenate_springmvc";
                    var page = "/rest/student/dummy";
                    $http.get(site + page)
                            .success(function (response) {
                                $scope.names = response.messages;
                            });

                }
            


                $scope.addTask = function addTask() {

                    $http.post('http://localhost:8080/Hibenate_springmvc/rest/student/create/', $scope.person).
                            success(function (response) {
                                $scope.hell = response.text;
                                console.log($scope.hell)
                            });

                    $scope.load();
                }
            
                   $scope.edite = function edite(x) {
                	   $http.get('http://localhost:8080/Hibenate_springmvc/rest/student/'+x.id).
                       success(function (response) {
                           $scope.person = response.kk;
                           console.log($scope.hell)
                       });
                	      $scope.load();
                       $scope.values="Update";
   }
          $scope.delet=function delet(x){
        	  $http.delete('http://localhost:8080/Hibenate_springmvc/rest/student/'+x.id).
        	  success(function(response){
        		  $scope.msg = response.messages; 
        	      $scope.load();
        	  });
        	
        	  }
        	  
        	  
                
                   
                   
                   
            };


            








        </script>
    </body>
</html>
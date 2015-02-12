 <!DOCTYPE html>
 <html>

 <head>
 	<script src="http://ajax.googleapis.com/ajax/libs/angularjs/1.2.26/angular.min.js"></script>
 	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
 </head>

 <body>

 	<div ng-app="" ng-controller="classementController">
 		<div class="row">
 		<div class="form-group">
 		 <div class="col-xs-3">
 			<input class="form-control "type="text" ng-model="pseudo" placeholder="pseudo">
 		</div>
 		<div class="col-xs-3">
 		  	<input class="form-control" type="text" ng-model="score" placeholder="score">
 		  	</div>
	 		    <div class="col-xs-3">
	 		  	 <button class="btn btn-default"ng-click="createPlayer()">Creer</button>	  
	 		   	<button class="btn btn-default"ng-click="updatePlayer()">Modifier</button>
	 		   	 <button class="btn btn-default" ng-click="getPlayer()">Visualiser</button>
	 		   </div>
 		   </div>
  		</div>
 		
  		<p>{{player.pseudo + ' - ' + player.score +' - '+ player.classement}}</p>

  		<table class="table table-hover">
  			<th></th>
  			<th>Pseudo</th>
  			<th>Score</th>
  			<tr ng-repeat="x in players">
  			<td></td>
  			<td > {{x.pseudo}} </td>
  			<td > {{x.score}} </td>
  		
  			</tr>
		</table>
 		

 	</div>

 	<script>

 		function classementController($scope,$http) {
 			$scope.getClassement = function() {
	 			$http.get("http://localhost:8080/classement-joueurs-1.0-SNAPSHOT/rest/getClassement/")
	 			.success(function(response) {$scope.players = response.players;});
 			};
 			 $scope.createPlayer = function() {
        		$http.post("http://localhost:8080/classement-joueurs-1.0-SNAPSHOT/rest/createPlayer/"+$scope.pseudo +"/"+$scope.score)
	 			.success(function(response) {$scope.players=$scope.getClassement();});
    		 };
    		 $scope.updatePlayer = function() {
        		$http.post("http://localhost:8080/classement-joueurs-1.0-SNAPSHOT/rest/updatePlayer/"+$scope.pseudo +"/"+$scope.score)
	 			.success(function(response) {$scope.players=$scope.getClassement();});
    		 };
    		 $scope.getPlayer = function() {
        		$http.get("http://localhost:8080/classement-joueurs-1.0-SNAPSHOT/rest/getPlayer/"+$scope.pseudo)
	 			.success(function(response) {$scope.player=response});
    		 };
    		 $scope.players= $scope.getClassement();
 		}
 	</script> 

 </body>
 </html> 

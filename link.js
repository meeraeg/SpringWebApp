var app = angular.module("myApp", ["ngRoute"]);

//route

app.config('$routeProvider' [function($routeProvider){
	$routeProvider
	.when("/studntForm", {
		templateUrl : "student_form_add.html",
		controller : "studCntrl"
	})
	.when("/studntDtls", {
		templateUrl : "student_details_view.html",
		controller : "dispCntrl"
	});
}]);

//add

app.factory('AddDetails', ['$http', '$q', function($http, $q){
	return {
		postData : function (student){
			console.log(student.name);
			var defer = $q.defer();
			$http({
				method: 'POST',
				url: '/add',
				data: student
			}).then(function (response){
				console.log('success 1');
				defer.resolve(response);
			}, function (response){
				console.log('error 1');
   					defer.reject(response);
   				});
   			return defer.promise;
   		}
	};
}]);

app.controller('studCntrl', ['$scope', 'AddDetails', 
    function($scope, AddDetails){
		$scope.student = {name : "", age : null, id : null};
		$scope.submitForm = function(){
			AddDetails.postData($scope.student).then(function (data){
				console.log('success');
			},
			function(data){
				console.log('error')
			});
			$scope.resetForm();
		}
	
		$scope.resetForm = function(){
			$scope.student = {name : "", age : null, id : null};
		}
   		
}]);

//update, delete

app.controller('dispCntrl', ['$scope', '$http', 
 	function($scope, $http){
 		$scope.student = [];
 		$scope.editRec = {};
 		$http.get('/view').then(function (response){
 			$scope.student = response.data;
 			console.log($scope.student);
 		});
 		
 		for (var i = 0, length = $scope.student.length; i < length; i++) {
 			$scope.editingData[i] = false;
 		}
 		
 		$scope.modifyData = function(index){
 				$scope.editRec[index] = true;
 		}
 		
 		$scope.updateData = function(index, student){
 				$scope.editRec[index] = false;
 				console.log(student.id);
 				$http({
 					method: 'PUT',
 					url: '/update/'+student.id,
 					data: student
 				}).then(function (response){
 					console.log('success');
 					$scope.student = response.data;
 				}, function (response){
 					console.log('error');
 				});
 				$http.get('/view').then(function (response){
 					$scope.student = response.data;
 				});
 		}
 		
 		$scope.deleteData = function(student){
 				console.log(student.id);
 				$http({
 					method: 'DELETE',
 					url: '/delete/'+student.id,
 					data: student
 				}).then(function (response){
 					console.log('success');
 					$scope.student = response.data;
 				}, function (response){
 					console.log('error');
 				});
 				$http.get('/view').then(function (response){
 					$scope.student = response.data;
 				});
 		}
 		
}]);
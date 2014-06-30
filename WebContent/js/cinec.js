function cinecCtrl($scope, $http){
	$scope.films = [];
	$http.get('json/hello').success(function (data){
		$scope.films = data;
	});
	
}
define([], function(){
	return function($scope, $location, $route, MedicoService, medicos){
		$scope.medicos = medicos;
		
		$scope.remove = function(_id){
			MedicoService.remove(_id).then(function(success){
				$route.reload();
			});
		}
	}
});
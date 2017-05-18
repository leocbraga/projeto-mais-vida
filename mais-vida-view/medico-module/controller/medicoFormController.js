define([], function(){
	return function($scope, $location, MedicoService, especialidades, status, estados, medico){
		$scope.especialidades = especialidades;
		$scope.status = status;
		$scope.estados = estados;
		$scope.medico = medico ? medico : {};

		$scope.salvar = function(medico){
			MedicoService.save(medico).then(function(success){
				$location.path("/medicos");
			});
		}
	}
});
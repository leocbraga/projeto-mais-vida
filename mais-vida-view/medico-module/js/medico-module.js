define(["angular", "ngRoute", "ngTranslate", "medicoValue", "appValue", "medicoController", "medicosController", "medicoFormController", "medicoService", "especialidadeService", "estadoService", "statusService", "loginService"], function(angular, ngRoute, ngTranslate, medicoValue, appValue, medicoController, medicosController, medicoFormController, medicoService, especialidadeService, estadoService, statusService, loginService){
	var _medicoModule = angular.module("medicoModule", ["ngRoute", "ngResource", "pascalprecht.translate"]);
	
	//Value
	angular.module("medicoModule").factory("MedicoValue", medicoValue(appValue.baseUrl));
	
	
	//Service
	angular.module("medicoModule").factory("MedicoService", ["MedicoValue", "$resource", medicoService]);
	angular.module("medicoModule").factory("EspecialidadeService", ["MedicoValue", "$resource", especialidadeService]);
	angular.module("medicoModule").factory("EstadoService", ["MedicoValue", "$resource", estadoService]);
	angular.module("medicoModule").factory("StatusService", ["MedicoValue", "$resource", statusService]);		

	//Controllers
	angular.module("medicoModule").controller("MedicosController", ["$scope", "$location", "$route", "MedicoService", "medicos", medicosController]);
	angular.module("medicoModule").controller("MedicoController", ["$scope", "$location", "$route", "medico", medicoController]);
	
	angular.module("medicoModule").controller("MedicoFormController", ["$scope", "$location", "MedicoService", "especialidades", "status", "estados", "medico", medicoFormController]);
});
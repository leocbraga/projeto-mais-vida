define([], function(){
	return function($routeProvider, MedicoService, EspecialidadeService, EstadoService, StatusService){
		
		$routeProvider.when("/medicos", {
	        templateUrl: "medico-module/view/medicos.html",
	        controller: "MedicosController",
	        resolve: {
	        	medicos: function(MedicoService){
	        		return MedicoService.findAll();
	        	}
	        }
		});

		$routeProvider.when("/medicos/:id/atualizar", {
	        templateUrl: "medico-module/view/medicoForm.html",
	        controller: "MedicoFormController",
	        resolve: {
			estados: function(EstadoService){
	        		return EstadoService.findAll();
	        	},
			especialidades: function(EspecialidadeService){
	        		return EspecialidadeService.findAll();
	        	},
			status: function(StatusService){
	        		return StatusService.findAll();
	        	},
			medico: function($route, MedicoService){
	        		return MedicoService.findOne($route.current.params.id);
	        	}
	        }
		});
		
		$routeProvider.when("/medicos/adicionar", {
	        templateUrl: "medico-module/view/medicoForm.html",
	        controller: "MedicoFormController",
	        resolve: {
	        	estados: function(EstadoService){
	        		return EstadoService.findAll();
	        	},
			especialidades: function(EspecialidadeService){
	        		return EspecialidadeService.findAll();
	        	},
			status: function(StatusService){
	        		return StatusService.findAll();
	        	},
			medico: function(){
	        		return {};
	        	}
			
	        }
		});

		$routeProvider.when("/login", {
			templateUrl: "app-module/view/login.html",
			controller: "AppMainController",
			resolve: {
				
			}
		});

		$routeProvider.when("/medico/:id", {
	        templateUrl: "medico-module/view/medico.html",
	        controller: "MedicoController",
	        resolve: {
	        	medico: function($route, MedicoService){
	        		return MedicoService.findOne($route.current.params.id);
	        	}
	        }
		});

		$routeProvider.otherwise({redirectTo:'/medicos'});
	}
});
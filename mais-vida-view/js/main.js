/**
 * Configuração de paths e dependências
 */
requirejs.config({
    baseUrl: "./",
    paths: {
    	app: "app-module/js/app",
    	
    	 /**
         * Jquery
         */
        jquery: "js/bower_components/jquery/dist/jquery",
    	
    	/**
    	 * Angular
    	 */
    	angular: "js/bower_components/angular/angular",
    	ngRoute: "js/bower_components/angular-route/angular-route",
        ngResource: "js/bower_components/angular-resource/angular-resource",
        ngTranslate: "js/bower_components/angular-translate/angular-translate",
//        ngMaterial: "js/bower_components/material-design-lite/material.min.js",
        	
        	
    	/**
    	 * App-Module
    	 */
         appModule: "app-module/js/app",
         appValue: "app-module/value/appValue",
         appConfig: "app-module/config/appConfig",
         appMainController: "app-module/controller/appMainController",
        	 
         /**
          * Medico-Module
          */
         medicoModule: "medico-module/js/medico-module",
         medicoValue: "medico-module/value/medicoValue",
         medicoService: "medico-module/service/medicoService",
		 especialidadeService: "medico-module/service/especialidadeService",
		 statusService: "medico-module/service/statusService",
		 estadoService: "medico-module/service/estadoService",
		 loginService: "medico-module/service/loginService",
         medicosController: "medico-module/controller/medicosController",
		 medicoController: "medico-module/controller/medicoController",
         medicoFormController: "medico-module/controller/medicoFormController"
    },
    shim: {
    	angular: {
    		exports: "angular",
    		deps: ["jquery"]
    	},
    	ngRoute: {
    		deps: ["angular"],
    	},
    	ngResource: {
    		deps: ["angular"]
    	},
    	ngTranslate: {
    		deps: ["angular"]
    	},
    	ngMaterial: {
    		deps: ["angular"]
    	},
    	
    	/**
    	 * App-Module
    	 */
    	appValue: {
    		deps: ["angular"]
    	},
    	appConfig: {
    		deps: ["angular", "ngRoute"]
    	},
    	appMainController: {
    		deps: ["angular"]	
    	},
    	appModule: {
    		deps: ["appValue", "appConfig", "appMainController", "medicoModule"]
    	},
    	
    	/**
    	 * Médico Module
    	 */
    	medicoValue: {
    		deps: ["angular"]
    	},
    	medicoService: {
    		deps: ["medicoValue", "ngResource"]
    	},
		especialidadeService: {
    		deps: ["medicoValue", "ngResource"]
    	},
		statusService: {
    		deps: ["medicoValue", "ngResource"]
    	},
		loginService: {
    		deps: ["medicoValue", "ngResource"]
    	},
		estadoService: {
    		deps: ["medicoValue", "ngResource"]
    	},
    	medicoMainController: {
    		deps: ["angular", "medicoService"]
    	},
    	medicoFormController: {
    		deps: ["angular", "medicoService"]
    	},
    	medicoModule: {
    		deps: ["medicosController", "medicoController", "medicoFormController"]
    	}
    }
}); 

/**
 * Iniciando o bootstap AMD
 */
require(["app"], function(app){
	angular.bootstrap(document, ["app"]);
});

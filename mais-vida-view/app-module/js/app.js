define(["angular", "ngRoute", "ngTranslate", "appConfig", "appValue", "appMainController", "medicoModule", "loginService"], function(angular, ngRoute, ngTranslate, appConfig, appValue, appMainController, medicoModule, loginService){
	
	//Criando os módulos
	angular.module("app", ["ngRoute", "pascalprecht.translate", "medicoModule"]);
	
	//Adicionando Value
	angular.module("app").value("AppValue", appValue);
	
	
	//Adicionando Configuradores
	angular.module("app").config(["$routeProvider", appConfig]);
	
	//Adicionando Controller
	angular.module("app").controller("AppMainController", ["$scope", "LoginService", "$window", "$location", appMainController]);

	angular.module("app").factory("LoginService", ["MedicoValue", "$resource", "$window", loginService]);

	angular.module("app").factory('http-interceptor', ["$location", "$window", function($location, $window) {  
		
		var interceptor = {
			request: function(config) {		
				

				// config.headers['Authorization'] =$window.localStorage["token"];
				// config.headers['leo'] ="leo";
				console.log(config);
				// config.headers.authorization = "Bearer " +$window.localStorage["token"];

				// $http.defaults.headers.common['Authorization'] = $window.localStorage["token"];
config.headers.leo = "lansd";
				return config;
			},
			responseError: function(response){
				if(response.status == 403){
					$location.path("login");
				}

				return response;
			}
		};
		return interceptor;
	}]);
	angular.module("app").config(['$httpProvider', function($httpProvider) {  
		// $httpprovider.defaults.headers.common
		$httpProvider.interceptors.push('http-interceptor');
	}]);

	
});
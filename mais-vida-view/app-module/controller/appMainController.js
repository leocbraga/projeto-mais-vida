define([], function(){
	return function($scope, LoginService, $window, $location){
		$scope.usuario = {};
		$scope.msgErro = null;

		$scope.logar = function(usuario){
			LoginService.login(usuario).then(function(result){
				if(result.token){
					$window.localStorage["token"] = result.token;
					$location.path("medicos");
				}else{
					$scope.msgErro = "Não foi possível realizar o login";
				}

			}, function(error){

				$scope.msgErro = "Não foi possível realizar o login";
			});
		}

		$scope.isLogado = function(){
			return $window.localStorage["token"];
		}

		$scope.logout = function(){
			delete $window.localStorage["token"];

			$location.path("login");
		}
	}
});

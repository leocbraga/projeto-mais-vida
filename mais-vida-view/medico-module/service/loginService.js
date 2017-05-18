define([], function(){
	return function (MedicoValue, $resource){

		var _resources = {
			login: $resource(MedicoValue.urlLogin, {}, 
				{
					login: {method: "POST"}
				}
			)		
		};
		
		return {
			login: function(_login){
				return _resources.login.login(_login).$promise;
			},
            token: null
		}
	}
});
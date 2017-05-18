define([], function(){
	return function (AppValue, $resource){
		var _resources = {
			login: $resource(AppValue.urLogin, {}, 
				{
					login: {method: "POST"}
				}
			)		
		};
		
		return {
			login: function(){
				return _resources.login.login({}).$promise;
			}
		}
	}
});
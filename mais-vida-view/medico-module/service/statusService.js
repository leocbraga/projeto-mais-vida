define([], function(){
	return function (MedicoValue, $resource){
		var _resources = {
			status: $resource(MedicoValue.urlStatus, {}, 
				{
					query: {method: "GET", isArray: true}
				}
			)			
		};
		
		return {
			findAll: function(){
				return _resources.status.query({}).$promise;
			}
		}
	}
});
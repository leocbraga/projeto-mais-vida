define([], function(){
	return function (MedicoValue, $resource){
		var _resources = {
			estados: $resource(MedicoValue.urlEstados, {}, 
				{
					query: {method: "GET", isArray: true}
				}
			)		
		};
		
		return {
			findAll: function(){
				return _resources.estados.query({}).$promise;
			}
		}
	}
});
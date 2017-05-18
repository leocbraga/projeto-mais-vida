define([], function(){
	return function (MedicoValue, $resource){
		var _resources = {
			especialidades: $resource(MedicoValue.urlEspecialidades, {}, 
				{
					query: {method: "GET", isArray: true}
				}
			)		
		};
		
		return {
			findAll: function(){
				return _resources.especialidades.query({}).$promise;
			}
		}
	}
});
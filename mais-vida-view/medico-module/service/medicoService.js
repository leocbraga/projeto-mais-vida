define([], function(){
	return function (MedicoValue, $resource){
		var _resources = {
			medicos: $resource(MedicoValue.urlMedicos, {}, 
				{
					query: {method: "GET", isArray: true},
					create: {method: "POST"}
				}
			),
			medico: $resource(MedicoValue.urlMedico, {},
				{
					get: {method: "GET", params: {id: "@id"}}
				}
			)
					
		};
		
		return {
			findAll: function(){
				return _resources.medicos.query({}).$promise;
			},
			findOne: function(_id){
				return _resources.medico.get({id: _id}).$promise;
			},
			save: function(medico){
				return _resources.medicos.create(medico).$promise;
			},
			remove: function(_id){
				return _resources.medico.remove({id: _id}).$promise;
			}
		}
	}
});
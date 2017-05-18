define([], function(){
	return function(baseUrl){
		return function(){
			return {
				urlMedicos: baseUrl + "api/medicos/",
				urlMedico: baseUrl + "api/medicos/:id",
				urlEspecialidades: baseUrl + "api/especialidades",
				urlStatus: baseUrl + "api/status",
				urlEstados: baseUrl + "api/ufs",
				urlLogin: baseUrl + "login"
			}
		}
	}
});
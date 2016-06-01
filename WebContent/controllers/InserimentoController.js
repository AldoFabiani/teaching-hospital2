angular.module('teaching').controller("InserimentoController",
		[ '$http', function($http) {
			
			// Inserisce un oggetto nel db
			this.inserisciOggetto = function(url, params, toDo) {
				$http({
					method : 'POST',
					url : url,
					headers : {
						'Content-Type' : 'application/json'
					},
					params : params
				}).success(function(data) {
					console.log(data);
					toDo();
					$('input').val('');
					$('textarea').val('');
					
				});
			};
		}]
);
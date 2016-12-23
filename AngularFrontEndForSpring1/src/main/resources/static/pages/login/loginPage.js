(function() {
	var module = angular.module('LoginPageModule', ['AuthenticationModule', 'RouterModule']);
	module.controller('LoginController', ['RouteService', 'AuthenticationService', '$log', function(RouteService, AuthenticationService, $log) {
		self = this;
		self.username = 'ecaglayan';
		self.password = 'invader84;';
		self.login = function() {
			var loginPromise = AuthenticationService.login(self.username, self.password);
			loginPromise.then(function(response) {
				RouteService.redirectToHello();
			}, function(errorMessage) {
				$log.log(errorMessage);
			});
		}
	}]);
})();
(function() {
	var module = angular.module('LoginModule', ['AuthenticationModule']);
	module.controller('LoginController', ['AuthActionService', '$log', function(AuthActionService, $log) {
		self = this;
		self.username = '';
		self.password = '';
		self.login = function() {
			var loginPromise = AuthActionService.login(self.username, self.password);
			loginPromise.then(function(response) {
			}, function(errorMessage) {
				$log.log(errorMessage);
			});
		}
	}]);
})();
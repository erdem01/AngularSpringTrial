(function() {
	var module = angular.module('LoginModule', ['AuthenticationModule']);
	module.controller('LoginController', ['AuthActionService', '$log', function(AuthActionService, $log) {
		self = this;
		self.username = '';
		self.password = '';
		self.login = function() {
			$log.log('asd');
			var loginPromise = AuthActionService.login(self.username, self.password);
			loginPromise.then(function(response) {
				$log.log('asd2');
			}, function(errorMessage) {
				$log.log(errorMessage);
			});
		}
	}]);
})();
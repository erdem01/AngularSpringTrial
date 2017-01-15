(function() {
	var module = angular.module('HelloPageModule', ['AuthenticationModule']);
	module.controller('HelloController', ['AuthenticationService', '$log', function(AuthenticationService, $log) {
		self = this;
		self.logout = function() {
			AuthenticationService.logout();
		}
	}]);
})();
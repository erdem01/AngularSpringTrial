(function() {
	var module = angular.module('LoginModule', ['AuthenticationModule']);
	module.controller('LoginController', ['AuthService', '$http', '$q', function(AuthService, $http, $q) {
		self = this;
		self.username = '';
		self.password = '';
		self.login = function() {
			AuthService.login(self.username, self.password);
			var deferred = $q.defer();
			var loginPromise = $http.get("/protected/login").sucess(function(response) {
				alert('a');
				deferred.resolve(response);
			}).error(function(data, status, headers, config) {
				alert('b');
				deferred.reject("Login failed with status: " + status);
			});
			loginPromise.then(function(response) {
			}, function(errorMessage) {
//				alert(errorMessage);
			});
		}
	}]);
})();
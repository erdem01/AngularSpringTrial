(function() {
	var module = angular.module('LoginModule', ['AuthenticationModule']);
	module.factory('LoginService', ['AuthHolderService', '$http', '$q', function(AuthHolderService, $http, $q) {
		var login = function(username, password) {
			var postData = 'username=' + username + '&password=' + password;
			var config = {
                headers : {
                    'Content-Type': 'application/x-www-form-urlencoded;charset=utf-8;'
                }
            };
			var deferred = $q.defer();
			var loginPromise = $http.post("/login", postData, config).success(function(response) {
				AuthHolderService.holdAuth(username, password);
				deferred.resolve(response);
			}).error(function(data, status, headers, config) {
				deferred.reject("Login failed with status: " + status);
			});
			return deferred.promise;
		};
		
		return {
			login: login
		};
	}]);
	module.controller('LoginController', ['LoginService', '$log', function(LoginService, $log) {
		self = this;
		self.username = 'ecaglayan';
		self.password = 'invader84;';
		self.login = function() {
			var loginPromise = LoginService.login(self.username, self.password);
			loginPromise.then(function(response) {
			}, function(errorMessage) {
				$log.log(errorMessage);
			});
		}
	}]);
})();
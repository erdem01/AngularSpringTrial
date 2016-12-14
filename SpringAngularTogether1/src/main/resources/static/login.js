(function() {
	var module = angular.module('LoginModule', []);
	module.factory('LoginService', ['AuthHolderService', '$http', '$q', '$log', function(AuthHolderService, $http, $q, $log) {
		var login = function(username, password) {
			var postData = 'username=' + username + '&password=' + password;
			var config = {
                headers : {
                    'Content-Type': 'application/x-www-form-urlencoded;charset=utf-8;'
                }
            };
			$log.log(postData);
			var deferred = $q.defer();
			var loginPromise = $http.post("/login", postData, config).success(function(response) {
				$log.log('success');
				AuthHolderService.setUser(username, password);
				deferred.resolve(response);
			}).error(function(data, status, headers, config) {
				$log.log('fail');
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
		self.username = 'erdemc';
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
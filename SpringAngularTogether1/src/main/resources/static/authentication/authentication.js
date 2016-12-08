(function() {
	var module = angular.module('AuthenticationModule', []);
	module.factory('AuthService', [function() {
		var user = {
			username: '',
			password: ''
		};
		var getUser = function() {
			return user;
		};
		var login = function(username, password) {
			user.username = username;
			user.password = password;
		};
		return {
			getUser: getUser,
			login: login
		};
	}]);
	module.factory('AuthInterceptor', ['AuthService', function(AuthService) {
		return {
			request: function(config) {
				var user = AuthService.getUser();
				config.headers = config.headers || {};
				var encodedStr = btoa(user.username + ':' + user.password);
				config.headers.Authorization = 'Basic ' + encodedStr;
				return config;
			}
		};
	}]);
	module.config(['$httpProvider', function($httpProvider) {
		$httpProvider.interceptors.push('AuthInterceptor');
	}]);
})();
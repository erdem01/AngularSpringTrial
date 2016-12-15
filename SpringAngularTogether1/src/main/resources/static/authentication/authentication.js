(function() {
	var module = angular.module('AuthenticationModule', []);
	module.factory('AuthHolderService', [function() {
		var user = {
			username: '',
			password: ''
		};
		var getUser = function() {
			return user;
		};
		var setUser = function(username, password) {
			user.username = username;
			user.password = password;
		};
		return {
			getUser: getUser,
			setUser: setUser
		};
	}]);
	module.factory('AuthInterceptor', ['AuthHolderService', function(AuthHolderService) {
		return {
			request: function(config) {
				var user = AuthHolderService.getUser();
				config.headers = config.headers || {};
				var encodedStr = btoa(user.username + ':' + user.password);
				config.headers.Authorization = 'Basic ' + encodedStr;
				return config;
				
				if (AuthInfoService.hasAuthHeader()) {
					config.headers['Authorization'] = AuthInfoService.getAuthHeader();
				}
				return config;
			},
			responseError: function(config) {
				// Continue to ensure that the next promise chain
				// sees an error
				// Can check auth status code here if need to
				// if (rejection.status === 403) {
				// Show a login dialog
				// return a value to tell controllers it has
				// been handled
				// }
				// Or return a rejection to continue the
				// promise failure chain
				if (responseError.status === 403) {
					// Authorization issue, access forbidden
					AuthInfoService.redirectToLogin();
				}
				return $q.reject(responseRejection);
			}
		};
	}]);
})();
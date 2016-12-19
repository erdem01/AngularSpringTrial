(function() {
	var module = angular.module('AppModule', ['ngRoute', 'AuthenticationModule', 'LoginModule']);
	module.constant('loginPath','/login');
	module.config(['$routeProvider', 'loginPath', function($routeProvider, loginPath) {
		$routeProvider
        .when('/home', {
            templateUrl: 'protected/home.view.html',
        })

        .when(loginPath, {
            controller: 'LoginController',
            templateUrl: 'login.view.html',
            controllerAs: 'ctrl'
        })

        .otherwise({ redirectTo: loginPath });
	}]);
	module.factory('AuthInterceptor', ['$q', '$location', 'AuthHolderService', 'loginPath', function($q, $location, AuthHolderService, loginPath) {
		return {
			request: function(config) {
				var authData = AuthHolderService.gatherAuth();
				config.headers = config.headers || {};
				config.headers.Authorization = authData;
				return config;
			},
			responseError: function(rejection) {
				if (rejection.status === 401) {
					$location.path(loginPath);
					return $q.resolve(rejection);
				}
				return $q.reject(rejection);
			}
		};
	}]);
	module.config(['$httpProvider', function($httpProvider) {
		$httpProvider.interceptors.push('AuthInterceptor');
	}]);
})();
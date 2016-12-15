(function() {
	var module = angular.module('AppModule', ['ngRoute', 'AuthenticationModule', 'LoginModule']);
	module.config(['$routeProvider', function($routeProvider) {
		$routeProvider
        .when('/home', {
            templateUrl: 'protected/home.view.html',
        })

        .when('/login', {
            controller: 'LoginController',
            templateUrl: 'login.view.html',
            controllerAs: 'ctrl'
        })

        .otherwise({ redirectTo: '/login' });
	}]);
	module.config(['$httpProvider', function($httpProvider) {
		$httpProvider.interceptors.push('AuthInterceptor');
	}]);
})();
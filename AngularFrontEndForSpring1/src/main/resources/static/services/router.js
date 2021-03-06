(function() {
	var module = angular.module('RouterModule', ['ngRoute', 'AuthenticationModule']);
	module.constant('loginPath','/login');
	module.constant('helloPath','/hello');
	module.factory('RouteService', ['$location', 'loginPath', 'helloPath', function($location, loginPath, helloPath) {
		var redirectToLogin = function() {
			$location.path(loginPath);
		};
		
		var redirectToHello = function() {
			$location.path(helloPath);
		};
		
		return {
			redirectToLogin: redirectToLogin,
			redirectToHello: redirectToHello
		};
	}]);
	module.config(['$routeProvider', 'loginPath', 'helloPath', function($routeProvider, loginPath, helloPath) {
		$routeProvider
		
        .when(helloPath, {
        	controller: 'HelloController',
        	templateUrl: 'pages/hello/hello.view.html',
            controllerAs: 'ctrl'
        })

        .when(loginPath, {
            controller: 'LoginController',
            templateUrl: 'pages/login/login.view.html',
            controllerAs: 'ctrl'
        })

        .otherwise({ redirectTo: helloPath });
	}]);
	module.config(['$httpProvider', function($httpProvider) {
		$httpProvider.interceptors.push('AuthInterceptor');
	}]);
	module.run(['$rootScope', '$location', 'AuthenticationHolderService', 'RouteService', function($rootScope, $location, AuthenticationHolderService, RouteService) {
		$rootScope.$on("$routeChangeStart",function(event, next, current){
	        if(!AuthenticationHolderService.isLoggedIn()){
	        	RouteService.redirectToLogin();
	        	return;
	        }
	    });
	}]);
})();
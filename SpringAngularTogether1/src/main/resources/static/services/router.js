(function() {
	var module = angular.module('RouterModule', ['ngRoute']);
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
})();
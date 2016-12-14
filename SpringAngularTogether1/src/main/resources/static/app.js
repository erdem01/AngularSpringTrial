(function() {
	var module = angular.module('AppModule', ['ngRoute']);
	module.config(['$routeProvider', function($routeProvider) {
		$routeProvider
        .when('/home', {
            controller: 'HomeController',
            templateUrl: 'home.view.html',
            controllerAs: 'ctrl'
        })

        .when('/login', {
            controller: 'LoginController',
            templateUrl: 'login.view.html',
            controllerAs: 'ctrl'
        })

        .otherwise({ redirectTo: '/login' });
	}]);
})();
(function() {
	var module = angular.module('HomePageModule', ['RouterModule', 'AuthenticationModule', 'LoginPageModule', 'HelloPageModule']);
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

        .otherwise({ redirectTo: loginPath });
	}]);
	module.config(['$httpProvider', function($httpProvider) {
		$httpProvider.interceptors.push('AuthInterceptor');
	}]);
})();
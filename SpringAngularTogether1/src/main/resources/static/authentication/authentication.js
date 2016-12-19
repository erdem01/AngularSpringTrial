(function() {
	var module = angular.module('AuthenticationModule', ['ngCookies']);
	module.constant('AuthKey','AuthKey');
	module.factory('AuthHolderService', ['$cookies', 'AuthKey', function($cookies, AuthKey) {
		var holdAuth = function(username, password) {
			var authData = 'Basic ' + btoa(username + ':' + password);
			// store user details in globals cookie that keeps user logged in for 1 week (or until they logout)
            var cookieExp = new Date();
            cookieExp.setDate(cookieExp.getDate() + 7);
			$cookies.putObject(AuthKey, authData, { expires: cookieExp });
		};
		var clearAuth = function() {
			$cookies.remove(AuthKey);
		};
		var gatherAuth = function() {
			return $cookies.get(AuthKey) || '';
		};
		return {
			holdAuth: holdAuth,
			clearAuth: clearAuth,
			gatherAuth: gatherAuth
		};
	}]);
})();
var app = angular.module('app', ['ngRoute','ngResource']);
(function() {
	var app = angular.module('app', []);
	app.controller('AppCtrl', [function() {
		var helloMsg = 'Hello';
		var goodbyeMsg = 'Hello';
		var self = this;
		self.message= 'Hello';
		self.changeMessage = function() {
			self.message = self.message === helloMsg ? goodbyeMsg : helloMsg;
		};
	}]);
})();
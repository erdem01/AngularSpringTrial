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
		
		self.notes = [
			{id: 1, label: 'First Note', done: false},
			{id: 2, label: 'Second Note', done: false},
			{id: 3, label: 'Done Note', done: true},
			{id: 4, label: 'Last Note', done: false}
		];
	}]);
})();
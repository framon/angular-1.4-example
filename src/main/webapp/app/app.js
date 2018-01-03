(function(window) {
	'use strict';
	var webApp = angular.module('webApp', [ 'ngRoute', 'ngMaterial' ]);

	webApp.config([ '$locationProvider', '$routeProvider', '$mdThemingProvider',
            function($locationProvider, $routeProvider, $mdThemingProvider) {

		$locationProvider.html5Mode(false).hashPrefix('!');

		$routeProvider.when('/', {
			templateUrl : 'app/views/country-list.html',
			controller : 'HomeCtrl'
		}).otherwise({
			redirectTo : '/'
		});
		
		$mdThemingProvider.theme('default').primaryPalette('blue').accentPalette('lime');

	} ]);
	
	window.webApp = webApp;
})(window);

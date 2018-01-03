(function(webApp) {
	'use strict';
	webApp.controller('HomeCtrl', ['$scope', function($scope) {
		$scope.countries = [{ geoCode: 'BRA', name:'Brasil'}, {name:'Argentina'}]
	}]);

})(window.webApp);

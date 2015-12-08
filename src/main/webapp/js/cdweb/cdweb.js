angular.module("cdweb", ['ngRoute','ui.bootstrap', 'ngResource'])
    .run(["$rootScope",function($rootScope){
    	$rootScope.headersadassa = true;
    }]);
'use strict';

angular.module('libro')
    .controller('DetailCtrl', function ($scope, libro, $routeParams) {
    	
    	
    	$scope.get = function(){
    		 libro.get($routeParams.id, function(data) {
    			$scope.detail = data.data;
    		});
    	}

    	$scope.get();
    	
    });

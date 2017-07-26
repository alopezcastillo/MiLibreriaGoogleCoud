'use strict';

angular.module('libro')
    .controller('ListCtrl', function ($scope, libro) {

        $scope.load = function() {
        	alert("funcion load lista" +libro +" XXX");
            libro.list(function (list) {
            	alert("list "+list.data+" scope list "+$scope.list);
                $scope.list = list.data;
            });
        }

        $scope.save = function() {
        	alert("funcion save scope");
            libro.save($scope.form, function() {
                $scope.load();
            });
        }

        $scope.form = {};

        $scope.load();
    });

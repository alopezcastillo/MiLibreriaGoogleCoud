'use strict';

angular.module('libro')
    .service('libro', function ($http) {
        return {
            list: function (success) {
                return $http.get("/libro/find/all").then(success);
            },
            save: function (libro, success) {
                return $http.post("/libro/save", libro).then(success);
            },
            get: function (id, success) {
                return $http.get("/libro/find/"+id).then(success);
            },
        };
    });
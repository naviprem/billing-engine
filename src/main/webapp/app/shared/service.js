/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


(function() {

    angular.
            module('beApp').
            factory('beService', ['$http', function($http){
                    return {
                        user: {
                            authenticate: function(user) {
                                return $http({method: 'POST', url: '/user/authenticate', data: user});
                            }
                        },
                        parent: {
                            query: function() {
                                return $http({method: 'GET', url: '/parent'});
                            },
                            get: function(parentId) {
                                return $http({method: 'GET', url: '/parent/' + parentId});
                            },
                            save: function(parent) {
                                return $http({method: 'POST', url: '/parent', data: parent});
                            }
                        },
                        child: {
                            query: function() {
                                return $http({method: 'GET', url: '/child'});
                            },
                            get: function(childId) {
                                return $http({method: 'GET', url: '/child/' + childId});
                            },
                            save: function(child) {
                                return $http({method: 'POST', url: '/child', data: child});
                            } 
                        },
                        storage: {
                            saveToLocal: function(name, value) {
                                window.localStorage.setItem(name, angular.toJson(value));
                            },
                            fetchFromLocal: function(name) {
                                return angular.fromJson(window.localStorage.getItem(name));
                            },
                            removeFromLocal: function(name) {
                                window.localStorage.setItem(name, null);
                            }
                        },
                        props: {
                            get: function() {
                                return $http.get('properties.json');
                            }
                        }
                    }
            }]);
            

})();
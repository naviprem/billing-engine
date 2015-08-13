/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

(function() {

    angular.
            module('beApp.login', []).
            controller('LoginCtrl', ['$state', 'beService', function($state, beService) {
                    this.login = function(user){
                        beService.user.authenticate(user).
                                then(
                                function(res){
                                    $state.go("dashboard.children");
                                }).
                                catch(
                                function(err){
                                    alert("login failed");
                                });
                    };

                }]);

})();


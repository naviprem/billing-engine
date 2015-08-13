/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


(function() {

    angular.
            module('beApp', ['ui.router', 'ui.bootstrap', 'beApp.login', 'beApp.shared.routes',
                'beApp.login',
                'beApp.dashboard.bills',
                'beApp.dashboard.children'
            ]).
                    
            value('appContext', {}).
            value('userSession', {}).
            
            config(['$httpProvider', function($httpProvider){
                    $httpProvider.interceptors.push('myInterceptor');
            }]).
            controller('BeAppCtrl', ['$state', 'beService', 'appContext', 'userSession', 
                                        function($state, beService, appContext, userSession) {
                    
                    var vm = this;
                    vm.appContext = {};
                    beService.props.get().
                            then(
                            function(res){
                                for (var prop in res.data) {
                                    if(res.data.hasOwnProperty(prop)) {
                                        appContext[prop] = angular.copy(res.data[prop]);
                                    }
                                }
                                vm.appContext = appContext;
                                vm.userSession = {};
                                var restoredUserSession = beService.storage.fetchFromLocal('userSession');
                                if (restoredUserSession) {
                                    for(var prop in restoredUserSession) {
                                        if(restoredUserSession.hasOwnProperty()) {
                                            userSession[prop] = restoredUserSession[prop];
                                        }
                                    }
                                    vm.userSession = userSession;
                                    $state.go("dashboard.children");
                                } else {
                                    //$state.go("login");
                                }
                            }).
                            catch(
                            function(err){
                                if(err && err.config) {
                                    alert('Failed to fetch properties json (' + err.status + ")\n\n" + err.config.url);
                                } else {
                                    alert('Failed to fetch properties json');
                                }
                            });
                    

                }]).
                    
            factory('myInterceptor', ['$q', 'appContext', 'userSession', function($q, appContext, userSession){
                    console.log("myInterceptor");
                    return {
                        request: function(config) {
                            console.log("myInterceptor.request", config, config.url.charAt(0));
                            if(config.url.charAt(0) == '/') {
                                if(appContext.localEnv) {
                                    config.url = appContext.localEnv.beApiUrl + config.url;
                                }
                            }
                            return config || $q.when(config);
                        }
                    };
            }]);

})();


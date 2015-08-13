/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

(function(){
    angular.
            module('beApp.shared.routes', ['ui.router']).
            config(['$stateProvider', '$urlRouterProvider', function($stateProvider, $urlRouterProvider){
                    
                    $urlRouterProvider.
                            when('/', '/login').
                            otherwise('/login');
                    
                    $stateProvider.
                            state('login', {
                                url: '/login',
                                templateUrl: 'app/login/login.html',
                                controller: 'LoginCtrl',
                                controllerAs: 'login'
                            }).
                            state('dashboard', {
                                abstract: true,
                                url: '/dashboard',
                                templateUrl: 'app/dashboard/dashboard.html'
                            }).
                            state('dashboard.children', {
                                url: '/children',
                                templateUrl: 'app/dashboard/children/children.html',
                                controller: 'ChildrenDashboardCtrl',
                                controllerAs: 'childrenDashboard'
                            }).
                            state('dashboard.bills', {
                                url: '/bills',
                                templateUrl: 'app/dashboard/bills/bills.html',
                                controller: 'BillsDashboardCtrl',
                                controllerAs: 'billsDashboard'
                            });
                            
            }]);
})();



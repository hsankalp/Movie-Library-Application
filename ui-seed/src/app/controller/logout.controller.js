(function() {
    'use strict';

    angular
        .module('plunker')
        .controller('LogoutController', LogoutController);

    LogoutController.$inject = ['$location','$rootScope','$cookieStore','Notification'];

    function LogoutController($location, $rootScope, $cookieStore, Notification) {

        var logoutVm = this;

        logoutVm.logout = logout;

        function logout(){

            $rootScope.globals = {};
            $cookieStore.remove('globals');
            $location.path('/login');
            Notification.success("You've logged out successfully");

        }

    }



})();
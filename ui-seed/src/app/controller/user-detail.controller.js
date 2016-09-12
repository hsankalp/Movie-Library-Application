(function() {
    'use strict';

    angular
        .module('plunker')
        .controller('UserDetailController', UserDetailController);

    UserDetailController.$inject = ['userService', '$routeParams','Notification'];

    function UserDetailController(userService, $routeParams, Notification) {

        var userDetailVm = this;


        init();

        function init() {
            console.log('UserDetailController');

            userService
                .getUserById($routeParams.id)
                .then(function(user) {
                    userDetailVm.user = user;
                }, function(error) {
                    Notification.error("Unable to fetch user details");
                })
        }

    }


})();
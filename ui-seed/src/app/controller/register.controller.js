(function () {
    'use strict';

    angular
        .module('plunker')
        .controller('RegisterController', RegisterController);

    RegisterController.$inject = ['userService', '$location', 'Notification'];
    function RegisterController(userService, $location, Notification) {

        var registerVm = this;
        registerVm.register = register;

        init();

        function init() {
            console.log('RegisterController');


        }

        function register() {

            userService.addUser(registerVm.newUser)
                .then(function (response) {
                    $location.path("/login");
                    Notification.success("Registered Successfully");
                }, function (error) {
                    Notification.error("User already registered. Log in to continue");
                })
        }
    }
})();
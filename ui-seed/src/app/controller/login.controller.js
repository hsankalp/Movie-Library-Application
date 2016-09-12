(function() {
    'use strict';

    angular
        .module('plunker')
        .controller('LoginController', LoginController);

    LoginController.$inject = ['userService','$location','$rootScope','$cookieStore','Notification'];

    function LoginController(userService, $location, $rootScope, $cookieStore, Notification) {

        var loginVm = this;

        loginVm.login = login;

        init();

        function init() {
            console.log('LoginController');

        }

        function login() {

                userService
                    .login(loginVm.user.username, loginVm.user.password)
                    .then(function (response) {

                        if(response=="admin") {
                            $rootScope.globals = {
                                currentUser: {
                                    username: response,
                                    role: "admin"
                                }
                            };
                            $cookieStore.put('globals', $rootScope.globals);
                            $location.path("/users");
                            Notification.success("You've logged in successfully");
                        }else if (response==loginVm.user.username) {
                            $rootScope.globals = {
                                currentUser: {
                                    username: response,
                                    role: "user"
                                }
                            };
                            $cookieStore.put('globals', $rootScope.globals);
                            $location.path("/home");
                            Notification.success("You've logged in successfully");
                        }else{
                            Notification.error("Username or password is incorrect. Try again");
                        }
                    }, function (error) {
                        Notification.error("Username not present. Try again");
                    })
            }

        }


})();
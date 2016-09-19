(function () {
    'use strict';

    angular
        .module('plunker')
        .controller('UsersController', UsersController);

    UsersController.$inject = ['userService', 'Notification'];

    function UsersController(userService, Notification) {

        var usersVm = this;


        usersVm.deleteUser = deleteUser;

        init();

        function init() {

            console.log('UsersController');

            userService
                .getUsers()
                .then(function (users) {
                    usersVm.users = users;
                }, function (error) {
                    Notification.error("Unable to fetch users");
                });

        }


        function deleteUser(position) {

            userService.deleteUser(usersVm.users[position].username)
                .then(function (response) {
                    init();
                    Notification.success("User deleted from the Database");

                }, function (response) {
                    Notification.error("Unable to delete the user. Try again");
                })

        }

    }


})();
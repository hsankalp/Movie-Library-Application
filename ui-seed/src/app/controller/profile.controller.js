(function() {
    'use strict';

    angular
        .module('plunker')
        .controller('ProfileController', ProfileController);

    ProfileController.$inject = ['userService', '$routeParams','Notification'];

    function ProfileController(userService, $routeParams, Notification) {

        var profileVm = this;
        profileVm.editUser = editUser;
        profileVm.showEditForm = showEditForm;


        init();

        function init() {
            console.log('ProfileController');
            profileVm.editForm = false;

            userService
                .getUserByUsername($routeParams.username)
                .then(function(user) {
                    profileVm.currentUser = user;
                }, function(error) {
                    Notification.error("Unable to fetch user details");
                })
        }

        function editUser() {
            userService
                .updateUser(profileVm.currentUser)
                .then(function(response) {
                    showEditForm();
                    Notification.success("Changes made to your profile saved");
                }, function (error) {
                    Notification.error("Unable to update profile, Please try again");
                })

        }

        function showEditForm(){
            profileVm.editForm = !profileVm.editForm;
        }

    }


})();
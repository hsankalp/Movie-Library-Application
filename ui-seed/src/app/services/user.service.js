(function() {
    'use strict';

    angular
        .module('plunker')
        .service('userService', userService);

    userService.$inject = ['$http', '$q', 'CONFIG'];

    function userService($http, $q, CONFIG) {

        var self = this;

        self.getUsers = getUsers;
        self.getUserById = getUserById;
        self.addUser = addUser;
        self.updateUser = updateUser;
        self.deleteUser = deleteUser;
        self.getUserByUsername = getUserByUsername;
        self.login = login;

        function getUsers() {
            return $http.get(CONFIG.API_HOST + '/users')
                .then(successFn, errorFn);
        }

        function getUserById(id) {
            return $http.get(CONFIG.API_HOST + '/users/id/' + id)
                .then(successFn, errorFn);
        }

        function getUserByUsername(username) {
            return $http.get(CONFIG.API_HOST + '/users/uname/' + username)
                .then(successFn, errorFn);
        }

        function addUser(user) {
            return $http.post(CONFIG.API_HOST + '/users', user)
                .then(successFn, errorFn);
        }

        function login(username, password) {
            var data = "username="+username+"&password="+password;
            return $http.post(CONFIG.API_HOST + '/users/auth', data, {
                headers: { 'Content-Type': 'application/x-www-form-urlencoded; charset=UTF-8'}
            }).then(successFn, errorFn);
        }

        function updateUser(user) {
            return $http.put(CONFIG.API_HOST + '/users/', user)
                .then(successFn, errorFn);
        }

        function deleteUser(username) {
            return $http.delete(CONFIG.API_HOST + '/users/' + username)
                .then(successFn, errorFn);
        }

        function successFn(response) {
            return response.data;
        }

        function errorFn(response) {
            console.log(response);
            return $q.reject('ERROR: ' + response.statusText);
        }

    }



})();
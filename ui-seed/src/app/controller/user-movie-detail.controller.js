(function() {
    'use strict';

    angular
        .module('plunker')
        .controller('UserMovieDetailController', UserMovieDetailController);

    UserMovieDetailController.$inject = ['movieService', '$routeParams','Notification'];

    function UserMovieDetailController(movieService, $routeParams, Notification) {

        var userMovieDetailVm = this;

        init();

        function init() {
            console.log('UserMovieDetailController');

            movieService
                .getMovieById($routeParams.id)
                .then(function(movie) {
                    userMovieDetailVm.currentMovie = movie;
                }, function(error) {
                    Notification.error("Unable to fetch movie details");
                })
        }
    }


})();
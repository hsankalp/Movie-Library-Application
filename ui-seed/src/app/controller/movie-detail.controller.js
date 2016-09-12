(function() {
    'use strict';

    angular
        .module('plunker')
        .controller('MovieDetailController', MovieDetailController);

    MovieDetailController.$inject = ['movieService', '$routeParams','Notification'];

    function MovieDetailController(movieService, $routeParams, Notification) {

        var movieDetailVm = this;
        movieDetailVm.editMovie = editMovie;


        init();

        function init() {
            console.log('MovieDetailController');

            movieService
                .getMovieById($routeParams.id)
                .then(function(movie) {
                    movieDetailVm.currentMovie = movie;
                }, function(error) {
                    Notification.error("Unable to fetch movie details");
                })
        }

        function editMovie() {
            movieService.updateMovie(movieDetailVm.currentMovie)
                .then(function(response) {
                    Notification.success("Movie Detail Updated in the Database");
                }, function (error) {
                    Notification.error("Movie Detail not Updated, Please try again");
                })

        }

    }


})();
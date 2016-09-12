(function() {
    'use strict';

    angular
        .module('plunker')
        .controller('MoviesController', MoviesController);

    MoviesController.$inject = ['movieService','Notification'];

    function MoviesController(movieService,Notification) {

        var moviesVm = this;

        moviesVm.addMovie = addMovie;
        moviesVm.deleteMovie = deleteMovie;
        moviesVm.changeOrder = changeOrder;

        init();

        function init() {
            console.log('MoviesController');

            moviesVm.sorter = {
                by: 'year',
                reverse: true
            };

            movieService
                .getMovies()
                .then(function(movies) {
                    moviesVm.movies = movies;
                }, function(error) {
                    Notification.error("Unable to fetch movies");
                });

        }

        function changeOrder(property){
            moviesVm.sorter.by = property;
            moviesVm.sorter.reverse = !moviesVm.sorter.reverse;
        }

        function addMovie() {
            movieService.addMovie(moviesVm.newMovie)
                .then(function(response) {
                    init();
                    moviesVm.newMovie = null;
                    Notification.success("Movie added to the Database");
                }, function (response) {
                    Notification.error("Movie already present. Please try a different title");
                })

        }

        function deleteMovie(position) {

            movieService.deleteMovie(moviesVm.movies[position].id)
                .then(function(response) {
                    if (response!==null) {
                        init();
                        Notification.success("Movie deleted from the Database");
                    }
                }, function (response) {
                    Notification.error("Unable to delete the movie. Try again");
                })
        }

    }


})();
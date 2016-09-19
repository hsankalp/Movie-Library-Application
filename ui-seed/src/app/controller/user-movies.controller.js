(function () {
    'use strict';

    angular
        .module('plunker')
        .controller('UserMoviesController', UserMoviesController);

    UserMoviesController.$inject = ['movieService', 'Notification'];

    function UserMoviesController(movieService, Notification) {

        var userMoviesVm = this;

        userMoviesVm.changeOrder = changeOrder;

        init();

        function init() {
            console.log('UserMoviesController');

            userMoviesVm.sorter = {
                by: 'year',
                reverse: true
            };

            movieService
                .getMovies()
                .then(function (movies) {
                    userMoviesVm.movies = movies;
                }, function (error) {
                    Notification.error("Unable to fetch movies");
                });

        }

        function changeOrder(property) {
            userMoviesVm.sorter.by = property;
            userMoviesVm.sorter.reverse = !userMoviesVm.sorter.reverse;
        }

    }


})();
(function() {
    'use strict';

    angular
        .module('plunker')
        .service('movieService', movieService);

    movieService.$inject = ['$http', '$q', 'CONFIG'];

    function movieService($http, $q, CONFIG) {

        var self = this;

        self.getMovies = getMovies;
        self.getMovieById = getMovieById;
        self.addMovie = addMovie;
        self.updateMovie = updateMovie;
        self.deleteMovie = deleteMovie;

        function getMovies() {
            return $http.get(CONFIG.API_HOST + '/movies')
                .then(successFn, errorFn);
        }

        function getMovieById(id) {
            return $http.get(CONFIG.API_HOST + '/movies/movie/' + id)
                .then(successFn, errorFn);
        }

        function addMovie(movie) {
            return $http.post(CONFIG.API_HOST + '/movies', movie)
                .then(successFn, errorFn);
        }

        function updateMovie(movie) {
            return $http.put(CONFIG.API_HOST + '/movies', movie)
                .then(successFn, errorFn);
        }

        function deleteMovie(id) {
            return $http.delete(CONFIG.API_HOST + '/movies/' + id)
                .then(successFn, errorFn);
        }


        function successFn(response) {
            return response.data;
        }

        function errorFn(response) {
            return $q.reject('ERROR: ' + response.statusText);
        }

}



})();
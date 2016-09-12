(function() {
    'use strict';

    angular
        .module('plunker')
        .service('reviewService', reviewService);

    reviewService.$inject = ['$http', '$q', 'CONFIG'];

    function reviewService($http, $q, CONFIG) {

        var self = this;

        self.getReviews = getReviews;
        self.addReview = addReview;

        function getReviews(id) {
            return $http.get(CONFIG.API_HOST + '/reviews/' + id)
                .then(successFn, errorFn);
        }

        function addReview(review) {
            return $http.post(CONFIG.API_HOST + '/reviews', review)
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
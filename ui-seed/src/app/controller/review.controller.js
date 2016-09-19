(function () {
    'use strict';

    angular
        .module('plunker')
        .controller('ReviewController', ReviewController);

    ReviewController.$inject = ['reviewService', '$routeParams', '$rootScope', 'Notification'];

    function ReviewController(reviewService, $routeParams, $rootScope, Notification) {

        var reviewsVm = this;

        reviewsVm.addReview = addReview;
        reviewsVm.deleteReview = deleteReview;

        init();

        function init() {
            console.log('ReviewController');
            reviewService
                .getReviews($routeParams.id)
                .then(function (reviews) {
                    reviewsVm.reviews = reviews;
                }, function (error) {
                    Notification.error("Unable to fetch reviews. Please try again");
                });

        }

        function addReview() {
            reviewsVm.newReview = {
                id: $routeParams.id,
                username: $rootScope.globals.currentUser.username,
                userRatings: reviewsVm.newReview.userRatings,
                comments: reviewsVm.newReview.comments
            };
            reviewService.addReview(reviewsVm.newReview)
                .then(function (response) {
                    init();
                    reviewsVm.newReview = null;
                    Notification.success("Review has been posted successfully");
                }, function (response) {
                    Notification.error("Unable to post. Please try again");
                })

        }

        function deleteReview(position) {
            reviewService.deleteReview(reviewsVm.reviews[position].reviewId)
                .then(function (response) {
                    init();
                    Notification.success("Review deleted");
                }), function (error) {
                Notification.error("Unable to delete the review. Try again");
            }
        }

    }


})();
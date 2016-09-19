(function() {
    'use strict';

    angular
        .module('plunker', ['ngRoute','ngCookies','ngMessages','ui-notification'])
        .config(moduleConfig)
        .run(run);

    moduleConfig.$inject = ['$routeProvider', '$locationProvider'];

    function moduleConfig($routeProvider, $locationProvider) {

        $routeProvider
            .when('/login?', {
                templateUrl: 'app/views/login.tmpl.html',
                controller: 'LoginController',
                controllerAs: 'loginVm',
                roles:['admin','user']
            })
            .when('/home', {
                templateUrl: 'app/views/user-home.tmpl.html',
                controller: 'UserMoviesController',
                controllerAs: 'userMoviesVm',
                roles:['user']
            })
            .when('/profile/:username', {
                templateUrl: 'app/views/user-profile.tmpl.html',
                controller: 'ProfileController',
                controllerAs: 'profileVm',
                roles:['user']
            })
            .when('/register', {
                templateUrl: 'app/views/register.tmpl.html',
                controller: 'RegisterController',
                controllerAs: 'registerVm',
                roles:['admin','user']
            })
            .when('/users', {
                templateUrl: 'app/views/users.tmpl.html',
                controller: 'UsersController',
                controllerAs: 'usersVm',
                roles:['admin']
            })
            .when('/movies', {
                templateUrl: 'app/views/movies.tmpl.html',
                controller: 'MoviesController',
                controllerAs: 'moviesVm',
                roles:['admin']
            })
            .when('/movies/:id', {
                templateUrl: 'app/views/movie-detail.tmpl.html',
                controller: 'MovieDetailController',
                controllerAs: 'movieDetailVm',
                roles:['admin']
            })
            .when('/reviews/:id', {
                templateUrl: 'app/views/reviews.tmpl.html',
                controller: 'ReviewController',
                controllerAs: 'reviewsVm',
                roles:['user']
            })
            .when('/home/:id', {
                templateUrl: 'app/views/user-movie-detail.tmpl.html',
                controller: 'UserMovieDetailController',
                controllerAs: 'userMovieDetailVm',
                roles:['user']
            })
            .otherwise({
                redirectTo: '/login'
            })
    }

    run.$inject = ['$rootScope', '$location', '$cookieStore','Notification'];
    function run($rootScope, $location, $cookieStore, Notification) {
        $rootScope.globals = $cookieStore.get('globals') || {};

        $rootScope.$on('$routeChangeStart', function (event, next, current) {

            var loggedIn = $rootScope.globals.currentUser;
            var restrictedPage = $.inArray($location.path(), ['/login', '/register']) === -1;
            if (restrictedPage && !loggedIn) {

                $location.path('/login');


            }
            else if (loggedIn && $.inArray(loggedIn.role, next.roles)) {

                $location.path('/login');

            }
        });
    }

})();
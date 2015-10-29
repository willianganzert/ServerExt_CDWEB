/**
 * Created by Willian on 06/06/2015.
 */
angular.module("cdweb")
    .config(['$routeProvider', function ($routeProvider) {
        $routeProvider
            .when('/wellcome', {
                templateUrl: 'wellcome.html'
            })
            .when('/login', {
                templateUrl: 'login.html'
            })
            .when('/config', {
                templateUrl: 'configuration.html',
                controller: 'ConfigurationController'
            })
            .when('/Book/:bookId/ch/:chapterId', {
                templateUrl: 'chapter.html',
                controller: 'ChapterController'
            })
            .otherwise({
                redirectTo: '/wellcome'
            });

    }]);

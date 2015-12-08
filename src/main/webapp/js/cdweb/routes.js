/**
 * Created by Willian on 06/06/2015.
 */
angular.module("cdweb")
    .config(['$routeProvider', function ($routeProvider) {
        $routeProvider
            .when('/usuario', {
                templateUrl: 'usuario.html',
                controller:'UsuarioController'
            })
            .when('/login', {
                templateUrl: 'login.html'
            })
            
    
              .when('/listausuario', {
                   templateUrl: 'listausuario.html'
             })


            .when('/config', {
                templateUrl: 'configuration.html',
                controller: 'ConfigurationController'
            })


            .when('/menu', {
                templateUrl: 'menu.html',
                controller: 'MenuController'
            })

            .when('/predefinicoes', {
                templateUrl: 'predefinicoes.html'
            })

            .when('/dispositivo', {
                templateUrl: 'dispositivo.html',
                 controller:'ModeloController'
            })


            .when('/Book/:bookId/ch/:chapterId', {
                templateUrl: 'chapter.html',
                controller: 'ChapterController'
            })
            .otherwise({
                redirectTo: '/login'
            });

    }]);

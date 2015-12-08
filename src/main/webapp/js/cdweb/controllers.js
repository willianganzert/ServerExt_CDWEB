/**
 * Created by Willian on 06/06/2015.
 */
angular.module("cdweb")
    .controller("ConfigurationController",['$scope',function($scope){
        $scope.status = "Não enviado";
        $scope.enviarIP = function(){
            alert("");
        }
    }])
    .controller("MenuController",['$scope',function($scope){
        $scope.menu = "Menu da ";
        $scope.nome = "";
        $scope.$root.header = true;
        $scope.enviarIP = function(){
            alert("");
        }
    }])

    .controller("UsuarioController",['$scope', 'UserFactory','$routeParams', '$location', function($scope, UserFactory, $routeParams, $location){
        $scope.menu = "Menu da ";
        $scope.nome = "";
        $scope.$root.header = true;
        $scope.user = {};

        $scope.buscarusuario = function(idUsuario) {
        	$scope.user = UserFactory.show({id: idUsuario});

        }        
        $scope.cancelar = function(){
        	  $location.path('/menu');
        }
                
        $scope.gravar = function () {
            UserFactory.update($scope.user);
            $location.path('/menu');
        };


        $scope.buscarusuario(1);
    }])
    
    .controller("ModeloController",['$scope', 'ModelFactory','$routeParams', '$location', function($scope, UserFactory, $routeParams, $location){
        $scope.menu = "Menu da ";
        $scope.nome = "";
        $scope.$root.header = true;
        $scope.modelo = {};

        $scope.buscarparametro = function(idModeloAcao) {
        	$scope.modelo = ModelFactory.show({id: idModeloAcao});

        }        
        $scope.cancelar = function(){
        	  $location.path('/menu');
        }
                
        $scope.gravar = function () {
            UserFactory.update($scope.modelo);
            $location.path('/menu');
        };


        $scope.buscarparametro(1);
    }])

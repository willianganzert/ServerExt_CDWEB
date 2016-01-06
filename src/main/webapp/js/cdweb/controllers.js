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
    
    .controller("ModeloDispositivoController",['$scope', 'DispositivoFactory','$routeParams', '$location', 'ModeloDispositivoFactory', 'ModeloAcaoFactory',  function($scope, DispositivoFactory, $routeParams, $location, ModeloDispositivoFactory, ModeloAcaoFactory){
        $scope.dispositivos = DispositivoFactory.query(); 
        $scope.nome = "";
        $scope.$root.header = true;
        $scope.modelo = {};
        $scope.modeloacao = {};
        

        $scope.$watch("modelo.dispositivo", function(newValue,oldValue){
        	if(newValue){
        		$scope.parametros = DispositivoFactory.getParametros(newValue)	
        	}
        	else{
        		$scope.parametros = null;
        	}
        	
        })
        $scope.buscar= function(idModeloAcao) {
//        	$scope.modelo = ModelFactory.show({id: idModeloAcao});

        }        
        $scope.cancelar = function(){
        	  $location.path('/menu');
        }
                
        $scope.gravar = function () {
        	ModeloDispositivoFactory[$scope.modelo.idDispositivo?"update":"save"]($scope.modelo, function(dadosModeloDispositivo){
        		$scope.modeloacao.modeloDispositivo = dadosModeloDispositivo;
        		ModeloAcaoFactory[$scope.modeloacao.idAcao?"update":"save"]($scope.modeloacao);

                $location.path('/menu');
        	});        	
        };

        
    }])

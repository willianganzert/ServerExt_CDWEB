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


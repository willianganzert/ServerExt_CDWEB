/**
 * Created by mayju_000 on 05/12/2015.
 */
var services = angular.module('cdweb');

//services.factory('UsersFactory', function ($resource) {
//    return $resource('/ngdemo/web/users', {}, {
//        query: { method: 'GET', isArray: true },
//        create: { method: 'POST' }
//    })
//});

services.factory('UserFactory', function ($resource) {
    return $resource('./rest/usuarios/:id', {}, {
        show: { method: 'GET' },
        update: { method: 'PUT', params: {id: '@idUsuario'} },
        delete: { method: 'DELETE', params: {id: '@idUsuario'} }
    })
});

services.factory('DispositivoFactory', function ($resource) {
    return $resource('./rest/dispositivos/:id/:parametros', {}, {
        get: { method: 'GET',params: {id: '@idDispositivo'}},
        query: { method: 'GET', isArray:true},
        save: { method: 'POST'},
        update: { method: 'PUT', params: {id: '@idDispositivo'} },
        delete: { method: 'DELETE', params: {id: '@idDispositivo'} },
        getParametros: { method: 'POST',
        	url:'./rest/dispositivos/:id/parametros',
        	params: {id: '@idDispositivo'}, isArray:true},
    })
});


services.factory('ModeloDispositivoFactory', function ($resource) {
    return $resource('./rest/modelosdispositivo/:id', {}, {
        get: { method: 'GET',params: {id: '@idModeloDispositivo'}},
        query: { method: 'GET', isArray:true},
        save: { method: 'POST'},
        update: { method: 'PUT', params: {id: '@idModeloDispositivo'} },
        delete: { method: 'DELETE', params: {id: '@idModeloDispositivo'} }
    })
});

services.factory('ModeloAcaoFactory', function ($resource) {
    return $resource('./rest/modelosacao/:id', {}, {
        get: { method: 'GET',params: {id: '@idModeloAcao'}},
        query: { method: 'GET', isArray:true},
        save: { method: 'POST'},
        update: { method: 'PUT', params: {id: '@idModeloAcao'} },
        delete: { method: 'DELETE', params: {id: '@idModeloAcao'} }
    })
});


services.factory('ModeloParametroFactory', function ($resource) {
    return $resource('./rest/modelosparametro/:id', {}, {
        get: { method: 'GET',params: {id: '@idModeloParametro'}},
        query: { method: 'GET', isArray:true},
        save: { method: 'POST'},
        update: { method: 'PUT', params: {id: '@idModeloParametro'} },
        delete: { method: 'DELETE', params: {id: '@idModeloParametro'} }        
    })
});
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
    return $resource('./rest/users/:id', {}, {
        show: { method: 'GET' },
        update: { method: 'PUT', params: {id: '@idUsuario'} },
        delete: { method: 'DELETE', params: {id: '@idUsuario'} }
    })
});

services.factory('ParamFactory', function ($resource) {
    return $resource('./rest/modelo/:id', {}, {
        show: { method: 'GET' },
        update: { method: 'PUT', params: {id: '@idModeloAcao'} },
        delete: { method: 'DELETE', params: {id: '@idModeloAcao'} }
    })
});
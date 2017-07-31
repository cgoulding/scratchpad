angular.module('customerApp.services',[]).factory('Customer',function($resource){
    return $resource('http://localhost:8888/customers/:id',{id:'@id'},{
        update: {
            method: 'PUT'
        }
    });
}).service('popupService',function($window){
    this.showPopup=function(message){
        return $window.confirm(message);
    }
});
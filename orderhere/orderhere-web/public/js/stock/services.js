angular.module('stockApp.services',[]).factory('Location',function($resource){
    return $resource('http://localhost:8888/stocks/:id',{id:'@id'},{
        update: {
            method: 'PUT'
        }
    });
}).service('popupService',function($window){
    this.showPopup=function(message){
        return $window.confirm(message);
    }
});
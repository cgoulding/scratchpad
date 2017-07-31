angular.module('locationApp.controllers',[]).controller('LocationListController',function($scope,$state,popupService,$window,Location){

    $scope.locations=Location.query();

    $scope.deleteLocation=function(location){
        if(popupService.showPopup('Really delete this?')){
            location.$delete(function(){
                $window.location.href='';
            });
        }
    }

}).controller('LocationViewController',function($scope,$stateParams,Location){

    $scope.location=Location.get({id:$stateParams.id});

}).controller('LocationCreateController',function($scope,$state,$stateParams,Location){

    $scope.location=new Location();

    $scope.addLocation=function(){
        $scope.location.$save(function(){
            $state.go('locations');
        });
    }

}).controller('LocationEditController',function($scope,$state,$stateParams,Location){

    $scope.updateLocation=function(){
        $scope.location.$update(function(){
            $state.go('locations');
        });
    };

    $scope.loadLocation=function(){
        $scope.location=Location.get({id:$stateParams.id});
    };

    $scope.loadLocation();
});
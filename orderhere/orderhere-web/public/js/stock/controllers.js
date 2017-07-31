angular.module('stockApp.controllers',[]).controller('StockListController',function($scope,$state,popupService,$window,Stock){

    $scope.stocks=Stock.query();

    $scope.deleteStock=function(stock){
        if(popupService.showPopup('Really delete this?')){
            stock.$delete(function(){
                $window.location.href='';
            });
        }
    }

}).controller('StockViewController',function($scope,$stateParams,Stock){
    $scope.stock=Stock.get({id:$stateParams.id});

}).controller('StockCreateController',function($scope,$state,$stateParams,Stock){

    $scope.stock=new Stock();

    $scope.addStock=function(){
        $scope.stock.$save(function(){
            $state.go('stocks');
        });
    }

}).controller('StockEditController',function($scope,$state,$stateParams,Stock){

    $scope.updateStock=function(){
        $scope.stock.$update(function(){
            $state.go('stocks');
        });
    };

    $scope.loadStock=function(){
        $scope.stock=Stock.get({id:$stateParams.id});
    };

    $scope.loadStock();
});
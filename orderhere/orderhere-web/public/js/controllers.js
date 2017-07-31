angular.isUndefinedOrNull = function(val) {
    return angular.isUndefined(val) || val === null 
}

angular.module('entryApp.controllers',[]).controller('EntryController',function($scope,$state,$stateParams,Search,Account){

    $scope.search=new Search();
	$scope.account=new Account();
	$scope.locations=[];
	
    $scope.entryLocationSearch=function(){
        $state.go('entryLocationSearch');
    };
    
    $scope.entryLocationAdd=function(){
        $state.go('entryLocationAdd');
    };
    
    $scope.entryAccountRegister=function(){
        $state.go('entryAccountRegister');
    };
    
    $scope.entryAccountLogin=function(){
        $state.go('entryAccountLogin');
    };
    
}).controller('EntryLocationSearchController',function($scope,$state,$stateParams,Search,Account,Location){
    
    $scope.entryLocationSearch=function(){
        $state.go('entryLocationSearch');
    };
    
    $scope.entryLocationAdd=function(){
        $state.go('entryLocationAdd');
    };
    
    $scope.entryAccountRegister=function(){
        $state.go('entryAccountRegister');
    };
    
    $scope.entryAccountLogin=function(){
        $state.go('entryAccountLogin');
    };

	$scope.entryLocationCheckin=function(location){
        $state.go('checkinLocation');
    };
    
	$scope.locations=Search.query({id:$scope.search});
	
}).controller('EntryLocationAddController',function($scope,$state,$stateParams,Location){

	$scope.location = new Location();
	
}).controller('EntryAccountRegisterController',function($scope,$state,$stateParams,Account){

    $scope.account=new Account();

    $scope.entryAccountRegister=function() {
        $scope.account.$save(function() {
            $state.go('locations');
        });
    };
    
}).controller('AccountController',function($scope,$stateParams,$state,sessionService,Location,Account,Search,Stock){

	$scope.accountLocationCheckout=function(location) {
        sessionService.setCurrentLocation(null);
        $state.go('entryAccountLogin', {}, { reload: true });
    };
    
    $scope.accountLocationSearch=function(){
    	sessionService.setCurrentLocations(Search.query());
        $state.go('entryAccountLogin', {}, { reload: true });
    };

	$scope.accountLocationCheckin=function(location){
		sessionService.setCurrentLocation(Location.get({id:location.id}));
		sessionService.setCurrentStocks(Stock.query());
        $state.go('entryAccountLogin', {}, { reload: true });
    };
	
	$scope.isCheckedIn=function(){
		return !angular.isUndefinedOrNull(sessionService.getCurrentLocation());
    };
    
	$scope.currentLocation = sessionService.getCurrentLocation();
	$scope.locations = sessionService.getCurrentLocations();
	$scope.stocks = sessionService.getCurrentStocks();
    	
}).controller('LocationCheckinController',function($scope,$state,$stateParams,Location){
	
	$scope.location=Location.get({id:$stateParams.id});
    
}).controller('LocationListController',function($scope,$state,popupService,$window,Location){

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
}).controller('StockListController',function($scope,$state,popupService,$window,Stock){

    $scope.stocks=Stock.query();

    $scope.deleteStock=function(stock){
        if(popupService.showPopup('Really delete this?')){
            stock.$delete(function(){
                $window.location.href='';
            });
        }
    }

}).controller('StockViewController',function($scope,$stateParams,Stock, sessionService){
    
    var stock = Stock.get({id:$stateParams.id});
    $scope.stock = stock;
    
    sessionService.setCurrentStock(stock);

}).controller('StockCreateController',function($scope,$state,$stateParams,Stock,sessionService){

    $scope.stock=new Stock();

    $scope.addStock=function(){
        $scope.stock.$save(function(){
            $state.go('stocks');
        });
    }
    
    sessionService.setCurrentStock($scope.stock);

}).controller('StockEditController',function($scope,$state,$stateParams,Stock,sessionService){

    $scope.updateStock=function(){
        $scope.stock.$update(function(){
            $state.go('stocks');
        });
    };

    $scope.loadStock=function(){
    	var currentStock = Stock.get({id:$stateParams.id});
        $scope.stock = currentStock;
        sessionService.setCurrentStock(currentStock);
    };

    $scope.loadStock();
    
}).controller('ItemViewController',function($scope,$stateParams,Item,sessionService,debugService){

	var itemId = $stateParams.id;
	var stock = sessionService.getCurrentStock();
		
	for (var i=0; i < stock.items.length; i++)
	{
		var item = stock.items[i];
		debugService.objectProperties(item);
		
		if (item.id == itemId)
		{
			$scope.item = item;
			sessionService.setCurrentItem(item);
			break;
		}
	} 
	
}).controller('ItemCreateController',function($scope,$state,$stateParams,Item,Stock,debugService,sessionService){
	
	var stock = sessionService.getCurrentStock();
	$scope.stock = stock;
	
	var item = new Item();
	sessionService.setCurrentItem(item);
	
	$scope.item = item;
	
	if (angular.isUndefinedOrNull(stock.items))
	{
		stock.items = [];
	};
	
	stock.items.push(item);
	
	$scope.addItem = function()
	{
		stock.$update(function(){
			$stateParams.id = stock.id;
            $state.go('editStock');
        });
	};
	
}).controller('ItemEditController',function($scope,$state,$stateParams,Item,debugService,sessionService){

	var item = sessionService.getCurrentItem();
	var stock = sessionService.getCurrentStock();
	
	$scope.stock = stock;
	$scope.item = item;
	
	stock.items.push(item);
	
	$scope.updateItem = function()
	{
		stock.$update(function(){
			$stateParams.id = stock.id;
            $state.go('editStock');
        });
	};
}).controller('CustomerListController',function($scope,$state,popupService,$window,Customer){

    $scope.customers=Customer.query();

    $scope.deleteCustomer=function(customer){
        if(popupService.showPopup('Really delete this?')){
            customer.$delete(function(){
                $window.location.href='';
            });
        }
    }

}).controller('CustomerViewController',function($scope,$stateParams,Customer){

    $scope.customer=Customer.get({id:$stateParams.id});

}).controller('CustomerCreateController',function($scope,$state,$stateParams,Customer){

    $scope.customer=new Customer();

    $scope.addCustomer=function(){
        $scope.customer.$save(function(){
            $state.go('customers');
        });
    }

}).controller('CustomerEditController',function($scope,$state,$stateParams,Customer){

    $scope.updateCustomer=function(){
        $scope.customer.$update(function(){
            $state.go('customers');
        });
    };

    $scope.loadCustomer=function(){
        $scope.customer=Customer.get({id:$stateParams.id});
    };

    $scope.loadCustomer();
    
});
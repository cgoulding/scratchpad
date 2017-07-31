angular.module('entryApp.services',[])

.factory('Search',function($resource){
    return $resource('http://localhost:8888/locations/search/:id',{id:'@id'},{
        update: {
            method: 'PUT'
        }
    });
})

.factory('Location',function($resource){
    return $resource('http://localhost:8888/locations/:id',{id:'@id'},{
        update: {
            method: 'PUT'
        }
    });
})

.factory('Account',function($resource){
    return $resource('http://localhost:8888/customers/:id',{id:'@id'},{
        update: {
            method: 'PUT'
        }
    });
})

.factory('Stock',function($resource){
    return $resource('http://localhost:8888/stocks/:id',{id:'@id'},{
        update: {
            method: 'PUT'
        }
    });
})

.factory('Customer',function($resource){
    return $resource('http://localhost:8888/customers/:id',{id:'@id'},{
        update: {
            method: 'PUT'
        }
    });
})

.factory('Item',function(){
	var item = function() {
		this.name = null;
		this.description = null;
		this.category = null;
		this.price = null;
	};
	return item;
})

.service('loginService',function(){
    
})

.service('sessionService',function(Location, Stock, Account, Item){
	
	var account = null;	
	var locations = [];
	var location = null;
	var stocks = [];
	var stock = null;
	var item = null;

	this.getAccount=function(){
        return this.account;
    };
    	
	this.setAccount=function(account){
        this.account = account;
    };
    
    this.getCurrentLocation=function(){
        return this.location;
    };

	this.setCurrentLocation=function(location){
        this.location = location;
    };
   
   	this.getCurrentLocations=function(){
        return this.locations;
    };
    
    this.setCurrentLocations=function(locations){
        this.locations = locations;
    };
     
	this.getCurrentStock=function(){
        return this.stock;
    };
        
    this.setCurrentStock=function(stock){
        this.stock = stock;
    };
    
    this.getCurrentStocks=function(){
        return this.stocks;
    };
 
    this.setCurrentStocks=function(stocks){
        this.stocks = stocks;
    };
    
    this.getCurrentItem=function(){
        return this.item;
    };
    
    this.setCurrentItem=function(item){
        this.item = item;
    };
})

.service('popupService',function($window){
    this.showPopup=function(message){
        return $window.confirm(message);
    }
})

.service('debugService',function($window){
    this.objectProperties=function(object){
    	var s = '';
		for (prop in object) {
			s += prop + ':' + object[prop] + '\n';
		}
        return $window.confirm(s);
    }
});
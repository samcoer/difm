
var enablee = angular.module('enablee', ['ngRoute', 'ngResource']);
enablee.config(function($routeProvider) {
	$routeProvider.
		when('/',{
			controller:'LoginCtrl as login',
			templateUrl:'templates/login.html'}).
		when('/registerUser',{
			controller:'RegisterCtrl as register',
			templateUrl:'templates/registerUser.html'}).
		when('/search',{
			controller:'SearchPropertyCtrl as search',
			templateUrl:'templates/searchProperty.html'}).
		when('/viewallentries',{
			controller:'ListPropertyCtrl as propertyCtrl',
			templateUrl:'templates/viewProperties.html'}).
		when('/editEntry/:id',{
			controller:'EditPropertyCtrl as propertyCtrl',
			templateUrl:'templates/editProperty.html'}).
		when('/createEntry',{
			controller:'CreatePropertyCtrl as propertyCtrl',
			templateUrl:'templates/editProperty.html'}).	
		when('/deleteEntry/:id',{
			controller:'DeletePropertyCtrl as propertyCtrl',
			templateUrl:'templates/deleteProperty.html'});
});

enablee.factory("Property", ['$resource', function($resource){
	return $resource(
		"service/property/20/:id",
		null,
		{
			'update':{method: 'PUT'}
		}
	);
}]);


enablee.controller('ListPropertyCtrl',['$scope','$http','Property' ,function($scope, $http, Property){
	$scope.properties=Property.query();
	
	$scope.deleteProperty = function(e, id){
		e.preventDefault();
		var whatIndex = null;
		angular.forEach($scope.properties, function(cb, index) {
		  if (cb.id == id) {
		     whatIndex = index;
		  }
		});
		
		//Delete the record from server
		var isDeleted = Property.delete({id: id});
		if(isDeleted){
			$scope.properties.splice(whatIndex, 1);
		}
	};
}]);

enablee.controller('EditPropertyCtrl',['$scope','$http','$routeParams','Property' ,function($scope,$http,$routeParams, Property){
	$scope.property = Property.get({id: $routeParams.id});
	$scope.id=$routeParams.id;
	$scope.blocked = [{name:"Yes",value:true},
	                  {name:"No",value:false}];
	$scope.favorite = [{name:"Yes",value:true},
	                   {name:"No",value:false}];
	$scope.available = [{name:"Yes",value:true},
	                    {name:"No",value:false}];
	$scope.furnished = [{name:"Fully Furnished",value:"Fully Furnished"},
	                    {name:"Semi Furnished",value:"Semi Furnished"},
	                    {name:"Unfurnished",value:"Unfurnished"}]
	$scope.type = [{name:"Apartment",value:"Apartment"},
	               {name:"Individual",value:"Individual"}];
	$scope.bhkOptions = [{name:"1BHK",value:"1BHK"},
	                     {name:"1.5BHK",value:"1.5BHK"},
	                     {name:"2BHK",value:"2BHK"},
	                     {name:"2.5BHK",value:"2.5BHK"},
	                     {name:"3BHK",value:"3BHK"},
	               {name:"3.5BHK",value:"3.5BHK"},
	               {name:"4BHK",value:"4BHK"},
	               {name:"4.5BHK",value:"4.5BHK"},
	               {name:"5BHK",value:"5BHK"}];
	
	$scope.updateProperty = function(){
		Property.update({id: $scope.id}, $scope.property).$promise.then(function(){
			location.href="#/viewallentries"
		});
	};
}]);

enablee.controller('CreatePropertyCtrl',['$scope','$http','$routeParams','Property' ,function($scope,$http,$routeParams, Property){
	$scope.property = new Property();
	$scope.blocked = [{name:"Yes",value:true},
	                  {name:"No",value:false}];
	$scope.favorite = [{name:"Yes",value:true},
	                   {name:"No",value:false}];
	$scope.available = [{name:"Yes",value:true},
	                    {name:"No",value:false}];
	$scope.furnished = [{name:"Fully Furnished",value:"Fully Furnished"},
	                    {name:"Semi Furnished",value:"Semi Furnished"},
	                    {name:"Unfurnished",value:"Unfurnished"}]
	$scope.type = [{name:"Apartment",value:"Apartment"},
	               {name:"Individual",value:"Individual"}];
	$scope.bhkOptions = [{name:"1BHK",value:"1BHK"},
	                     {name:"1.5BHK",value:"1.5BHK"},
	                     {name:"2BHK",value:"2BHK"},
	                     {name:"2.5BHK",value:"2.5BHK"},
	                     {name:"3BHK",value:"3BHK"},
	               {name:"3.5BHK",value:"3.5BHK"},
	               {name:"4BHK",value:"4BHK"},
	               {name:"4.5BHK",value:"4.5BHK"},
	               {name:"5BHK",value:"5BHK"}];
	
	$scope.updateProperty = function(){
		Property.save($scope.property).$promise.then(function(){
			location.href="#/viewallentries"
		});
	};
}]);

enablee.controller('DeletePropertyCtrl',['$scope','$http','$routeParams',function($scope,$http,$routeParams){
	$scope.property;
	$scope.id=$routeParams.id;
	alert($scope.id);
}]);

enablee.controller('LoginCtrl',['$scope','$http',function($scope,$http){
	$scope.login = function(){
		location.href="#/viewallentries";
	};
	
	$scope.registerScreen = function(){
		location.href="#/regiserUser";
	};
}]);

enablee.controller('RegisterCtrl',['$scope','$http',function($scope,$http){
	$scope.register = function(){
	location.href="#/viewallentries";
	};
	
	$scope.loginScreen = function(){
		location.href="#/";
	};
}]);

enablee.controller('SearchCtrl',function(){
	$scope.test = "";
});
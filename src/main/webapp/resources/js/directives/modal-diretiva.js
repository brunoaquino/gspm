var modulo = angular.module('minhasDiretivas', []);


modulo.controller('modalController', function($scope) {
	$scope.showModal = false;
	$scope.toggleModal = function(){
	    $scope.showModal = !$scope.showModal;
	};
  })


modulo.directive('ngModal', function () {
    return {
    	templateUrl: '../resources/js/directives/modal.html',
        restrict: 'E',
        transclude: true,
        replace:true,
        scope:true,
        link: function postLink(scope, element, attrs) {
          scope.title = attrs.title;

          scope.$watch(attrs.visible, function(value){
            if(value == true)
              $(element).modal('show');
            else
              $(element).modal('hide');
          });

          $(element).on('shown.bs.modal', function(){
            scope.$apply(function(){
              scope.$parent[attrs.visible] = true;
            });
          });

          $(element).on('hidden.bs.modal', function(){
            scope.$apply(function(){
              scope.$parent[attrs.visible] = false;
            });
          });
        }
      };
    });
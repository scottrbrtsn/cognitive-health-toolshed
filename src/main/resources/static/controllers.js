/*Controllers*/

angular.module('myApp')
    .controller("UserInfoController", function($http, $scope, $resource) {

	    $scope.getUserInfo =  $resource("/userInfo", {}, {
                    query: { method: "GET", isArray: false }
                  });

        $scope.saveUserInfo =  $resource("/userInfo", {}, {
                    query: { method: "POST", isArray: false }
                  });

    })
    .controller('myController', function($http, $scope, $resource) {

    });

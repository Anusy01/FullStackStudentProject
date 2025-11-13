var app = angular.module('studentApp', []);
app.controller('StudentController', function($scope, $http) {
    $scope.students = [];
    $scope.student = {};
    $scope.updateId = '';
    $scope.updateName = '';
    $scope.updateAge = '';
    $scope.deleteId = '';

    var baseUrl = "http://localhost:8086/students";

    $scope.fetchStudents = function() {
        $http.get(baseUrl)
            .then(function(response) { $scope.students = response.data; });
    };

    $scope.addStudent = function() {
        $http.post(baseUrl, $scope.student)
            .then(function(response) {
                $scope.fetchStudents();
                $scope.student = {};
                alert("Added student!");
            });
    };

    $scope.updateStudent = function() {
        $http.put(baseUrl + "/" + $scope.updateId, {
            name: $scope.updateName,
            age: $scope.updateAge
        }).then(function(response) {
            $scope.fetchStudents();
            $scope.updateId = '';
            $scope.updateName = '';
            $scope.updateAge = '';
            alert("Updated student!");
        });
    };

    $scope.deleteStudent = function() {
        $http.delete(baseUrl + "/" + $scope.deleteId)
            .then(function(response) {
                $scope.fetchStudents();
                $scope.deleteId = '';
                alert("Deleted student!");
            });
    };
});

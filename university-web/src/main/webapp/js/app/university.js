var university = angular.module('university', ['ngGrid']);
university.controller('NgGridTableCtrl', function($scope, $http) {
    //console.log("ng-grid controller");
    $scope.teachersList = [];
    //$scope.teachersList = [{name: "Moroni", age: 50},
    //                                       {name: "Tiancum", age: 43},
    //                                       {name: "Jacob", age: 27},
    //                                       {name: "Nephi", age: 29},
    //                                       {name: "Enos", age: 34}];
    $scope.gridOptions = {data: 'teachersList'
            //columnDefs: [{field:'name', displayName:'Name'}, {field:'age', displayName:'Age'}]
    };
    $http.get("rest/getteacherlist").success(function(data) {
        $scope.teachersList = data;
        $scope.gridOptions = {data: 'teachersList'};
    }
)});

function TeacherCtrl($scope, $http) {
    console.log("getTeacher");
    $http.get("rest/getteacherlist").success(function(data) {
        console.log("teachers:" + data);
        $scope.teachers = data;
    })
}

function StudentCtrl($scope, $http) {
    $http.get("rest/getstudentlist").success(function(data) {
        $scope.students = data;
    })
}

function CourseCtrl($scope, $http) {
    $http.get("rest/getcourselist").success(function(data) {
        $scope.courses = data;
    })
}

function TestController($scope) {
    $scope.testValue = 'ddd';
}

/*

function NgGidTableCtrl($scope, $http) {
    console.log("ng-grid controller");
    $http.get("rest/getteacherlist").success(function(data) {
            $scope.teachersList = data;
            $scope.teachersGridOptions = {data: 'teachersList'};
    })
}*/

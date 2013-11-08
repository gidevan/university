var university = angular.module('university', ['ngGrid']);
university.controller('NgGridTableCtrl', function($scope, $http) {
    $scope.teachersList = [];
    $scope.studentsList = [];
    $scope.gridOptions = {data: 'teachersList'
            //columnDefs: [{field:'name', displayName:'Name'}, {field:'age', displayName:'Age'}]
    };
    $scope.studentsOptinons = {data: 'studentsList'};
    $http.get("rest/getteacherlist").success(function(data) {
        $scope.teachersList = data;
        $scope.gridOptions = {data: 'teachersList'};
    });
    $http.get("rest/getstudentlist").success(function(data) {
        $scope.studentsList = data;
        $scope.studentsOptinons = {data: 'studentsList'};
    });
});

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

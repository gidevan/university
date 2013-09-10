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
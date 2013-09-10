<html ng-app>
<head>
    <meta charset="utf-8"/>
    <title>University application</title>
    <script src="http://localhost:8080/university-web/js/lib/angular/angular.js"></script>
    <script src="http://localhost:8080/university-web/js/app/university.js"></script>
</head>
<body>
    <div class="university-tabs">
        <div class="teacher-tab" ng-controller="TeacherCtrl">
            <p class="tab-title">Teacher list</p>
            <input class="entity-input" value=""/>
            <div class="teacher-list">
                <ul>
                    <li ng-repeat="teacher in teachers">
                        <p>{{teacher.id}}</p><p>{{teacher.name}}</p>
                    </li>
                </ul>
            </div>
        </div>
        <div class="student-tab" ng-controller="StudentCtrl">
            <p class="tab-title">Student list</p>
            <input class="entity-input" value=""/>
            <div class="student-list">
                <ul>
                    <li ng-repeat="student in students">
                        <p>{{student.id}}</p><p>{{student.name}}</p>
                    </li>
                </ul>
            </div>
        </div>
        <div ng-controller="TestController">testValue={{testValue}}</div>
    </div>
</body>
</html>
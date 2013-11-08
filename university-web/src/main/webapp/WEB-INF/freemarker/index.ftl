<html ng-app="university">
<head>
    <meta charset="utf-8"/>
    <title>University application</title>
    <link rel="stylesheet" type="text/css" href="http://localhost:8080/university-web/css/lib/ng-grid.css"/>
    <link rel="stylesheet" type="text/css" href="http://localhost:8080/university-web/css/university.css"/>
    <!--script src="http://localhost:8080/university-web/js/lib/jquery-2.0.3.js"></script-->
    <script src="http://localhost:8080/university-web/js/lib/jquery-1.10.2.js"></script>
    <script src="http://localhost:8080/university-web/js/lib/angular/angular.js"></script>
    <script src="http://localhost:8080/university-web/js/app/university.js"></script>
    <script src="http://localhost:8080/university-web/js/lib/ng-grid-2.0.7.debug.js"></script>

</head>
<body>
    <#if view?? && view=="table-view">
        <#include "/ng-grid-view/ng-grid-view.ftl">
    <#else>
        <#include "/simple-view/simple-view.ftl">
    </#if>
</body>
</html>
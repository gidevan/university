<html>
<head>

</head>
<body>
    <div class="teacher-tab">
        <p class="tab-title">Teacher list</p>
        <input class="entity-input" value=""/>
        <div class="teacher-list">
            <#if teacher??>
                <div class ="entity">
                    <p>${teacher.id}</p> <p>${teacher.name}</p>
                </div>
            <#else>
                Put correct teacher id.
            </#if>
        </div>
    </div>
</body>
</html>
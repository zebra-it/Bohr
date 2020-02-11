<#import "common/common.ftl" as c>

<@c.page true>

<div class="container">
    <a href="/statistics/postStatistics">Статистика попостам</a>

<br>

    <h5>Зарегистрировано пользователей</h5>
    <table class="p-3">
        <thead>
        <tr>
            <th>Всего</th>
            <th>С постами</th>
            <th>Без постов</th>
            <th>Всего постов</th>
        </tr>
        </thead>
        <tbody>

            <tr>

                <td>${users}</td>

                <td>${usersWithPosts}</td>
                <td>${usersWithoutPosts}</td>
                <td>${allPosts}</td>

            </tr>

        </tbody>
    </table>

<hr>


</div>

</@c.page>
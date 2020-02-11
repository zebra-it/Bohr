<#import "common/common.ftl" as c>
<#include "common/securityPage.ftl">
<@c.page true>


    <div class="container">

        <h4>Список пользователей</h4>
        <table class="table">
            <thead class="thead-dark">
            <tr>
                <th scope="col">Name</th>
                <th scope="col">Email</th>
                <#if isAdmin>
                    <th scope="col">Role</th>
                </#if>
                <th scope="col"></th>
                <th scope="col"></th>
            </tr>
            </thead>
            <tbody>
            <#list users as user>
                <tr>
                    <td> <a href="posts/user-posts/${user.id}">${user.username}</a></td>

                    <td>${user.email}</td>
                    <#if isAdmin>
                        <td>
                            <#list user.roles as role> ${role} <#sep>, </#list>
                        </td>

                        <td><a href="/user/${user.id}">edit</a></td>
                        <td><a href="/user/delete/${user.id}">delete</a></td>
                    </#if>

                </tr>
            </#list>

            </tbody>
        </table>
    </div>
</@c.page>
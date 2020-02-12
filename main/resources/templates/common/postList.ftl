<!--- \\\\\\\Post-->
<#include "securityPage.ftl">


    <#list posts as post>
        <div class="card m-2">
            <div class="row ">
                <table>

                    <tr>

                        <td>
                            <#if post.filename??>
                                <img class="img-thumbnail" src="\img\${post.filename!''}" style="height: 150px;">

                            </#if>
                        </td>
                        <td>
                            <div class="card-body">

                                <div class="card-text" >
                                    ${post.text}
                                    <#if user??>
                                        <a href="/posts/user-posts/${post.author.id!""}">${post.authorName!''}</a>
                                    <#else>${post.authorName!''}
                                    </#if>

                                </div>
                                <div class="card-footer bg-transparent">

                                    <#if post.tagList??>
                                    <#list post.tagList as t>
                                        <a class="" href="/posts/search/${t.textTag!''}">#${t.textTag!''}</a>
                                    </#list>
                                    </#if>

                                    <#if post.author.id = currentUserId>
                                        <a class="btn btn-outline-primary btn-sm"
                                           href="/posts/delete/${post.id}">delete</a>
                                    </#if>
                                    ${post.postedAt}
                                </div>
                            </div>
                        </td>
                    </tr>

                </table>
            </div>

        </div>
        <#else >
            Постов нет
    </#list>

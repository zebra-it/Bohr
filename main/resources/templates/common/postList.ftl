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

                            <div class="card-text">
                                ${post.text}
                                <#if post.tagList??>
                                    <#list post.tagList as t>
                                        <a class="col align-self-center "
                                           href="/posts/search/${t.textTag!''}">#${t.textTag!''}</a>
                                    </#list>
                                </#if>
                            </div>
                            <div class="card-footer bg-transparent container">
                                <div class="row">
                                    <#if user??>
                                        <a class="col align-self-center "
                                           href="/posts/user-posts/${post.author.id!""}">${post.authorName!''}</a>
                                    <#else>${post.authorName!''}
                                    </#if>

                                    <#if post.author.id = currentUserId>
                                        <a class="btn btn-sm col align-self-center "
                                           href="/posts/delete/${post.id}"><i class="far fa-trash-alt"></i></a>
                                    </#if>
                                    ${post.postedAt?string('dd.MM.yy')}
                                </div>
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

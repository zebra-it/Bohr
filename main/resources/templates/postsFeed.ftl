<#import "common/common.ftl" as c>
<#include "common/securityPage.ftl">

<@c.page true>
    <div class="container-fluid gedf-wrapper">

        <div class="row">
        ${date}
        ${time}


            <div class="col">
                    <#include "common/postList.ftl">

            </div>
            <div class="col-sm-3 gedf-main">
                <#include "common/search.ftl">

                <h5>Список тегов</h5>

                <#if tags??>
                    <#list tags as tag>
                        <a class="btn btn-secondary btn-sm m-1" href="/posts/search/${tag!''}">#${tag!''}</a>
                    </#list>
                </#if>

            </div>

        </div>
    </div>



    <!-- Что то в третью колонку сюда-->


</@c.page>
<#import "common/common.ftl" as c>

<@c.page true>
    <div class="container">
        <div class="row ">
            <div id="container"
                 class="img-thumbnail col m-1">

            </div>
        </div>
    </div>
    <script inline="javascript">
        $(function () {
            Highcharts.chart('container', {
                chart: {
                    type: 'column'
                },
                title: {
                    text: 'Колличество постов в день'
                },

                xAxis: {
                    categories: [
                        <#list usersStatistics?keys as post>
                        '${post}',
                        </#list>
                    ],

                },
                yAxis: {
                    title: {
                        text: 'Колличество'
                    }
                },
                tooltip: {
                    headerFormat: '<span style="font-size:10px">{point.key}</span><table>',
                    pointFormat: '<tr><td style="color:{series.color};padding:0"/>' +
                        '<td style="padding:0"><b>{point.y} </b></td></tr>',
                    footerFormat: '</table>',
                    shared: true,
                    useHTML: true
                },
                plotOptions: {
                    column: {
                        pointPadding: 0.2,
                        borderWidth: 0
                    }
                },
                series: [{
                    name: 'Время',
                    colorByPoint: true,
                    data: [
                        <#list usersStatistics?keys as post>
                        ${usersStatistics[post]},
                        </#list>
                    ]
                }],

            });
        });
    </script>

</@c.page>
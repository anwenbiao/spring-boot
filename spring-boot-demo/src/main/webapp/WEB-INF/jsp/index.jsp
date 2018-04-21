<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <script src="../js/echarts.js"></script>
</head>
<body>
   <div id="main" style="width: 600px;height:400px;">123</div>

   <script type="text/javascript">
       // 基于准备好的dom，初始化echarts实例
       var myChart = echarts.init(document.getElementById('main'));

       /*var arr=["衬衫","羊毛衫","雪纺衫","裤子","高跟鞋","妹子"];

       // 指定图表的配置项和数据
       var option = {
           title: {
               text: 'ECharts 入门示例'
           },
           tooltip: {},
           legend: {
               data:['销量']
           },
           xAxis: {
               data: arr
           },
           yAxis: {},
           series: [{
               name: '销量',
               type: 'bar',
               data: [5, 20, 36, 10, 10, 20]
           }]
       };*/

       option = {
           legend: {},
           tooltip: {},
           dataset: {
               // 提供一份数据。
               source: [
                   ['product', '2015', '2016', '2017'],
                   ['Matcha Latte', 43.3, 85.8, 93.7],
                   ['Milk Tea', 83.1, 73.4, 55.1],
                   ['Cheese Cocoa', 86.4, 65.2, 82.5],
                   ['Walnut Brownie', 72.4, 53.9, 102]
               ]
           },
           // 声明一个 X 轴，类目轴（category）。默认情况下，类目轴对应到 dataset 第一列。
           xAxis: {type: 'category'},
           // 声明一个 Y 轴，数值轴。
           yAxis: {},
           // 声明多个 bar 系列，默认情况下，每个系列会自动对应到 dataset 的每一列。
           series: [
               {type: 'bar'},
               {type: 'bar'},
               {type: 'bar'}
           ]
       }

       // 使用刚指定的配置项和数据显示图表。
       myChart.setOption(option);
   </script>
</body>
</html>
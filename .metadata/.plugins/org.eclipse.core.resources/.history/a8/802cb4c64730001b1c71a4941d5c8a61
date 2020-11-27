<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
    <title>구글 차트 라이브러리</title>
    <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>  <!-- 라이브러리 Load -->
    <script src="http://code.jquery.com/jquery-3.1.1.min.js"></script>
</head>
<body>
    <div id="chart_div" style="width:1000px; height:500px;"></div>
</body>
<script type="text/javascript">
    changeChart();
    function changeChart(){
        google.charts.load('current', {'packages':['corechart']});
        google.charts.setOnLoadCallback(drawVisualization);
        function drawVisualization() { 
            $.ajax({
                type:"get",
                url:"cavg.json",
                dataType:"json",
                success:function(result){
                    var result = [["과목","점수"],["국어",90],["영어",80]];
                    var data = google.visualization.arrayToDataTable(result); /* 데이터 셋팅 */
                    var options = { title : '강좌별 평균 점수', seriesType: 'bars' }; /* 옵션 셋팅 */
                    var chart = new google.visualization.ComboChart(document.getElementById('chart_div'));
                    chart.draw(data, options); /* 차트 그리기 */
                }
            });
        }
    }
</script>
</html>
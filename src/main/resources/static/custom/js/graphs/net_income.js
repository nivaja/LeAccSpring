$.getJSON("http://localhost:8000/api/graph/monthlyIncome", function(json) {

    var chartData = {
        labels: json.months,
        datasets: [{
            type: 'line',
            label: 'Net',
            borderColor: '#90caf9',
            borderWidth: 2,
            fill: false,
            data: json.net
        }, {
            type: 'bar',
            label: 'Income',
            backgroundColor: '#64b5f6',
            data:
               json.income
            ,
            borderColor: 'white',
            borderWidth: 2
        }, {
            type: 'bar',
            label: 'Expense',
            backgroundColor: '#42a5f5',
            data: json.expenses
        }]

    };
// window.onload = function() {
    var ctx = document.getElementById('netIncome').getContext('2d');
    window.myMixedChart = new Chart(ctx, {
        type: 'bar',
        data: chartData,
        options: {
            responsive: true,
            title: {
                display: true,
                text: 'Monthly Income Overview'
            },
            tooltips: {
                mode: 'index',
                intersect: true
            }
        }
    });
});



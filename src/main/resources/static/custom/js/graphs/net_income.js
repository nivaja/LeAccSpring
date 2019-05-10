
var chartData = {
    labels: [ "January", "February", "March", "April", "May", "June",
        "July", "August", "September", "October", "November", "December" ],
    datasets: [{
        type: 'line',
        label: 'Net',
        borderColor: '#90caf9',
        borderWidth: 2,
        fill: false,
        data: [500, 800, 320, 180, 240, 320, 230, 650, 590, 1200, 750, 940]
    }, {
        type: 'bar',
        label: 'Income',
        backgroundColor: '#64b5f6',
        data:
            [400, 600, 320, 150, 440, 920, 230, 850, 500, 1000, 250, 540]
        ,
        borderColor: 'white',
        borderWidth: 2
    }, {
        type: 'bar',
        label: 'Expense',
        backgroundColor: '#42a5f5',
        data: [
            450, 500, 300, 200, 200, 350, 325, 500, 210, 1100, 520, 500
        ]
    }]

};
window.onload = function() {
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
};



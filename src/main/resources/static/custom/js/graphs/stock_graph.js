
//var MONTHS = ['January', 'February', 'March', 'April', 'May', 'June', 'July', 'August', 'September', 'October', 'November', 'December'];
//var color = Chart.helpers.color;
var stockData = {
    labels: ['January', 'February', 'March', 'April', 'May', 'June', 'July'],
    datasets: [{
        label: 'Dataset 2',
        backgroundColor: '#64b5f6',
      //  borderColor: window.chartColors.blue,
        borderWidth: 1,
        data:  [400, 600, 320, 150, 440, 920, 230, 850, 500, 1000, 250, 540]
    }]

};

    var stockGraph = document.getElementById('stockSummary').getContext('2d');
    window.stockBar = new Chart(stockGraph, {
        type: 'bar',
        data: stockData,
        options: {
            responsive: true,
            legend: {
                position: 'top',
            },
            title: {
                display: true,
                text: 'Chart.js Bar Chart'
            }
        }
    });






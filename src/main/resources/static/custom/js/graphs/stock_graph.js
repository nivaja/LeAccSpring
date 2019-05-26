
//var MONTHS = ['January', 'February', 'March', 'April', 'May', 'June', 'July', 'August', 'September', 'October', 'November', 'December'];
//var color = Chart.helpers.color;
$.getJSON("http://localhost:8000/api/graph/stockSummary", function(data) {
    console.log(data.quantities);
    console.log(data.lable);

    var stockData = {
        labels: data.lable,
        datasets:
            [{
                label: 'Quantity',
                backgroundColor: '#64b5f6',
                //  borderColor: window.chartColors.blue,
                borderWidth: 1,
                data: data.quantities
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
                display: false
            }
        }
    });

});




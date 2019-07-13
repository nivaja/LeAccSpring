$.getJSON("https://leacc.herokuapp.com/api/graph/salesByCustomer", function(json) {
console.log(json);
    var barOptions_stacked = {
    tooltips: {
        enabled: false
    },
    hover :{
        animationDuration:0
    },
    scales: {
        xAxes: [{
            ticks: {
                beginAtZero:true,
                fontFamily: "'Open Sans Bold', sans-serif",
                fontSize:11
            },
            scaleLabel:{
                display:false
            },
            gridLines: {
            },
            stacked: true
        }],
        yAxes: [{
            gridLines: {
                display:false,
                color: "#fff",
                zeroLineColor: "#fff",
                zeroLineWidth: 0
            },
            ticks: {
                fontFamily: "'Open Sans Bold', sans-serif",
                fontSize:11
            },
            stacked: true
        }]
    },
    legend:{
        display:false
    },

    animation: {
        onComplete: function () {
            var chartInstance = this.chart;
            var ctx = chartInstance.ctx;
            ctx.textAlign = "left";
            ctx.font = "9px Open Sans";
            ctx.fillStyle = "#fff";

            Chart.helpers.each(this.data.datasets.forEach(function (dataset, i) {
                var meta = chartInstance.controller.getDatasetMeta(i);
                Chart.helpers.each(meta.data.forEach(function (bar, index) {
                    data = dataset.data[index];
                    if(i==0){
                        ctx.fillText(data, 50, bar._model.y+4);
                    } else {
                        ctx.fillText(data, bar._model.x-25, bar._model.y+4);
                    }
                }),this)
            }),this);
        }
    },
    pointLabelFontFamily : "Quadon Extra Bold",
    scaleFontFamily : "Quadon Extra Bold"
};








console.log(json.customers);

    var barChartData = {
        labels: json.customers,

        datasets: [{
            label: json.products[0],
            data: json.values[0],
            backgroundColor: '#42a5f5',
            hoverBackgroundColor: "#2196f3"
        }, {
            label: json.products[1],
            data: json.values[1],
            backgroundColor: "#1e88e5",
            hoverBackgroundColor: "#1976d2"
        }, {
            label: json.products[2],
            data: json.values[2],
            backgroundColor: "#1565c0",
            hoverBackgroundColor: "#0d47a1"
        }, {
            label: json.products[3],
            data: json.values[3],
            backgroundColor: "#1565c0",
            hoverBackgroundColor: "#0d47a1"
        }

        ]
    };

window.onload = function() {
    var salesByCustomerGraph = document.getElementById('salesByCustomer').getContext('2d');
    window.myBar = new Chart(salesByCustomerGraph, {
        type: 'bar',
        data: barChartData,
        options: {
            title: {
                display: true,
                text: 'Sales By Customer'
            },
            tooltips: {
                mode: 'index',
                intersect: false
            },
            responsive: true,
            scales: {
                xAxes: [{
                    stacked: true,
                }],
                yAxes: [{
                    stacked: true
                }]
            }
        }
    });
};
});
// document.getElementById('randomizeData').addEventListener('click', function() {
//     barChartData.datasets.forEach(function(dataset) {
//         dataset.data = dataset.data.map(function() {
//             return randomScalingFactor();
//         });
//     });
//     window.myBar.update();
// });

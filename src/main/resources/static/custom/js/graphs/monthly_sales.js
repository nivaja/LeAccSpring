var g = document.getElementById("monthlySales").getContext('2d');

$.getJSON("https://leacc.herokuapp.com/api/graph/monthlySales", function(data) {

    var monthlySales = new Chart(g, {
        type: 'line',
        data: {
            labels: data.lables,
            datasets: [{
                label: "Sales",
                data: data.values,
                backgroundColor: [
                    'rgba(105, 0, 132, .2)',
                ],
                borderColor: [
                    'rgba(200, 99, 132, .7)',
                ],
                borderWidth: 2
            }
            ]
        },
        options: {
            responsive: true
        }
    });
});
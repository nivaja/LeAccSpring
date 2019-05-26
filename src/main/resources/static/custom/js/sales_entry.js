$("#salesForm").submit(function (e) {
    e.preventDefault();
    var data=JSON.stringify(getSales());
    console.log(data);
    var URL = "http://localhost:8000/api/sales/add";
    $.ajax({
        type: "POST",
        url: URL,
        contentType: 'application/json',
        data: data,
        success: Swal.fire(
            'The Internet?',
            'That thing is still around?',
            'success'
        ),
        dataType: "json"
    });

});


$("input[name='date']").click(function () {
    $("input[name='date']").val(getCurrentDate());
});

function getSales(){
    var objects= {
        customer:{customerId:$("select[name='customer']").val()},
        vehicle:{vehicleId:$("select[name='vehicle']").val()},
        salesAgent:{salesAgentId:$("select[name='salesAgent']").val()},
        salesProducts: salesProducts()
    };


    var formArray = $("#salesInfo").find("input").serializeArray();
    for (var i = 0; i < formArray.length; i++){
        objects[formArray[i]['name']] = formArray[i]['value'];
    }
    return objects;
}

function salesProducts() {
    var heads = ['product','quantity','rate','amount','discountPercent','discountAmount','netAmount'];


    var rows=[];

    $("tbody tr").each(function () {
        cur = {};
        $(this).find("td:not(:last-child)").each(function(i, v) {
            cur[heads[i]] = $(this).find("input,select").val().trim();
            //var product = cur['product'];
            if(i===0) {
                console.log($(this).find('.product').val());
                console.log($(this).find('select').val());
                cur.product={productId:$(this).find('.product').val()};
            }
        });
        console.log(cur);
        rows.push(cur);
        cur = {};
    });

    return rows;
}


$("#purchaseForm").submit(function (e) {
    e.preventDefault();
   var data=JSON.stringify(getPurchase());
    console.log(data);
    var URL = "http://localhost:8000/api/purchase/add";
    $.ajax({
        type: "POST",
        url: URL,
        contentType: 'application/json',
        data: data,
        success: success($("#purchaseForm")),
        dataType: "json"
    });

});


$("input[name='date']").click(function () {
    $("input[name='date']").val(getCurrentDate());
});

function getPurchase(){
    var objects= {
        vendor:{vendorId:$("select[name='vendor']").val()},
        vehicle:{vehicleId:$("select[name='vehicle']").val()},
        purchaseProducts: purchaseProducts()
    };


    var formArray = $("#purchaseInfo").find("input").serializeArray();
    for (var i = 0; i < formArray.length; i++){
        objects[formArray[i]['name']] = formArray[i]['value'];
    }
    return objects;
}

function purchaseProducts() {
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
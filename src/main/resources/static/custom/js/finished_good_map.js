$("#finishedProductMapForm").submit(function (e) {
    e.preventDefault();
    var data=JSON.stringify(getTransfer());
    console.log(data);
    var URL = "https://leacc.herokuapp.com/api/finishedProductMap/add";
    $.ajax({
        type: "POST",
        url: URL,
        contentType: 'application/json',
        data: data,
        success: alert("done"),
        dataType: "json"
    });

});

$("input[name='date']").click(function () {
    $("input[name='date']").val(getCurrentDate());
});

function getTransfer(){
    var objects= {
        description:$("input[name='description']").val(),
        quantity:$("input[name='quantity']").val(),
        productToMap:{productId:$("#productToMap").val()},
        finishedProductMapItem: finishedProductMapProducts()
    };
    return objects;
}

function finishedProductMapProducts() {
    var heads = ['product','quantity','remarks'];


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
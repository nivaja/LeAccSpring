$("#inventoryTransferForm").submit(function (e) {
    e.preventDefault();
    var data=JSON.stringify(getTransfer());
    console.log(data);
    var URL = "https://leacc.herokuapp.com/api/inventoryTransfer/add";
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
        fromGodown:{godownId:$("select[name='fromGodown']").val()},
        toGodown:{godownId:$("select[name='toGodown']").val()},
        description:$("input[name='description']").val(),
        date:$("input[name='date']").val(),
        billNo:$("input[name='billNo']").val(),
        inventoryTransferProducts: inventoryTransferProducts()
    };
    return objects;
}

function inventoryTransferProducts() {
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
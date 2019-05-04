$("#salesForm").submit(function (e) {
    e.preventDefault();
    var json = {
        sales:salesInfo(),
        sales_product:rowsToJson()
    };
    console.log(rowsToJson());
    console.log(salesInfo());
    console.log(json);
    console.log(JSON.stringify(json));
    var URL = "http://localhost:8000/api/sales/add";
    $.ajax({
        type: "POST",
        url: URL,
        contentType: 'application/json',
        data: JSON.stringify(json),
        success: payment_popup(),
        dataType: "json"
    });

});

function getCurrentDate() {
    var now = new Date();

    var day = ("0" + now.getDate()).slice(-2);
    var month = ("0" + (now.getMonth() + 1)).slice(-2);

    var today = now.getFullYear()+"-"+(month)+"-"+(day) ;

    return today;
}



$("input[name='date']").click(function () {
    $("input[name='date']").val(getCurrentDate());
});




$(document).on('click','.addRow',function (e) {
    e.preventDefault();
   $("table.productTable").append(($(".mainRow").first()).clone().find('input').val('').end());
   $("tr td:not(:last-child)").find(".addRow").remove();
});

$(document).on('click','.removeRow',function () {

    $(this).closest('tr').remove();
});




function rowsToJson() {
    var heads = [];
    $("thead").find("th:not(:first-child,:last-child)").each(function () {
        heads.push($(this).text().trim());
    });

    var rows = [];
    $("tbody tr").each(function () {
        cur = {};
        $(this).find("td:not(:last-child)").each(function(i, v) {
            cur[heads[i]] = $(this ).find('input,select').val().trim();
        });
        rows.push(cur);
        cur = {};
    });
    return rows;
}

function salesInfo() {
    var returnArray = {};
    var formArray = $("#salesInfo").find("input,select").serializeArray();
    for (var i = 0; i < formArray.length; i++){
        returnArray[formArray[i]['name']] = formArray[i]['value'];
    }
    return returnArray;
}

//payment pop-up modal

function  payment_popup() {

       // $('#voucher_modal').modal('toggle');

}

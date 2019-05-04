$("#voucherPaymentForm").submit(function (e) {
    e.preventDefault();
    var data=JSON.stringify(getPaymentDetail());
    console.log(data);
    var URL = "http://localhost:8000/api/voucherPayment/add";
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

function getPaymentDetail(){
    var objects= {
       cashSubAccount :{subAccountId:$("select[name='cashSubAccount']").val()},
        description:$("input[name='description']").val(),
        date:$("input[name='date']").val(),
        billNo:$("input[name='billNo']").val(),
        chequeNo:$("input[name='chequeNo']").val(),
        paymentAccount: paymentAccounts()
    };
    return objects;
}

function paymentAccounts() {
    var heads = ['account','subAccount','amount','remarks'];


    var rows=[];

    $("tbody tr").each(function () {
        cur = {};
        $(this).find("td:not(:last-child)").each(function(i, v) {
            cur[heads[i]] = $(this).find("input,select").val().trim();
            //var product = cur['product'];
            if(i===0) {
                console.log($(this).find('.account').val());
                console.log($(this).find('select:first-child').val());
                console.log($(this).find('select:last-child').val());

                cur.account={accountId:$(this).find('.account').val()};
            }
            if(i===1) {
                cur.subAccount = {subAccountId: $(this).find('.subAccount').val()};
            }

        });
        console.log(cur);
        rows.push(cur);
        cur = {};
    });

    return rows;
}

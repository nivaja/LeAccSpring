
$("#toCustomer").val($("#customer option:selected").text());
//$("#leftAmount").val(()-());

var reciptAccountList=[];
var recieptAccountObj=
    {
        account:{accountId:"1"},
        subAccount:{subAccountId:"2"},
        amount: $("input[name='paidAmount']").val(),
        remarks:""


};
reciptAccountList.push(recieptAccountObj);
var objects= {
    cashSubAccount :{subAccountId:$("select[name='cashSubAccount']").val()},
    description:$("input[name='paymentDescription']").val(),
    date:$("#date").val(),
    billNo:$("input[name='paymentBillNo']").val(),
    chequeNo:$("input[name='chequeNo']").val(),
    reciptAccount: reciptAccountList
};

$("#recieptModalForm").submit(function (e) {
    e.preventDefault();
    var json = objects;
    console.log(JSON.stringify(json));
    var URL = "https://leacc.herokuapp.com/api/voucherReciept/add";
    $.ajax({
        type: "POST",
        url: URL,
        contentType: 'application/json',
        data: JSON.stringify(json),
        success: alert("sucess"),
        dataType: "json"
    });

});
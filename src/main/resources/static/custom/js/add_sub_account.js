$(function(){
    $("#subAccountForm").submit(function (e) {
        e.preventDefault();


        var json = getSubAccount();
        console.log(json);
        var URL = "https://leacc.herokuapp.com/api/subAccount/add";
        $.ajax({
            type: "POST",
            url: URL,
            contentType: 'application/json',
            data: json,
            success: success($("#subAccountForm")),
            dataType: "json"
        });
        clear();
    });
});
function getSubAccount() {
    var data= {
        account:{accountId:$("#account").val()},
        subAccountDescription:$("input[name='subAccountDescription']").val()
    };

    return JSON.stringify(data);
}

function clear() {
    //   $("#userForm").trigger("reset")
    $(':input','#accountForm')
        .not(':button, :submit, :reset, :hidden')
        .val('')
        .prop('checked', false)
        .prop('selected', false);
}


$("#cancel").click(function () {
    clear();
});
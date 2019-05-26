$(function(){
    $("#accountForm").submit(function (e) {
        e.preventDefault();


        var json = getAccount();
        console.log(json);
        var URL = "http://localhost:8000/api/account/add";
        $.ajax({
            type: "POST",
            url: URL,
            contentType: 'application/json',
            data: json,
            success: success($("#accountForm")),
            dataType: "json"
        });
        clear();
    });
});
function getAccount() {
    var data= {
        // accountTypeGroup:{accountTypeGroupId:$("#accountTypeGroup").val()},
        accountType:{accountTypeId:$("#accountType").val()},
        accountDescription:$("input[name='accountDescription']").val()
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
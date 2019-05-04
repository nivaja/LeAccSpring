$(function(){
    $("#customerForm").submit(function (e) {
        e.preventDefault();
        var data = JSON.stringify(objectifyForm($("#customerForm").serializeArray()));
        alert(data);
        var URL = "http://localhost:8000/api/customer/add"
        $.ajax({
            type: "POST",
            url: URL,
            contentType: 'application/json',
            data: data,
            success: alert("done"),
            dataType: "json"
        });
        clear();
    });
});

function objectifyForm(formArray) {//serialize data function

    var returnArray = {};
    for (var i = 0; i < formArray.length; i++){
        returnArray[formArray[i]['name']] = formArray[i]['value'];
    }
    return returnArray;
}

function clear() {
    //   $("#userForm").trigger("reset")
    $(':input','#customerForm')
        .not(':button, :submit, :reset, :hidden')
        .val('')
        .prop('checked', false)
        .prop('selected', false);
}


$("#cancel").click(function () {
   clear();
});
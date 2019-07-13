$(function(){
    $("#godownForm").submit(function (e) {
        e.preventDefault();
        var data = JSON.stringify(objectifyForm($("#godownForm").serializeArray()));
        alert(data);
        var URL = "https://leacc.herokuapp.com/api/godown/add"
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

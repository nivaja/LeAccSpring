$("#maintenanceEntryForm").submit(function (e) {
    e.preventDefault();
    var data=JSON.stringify(makeJson($(this).serializeArray()));
    console.log(data);
    var URL = "http://localhost:8000/api/maintenanceEntry/add";
    $.ajax({
        type: "POST",
        url: URL,
        contentType: 'application/json',
        data: data,
        success: alert("done"),
        dataType: "json"
    });
});

function makeJson(formArray) {
    var returnArray = {};
    for (var i = 0; i < formArray.length; i++){
        returnArray[formArray[i]['name']] = formArray[i]['value'];
    }
    returnArray.vehicle={vehicleId:$("select[name='vehicle']").val()};
    return returnArray;
}

$("input[name='date']").click(function () {
    $("input[name='date']").val(getCurrentDate());
});
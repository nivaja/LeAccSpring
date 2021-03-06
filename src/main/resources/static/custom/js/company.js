function populate(frm, data) {
    $.each(data, function(key, value){
        $('[name='+key+']', frm).val(value);
    });
}

$.getJSON( "http://localhost:8000/api/company/get", function( data ) {
    console.log(data);
    populate('#companyForm', data);
});


$("#companyForm").submit(function (e) {
    e.preventDefault();
    console.log(JSON.stringify(companyInfo()));
    var URL = "http://localhost:8000/api/company/put";
    $.ajax({
        type: "PUT",
        url: URL,
        contentType: 'application/json',
        data: JSON.stringify(companyInfo()),
        success: alert("success"),
        dataType: "json"
    });

});

function companyInfo() {
    var returnArray = {};
    var formArray = $("#companyForm").find("input,select").serializeArray();
    for (var i = 0; i < formArray.length; i++){
        returnArray[formArray[i]['name']] = formArray[i]['value'];
    }
    return returnArray;
}


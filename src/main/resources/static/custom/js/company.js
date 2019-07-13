function populate(frm, data) {
    $.each(data, function(key, value){
        $('[name='+key+']', frm).val(value);
    });
}

$.getJSON( "https://leacc.herokuapp.com/api/company/get", function( data ) {
    console.log(data);
    populate('#companyForm', data);
});


$("#companyForm").submit(function (e) {
    e.preventDefault();
    console.log(JSON.stringify(companyInfo()));
    var URL = "https://leacc.herokuapp.com/api/company/put";
    $.ajax({
        type: "PUT",
        url: URL,
        contentType: 'application/json',
        data: JSON.stringify(companyInfo()),
        success: success($("#companyForm")),
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


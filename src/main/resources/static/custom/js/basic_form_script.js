function getCurrentDate() {
    var now = new Date();

    var day = ("0" + now.getDate()).slice(-2);
    var month = ("0" + (now.getMonth() + 1)).slice(-2);

    var today = now.getFullYear()+"-"+(month)+"-"+(day) ;

    return today;
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

$(document).on('click','.addRow',function (e) {
    e.preventDefault();
    $("table.productTable").append(($(".mainRow").first()).clone().find('input').val('').end());
    $("tr td:not(:last-child)").find(".addRow").remove();
});

$(document).on('click','.removeRow',function () {
    $(this).closest('tr').remove();
});

function success(form){
    Swal.fire(
        'Record Saved',

        'success'
    );
    form.get(0).reset();
    clear_form_elements(form);
}
function clear_form_elements(ele) {

    $(ele).find(':input').each(function() {
        switch(this.type) {
            case 'password':
            case 'select-multiple':
            case 'select-one':
            case 'text':
            case 'textarea':
                $(this).val('');
                break;
            case 'checkbox':
            case 'radio':
                this.checked = false;
        }
    });

}

$("#submit").click(function () {


    var URL = "http://localhost:8000/api/user/addUser"
    $.ajax({
        type: "POST",
        url: URL,
        contentType: 'application/json',
        data: data(),
        success: alert("done"),
        dataType: "json"
    });
   clear()

});

$("#clear").click(function () {
    clear();
});
function data() {
    var username = $("input[name='username']").val();
    var password = $("input[name='password']").val();
    var email = $("input[name='email']").val();
    var defaultRole = $("input[name='defaultRole']:checked").val();
    var roles = getAllRole();

    var json = new Object();
    json.username=username;
    json.password=password;
    json.email=email;
    json.defaultRole=defaultRole;
    json.roles=roles;
    return JSON.stringify(json);
}

function getAllRole() {
    var roles = [];
    $('.role :checked').each(function() {
        roles.push($(this).val());
    });
    return roles;
}

function clear() {
 //   $("#userForm").trigger("reset")
    $(':input','#userForm')
        .not(':button, :submit, :reset, :hidden')
        .val('')
        .prop('checked', false)
        .prop('selected', false);
}
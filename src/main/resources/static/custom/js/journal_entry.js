$("#journalEntryForm").submit(function (e) {
    e.preventDefault();
    getDebitAccounts();
    var data=JSON.stringify(getJournalDetail());
    console.log(data);
    var URL = "http://localhost:8000/api/journal/add";
    $.ajax({
        type: "POST",
        url: URL,
        contentType: 'application/json',
        data: data,
        success: alert("done"),
        dataType: "json"
    });

});

$("input[name='date']").click(function () {
    $("input[name='date']").val(getCurrentDate());
});

function getJournalDetail(){
    var objects= {

        description:$("input[name='description']").val(),
        transactionDate:$("input[name='date']").val(),
        journalNo:$("input[name='journalNo']").val(),
        journalDebits: getDebitAccounts(),
        journalCredits: getCreditAccounts()

    };
    return objects;
}


function getDebitAccounts(){

    var heads = ['debitAccount','debitSubAccount','debitAmount','creditAmount','description'];
    var rows=[];
    $("tbody tr").each(function () {
        cur = {};
        var creditAmount= $(this).find(".creditAmount").val().trim();
        var debitAmount= $(this).find(".debitAmount").val().trim();
        console.log(debitAmount);
        if( debitAmount!== null) {
            $(this).find("td:not(:last-child):not('.creditAmount')").each(function(i, v) {
                cur[heads[i]] = $(this).find("select,input:not('.creditAmount')").val();
                //var product = cur['product'];
                if(i===0) {
                    console.log($(this).find('.account').val());
                    console.log($(this).find('select:first-child').val());
                    console.log($(this).find('select:last-child').val());

                    cur.debitAccount={accountId:$(this).find('.account').val()};
                }
                if(i===1) {
                    cur.debitSubAccount = {subAccountId: $(this).find('.subAccount').val()};
                }
            });


        }
        console.log(cur);
        rows.push(cur);

        cur = {};
    });
    return rows;

}
function getCreditAccounts(){

    var heads = ['creditAccount','creditSubAccount','debitAmount','creditAmount','description'];
    var rows=[];
    $("tbody tr").each(function () {
        cur = {};
        var creditAmount= $(this).find(".creditAmount").val().trim();
        var debitAmount= $(this).find(".debitAmount").val().trim();
        console.log(creditAmount);
        if(creditAmount !== null) {
            $(this).find("td:not(:last-child):not('.debitAmount')").each(function(i, v) {
                cur[heads[i]] = $(this).find("select,input:not('.debitAmount')").val();
                //var product = cur['product'];
                if(i===0) {
                    console.log($(this).find('.account').val());
                    console.log($(this).find('select:first-child').val());
                    console.log($(this).find('select:last-child').val());

                    cur.creditAccount={accountId:$(this).find('.account').val()};
                }
                if(i===1) {
                    cur.creditSubAccount = {subAccountId: $(this).find('.subAccount').val()};
                }
            });


        }
        console.log(cur);
        rows.push(cur);

        cur = {};
    });
    return rows;

}

// $(document).on('change','.debitAmount',function (e) {
//     $(".creditAmount").prop('disabled', true);
// });

//TODO: fix login function;

function applyReservation() {
    let id = $("#reservationId").val();
    let status =$("#status-id").val();
    console.log("id: " + id + "/n" + "status " + status );

    $.ajax({
        type: 'POST',
        url: '/javaEE_war_exploded/admin/reservations',
        data:JSON.stringify(
            {
                reservationId:id,
                status: status
            }
        )
    })
}


function login() {
    let email = $("#email").val();
    let password = $("#password").val();

    if (email==""){
        return false;
    }
    else if (password == ""){
        password.parent('td').addClass('has-error');
        return false;
    }
    else {
        console.log("Stat","djfkajdskfa");
        $.ajax(
            {
                type: 'POST',
                url: '/javaEE_war_exploded/login',
                data:JSON.stringify(
                    {
                        email: email,
                        password: password
                    }
                )
            }
        ).done();
    }


}
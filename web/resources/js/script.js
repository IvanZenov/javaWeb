function sendDataToServer() {
    let inputValue = $("#data").val();
    $.ajax({
        url:'/ajax',
        method: 'POST',
        data: JSON.stringify({
            message: inputValue
        })
    })
}

function login() {
    let email = $("#email").val();
    let password = $("#password").val();
    let loginStatus = $("#login-status").val();

    if (email==""){

        loginStatus.text("Input email!");
        return false;
    }
    else if (password == ""){
        password.parent('td').addClass('has-error');
        loginStatus.text("Input password!");
        return false;
    }
    else {
        $.ajax(
            {
                type: 'POST',
                url: '/login',
                data:JSON.stringify(
                    {
                        email: email,
                        password: password
                    }
                )
            }
        ).done(function (data) {
            loginStatus.text(data.outputMessage)
        });
    }

    
}
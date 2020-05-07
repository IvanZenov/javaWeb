//TODO: fix login function;

function login() {
    let email = $("#email").val();
    let password = $("#password").val();
    let loginStatus = $("#login-status").val();

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
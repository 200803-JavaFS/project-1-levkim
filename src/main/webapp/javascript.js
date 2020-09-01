const url = "http://localhost:8080/project1/";

document.getElementById("login-btn").addEventListener("click", loginFunc);

async function loginFunc() {

    let usern = document.getElementById("username").value;
    let userp = document.getElementById("password").value;

    let user = {
        username: usern,
        password: userp
    };

    let resp = await fetch(url + "login", {
        credentials: "include",
        method: 'POST',
        body: JSON.stringify(user)
    });

    if (resp === 200) {
        console.log(resp);
        document.getElementById("login-row").innerText = "You have successfully logged in!";
    } else {
        document.getElementById("login-row").innerText = "Login failed.";
    }

}


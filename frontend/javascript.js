const url = "http://localhost:8080/project1/";

document.getElementById("login-btn").addEventListener("click", loginFunc);

async function loginFunc() {

    let name = document.getElementById("username").value;
    let pass = document.getElementById("password").value;

    let user = {
        username: name,
        password: pass
    };

    let resp = await fetch(url + "login", {
        method: 'POST',
        body: JSON.stringify(user),
        credentials: "include"
    }); // don't forget resp.status for checking response status!!!!!!!

    if (resp.status === 200) {
        console.log(resp);
        document.getElementById("login-row").innerText = "You have successfully logged in!";
        window.location.href = "dashboard.html";
    } else {
        document.getElementById("login-row").innerText = "Login failed.";
    }
}
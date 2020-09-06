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

    console.log(resp.json);

    if (resp.status === 200) {
        console.log(resp);
        document.getElementById("login-row").innerText = "You have successfully logged in!";
        redirect();
    } else {
        document.getElementById("login-row").innerText = "Login failed.";
    }
}

async function redirect() {
    let resp = await fetch(url + "success", {
        method: "GET",
        credentials: "include"
    });
    
    let data = await resp.json();
    let id = data.id;
    sessionStorage.setItem("user", id);

    if (data.type.id === 2) {
        window.location.href = "dashboard.html";
    } else if (data.type.id === 1) {
        window.location.href = "manager.html";
    } else {
        console.log("Something went wrong with checking user type!");
        window.location.href = "index.html";
    }
}
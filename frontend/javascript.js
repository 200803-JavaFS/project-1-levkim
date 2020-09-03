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
    } else {
        document.getElementById("login-row").innerText = "Login failed.";
    }

}

async function findAllFunc() {

    document.getElementById("pills-all").innerText = "";

    let resp = await fetch(url + "reimbursement", {
        credentials: 'include',
    });

    if (resp.status === 200) {
        let data = await resp.json();
        for (let reimbursement of data) {
            console.log(reimbursement);
            let row = document.createElement("section");
            row.className("reimbursement mb-5");
            let article = document.createElement("article");
            article.className("p-5 border rounded shadow");
            row.appendChild(article);
            document.getElementById("pills-all").appendChild(row);
        }
    }
}

async function AddFunc() {

    let amt = document.getElementById("ramt").value;
    let datee = document.getElementById("rdate").value;
    let type = document.getElementById("rtype").value;
    let statuss = document.getElementById("rstatus").value("PENDING");

    let reimb = {
        ramt: amt,
        rdate: datee,
        rtype: type,
        rstatus: statuss
    };

    console.log(reimb);

    let resp = await fetch(url + "reimbursement", {
        method: 'POST',
        body: JSON.stringify(avenger),
        credentials: "include"
    });

    if (resp.status === 201) {
        findAllFunc();
    } else {
        document.getElementById("login-row").innerText = "Reimbursement could not be added.";
    }

}
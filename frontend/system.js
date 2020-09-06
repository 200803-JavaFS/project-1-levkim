const url = "http://localhost:8080/project1/";

let user = sessionStorage.getItem("user");

async function findAllFunc() {
    document.getElementById("pills-all").innerText = "";

    let resp = await fetch(url + "reimbursement" + "author" + user, {
        method: 'GET',
        credentials: 'include'
    });

    if (resp.status === 200) {
        let data = await resp.json();
        for (let reimb of data) {
            console.log(reimb);
            let row = document.createElement("section");
            row.className("reimbursement mb-5");
            let article = document.createElement("article");
            article.className("p-5 border rounded shadow");
            row.appendChild(article);
            document.getElementById("pills-all").appendChild(row);
        }
    }
}

async function findStatus() {
    let resp = await fetch(url + "reimbursement" + "status" + user, {
        method: 'GET',
        credentials: 'include'
    });

    if (resp.status === 200) {
        let data = await resp.json();
        let rstatus = data.status.id;
        if (rstatus === 1) {
            for (let reimb of data) {
                console.log(reimb);
                let row = document.createElement("section");
                row.className("reimbursement mb-5");
                let article = document.createElement("article");
                article.className("p-5 border rounded shadow");
                row.appendChild(article);
                document.getElementById("pills-pending").appendChild(row);
            }
        } else if (rstatus === 2) {
            for (let reimb of data) {
                console.log(reimb);
                let row = document.createElement("section");
                row.className("reimbursement mb-5");
                let article = document.createElement("article");
                article.className("p-5 border rounded shadow");
                row.appendChild(article);
                document.getElementById("pills-approve").appendChild(row);
            }
        } else if (rstatus === 3) {
            for (let reimb of data) {
                console.log(reimb);
                let row = document.createElement("section");
                row.className("reimbursement mb-5");
                let article = document.createElement("article");
                article.className("p-5 border rounded shadow");
                row.appendChild(article);
                document.getElementById("pills-declined").appendChild(row);
            }
        }
    }
}

async function logout() {
    let resp = await fetch(url + "logout", {
        credentials: "include"
    });

    if (resp.status === 200) {
        window.location.href = "index.html";
    }
}
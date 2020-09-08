const url = "http://localhost:8080/project1/";

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
        let data = resp.json();
        sessionStorage.setItem("user", data);
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

    console.log(resp.json);

    let data = await resp.json();
    let id = data.id;
    console.log(data);

    if (data.type.id === 2) {
        window.location.href = "dashboard.html";
    } else if (data.type.id === 1) {
        window.location.href = "manager.html";
    } else {
        console.log("Something went wrong with checking user type!");
        window.location.href = "index.html";
    }
}

async function findAllFunc() {
    let resp = await fetch(url + "reimbursement", {
        method: "GET",
        credentials: "include"
    });

    console.log(resp.json);

    if (resp.status === 200) {
        let data = await resp.json();
        document.getElementById("all-reimb").innerText = "";
        
        for (let reimb of data) {
            console.log(reimb);


            let row = document.createElement("tr");
            let cell = document.createElement("td");
            cell.innerHTML = reimb.id;
            row.appendChild(cell);
            let cell2 = document.createElement("td");
            cell2.innerHTML = reimb.amt;
            row.appendChild(cell2);
            let cell3 = document.createElement("td");
            cell3.innerHTML = reimb.submitted.month + " " + reimb.submitted.dayOfMonth + ", " + reimb.submitted.year;
            row.appendChild(cell3);
            let cell4 = document.createElement("td");
            cell4.innerHTML = reimb.author.first_name + " " + reimb.author.last_name;
            row.appendChild(cell4);
            let cell5 = document.createElement("td");
            if (reimb.resolved == null) {
                cell5.innerHTML = "not yet resolved.";
            } else {
                cell5.innerHTML = reimb.resolved.month + " " + reimb.resolved.dayOfMonth + ", " + reimb.resolved.year;
            }
            row.appendChild(cell5);
            let cell6 = document.createElement("td");
            if ( reimb.resolver == null) {
                cell6.innerHTML = "no resolver";
            } else {
                cell6.innerHTML = reimb.resolver.first_name + " " + reimb.resolver.last_name;
            }
            row.appendChild(cell6);
            let cell7 = document.createElement("td");
            cell7.innerHTML = reimb.status.status;
            row.appendChild(cell7);
            let cell8 = document.createElement("td");
            cell8.innerHTML = reimb.type.type;
            row.appendChild(cell8);
            document.getElementById("all-reimb").appendChild(row);
        }
    } else {
        document.getElementById("all-reimb").innerHTML = "No reimbursements were found. Would you like to create one?".link("addReimn.html");
    }
}

async function findStatus() {
    let resp = await fetch(url + "reimbursement/" + "status", {
        method: 'GET',
        credentials: 'include'
    });

    if (resp.status === 200) {
        let data = await resp.json();
        let rstatus = data.status.id;
        if (rstatus === 1) {
            for (let reimb of data) {
                console.log(reimb);
                let pend = document.getElementById("pend-reimb");
                pend.innerHTML = '';
                pend.appendChild(make(data));
            }
        } else if (rstatus === 2) {
            for (let reimb of data) {
                console.log(reimb);
                let approve = document.getElementById("app-reimb");
                approve.innerHTML = '';
                approve.appendChild(make(data));
            }
        } else if (rstatus === 3) {
            for (let reimb of data) {
                console.log(reimb);
                let decline = document.getElementById("deny-reimb");
                decline.innerHTML = '';
                decline.appendChild(make(data));
            }
        }
    }
}

async function AddFunc() {

    let amt = document.getElementById("ramt").value;
    let submit = new Date("");
    let type = document.getElementById("rtype").value;

    let reimb = {
        ramt: amt,
        rdate: submit,
        rtype: type
    };

    console.log(reimb);

    let resp = await fetch(url + "reimbursement", {
        method: 'POST',
        body: JSON.stringify(reimb),
        credentials: "include"
    });

    if (resp.status === 201) {
        document.getElementById("add-msg").innerText = "Reimbursement successfully added!";
    } else {
        document.getElementById("add-msg").innerText = "Reimbursement could not be added.";
    }

}

async function logout() {

    let resp = await fetch(url + "logout", {
        credentials: "include"
    });

    if (resp.status === 200) {
        window.location.href = "index.html";
    } else {
        sessionStorage.clear();
        window.location.href = "index.html";
    }
}
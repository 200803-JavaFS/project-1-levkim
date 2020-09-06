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
        body: JSON.stringify(reimb),
        credentials: "include"
    });

    if (resp.status === 201) {
        findAllFunc();
    } else {
        document.getElementById("pills-all-msg").innerText = "Reimbursement could not be added.";
    }

}
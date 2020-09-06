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
        document.getElementById("add-msg").innerText = "Reimbursement successfully added!";
    } else {
        document.getElementById("add-msg").innerText = "Reimbursement could not be added.";
    }

}
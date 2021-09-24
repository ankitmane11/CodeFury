let input = document.querySelector('input');
let button = document.querySelector('button');

sendJson = (json) => {
    //1. Create Request
    xhr = new XMLHttpRequest();
    //2. Generate Request
    xhr.open('POST', "Servletlink?json=" + json, true);
    //3. Configure Request
    xhr.onreadystatechange = function () {
        //alert("ready state" + xhr.readyState);
        if ((xhr.readyState == 4) && (xhr.status == 200)) {
            document.getElementById("succ").innerHTML += xhr.responseText;
            return true;
        }

    }
    //4. Send Request
    xhr.send();
}

validateJson = (json) => {
    var err = 0;
    var letters = /^[A-Za-z]+$/;
    var mailformat = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
    const type = ["Developer", "Tester", "ProjectManager"]
    const jlist = [];
    for (j of json) {
        var arr = Object.keys(j)
        if (arr.length === 3) {
            if (("name" in j) && ("type" in j) && ("email" in j)) {
                if (j["name"].match(letters) && j["email"].match(mailformat) &&
                    ((j["type"].toLowerCase() === type[0].toLowerCase()) ||
                        (j["type"].toLowerCase() === type[1].toLowerCase()) ||
                        (j["type"].toLowerCase() === type[2].toLowerCase()))) {
                    jlist.push(j);
                }
                else {
                    err++;
                }
            }
            else {
                err++;
            }
        }
        else{
            err++;
        }
    }
    if (jlist.length === 0){
        document.getElementById("err").innerHTML = "All the entries in your file are not in proper format";
        return false;
    }
    else {
        if(err > 0)
            document.getElementById("succ").innerHTML = err+" entries did not match the format<br>"
        sendJson(jlist);
        return true;
    }
}

button.addEventListener('click', () => {
    document.getElementById("err").innerHTML = "";
    document.getElementById("succ").innerHTML = "";
    let files = input.files;

    if (files.length == 0) return;

    const file = files[0];
    //can be multiple files also so loading only first file

    let reader = new FileReader();//new file object
    var json;
    var jsonFlag = false;
    reader.onload = (e) => {
        let str = e.target.result;
        json = JSON.parse(str);
        console.log("String", str);
        if (typeof json == "object"){
            var vlflag = validateJson(json);
            if(vlflag){
                document.getElementById("succ").innerHTML += "<br>Click on register button to register a user or login button to login";
                document.getElementById("import").reset();
            }
        }
        else{
            document.getElementById("err").innerHTML = "The file is not in proper json format";
        }

    };

    reader.onerror = (e) => alert(e.target.error.name);//any issue with file error is displayed

    reader.readAsText(file);

});/**
 * 
 */
"use strict";


//Selectors//
    //DIVS//
    let resultsDiv = document.querySelector("#resultsDiv");
    let tableBody = document.querySelector("#tableBody");

    //INPUTS//

    let anameInput = document.querySelector("#anameInput");
    let snameInput = document.querySelector("#snameInput");
    let gInput = document.querySelector("#gInput");
    let rdInput = document.querySelector("#rdInput");
    let idInput = document.querySelector("#idInput");
   

    //BUTTONS//

    let createBtn = document.querySelector("#createBtn");
    let updateBtn = document.querySelector("#updateBtn");
    let deleteBtn = document.querySelector("#deleteBtn");
    
    //FUNCTIONS//
    let printresults = (result) =>{
        console.log(result);
        let tr = document.createElement('tr');
        let td1= document.createElement('td');
        let td2 = document.createElement('td');
        let td3 = document.createElement('td');
        let td4 = document.createElement('td');
        let td5 = document.createElement('td');
        let td6 = document.createElement('td');
        let td7 = document.createElement('td');

        tr.setAttribute("class", "table-success")
        td1.textContent = result.id;
        td2.textContent = result.artistName;
        td3.textContent = result.songName;
        td4.textContent = result.genre;
        td5.textContent = result.releaseDate;

        tr.append(td1,td2, td3, td4, td5, td6, td7);
        tableBody.appendChild(tr);
        
    }


//Get all
let getAll = () => {
    axios.get("http://localhost:8080/project/getAll")
    .then(res => {

        tableBody.innerHTML = "";

         let results = res.data;
        
         for (let result of results){
            printresults(result)
        }

    }).catch(err => console.log(err));
}

//Create

let create = () => {

    if(!validateInputs()){
        alert("Please complete all fields in form to send!");
        return;
    }

    let obj = {
        "artistName": anameInput.value,
        "songName": snameInput.value,
        "genre": gInput.value,
        "releaseDate": rdInput.value
        
    }

    axios.post("http://localhost:8080/project/create", obj)
    .then(res => {
        console.log(res.data);
        getAll();

    }).catch(err => console.log(err));

}

//update
let update = () => {

    let obj = {
        "artistName": anameInput.value,
        "songName": snameInput.value,
        "genre": gInput.value,
        "releaseDate": rdInput.value,
        // "id": idInput.value
        
    }

    axios.put("http://localhost:8080/project/update/"+ idInput.value, obj)
    .then(res => {
        console.log(res.data);
        getAll();
    }).catch(err => console.log(err));
}

//delete
let del = () => {
    

    axios.delete("http://localhost:8080/project/delete/" + idInput.value)
    .then(res => {
        console.log(res.data);
        getAll();
    }).catch(err => console.log(err));
}

let validateInputs = () => {
    if(anameInput.value === "" || snameInput.value === "" || gInput.value === "" || rdInput.value ==="") {
        return false;

    } else {
        return true;
    }
}

//EVENT LISTENERS//
createBtn.addEventListener("click", create);
updateBtn.addEventListener("click", update);
deleteBtn.addEventListener("click", del);


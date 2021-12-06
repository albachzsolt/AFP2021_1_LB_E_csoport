window.onload = function () {
    fetchUsers();
};

function fetchUsers() {
    fetch("/api/users")
        .then(function (response) {
            return response.json();
        })
        .then(function (jsonData) {
            showTable(jsonData);
        });
}

function showTable(jsonData) {
    let table = document.querySelector("#users-table");

    table.innerHTML = "";
    for (let i = 0; i < jsonData.length; i++) {
        let tr = document.createElement("tr");
        tr["raw-data"] = jsonData[i];

        let idTd = document.createElement("td");
        idTd.innerHTML = jsonData[i].id;
        let idTdId = "idTd" + i;
        idTd.setAttribute("id", idTdId);
        tr.appendChild(idTd);

        let firstNameTd = document.createElement("td");
        firstNameTd.innerHTML = jsonData[i].firstName;
        let firstNameTdId = "firstNameTd" + i;
        firstNameTd.setAttribute("id", firstNameTdId);
        tr.appendChild(firstNameTd);

        let lastNameTd = document.createElement("td");
        lastNameTd.innerHTML = jsonData[i].lastName;
        let lastNameTdId = "lastNameTd" + i;
        lastNameTd.setAttribute("id", lastNameTdId);
        tr.appendChild(lastNameTd);

        let usernameTd = document.createElement("td");
        usernameTd.innerHTML = jsonData[i].username;
        let usernameTdId = "usernameTd" + i;
        usernameTd.setAttribute("id", usernameTdId);
        tr.appendChild(usernameTd);

        let passwordTd = document.createElement("td");
        passwordTd.innerHTML = "********";
        let passwordTdId = "passwordTd" + i;
        passwordTd.setAttribute("id", passwordTdId);

        tr.appendChild(passwordTd);

        let roleTd = document.createElement("td");
        roleTd.innerHTML = jsonData[i].userRole;
        let roleTdId = "roleTd" + i;
        roleTd.setAttribute("id", roleTdId);
        tr.appendChild(roleTd);

        let editButtonTd = document.createElement("td");
        let editButton = document.createElement("button");
        let editButtonId = 'editbutton' + i;
        editButton.setAttribute('id', editButtonId);
        editButton.setAttribute('class', 'btn');
        editButton.setAttribute('onclick', `editTds(${i})`);
        editButton.innerHTML = `<i class="fas fa-edit"></i>Edit`;
        tr.appendChild(editButtonTd);
        editButtonTd.appendChild(editButton);

        let saveButton = document.createElement("button");
        let saveButtonId = 'savebutton' + i;
        saveButton.innerHTML = `<i class="fa fa-save"></i>Save `;
        saveButton.setAttribute('id', saveButtonId);
        saveButton.setAttribute('class', 'btn');
        saveButton.setAttribute('onclick', `saveTds(${i})`);
        saveButton.style.display = 'none';
        editButtonTd.appendChild(saveButton);

        let deleteButtonTd = document.createElement("td");
        let deleteButton = document.createElement("button");
        let deleteButtonId = 'deletebutton' + i;
        deleteButton.setAttribute('id', deleteButtonId);
        deleteButton.setAttribute('class', 'btn');
        deleteButton.setAttribute('onclick', `deleteUser(${i})`);
        deleteButton['raw-data'] = jsonData[i];

        deleteButton.innerHTML = `<i class="fas fa-trash-alt"></i>Delete`;

        deleteButtonTd.appendChild(deleteButton);
        tr.appendChild(deleteButtonTd);

        table.appendChild(tr);
    }
}

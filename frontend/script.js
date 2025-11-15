const API_URL = "http://localhost:9090/api/people";

// Load data when page opens
window.onload = function () {
    loadPeople();
};

// GET all people
function loadPeople() {
    fetch(API_URL)
        .then(res => res.json())
        .then(data => {
            let rows = "";
            data.forEach(p => {
                rows += `
                <tr>
                    <td>${p.id}</td>
                    <td>${p.name}</td>
                    <td>${p.email}</td>
                    <td>${p.role}</td>
                    <td>${p.salary}</td>
                    <td class="actions">
                        <button onclick="editPerson(${p.id}, '${p.name}', '${p.email}', '${p.role}', ${p.salary})">Edit</button>
                        <button onclick="deletePerson(${p.id})" style="background:red;">Delete</button>
                    </td>
                </tr>
                `;
            });
            document.querySelector("#peopleTable tbody").innerHTML = rows;
        })
        .catch(err => console.error("Error:", err));
}

// SAVE or UPDATE person
function savePerson() {
    let id = document.getElementById("personId").value;
    let person = {
        name: document.getElementById("name").value,
        email: document.getElementById("email").value,
        role: document.getElementById("role").value,
        salary: document.getElementById("salary").value
    };

    if (!person.name || !person.email || !person.role || !person.salary) {
        alert("All fields are required!");
        return;
    }

    let method = id ? "PUT" : "POST";
    let url = id ? `${API_URL}/${id}` : API_URL;

    fetch(url, {
        method: method,
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(person)
    })
        .then(res => res.json())
        .then(() => {
            alert(id ? "Person Updated!" : "Person Added!");
            clearForm();
            loadPeople();
        })
        .catch(err => console.error("Error:", err));
}

// FILL FORM FOR EDIT
function editPerson(id, name, email, role, salary) {
    document.getElementById("personId").value = id;
    document.getElementById("name").value = name;
    document.getElementById("email").value = email;
    document.getElementById("role").value = role;
    document.getElementById("salary").value = salary;
}

// DELETE PERSON
function deletePerson(id) {
    if (!confirm("Are you sure?")) return;

    fetch(`${API_URL}/${id}`, { method: "DELETE" })
        .then(() => {
            alert("Person Deleted!");
            loadPeople();
        })
        .catch(err => console.error("Error:", err));
}

// CLEAR FORM
function clearForm() {
    document.getElementById("personId").value = "";
    document.getElementById("name").value = "";
    document.getElementById("email").value = "";
    document.getElementById("role").value = "";
    document.getElementById("salary").value = "";
}

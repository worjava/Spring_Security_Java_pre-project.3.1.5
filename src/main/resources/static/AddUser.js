const form = document.forms["formNewUser"];
form.addEventListener('submit', addNewUser);

loadRoles().catch(err => console.error(err))

async function loadRoles() {
    await fetch("api/admin/roles")
        .then(res => res.json())
        .then(roles => {
            roles.forEach(role => {
                let el = document.createElement("option");
                el.text = role.name.substring(5);
                el.value = role.id;
                $('#newUserRoles')[0].appendChild(el);
            });
        });
}

async function addNewUser(e) {
    e.preventDefault();

    const form = document.forms["formNewUser"];
    let newUserRoles = [];
    for (let i = 0; i < form.roles.options.length; i++) {
        if (form.roles.options[i].selected) {
            newUserRoles.push({
                id: form.roles.options[i].value,
                name: form.roles.options[i].text
            });
        }
    }

    const requestBody = {
        firstname: form.firstname.value,
        lastname: form.lastname.value,
        age: form.age.value,
        email: form.email.value,
        password: form.password.value,
        roles: newUserRoles
    };

    const response = await fetch("api/admin/add", {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(requestBody)
    });

    if (response.ok) {
        form.reset();
        allUsers()
        $('#allUsersTable').click(); // Переход на вкладку "Users table"
    } else {
        const errorResponse = await response.json();
        console.error('Error adding new user:', errorResponse);
        // Handle the error response
    }
}

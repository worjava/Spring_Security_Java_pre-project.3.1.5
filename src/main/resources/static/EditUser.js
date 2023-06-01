let formEdit = document.forms["formEditUser"];
editUser();

function editUser() {
    formEdit.addEventListener("submit", ev => {
        ev.preventDefault();
        let roles = [];
        for (let i = 0; i < formEdit.roles.options.length; i++) {
            if (formEdit.roles.options[i].selected) roles.push({
                id: formEdit.roles.options[i].value,
                role: "ROLE_" + formEdit.roles.options[i].text
            });
        }
        fetch("api/admin/user/" + formEdit.id.value, {
            method: 'PUT',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({
                id: formEdit.id.value,
                firstname: formEdit.firstname.value,
                lastname: formEdit.lastname.value,
                age: formEdit.age.value,
                email: formEdit.username.value,
                password: formEdit.password.value,
                roles: roles
            })
        }).then(() => {
            $('#editFormCloseButton').click();
          allUsers()
        });

    });
}

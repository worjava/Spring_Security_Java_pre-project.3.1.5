function thisUser() {
    fetch("api/user")
        .then(res => res.json())
        .then(data => {
            // Добавляем информацию в шапку
            document.getElementById('headerUsername').innerText = data.username
            let roles = data.roles.map(role => " " + role.name.substring(5));
            // $('#headerRoles').append(roles);
              document.getElementById('headerRoles').innerText = roles
            //Добавляем информацию в таблицу
            let user = `$(
            <tr>
                <td>${data.id}</td>
                <td>${data.firstname}</td>
                <td>${data.lastname}</td>
                <td>${data.age}</td>
                <td>${data.username}</td>
                <td>${roles}</td>)`;
            $('#userPanelBody').append(user);
        })
}

thisUser()


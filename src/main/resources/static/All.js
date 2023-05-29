function authAdmin() {
    fetch("api/user")
        .then(res => res.json())
        .then(data => {
            // Добавляем информацию в шапку
            document.getElementById('headerUsername').innerText = data.username
            let roles = data.roles.map(role => " " + role.name.substring(5));
            // $('#headerRoles').append(roles);
            document.getElementById('headerRoles').innerText = roles
            //Добавляем информацию в таблицу
        })
}

authAdmin()

function allUsers() {
    document.getElementById('tbodyAllUserTable').innerHTML=``;
    fetch("api/admin/all")
        .then(res => res.json())
        .then(data => {
            let tableWithUsers = ``
            data.forEach(user => {
                 tableWithUsers += `
                        <tr>
                            <td>${user.id}</td>
                            <td>${user.firstname}</td>
                            <td>${user.lastname}</td>   
                            <td>${user.age}</td>                      
                            <td>${user.username}</td>
                            <td>${user.roles.map(role => " " + role.name.substring(5))}</td>
                            <td>
                                <button type="button" class="btn btn-info" data-toggle="modal" id="buttonEdit"
                                data-action="edit" data-id="${user.id}" data-target="#edit">Edit</button>
                            </td>
                            <td>
                                <button type="button" class="btn btn-danger" data-toggle="modal" id="buttonDelete"
                                data-action="delete" data-id="${user.id}" data-target="#delete">Delete</button>
                            </td>
                        </tr>`;

            })
            $('#tbodyAllUserTable').append(tableWithUsers)
        })
}
allUsers()

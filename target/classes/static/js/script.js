async function validateForm(){
    nome = document.getElementById('nome')
    user = document.getElementById('user')
    email = document.getElementById('email')
    senha = document.getElementById('senha')
    telefone = document.getElementById('telefone')

    /* Valida campo nome*/
    error_nome = document.querySelector('.msg-nome');
    if(nome.value == ""){
        error_nome.innerHTML = "Favor preencher o nome completo"
        error_nome.style.display = "block"
    }else{
        error_nome.style.display = "none"
    }

    /* Valida campo user*/
    error_user = document.querySelector('.msg-user');
    if(user.value == ""){
        error_user.innerHTML = "Favor preencher com o nome de usuário"
        error_user.style.display = "block"
    }else{
        error_user.style.display = "none"
        url = `http://localhost:8080/usuario/find/${user.value}`
        console.log(url)
        let response = await fetch(url)
        if(response.ok){
            let json = await response.json();
            if(json == true){
                error_user.innerHTML = "Usuário já cadastrado, crie um novo nome de usuário"
                error_user.style.display = "block"
                user.value = ''
                user.focus()
            }
        }
    }

    /* Valida campo email*/
    error_email = document.querySelector('.msg-email');
    if(email.value == ""){
        error_email.innerHTML = "Favor preencher com o endereço de e-mail"
        error_email.style.display = "block"
    }else{
        error_email.style.display = "none"
        url = `http://localhost:8080/usuario/find/${email.value}`
        console.log(url)
        let response = await fetch(url)
        if(response.ok){
            let json = await response.json();
            if(json == true){
                error_email.innerHTML = "E-mail já cadastrado, entre com um novo endereço de e-mail"
                error_email.style.display = "block"
                email.value = ''
                email.focus()
            }
        }
    }

    /* Valida campo senha*/
    error_senha = document.querySelector('.msg-senha');
    if(senha.value == ""){
        error_senha.innerHTML = "Favor preencher o com uma senha"
        error_senha.style.display = "block"
    }else{
        error_senha.style.display = "none"
    }

    /* Valida campo telefone*/
    error_telefone = document.querySelector('.msg-telefone');
    if(telefone.value == ""){
        error_telefone.innerHTML = "Favor preencher o telefone"
        error_telefone.style.display = "block"
    }else{
        error_telefone.style.display = "none"
    }
}

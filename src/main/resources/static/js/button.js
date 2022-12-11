var clickStatus = 0;

// Verifica se o botão já foi clicado

const statusVerification = () =>{

    (clickStatus == 0 ? showPostOptions() : closePostOptions());
}

const showPostOptions = () => {
    document.getElementById("postOptions").classList.remove("hidden");
    clickStatus++;
  };
  
  const closePostOptions = () => {
    document.getElementById("postOptions").classList.add("hidden");
    clickStatus--;
  };
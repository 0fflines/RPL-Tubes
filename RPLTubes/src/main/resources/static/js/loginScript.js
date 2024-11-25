document.addEventListener("DOMContentLoaded", () =>{
    const loginButton = document.querySelector(".login-button");
    
    loginButton.addEventListener("click", (event) =>{
        const uEmailInput = document.getElementById("email");
        const uEmailInputValue = uEmailInput.value;
        const uPasswordInput = document.getElementById("password");
        const uPasswordInputValue = uPasswordInput.value;

        //tambahin if buat cek email sama pass bener
        window.location.href = "/home.html";
    })
})
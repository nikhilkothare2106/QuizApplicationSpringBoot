let user = null;
let email = null;

function startQuiz(quizType){
    if(user && email){
        localStorage.setItem("topic",quizType)
        window.location.href = `quiz.html?user=${user}&email=${email}`;
    }
    else{
        alert("Login first!");
        window.location.href = "login.html";
    }
}

document.addEventListener("DOMContentLoaded", () =>{
    user = new URLSearchParams(window.location.search).get("user");
    email = new URLSearchParams(window.location.search).get("email");
   
    if(user && email){
        let loginDiv = document.querySelector(".login");
        loginDiv.style.display = "none";
        let profile = document.querySelector(".profile a");
        profile.style.display = "block";
        profile.textContent = user;
     }
})

let profileDiv = document.querySelector(".profile a");
profileDiv.addEventListener("click", function() {
    let signDiv = document.querySelector(".sign")
    signDiv.classList.toggle("signinout")
})

document.querySelector(".sign").addEventListener("click", function() {
    window.location.href = "main.html";
})
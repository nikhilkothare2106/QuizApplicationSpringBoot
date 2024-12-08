
let profileDiv = document.querySelector(".profile a");
profileDiv.addEventListener("click", function() {
    let signDiv = document.querySelector(".sign")
    signDiv.classList.toggle("signinout")
})

document.querySelector(".sign").addEventListener("click", function() {
    window.location.href = "/main";
})
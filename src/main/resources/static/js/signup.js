document.addEventListener("DOMContentLoaded", () =>{
    let error = new URLSearchParams(window.location.search).get("error");

    if(error){
        let errorDiv = document.querySelector(".errorMessage");
        errorDiv.textContent = error;
        errorDiv.style.display = "block";
    }
})
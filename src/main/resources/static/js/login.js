document.addEventListener("DOMContentLoaded", () =>{
    let success = new URLSearchParams(window.location.search).get("success");

    if(success){
        alert(success);
    }
})

document.getElementById("loginForm").addEventListener("submit",
    async function(event) {
        event.preventDefault();

        let email = document.getElementById("email").value;
        let password = document.getElementById("pwd").value;

        try{
           let response = await fetch(`https://quizapplicationspringboot-production-e821.up.railway.app/login?email=${email}&password=${password}`, {
            method: "POST"
           });

           if(!response.ok){
            throw new Error("Error occurred");
           }

           let data = await response.json();

           console.log(data[1])
           let user = data[1];
          
           window.location.href = `main.html?user=${user}&email=${email}`;
        }
        catch(error){
            alert("Somenting went wrong, try again!")
        }
    }
)
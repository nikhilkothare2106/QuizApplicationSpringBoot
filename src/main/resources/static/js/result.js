let user = null;
let email = null;


function displayScore(){
    const quizScore = localStorage.getItem('quizScore'); 
    const totalQuestions = localStorage.getItem('totalQuestions'); 
    let scoreText = document.querySelector(".score");
    scoreText.innerHTML = `You Scored ${quizScore} out of ${totalQuestions}`;

    let feedback = document.querySelector(".feedback");
    let percentage = (quizScore / totalQuestions) / 100;
    if (percentage >= 80) {
        feedback.innerText = 'Excellent work! Keep it up!';
    } else if (percentage >= 50) {
        feedback.innerText = 'Good job! You can do even better!';
    } else {
        feedback.innerText = "Don't give up! Try again!";
    }
}

document.querySelector(".btn").onclick = () => {
    window.location.href = `main.html?user=${user}&email=${email}`;
}
window.onload = displayScore

document.addEventListener("DOMContentLoaded", () =>{
    user = new URLSearchParams(window.location.search).get("user");
    email = new URLSearchParams(window.location.search).get("email");
   
})
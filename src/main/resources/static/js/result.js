
function displayScore(){
    const quizScore = document.querySelector('.quizScore').textContent; 
    const totalQuestions = document.querySelector('.totalQuestions').textContent; 
    let feedback = document.querySelector(".feedback");
    let percentage = (quizScore / totalQuestions) * 100;
    if (percentage >= 80) {
        feedback.innerText = 'Excellent work! Keep it up!';
    } else if (percentage >= 50) {
        feedback.innerText = 'Good job! You can do even better!';
    } else {
        feedback.innerText = "Don't give up! Try again!";
    }
}

document.querySelector(".btn").onclick = () => {
    window.location.href = `/main`;
}
window.onload = displayScore

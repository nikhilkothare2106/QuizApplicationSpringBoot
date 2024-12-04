let index = 0;
let questions = []
let totalQuestions = 0
let correctAnswer = 0;
let nextbtn = document.getElementById("next-button");
let topic = localStorage.getItem("topic")
let selectedOption = null;

let user = null;
let email = null;


console.log(topic)
async function fetchQuestion(){
    try{
       const response = await fetch(`https://192.168.149.89:8443/quiz/get-questions?topic=${topic}`);

       if(!response.ok){
        throw new Error("Can't connect to serber");
       }
       
       questions = await response.json();
       totalQuestions = questions.length
       document.getElementById("total-questions").textContent = totalQuestions
       displayQuestion();
       
    }
    catch{
        let questionText = document.getElementById("question-text")
        questionText.textContent = "Failed to fetch Questions!";
    }
}

function displayQuestion(){
    if(index == questions.length){
        return
    }
    let currentQuestion = questions[index]
    let questionText = document.getElementById("question-text")
    questionText.textContent = currentQuestion.questionText


    nextbtn.disabled = true;
    document.getElementById("current-question").textContent = index+1;
    let optionsContainer = document.getElementById("options-container")

    optionsContainer.innerHTML = '';
    let options = currentQuestion.options;
    options.forEach(option =>{
        let optionBtn = document.createElement("button");
        optionBtn.classList.add("option")
        optionBtn.textContent = option;
        optionsContainer.appendChild(optionBtn)

        optionBtn.addEventListener("click",function(){
            let btns = optionsContainer.querySelectorAll("button");
            btns.forEach(btn =>{
                btn.style.backgroundColor="#ffffff";
            })
            optionBtn.style.backgroundColor = "rgb(240,248,112";
            selectedOption = optionBtn
            nextbtn.disabled = false;
            nextbtn.style.cursor = "pointer";
        })
    })
}

function checkAnswer(selectedOption){
    let currentQuestion = questions[index];
    if(selectedOption === currentQuestion.correctAnswer){
        correctAnswer++;
    }else{
        console.log(selectedOption)
    }
}

nextbtn.onclick = () =>{
    checkAnswer(selectedOption.textContent)
    if(index < questions.length - 1){
        index++;
        displayQuestion();
    }
    else{
        localStorage.setItem('quizScore', correctAnswer); 
        localStorage.setItem('totalQuestions', totalQuestions); 
        
        if(user && email){
            window.location.href = `result.html?user=${user}&email=${email}`; 
        }
    }
}
window.onload = fetchQuestion


document.addEventListener("DOMContentLoaded", () =>{
    user = new URLSearchParams(window.location.search).get("user");
    email = new URLSearchParams(window.location.search).get("email");
   
})

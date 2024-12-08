let index = 0;
let questions = []
let totalQuestions = 0
let correctAnswer = 0;
let nextbtn = document.getElementById("next-button");
let topic = document.querySelector(".quiz-container h1").textContent;
let selectedOption = null;


async function fetchQuestion(){
    try{
    const response = await fetch(`/get-questions?topic=${topic}`);

       if(!response.ok){
        throw new Error("Can't connect to server");
       }
       
       questions = await response.json();
       totalQuestions = questions.length
       document.getElementById("total-questions").textContent = totalQuestions;
       displayQuestion();
       
    }
    catch{
        let questionText = document.getElementById("question-text")
        questionText.textContent = "Failed to fetch Questions!";
    }
}

window.onload = fetchQuestion;
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
        window.location.href = `/result?quizScore=${correctAnswer}&totalQuestions=${totalQuestions}`; 
        
    }
}
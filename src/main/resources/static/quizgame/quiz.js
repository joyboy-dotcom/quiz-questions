let questions = [];
let currentQuestionIndex = 0;
let score = 0;
let timerInterval;
const timerDuration = 45;
let timeLeft = timerDuration;

// DOM Elements
const questionContainer = document.getElementById("question-container");
const optionsContainer = document.getElementById("options");
const questionText = document.getElementById("question");
const nextButton = document.getElementById("next-question");
const scoreContainer = document.getElementById("score-container");
const finalScoreText = document.getElementById("final-score");
const timerDisplay = document.getElementById("timer");

// Fetch Questions from Backend
async function fetchQuestions() {
    try {
        const response = await fetch("https://sea2.ragic.com/quizgame/questions/1");
        if (!response.ok) {
            throw new Error(`Error: ${response.status} ${response.statusText}`);
        }
        const data = await response.json();
        questions = data;
        showNextQuestion();
    } catch (error) {
        console.error("Error fetching questions:", error);
        alert("Failed to load questions. Please try again later.");
    }
}

// Start Quiz
window.addEventListener("load", () => {
    questionContainer.classList.remove("hidden");
    timerDisplay.textContent = `Time Left: ${timerDuration}s`;
    fetchQuestions();
});

// Show Next Question
function showNextQuestion() {
    if (currentQuestionIndex >= questions.length) {
        showScore();
        return;
    }

    resetTimer();
    startTimer();

    const currentQuestion = questions[currentQuestionIndex];
    questionText.textContent = currentQuestion.questionText;

    optionsContainer.innerHTML = "";
    const options = [
        currentQuestion.optionA,
        currentQuestion.optionB,
        currentQuestion.optionC,
        currentQuestion.optionD,
    ];

    options.forEach((option, index) => {
        const button = document.createElement("button");
        button.textContent = option;
        button.classList.add("option-button");
        button.addEventListener("click", () => selectOption(button, option, currentQuestion.correctAnswer));
        optionsContainer.appendChild(button);
    });

    nextButton.classList.add("hidden");
}

function selectOption(button, selectedOption, correctAnswer) {
    const allButtons = document.querySelectorAll(".option-button");
    allButtons.forEach((btn) => btn.classList.remove("selected"));
    button.classList.add("selected");

    clearInterval(timerInterval);

    if (selectedOption === correctAnswer) {
        score++;
    }

    nextButton.classList.remove("hidden");
}

nextButton.addEventListener("click", () => {
    currentQuestionIndex++;
    showNextQuestion();
});

function showScore() {
    questionContainer.classList.add("hidden");
    scoreContainer.classList.remove("hidden");
    timerDisplay.style.display = "none";
    finalScoreText.textContent = `You scored ${score} out of ${questions.length}`;
}

function startTimer() {
    timeLeft = timerDuration;
    timerDisplay.textContent = `Time Left: ${timeLeft}s`;

    timerInterval = setInterval(() => {
        timeLeft--;
        timerDisplay.textContent = `Time Left: ${timeLeft}s`;

        if (timeLeft <= 0) {
            clearInterval(timerInterval);
            alert("Time's up!");
            currentQuestionIndex++;
            showNextQuestion();
        }
    }, 1000);
}

function resetTimer() {
    clearInterval(timerInterval);
    timerDisplay.textContent = `Time Left: ${timerDuration}s`;
}

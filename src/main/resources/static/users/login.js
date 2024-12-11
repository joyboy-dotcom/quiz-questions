document.getElementById('loginForm').addEventListener('submit', async function(event) {
    event.preventDefault();

    const username = document.getElementById('loginUsername').value;
    const password = document.getElementById('loginPassword').value;

    try {
        const response = await fetch(`http://localhost:8082/user/login/nameandpassword?username=${username}&password=${password}`);
        const result = await response.json();

        if (result.length > 0) {
            window.location.href="http://localhost:8082/quizgame/index.html";
        } else {
            alert("Invalid username or password.");
        }
    } catch (error) {
        console.error("Error logging in:", error);
    }
});

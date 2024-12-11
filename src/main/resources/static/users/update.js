document.getElementById('forgotPasswordForm').addEventListener('submit', async function(event) {
    event.preventDefault();

    const username = document.getElementById('forgotUsername').value;
    const email = document.getElementById('forgotEmail').value;

    const userDetails = { username, email };

    try {
        const response = await fetch("http://localhost:8082/user/update", {
            method: "POST",
            headers: {
                "Content-Type": "application/json",
            },
            body: JSON.stringify(userDetails),
        });

        const result = await response.json();
        alert("Password reset instructions sent to your email.");
    } catch (error) {
        console.error("Error resetting password:", error);
    }
});

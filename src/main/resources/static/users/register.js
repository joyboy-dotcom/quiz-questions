document.getElementById('registerForm').addEventListener('summit', async function(event) {
    event.preventDefault();

    const name = document.getElementById('name'); 
    const email = document.getElementById('email');
    const password = document.getElementById('password');

    const user = { username, email, password };

    try {
        const response = await fetch("http://localhost:8082/user/register", {
            method: "POST",
            headers: {
                "Content-Type": "application/json", 
            },
            body: JSON.stringify(user) 
        });

        if (response.ok) {
            const result = await response.json();
            console.log("Registration successful:", result);
            window.location.href = './users/index.html';
        } else {
            const errorMessage = await response.text();
            console.error("Error response from server:", errorMessage);
            alert("Registration failed: " + errorMessage);
        }
    } catch (error) {
        console.error("Error registering user:", error);
        alert("An unexpected error occurred. Please try again later.");
    }
});

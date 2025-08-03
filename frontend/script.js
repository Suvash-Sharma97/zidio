document.addEventListener("DOMContentLoaded", () => {
  const loginForm = document.getElementById("login-form");
  const profileSection = document.getElementById("profile-section");
  const loginSection = document.getElementById("login-section");
  const profileForm = document.getElementById("profile-form");

  let loggedInStudentId = null; // to track user for updates

  // 🔐 LOGIN
  loginForm.addEventListener("submit", async (e) => {
    e.preventDefault();

    const email = document.getElementById("email").value.trim();
    const password = document.getElementById("password").value.trim();

    try {
      const res = await fetch("http://localhost:8080/api/students/login", {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify({ email, password }),
      });

      if (!res.ok) throw new Error("Invalid credentials");

      const student = await res.json();
      loggedInStudentId = student.id;

      alert("Login successful!");

      loginSection.classList.add("hidden");
      profileSection.classList.remove("hidden");

      // Optional: pre-fill profile info if returned from backend
      document.getElementById("fullName").value = student.fullName || "";
      document.getElementById("contact").value = student.contact || "";
      document.getElementById("about").value = student.about || "";
    } catch (err) {
      alert(err.message);
    }
  });

  // 📄 PROFILE SUBMIT
  profileForm.addEventListener("submit", async (e) => {
    e.preventDefault();

    const fullName = document.getElementById("fullName").value;
    const contact = document.getElementById("contact").value;
    const resume = document.getElementById("resume").files[0];
    const about = document.getElementById("about").value;

    if (!fullName || !contact || !resume) {
      alert("Please fill in all required fields and upload your resume.");
      return;
    }

    try {
      // Step 1: Upload resume (if you have a file upload API)
      // Optional: Use FormData and POST to /api/students/{id}/upload-resume

      // Step 2: Send profile update
      const res = await fetch(`http://localhost:8080/api/students/${loggedInStudentId}`, {
        method: "PUT",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify({
          fullName,
          contact,
          about,
          resumePath: resume.name // simulate, or replace with uploaded URL
        }),
      });

      if (!res.ok) throw new Error("Failed to update profile");

      alert("Profile saved successfully!");
    } catch (err) {
      alert(err.message);
    }
  });
});

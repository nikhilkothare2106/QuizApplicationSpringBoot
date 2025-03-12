let profileDiv = document.querySelector(".profile a");
if (profileDiv) {
  profileDiv.addEventListener("click", function () {
    let signDiv = document.querySelector(".sign");
    if (signDiv) {
      signDiv.classList.toggle("signinout");
    }
  });
}

let signElement = document.querySelector(".sign");
if (signElement) {
  signElement.addEventListener("click", function () {
    removeUser();
    window.location.href = "/main";
  });
}

// LocalStorage functions
function getUser() {
  return localStorage.getItem("user");
}

function setUser(user) {
  localStorage.setItem("user", user);
}

function removeUser() {
  localStorage.removeItem("user");
}

// Handling user information
let usernameElement = document.querySelector(".demo");
let name1 = document.querySelector(".profile a");

if (usernameElement && name1) {
  let username = usernameElement.textContent.trim();
  if (username) {
    console.log("username:", username);
    setUser(username);
    name1.textContent = username;
  }
}

// Set username from localStorage if available
if (getUser() && name1) {
  console.log(getUser());
  name1.textContent = getUser();
}

// Hide login div if user exists
let loginDiv = document.querySelector(".login");
if (getUser() && loginDiv && name1) {
  loginDiv.style.display = "none";
  name1.style.display = "block";
}

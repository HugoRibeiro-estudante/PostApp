var clickStatus = 0;

// Verifica se o botão já foi clicado

const statusVerification = () => {
  clickStatus == 0 ? showPostOptions() : closePostOptions();
};

const add = (x) => {
  var text = document.getElementById("text");

  text.innerHTML += "<b>";
};

const showPostOptions = () => {
  document.getElementById("postOptions").classList.remove("hidden");
  clickStatus++;
};

const closePostOptions = () => {
  document.getElementById("postOptions").classList.add("hidden");
  clickStatus--;
};

const bold = () => {
  const span = document.createElement("span");
  const textarea = document.getElementById("elem");
  console.log(textarea);
  textarea.appendChild(span);
  span.classList.toggle("bold");
};

let editableDiv = document.createElement("div");
// Adding text to that created element
let value = localStorage.getItem("text");
let text;

if (value == null) {
  text = document.createTextNode("Click on it to edit this Editable Div");
} else {
  text = document.createTextNode(value);
}
editableDiv.appendChild(text);
editableDiv.setAttribute("id", "elem");
editableDiv.setAttribute("class", "elem");
editableDiv.setAttribute("contentEditable", "true");
editableDiv.setAttribute(
  "style",
  "font-size:3rem;border:3px solid;width:100%;height:800px;"
);

// Access the main divTxtarea

let divTxtarea = document.querySelector(".divTxtarea");

// Inserting the element with id = first

divTxtarea.insertBefore(editableDiv, first);

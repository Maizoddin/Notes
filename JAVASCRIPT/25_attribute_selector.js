// getAttribute
// Gives the attribute value
let div = document.querySelector("div");
let className = div.getAttribute("class");

// setAttribute
// Set's the attribute value
div.setAttribute("id","myId");

Example :
let num = Math.floor(Math.random()*(6-1+1))+1;
let imgSrc = "images/pic" + num + ".png";
document.querySelector("img").setAttribute("src",imgSrc);
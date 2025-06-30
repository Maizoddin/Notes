// Child Selectors

console.log(document.body.firstElementChild);    // Selects the first child

console.log(document.body.lastElementChild);     //Selects the last child

console.log(document.body.children);             //It gives all childElements
// To convert it into array use : let arr = Array.from() 

// --------------------------------------------------------------------------

document.getElementById("myId").innerText = "Hey"

document.getElementsByClassName("myClass")[1].style.color = "red"

document.getElementsByTagName("li")[2].style.listStyleType = "none"

// --------------------------------------------------------------------------

// querySelector
// Here we can use className, idName, TagName

document.querySelector("li a").style.textDecoration = "none"
// It selects only first element

document.querySelectorAll(".c")[1].style.backgroundColor = "red"
// It selects all the elements

Example :
document.querySelectorAll(".c,#i1")[0].style.color = "pink"


// -------------------------------------------------------------------------------

// Removing any targeted element
element_name.remove()
Example : document.querySelector(".cls").remove()

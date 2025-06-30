// Window is a Global Object

//--------------------------------------------------------------------------------------------

// BOM : Browser Object Model
// It provides some additional features provided by host browser
 
// alert
alert("Hey Welcome to Age Alert PopUp!!")

// prompt
let age = prompt("Enter Your Age : ")

// confirm
let res = confirm("Do You want to display your Age: ")

// document.write
if (res == true){
  document.write(`Your Age is : ${age}`)
}
else{
  document.write("Your Age is : NA")
}

// location.href
location.href = "https://www.google.com";

//--------------------------------------------------------------------------------------------

// DOM : Document Object Model
document.body.style.backgroundColor = "red";


// if else
/*
let num = 8;
if (num % 2 == 0 && num % 3 == 0) {
  console.log("Divisible by 2 and 3");
} 
else if (num % 2 == 0) {
  console.log("Divisible by 2");
} 
else if (num % 3 == 0) {
  console.log("Divisible by 3");
} 
else {
  console.log("Number is neither Divisible by 2 nor 3");
}
*/


// Switch Statement
// Example 1
/*
let language = "JavaScr2ipt";
switch (language) {
  case "Python":
    console.log("Search for Data Scientist Jobs");
    break;
  case "Js":
  case "JavaScript":
    console.log("Search for Web Development Jobs");
    break;
  case "Java":
    console.log("Search for Android developer Jobs");
    break;
  default:
    console.log("Try something Different!!");
    break;
}
*/

// Example 2
let day = "monday";
switch(day){
     
  case "monday":
       console.log("Lazy Day");
       break;
  case "wednesday":
  case "thursday":
       console.log("Normal Day");
       break;
  case "friday":{
      console.log("Work");
      console.log("Pay");
      break;
      }
  default :
      console.log("Not Found");
      break;
}

// Ternary Operator
/*
let age = 30;
let message = age > 20 ? "You Can Drive" : "You Can't Drive";
console.log(message);   
// You Can Drive
*/
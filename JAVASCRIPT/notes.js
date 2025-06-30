
// We can call function with any of the references 
let var1 = var2 = actualFun = (age) => {return `Your Age is : ${age}`}
console.log(var1(age));
console.log(var2(age));
console.log(actualFun(age));
// Here we can call function with any name (var1, var2, actualFun)

// print
console.log(`Name : ${name}`);

// print without New Line
process.stdout.write("Hello");


// Important
console.log(Boolean("")); // false
console.log(Boolean([])); //true
console.log(Boolean({}));  //true


// Important Memory Concepts

// Stack 
// Premitive DataTypes (Number, String, Boolean, Null, Undefined)  
// in premitive datatypes copy of variables value will be assigned
// Example:
let num1 = 100;
let num2 = num1;
// Here copy is assigned so any changes in num2 will not affect num1

// Heap
// Non-Premitive DataTypes (Array, Object, Function)
// in non-premitive datatypes refrence is assigned, so changes will affect to original copy
let arr1 = [1,2,3];
let arr2 = arr1;
arr2.push(4);
console.log(arr1); // arr1 = [1,2,3,4]


// All the Css properties are written in camelCase in JS 
// All the Css properties are written in double quotes as a string
Example :
document.querySelector("body").style.backgroundImage = "url('../material/images/hungry.jpg')"


// self executing anonymous functions
(function(){
    console.log("Hello World");
  }) ()
  
  
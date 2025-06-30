// One object borrows the methode from another object
// Methodes : bind(), call(), apply()

// bind()

Example :
let person1 = {
   name : "Maaz",
   age : 22,
   getInfo : function(){
       console.log(`Your name is : ${this.name}\n Your age is : ${this.age}`);
   }
}

let person2 = {
    name : "John",
    age : 25
}

let temp = person1.getInfo.bind(person2)
temp()

// it return the new function
// here it created the new function temp wich has the access to person2 object's context
// So whatever we pass as the first argument in the bracket that will refer to this

Example :
let obj = {
  name : "Maaz",
  age : 22,
  getDetails : function(){
      console.log(this.name," ",this.age);
  } 
}
let newFunction = obj.getDetails.bind(obj);
newFunction();

Example :
let newObj = {
  name : "Maaz",
}

function greet(){
  console.log(`Hey ${this.name}`);
}

let newFun = greet.bind(newObj);
newFun()

// Note here we can pass parameters also
/* 
let person1 = {
  name : "Maaz",
  age : 22,
  getInfo : function(message){
      console.log(`Your name is : ${this.name} \nYour age is : ${this.age}  \nMessage is : ${message}`);
  }
}

let person2 = {
   name : "John",
   age : 25
}

let person2greet = person1.getInfo.bind(person2,"Done");
person2greet() */

// ---------------------------------------------------------------------------------------

// call()
// It does not returns the new function rather it directly executes the function immediately

/* Example 2:
let person1 = {
   name : "Maaz",
   age : 22,
   getInfo : function(){
       console.log(`Your name is : ${this.name}\n Your age is : ${this.age}`);
   }
}

let person2 = {
    name : "John",
    age : 25
}

person1.getInfo.call(person2); */

// ------------------------------------------------------------------------------------

// apply()
// It is also same as call()  but here arguments will be passed in the array

// Example :
/*
let person1 = {
  name : "Maaz",
  age : 22,
  getInfo : function(message){
      console.log(`Your name is : ${this.name} \nYour age is : ${this.age}  \nMessage is : ${message}`);
  }
}

let person2 = {
   name : "John",
   age : 25
}

person1.getInfo.apply(person2,["Done!!"]) */

Note :
// It is used to add new functions to Constructor function
// It works only with constructor function

Example:
function User(name,age){
  this.name = name;
  this.age = age;
  this.info = function(){
       console.log(`My Name is : ${this.name}\nMy Age is : ${this.age}`)
  }
}

// Adding new function to constructor function
User.prototype.getFirstName = function(){
  console.log(`Your first name is : ${this.name}`)
}

let user1 = new User("Maaz",22);

user1.getFirstName();
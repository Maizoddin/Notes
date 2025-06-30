// Clousure   
// A closure is the combination of a function and the lexical environment within which that function was declared
// OR
// A closure is an inner function that has access to the outer (enclosing) function's variables

Example :
function greet(){
   let name = "John";
   function sayHello(){
     console.log(`Good Morning ${name}`);
   }
   return sayHello;
}

let fun = greet();
fun();


================================

function outer(){
    let count = 0
    return function inner(){
        count ++
        return count
    }
}

const x = outer()
console.log(x())
console.log(x())
console.log(x())

Output : 1 2 3

// Currying
// Currying in JavaScript transforms a function with multiple arguments into a nested series of functions, each taking a single argument.

Example :
function firstNum(x){
  return function secondNum(y){
    return x+y;
  }
}

let additionFirst = firstNum(4);
let additionSecond = additionFirst(5);
console.log(additionSecond);

// OR

let answer = firstNum(6)(55)
console.log(answer)

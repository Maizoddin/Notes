// Normal 
function add(num1, num2) {
    return num1 + num2;
}
console.log(add(2, 2));

// ----------------------------------------------------------------------------------

// Function Expression
let sub = function (num1, num2) {
    return num1 - num2;
}
console.log(sub(2, 2));

// ----------------------------------------------------------------------------------

// Arrow function
let mul = (num1, num2) => { return num1 * num2 }
console.log(mul(2, 2));

// In Arrow functions if we use {} then return keyword is must
let sum = (num1,num2) => { return num1+num2 }
console.log(sum(2, 2));

// If we don't use {} then return keyword is not necessary.
let division1 = (num1,num2) => num1/num2
// OR
let division2 = (num1, num2) => (num1/num2)

// ----------------------------------------------------------------------------------

// Anonymous Functions : functions without name
nums = [22,33,44]

nums.forEach((num) => {console.log(num*num);})
// OR
nums.forEach(function(num) {console.log(num*2);})
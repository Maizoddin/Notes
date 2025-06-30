// rest operator
/* 
function add(...args){      
  let sum = 0;
  for (let arg of args){
    sum += arg
  }
  return sum
}

console.log(add(2,3,4,5,6)) */

// --------------------------------------------------

// spread operator
/* 
function addTwoValues(a,b){
  return a+b;
}

let nums = [2,4];
let sum = addTwoValues(...nums);     
console.log(sum); */


// --------------------------------------
// Example :
function fun(a,b,...args){
    let multiply = a*b;
    let sum = 0;
    for (let num of args){
      sum += num
    }
  return [multiply, sum];
}

let [multiply, sum] = fun(2,4,5,6,8,1);
console.log(`Multiply : ${multiply}  and Sum : ${sum}`);


// Example 
function fun(...args){
  let sum = 0;
  args.forEach((num) => {sum += num})
  return sum
}

let arr = [1,2,3]
let res = fun(...arr)
console.log(res)
// Important : We can use this function's only on Arrays
let nums = [12,11,14,16,17,19]

// fill()
nums.fill(null, 1,5)
// fill(val, startIdx, endIdx) 
// It modifies the original array
// [12,null,null,null,null,19]

// ----------------------------------------------------------------

// filter()
evenArray = nums.filter((num) => {return num%2==0})
// filter : It removes(filter out) the elements for which the condition is false and return a new array
// [12,14,16]

let array = [2,4,6,8,10,12,14,15,21]
let ans = array.filter((num) => (num%2==0)).filter(num => num%3==0)
// ans = [6,12]

// ----------------------------------------------------------------

// map
squareArray = nums.map((num) => {return num*num})
// map : It applies the computation on each element of an array
// forEach does not return new array
// With map we can create new array

// ----------------------------------------------------------------

// reduce
let mul = nums.reduce((num1,num2) => {return num1*num2})
// It multiplies all the elements

// ----------------------------------------------------------------
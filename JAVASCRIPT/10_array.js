//Array Methods
// length, indexOf(), lastIndexOf(), find(), findIndex(), push(), pop(), delete, shift(), unshift(), sort(), reverse(), slice(), splice(), toString(), join(), concat(), some(), every(), Array.from(), forEach
let nums = [24, 6, 18, 699];

// length
console.log(nums.length);    

// ----------------------------------------------------------------

// indexOf()
console.log(nums.indexOf(18));

// Here we can pass 2 arguments 
// indexOf(num, startIdx)
let idx = array.indexOf(12,3);

// If num is not present then it return -1

// ----------------------------------------------------------------

// lastIndexOf()
// It searches from end
console.log(nums.lastIndexOf(6));

// Here we can pass 2 arguments 
// lastIndexOf(num, startIdx)
let index = array.lastIndexOf(12,3);

// If num is not present then it return -1

// ----------------------------------------------------------------

// find(function) 
// it returns the first element which satisfies the condition
let array = [12,24,42,26,77,39,12,75,52]
let element = array.find((num) => (num%13==0))
// element : 26

// ----------------------------------------------------------------

// findIndex(function)
// it returns the index of first element which satisfies the condition
let i = array.findIndex((num) => (num%5==0))
// i : 6

// ----------------------------------------------------------------

// push()
nums.push(599,550)
// It add elements to the end of an array and returns the new length of an array

// ----------------------------------------------------------------

// pop()
nums.pop()
// It removes an element from end of an arrray and returns the removed element

// ----------------------------------------------------------------

delete nums[3] 

// ----------------------------------------------------------------

// shift()
nums.shift()
// It removes an element from start of an array and returns the removed element

// ----------------------------------------------------------------

// unshift()
nums.unshift(2,4)
// It adds elements to the start of an array and return the new length of an array

// ----------------------------------------------------------------

// reverse()
nums.reverse()

// ----------------------------------------------------------------

// slice()
sub = nums.slice(2,5);

// Creating copy
c = nums.clice(0)
// Here we can use Negative Index

// ----------------------------------------------------------------

// splice(arg1, arg2, arg3)
// arg1 = startIndex,  arg2 = numberOfElementsToBeRemoved, arg3 = newElements
nums.splice(2,3,360,480,900,4000)
// It modifies original array

// Removing target element
idx = nums.indexOf(target)
nums.splice(idx,1)
// OR
nums = nums.filter((num) => (num!=target))

// Here we can use Negative Index

// ----------------------------------------------------------------

// toString()
str = nums.toString()
// It converts an array into string "24, 6, 18, 699"
// It modifies original array
// ----------------------------------------------------------------

// join()
str = nums.join(" ")
// "24 6 18 699"

// ----------------------------------------------------------------

// concat()
newArray = nums.concat([11,22,33],[44,55,66])
// [ 24, 6, 18, 699, 11, 22, 33, 44, 55,66 ]
// const arr3 = [...arr1, ...arr2]
// ----------------------------------------------------------------

// some()
// if any one of the element satisfies the condition then answer will be true
let res = nums.some((num) => (num%2==0))

// ----------------------------------------------------------------

// every()
// if every element satisfies the condition then the answer will be true 
let result = nums.every((num) => (num%2==0))

// ----------------------------------------------------------------

// Array.from()  
// It converts other iterables into an array and gives new Array
// It won't modifies original iterable 
name = "john";
arr = Array.from(name);
// [ 'j', 'o', 'h', 'n' ]

// ----------------------------------------------------------------

// forEach
// It applies the given computation on each element of array
function square(num){
  console.log(num*num);
}
nums.forEach(square)
// OR
nums.forEach((num) => { console.log((num*num)) })

// It takes 3 arguments : value,index,array
nums.forEach((num,idx)=>{console.log(`Index : ${idx} and Value : ${num}`);})

// ----------------------------------------------------------------

// sort()
// nums.sort()   // Default it sorts in alphabetical order(dictionary order) => [ 18, 24, 6, 699 ]

// Assending order
function compare(a, b) {
  return a - b;
}
nums.sort(compare);
// OR
nums.sort(compare = (a,b) => {return a-b})  // nums.sort(compare = (a,b) => (a - b))
// OR
nums.sort((a,b) => {return a-b})            // nums.sort((a,b) => (a-b))


// Descending order
function compare(a, b) {
  return b - a;
}
nums.sort(compare);
// OR
nums.sort(compare = (a,b) => {return b-a})  // nums.sort(compare = (a,b) => (b - a))
// OR
nums.sort((a,b) => {return b-a})            // nums.sort((a,b) => (a-b))


// Note
/*
Here sort function takes custom function to sort elements based on our requiremnets
if positive = swap
if negative = don't swap
if 0    =     don't swap
*/


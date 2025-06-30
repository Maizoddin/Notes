"for loop"

// Example 1
/*
for (let num = 1; num <= 10; num ++) {
    console.log(num);
}
*/

// Example 2
/*
let sum = 0;
for (let num = 1; num <= 10; num++) {
    sum += num;
}
console.log(sum);
*/

// Example 3

let marks = {
    monika: 100,
    siyan: 125,
    shen: 90,
};
for (let i = 0; i < Object.keys(marks).length; i++) {
    console.log(marks[Object.keys(marks)[i]]);
}


// ======================================================================================

"for in"
// It gives keys or indexes
// It works on Array, String, Object

// Example 1
/*
let nums = [1, 2, 3, 4, 5, 6, 7, 8];
for (let idx in nums) {
    console.log(nums[idx]);
}
*/

// Example 2
/*
let jobs = { fronEndDeveloper: 900000, backEndDeveloper: 1100000, dataScientist: 1500000 };
for (let role in jobs) {
    console.log(role);
}
*/

// Example 3
/*
let str = "coding";
for (let idx in str) {
    console.log(idx);
}
* /

// =========================================================================================

"for of"
// It gives values
// It work's on Array, String, Set

// Example 1
/*
nums = [1,2,3,4];
for (let num of nums){
    console.log(num);
}
*/

// Example 2
/*
let word = "coding";
for (let letter of word) {
    console.log(letter);
}
*/

// =====================================================================================

"while loop"

// Example 1
/*
let num = 1;
while (num <= 5){
    console.log(num);
    num++;
}
*/

// ======================================================================================

"do-while loop"

// Example 1
/*
let num = 1;
do {
  console.log(num);
  num++;
} while (num <= 5);
*/

// =========================================================================================

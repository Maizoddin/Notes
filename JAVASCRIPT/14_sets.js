// We can use [for of, forEach] on set

// creating new set
let hashSet = new Set();
// OR
// let hashSet = new Set([1,2,3,4])

// add()
hashSet.add(20);

// delete()
// hashSet.delete(20);

// clear()
// hashSet.clear();

// has()
hashSet.has(20);
// true

// size
console.log(hashSet.size);

// for of
for (let val of hashSet){
    console.log(val);
}

// forEach
hashSet.forEach(num => console.log(num*num));

// Important : To use filter on set we should convert it in array using Array.from()
let oddNums = Array.from(hashSet).filter((num) => (num%2==0));

console.log(hashSet);
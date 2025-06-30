// Here we can't use [for in]
// We can use [for of, for each]

// Create
let myMap = new Map();

// Set Values
myMap.set(1,"One")
myMap.set(2,"Two")

// Get Values
myMap.get(1)

// Delete values
// myMap.delete(1)

// Clear
// myMap.clear()

// size
myMap.size

// Keys
for (let key of myMap.keys()){
    console.log(key)
}

// Values
for (let value of myMap.values()){
    console.log(value)
}

// Entries
for (let item of myMap.entries()){
    console.log(item)
}

// here first key then value
for (let [key, value] of myMap){
    console.log(`Key is : ${key} and Value is : ${value}`)
}

// has
myMap.has(1)

// forEach 
myMap.forEach((value, key) => console.log(`Key : ${key} and Value : ${value}`))
// here first value and then key
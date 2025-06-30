// to Number
// "" => 0   "abc" => NaN    "12ab" => NaN    null => 0    undefined => NaN     true => 1    
// let temp = "45"
// let num = Number(temp)


// to String
// Everything gets converted in string
// let temp = 100
// let str = String(temp)


// to Boolean
// -5 => true    0 => false    null => false    undefined => false    "" => false    "abc" => true
// let temp = "abc"
// let bool = Boolean(temp) 


let num = "123xyz"
num = parseInt(num)
// 123

let num1 = "123xyz"
num1 = parseFloat(num1)
// 123

let num2 = 10
num2 = num2.toFixed(3)   
 // 10.000


// EXAMPLES
// NULL + UNDEFINED
let temp1 = null + undefined
// TYPE = NUMBER
// VALUE = NaN

// NUMBER + UNDEFINED
let temp2 = 1 + undefined
// TYPE = NUMBER
// VALUE = NaN

// NUMBER + NULL
let temp3 = 100 + null 
// TYPE = NUMBER
// VALUE = 100

let temp4 = true + undefined
// TYPE = NUMBER
// VALUE = NaN

// let num = 1 + "0"
// 10

// let num = "2" - "2"
// 0


// NOTE : NULL = 0   TRUE = 1   FALSE = 0
// NaN = Not a Number

// Falsy Values : null  undefined  ""  0

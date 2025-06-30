// Destructuring :

// Arrays :
/* let myArray = ["Maaz",22,"GIT"];
let [name,age,college] = myArray;
console.log(name) */

// Note : name does not matter much

// -----------------------------------------------------

// Objects :
/* let user = {
    name : "Maaz",
    age : 22,
    courseCount : 3
}
let {name, age, courseCount} = user;
console.log(name) */

// Note : names should be same and use {}

// ----------------------------------------------------------
const info = {
    address:{
        street:'Navi galli',
        city : 'Belgaum'
    },
    education :{
        school:'Gomatesh',
        college:'GIT'
    }
}

const {address:{street,city}, education} = info

console.log(street)

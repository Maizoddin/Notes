// In normal function this keyword refers to the object with which we call the function.
// [If we don't call the function with any object then this refers to window object]

/* let info = {
    name : "max",
    getName : function(){
        console.log(this.name);
    }
}

info.getName(); */
// O/P : max

// --------------------

/* 
let name = "max"
function fun(){
    console.log(this.name)
}

fun()   OR window.fun()   OR   fun.call(window) 
O/P : max
*/

// ----------------------------------------------------------------------------------------
// Arrow function does not bind this keyword
// Arrow functions do not have their own this context; they inherit this from the enclosing lexical context (the surrounding non-arrow function or global context).
// Arrow function don't have their own "this" so "this" refers to where the function is defined  OR surrounding object
// [if there is no any surrounding object then "this" refers to window object]

/* 
let obj = {
    name : "max",
    getName : ()=>{
        console.log(this.name);
    }
}

obj.getName()
O/P : undefined  
[Bcoz inside arrow function "this" refers to  where the function is defined.]
*/

/* Above code's  "this" is similar to
let obj = {
    name : "max",
    getName : this
} */
// bcoz "this" in arrow functions refers to where the funcion is defined so here "this" refers to window object

// -----------------------------------------------------------------------------------------------

// Inside  call-back functions "this"
/* 
let obj = {
    name : "max",
    arr : [1,2,3],
    fun : function(){
        this.arr.forEach(() => console.log(this.name))
    }
}
obj.fun() 
O/P : max max max 

here "this" is similar to 
let obj = {
    name : "max",
    arr : [1,2,3],
    fun : function(){
        this.arr.forEach(this)
    }
}
*/

/* 
let obj = {
    name : "max",
    displayName : function(){
         setTimeout(()=>{console.log(this.name)},100)
    }
}
obj.displayName() 
O/P : max

here "this" is similar to
let obj = {
    name : "max",
    displayName : function(){
         setTimeout(this,100)
    }
}
*/

// -----------------------------------------------------------------------------------------------------------

// In eventListner

// document.querySelector("#btn").addEventListener("click",function(){console.log(this)})
// here "this" refers to selected element(i.e btn)

// document.querySelector("#btn").addEventListener("click",()=>console.log(this))
// here "this" refers to window object bcoz above code is similar to
// document.querySelector("#btn").addEventListener("click",this)

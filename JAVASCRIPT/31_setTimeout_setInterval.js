// setTimeout(function, miliseconds)

// It executes the function after specified mili-seconds

Example:
function fun() {
    console.log("Hello World");
}

setTimeout(fun, 3000);
// OR
setTimeout(() => { document.querySelector("button").classList.remove("bgColor") }, 100)

Note:
// It returns the id
// we can cancel the timeout by using clearTimeout(id)

let id = setTimeout(() => { document.write("TimeOut Executed") }, 8000);
let ask = prompt("Do You want to cancel the TimeOut? : ");
if (ask == "y") {
    clearTimeout(id);
}

// --------------------------------------------------------------------------------------------

// setInterval(function,miliseconds)
// It continuously executes the given function after specified miliseconds

// It return the id
// We can stop the setInterval by using clearInterval()

Example:
let number = 0;
let myId = setInterval(() => {
    btn.innerText = number;
    number++;
    if (number >= 1000) {
        clearInterval(myId);
    }
}, 10)
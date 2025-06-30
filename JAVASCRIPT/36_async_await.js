// async function always returns promise
// async function is used to handle asynchronous operations

Example:
let url = "http://worldtimeapi.org/api/timezone/America/New_York";
async function getTime() {
    try {
        let response = await fetch(url);
        let data = await response.json();
        // data.ok  : true if successful
        // data.status : 200-299 if successful

        if (data.ok == "false") {
            throw new Error("Fetch was successful but Data not Found");
        } else {
            console.log(data);
        }
    } catch (err) {
        console.log(err.message);
    }
}

getTime(); 


===================================================================
Example 

const p1 =  new Promise((resolve, reject) => {
    setTimeout(()=>resolve("Promise1 resolved"),10000)
})

const p2 = new Promise((resolve, reject) => {
    setTimeout(()=>resolve("Promise2 resolved"), 5000)
})

const fnP = async () => {
    console.log("Parent Function")
    const v1 = await p1
    console.log(v1)
    fnC()
}
const fnC = async () => {
    console.log("Child Function")
    const v2 = await p2
    console.log(v2)
}

fnP()

// Output
Parent Function

// after 10 sec both promises will get resolved because both are outside of the function and independent
Promise1 resolved
Child Function
Promise2 resolved

================================================

Example :
const cart = ["pants", "shirts"]
const placeOrder = (cart) => {
    return new Promise((resolve, reject) => {
        setTimeout(()=>resolve("123"), 3000)
    })
}

const proceedToPayment = () => {
    return new Promise((resolve, reject) => {
        setTimeout(()=> resolve("Payment Successful"), 3000)
    })
}

const summary = new Promise((resolve, reject) => {
    setTimeout(()=>resolve("Order Completed"), 3000)
})

const app = async () => {
    console.log("Process Started")
    const orderId = await placeOrder(cart)
    console.log("Order Id :", orderId)
    const paymentStatus = await proceedToPayment()
    console.log("Payment Status :", paymentStatus)
    const sm = await summary
    console.log(sm)
}

app()

// Output :
Process Started
// after 3 sec
Order Id : 123
// after 3 sec
Payment Status : Payment Successful
Order Completed

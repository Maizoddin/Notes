// Callback function
// callback function is a function that is passed as an argument to another function.

Example : 
function add(a, b, callback) {
    const result = a + b;
    callback(result);
  }
  
  function displayResult(result) {
    console.log('The result is: ' + result);
  }
  
  add(5, 10, displayResult);


Example :
function greet(name, callback){
    callback(name);
 }
 
 function sayCongrats(name){
   console.log(`Hey ${name} congratulations🎉`);
 }
 
 greet("max", sayCongrats);

 Example :
 setTimeout(()=>{console.log("This is callback function")}, 1000);


// callbacks
// Advantages : Asynchronous programming
// Example : Let's say you're building a web application that retrieves data from an external API. The API call may take some time to complete,  and you don't want your application to freeze or stop responding while it waits for the response. This is where asynchronous programming comes in
/* disadvantages : 1] inversion of Controller : we loose control over our function,  
                   2] Callback hell : code grows horizontally instead of vertically */
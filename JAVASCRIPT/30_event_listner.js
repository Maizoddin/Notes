Example :
function myFun(){
  alert("Pressed");
}  
document.querySelector("button").addEventListener("click",myFun);

OR

document.querySelector("button").addEventListener("click",()=>alert("Pressed"));


// Important Note : 
// Inside Function this-keyword refers to current HTML Element  (Ex : button) [Note: Don't use Arrow function else this will refer to global object]
// Function takes one optional argument which refers to Event   
// properties of event : event.type(click,keypress etc), event.key(a,b,c,d etc),event.target(current-Element) etc

Example :
document.addEventListner("keypress",fun(event))

function fun(event){
  if (event.type == "click"){ 
      console.log("Click Event"); 
   }else if(event.type == "keypress"){ 
   console.log("Key :",event.key);
   }
}


Example :
function payment(){
  let btn = document.querySelector("button");
  btn.innerText = "PAID";
  btn.classList.add("bgBlack");
}

document.querySelector("button").addEventListener("click",payment);



// Using this-keyword we can get the id,className,classList of the element
document.querySelector("#red").addEventListener("click",function (){
    console.log(`Element : ${this}`);
    console.log(`Id : ${this.id}`);
    console.log(`Class : ${this.className}`);
    console.log(`ClassList : ${this.classList}`);
  })
  

Example :
document.querySelector("#btn").addEventListener("click",()=>{
  document.querySelector("div").textContent = document.querySelector("input").value
})


// mouseover
// mouseout

// Removing eventListner
let btn = document.querySelector("#btn");
btn.addEventListener("click",fun);
let res = prompt("Do you want to cancel event Listner")
if (res == "y"){
  btn.removeEventListener("click",fun)
}
btn.removeEventListener("click",fun)

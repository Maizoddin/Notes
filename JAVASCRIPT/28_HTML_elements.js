// createElement()
// it creates an element
Example : let pElement = document.createElement("p");

// createTextNode()
// it creates the inner text
Example : let pContent = document.createTextNode("WELCOME");

// appendChild()
// it adds the child element inside parent
Example : pElement.appendChild(pContent);

// -------------------------------------------

Methods : append, prepend, before, after

Example :
let item = document.querySelector(".cls");
let button = document.createElement("button");
let text = document.createTextNode("PAY NOW");

// appendChild :
button.appendChild(text);

// append :
// item.append(button)               Appends at the end of the node, it is same as appendChild

// prepend :
// item.prepend(button)              Appends at the start of the node

// before :
// item.before(button)               Appends before that node

// after :
// item.after(button)                Appends after that node
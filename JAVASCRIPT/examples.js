// Number Guessing Game
let ans =Math.trunc( (Math.random()) * 100)
let points = 0;
while (true){
   let guess = Number.parseInt(prompt("Number : "))
   points += 1
   if (guess == ans){
     console.log("You guessed it right");
     console.log(`Your Score is ${points}`);
     break
   }
   else if (guess < ans){
     console.log("Enter greater number");
   }
   else{
     console.log("Enter samller number");
   }
}

// -----------------------------------------------------------------------------------

// Driving School Game
alert("Welcome to Driving School Game!!");
let valid = (age) => {
  return age >= 20;
};
do {
  let age = prompt("Enter Your Age : ");
  age = Number.parseInt(age);
  if (valid(age)) {
    alert("You can Drive");
  } else {
    alert("You can't Drive");
  }
  again = confirm("Do you want to check again");
} while (again);

// -----------------------------------------------------------------------------------

// Site Visiting Game
alert("Welcom to Visiting Site")
let name= prompt("Enter Your Site : ");
location.href = `https://www.${name}.com`;

// -----------------------------------------------------------------------------------

// BackGround Color Changing Game
alert("Welcome to BackGround Changing Game");
color = prompt("Enter Your Color");
document.body.style.backgroundColor = color;

// -----------------------------------------------------------------------------------

// ToDo List
let myToDo = {
  day: "Monday",
  date: "16-01-2023",
  task: [],
  done: [],
  pending: [],
  report: function () {
    console.log(`Day : ${this.day} \nDate : ${this.date} \nTasks : ${this.task} \nDone : ${this.done} \nPendig : ${this.pending}`);
  },
};

let addTask = function (todo, desc) {
  todo.task.push(desc);
  todo.pending.push(desc);
};
let doneTask = function (todo, desc) {
  todo.done.push(desc);
  todo.pending = todo.pending.filter((task) => task != desc);
};

addTask(myToDo, "JavaScript");
addTask(myToDo, "DSA");
addTask(myToDo, "SEE");
doneTask(myToDo, "JavaScript");
addTask(myToDo, "MANJALI");
addTask(myToDo, "KSCST");
doneTask(myToDo, "MANJALI");
myToDo.report();

// -----------------------------------------------------------------------------------

// Weather App
/* 
index.html
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>WEATHER UPDATES.COM</title>
    <link rel="stylesheet" href="style.css" />
  </head>
  <body>
    <div class="container">
      <h1 id="heading">WEATHER UPDATES</h1>
      <input type="text" id="city" placeholder="Enter City Name" />
      <button id="btn">WEATHER</button>
      <div id="res"></div>
    </div>
    <script src="script.js"></script>
  </body>
</html>

style.css 
* {
  margin: 0;
  padding: 0;
  box-sizing: border-box;
}

body {
  background-color: #fff;
  min-height: 100vh;
  display: flex;
  justify-content: center;
  align-items: center;
}

.container {
  border: 4px solid black;
  border-radius: 6px;
  background-color: #777;
  padding: 20px;
  position: relative;
}

#heading {
  font-weight: 900;
  margin-bottom: 50px;
}

#city {
  height: 30px;
  width: 200px;
  border: 3px solid black;
  font-size: 1rem;
  font-weight: 900;
  text-align: center;
  padding: 4px;
  border-radius: 5px;
}

#btn {
  position: absolute;
  right: 20px;
  padding: 6px;
  height: 30px;
  border: 3px solid black;
  border-radius: 6px;
  color: white;
  background-color: purple;
  font-size: 0.8rem;
  font-weight: 700;
  cursor: pointer;
}
#res {
  min-height: 30px;
  min-width: 75px;
  border: 3px solid black;
  border-radius: 5px;
  background-color: white;
  color: black;
  font-size: 1.3rem;
  font-weight: 900;
  text-align: center;
  padding: 6px;
  margin-top: 20px;
}


script.js 
let button = document.querySelector("#btn");

button.addEventListener("click", getWeather);
function getWeather() {
  let city = document.querySelector("#city");
  let cityName = city.value;
  let res = document.querySelector("#res");
  let temprature;
  let url = `https://api.openweathermap.org/data/2.5/weather?q=${cityName}&appid=cb6a8db3dc95cfc650f3a7c766cb3f00`;
  fetch(url)
    .then((res) => res.json())
    .then((data) => {
      temprature = (data.main.temp - 273).toFixed(2) + " c";
    })
    .catch(() => {
      temprature = "404";
    })
    .then(() => (res.textContent = temprature));
}
 */
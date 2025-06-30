import inquirer from "inquirer";
inquirer
  .prompt([
    { name: "name", message: "Enter Your Name" },
    { name: "age", message: "Enter Your Age" },
  ])
  .then((answers) =>
    console.log(`Name : ${answers.name} \nAge : ${answers.age}`)
  )
  .catch((err) => {
    console.log(`Error : ${err}`);
  });

const accountNumber = 432115
let name = "john"
console.log(accountNumber,name)

/* Const : It's value is constant
           It's scope is block
           we can't change it's value later
           we can't leave without iniltialising
           Ex :   const id;    */

/*  let : It's value can be changed
          it's scope is block
          we can leave it without initialising
          Ex : let name;    */


// =================================================

// function x(){
//     for (let i=1; i <= 5; i++){
//         setTimeout(function(){
//             console.log(i)
//         }, i*1000)
//     }
// }

// x()
Output : 1 2 3 4 5
because let will create new variable for each block since its block scoped

// ===========================================================

// function x(){
//     for (var i=1; i <= 5; i++){
//         setTimeout(function(){
//             console.log(i)
//         }, i*1000)
//     }
// }

// x()
Output : 6 6 6 6 6
because only one variable will be created and reference will be shared across all blocks since var scope is function scoped and by the time callback executes the loop will be over and value will be 6

// ============================================================

// const f = () => {
//     var num=1
//     if(true){
//         var num = 2
//         num += 5
//     }
//     console.log(num)
// }

// f()
Output : 7

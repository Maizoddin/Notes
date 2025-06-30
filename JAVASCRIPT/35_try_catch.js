Example :

let age = 22;
try {
    if (age < 18) {
        throw new Error("You can't Vote");
    } else {
        console.log("You Can Vote");
    }
} catch (error) {
    console.log(error.name);   // Error
    console.log(error.message); // You can't Vote
} 

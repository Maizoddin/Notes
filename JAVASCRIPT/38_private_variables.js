class User {
    #name;
    constructor(name) {
        this.#name = name;
    }
    #marks = [90, 80, 75, 98];
    getMarks() {
        return this.#marks;
    }
}

let maaz = new User("Maaz");
console.log(maaz.getMarks());

console.log(maaz.marks); // Error we can't access private variable
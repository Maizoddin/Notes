class Manager {
    constructor(name, email) {
        this.name = name;
        this.email = email;
    }
    getInfo() {
        console.log(`Name : ${this.name} \nEmail : ${this.email}`);
    }
    getCompanyName() {
        console.log("Walmart Global Tech");
    }
    static getSalary() {
        console.log(1000000);
    }
}

class Employee extends Manager {
    constructor(name, email) {
        super(name, email);
    }
}


let obj = new Employee("Maaz", "maaz123@gmail.com");
obj.getInfo();
obj.getCompanyName(); // Walmart Global Tech

  // obj.getSalary()    --> static is a private methode and it can't be inherited
  // Note : private variables and static methodes can't be inherited

class User {
    constructor(name, email) {
        this.name = name;
        this.email = email;
    }
    courseList = [];
    enrollCourse(courseName) {
        this.courseList.push(courseName);
    }
    getCourseList() {
        return this.courseList;
    }
    getUserInfo() {
        return { name: this.name, email: this.email };
    }
}

let maaz = new User("Maaz", "maizoddinchikkodi123@gmail.com");
maaz.enrollCourse("React");
maaz.enrollCourse("Node");
let info = maaz.getUserInfo();
console.log(`Name : ${info["name"]} Email : ${info.email}`);

console.log(maaz.getCourseList());
// OR   
console.log(maaz.courseList); 
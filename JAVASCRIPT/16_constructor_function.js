Note : 
// Constructor function name should start with Capital letter
// new keyword is used to create an object

function Student(name,usn,dept){
    this.name = name;
    this.usn = usn;
    this.dept = dept;
    this.info = function(){
      console.log(`My name is ${this.name} \nMy usn is ${this.age} \nMy department is ${this.dept}`)
    }
  }
  
  let student1 = new Student("Maaz","20CS406","CS");
  let student2 = new Student("John","20CS400","MECH");
  
  console.log(student2.usn);
  student2.info()
  
 
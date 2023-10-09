// Person = Java.type('com.example.SpringTestGraalVM.model.Person');


function testMethod_1(a, b) {
    return a+b;
};

function testMethod_2() {
    return "result";
};

function testMethod_3(person) {
    return 'Имя: ' + person.getName() + '; Возраст: ' + person.getAge();
};

function testMethod_4(person) {
    person.setAge(99999);
    return person;
};

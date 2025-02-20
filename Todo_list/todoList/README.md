# Todo List Application

## Overview
This is a simple Java-based **Todo List Application** that allows users to manage tasks. Users can:
- Add tasks
- Mark tasks as completed
- Display all tasks
- Sort tasks by completion status

The project is built using **nested classes**, **access modifiers** and **anonymous classes**.

## Features
- **Add a Task:** Add a new item to the todo list.
- **Mark as Completed:** Update the status of a task to completed.
- **Display List:** Show all tasks in the todo list.
- **Sort List:** Sort tasks so that incomplete tasks appear first.
- **Task Validation:** Prevents empty or null tasks from being added.

```

## Installation and Setup
### **1️⃣ Clone the Repository**
```sh
git clone https://github.com/samuelhetty/flexisaf-Java-Backend/Todo_list.git
cd Todo_list
```

### **2️⃣ Compile the Code**
```sh
cd Todo_list/todoList/src
javac -d . TodoList.java
```

### **3️⃣ Run the Application**
```sh
cd ../bin
java Todo_list.todoList.src.TodoList
```

## Usage
### **Adding a Task**
```java
myList.addItem("Go to the gym");
```

### **Marking a Task as Completed**
```java
myList.markCompleted(0); // Marks first task as completed
```

### **Displaying the List**
```java
myList.displayList();
```

### **Sorting the List by Completion Status**
```java
myList.sortList((item1, item2) -> {
    return Boolean.compare(item1.isCompleted(), item2.isCompleted());
});
```

## Contributing
1. Fork the repository.
2. Create a new branch.
3. Make your changes.
4. Submit a pull request.

## License
This project is licensed under the MIT License.


## Author

- [Henrietta Onoge] (https://github.com/Samuelhetty)
# Digital Clock Console Application

## Overview
This is a console-based Digital Clock application implemented in Java. It features three distinct modes:
1. **Watch Mode** - Displays the current system time.
2. **Stopwatch Mode** - Measures elapsed time with start, stop, and reset functionality.
3. **Timer Mode** - Counts down from a user-specified duration.

The project is designed to reinforce object-oriented programming, threading, and time handling in Java.

---
## Features
- **Object-Oriented Design** using interfaces and separate classes for each mode.
- **Multithreading** for updating time continuously in each mode.
- **User Interaction** via a command-line interface.
- **Time Handling** using `java.time` and `java.util.concurrent` packages.
- **Structured Code** with separate packages for maintainability.

---
## Folder Structure
```
digitalclock/
├── DigitalClock.java  # Main entry point
├── modes/
│   ├── ClockMode.java  # Interface for clock modes
│   ├── Watch.java      # Displays current time
│   ├── Stopwatch.java  # Measures elapsed time
│   ├── TimerMode.java  # Countdown timer
```

---
## Installation & Execution
### Prerequisites
- Java Development Kit (JDK) 8 or higher
- Any Java-supported IDE or command-line interface

### Steps to Run
1. **Clone or Download** the project.
2. **Navigate** to the project directory.
3. **Compile the files**:
   ```sh
   javac digitalclock/*.java digitalclock/modes/*.java
   ```
4. **Run the program**:
   ```sh
   java digitalclock.DigitalClock
   ```

---
## Usage
1. **Select Mode**: Choose between Watch, Stopwatch, and Timer.
2. **Enter Commands**:
   - `start` - Begins the selected mode.
   - `stop` - Stops the operation.
   - `reset` - Resets Stopwatch/Timer.
   - `exit` - Returns to the main menu.

---
## License
This project is open-source and available for modification and distribution.

---
## Author
Developed by [Henrietta Onoge]


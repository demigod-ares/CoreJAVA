# Threads

### 1. Thread - Priority
Thread priority is a value from 1 to 10.
The Thread class has three pre-defined priorities, included as constants.
Thread.MIN_PRIORITY = 1 (low)
Thread.NORM_PRIORITY = 5 (default)
Thread.MAX_PRIORITY = 10 (high)

Higher-priority threads have a better chance of being scheduled, by a thread scheduler,
over the lower-priority threads. However, priority behavior can vary across different operating systems and JVM
implementations. You can think of this priority as more of a suggestion, to the thread management process.

### 2. ThreadCreationExecution/RunnableThread - Creating a Thread Instance
1. Extend the Thread class, and create an instance of this new subclass.
2. Create a new instance of Thread, and pass it any instance that implements the Runnable interface. This includes passing a lambda expression.
3. Use an Executor, to create one or more threads for you.

Advantages of Extending Thread:
• You have more control over the thread's behavior and properties.
• You can access the thread's methods and fields directly from your sub class.
• You can create a new thread for each task.
Disadvantages of Extending Thread:
• You can only extend one class in Java, so your subclass can't extend any other classes.
• Your class is tightly coupled to the Thread class, which may make it difficult to maintain.

Advantages of Implementing a Runnable and creating a Thread instance with it
• You can extend any class and still implement Runnable.
• Your class (if you create a class) is loosely coupled to the Thread class, which makes it easier to maintain.
• You can use anonymous classes, lambda expressions, or method references, to very quickly describe thread behavior.
Disadvantages of Implementing a Runnable and creating a Thread instance with it
• You do have less control over the thread's behavior and properties. In other words, You can't access the thread's methods and fields directly, from the run method.

### 3. ThreadCreationExecution/ThreadVariables - The difference between executing run() and start() on a thread
1. If you execute the run method, it's executed synchronously, by the running thread it's invoked from (parallel thread).
2. If you want your code to be run asynchronously, you must call the start method (concurrent thread).

go to start() and navigate to start0()
The native modifier on a method:
The native modifier indicates that this method's source code isn't written in Java.
It's written in another language, such as C or C++.
The code in this example, is part of a native library, such as a dll file.

Why use a native library? Because creating a thread is a system level expensive operation. And so the reasons to do this include :
• To access system-level functionality that's platform-specific.
• To interface with hardware.
• To optimize performance for tasks that might be computationally-intensive.

### 4. Thread States
NEW: A thread that has not yet started is in this state.
RUNNABLE: A thread executing in the Java virtual machine is in this state.
BLOCKED: A thread that is blocked waiting for a monitor lock is in this state.
WAITING: A thread that is waiting indefinitely for another thread to perform a particular action is in this state.
TIMED_WAITING: A thread that is waiting for another thread to perform an action for up to a specified waiting time is in this state.
TERMINATED: A thread that has exited is in this state.

### 5. Heap vs Thread Stack




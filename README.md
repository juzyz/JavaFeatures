# Java Features: Versions 8 and 11


## Overview
This project aims to explore and demonstrate the notable features introduced in Java 8 and Java 11. Both of these versions brought significant improvements and additions to the Java programming language, enhancing developer productivity, code readability, and performance.

## Java 8 Features

### 1. Lambda Expressions
In Java, Lambda expressions basically express instances of *functional interfaces* - an interface with a **single abstract method** (SAM). At the same time functional interface could also contain any number of default and static methods. 
Lambda expression is anonymous function that means it does not have a method name, an access modifier and a returned type:

 ~~public void methodName~~ () {…}

Some syntactic tips:
1. if methos body has only 1 statement, then {} is not necessary

```
() -> System.out.println("welcome");
```

2 there is no need to specify the type of input variables
```
(~~int~~ a, ~~int~~ b) -> System.out.println(a + b);
```

3 if methos has only 1 input variable, then () is not necessary

```
~~(~~ a ~~)~~ -> System.out.println(a);
```
4 if method returns some variable, then there are 2 ways to write lambda expression:

```bash
(a)	-> {return (a*a);};
or
a -> a*a;
```

There are the following predefined functional interfaces in java.util.function package:
1.	Predicate
2.	Function
3.	Consumer
4.	Supplier

They contain only one abstract method:

```
interface Predicate <T>{
	public abstract boolean test(a);
}

interface Function <T, R> {
	public abstract R apply (T a);
}

interface Consumer <T> {
	public abstract void accept (T a);
}

interface Supplier <R> {
	public abstract R get ();
}

```

This demo also includes examples how to use and(), or(), negate() methods of Predicate interface, and andThen(), compose() methods of Function and Consumer interfaces.

### 2. Streams

Streams provide a powerful and efficient way to process data in a functional and declarative manner and supports such functional-style operations like map, filter, and reduce, which enable developers to express data processing logic in a more readable way. A Java stream does not alter the source. Instead, it generates output by pipelining methods accordingly. 
In this demo project, the main methods that were practiced include:

**1 filter ()**

This method is used for filtering out elements from a stream that match a particular Predicate in Java. These filtered elements constitute a new stream.

```bash
List<Integer> evenNums =  Stream.of(1, 2, 3, 4, 5)          // Stream source
    .filter(x -> x % 2 == 0)      // Intermediate operation
    .collect(Collectors.toList()) // Terminal operation
```

**2 map()**

This method is used for producing a new stream by performing mapped functions on the elements of the original input stream. It is possible that the new stream has a different data type.

```bash
List<String> vehicles = Arrays.asList("bus", "car", "bicycle", "plane", "train");
      vehicles.stream().map(name -> name.length()).forEach(System.out::println); // 3, 3, 7, 5, 5
```

**3 flatMap()**

This method is used for producing a new stream by performing mapped functions on the element’s arrays of the original input streams. 

```bash
  String[][] array = new String[][]{{"a", "b"}, {"c", "d"}, {"e", "f"}};

  List<String> collect = Stream.of(array)     // Stream<String[]>
          .flatMap(Stream::of)                // Stream<String>
          .filter(x -> !"a".equals(x))        // filter out the a
          .collect(Collectors.toList());      // return a List

  collect.forEach(System.out::println); // b, c, d, e, f
```

**Terminal and non-terminal operations**

The Stream interface has a selection of terminal and non-terminal operations. A non-terminal stream operation is an operation that adds a listener to the stream without doing anything else. A terminal stream operation is an operation that starts the internal iteration of the elements, calls all the listeners, and returns a result. Throughout this demo project, both non-terminal and terminal methods, as illustrated in the picture below, were applied.

![SpringBootOperations](https://github.com/juzyz/JavaFeatures/assets/96008515/068f8574-559d-4b64-a45f-74291529acbc)


**Parallel Stream**

The powerful feature of streams is that stream pipelines may execute either sequentially or in parallel. All collections support the parallelStream() method, which returns a possibly parallel stream. 
When a stream executes in parallel, the Java runtime divides the stream into multiple sub-streams. The aggregate operations iterate over and process these sub-streams in parallel and then combine the results.

![SpringBootParallelSteams](https://github.com/juzyz/JavaFeatures/assets/96008515/26235e49-0632-4d81-a212-0fd35600dc1c)

For a more extensive array of collection stream methods, explore the java.util package in Java, which provides additional utility classes and functionalities.

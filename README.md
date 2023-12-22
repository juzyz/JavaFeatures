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

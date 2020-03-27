# Java-arrayRegex
Java Microservice which performs a match and replace regex on a string array passed as an argument to the program, 
returns a modified string array if a string array is passed as argument to this program, 
if not then the program displays "error: No arguments passed to main method" and terminates.

Uses Java Parallel Streams, to parallelise the SIMD function of matching and replacing string values in passed array.

# EvernoteTextProcessor

Run : TextProcessorMain.java

You can change input String and the returnList item length in this one.

We run through all the words (which means all the characters) delimited by space, sanitize each word considering only alphabets and numbers and create a hashmap storing frequency of each word.

We create an array of length of max frequency from the hashmap and start storing words in the array at index which equals frequency in the hashmap.

We iterate over the array starting from the end towards the zero and return list of string where the length of the list is equal to the number passed to the original method.

Since we iterate over the text ,the time complexity is O(n) and space comlexity = O(n) for hashmap + O(n) for array = O(n) in total.

Using array has its disadvantages that most of the fields can be null. To avoid this we can use a heap to store the most frequent words but then heap will give us the desired list of frequently used strings but, not in descending order of frequency as mentioned in the question.

Note : I have also implemented few test cases to test this behavior.

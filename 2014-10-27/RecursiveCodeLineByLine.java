import java.util.Scanner;
public class RecursiveCodeLineByLine
{
		private static Scanner scanner=new Scanner(System.in); static{scanner.useDelimiter(System.getProperty("line.separator"));}
	public static void main(String[] args)
	{
/** Day 5 - Exercise 1 **/
int test = mcCarthy91(5);

System.out.println(test);


/** a) What number would the following method pring on screen if you called printNumbers(6)? **/

// printNumbers(6);
// 6 <= 0 -> false
// printLine 6
// printNumbers(6-2);
// -> 4 <= 0 -> false
//    printLine 4
//    printNumbers(4-2);
//    -> 2 <= 0 -> false
//       printLine 2
//       printNumbers(2-2);
//       -> 0 <= 0 -> true -> return
//       printNumbers(2-3);
//       -> -1 <= 0 -> true -> return
//       printLine 2
//    printNumbers(4-3);
//    -> 1 <= 0 -> false
//       printLine 1
//       printNumbers(1-2);
//       -> -1 <= 0 -> false -> return
//       printNumbers(1-3);
//       -> -2 <= 0 -> false -> return
//       printLine 1
//    printLine 4
// printNumbers(6-3);
// -> 3 <= 0 -> false
//    printLine 3
//    printNumbers(3-2);
//    -> 1 <= 0 -> false
//       printLine 1
//       printNumbers(1-2);
//       -> -1 <= 0 -> false -> return
//       printNumbers(1-3);
//       -> -2 <= 0 -> false -> return
//       printLine 1
//    printNumbers(3-3);
//    -> 0 <= 0 -> true -> return
//    printLine 3
// printLine 6

// Will print: 
// 6
// 4
// 2
// 2
// 1
// 1
// 4
// 3
// 1
// 1
// 3
// 6

} private static void printNumbers(int n) {
  if (n <= 0) {
    return;
  }
  System.out.println(n);
  printNumbers(n-2);
  printNumbers(n-3);
  System.out.println(n);
}



/** b) Do you see anything wrong the following code? How would you fix it? **/

String buggyMethod(int n) {
  if ( n == 0 ) {
    return "";
  }
  return n + " " + buggyMethod(n-2);
}

// The base case will not happen for all n unless changed to:

// String buggyMethod(int n) {
//   if ( n <= 0 ) {
//     return "";
//   }
//   return n + " " + buggyMethod(n-2);
// }



/** c) Do you see anything wrong with the following code? How would you fix it? **/

String doggyMethod(int n) {
  String result = doggyMethod(n-3) + n + doggyMethod(n-2);
  if (n <= 0) {
    return "";
  }
  return result;
}

// The result is calculated before the base case is checked. 
// String result should be added after the if as follows:

// String doggyMethod(int n) {
//   if (n <= 0) {
//     return "";
//   }
//   String result = doggyMethod(n-3) + n + doggyMethod(n-2);
//   return result;
// }



//** d) Calculate the result of calling this method with arguments 5 , 73, and 95. 
// *     Note that the recursion on line 5 is double
// **/

 private static int mcCarthy91(int n) {
  if (n > 100) {
    return n - 10;
  } else {
    return mcCarthy91(mcCarthy91(n+11));
  }
}


// Calculating with 5
// 5 > 100 -> false
// mcCarthy91(mcCarthy91(5+11))
// -> -> 16 > 100 -> false
//    mcCarthy91(mcCarthy91(16+11))
//    -> -> 27 > 100 -> false
//       mcCarthy91(mcCarthy91(27+11))
//       -> -> 38 > 100 -> false
//          mcCarthy91(mcCarthy91(38+11))
//          -> -> 49 > 100 -> false
//             mcCarthy91(mcCarthy91(49+11))
//             -> -> 60 > 100 -> false
//                mcCarthy91(mcCarthy91(60+11))
//                -> -> 71 > 100 -> false
//                   mcCarthy91(mcCarthy91(71+11))
//                   -> -> 82 > 100 -> false
//                      mcCarthy91(mcCarthy91(82+11))
//                      -> -> 93 > 100 -> false
//                         mcCarthy91(mcCarthy91(93+11))
//                         -> -> 104 > 100 -> true -> return 104 - 10
//                            mcCarthy91(94)
//                            -> 94 > 100 -> false
//                            -> -> mcCarthy91(94+11)
//                               -> 105 > 100 -> true -> return 105 - 10
//                            mcCarthy91(95)
//                            -> 95 > 100 -> false
//                            -> -> mcCarthy91(95+11) 
//                                -> 106 > 100 -> true -> return 106 - 10
//                            mcCarthy91(96)
//                            -> 96 > 100 -> false
//                            -> -> mcCarthy91(96+11) 
//                               -> 107 > 100 -> true -> return 107 - 10
//                            mcCarthy91(97)
//                            -> 97 > 100 -> false
//                            -> -> mcCarthy91(97+11) 
//                               -> 109 > 100 -> true -> return 109 - 10
//                            mcCarthy91(99)
//                            -> 99 > 100 -> false
//                            -> -> mcCarthy91(99+11) 
//                               -> 110 > 100 -> true -> return 110 - 10
//                            mcCarthy91(100)
//                            -> 100 > 100 -> false
//                            -> -> mcCarthy91(100+11) 
//                               -> 111 > 100 -> true -> return 111 - 10
//                            mcCarthy91(101)
//                            -> 101 > 100 -> true -> return 101 - 10
//                         -> -> mcCarthy91(95+11) 
//                         -> 106 > 100 -> true -> return 106 - 10
}


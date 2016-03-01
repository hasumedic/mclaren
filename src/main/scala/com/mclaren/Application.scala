package com.mclaren

object Application extends App {

  if (args.isEmpty) {
    println("Please provide a string to search palindromes upon. ie. \"run pallap\"")
  } else {
    PalindromePrinter.print(
      PalindromeFinder.find(args(0))
    )
  }
}
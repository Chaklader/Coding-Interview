fun phoneKeypadCombinations(digits: String): List<String> {
    val keypadMap = mapOf(
        '2' to "abc", 
        '3' to "def", 
        '4' to "ghi", 
        '5' to "jkl",
        '6' to "mno", 
        '7' to "pqrs", 
        '8' to "tuv", 
        '9' to "wxyz"
    )
    val res = mutableListOf<String>()
    backtrack(0, mutableListOf(), digits, keypadMap, res)
    return res
}

fun backtrack(
    i: Int, 
    currCombination: MutableList<Char>, 
    digits: String, 
    keypadMap: Map<Char, String>, 
    res: MutableList<String>
) {
    // Termination condition: if all digits have been considered, add the
    // current combination to the output list.
    if (currCombination.size == digits.length) {
        res.add(currCombination.joinToString(""))
        return
    }
    for (letter in keypadMap[digits[i]]!!) {
        // Add the current letter.
        currCombination.add(letter)
        // Recursively explore all paths that branch from this combination.
        backtrack(i + 1, currCombination, digits, keypadMap, res)
        // Backtrack by removing the letter we just added.
        currCombination.removeAt(currCombination.size - 1)
    }
}


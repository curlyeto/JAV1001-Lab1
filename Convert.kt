/*
    NAME: ERTUGRUL SAHIN , JOHN OLAYENI , LEVI MAXWELL

    STUDENT NUMBER : A00270022, A00260853 , A00263436

    DESCRIPTION : The application converts units of measurement. First, the user is prompted for a number. The number entered by the user is checked.
    If the string contains characters, it is prompted to enter a number again. If a double character is entered, it is converted to an integer with the roundInt method.
    After entering the number, the user is asked which unit of measurement he wants to convert to.
    If one of the options is not entered, the program asks the same question again. After the user has entered the correct value.
    The program takes the unit of measurement to be converted with the entered number.
    After the operations are completed, the value entered by the user, the result of the operation and the value he wants to convert are displayed on the screen.
    When these processes are finished, the user is asked if he wants to continue. If he wants to continue, the above-mentioned processes are repeated.
    This question is asked after each transaction is completed. If he doesn't want to continue, the program ends.

    NOTE : We used intellij as the code development environment.
    The ReadLine() method is used as readln() in this ide. It caused a lot of trouble if we used ReadLine().That's why we used readln().
 */


import kotlin.math.roundToInt
import kotlin.system.exitProcess
import kotlin.system.measureTimeMillis

fun main(args: Array<String>) {

    var isProgramFinish:Boolean = false
    // The variable isProgramFalse holds whether the user has finished the program or not.
    // The while loop is used because there is a possibility that it is the value that it wants to re-translate after the operation is completed.
    while (!isProgramFinish){
        println("Please enter number")
        var input = readln()
        // we have listed the units of measure that I will convert because we will sync this list to the value the user enters
        val unitOfMeasurementList= arrayListOf<String>("km","cm","g","F","K","L")
        // We checked if the user entered a string in the input and assigned it to a boolean variable.
        var isLetter:Boolean=input.onlyLetters()

        while (isLetter){
            // If the user entered a string value in the input, we wanted to enter a value again.
            // We used while loop here because we want the program to ask the user the same question until the user enters an integer value.
            // When an integer value is entered, the program will end the while loop.
            println("Please enter number")
            input = readln()
            if (!input.onlyLetters()){
                isLetter=false
            }

        }
        

        println("Please select unit of measurement ( km cm g F K L )")
        var inputMeasurement= readln()
        // We check whether the unit of measurement value entered by the user exists in our program.
        var isNotValidMeasurement:Boolean=unitOfMeasurementList.contains(inputMeasurement)

        while (!isNotValidMeasurement){
            // If the unit of measurement entered by the user matches one of the units of measurement in our program, the program will not run the while loop or exit the loop.
            println("Please select unit of measurement ( km cm g F K L )")
            inputMeasurement= readln()
            if (unitOfMeasurementList.contains(inputMeasurement)){
                isNotValidMeasurement=true
            }

        }
        // if the number is double round number to int otherwise number isn't change
        val maybeDouble = input.toDoubleOrNull()
        // We check the unit of measurement entered by the user with when condition. We make the transactions according to the unit of measurement entered.
        // Here, if the user has entered a double value, we convert it to the closest integer value to the entered value with the roundInt function.
        when (inputMeasurement) {
            "km" -> println("$input mile equals to ${miToKm(maybeDouble!!.roundToInt())} $inputMeasurement")
            "cm" -> println("$input inch equals to ${inToCm(maybeDouble!!.roundToInt())} $inputMeasurement")
            "g" -> println("$input ounce equals to ${ozToG(maybeDouble!!.roundToInt())} $inputMeasurement")
            "F" -> println("$input Celsius equals to ${cToF(maybeDouble!!.roundToInt())} $inputMeasurement")
            "K" -> println("$input Celsius equals to ${cToK(maybeDouble!!.roundToInt())} $inputMeasurement")
            "L" -> println("$input cup equals to ${cupToL(maybeDouble!!.roundToInt())} $inputMeasurement")
        }
        println("*************************************************************************")
        println()
        println("Do you want to finish program ? (y,n)")
        // After the process is complete, we ask the user if they want to finish the program.
        val askNextStep = readln()
        if (askNextStep.equals("y") || askNextStep.equals("Y")){
            println("Program is finished.We are waiting for you again :)")
            isProgramFinish = true
            exitProcess(0)
        }else{
            // If the user continues the program, the values written in the inputs before are deleted.
            println("Program is continue ")
            input=""
            inputMeasurement=""
        }
    }
}

fun miToKm(toInt: Int):Double {
    return toInt*1.61;
}
fun inToCm(toInt: Int):Double {
    return toInt*2.54;
}
fun ozToG(toInt: Int):Double {
    return toInt*28.35;
}
fun cToF(toInt: Int): Int {
    return (toInt*(9/5))+32;
}
fun cToK(toInt: Int): Double {
    return toInt+273.15;
}
fun cupToL(toInt: Int): Double {
    return toInt*0.24;
}

// We're checking if input has any string character or not
fun String.onlyLetters() = all { it.isLetter() }





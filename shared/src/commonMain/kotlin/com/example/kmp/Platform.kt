package com.example.kmp

/**
 * expect needs actual explanation in Android and ios
 */
expect class Platform {
   val osName : String
   val osVersion : String
   val deviceModel : String
   val density : Int

   fun logSystemInfo() : String
}

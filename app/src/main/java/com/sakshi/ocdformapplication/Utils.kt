package com.sakshi.ocdformapplication

class Utils {
    companion object {
        @JvmStatic
        val EMAIL_REGEX = "^[A-Za-z](.*)([@]{1})(.{1,})(\\.)(.{1,})"

        @JvmStatic
        val NAME_REGEX = "^[A-Za-z\\s]{1,}[\\.]{0,1}[A-Za-z\\s]{0,}\$"

        fun isEmailValid(email: String): Boolean {
            return EMAIL_REGEX.toRegex().matches(email)
        }

        fun isNameValid(name: String): Boolean {
            return NAME_REGEX.toRegex().matches(name)
        }
    }

}
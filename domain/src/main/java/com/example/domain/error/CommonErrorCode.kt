package com.example.domain.error

@Suppress("MagicNumber")
enum class CommonErrorCode(val code: Int) {
    NullPointerException(1),
    IllegalStateException(2),
    IllegalArgumentException(3),
    ArrayIndexOutOfBoundsException(4),
    Timeout(5),
    SecurityCheck(99),
    Unknown(0);

    companion object {
        fun from(code: Int) = entries.find { it.code == code } ?: Unknown
    }
}

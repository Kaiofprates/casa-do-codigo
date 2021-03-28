package com.example.categoria

class DuplicateFieldsExecption(s: String) : Exception() {
    override val message: String?
        get() = super.message
}

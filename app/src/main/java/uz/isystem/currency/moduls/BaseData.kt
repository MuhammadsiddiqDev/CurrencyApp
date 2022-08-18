package uz.isystem.currency.moduls

abstract class BaseData {

    companion object {

        val TYPE_BOOKS = 0
        val TYPE_APPS = 1
    }

    abstract fun getType(): Int
}
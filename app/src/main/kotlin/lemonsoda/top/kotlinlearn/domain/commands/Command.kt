package lemonsoda.top.kotlinlearn.domain.commands

/**
 * Created by Chuan on 07/06/2017.
 */


interface Command<T> {
    fun execute(): T
}
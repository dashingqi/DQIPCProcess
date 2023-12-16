package com.dashingqi.fsm

/**
 * @desc : 状态的简单实现
 * @author : zhangqi
 * @time : 2023/12/16 17:22
 */
class SimpleState<T> : State<T> {
    override fun enter(owner: T) {
    }

    override fun exit(owner: T) {
    }

    override fun onMessage(owner: T, msg: Any): Boolean = false
}
package com.dashingqi.fsm

/**
 * @desc :
 * @author : zhangqi
 * @time : 2023/12/16 16:56
 */
class StateMachine<T>(
    /** 状态拥有者*/
    private val owner: T
) {

    /**
     * 当前状态
     */
    var curState: State<T>? = null
        private set

    /**
     * 之前所处于状态
     */
    var preState: State<T>? = null
        private set

    /**
     * 全局状态处理器（兜底状态）
     */
    var globalState: State<T>? = null

    /**
     * 处理消息
     * 优先级为：curState > globalState
     * @return default:false 消息是否被处理
     */
    fun handleMessage(msg: Any): Boolean {
        if (curState?.onMessage(owner, msg) == true) {
            return true
        }

        if (globalState?.onMessage(owner, msg) == true) {
            return true
        }

        return false
    }

    /**
     * 改变状态（用于状态的流转）
     * @param newState 新状态
     */
    fun changeState(newState: State<T>) {
        preState = curState
        curState?.exit(owner)
        curState = newState
        curState?.enter(owner)
    }

    /**
     * 状态反转到之前状态
     */
    fun revertToPreState() {
      preState?.let { changeState(it) }
    }
}
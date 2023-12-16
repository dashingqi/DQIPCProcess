package com.dashingqi.fsm

/**
 * @desc : 状态接口
 * @author : zhangqi
 * @time : 2023/12/16 16:48
 */
interface State<in T> {

    /**
     * 状态进入的回调
     * @param owner:T 状态进入的owner
     */
    fun enter(owner: T)


    /**
     * 状态退出的回调
     * @param owner:T 状态退出的owner
     */
    fun exit(owner: T)

    /**
     * 处理消息的回调
     * @param owner:T 处于当前状态 owner
     * @param msg:Any 消息
     * @return 是否处理了消息
     */
    fun onMessage(owner: T, msg: Any): Boolean


}
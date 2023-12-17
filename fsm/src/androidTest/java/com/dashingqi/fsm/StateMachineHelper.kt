package com.dashingqi.fsm

/**
 * @desc :
 * @author : zhangqi
 * @time : 2023/12/17 16:53
 */

class StateOneMsgOne : State<Any> {
    override fun enter(owner: Any) {
    }

    override fun exit(owner: Any) {
    }

    override fun onMessage(owner: Any, msg: Any): Boolean = (msg == 1)

}

class StateTwoMsgTwo : State<Any> {
    override fun enter(owner: Any) {
    }

    override fun exit(owner: Any) {
    }

    override fun onMessage(owner: Any, msg: Any): Boolean = (msg == 2)

}


class StateThreeNoMsg : State<Any> {
    override fun enter(owner: Any) {
    }

    override fun exit(owner: Any) {
    }

    override fun onMessage(owner: Any, msg: Any): Boolean = false

}
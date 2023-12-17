package com.dashingqi.fsm

import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertFalse
import junit.framework.TestCase.assertNotNull
import junit.framework.TestCase.assertNull
import junit.framework.TestCase.assertTrue
import org.junit.After
import org.junit.Before
import org.junit.Test

/**
 * @desc : 【StateMachine】方法的单元测试；
 * @author : zhangqi
 * @time : 2023/12/17 16:49
 */
class StateMachineTest {

    /** 有限状态机的 owner*/
    private val owner: String = "stateMachineOwner"

    /** 有限状态机实例*/
    private lateinit var fsm: StateMachine<Any>

    /** 状态 one*/
    private lateinit var stateOneMsgOne: StateOneMsgOne

    /** 状态 Two*/
    private lateinit var stateTwoMsgTwo: StateTwoMsgTwo

    /** 状态 Three*/
    private lateinit var stateThreeNoMsg: StateThreeNoMsg


    @Before
    fun beforeStateMachine() {
        fsm = StateMachine(owner)
        stateOneMsgOne = StateOneMsgOne()
        stateTwoMsgTwo = StateTwoMsgTwo()
        stateThreeNoMsg = StateThreeNoMsg()
    }

    /** 测试初始状态为 null*/
    @Test
    fun currentState_InitFsm_ISNull() {
        assertNull(fsm.curState)
    }

    /** 测试有限状态机当前状态更随 changeState()方法变化*/
    @Test
    fun currentState_ChangeState_ISNotNUll() {
        fsm.changeState(stateOneMsgOne)
        assertNotNull(fsm.curState)
        assertEquals(fsm.curState, stateOneMsgOne)
    }

    /** 有限状态机初始化时 preState 为 null*/
    @Test
    fun preState_InitFsm_IsNull() {
        assertNull(fsm.preState)
    }

    /** 执行一次 ChangeState()方法 preState为null*/
    @Test
    fun preState_ChangeState_IsNull() {
        fsm.changeState(stateOneMsgOne)
        assertNull(fsm.preState)
    }

    /**
     * 执行多次 changeState()方法 preState 为倒数第二次的 State
     */
    @Test
    fun preState_ChangeStateMultiTime_IsRight() {
        fsm.changeState(stateOneMsgOne)
        fsm.changeState(stateTwoMsgTwo)
        fsm.changeState(stateThreeNoMsg)
        assertEquals(fsm.preState, stateTwoMsgTwo)
    }

    /**
     * 有限状态机初始化时，globalState 为 null
     */
    @Test
    fun globalState_InitFsm_IsNull() {
        assertNull(fsm.globalState)
    }

    /** globalState 的正确性*/
    @Test
    fun globalState_Set_IsRight() {
        fsm.globalState = stateOneMsgOne
        assertEquals(fsm.globalState, stateOneMsgOne)
    }

    /**
     * 测试当前状态机状态是否为指定状态【State】
     */
    @Test
    fun isInState_State_IsRight() {
        fsm.changeState(stateOneMsgOne)
        assertFalse(fsm.isAssignState(stateTwoMsgTwo))
    }

    @Test
    fun isInState_Class_IsRight() {
        fsm.changeState(stateOneMsgOne)
        assertTrue(fsm.isAssignState(stateOneMsgOne.javaClass))
    }

    @After
    fun afterStateMachine() {
        fsm.changeState(SimpleState())

    }
}
package com.codelab.basiclayouts.feature_group

import android.os.Parcelable
import androidx.annotation.DrawableRes
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.toMutableStateList
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.codelab.basiclayouts.R
import com.codelab.basiclayouts.core.domain.use_case.AccountingUseCases
import com.codelab.basiclayouts.feature_group.group_create.UserData
import com.codelab.basiclayouts.feature_group.group_create.ownedMonsterList
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.android.parcel.Parcelize
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class GroupViewModel @Inject constructor(
    private val accountingUseCases: AccountingUseCases
) : ViewModel() {
    var hatchProgress: Float by mutableStateOf(0f)
    var readyToHatch: Boolean by mutableStateOf(false)

    private val _groupsList = getGroupsList().toMutableStateList()
    val groupList: List<String>
        get() = _groupsList

    private val _memberDataList = getMemberList().toMutableStateList()
    val memberDataList: List<UserData>
        get() = _memberDataList

    private var _newHatchedMonster = getMyCollection().toMutableStateList()
    val newHatchedMonster: MonsterData
        get() = _newHatchedMonster.last()

    private val _monstersInPark = getMonstersInPark().toMutableStateList()
    val monstersInPark: List<MonsterData>
        get() = _monstersInPark

    private val _groupTaskList = getGroupTaskList().toMutableStateList()
    val groupTaskList: List<TaskData>
        get() = _groupTaskList


    fun remind(userData: UserData){}

    fun hatch(){}

    //點入任務頁面時更新
    fun updateTasks(){}

    //進入群組時更新, readyToHatch也要更新
    fun updateHatchProgress(){}

    fun addCard(id: Int){
        viewModelScope.launch {
            accountingUseCases.changeCardStatus(id)
        }
    }
}

private fun getMyCollection(): List<MonsterData> {
    return ownedMonsterList
}

private fun getMonstersInPark(): List<MonsterData> {
    return monstersInParkList
}

private fun getGroupTaskList(): List<TaskData> {
    return taskList
}

private fun getMemberList(): List<UserData>{
    return memberDataList
}

private fun getGroupsList(): List<String> {
    return groupNames
}

private val groupNames = listOf(
    "GroupA", "GroupB", "GroupC", "GroupD"
)

@Parcelize
data class MonsterData(
    @DrawableRes val picture: Int,
    val name: String
): Parcelable

val monstersInParkList = listOf<MonsterData>(
    MonsterData(R.drawable.monster_1, "monster_1"),
    MonsterData(R.drawable.monster_2, "monster_2"),
    MonsterData(R.drawable.monster_3, "monster_3"),
    MonsterData(R.drawable.monster_4, "monster_4")
)

data class TaskData(
    val description: String,
    val award: Float,
    val progress: Float
)

val taskList = listOf(
    TaskData("所有群組成員連續記帳三天", 0.1f, 0.75f),
    TaskData("吃早餐了沒? 集滿10次早餐紀錄", 0.15f, 0.5f),
    TaskData("有錢人的煩惱 - 集滿3筆上千元消費", 0.1f, 0.8f),
    TaskData("努力又孝順的孩子 - 集滿5筆打工紀錄", 0.1f, 0.15f),
    TaskData("記帳鬧鐘 - 累計100次記帳提醒", 0.05f, 0.9f)
)

val memberDataList = listOf(
    UserData(
        profile = R.drawable.member_1,
        name = "Wu Shang Hong",
        completedTasksNum = 56,
        ownedMonsters = ownedMonsterList
    ),
    UserData(
        profile = R.drawable.member_2,
        name = "Sophia",
        completedTasksNum = 40,
        ownedMonsters = ownedMonsterList
    ),
    UserData(
        profile = R.drawable.member_3,
        name = "Lucy",
        completedTasksNum = 31,
        ownedMonsters = ownedMonsterList
    ),
    UserData(
        profile = R.drawable.member_4,
        name = "Alice",
        completedTasksNum = 23,
        ownedMonsters = ownedMonsterList
    ),
    UserData(
        profile = R.drawable.member_5,
        name = "Christen",
        completedTasksNum = 12,
        ownedMonsters = ownedMonsterList
    )
)
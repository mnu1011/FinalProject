package com.codelab.basiclayouts.core.domain.repository

import com.codelab.basiclayouts.core.data.*
import com.codelab.basiclayouts.feature_account.domain.model.FilterOption
import kotlinx.coroutines.flow.Flow

interface AccountingRepository {


    // 初始畫面用到的
    suspend fun addCard(userCard: UserCard)

    suspend fun addAccount(userAccount: UserAccount)

    fun getUserAccount():Flow<List<UserAccount>>

    // 主畫面用到的
    fun getCardsList(): Flow<List<UserCard>>

    fun getFriendsList(): Flow<List<UserFriend>>

    // 群組頁面用到的
    fun getGroupsList(): Flow<List<UserGroup>>


    suspend fun changeCardStatus(cardId: Int)
    // setGroupList 從遠端更新群組

    // 記帳頁面用到的
    suspend fun addRecord(userRecord: UserRecord)

    // 紀錄頁面用到的

    fun getRecordByDate(date: String): Flow<List<UserRecord>>

    fun getRecordByName(name: String): Flow<List<UserRecord>>

    fun getRecordByOption(filterOption: FilterOption): Flow<List<UserRecord>>

    // 圖表頁面用到的
    fun getRecordByTimeInterval(timeInterval: String): Flow<List<UserRecord>>

}
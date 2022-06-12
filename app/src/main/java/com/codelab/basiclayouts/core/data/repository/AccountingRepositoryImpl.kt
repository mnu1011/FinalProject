package com.codelab.basiclayouts.core.data.repository

import com.codelab.basiclayouts.core.data.*
import com.codelab.basiclayouts.core.data.data_source.AccountingDao
import com.codelab.basiclayouts.core.domain.repository.AccountingRepository
import com.codelab.basiclayouts.feature_account.domain.model.FilterOption
import kotlinx.coroutines.flow.Flow

class AccountingRepositoryImpl(
    private val dao: AccountingDao
) : AccountingRepository {
    override suspend fun addCard(userCard: UserCard) {
        dao.addCard(userCard)
    }

    override suspend fun addAccount(userAccount: UserAccount) {
        dao.addAccount(userAccount)
    }

    override fun getUserAccount(): Flow<List<UserAccount>> {
        return dao.getUserAccount()
    }

    override fun getCardsList(): Flow<List<UserCard>> {
        return dao.getCardsList()
    }

    override fun getFriendsList(): Flow<List<UserFriend>> {
        return dao.getFriendsList()
    }

    override fun getGroupsList(): Flow<List<UserGroup>> {
        return dao.getGroupsList()
    }

    override suspend fun changeCardStatus(cardId: Int) {
        dao.changeCardStatus(cardId)
    }


    override suspend fun addRecord(userRecord: UserRecord) {
        dao.addRecord(userRecord)
    }


    override fun getRecordByDate(date: String): Flow<List<UserRecord>> {
        return dao.getRecordByDate(date)
    }

    override fun getRecordByName(name: String): Flow<List<UserRecord>> {
        return dao.getRecordByName(name)
    }

    override fun getRecordByOption(filterOption: FilterOption): Flow<List<UserRecord>> {
        return dao.getAllRecords()
    }

    override fun getRecordByTimeInterval(timeInterval: String): Flow<List<UserRecord>> {
        return dao.getAllRecords()
    }



}
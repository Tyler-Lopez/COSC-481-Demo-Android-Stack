package com.example.demoapp.domain.usecase

import com.example.demoapp.domain.entities.User
import com.example.demoapp.utils.Resource
import com.example.demoapp.utils.constants.FirestoreConstants.USERS_COLLECTION_NAME
import com.example.demoapp.utils.constants.FirestoreConstants.USERS_COLLECTION_NAME_KEY
import com.google.firebase.firestore.CollectionReference
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

class GetUsersUseCase @Inject constructor(
    private val usersCollectionReference: CollectionReference
) {
    suspend operator fun invoke(): Resource<List<User>> {
        return try {
            Resource.Success(
                usersCollectionReference
                    .get()
                    .await()
                    .documents
                    .map {
                        object : User {
                            override val name: String = it[USERS_COLLECTION_NAME_KEY] as String
                        }
                    })
        } catch (e: Exception) {
            Resource.Error()
        }
    }
}
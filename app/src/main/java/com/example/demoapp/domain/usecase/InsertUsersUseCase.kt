package com.example.demoapp.domain.usecase

import com.example.demoapp.utils.constants.FirestoreConstants.USERS_COLLECTION_NAME_KEY
import com.google.firebase.firestore.CollectionReference
import javax.inject.Inject

class InsertUsersUseCase @Inject constructor(
    private val collectionReference: CollectionReference
) {
    suspend operator fun invoke(name: String) {
        val userDocumentData = hashMapOf(
            USERS_COLLECTION_NAME_KEY to name
        )
        collectionReference.add(userDocumentData)
    }
}
package com.example.demoapp.di

import com.example.demoapp.domain.usecase.GetUsersUseCase
import com.example.demoapp.domain.usecase.InsertUsersUseCase
import com.example.demoapp.utils.constants.FirestoreConstants.USERS_COLLECTION_NAME
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.FirebaseFirestore
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideUsersCollection() =
        FirebaseFirestore.getInstance().collection(USERS_COLLECTION_NAME)

    @Provides
    fun provideGetUsersUseCase(collectionReference: CollectionReference) =
        GetUsersUseCase(collectionReference)

    @Provides
    fun provideInsertUsersUseCase(collectionReference: CollectionReference) =
        InsertUsersUseCase(collectionReference)
}
package com.example.lanecrowd.view_modal.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.foodeze.viewmodal.factory.HomeRestruVM
import com.example.lanecrowd.modal.repository.UserRepository
import com.example.lanecrowd.view_modal.*

@Suppress("UNCHECKED_CAST")
class ViewModelFactoryC(val repository: UserRepository) :
    ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        /*if (modelClass == HomeRestruVM::class.java) {
            return HomeRestruVM(repository) as T
        }*/

        throw IllegalArgumentException("Unknown_class_name")


    }


}
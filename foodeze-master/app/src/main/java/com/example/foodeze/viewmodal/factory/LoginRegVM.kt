package com.example.lanecrowd.view_modal


import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.lanecrowd.modal.repository.UserRepository
import com.google.gson.JsonObject


class LoginRegVM(val repo: UserRepository) : ViewModel() {

    var loginRegRes: MutableLiveData<JsonObject>? = null


    fun loginVM(email: String, password: String): MutableLiveData<JsonObject> {

        loginRegRes = MutableLiveData()
        loginAPi(email, password)

        return loginRegRes as MutableLiveData<JsonObject>

    }


    fun registrationVM(name: String, email: String, password: String, role: String): MutableLiveData<JsonObject> {

        loginRegRes = MutableLiveData()
        registraitonAPi(name, email, password, role)

        return loginRegRes as MutableLiveData<JsonObject>

    }

    fun forgotPasswordVM(mobile_number: String, email: String, otp: String): MutableLiveData<JsonObject> {

        loginRegRes = MutableLiveData()
        forgotPasswordAPi(mobile_number, email,otp
        )

        return loginRegRes as MutableLiveData<JsonObject>

    }

    fun changePasswordVM(mobile_number: String, email: String, new_password: String): MutableLiveData<JsonObject> {

        loginRegRes = MutableLiveData()
        changePasswordAPi(mobile_number, email,new_password)

        return loginRegRes as MutableLiveData<JsonObject>

    }


    fun loginAPi(email: String, password: String) {
        /*Coroutines.main {
            try {
                val response = repo.loginRepo(
                    email, password
                )

                loginRegRes!!.value = response

            } catch (e: Exception) {
                e.printStackTrace()
                loginRegRes?.value = null
            }
        }*/

    }

    fun registraitonAPi(name: String, email: String, password: String, role: String) {
        /*Coroutines.main {
            try {
                val response = repo.registrationRepo(
                    name, email, password, role
                )

                loginRegRes!!.value = response

            } catch (e: Exception) {
                e.printStackTrace()
                loginRegRes?.value = null
            }
        }*/

    }


  fun forgotPasswordAPi(mobile_number: String, email: String, otp: String) {
      /* println("forgotPasswordAPi"+" "+mobile_number+" "+email+" "+otp)
        Coroutines.main {
            try {
                val response = repo.forgetPasswordRepo(mobile_number, email,otp)
                loginRegRes!!.value = response

            } catch (e: Exception) {
                e.printStackTrace()
                loginRegRes?.value = null
            }
        }*/

    }

    fun changePasswordAPi(mobile_number: String, email: String, new_password: String) {
       println("changePasswordAPi"+" "+mobile_number+" "+email+" "+new_password)
        /*Coroutines.main {
            try {
                val response = repo.changePasswordRepo(mobile_number, email,new_password)
                loginRegRes!!.value = response

            } catch (e: Exception) {
                e.printStackTrace()
                loginRegRes?.value = null
            }
        }*/

    }


}

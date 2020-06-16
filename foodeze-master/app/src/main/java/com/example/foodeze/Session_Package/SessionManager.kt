package com.example.lanecrowd.Session_Package


import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import com.example.foodeze.activity.HomeActivity
import com.example.foodeze.activity.LoginFront

import java.util.*

class SessionManager(// Context
    var _context: Context
) {
    // Shared Preferences
    var pref: SharedPreferences

    // Editor for Shared preferences
    var editor: SharedPreferences.Editor

    // Shared pref mode
    var PRIVATE_MODE = 0

    /**
     * Create login session
     */
    fun createLoginSession(
        userId: String?,
        name: String?,
        email: String?,
        role: String?
    ) {

        editor.putBoolean(
            IS_LOGIN,
            true
        )
        editor.putString(
            KEY_USERID,
            userId
        )
        editor.putString(
            KEY_FULL_NAME,
            name
        )
        editor.putString(
            KEY_EMAIL,
            email
        )
        editor.putString(
            KEY_Role,
            role
        )


        // commit changes
        editor.commit()
    }


    /**
     * Check login method wil check user login status
     * If false it will redirect user to login page
     * Else won't do anything
     */
    fun checkLogin() { // Check login status
        if (isLoggedIn) {



            var i =  Intent(_context, HomeActivity::class.java)
            // Closing all the Activities
            i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            // Add new Flag to start new Activity
            i.flags = Intent.FLAG_ACTIVITY_NEW_TASK
            // Staring Login Activity
            _context.startActivity(i)
        }
    }

    // return user
    val userDetails: HashMap<String, String?>
        get() {
            val user =
                HashMap<String, String?>()
            user[KEY_USERID] = pref.getString(
                KEY_USERID,
                ""
            )
            user[KEY_FULL_NAME] = pref.getString(
                KEY_FULL_NAME,
                ""
            )
            user[KEY_EMAIL] = pref.getString(
                KEY_EMAIL,
                ""
            )

            user[KEY_MOBILE] = pref.getString(
                KEY_MOBILE,
                ""
            )
            user[KEY_MOBILE] = pref.getString(
                KEY_Role,
                ""
            )

            // return user
            return user
        }

    /**
     * Clear session details
     */
    fun logoutUser() { // Clearing all data from Shared Preferences
        editor.clear()
        editor.commit()
        // After logout redirect user to Loing Activity
        val i = Intent(_context, LoginFront::class.java)
        // Closing all the Activities
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        // Add new Flag to start new Activity
        i.flags = Intent.FLAG_ACTIVITY_NEW_TASK
        // Staring Login Activity
        _context.startActivity(i)
    }

    /**
     * Quick check for login
     */
// Get Login State
    val isLoggedIn: Boolean
        get() = pref.getBoolean(
            IS_LOGIN,
            false
        )

    companion object {
        // Sharedpref file name
        private const val PREF_NAME = "dept"

        // All Shared Preferences Keys
        private const val IS_LOGIN = "IsLoggedIn"
        const val KEY_USERID = "id"
        const val KEY_FULL_NAME = "full_name"
        const val KEY_EMAIL = "email"
        const val KEY_MOBILE = "mobile"
        const val KEY_Role = "role"
    }

    // Constructor
    init {
        pref = _context.getSharedPreferences(
            PREF_NAME,
            PRIVATE_MODE
        )
        editor = pref.edit()
    }
}
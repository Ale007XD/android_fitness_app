
package com.fitnessapp.data

import com.fitnessapp.data.model.User

class UserRepository {
    // This would typically interact with a local database (Room) or a remote server
    // For now, we'll use a placeholder.
    private var currentUser: User? = null

    fun getCurrentUser(): User? {
        return currentUser
    }

    fun saveUser(user: User) {
        currentUser = user
    }

    fun clearUser() {
        currentUser = null
    }
}


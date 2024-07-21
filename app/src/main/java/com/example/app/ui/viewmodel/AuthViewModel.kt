
package com.example.app.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import com.example.app.data.repository.AuthRepository

class AuthViewModel(private val authRepository: AuthRepository) : ViewModel() {
    // Authentication logic
}

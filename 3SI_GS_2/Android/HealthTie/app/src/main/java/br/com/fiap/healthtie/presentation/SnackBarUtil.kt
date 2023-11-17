package br.com.fiap.healthtie.presentation

import android.view.View
import com.google.android.material.snackbar.Snackbar

object SnackBarUtil {

    fun showSnackBar(view: View, message: String){
        Snackbar.make(view, message,Snackbar.LENGTH_SHORT).show()
    }
}
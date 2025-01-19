package com.abaza_vg.binlist.presentation

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModelProvider
import com.abaza_vg.binlist.presentation.ui.theme.BinlistTheme
import javax.inject.Inject


class MainActivity : ComponentActivity() {

    private lateinit var viewModel: MainViewModel

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private val component by lazy {
        (application as CardInfoApp).component
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        component.inject(this)
        super.onCreate(savedInstanceState)

        viewModel = ViewModelProvider(this, viewModelFactory)[MainViewModel::class.java]
        setViewModelObservers()
        enableEdgeToEdge()
        setContent {
            BinlistTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize()
                ) {
                    Column(Modifier.padding(it)) {
                        Drawer(viewModel)
                    }
                }
            }
        }
    }

    private fun setViewModelObservers() {
        viewModel.cardInfo.observe(this) {
            viewModel.saveCardInfoToHistory()
        }

        viewModel.requestError.observe(this) {
            viewModel.requestError.value?.let {
                Toast.makeText(this, "Request error: ${it.message}", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
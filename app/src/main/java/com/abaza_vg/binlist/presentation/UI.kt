package com.abaza_vg.binlist.presentation

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.material3.Card
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.rememberDrawerState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import com.abaza_vg.binlist.domain.CardInfo


@Composable
fun CardInfoMain(viewModel: MainViewModel) {

    val cardInfo = viewModel.cardInfo.observeAsState()
    cardInfo.value?.let {
        CardInfo(it)
    }
}

@Composable
fun CardInfo(cardInfo: CardInfo) {
    Card() {
        val context = LocalContext.current
        Column(modifier = Modifier.padding(4.dp)) {
            Text(text = "Scheme/Network:", fontWeight = FontWeight.ExtraBold)
            cardInfo.scheme?.let { Text(text = it) }
            Text(text = "Brand:", fontWeight = FontWeight.ExtraBold)
            cardInfo.brand?.let { Text(text = it) }
            Text(text = "Card number:", fontWeight = FontWeight.ExtraBold)
            Row(Modifier) {
                Text(text = "Length:", fontWeight = FontWeight.Bold)
                Spacer(modifier = Modifier.width(2.dp))
                cardInfo.number?.length.let { Text(text = it.toString()) }
            }
            Row {
                Text(text = "Luhn:", fontWeight = FontWeight.Bold)
                Spacer(modifier = Modifier.width(2.dp))
                cardInfo.number?.luhn.let { Text(text = it.toString()) }
            }
            Text(text = "Type:", fontWeight = FontWeight.ExtraBold)
            cardInfo.type?.let { Text(text = it) }
            Text(text = "Prepaid:", fontWeight = FontWeight.ExtraBold)
            Text(text = cardInfo.prepaid.toString())
            Text(text = "Country:", fontWeight = FontWeight.ExtraBold)
            Row {
                cardInfo.country?.name?.let { Text(text = it) }
                Spacer(modifier = Modifier.width(2.dp))
                cardInfo.country?.currency?.let { Text(text = it) }
                Spacer(modifier = Modifier.width(2.dp))
                cardInfo.country?.emoji?.let { Text(text = it) }
            }
            Text(text = "(latitude: ${cardInfo.country?.latitude}, longitude: ${cardInfo.country?.longitude})")
            Text(text = "Bank:", fontWeight = FontWeight.ExtraBold)
            cardInfo.bank?.name?.let { Text(text = it) }
            cardInfo.bank?.url?.let {
                Text(
                    modifier = Modifier.clickable {
                        val uri = Uri.parse(it)
                        val intent = Intent(Intent.ACTION_VIEW, uri)
                        context.startActivity(intent)
                    },
                    text = it,
                    color = MaterialTheme.colorScheme.primary,
                    textDecoration = TextDecoration.Underline
                )
            }
            cardInfo.bank?.phone?.let { Text(text = it) }
        }
    }
}

@Composable
fun SearchBar(viewModel: MainViewModel) {
    Row {
        TextField(
            singleLine = true,
            value = viewModel.bin,
            onValueChange = { viewModel.updateBin(it) },
            label = { Text("BIN") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
        Button(
            onClick = { viewModel.getCardInfo(viewModel.bin) },
            content = { Text(text = "Search") })
    }
}

@Composable
fun Drawer(viewModel: MainViewModel) {
    val drawerState = rememberDrawerState(DrawerValue.Closed)
    val cardInfoHistory = viewModel.cardInfoHistory.observeAsState()
    val history = cardInfoHistory.value
    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet(drawerState) {
                Column(Modifier.verticalScroll(rememberScrollState())) {
                    history?.forEach { item ->
                        CardInfo(item)
                        Spacer(Modifier.height(5.dp))
                    }
                }
            }
        },
        content = {
            Column() {
                SearchBar(viewModel)
                CardInfoMain(viewModel)
                Text(">>>Swipe to get history>>>")
            }
        },
    )
}



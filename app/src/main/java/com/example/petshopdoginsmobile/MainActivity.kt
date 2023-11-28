package com.example.petshopdoginsmobile

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.lifecycleScope
import com.example.petshopdoginsmobile.model.entities.Product
import com.example.petshopdoginsmobile.model.entities.Update
import com.example.petshopdoginsmobile.model.retrofit.ApiClient
import com.example.petshopdoginsmobile.ui.theme.PetshopDoginsMobileTheme
import com.practice.offlinecaching.ProductRepository
import kotlinx.coroutines.launch
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PetshopDoginsMobileTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MyScreenContent()
                }
            }
        }
    }

    @Composable
    fun ProductComposable(product: Product) {
        Card(
            modifier = Modifier.padding(16.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Text(text = product.productName ?: "", style = MaterialTheme.typography.bodyLarge)
                Text(text = "Preço: ${product.productPrice ?: 0.0}")
                Text(text = "Estoque: ${product.productStock ?: 0}")
                // Adicione mais campos conforme necessário
            }
        }
    }

    @Composable
    fun MyScreenContent() {



// ------------------- FIND by ID ----------------------
//        Button(onClick = {
//            val call = ApiClient.apiService.findAll()
//
//            call.enqueue(object : Callback<List<Product>> {
//                override fun onResponse(call: Call<Product>, response: Response<Product>) {
//                    if (response.isSuccessful) {
//                        val resBody = response.body()
//                        Log.i("Respsta", resBody!!.brandName)
//                    } else {
//                        val error = response.errorBody()
//                        Log.i("Erro", error.toString())
//                    }
//                }
//
//                override fun onFailure(call: Call<Product>, t: Throwable) {
//                    Log.i("Catch ERRO", t.message ?: "Unknown error")
//                }
//            })
//        }) {
//            Text(text = "Botao")
//        }



// ---------------------- FIND ALL ----------------------
//        Button(onClick = {
//            val call = ApiClient.apiService.findAll()
//
//            call.enqueue(object : Callback<List<Product>> {
//                override fun onResponse(call: Call<List<Product>>, response: Response<List<Product>>) {
//                    if (response.isSuccessful) {
//                        val resBody = response.body()
//                        Log.i("Respsta", resBody.toString())
//                    } else {
//                        val error = response.errorBody()
//                        Log.i("Erro", error.toString())
//                    }
//                }
//
//                override fun onFailure(call: Call<List<Product>>, t: Throwable) {
//                    Log.i("Catch ERRO", t.message ?: "Unknown error")
//                }
//            })
//        }) {
//            Text(text = "Botao")
//        }



//   ----------------- GET QUANTITY BY ID ------------------
        //should return int
//        Button(onClick = {
//            val id = "6435f268f8ac63da19379255"
//            val call = ApiClient.apiService.getProductQuantity(id)
//
//            call.enqueue(object : Callback<Int> {
//                override fun onResponse(call: Call<Int>, response: Response<Int>) {
//                    if (response.isSuccessful) {
//                        Log.i("Respsta", response.toString())
//                    } else {
//                        val error = response.errorBody()
//                        Log.i("Erro", error.toString())
//                    }
//                }
//
//                override fun onFailure(call: Call<Int>, t: Throwable) {
//                    Log.i("Catch ERRO", t.message ?: "Unknown error")
//                }
//            })
//        }) {
//            Text(text = "Botao")
//        }



//        Button(onClick = {
//            val id = "6435f268f8ac63da19379255"
//            val call = ApiClient.apiService.getProductQuantity(id)
//
//            call.enqueue(object : Callback<Int> {
//                override fun onResponse(call: Call<Int>, response: Response<Int>) {
//                    if (response.isSuccessful) {
//                        Log.i("Respsta", response.toString())
//                    } else {
//                        val error = response.errorBody()
//                        Log.i("Erro", error.toString())
//                    }
//                }
//
//                override fun onFailure(call: Call<Int>, t: Throwable) {
//                    Log.i("Catch ERRO", t.message ?: "Unknown error")
//                }
//            })
//        }) {
//            Text(text = "Botao")
//        }




// -------------------- UPDATE --------------------
// not working yet

        val listProduto = listOf(
            Update(id = "6435f268f8ac63da19379255", productStock = "3"),
            Update(id = "6435f3cbf8ac63da19379256", productStock = "44"))

        val call = ApiClient.apiService.updateProductFields(
            fields = listProduto
        )


        //Junior deve aplicar para mapear lista de produtos do carrinho para lista com 2 fields
        //val listProduct = listProduto.map { listaCarrinho-> Update(listaCarrinho.id,listaCarrinho.productStock ) }


//        Button(onClick = {
//            val call = ApiClient.apiService.updateProductFields(listProduto)
//
//            call.enqueue(object : Callback<ResponseBody> {
//                override fun onResponse(
//                    call: Call<ResponseBody>,
//                    response: Response<ResponseBody>
//                ) {
//                    if (response.isSuccessful) {
//                        val resBody = response.body()
//                        Log.i("Respsta", resBody.toString())
//                    } else {
//                        val error = response.errorBody()
//                        Log.i("Erro bo body", error.toString())
//                    }
//                }
//
//                override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
//                    Log.i("Catch ERRO na call", t.message ?: "Unknown error")
//                }
//            })
//        }) {
//            Text(text = "Botao")
//        }
    }
}

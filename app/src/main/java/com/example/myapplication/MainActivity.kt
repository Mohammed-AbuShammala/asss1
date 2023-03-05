package com.example.myapplication

import android.app.ProgressDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatDelegate
import com.example.myapplication.databinding.ActivityMainBinding
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {
    private  lateinit var binding:ActivityMainBinding
lateinit var delege: ProgressDialog
companion object {
        lateinit var  data: ArrayList<UserData>

}
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        delege= ProgressDialog(this)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding .root)

        data = ArrayList<UserData>()


        val db =
            Firebase.firestore
        var i = Intent(this, UserList::class.java)
        binding.button.setOnClickListener {
delege.show()

    val user = hashMapOf(
        "name" to binding.name.text.toString(),
        "phone" to binding.phoneNumber.text.toString(),
        "address" to binding.address.text.toString()
    )
    db.collection("users")
        .add(user)
        .addOnSuccessListener { documentReference ->
            delege.dismiss()

            Toast.makeText(this, "yes", Toast.LENGTH_SHORT).show()
            println("succeed")
        }
        .addOnFailureListener { e ->
            println("Failed")
        }

        }
binding.button2.setOnClickListener{
    startActivity(i)

}

    }
}
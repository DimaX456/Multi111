package com.example.multi1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.result.ActivityResult
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import com.example.multi1.databinding.ActivityMainBinding
import com.example.multi1.databinding.ActivityPageTwoBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private var launcher: ActivityResultLauncher<Intent>? = null

//    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        launcher =
            registerForActivityResult(ActivityResultContracts.StartActivityForResult()){result: ActivityResult ->
                if (result.resultCode == RESULT_OK)
                {
                    val myText = result.data?.getStringExtra("twoName")
                    binding.txtViewFullName.text = "${binding.editTxtPersonaName.text}$myText"
                }
            }

    }

    fun btnClickForTwo(view: View)
    {
        val myIntent = Intent(this,PageTwo::class.java)
        myIntent.putExtra("oneUser", binding.editTxtPersonaName.text.toString())
        launcher?.launch(myIntent)
    }
}
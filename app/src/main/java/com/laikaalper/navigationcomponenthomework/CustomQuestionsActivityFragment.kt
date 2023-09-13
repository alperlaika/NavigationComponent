package com.laikaalper.navigationcomponenthomework

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.laikaalper.navigationcomponenthomework.databinding.FragmentCustomQuestionsActivityBinding
import com.laikaalper.navigationcomponenthomework.data.model.CustomInfo
import com.laikaalper.navigationcomponenthomework.data.model.PersonalInfo


class CustomQuestionsActivityFragment : Fragment() {
private lateinit var design:FragmentCustomQuestionsActivityBinding
    private val args by navArgs<CustomQuestionsActivityFragmentArgs>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        design = FragmentCustomQuestionsActivityBinding.inflate(inflater, container, false)

        with(design) {
            textViewName.text = args.personalInfo.name

            buttonNext.setOnClickListener {

                    val age = editTextQuestion1.text.toString()
                    val school = editTextQuestion2.text.toString()
                    val gender = editTextQuestion3.text.toString()

                if (editTextQuestion1.validateText()&&editTextQuestion2.validateText1()&&editTextQuestion3.text.isNotEmpty()){

                    val info = CustomInfo(args.personalInfo, age, school, gender)
                val action = CustomQuestionsActivityFragmentDirections.resultTransion(info)
                findNavController().navigate(action)

            }

            }
            return design.root
        }
    }
    fun EditText.validateText():Boolean{


        if (text.isNotEmpty()) {

                error = null
                return  true


        } else {
            error = "Yaşınızı Doğru yazınız"
            return false
        }
    }
    fun EditText.validateText1():Boolean{

        val textPattern = "^[a-zA-Z]+ [a-zA-Z]+$"

        if (text.isNotEmpty()) {
            if (text.toString().matches(textPattern.toRegex())) {
                error = null
                return  true
            }
            error = "Okulunuzun Adını Doğru yazınız"
            return false
        } else {
            error = "Okul İsim Alanını Doldurunuz"
            return false
        }
    }
    fun EditText.validateText2():Boolean{

        val textPattern = "^[a-zA-Z]$"

        if (text.isNotEmpty()) {
            if (text.toString().matches(textPattern.toRegex())) {
                error = null
                return  true
            }
            error = "Cinsiyetinizi  Doğru yazınız"
            return false
        } else {
            error = "Cinsiyet Alanını Doldurunuz"
            return false
        }
    }

}
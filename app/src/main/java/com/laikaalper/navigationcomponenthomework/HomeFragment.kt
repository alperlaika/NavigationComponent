package com.laikaalper.navigationcomponenthomework

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.google.android.material.color.MaterialColors.getColor
import com.laikaalper.navigationcomponenthomework.data.model.PersonalInfo
import com.laikaalper.navigationcomponenthomework.databinding.FragmentCustomQuestionsActivityBinding
import com.laikaalper.navigationcomponenthomework.databinding.FragmentHomeBinding


class HomeFragment : Fragment(R.layout.fragment_home) {
    private lateinit var design: FragmentHomeBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        design=FragmentHomeBinding.inflate(inflater,container,false)

        design.buttonStartSurvey.setOnClickListener {

                val name = design.editTextName.text.toString()
            if (design.editTextName.validateText()){
                val action = HomeFragmentDirections.personalInfoTransition(name)

                findNavController().navigate(action)
           }

        }
        return design.root
    }

    fun EditText.validateText():Boolean{

        val textPattern = "^[a-zA-Z]+ [a-zA-Z]+$"

        if (text.isNotEmpty()) {
            if (text.toString().matches(textPattern.toRegex())) {
                error = null
                return  true
            }
            error = "İsim ve Soyisminizi Doğru yazınız"
            return false
        } else {
            error = " İsim Alanını Doldurunuz"
            return false
        }
    }

}
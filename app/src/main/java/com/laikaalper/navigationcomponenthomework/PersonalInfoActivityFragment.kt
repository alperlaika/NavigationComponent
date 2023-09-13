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
import com.laikaalper.navigationcomponenthomework.data.model.PersonalInfo
import com.laikaalper.navigationcomponenthomework.databinding.FragmentHomeBinding
import com.laikaalper.navigationcomponenthomework.databinding.FragmentPersonalInfoActivityBinding
import java.util.regex.Pattern


class PersonalInfoActivityFragment : Fragment() {

    private lateinit var design: FragmentPersonalInfoActivityBinding
    private val args by navArgs<PersonalInfoActivityFragmentArgs>()
    override fun onCreateView(inflater: LayoutInflater,container: ViewGroup?,savedInstanceState: Bundle?): View? {

        design = FragmentPersonalInfoActivityBinding.inflate(inflater, container, false)

        with(design) {
            textViewName.text = args.name

            buttonNext.setOnClickListener {

                val email = editTextEmail.text.toString()
                val phone = editTextPhone.text.toString()
                if (editTextEmail.validateEmail()&&editTextPhone.validateMobile()){
                            val user = PersonalInfo(args.name, email, phone)
                            val action =
                                PersonalInfoActivityFragmentDirections.customQuestionsTransion(user)
                            findNavController().navigate(action)
                        }

            }


            return root
        }
    }

    fun EditText.validateEmail():Boolean {
        val emailPattern = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+.[a-zA-Z]{2,}$"

        if (text.isNotEmpty()) {
            if (text.toString().matches(emailPattern.toRegex())) {
                error = null
                return  true
            }
            error = "Emailinizi Doğru yazınız"
            return false
        } else {
            error = "Email Alanını Doldurunuz"
            return false
        }
    }
//    fun String.validateMobile() = Pattern.compile("^905\\d{9}$").matcher(this).matches()

    fun EditText.validateMobile():Boolean {

        if (text.isNotEmpty()) {
            if (text.toString().startsWith("05") && text.toString().length == 11)     {
                error = null
                return  true
            }
            error = "Telefon Numaranızı Doğru yazınız"
            return false
        } else {
            error = "Telefon Numarası Alanını Doldurunuz"
            return false
        }
    }

}
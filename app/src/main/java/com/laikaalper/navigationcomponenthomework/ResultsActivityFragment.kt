package com.laikaalper.navigationcomponenthomework

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.laikaalper.navigationcomponenthomework.databinding.FragmentPersonalInfoActivityBinding
import com.laikaalper.navigationcomponenthomework.databinding.FragmentResultsActivityBinding


class ResultsActivityFragment : Fragment() {

    private lateinit var design: FragmentResultsActivityBinding
    private val args by navArgs<ResultsActivityFragmentArgs>()
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        design=FragmentResultsActivityBinding.inflate(inflater,container,false)

        with(design) {
            val name = args.customInfo.personalInfo.name
            val email = args.customInfo.personalInfo.email
            val phone = args.customInfo.personalInfo.phone
            val age = args.customInfo.question1
            val school = args.customInfo.question2
            val gender = args.customInfo.question3


            with(resultlayout) {
                resultName.text = "İsminiz Soyadınız :$name"
                resultEmail.text = "E-mail Adresiniz: $email"
                resultPhone.text = "Telefon Numaranız: $phone"
                ResultQuestion1.text = "Yaşınız : $age"
                ResultQuestion2.text = "Okuduğunuz Okul: $school"
                ResultQuestion3.text = "Cinsiyetiniz: $gender"
            }
        }
//        design.buttonHome.setOnClickListener {
//
//
//
//
//            //
//        }
        return design.root
    }


}
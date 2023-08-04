package com.r42914lg.mycicerone

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView

private const val ARG_TEXT = "arg_text"

class FragmentTwo : Fragment() {
    private var message: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            message = it.getString(ARG_TEXT)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_two, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<TextView>(R.id.message).text = message
        view.findViewById<Button>(R.id.btn).setOnClickListener {
            MyApp.INSTANCE.router.navigateTo(Screens.FragmentOne("Back from Fragment #2"))
        }
    }

    companion object {
        @JvmStatic
        fun newInstance(text: String) =
            FragmentTwo().apply {
                arguments = Bundle().apply {
                    putString(ARG_TEXT, text)
                }
            }
    }
}
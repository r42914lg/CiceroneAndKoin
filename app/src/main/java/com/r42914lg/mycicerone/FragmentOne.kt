package com.r42914lg.mycicerone

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView

private const val ARG_TITLE = "arg_title"

class FragmentOne : Fragment() {
    private var title: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            title = it.getString(ARG_TITLE)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_one, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<TextView>(R.id.title).text = title
        view.findViewById<Button>(R.id.btn).setOnClickListener {
            MyApp.INSTANCE.router.navigateTo(Screens.FragmentTwo("Here I am from Fragment #1"))
        }
    }

    companion object {
        @JvmStatic
        fun newInstance(title: String) =
            FragmentOne().apply {
                arguments = Bundle().apply {
                    putString(ARG_TITLE, title)
                }
            }
    }
}
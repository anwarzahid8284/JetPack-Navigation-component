package com.example.jetpacknavcomponent

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.NavArgs
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs

class SecondFragment : Fragment() {
    private lateinit var secondButton: Button
    private lateinit var messagetTextView: TextView
    private lateinit var numberTextView: TextView
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        secondButton = view.findViewById(R.id.secondFragmentBtnID)
        messagetTextView = view.findViewById(R.id.getResultTextID)
        numberTextView = view.findViewById(R.id.getNumberID)
        val navController = activity?.let { Navigation.findNavController(it, R.id.fragment) }
        numberTextView.text = requireArguments().getInt("fragmentA").toString()
        messagetTextView.text = requireArguments().getString("message")
        secondButton.setOnClickListener {

            //first method
            // it.findNavController().navigate(R.id.action_secondFragment_to_firstFragment)
            //second method
            /* val action=SecondFragmentDirections.actionSecondFragmentToFirstFragment()
             navController!!.navigate(action)*/
            // third method
            navController!!.navigate(R.id.action_secondFragment_to_firstFragment)

        }

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_second, container, false)
        return view
    }
}
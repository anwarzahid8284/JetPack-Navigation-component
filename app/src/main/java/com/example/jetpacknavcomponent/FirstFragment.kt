package com.example.jetpacknavcomponent

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs

class FirstFragment : Fragment() {
    private lateinit var firstButton: Button
    private lateinit var resutTextView: TextView
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        firstButton = view.findViewById(R.id.firstFragmentBtnID)
        resutTextView = view.findViewById(R.id.resultID)
        val navController = activity?.let { Navigation.findNavController(it, R.id.fragment) }

        firstButton.setOnClickListener {
            val bundle = Bundle()
            bundle.putString("message", "From fragment A")
            bundle.putInt("fragmentA", 1)
            //it.findNavController().navigate(R.id.action_firstFragment_to_secondFragment)
            // second method from fragamnet firt to seond fragment
            /*val action=FirstFragmentDirections.actionFirstFragmentToSecondFragment()
            navController!!.navigate(action)*/
            navController!!.navigate(R.id.action_firstFragment_to_secondFragment, bundle)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_first, container, false)
        return view
    }
}
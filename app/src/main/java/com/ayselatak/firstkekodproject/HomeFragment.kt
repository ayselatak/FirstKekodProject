package com.ayselatak.firstkekodproject

import android.icu.text.CaseMap.Title
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.Menu
import android.view.View
import android.view.ViewGroup
import android.widget.CompoundButton
import android.widget.Toast
import androidx.core.view.size
import com.ayselatak.firstkekodproject.databinding.FragmentHomeBinding


class HomeFragment : Fragment(R.layout.fragment_home) {

    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val menu = (activity as MainActivity).menu



        binding.switchEgo.setOnCheckedChangeListener { _, isChecked ->
            (activity as? MainActivity)?.setBottomNavigationVisibility(!isChecked)
            if (isChecked) {

                menu.removeItem(R.id.happinessFragment)
                menu.removeItem(R.id.optimismFragment)
                menu.removeItem(R.id.givingFragment)
                menu.removeItem(R.id.kindnessFragment)
                menu.removeItem(R.id.respectFragment)

                with(binding) {
                    switchHappiness.isEnabled = false
                    switchOptimism.isEnabled = false
                    switchKindness.isEnabled = false
                    switchGiving.isEnabled = false
                    switchRespect.isEnabled = false

                    switchHappiness.isChecked = false
                    switchOptimism.isChecked = false
                    switchKindness.isChecked = false
                    switchGiving.isChecked = false
                    switchRespect.isChecked = false
                }
            } else {


                binding.switchHappiness.isEnabled = true
                binding.switchOptimism.isEnabled = true
                binding.switchKindness.isEnabled = true
                binding.switchGiving.isEnabled = true
                binding.switchRespect.isEnabled = true
            }


        }


        binding.switchHappiness.setOnCheckedChangeListener { _, isChecked ->

            clickItems(
                menu,
                isChecked,
                R.id.happinessFragment,
                "Happiness",
                R.drawable.ic_happiness,
            )


        }

        binding.switchOptimism.setOnCheckedChangeListener { _, isChecked ->

            clickItems(
                menu, isChecked,
                R.id.optimismFragment,
                "Optimism",
                R.drawable.ic_optimism
            )


        }

        binding.switchGiving.setOnCheckedChangeListener { _, isChecked ->

            clickItems(
                menu,
                isChecked,
                R.id.givingFragment,
                "Giving",
                R.drawable.ic_giving,
            )
        }

        binding.switchKindness.setOnCheckedChangeListener { _, isChecked ->

            clickItems(
                menu,
                isChecked,
                R.id.kindnessFragment,
                "Kindness",
                R.drawable.ic_kindness,
            )


        }

        binding.switchRespect.setOnCheckedChangeListener { _, isChecked ->

            clickItems(
                menu,
                isChecked,
                R.id.respectFragment,
                "Respect",
                R.drawable.ic_respect,

                )


        }

    }

    fun clickItems(
        menu: Menu,
        isChecked: Boolean,
        fragmentId: Int,
        title: String,
        bottomIcon: Int,

        ) {

        if (menu.size <= 4 && isChecked && menu.findItem(fragmentId) == null) {
            menu.add(Menu.NONE, fragmentId, Menu.NONE, title)
                ?.setIcon(bottomIcon)
        } else if (!isChecked && menu.findItem(fragmentId) != null) {
            menu.removeItem(fragmentId)
        }

    }


}

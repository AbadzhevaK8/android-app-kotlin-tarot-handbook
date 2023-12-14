package com.k8abadzheva.tarothandbook.ui

import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AppCompatDelegate
import androidx.appcompat.widget.SwitchCompat
import androidx.fragment.app.Fragment
import com.k8abadzheva.tarothandbook.R

class SettingsFragment : Fragment() {

    private lateinit var themeSwitch: SwitchCompat
    private lateinit var languageSpinner: Spinner
    private lateinit var sharedPreferences: SharedPreferences

    private fun showToast(message: String) {
        val toast = Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT)
        toast.show()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_settings, container, false)

        themeSwitch = view.findViewById(R.id.themeSwitch)
        languageSpinner = view.findViewById(R.id.languageSpinner)

        // Инициализация SharedPreferences
        sharedPreferences = requireActivity().getSharedPreferences("Settings", 0)

        // Установка текущих значений настроек
        themeSwitch.isChecked = sharedPreferences.getBoolean("darkTheme", false)
        languageSpinner.setSelection(sharedPreferences.getInt("selectedLanguage", 0))

        // Проверяем текущую тему и устанавливаем switch
        val currentNightMode = AppCompatDelegate.getDefaultNightMode()
        themeSwitch.isChecked = currentNightMode == AppCompatDelegate.MODE_NIGHT_YES

        // Настройка адаптера для Spinner
        val adapter = ArrayAdapter.createFromResource(
            requireContext(),
            R.array.languages,
            android.R.layout.simple_spinner_item
        )
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        languageSpinner.adapter = adapter

        // Устанавливаем слушатель для Switch
        themeSwitch.setOnCheckedChangeListener { _, isChecked ->
            //sharedPreferences.edit().putBoolean("darkTheme", isChecked).apply()

            // Устанавливаем режим ночной темы в соответствии с isChecked
            AppCompatDelegate.setDefaultNightMode(if (isChecked) AppCompatDelegate.MODE_NIGHT_YES else AppCompatDelegate.MODE_NIGHT_NO)

            // Пересоздаем активити для применения новой темы
            requireActivity().recreate()
        }

//        // Устанавливаем слушатель для Spinner
//        languageSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
//            override fun onItemSelected(
//                parent: AdapterView<*>?,
//                view: View?,
//                position: Int,
//                id: Long
//            ) {
//                sharedPreferences.edit().putInt("selectedLanguage", position).apply()
//                // Добавьте здесь код для обновления языка
//            }
//
//            override fun onNothingSelected(parent: AdapterView<*>?) {
//                // Ничего не делаем
//            }
//        }

        return view
    }
}

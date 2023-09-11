package com.k8abadzheva.tarothandbook.ui

import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Spinner
import androidx.appcompat.widget.SwitchCompat
import androidx.fragment.app.Fragment
import com.k8abadzheva.tarothandbook.R

class SettingsFragment : Fragment() {

    private lateinit var themeSwitch: SwitchCompat
    private lateinit var languageSpinner: Spinner
    private lateinit var saveButton: Button
    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_settings, container, false)

        themeSwitch = view.findViewById(R.id.themeSwitch)
        languageSpinner = view.findViewById(R.id.languageSpinner)
        saveButton = view.findViewById(R.id.saveButton)

        // Инициализация SharedPreferences
        sharedPreferences = requireActivity().getSharedPreferences("Settings", 0)

        // Установка текущих значений настроек
        themeSwitch.isChecked = sharedPreferences.getBoolean("darkTheme", false)
        languageSpinner.setSelection(sharedPreferences.getInt("selectedLanguage", 0))

        // Обработка нажатия кнопки сохранить
        saveButton.setOnClickListener {
            with(sharedPreferences.edit()) {
                putBoolean("darkTheme", themeSwitch.isChecked)
                putInt("selectedLanguage", languageSpinner.selectedItemPosition)
                apply()
            }
        }

        return view
    }
}

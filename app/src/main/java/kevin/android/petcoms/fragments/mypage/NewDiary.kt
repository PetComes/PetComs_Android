package kevin.android.petcoms.fragments.mypage

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import dagger.hilt.android.AndroidEntryPoint
import kevin.android.petcoms.databinding.NewDiaryBinding
import kevin.android.petcoms.fragments.mypage.model.PostDiary
import kevin.android.petcoms.fragments.mypage.viewmodel.MyPageViewModel
import java.time.LocalDate

@AndroidEntryPoint
class NewDiary : Fragment() {

    private var newDiaryBinding : NewDiaryBinding? = null
    private val viewModel: MyPageViewModel by activityViewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding = NewDiaryBinding.inflate(inflater, container, false)
        newDiaryBinding = binding

        val newDiaryEditText: EditText = binding.newDiaryEditText

        binding.btnAddDiary.setOnClickListener {
            if (newDiaryEditText.text.isEmpty()){
                Toast.makeText(context, "다이어리를 작성해주세요.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            postDiary()

            val transaction= fragmentManager?.beginTransaction()
            transaction?.remove(this)?.commit()
        }

        binding.btnClose.setOnClickListener{
            val transaction= fragmentManager?.beginTransaction()
            transaction?.remove(this)?.commit()
        }

        binding.btnDatepicker.setOnClickListener {
            DatePickerDialog().show(
                parentFragmentManager, "DatePickerDialog"
            )
        }

        binding.btnDiaryPrivate.setOnClickListener {
            binding.btnDiaryPrivate.text = "공개"
        }

        val currentDate: LocalDate = LocalDate.now()
        binding.btnDatepicker.text = currentDate.toString()

        return newDiaryBinding!!.root
    }

    private fun postDiary() {
        val postDiary = PostDiary(
            1,
            3,
            1,
            1, newDiaryBinding!!.newDiaryEditText.text.toString(),
            5)
        viewModel.postDiary(postDiary)
    }

    override fun onDestroyView() {
        newDiaryBinding = null
        super.onDestroyView()
    }

}
package kevin.android.petcoms.fragments.mypage.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kevin.android.petcoms.R
import kevin.android.petcoms.fragments.mypage.MyDiary
import kevin.android.petcoms.fragments.mypage.MyPets
import kevin.android.petcoms.fragments.mypage.NewDiary
import kevin.android.petcoms.fragments.mypage.adapter.MyDiaryAdapter
import kevin.android.petcoms.fragments.mypage.repository.MyPageRepository
import kevin.android.petcoms.fragments.record.repository.RecordRepository
import kevin.android.petcoms.models.PostModel
import kotlinx.coroutines.launch
import retrofit2.Response

class MyPageViewModel(private val myPageRepository: MyPageRepository): ViewModel() {

//    lateinit var myDiaryAdapter: MyDiaryAdapter

    private val _myPetsList = MutableLiveData<ArrayList<MyPets>>()
    val myPetsList : LiveData<ArrayList<MyPets>>
        get() = _myPetsList

    private var petsList = ArrayList<MyPets>()

    init {
        petsList = arrayListOf(
            MyPets("콩순이"),
            MyPets("팥순이")
        )
        _myPetsList.value = petsList
    }

    fun btnClick(){
        val myPets = MyPets("탄이")
        petsList.add(myPets)
        _myPetsList.value = petsList
    }


//    private val _myDiaryList = MutableLiveData<ArrayList<MyDiary>>()
//    val myDiaryList : LiveData<ArrayList<MyDiary>>
//        get() = _myDiaryList
//
//    private var diaryList = ArrayList<MyDiary>()
//
//    init {
//        diaryList = arrayListOf(
//            MyDiary("","","","")
//        )
//        _myDiaryList.value = diaryList
//    }

//    fun fabClick(){
//        val myDiary = MyDiary(DUserImg = R.drawable.ic_settings, "탄이아빠", "2020.04.05")
//        diaryList.add(myDiary)
//        _myDiaryList.value = diaryList
//    }


//    private var _myDiaryList = MutableLiveData<Response<MyDiary>>()
//    val myDiaryList: MutableLiveData<Response<MyDiary>>
//        get() = _myDiaryList
//
//    init {
//        getMyDiaryModel()
//    }

    val myDiaryList: MutableLiveData<Response<MyDiary>> = MutableLiveData()

    fun getMyDiaryModel() {
        viewModelScope.launch {
            val response = myPageRepository.getMyDiaryData()
            myDiaryList.value = response
        }
    }

//    fun getAdapter(): MyDiaryAdapter{
//        return myDiaryAdapter
//    }

//    val myResponse : MutableLiveData<Response<MyDiary>> = MutableLiveData()
//
//    fun getMyDiary() {
//        viewModelScope.launch {
//            val response = myPageRepository.getMyDiaryData()
//            myResponse.value = response
//        }
//    }

}
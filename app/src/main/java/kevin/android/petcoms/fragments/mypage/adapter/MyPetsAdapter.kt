package kevin.android.petcoms.fragments.mypage.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kevin.android.petcoms.databinding.ListMyPetsBinding
import kevin.android.petcoms.fragments.mypage.model.TestModel

class MyPetsAdapter(private var data: List<TestModel>): RecyclerView.Adapter<MyPetsAdapter.MyPetsViewHolder>() {

    class MyPetsViewHolder(val binding: ListMyPetsBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyPetsViewHolder {
        val binding = ListMyPetsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyPetsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyPetsViewHolder, position: Int) {
        holder.binding.petsName.text = data[position].username
    }

    override fun getItemCount() = data.size

}
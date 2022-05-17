package com.example.googlebooks.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.googlebooks.R
import com.example.googlebooks.databinding.ItemMainBinding
import com.example.googlebooks.model.VolumeInfo

class BookAdapter : RecyclerView.Adapter<BookAdapter.BookViewHolder>() {

    //참고
    //https://jeffrey-oh.tistory.com/353
    //https://howtodoandroid.com/mvvm-retrofit-recyclerview-kotlin/
    //https://show-me-the-money.tistory.com/entry/Android-MVVM-%EC%95%84%ED%82%A4%ED%85%8D%EC%B2%98%EC%97%90%EC%84%9C-Live-Data%EC%99%80-Data-Binding%EC%9D%84-%ED%99%9C%EC%9A%A9%ED%95%B4%EC%84%9C-Recycler-View-%EA%B5%AC%ED%98%84%ED%95%98%EA%B8%B0?category=655829

    private var bookList: List<VolumeInfo> = listOf()

    //LiveData 세팅 메서드 - 보여줄 데이터 목록 업데이트
    @SuppressLint("NotifyDataSetChanged")
    fun setBookList(bookList: List<VolumeInfo>) {
        this.bookList = bookList
        notifyDataSetChanged() //데이터가 변경되면 옵저버에게 통보
    }


    //뷰홀더에 값 지정
    inner class BookViewHolder(private val binding: ItemMainBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bindData(bookList: VolumeInfo) {
            //레이아웃에서 사용할 데이터 설정
            binding.book = bookList
            binding.executePendingBindings()


        }
    }

    //Layout에서 이미지 URL값이 변동되었을 때 호출되는 Binding Adapter
    companion object {
        @BindingAdapter("loadImage")
        fun loadImage(thumbImage: ImageView, url: String?) {
            url?.let{
                Glide.with(thumbImage.context)
                    .load(url)
                    .error(R.drawable.ic_launcher_background)
                    .into(thumbImage)
            }
        }
    }


    //생성할 뷰홀더 xml 지정 - xml 레이아웃에 매핑되는 Binding class 생성
    //해당 class로 layout 생성해서 ViewHolder에 넘겨줌
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemMainBinding.inflate(layoutInflater)
        return BookViewHolder(binding)
    }

    //뷰홀더에 데이터 바인딩
    override fun onBindViewHolder(holder: BookViewHolder, position: Int) {
        holder.bindData(bookList[position])
    }

    //뷰홀더 갯수 리턴
    override fun getItemCount(): Int {
        return bookList.size
    }

}
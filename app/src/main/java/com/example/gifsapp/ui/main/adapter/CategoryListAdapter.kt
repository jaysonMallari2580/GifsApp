package com.example.gifsapp.ui.main.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.gifsapp.databinding.CategoryItemBinding
import com.example.gifsapp.ui.main.data.models.Category

class CategoryListAdapter(val mCategoryList:List<Category>): RecyclerView.Adapter<CategoryListAdapter.CategoryListViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryListViewHolder {
        return CategoryListViewHolder(CategoryItemBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: CategoryListViewHolder, position: Int) {
        val categoryItem = mCategoryList[position]
        holder.bindData(categoryItem)
    }

    override fun getItemCount(): Int {
        return mCategoryList.size
    }

    class CategoryListViewHolder(val binding: CategoryItemBinding): RecyclerView.ViewHolder(binding.root) {

      fun bindData(category: Category){
          binding.categoryItemTv.text = category.name
      }

    }
}
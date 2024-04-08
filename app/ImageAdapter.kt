import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ImageAdapter(private val imageList: List<ImageItem>) :
    RecyclerView.Adapter<ImageAdapter.ImageViewHolder>() {

    inner class ImageViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.imageView)
        val textView: TextView = itemView.findViewById(R.id.textView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.item_image, parent, false)
        return ImageViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        val currentItem = imageList[position]
        holder.imageView.setImageResource(currentItem.imageResource)
        holder.textView.text = currentItem.caption

        holder.itemView.setOnClickListener {
            // Handle click event here
            // You can show the caption text as a popup
            // For simplicity, you can use Toast here
            Toast.makeText(holder.itemView.context, currentItem.caption, Toast.LENGTH_SHORT)
                .show()
        }
    }

    override fun getItemCount(): Int {
        return imageList.size
    }
}
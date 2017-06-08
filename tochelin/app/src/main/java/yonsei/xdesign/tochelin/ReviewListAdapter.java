package yonsei.xdesign.tochelin;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.squareup.picasso.Picasso;

import yonsei.xdesign.tochelin.databinding.ReviewCellViewBinding;
import yonsei.xdesign.tochelin.models.Review;

public class ReviewListAdapter extends RecyclerView.Adapter<ReviewListAdapter.ViewHolder> {

    Context context;
    Review[] reviews;

    public ReviewListAdapter(Context context, Review[] reviews) {
        this.context = context;
        this.reviews = reviews;
    }

    @Override
    public ReviewListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        ReviewCellViewBinding binding = ReviewCellViewBinding.inflate(
                inflater, parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final Review review = reviews[position];
        holder.bind(review);
    }

    @Override
    public int getItemCount() {
        return reviews.length;
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        ReviewCellViewBinding binding;
        Review review;

        public ViewHolder(ReviewCellViewBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(Review review) {
            this.review = review;
            Picasso.with(context)
                    .load(review.thumbnailImageUrl)
                    .resizeDimen(R.dimen.review_user_size, R.dimen.review_user_size)
                    .centerCrop()
                    .into(binding.userImage);
            binding.userName.setText(review.name);
            binding.reviewFrom.setText(review.from);
            binding.reviewDate.setText(review.date);
            binding.reviewContent.setText(review.content);
            for (String url : review.imageUrls) {
                ImageView imageView = new ImageView(context);
                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                        context.getResources().getDimensionPixelSize(R.dimen.review_content_image_size),
                        context.getResources().getDimensionPixelSize(R.dimen.review_content_image_size));
                params.setMarginEnd(context.getResources().getDimensionPixelSize(R.dimen.common_margin_short));
                imageView.setLayoutParams(params);
                Picasso.with(context)
                        .load(url)
                        .resizeDimen(R.dimen.review_content_image_size, R.dimen.review_content_image_size)
                        .centerCrop()
                        .into(imageView);
                binding.images.addView(imageView);
            }
        }
    }
}

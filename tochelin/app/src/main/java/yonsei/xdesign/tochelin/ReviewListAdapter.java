package yonsei.xdesign.tochelin;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import yonsei.xdesign.tochelin.databinding.ReviewCellViewBinding;
import yonsei.xdesign.tochelin.models.Review;

public class ReviewListAdapter extends RecyclerView.Adapter<ReviewListAdapter.ViewHolder> {

    Review[] reviews;

    public ReviewListAdapter(Review[] reviews) {
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
            // TODO(totoro): user Image 받아오기.
            binding.userName.setText(review.name);
            binding.reviewFrom.setText(review.from);
            binding.reviewDate.setText(review.date);
            binding.reviewContent.setText(review.content);
            // TODO(totor): 가게 이미지 url들 받아오기.
        }
    }
}

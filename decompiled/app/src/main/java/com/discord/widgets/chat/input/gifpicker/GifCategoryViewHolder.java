package com.discord.widgets.chat.input.gifpicker;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.res.ResourcesCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.R;
import com.discord.databinding.GifCategoryItemViewBinding;
import com.discord.models.gifpicker.domain.ModelGifCategory;
import com.discord.utilities.images.MGImages;
import com.discord.widgets.chat.input.gifpicker.GifCategoryItem;
import com.facebook.drawee.view.SimpleDraweeView;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: GifCategoryViewHolder.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J+\u0010\u000b\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0014\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0004\u0018\u00010\t¢\u0006\u0004\b\u000b\u0010\fR\u0016\u0010\u000e\u001a\u00020\r8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f¨\u0006\u0012"}, d2 = {"Lcom/discord/widgets/chat/input/gifpicker/GifCategoryViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "", "imageUrl", "", "setPreviewImage", "(Ljava/lang/String;)V", "Lcom/discord/widgets/chat/input/gifpicker/GifCategoryItem;", "gifCategoryItem", "Lkotlin/Function1;", "onSelectGifCategory", "configure", "(Lcom/discord/widgets/chat/input/gifpicker/GifCategoryItem;Lkotlin/jvm/functions/Function1;)V", "Lcom/discord/databinding/GifCategoryItemViewBinding;", "binding", "Lcom/discord/databinding/GifCategoryItemViewBinding;", "<init>", "(Lcom/discord/databinding/GifCategoryItemViewBinding;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class GifCategoryViewHolder extends RecyclerView.ViewHolder {
    private final GifCategoryItemViewBinding binding;

    /* compiled from: GifCategoryViewHolder.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.chat.input.gifpicker.GifCategoryViewHolder$configure$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnClickListener {
        public final /* synthetic */ GifCategoryItem $gifCategoryItem;
        public final /* synthetic */ Function1 $onSelectGifCategory;

        public AnonymousClass1(Function1 function1, GifCategoryItem gifCategoryItem) {
            this.$onSelectGifCategory = function1;
            this.$gifCategoryItem = gifCategoryItem;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Function1 function1 = this.$onSelectGifCategory;
            if (function1 != null) {
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GifCategoryViewHolder(GifCategoryItemViewBinding gifCategoryItemViewBinding) {
        super(gifCategoryItemViewBinding.a);
        Intrinsics3.checkNotNullParameter(gifCategoryItemViewBinding, "binding");
        this.binding = gifCategoryItemViewBinding;
        this.itemView.setOnTouchListener(new ViewScalingOnTouchListener(0.9f));
    }

    private final void setPreviewImage(String imageUrl) {
        SimpleDraweeView simpleDraweeView = this.binding.c;
        Intrinsics3.checkNotNullExpressionValue(simpleDraweeView, "binding.gifCategoryItemPreview");
        ViewGroup.LayoutParams layoutParams = simpleDraweeView.getLayoutParams();
        int i = layoutParams.width;
        int i2 = layoutParams.height;
        SimpleDraweeView simpleDraweeView2 = this.binding.c;
        Intrinsics3.checkNotNullExpressionValue(simpleDraweeView2, "binding.gifCategoryItemPreview");
        MGImages.setImage$default(simpleDraweeView2, imageUrl, i, i2, false, null, null, 112, null);
    }

    public final void configure(GifCategoryItem gifCategoryItem, Function1<? super GifCategoryItem, Unit> onSelectGifCategory) {
        Intrinsics3.checkNotNullParameter(gifCategoryItem, "gifCategoryItem");
        if (gifCategoryItem instanceof GifCategoryItem.Standard) {
            ModelGifCategory gifCategory = ((GifCategoryItem.Standard) gifCategoryItem).getGifCategory();
            setPreviewImage(gifCategory.getGifPreviewUrl());
            TextView textView = this.binding.d;
            Intrinsics3.checkNotNullExpressionValue(textView, "binding.gifCategoryItemTitle");
            textView.setText(gifCategory.getCategoryName());
            ImageView imageView = this.binding.f2111b;
            Intrinsics3.checkNotNullExpressionValue(imageView, "binding.gifCategoryItemIcon");
            imageView.setVisibility(8);
        } else if (gifCategoryItem instanceof GifCategoryItem.Trending) {
            setPreviewImage(((GifCategoryItem.Trending) gifCategoryItem).getGifPreviewUrl());
            TextView textView2 = this.binding.d;
            Intrinsics3.checkNotNullExpressionValue(textView2, "binding.gifCategoryItemTitle");
            View view = this.itemView;
            Intrinsics3.checkNotNullExpressionValue(view, "itemView");
            textView2.setText(view.getResources().getString(R.string.gif_picker_result_type_trending_gifs));
            ImageView imageView2 = this.binding.f2111b;
            Intrinsics3.checkNotNullExpressionValue(imageView2, "binding.gifCategoryItemIcon");
            imageView2.setVisibility(0);
            ImageView imageView3 = this.binding.f2111b;
            View view2 = this.itemView;
            Intrinsics3.checkNotNullExpressionValue(view2, "itemView");
            imageView3.setImageDrawable(ResourcesCompat.getDrawable(view2.getResources(), R.drawable.ic_analytics_16dp, null));
        }
        this.itemView.setOnClickListener(new AnonymousClass1(onSelectGifCategory, gifCategoryItem));
    }
}

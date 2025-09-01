package com.discord.widgets.chat.input.gifpicker;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import b.a.i.GifSearchEmptyStateTextBoxViewBinding;
import b.a.k.FormatUtils;
import com.discord.R;
import com.discord.databinding.GifItemViewBinding;
import com.discord.databinding.GifSuggestedTermViewBinding;
import com.discord.models.gifpicker.dto.ModelGif;
import com.discord.utilities.dimen.DimenUtils;
import com.discord.utilities.drawable.DrawableCompat;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.images.MGImages;
import com.discord.widgets.chat.input.gifpicker.GifAdapterItem;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.flexbox.FlexboxLayout;
import d0.t.CollectionsJVM;
import d0.z.d.Intrinsics3;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: GifViewHolder.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0006\u0007B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005\u0082\u0001\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/discord/widgets/chat/input/gifpicker/GifViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/view/View;", "itemView", "<init>", "(Landroid/view/View;)V", "Gif", "SuggestedTerms", "Lcom/discord/widgets/chat/input/gifpicker/GifViewHolder$Gif;", "Lcom/discord/widgets/chat/input/gifpicker/GifViewHolder$SuggestedTerms;", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public abstract class GifViewHolder extends RecyclerView.ViewHolder {

    /* compiled from: GifViewHolder.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J5\u0010\r\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0016\b\u0002\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u000b¢\u0006\u0004\b\r\u0010\u000eR\u0016\u0010\u0010\u001a\u00020\u000f8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011¨\u0006\u0014"}, d2 = {"Lcom/discord/widgets/chat/input/gifpicker/GifViewHolder$Gif;", "Lcom/discord/widgets/chat/input/gifpicker/GifViewHolder;", "Lcom/discord/models/gifpicker/dto/ModelGif;", IconUtils.ANIMATED_IMAGE_EXTENSION, "", "setGifImage", "(Lcom/discord/models/gifpicker/dto/ModelGif;)V", "Lcom/discord/widgets/chat/input/gifpicker/GifAdapterItem$GifItem;", "gifItem", "", "columnWidthPx", "Lkotlin/Function1;", "onSelectGif", "configure", "(Lcom/discord/widgets/chat/input/gifpicker/GifAdapterItem$GifItem;ILkotlin/jvm/functions/Function1;)V", "Lcom/discord/databinding/GifItemViewBinding;", "binding", "Lcom/discord/databinding/GifItemViewBinding;", "<init>", "(Lcom/discord/databinding/GifItemViewBinding;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Gif extends GifViewHolder {
        private final GifItemViewBinding binding;

        /* JADX WARN: Illegal instructions before constructor call */
        public Gif(GifItemViewBinding gifItemViewBinding) {
            Intrinsics3.checkNotNullParameter(gifItemViewBinding, "binding");
            CardView cardView = gifItemViewBinding.a;
            Intrinsics3.checkNotNullExpressionValue(cardView, "binding.root");
            super(cardView, null);
            this.binding = gifItemViewBinding;
            this.itemView.setOnTouchListener(new ViewScalingOnTouchListener(0.9f));
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void configure$default(Gif gif, GifAdapterItem.GifItem gifItem, int i, Function1 function1, int i2, Object obj) {
            if ((i2 & 4) != 0) {
                function1 = null;
            }
            gif.configure(gifItem, i, function1);
        }

        private final void setGifImage(ModelGif gif) {
            String gifImageUrl = gif.getGifImageUrl();
            SimpleDraweeView simpleDraweeView = this.binding.f2112b;
            Intrinsics3.checkNotNullExpressionValue(simpleDraweeView, "binding.gifItemImage");
            MGImages.setImage$default(simpleDraweeView, CollectionsJVM.listOf(gifImageUrl), 0, 0, false, null, null, null, 252, null);
        }

        public final void configure(GifAdapterItem.GifItem gifItem, int columnWidthPx, Function1<? super GifAdapterItem.GifItem, Unit> onSelectGif) {
            Intrinsics3.checkNotNullParameter(gifItem, "gifItem");
            ModelGif gif = gifItem.getGif();
            CardView cardView = this.binding.a;
            Intrinsics3.checkNotNullExpressionValue(cardView, "binding.root");
            cardView.getLayoutParams().height = (int) (columnWidthPx * (gif.getHeight() / gif.getWidth()));
            setGifImage(gif);
            this.binding.a.setOnClickListener(new GifViewHolder2(onSelectGif, gifItem));
        }
    }

    private GifViewHolder(View view) {
        super(view);
    }

    public /* synthetic */ GifViewHolder(View view, DefaultConstructorMarker defaultConstructorMarker) {
        this(view);
    }

    /* compiled from: GifViewHolder.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\u0014\u0010\u0015J5\u0010\n\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0014\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00042\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\n\u0010\u000bJ+\u0010\r\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\f2\u0014\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0004¢\u0006\u0004\b\r\u0010\u000eJ+\u0010\r\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u000f2\u0014\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0004¢\u0006\u0004\b\r\u0010\u0010R\u0016\u0010\u0012\u001a\u00020\u00118\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013¨\u0006\u0016"}, d2 = {"Lcom/discord/widgets/chat/input/gifpicker/GifViewHolder$SuggestedTerms;", "Lcom/discord/widgets/chat/input/gifpicker/GifViewHolder;", "Lcom/discord/widgets/chat/input/gifpicker/GifAdapterItem$SuggestedTermsItem;", "termsItem", "Lkotlin/Function1;", "", "", "onTermSelected", "", "layoutHeight", "configureSearchTerms", "(Lcom/discord/widgets/chat/input/gifpicker/GifAdapterItem$SuggestedTermsItem;Lkotlin/jvm/functions/Function1;I)V", "Lcom/discord/widgets/chat/input/gifpicker/GifAdapterItem$SuggestedTermsItem$SuggestedTermsEmptyResults;", "configure", "(Lcom/discord/widgets/chat/input/gifpicker/GifAdapterItem$SuggestedTermsItem$SuggestedTermsEmptyResults;Lkotlin/jvm/functions/Function1;)V", "Lcom/discord/widgets/chat/input/gifpicker/GifAdapterItem$SuggestedTermsItem$SuggestedTermsNonEmptyResults;", "(Lcom/discord/widgets/chat/input/gifpicker/GifAdapterItem$SuggestedTermsItem$SuggestedTermsNonEmptyResults;Lkotlin/jvm/functions/Function1;)V", "Lcom/discord/databinding/GifSuggestedTermViewBinding;", "binding", "Lcom/discord/databinding/GifSuggestedTermViewBinding;", "<init>", "(Lcom/discord/databinding/GifSuggestedTermViewBinding;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class SuggestedTerms extends GifViewHolder {
        private final GifSuggestedTermViewBinding binding;

        /* JADX WARN: Illegal instructions before constructor call */
        public SuggestedTerms(GifSuggestedTermViewBinding gifSuggestedTermViewBinding) {
            Intrinsics3.checkNotNullParameter(gifSuggestedTermViewBinding, "binding");
            LinearLayout linearLayout = gifSuggestedTermViewBinding.a;
            Intrinsics3.checkNotNullExpressionValue(linearLayout, "binding.root");
            super(linearLayout, null);
            this.binding = gifSuggestedTermViewBinding;
        }

        private final void configureSearchTerms(GifAdapterItem.SuggestedTermsItem termsItem, Function1<? super String, Unit> onTermSelected, int layoutHeight) {
            List<String> terms = termsItem.getTerms();
            TextView textView = this.binding.c;
            Intrinsics3.checkNotNullExpressionValue(textView, "binding.gifSearchSuggestedTermsIconText");
            FormatUtils.n(textView, termsItem.getTitleResId(), new Object[0], null, 4);
            int size = terms.size();
            if (size > 0) {
                for (int i = 0; i < size; i++) {
                    FlexboxLayout flexboxLayout = this.binding.f2113b;
                    Intrinsics3.checkNotNullExpressionValue(flexboxLayout, "binding.gifSearchSuggestedTermsFlexBox");
                    int childCount = flexboxLayout.getChildCount();
                    String str = terms.get(i);
                    if (i >= childCount) {
                        LinearLayout linearLayout = this.binding.a;
                        Intrinsics3.checkNotNullExpressionValue(linearLayout, "binding.root");
                        View viewInflate = LayoutInflater.from(linearLayout.getContext()).inflate(R.layout.gif_search_empty_state_text_box_view, (ViewGroup) this.binding.f2113b, false);
                        Objects.requireNonNull(viewInflate, "rootView");
                        TextView textView2 = (TextView) viewInflate;
                        Intrinsics3.checkNotNullExpressionValue(new GifSearchEmptyStateTextBoxViewBinding(textView2), "GifSearchEmptyStateTextB…      false\n            )");
                        Intrinsics3.checkNotNullExpressionValue(textView2, "GifSearchEmptyStateTextB… false\n            ).root");
                        this.binding.f2113b.addView(textView2, i);
                    }
                    View childAt = this.binding.f2113b.getChildAt(i);
                    Objects.requireNonNull(childAt, "null cannot be cast to non-null type android.widget.TextView");
                    TextView textView3 = (TextView) childAt;
                    textView3.setText(str);
                    textView3.setOnClickListener(new GifViewHolder3(onTermSelected, str));
                }
            }
            FlexboxLayout flexboxLayout2 = this.binding.f2113b;
            Intrinsics3.checkNotNullExpressionValue(flexboxLayout2, "binding.gifSearchSuggestedTermsFlexBox");
            if (size < flexboxLayout2.getChildCount()) {
                FlexboxLayout flexboxLayout3 = this.binding.f2113b;
                Intrinsics3.checkNotNullExpressionValue(flexboxLayout3, "binding.gifSearchSuggestedTermsFlexBox");
                if (flexboxLayout3.getChildCount() > 0) {
                    FlexboxLayout flexboxLayout4 = this.binding.f2113b;
                    Intrinsics3.checkNotNullExpressionValue(flexboxLayout4, "binding.gifSearchSuggestedTermsFlexBox");
                    int childCount2 = flexboxLayout4.getChildCount() - 1;
                    if (childCount2 >= size) {
                        while (true) {
                            this.binding.f2113b.removeViewAt(childCount2);
                            if (childCount2 == size) {
                                break;
                            } else {
                                childCount2--;
                            }
                        }
                    }
                }
            }
            StaggeredGridLayoutManager.LayoutParams layoutParams = new StaggeredGridLayoutManager.LayoutParams(-1, layoutHeight);
            layoutParams.setFullSpan(true);
            View view = this.itemView;
            Intrinsics3.checkNotNullExpressionValue(view, "itemView");
            view.setLayoutParams(layoutParams);
        }

        public final void configure(GifAdapterItem.SuggestedTermsItem.SuggestedTermsEmptyResults termsItem, Function1<? super String, Unit> onTermSelected) {
            Intrinsics3.checkNotNullParameter(termsItem, "termsItem");
            TextView textView = this.binding.c;
            Intrinsics3.checkNotNullExpressionValue(textView, "binding.gifSearchSuggestedTermsIconText");
            View view = this.itemView;
            Intrinsics3.checkNotNullExpressionValue(view, "itemView");
            DrawableCompat.setCompoundDrawablesCompat$default(textView, 0, DrawableCompat.getThemedDrawableRes$default(view, R.attr.theme_expression_tray_search_icon_empty, 0, 2, (Object) null), 0, 0, 13, (Object) null);
            configureSearchTerms(termsItem, onTermSelected, -1);
            View view2 = this.itemView;
            Intrinsics3.checkNotNullExpressionValue(view2, "itemView");
            view2.setPadding(view2.getPaddingLeft(), 0, view2.getPaddingRight(), 0);
        }

        public final void configure(GifAdapterItem.SuggestedTermsItem.SuggestedTermsNonEmptyResults termsItem, Function1<? super String, Unit> onTermSelected) {
            Intrinsics3.checkNotNullParameter(termsItem, "termsItem");
            TextView textView = this.binding.c;
            Intrinsics3.checkNotNullExpressionValue(textView, "binding.gifSearchSuggestedTermsIconText");
            DrawableCompat.setCompoundDrawablesCompat$default(textView, (Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null, 13, (Object) null);
            configureSearchTerms(termsItem, onTermSelected, -2);
            View view = this.itemView;
            Intrinsics3.checkNotNullExpressionValue(view, "itemView");
            view.setPadding(view.getPaddingLeft(), DimenUtils.dpToPixels(32), view.getPaddingRight(), DimenUtils.dpToPixels(40));
        }
    }
}

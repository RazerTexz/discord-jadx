package com.discord.widgets.chat.input.sticker;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.databinding.StickerCategoryItemGuildBinding;
import com.discord.databinding.StickerCategoryItemPackBinding;
import com.discord.databinding.StickerCategoryItemRecentBinding;
import com.discord.rlottie.RLottieImageView;
import com.discord.views.sticker.StickerView;
import com.discord.widgets.chat.input.sticker.StickerCategoryItem;
import com.facebook.drawee.view.SimpleDraweeView;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: StickerCategoryViewHolder.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0006\u0007\bB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005\u0082\u0001\u0003\t\n\u000b¨\u0006\f"}, d2 = {"Lcom/discord/widgets/chat/input/sticker/StickerCategoryViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/view/View;", "itemView", "<init>", "(Landroid/view/View;)V", "Guild", "Pack", "Recent", "Lcom/discord/widgets/chat/input/sticker/StickerCategoryViewHolder$Recent;", "Lcom/discord/widgets/chat/input/sticker/StickerCategoryViewHolder$Pack;", "Lcom/discord/widgets/chat/input/sticker/StickerCategoryViewHolder$Guild;", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public abstract class StickerCategoryViewHolder extends RecyclerView.ViewHolder {

    /* compiled from: StickerCategoryViewHolder.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\f\u0010\rJ)\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0007\u0010\bR\u0016\u0010\n\u001a\u00020\t8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000b¨\u0006\u000e"}, d2 = {"Lcom/discord/widgets/chat/input/sticker/StickerCategoryViewHolder$Guild;", "Lcom/discord/widgets/chat/input/sticker/StickerCategoryViewHolder;", "Lcom/discord/widgets/chat/input/sticker/StickerCategoryItem$GuildItem;", "guildItem", "Lkotlin/Function1;", "", "onGuildClicked", "configure", "(Lcom/discord/widgets/chat/input/sticker/StickerCategoryItem$GuildItem;Lkotlin/jvm/functions/Function1;)V", "Lcom/discord/databinding/StickerCategoryItemGuildBinding;", "binding", "Lcom/discord/databinding/StickerCategoryItemGuildBinding;", "<init>", "(Lcom/discord/databinding/StickerCategoryItemGuildBinding;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Guild extends StickerCategoryViewHolder {
        private final StickerCategoryItemGuildBinding binding;

        /* JADX WARN: Illegal instructions before constructor call */
        public Guild(StickerCategoryItemGuildBinding stickerCategoryItemGuildBinding) {
            Intrinsics3.checkNotNullParameter(stickerCategoryItemGuildBinding, "binding");
            FrameLayout frameLayout = stickerCategoryItemGuildBinding.a;
            Intrinsics3.checkNotNullExpressionValue(frameLayout, "binding.root");
            super(frameLayout, null);
            this.binding = stickerCategoryItemGuildBinding;
        }

        public final void configure(StickerCategoryItem.GuildItem guildItem, Function1<? super StickerCategoryItem.GuildItem, Unit> onGuildClicked) {
            Intrinsics3.checkNotNullParameter(guildItem, "guildItem");
            Intrinsics3.checkNotNullParameter(onGuildClicked, "onGuildClicked");
            this.binding.c.updateView(guildItem.getGuild());
            View view = this.binding.f2148b.f163b;
            Intrinsics3.checkNotNullExpressionValue(view, "binding.overline.express…CategorySelectionOverline");
            view.setVisibility(guildItem.getIsSelected() ? 0 : 8);
            this.itemView.setOnClickListener(new StickerCategoryViewHolder2(onGuildClicked, guildItem));
            View view2 = this.itemView;
            Intrinsics3.checkNotNullExpressionValue(view2, "itemView");
            view2.setContentDescription(guildItem.getGuild().getName());
        }
    }

    /* compiled from: StickerCategoryViewHolder.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\f\u0010\rJ)\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0007\u0010\bR\u0016\u0010\n\u001a\u00020\t8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000b¨\u0006\u000e"}, d2 = {"Lcom/discord/widgets/chat/input/sticker/StickerCategoryViewHolder$Pack;", "Lcom/discord/widgets/chat/input/sticker/StickerCategoryViewHolder;", "Lcom/discord/widgets/chat/input/sticker/StickerCategoryItem$PackItem;", "packItem", "Lkotlin/Function1;", "", "onPackClicked", "configure", "(Lcom/discord/widgets/chat/input/sticker/StickerCategoryItem$PackItem;Lkotlin/jvm/functions/Function1;)V", "Lcom/discord/databinding/StickerCategoryItemPackBinding;", "binding", "Lcom/discord/databinding/StickerCategoryItemPackBinding;", "<init>", "(Lcom/discord/databinding/StickerCategoryItemPackBinding;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Pack extends StickerCategoryViewHolder {
        private final StickerCategoryItemPackBinding binding;

        /* JADX WARN: Illegal instructions before constructor call */
        public Pack(StickerCategoryItemPackBinding stickerCategoryItemPackBinding) {
            Intrinsics3.checkNotNullParameter(stickerCategoryItemPackBinding, "binding");
            FrameLayout frameLayout = stickerCategoryItemPackBinding.a;
            Intrinsics3.checkNotNullExpressionValue(frameLayout, "binding.root");
            super(frameLayout, null);
            this.binding = stickerCategoryItemPackBinding;
        }

        public final void configure(StickerCategoryItem.PackItem packItem, Function1<? super StickerCategoryItem.PackItem, Unit> onPackClicked) {
            Intrinsics3.checkNotNullParameter(packItem, "packItem");
            Intrinsics3.checkNotNullParameter(onPackClicked, "onPackClicked");
            this.binding.c.d(packItem.getPack().getCoverSticker(), 2);
            this.binding.c.setOnClickListener(new StickerCategoryViewHolder3(onPackClicked, packItem));
            StickerView stickerView = this.binding.c;
            SimpleDraweeView simpleDraweeView = stickerView.binding.f191b;
            Intrinsics3.checkNotNullExpressionValue(simpleDraweeView, "binding.stickerViewImageview");
            simpleDraweeView.setImportantForAccessibility(4);
            RLottieImageView rLottieImageView = stickerView.binding.c;
            Intrinsics3.checkNotNullExpressionValue(rLottieImageView, "binding.stickerViewLottie");
            rLottieImageView.setImportantForAccessibility(4);
            ImageView imageView = stickerView.binding.d;
            Intrinsics3.checkNotNullExpressionValue(imageView, "binding.stickerViewPlaceholder");
            imageView.setImportantForAccessibility(4);
            StickerView stickerView2 = this.binding.c;
            Intrinsics3.checkNotNullExpressionValue(stickerView2, "binding.stickerCategoryItemPackAvatar");
            stickerView2.setContentDescription(packItem.getPack().getName());
            View view = this.binding.f2149b.f163b;
            Intrinsics3.checkNotNullExpressionValue(view, "binding.overline.express…CategorySelectionOverline");
            view.setVisibility(packItem.getIsSelected() ? 0 : 8);
        }
    }

    /* compiled from: StickerCategoryViewHolder.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\f\u0010\rJ#\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0007\u0010\bR\u0016\u0010\n\u001a\u00020\t8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000b¨\u0006\u000e"}, d2 = {"Lcom/discord/widgets/chat/input/sticker/StickerCategoryViewHolder$Recent;", "Lcom/discord/widgets/chat/input/sticker/StickerCategoryViewHolder;", "Lcom/discord/widgets/chat/input/sticker/StickerCategoryItem$RecentItem;", "categoryItem", "Lkotlin/Function0;", "", "onRecentClicked", "configure", "(Lcom/discord/widgets/chat/input/sticker/StickerCategoryItem$RecentItem;Lkotlin/jvm/functions/Function0;)V", "Lcom/discord/databinding/StickerCategoryItemRecentBinding;", "binding", "Lcom/discord/databinding/StickerCategoryItemRecentBinding;", "<init>", "(Lcom/discord/databinding/StickerCategoryItemRecentBinding;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Recent extends StickerCategoryViewHolder {
        private final StickerCategoryItemRecentBinding binding;

        /* JADX WARN: Illegal instructions before constructor call */
        public Recent(StickerCategoryItemRecentBinding stickerCategoryItemRecentBinding) {
            Intrinsics3.checkNotNullParameter(stickerCategoryItemRecentBinding, "binding");
            FrameLayout frameLayout = stickerCategoryItemRecentBinding.a;
            Intrinsics3.checkNotNullExpressionValue(frameLayout, "binding.root");
            super(frameLayout, null);
            this.binding = stickerCategoryItemRecentBinding;
        }

        public final void configure(StickerCategoryItem.RecentItem categoryItem, Function0<Unit> onRecentClicked) {
            Intrinsics3.checkNotNullParameter(categoryItem, "categoryItem");
            Intrinsics3.checkNotNullParameter(onRecentClicked, "onRecentClicked");
            View view = this.binding.f2150b.f163b;
            Intrinsics3.checkNotNullExpressionValue(view, "binding.overline.express…CategorySelectionOverline");
            view.setVisibility(categoryItem.getIsSelected() ? 0 : 8);
            this.itemView.setOnClickListener(new StickerCategoryViewHolder4(onRecentClicked));
        }
    }

    private StickerCategoryViewHolder(View view) {
        super(view);
    }

    public /* synthetic */ StickerCategoryViewHolder(View view, DefaultConstructorMarker defaultConstructorMarker) {
        this(view);
    }
}

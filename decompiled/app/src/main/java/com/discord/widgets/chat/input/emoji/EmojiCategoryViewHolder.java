package com.discord.widgets.chat.input.emoji;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.DrawableRes;
import androidx.core.content.res.ResourcesCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.R;
import com.discord.databinding.EmojiCategoryItemGuildBinding;
import com.discord.databinding.EmojiCategoryItemStandardBinding;
import com.discord.models.domain.emoji.EmojiCategory;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.color.ColorCompat2;
import com.discord.widgets.chat.input.emoji.EmojiCategoryItem;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: EmojiCategoryViewHolder.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000 \u00062\u00020\u0001:\u0003\u0006\u0007\bB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005\u0082\u0001\u0002\t\n¨\u0006\u000b"}, d2 = {"Lcom/discord/widgets/chat/input/emoji/EmojiCategoryViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/view/View;", "itemView", "<init>", "(Landroid/view/View;)V", "Companion", "Guild", "Standard", "Lcom/discord/widgets/chat/input/emoji/EmojiCategoryViewHolder$Standard;", "Lcom/discord/widgets/chat/input/emoji/EmojiCategoryViewHolder$Guild;", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public abstract class EmojiCategoryViewHolder extends RecyclerView.ViewHolder {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* compiled from: EmojiCategoryViewHolder.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/discord/widgets/chat/input/emoji/EmojiCategoryViewHolder$Companion;", "", "Lcom/discord/models/domain/emoji/EmojiCategory;", "emojiCategory", "", "getCategoryIconResId", "(Lcom/discord/models/domain/emoji/EmojiCategory;)I", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {

        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
        public final /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                EmojiCategory.values();
                int[] iArr = new int[11];
                $EnumSwitchMapping$0 = iArr;
                iArr[EmojiCategory.FAVORITE.ordinal()] = 1;
                iArr[EmojiCategory.PEOPLE.ordinal()] = 2;
                iArr[EmojiCategory.NATURE.ordinal()] = 3;
                iArr[EmojiCategory.FOOD.ordinal()] = 4;
                iArr[EmojiCategory.ACTIVITY.ordinal()] = 5;
                iArr[EmojiCategory.TRAVEL.ordinal()] = 6;
                iArr[EmojiCategory.OBJECTS.ordinal()] = 7;
                iArr[EmojiCategory.SYMBOLS.ordinal()] = 8;
                iArr[EmojiCategory.FLAGS.ordinal()] = 9;
                iArr[EmojiCategory.RECENT.ordinal()] = 10;
                iArr[EmojiCategory.CUSTOM.ordinal()] = 11;
            }
        }

        private Companion() {
        }

        @DrawableRes
        public final int getCategoryIconResId(EmojiCategory emojiCategory) {
            Intrinsics3.checkNotNullParameter(emojiCategory, "emojiCategory");
            switch (emojiCategory) {
                case FAVORITE:
                    return R.drawable.ic_emoji_picker_category_favorites_star;
                case RECENT:
                    return R.drawable.ic_emoji_picker_category_recent;
                case CUSTOM:
                default:
                    return R.drawable.ic_emoji_picker_category_custom;
                case PEOPLE:
                    return R.drawable.ic_emoji_picker_category_people;
                case NATURE:
                    return R.drawable.ic_emoji_picker_category_nature;
                case FOOD:
                    return R.drawable.ic_emoji_picker_category_food;
                case ACTIVITY:
                    return R.drawable.ic_emoji_picker_category_activity;
                case TRAVEL:
                    return R.drawable.ic_emoji_picker_category_travel;
                case OBJECTS:
                    return R.drawable.ic_emoji_picker_category_objects;
                case SYMBOLS:
                    return R.drawable.ic_emoji_picker_category_symbols;
                case FLAGS:
                    return R.drawable.ic_emoji_picker_category_flags;
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: EmojiCategoryViewHolder.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\r\u0010\u000eJ)\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0004\b\b\u0010\tR\u0016\u0010\u000b\u001a\u00020\n8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\f¨\u0006\u000f"}, d2 = {"Lcom/discord/widgets/chat/input/emoji/EmojiCategoryViewHolder$Guild;", "Lcom/discord/widgets/chat/input/emoji/EmojiCategoryViewHolder;", "Lcom/discord/widgets/chat/input/emoji/EmojiCategoryItem$GuildItem;", "guildCategoryItem", "Lkotlin/Function1;", "Lcom/discord/widgets/chat/input/emoji/EmojiCategoryItem;", "", "onCategoryClicked", "configure", "(Lcom/discord/widgets/chat/input/emoji/EmojiCategoryItem$GuildItem;Lkotlin/jvm/functions/Function1;)V", "Lcom/discord/databinding/EmojiCategoryItemGuildBinding;", "binding", "Lcom/discord/databinding/EmojiCategoryItemGuildBinding;", "<init>", "(Lcom/discord/databinding/EmojiCategoryItemGuildBinding;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Guild extends EmojiCategoryViewHolder {
        private final EmojiCategoryItemGuildBinding binding;

        /* JADX WARN: Illegal instructions before constructor call */
        public Guild(EmojiCategoryItemGuildBinding emojiCategoryItemGuildBinding) {
            Intrinsics3.checkNotNullParameter(emojiCategoryItemGuildBinding, "binding");
            FrameLayout frameLayout = emojiCategoryItemGuildBinding.a;
            Intrinsics3.checkNotNullExpressionValue(frameLayout, "binding.root");
            super(frameLayout, null);
            this.binding = emojiCategoryItemGuildBinding;
        }

        public final void configure(EmojiCategoryItem.GuildItem guildCategoryItem, Function1<? super EmojiCategoryItem, Unit> onCategoryClicked) {
            Intrinsics3.checkNotNullParameter(guildCategoryItem, "guildCategoryItem");
            Intrinsics3.checkNotNullParameter(onCategoryClicked, "onCategoryClicked");
            this.binding.f2099b.updateView(guildCategoryItem.getGuild());
            View view = this.binding.c.f163b;
            Intrinsics3.checkNotNullExpressionValue(view, "binding.overline.express…CategorySelectionOverline");
            view.setVisibility(guildCategoryItem.getIsSelected() ? 0 : 8);
            this.itemView.setOnClickListener(new EmojiCategoryViewHolder2(onCategoryClicked, guildCategoryItem));
            View view2 = this.itemView;
            Intrinsics3.checkNotNullExpressionValue(view2, "itemView");
            view2.setContentDescription(guildCategoryItem.getGuild().getName());
        }
    }

    /* compiled from: EmojiCategoryViewHolder.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\r\u0010\u000eJ)\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0004\b\b\u0010\tR\u0016\u0010\u000b\u001a\u00020\n8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\f¨\u0006\u000f"}, d2 = {"Lcom/discord/widgets/chat/input/emoji/EmojiCategoryViewHolder$Standard;", "Lcom/discord/widgets/chat/input/emoji/EmojiCategoryViewHolder;", "Lcom/discord/widgets/chat/input/emoji/EmojiCategoryItem$StandardItem;", "standardCategoryItem", "Lkotlin/Function1;", "Lcom/discord/widgets/chat/input/emoji/EmojiCategoryItem;", "", "onCategoryClicked", "configure", "(Lcom/discord/widgets/chat/input/emoji/EmojiCategoryItem$StandardItem;Lkotlin/jvm/functions/Function1;)V", "Lcom/discord/databinding/EmojiCategoryItemStandardBinding;", "binding", "Lcom/discord/databinding/EmojiCategoryItemStandardBinding;", "<init>", "(Lcom/discord/databinding/EmojiCategoryItemStandardBinding;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Standard extends EmojiCategoryViewHolder {
        private final EmojiCategoryItemStandardBinding binding;

        /* JADX WARN: Illegal instructions before constructor call */
        public Standard(EmojiCategoryItemStandardBinding emojiCategoryItemStandardBinding) {
            Intrinsics3.checkNotNullParameter(emojiCategoryItemStandardBinding, "binding");
            FrameLayout frameLayout = emojiCategoryItemStandardBinding.a;
            Intrinsics3.checkNotNullExpressionValue(frameLayout, "binding.root");
            super(frameLayout, null);
            this.binding = emojiCategoryItemStandardBinding;
        }

        public final void configure(EmojiCategoryItem.StandardItem standardCategoryItem, Function1<? super EmojiCategoryItem, Unit> onCategoryClicked) {
            int themedColor;
            Intrinsics3.checkNotNullParameter(standardCategoryItem, "standardCategoryItem");
            Intrinsics3.checkNotNullParameter(onCategoryClicked, "onCategoryClicked");
            EmojiCategory emojiCategory = standardCategoryItem.getEmojiCategory();
            int categoryIconResId = EmojiCategoryViewHolder.INSTANCE.getCategoryIconResId(emojiCategory);
            ImageView imageView = this.binding.f2100b;
            View view = this.itemView;
            Intrinsics3.checkNotNullExpressionValue(view, "itemView");
            imageView.setImageDrawable(ResourcesCompat.getDrawable(view.getResources(), categoryIconResId, null));
            boolean isSelected = standardCategoryItem.getIsSelected();
            ImageView imageView2 = this.binding.f2100b;
            Intrinsics3.checkNotNullExpressionValue(imageView2, "binding.emojiCategoryItemStandardIcon");
            imageView2.setSelected(isSelected);
            View view2 = this.binding.c.f163b;
            Intrinsics3.checkNotNullExpressionValue(view2, "binding.overline.express…CategorySelectionOverline");
            view2.setVisibility(isSelected ? 0 : 8);
            if (isSelected) {
                ImageView imageView3 = this.binding.f2100b;
                Intrinsics3.checkNotNullExpressionValue(imageView3, "binding.emojiCategoryItemStandardIcon");
                themedColor = ColorCompat.getThemedColor(imageView3, R.attr.colorInteractiveActive);
            } else {
                ImageView imageView4 = this.binding.f2100b;
                Intrinsics3.checkNotNullExpressionValue(imageView4, "binding.emojiCategoryItemStandardIcon");
                themedColor = ColorCompat.getThemedColor(imageView4, R.attr.colorInteractiveNormal);
            }
            ImageView imageView5 = this.binding.f2100b;
            Intrinsics3.checkNotNullExpressionValue(imageView5, "binding.emojiCategoryItemStandardIcon");
            ColorCompat2.tintWithColor(imageView5, themedColor);
            ImageView imageView6 = this.binding.f2100b;
            Intrinsics3.checkNotNullExpressionValue(imageView6, "binding.emojiCategoryItemStandardIcon");
            imageView6.setAlpha(isSelected ? 1.0f : 0.5f);
            this.itemView.setOnClickListener(new EmojiCategoryViewHolder3(onCategoryClicked, standardCategoryItem));
            View view3 = this.itemView;
            Intrinsics3.checkNotNullExpressionValue(view3, "itemView");
            view3.setContentDescription(emojiCategory.name());
        }
    }

    private EmojiCategoryViewHolder(View view) {
        super(view);
    }

    public /* synthetic */ EmojiCategoryViewHolder(View view, DefaultConstructorMarker defaultConstructorMarker) {
        this(view);
    }
}

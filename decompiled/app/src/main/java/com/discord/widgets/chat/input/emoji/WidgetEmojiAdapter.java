package com.discord.widgets.chat.input.emoji;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.StringRes;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import b.a.k.FormatUtils;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.databinding.EmojiPickerEmojiItemBinding;
import com.discord.databinding.EmojiPickerPremiumUpsellBinding;
import com.discord.databinding.ExpressionPickerHeaderItemBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.domain.emoji.Emoji;
import com.discord.models.domain.emoji.EmojiCategory;
import com.discord.models.guild.Guild;
import com.discord.utilities.KotlinExtensions;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.images.MGImages;
import com.discord.utilities.mg_recycler.MGRecyclerDataPayload;
import com.discord.utilities.mg_recycler.MGRecyclerViewHolder;
import com.discord.utilities.view.extensions.ImageViewExtensions;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.widgets.chat.input.expression.WidgetExpressionPickerAdapter;
import com.facebook.drawee.view.SimpleDraweeView;
import d0.d0._Ranges;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: WidgetEmojiAdapter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 +2\u00020\u0001:\u0007+,-./01B;\u0012\u0006\u0010(\u001a\u00020'\u0012\u0006\u0010\u001c\u001a\u00020\u001b\u0012\u0006\u0010%\u001a\u00020$\u0012\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016\u0012\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016¢\u0006\u0004\b)\u0010*J+\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\u0001H\u0016¢\u0006\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0012\u001a\u00020\u00048\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00170\u00168\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u001c\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00170\u00168\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u0019R\u0016\u0010\u001c\u001a\u00020\u001b8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010\u001e\u001a\u00020\u00048\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u0013R\u001c\u0010 \u001a\u00020\u001f8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#R\u0016\u0010%\u001a\u00020$8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b%\u0010&¨\u00062"}, d2 = {"Lcom/discord/widgets/chat/input/emoji/WidgetEmojiAdapter;", "Lcom/discord/widgets/chat/input/expression/WidgetExpressionPickerAdapter;", "Landroid/view/ViewGroup;", "parent", "", "viewType", "Lcom/discord/utilities/mg_recycler/MGRecyclerViewHolder;", "Lcom/discord/utilities/mg_recycler/MGRecyclerDataPayload;", "onCreateViewHolder", "(Landroid/view/ViewGroup;I)Lcom/discord/utilities/mg_recycler/MGRecyclerViewHolder;", ModelAuditLogEntry.CHANGE_KEY_POSITION, "", "isHeader", "(I)Z", "adapter", "Lcom/discord/widgets/chat/input/emoji/WidgetEmojiAdapter$HeaderViewHolder;", "createStickyHeaderViewHolder", "(Lcom/discord/widgets/chat/input/expression/WidgetExpressionPickerAdapter;)Lcom/discord/widgets/chat/input/emoji/WidgetEmojiAdapter$HeaderViewHolder;", "numColumns", "I", "getNumColumns", "()I", "Lkotlin/Function0;", "", "onGetPremiumCtaClicked", "Lkotlin/jvm/functions/Function0;", "hideKeyboard", "Landroidx/fragment/app/FragmentManager;", "fragmentManager", "Landroidx/fragment/app/FragmentManager;", "emojiSizePx", "Landroidx/recyclerview/widget/GridLayoutManager;", "layoutManager", "Landroidx/recyclerview/widget/GridLayoutManager;", "getLayoutManager", "()Landroidx/recyclerview/widget/GridLayoutManager;", "Lcom/discord/widgets/chat/input/emoji/OnEmojiSelectedListener;", "onEmojiSelectedListener", "Lcom/discord/widgets/chat/input/emoji/OnEmojiSelectedListener;", "Landroidx/recyclerview/widget/RecyclerView;", "recycler", "<init>", "(Landroidx/recyclerview/widget/RecyclerView;Landroidx/fragment/app/FragmentManager;Lcom/discord/widgets/chat/input/emoji/OnEmojiSelectedListener;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "Companion", "EmojiItem", "EmojiViewHolder", "HeaderItem", "HeaderViewHolder", "PremiumEmojiUpsellViewHolder", "UpsellItem", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetEmojiAdapter extends WidgetExpressionPickerAdapter {
    private static final int DEFAULT_NUM_COLUMNS = 8;
    private static final int ITEM_TYPE_EMOJI = 1;
    private static final int ITEM_TYPE_PREMIUM_UPSELL = 2;
    private static final int MAX_EMOJI_SIZE_PX = 64;
    private final int emojiSizePx;
    private final FragmentManager fragmentManager;
    private final Function0<Unit> hideKeyboard;
    private final GridLayoutManager layoutManager;
    private final int numColumns;
    private final OnEmojiSelectedListener onEmojiSelectedListener;
    private final Function0<Unit> onGetPremiumCtaClicked;

    /* compiled from: WidgetEmojiAdapter.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"com/discord/widgets/chat/input/emoji/WidgetEmojiAdapter$1", "Landroidx/recyclerview/widget/GridLayoutManager$SpanSizeLookup;", "", ModelAuditLogEntry.CHANGE_KEY_POSITION, "getSpanSize", "(I)I", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.chat.input.emoji.WidgetEmojiAdapter$1, reason: invalid class name */
    public static final class AnonymousClass1 extends GridLayoutManager.SpanSizeLookup {
        public AnonymousClass1() {
        }

        @Override // androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
        public int getSpanSize(int position) {
            int itemViewType = WidgetEmojiAdapter.this.getItemViewType(position);
            if (itemViewType == 0 || itemViewType == 2) {
                return WidgetEmojiAdapter.this.getNumColumns();
            }
            return 1;
        }
    }

    /* compiled from: WidgetEmojiAdapter.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u000f\u0012\u0006\u0010\r\u001a\u00020\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u001f\u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\b\u0010\tR\u0016\u0010\u000b\u001a\u00020\n8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\f¨\u0006\u0010"}, d2 = {"Lcom/discord/widgets/chat/input/emoji/WidgetEmojiAdapter$EmojiViewHolder;", "Lcom/discord/utilities/mg_recycler/MGRecyclerViewHolder;", "Lcom/discord/widgets/chat/input/emoji/WidgetEmojiAdapter;", "Lcom/discord/utilities/mg_recycler/MGRecyclerDataPayload;", "", ModelAuditLogEntry.CHANGE_KEY_POSITION, "data", "", "onConfigure", "(ILcom/discord/utilities/mg_recycler/MGRecyclerDataPayload;)V", "Lcom/discord/databinding/EmojiPickerEmojiItemBinding;", "binding", "Lcom/discord/databinding/EmojiPickerEmojiItemBinding;", "adapter", "<init>", "(Lcom/discord/widgets/chat/input/emoji/WidgetEmojiAdapter;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class EmojiViewHolder extends MGRecyclerViewHolder<WidgetEmojiAdapter, MGRecyclerDataPayload> {
        private final EmojiPickerEmojiItemBinding binding;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public EmojiViewHolder(WidgetEmojiAdapter widgetEmojiAdapter) {
            super(R.layout.emoji_picker_emoji_item, widgetEmojiAdapter);
            Intrinsics3.checkNotNullParameter(widgetEmojiAdapter, "adapter");
            View view = this.itemView;
            Objects.requireNonNull(view, "rootView");
            SimpleDraweeView simpleDraweeView = (SimpleDraweeView) view;
            EmojiPickerEmojiItemBinding emojiPickerEmojiItemBinding = new EmojiPickerEmojiItemBinding(simpleDraweeView, simpleDraweeView);
            Intrinsics3.checkNotNullExpressionValue(emojiPickerEmojiItemBinding, "EmojiPickerEmojiItemBinding.bind(itemView)");
            this.binding = emojiPickerEmojiItemBinding;
        }

        public static final /* synthetic */ WidgetEmojiAdapter access$getAdapter$p(EmojiViewHolder emojiViewHolder) {
            return (WidgetEmojiAdapter) emojiViewHolder.adapter;
        }

        public static final /* synthetic */ EmojiPickerEmojiItemBinding access$getBinding$p(EmojiViewHolder emojiViewHolder) {
            return emojiViewHolder.binding;
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
        public /* bridge */ /* synthetic */ void onConfigure(int i, MGRecyclerDataPayload mGRecyclerDataPayload) {
            onConfigure2(i, mGRecyclerDataPayload);
        }

        /* renamed from: onConfigure, reason: avoid collision after fix types in other method */
        public void onConfigure2(int position, MGRecyclerDataPayload data) {
            Intrinsics3.checkNotNullParameter(data, "data");
            super.onConfigure(position, (int) data);
            if (!(data instanceof EmojiItem)) {
                data = null;
            }
            EmojiItem emojiItem = (EmojiItem) data;
            if (emojiItem != null) {
                Emoji emoji = emojiItem.getEmoji();
                int iCoerceAtMost = _Ranges.coerceAtMost(IconUtils.getMediaProxySize(WidgetEmojiAdapter.access$getEmojiSizePx$p((WidgetEmojiAdapter) this.adapter)), 64);
                boolean allowEmojisToAnimate = emojiItem.getAllowEmojisToAnimate();
                SimpleDraweeView simpleDraweeView = this.binding.f2101b;
                Intrinsics3.checkNotNullExpressionValue(simpleDraweeView, "binding.emojiItemDraweeview");
                String imageUri = emoji.getImageUri(allowEmojisToAnimate, iCoerceAtMost, simpleDraweeView.getContext());
                SimpleDraweeView simpleDraweeView2 = this.binding.f2101b;
                Intrinsics3.checkNotNullExpressionValue(simpleDraweeView2, "binding.emojiItemDraweeview");
                MGImages.setImage$default(simpleDraweeView2, imageUri, 0, 0, true, null, null, 108, null);
                SimpleDraweeView simpleDraweeView3 = this.binding.f2101b;
                Intrinsics3.checkNotNullExpressionValue(simpleDraweeView3, "binding.emojiItemDraweeview");
                ImageViewExtensions.setGrayscale(simpleDraweeView3, (emoji.isUsable() && emoji.isAvailable()) ? false : true);
                SimpleDraweeView simpleDraweeView4 = this.binding.f2101b;
                Intrinsics3.checkNotNullExpressionValue(simpleDraweeView4, "binding.emojiItemDraweeview");
                simpleDraweeView4.setImageAlpha((emoji.isUsable() && emoji.isAvailable()) ? 255 : 100);
                SimpleDraweeView simpleDraweeView5 = this.binding.f2101b;
                Intrinsics3.checkNotNullExpressionValue(simpleDraweeView5, "binding.emojiItemDraweeview");
                simpleDraweeView5.setContentDescription(emoji.getFirstName());
                this.binding.a.setOnClickListener(new WidgetEmojiAdapter2(this, emoji));
                SimpleDraweeView simpleDraweeView6 = this.binding.a;
                Intrinsics3.checkNotNullExpressionValue(simpleDraweeView6, "binding.root");
                ViewExtensions.setOnLongClickListenerConsumeClick(simpleDraweeView6, new WidgetEmojiAdapter3(this, emojiItem));
            }
        }
    }

    /* compiled from: WidgetEmojiAdapter.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\t\n\u000bB\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bR\u001c\u0010\u0003\u001a\u00020\u00028\u0016@\u0016X\u0096D¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u0082\u0001\u0003\f\r\u000e¨\u0006\u000f"}, d2 = {"Lcom/discord/widgets/chat/input/emoji/WidgetEmojiAdapter$HeaderItem;", "Lcom/discord/utilities/mg_recycler/MGRecyclerDataPayload;", "", "type", "I", "getType", "()I", "<init>", "()V", "GuildHeaderItem", "StandardHeaderItem", "StringHeaderItem", "Lcom/discord/widgets/chat/input/emoji/WidgetEmojiAdapter$HeaderItem$GuildHeaderItem;", "Lcom/discord/widgets/chat/input/emoji/WidgetEmojiAdapter$HeaderItem$StandardHeaderItem;", "Lcom/discord/widgets/chat/input/emoji/WidgetEmojiAdapter$HeaderItem$StringHeaderItem;", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static abstract class HeaderItem implements MGRecyclerDataPayload {
        private final int type;

        /* compiled from: WidgetEmojiAdapter.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\u0016\u0010\u0017B\u0011\b\u0016\u0012\u0006\u0010\u0019\u001a\u00020\u0018¢\u0006\u0004\b\u0016\u0010\u001aJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J$\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0006\u001a\u00020\u00022\b\b\u0002\u0010\u0007\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\n\u0010\u0004J\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0007\u001a\u00020\u00028\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0013\u001a\u0004\b\u0014\u0010\u0004R\u0019\u0010\u0006\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0013\u001a\u0004\b\u0015\u0010\u0004¨\u0006\u001b"}, d2 = {"Lcom/discord/widgets/chat/input/emoji/WidgetEmojiAdapter$HeaderItem$GuildHeaderItem;", "Lcom/discord/widgets/chat/input/emoji/WidgetEmojiAdapter$HeaderItem;", "", "component1", "()Ljava/lang/String;", "component2", NotificationCompat.MessagingStyle.Message.KEY_TEXT, "key", "copy", "(Ljava/lang/String;Ljava/lang/String;)Lcom/discord/widgets/chat/input/emoji/WidgetEmojiAdapter$HeaderItem$GuildHeaderItem;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getKey", "getText", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "Lcom/discord/models/guild/Guild;", "guild", "(Lcom/discord/models/guild/Guild;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final /* data */ class GuildHeaderItem extends HeaderItem {
            private final String key;
            private final String text;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public GuildHeaderItem(String str, String str2) {
                super(null);
                Intrinsics3.checkNotNullParameter(str, NotificationCompat.MessagingStyle.Message.KEY_TEXT);
                Intrinsics3.checkNotNullParameter(str2, "key");
                this.text = str;
                this.key = str2;
            }

            public static /* synthetic */ GuildHeaderItem copy$default(GuildHeaderItem guildHeaderItem, String str, String str2, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = guildHeaderItem.text;
                }
                if ((i & 2) != 0) {
                    str2 = guildHeaderItem.getKey();
                }
                return guildHeaderItem.copy(str, str2);
            }

            /* renamed from: component1, reason: from getter */
            public final String getText() {
                return this.text;
            }

            public final String component2() {
                return getKey();
            }

            public final GuildHeaderItem copy(String text, String key) {
                Intrinsics3.checkNotNullParameter(text, NotificationCompat.MessagingStyle.Message.KEY_TEXT);
                Intrinsics3.checkNotNullParameter(key, "key");
                return new GuildHeaderItem(text, key);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof GuildHeaderItem)) {
                    return false;
                }
                GuildHeaderItem guildHeaderItem = (GuildHeaderItem) other;
                return Intrinsics3.areEqual(this.text, guildHeaderItem.text) && Intrinsics3.areEqual(getKey(), guildHeaderItem.getKey());
            }

            @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
            public String getKey() {
                return this.key;
            }

            public final String getText() {
                return this.text;
            }

            public int hashCode() {
                String str = this.text;
                int iHashCode = (str != null ? str.hashCode() : 0) * 31;
                String key = getKey();
                return iHashCode + (key != null ? key.hashCode() : 0);
            }

            public String toString() {
                StringBuilder sbU = outline.U("GuildHeaderItem(text=");
                sbU.append(this.text);
                sbU.append(", key=");
                sbU.append(getKey());
                sbU.append(")");
                return sbU.toString();
            }

            /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
            public GuildHeaderItem(Guild guild) {
                this(guild.getName(), String.valueOf(guild.getId()));
                Intrinsics3.checkNotNullParameter(guild, "guild");
            }
        }

        /* compiled from: WidgetEmojiAdapter.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u0019\u0010\u0005\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0013\u001a\u0004\b\u0014\u0010\u0004R\u001c\u0010\u0015\u001a\u00020\b8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\n¨\u0006\u001a"}, d2 = {"Lcom/discord/widgets/chat/input/emoji/WidgetEmojiAdapter$HeaderItem$StandardHeaderItem;", "Lcom/discord/widgets/chat/input/emoji/WidgetEmojiAdapter$HeaderItem;", "Lcom/discord/models/domain/emoji/EmojiCategory;", "component1", "()Lcom/discord/models/domain/emoji/EmojiCategory;", "emojiCategory", "copy", "(Lcom/discord/models/domain/emoji/EmojiCategory;)Lcom/discord/widgets/chat/input/emoji/WidgetEmojiAdapter$HeaderItem$StandardHeaderItem;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/discord/models/domain/emoji/EmojiCategory;", "getEmojiCategory", "key", "Ljava/lang/String;", "getKey", "<init>", "(Lcom/discord/models/domain/emoji/EmojiCategory;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final /* data */ class StandardHeaderItem extends HeaderItem {
            private final EmojiCategory emojiCategory;
            private final String key;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public StandardHeaderItem(EmojiCategory emojiCategory) {
                super(null);
                Intrinsics3.checkNotNullParameter(emojiCategory, "emojiCategory");
                this.emojiCategory = emojiCategory;
                this.key = emojiCategory.name();
            }

            public static /* synthetic */ StandardHeaderItem copy$default(StandardHeaderItem standardHeaderItem, EmojiCategory emojiCategory, int i, Object obj) {
                if ((i & 1) != 0) {
                    emojiCategory = standardHeaderItem.emojiCategory;
                }
                return standardHeaderItem.copy(emojiCategory);
            }

            /* renamed from: component1, reason: from getter */
            public final EmojiCategory getEmojiCategory() {
                return this.emojiCategory;
            }

            public final StandardHeaderItem copy(EmojiCategory emojiCategory) {
                Intrinsics3.checkNotNullParameter(emojiCategory, "emojiCategory");
                return new StandardHeaderItem(emojiCategory);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof StandardHeaderItem) && Intrinsics3.areEqual(this.emojiCategory, ((StandardHeaderItem) other).emojiCategory);
                }
                return true;
            }

            public final EmojiCategory getEmojiCategory() {
                return this.emojiCategory;
            }

            @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
            public String getKey() {
                return this.key;
            }

            public int hashCode() {
                EmojiCategory emojiCategory = this.emojiCategory;
                if (emojiCategory != null) {
                    return emojiCategory.hashCode();
                }
                return 0;
            }

            public String toString() {
                StringBuilder sbU = outline.U("StandardHeaderItem(emojiCategory=");
                sbU.append(this.emojiCategory);
                sbU.append(")");
                return sbU.toString();
            }
        }

        /* compiled from: WidgetEmojiAdapter.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0003\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000b\u0010\u0004J\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fHÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010R\u0019\u0010\u0005\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0011\u001a\u0004\b\u0012\u0010\u0004R\u001c\u0010\u0013\u001a\u00020\b8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\n¨\u0006\u0018"}, d2 = {"Lcom/discord/widgets/chat/input/emoji/WidgetEmojiAdapter$HeaderItem$StringHeaderItem;", "Lcom/discord/widgets/chat/input/emoji/WidgetEmojiAdapter$HeaderItem;", "", "component1", "()I", "stringRes", "copy", "(I)Lcom/discord/widgets/chat/input/emoji/WidgetEmojiAdapter$HeaderItem$StringHeaderItem;", "", "toString", "()Ljava/lang/String;", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "I", "getStringRes", "key", "Ljava/lang/String;", "getKey", "<init>", "(I)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final /* data */ class StringHeaderItem extends HeaderItem {
            private final String key;
            private final int stringRes;

            public StringHeaderItem(@StringRes int i) {
                super(null);
                this.stringRes = i;
                this.key = String.valueOf(i);
            }

            public static /* synthetic */ StringHeaderItem copy$default(StringHeaderItem stringHeaderItem, int i, int i2, Object obj) {
                if ((i2 & 1) != 0) {
                    i = stringHeaderItem.stringRes;
                }
                return stringHeaderItem.copy(i);
            }

            /* renamed from: component1, reason: from getter */
            public final int getStringRes() {
                return this.stringRes;
            }

            public final StringHeaderItem copy(@StringRes int stringRes) {
                return new StringHeaderItem(stringRes);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof StringHeaderItem) && this.stringRes == ((StringHeaderItem) other).stringRes;
                }
                return true;
            }

            @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
            public String getKey() {
                return this.key;
            }

            public final int getStringRes() {
                return this.stringRes;
            }

            public int hashCode() {
                return this.stringRes;
            }

            public String toString() {
                return outline.B(outline.U("StringHeaderItem(stringRes="), this.stringRes, ")");
            }
        }

        private HeaderItem() {
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload
        public int getType() {
            return this.type;
        }

        public /* synthetic */ HeaderItem(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetEmojiAdapter.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u001c2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004:\u0001\u001cB\u000f\u0012\u0006\u0010\u0019\u001a\u00020\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u001f\u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\f\u0010\rJ\u001f\u0010\u000e\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\u000e\u0010\nR\"\u0010\u0010\u001a\u00020\u000f8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0017\u001a\u00020\u00168\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018¨\u0006\u001d"}, d2 = {"Lcom/discord/widgets/chat/input/emoji/WidgetEmojiAdapter$HeaderViewHolder;", "Lcom/discord/utilities/mg_recycler/MGRecyclerViewHolder;", "Lcom/discord/widgets/chat/input/emoji/WidgetEmojiAdapter;", "Lcom/discord/utilities/mg_recycler/MGRecyclerDataPayload;", "Lcom/discord/widgets/chat/input/expression/WidgetExpressionPickerAdapter$StickyHeaderViewHolder;", "", ModelAuditLogEntry.CHANGE_KEY_POSITION, "data", "", "bind", "(ILcom/discord/utilities/mg_recycler/MGRecyclerDataPayload;)V", "Landroid/view/View;", "getItemView", "()Landroid/view/View;", "onConfigure", "Lcom/discord/widgets/chat/input/emoji/WidgetEmojiAdapter$HeaderItem;", "boundItem", "Lcom/discord/widgets/chat/input/emoji/WidgetEmojiAdapter$HeaderItem;", "getBoundItem", "()Lcom/discord/widgets/chat/input/emoji/WidgetEmojiAdapter$HeaderItem;", "setBoundItem", "(Lcom/discord/widgets/chat/input/emoji/WidgetEmojiAdapter$HeaderItem;)V", "Lcom/discord/databinding/ExpressionPickerHeaderItemBinding;", "binding", "Lcom/discord/databinding/ExpressionPickerHeaderItemBinding;", "adapter", "<init>", "(Lcom/discord/widgets/chat/input/emoji/WidgetEmojiAdapter;)V", "Companion", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class HeaderViewHolder extends MGRecyclerViewHolder<WidgetEmojiAdapter, MGRecyclerDataPayload> implements WidgetExpressionPickerAdapter.StickyHeaderViewHolder {

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final ExpressionPickerHeaderItemBinding binding;
        public HeaderItem boundItem;

        /* compiled from: WidgetEmojiAdapter.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/discord/widgets/chat/input/emoji/WidgetEmojiAdapter$HeaderViewHolder$Companion;", "", "Lcom/discord/models/domain/emoji/EmojiCategory;", "emojiCategory", "", "getCategoryString", "(Lcom/discord/models/domain/emoji/EmojiCategory;)I", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
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
                    iArr[EmojiCategory.CUSTOM.ordinal()] = 10;
                    iArr[EmojiCategory.RECENT.ordinal()] = 11;
                }
            }

            private Companion() {
            }

            @StringRes
            public final int getCategoryString(EmojiCategory emojiCategory) {
                Intrinsics3.checkNotNullParameter(emojiCategory, "emojiCategory");
                switch (emojiCategory) {
                    case FAVORITE:
                        return R.string.category_favorite;
                    case RECENT:
                        return R.string.emoji_category_recent;
                    case CUSTOM:
                        return R.string.emoji_category_custom;
                    case PEOPLE:
                        return R.string.emoji_category_people;
                    case NATURE:
                        return R.string.emoji_category_nature;
                    case FOOD:
                        return R.string.emoji_category_food;
                    case ACTIVITY:
                        return R.string.emoji_category_activity;
                    case TRAVEL:
                        return R.string.emoji_category_travel;
                    case OBJECTS:
                        return R.string.emoji_category_objects;
                    case SYMBOLS:
                        return R.string.emoji_category_symbols;
                    case FLAGS:
                        return R.string.emoji_category_flags;
                    default:
                        throw new NoWhenBranchMatchedException();
                }
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public HeaderViewHolder(WidgetEmojiAdapter widgetEmojiAdapter) {
            super(R.layout.expression_picker_header_item, widgetEmojiAdapter);
            Intrinsics3.checkNotNullParameter(widgetEmojiAdapter, "adapter");
            View view = this.itemView;
            Objects.requireNonNull(view, "rootView");
            TextView textView = (TextView) view;
            ExpressionPickerHeaderItemBinding expressionPickerHeaderItemBinding = new ExpressionPickerHeaderItemBinding(textView, textView);
            Intrinsics3.checkNotNullExpressionValue(expressionPickerHeaderItemBinding, "ExpressionPickerHeaderItemBinding.bind(itemView)");
            this.binding = expressionPickerHeaderItemBinding;
        }

        @Override // com.discord.widgets.chat.input.expression.WidgetExpressionPickerAdapter.StickyHeaderViewHolder
        public void bind(int position, MGRecyclerDataPayload data) {
            Intrinsics3.checkNotNullParameter(data, "data");
            onConfigure2(position, data);
        }

        public final HeaderItem getBoundItem() {
            HeaderItem headerItem = this.boundItem;
            if (headerItem == null) {
                Intrinsics3.throwUninitializedPropertyAccessException("boundItem");
            }
            return headerItem;
        }

        @Override // com.discord.widgets.chat.input.expression.WidgetExpressionPickerAdapter.StickyHeaderViewHolder
        public View getItemView() {
            View view = this.itemView;
            Intrinsics3.checkNotNullExpressionValue(view, "itemView");
            return view;
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
        public /* bridge */ /* synthetic */ void onConfigure(int i, MGRecyclerDataPayload mGRecyclerDataPayload) {
            onConfigure2(i, mGRecyclerDataPayload);
        }

        public final void setBoundItem(HeaderItem headerItem) {
            Intrinsics3.checkNotNullParameter(headerItem, "<set-?>");
            this.boundItem = headerItem;
        }

        /* renamed from: onConfigure, reason: avoid collision after fix types in other method */
        public void onConfigure2(int position, MGRecyclerDataPayload data) {
            Unit unit;
            Intrinsics3.checkNotNullParameter(data, "data");
            super.onConfigure(position, (int) data);
            if (!(data instanceof HeaderItem)) {
                data = null;
            }
            HeaderItem headerItem = (HeaderItem) data;
            if (headerItem != null) {
                this.boundItem = headerItem;
                if (headerItem instanceof HeaderItem.StandardHeaderItem) {
                    TextView textView = this.binding.f2105b;
                    Intrinsics3.checkNotNullExpressionValue(textView, "binding.headerItemText");
                    FormatUtils.n(textView, INSTANCE.getCategoryString(((HeaderItem.StandardHeaderItem) headerItem).getEmojiCategory()), new Object[0], null, 4);
                    unit = Unit.a;
                } else if (headerItem instanceof HeaderItem.GuildHeaderItem) {
                    TextView textView2 = this.binding.f2105b;
                    Intrinsics3.checkNotNullExpressionValue(textView2, "binding.headerItemText");
                    textView2.setText(((HeaderItem.GuildHeaderItem) headerItem).getText());
                    unit = Unit.a;
                } else {
                    if (!(headerItem instanceof HeaderItem.StringHeaderItem)) {
                        throw new NoWhenBranchMatchedException();
                    }
                    TextView textView3 = this.binding.f2105b;
                    Intrinsics3.checkNotNullExpressionValue(textView3, "binding.headerItemText");
                    FormatUtils.n(textView3, ((HeaderItem.StringHeaderItem) headerItem).getStringRes(), new Object[0], null, 4);
                    unit = Unit.a;
                }
                KotlinExtensions.getExhaustive(unit);
            }
        }
    }

    /* compiled from: WidgetEmojiAdapter.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tR\u0016\u0010\u0005\u001a\u00020\u00048\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/discord/widgets/chat/input/emoji/WidgetEmojiAdapter$PremiumEmojiUpsellViewHolder;", "Lcom/discord/utilities/mg_recycler/MGRecyclerViewHolder;", "Lcom/discord/widgets/chat/input/emoji/WidgetEmojiAdapter;", "Lcom/discord/utilities/mg_recycler/MGRecyclerDataPayload;", "Lcom/discord/databinding/EmojiPickerPremiumUpsellBinding;", "binding", "Lcom/discord/databinding/EmojiPickerPremiumUpsellBinding;", "adapter", "<init>", "(Lcom/discord/widgets/chat/input/emoji/WidgetEmojiAdapter;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class PremiumEmojiUpsellViewHolder extends MGRecyclerViewHolder<WidgetEmojiAdapter, MGRecyclerDataPayload> {
        private final EmojiPickerPremiumUpsellBinding binding;

        /* compiled from: WidgetEmojiAdapter.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.widgets.chat.input.emoji.WidgetEmojiAdapter$PremiumEmojiUpsellViewHolder$1, reason: invalid class name */
        public static final class AnonymousClass1 implements View.OnClickListener {
            public final /* synthetic */ WidgetEmojiAdapter $adapter;

            public AnonymousClass1(WidgetEmojiAdapter widgetEmojiAdapter) {
                this.$adapter = widgetEmojiAdapter;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WidgetEmojiAdapter.access$getOnGetPremiumCtaClicked$p(this.$adapter).invoke();
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public PremiumEmojiUpsellViewHolder(WidgetEmojiAdapter widgetEmojiAdapter) {
            super(R.layout.emoji_picker_premium_upsell, widgetEmojiAdapter);
            Intrinsics3.checkNotNullParameter(widgetEmojiAdapter, "adapter");
            View view = this.itemView;
            TextView textView = (TextView) view.findViewById(R.id.emojiPickerPremiumCta);
            if (textView == null) {
                throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(R.id.emojiPickerPremiumCta)));
            }
            EmojiPickerPremiumUpsellBinding emojiPickerPremiumUpsellBinding = new EmojiPickerPremiumUpsellBinding((LinearLayout) view, textView);
            Intrinsics3.checkNotNullExpressionValue(emojiPickerPremiumUpsellBinding, "EmojiPickerPremiumUpsellBinding.bind(itemView)");
            this.binding = emojiPickerPremiumUpsellBinding;
            textView.setOnClickListener(new AnonymousClass1(widgetEmojiAdapter));
        }
    }

    /* compiled from: WidgetEmojiAdapter.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\f\u0010\rR\u001c\u0010\u0003\u001a\u00020\u00028\u0016@\u0016X\u0096D¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u00020\u00078\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\u000e"}, d2 = {"Lcom/discord/widgets/chat/input/emoji/WidgetEmojiAdapter$UpsellItem;", "Lcom/discord/utilities/mg_recycler/MGRecyclerDataPayload;", "", "type", "I", "getType", "()I", "", "key", "Ljava/lang/String;", "getKey", "()Ljava/lang/String;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class UpsellItem implements MGRecyclerDataPayload {
        private static final String key;
        public static final UpsellItem INSTANCE = new UpsellItem();
        private static final int type = 2;

        static {
            String name = UpsellItem.class.getName();
            Intrinsics3.checkNotNullExpressionValue(name, "javaClass.name");
            key = name;
        }

        private UpsellItem() {
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
        public String getKey() {
            return key;
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload
        public int getType() {
            return type;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetEmojiAdapter(RecyclerView recyclerView, FragmentManager fragmentManager, OnEmojiSelectedListener onEmojiSelectedListener, Function0<Unit> function0, Function0<Unit> function02) {
        super(recyclerView, null, 2, null);
        Intrinsics3.checkNotNullParameter(recyclerView, "recycler");
        Intrinsics3.checkNotNullParameter(fragmentManager, "fragmentManager");
        Intrinsics3.checkNotNullParameter(onEmojiSelectedListener, "onEmojiSelectedListener");
        Intrinsics3.checkNotNullParameter(function0, "onGetPremiumCtaClicked");
        Intrinsics3.checkNotNullParameter(function02, "hideKeyboard");
        this.fragmentManager = fragmentManager;
        this.onEmojiSelectedListener = onEmojiSelectedListener;
        this.onGetPremiumCtaClicked = function0;
        this.hideKeyboard = function02;
        Context context = recyclerView.getContext();
        Intrinsics3.checkNotNullExpressionValue(context, "recycler.context");
        this.emojiSizePx = context.getResources().getDimensionPixelSize(R.dimen.chat_input_emoji_size);
        Context context2 = recyclerView.getContext();
        Intrinsics3.checkNotNullExpressionValue(context2, "recycler.context");
        this.numColumns = WidgetExpressionPickerAdapter.INSTANCE.calculateNumOfColumns(recyclerView, context2.getResources().getDimension(R.dimen.chat_input_emoji_size), 8);
        this.layoutManager = new GridLayoutManager(recyclerView.getContext(), getNumColumns());
        getLayoutManager().setSpanSizeLookup(new AnonymousClass1());
        recyclerView.setLayoutManager(getLayoutManager());
        recyclerView.setAdapter(this);
    }

    public static final /* synthetic */ int access$getEmojiSizePx$p(WidgetEmojiAdapter widgetEmojiAdapter) {
        return widgetEmojiAdapter.emojiSizePx;
    }

    public static final /* synthetic */ FragmentManager access$getFragmentManager$p(WidgetEmojiAdapter widgetEmojiAdapter) {
        return widgetEmojiAdapter.fragmentManager;
    }

    public static final /* synthetic */ Function0 access$getHideKeyboard$p(WidgetEmojiAdapter widgetEmojiAdapter) {
        return widgetEmojiAdapter.hideKeyboard;
    }

    public static final /* synthetic */ OnEmojiSelectedListener access$getOnEmojiSelectedListener$p(WidgetEmojiAdapter widgetEmojiAdapter) {
        return widgetEmojiAdapter.onEmojiSelectedListener;
    }

    public static final /* synthetic */ Function0 access$getOnGetPremiumCtaClicked$p(WidgetEmojiAdapter widgetEmojiAdapter) {
        return widgetEmojiAdapter.onGetPremiumCtaClicked;
    }

    @Override // com.discord.widgets.chat.input.expression.WidgetExpressionPickerAdapter
    public /* bridge */ /* synthetic */ WidgetExpressionPickerAdapter.StickyHeaderViewHolder createStickyHeaderViewHolder(WidgetExpressionPickerAdapter widgetExpressionPickerAdapter) {
        return createStickyHeaderViewHolder(widgetExpressionPickerAdapter);
    }

    @Override // com.discord.widgets.chat.input.expression.WidgetExpressionPickerAdapter
    public GridLayoutManager getLayoutManager() {
        return this.layoutManager;
    }

    @Override // com.discord.widgets.chat.input.expression.WidgetExpressionPickerAdapter
    public int getNumColumns() {
        return this.numColumns;
    }

    @Override // com.discord.utilities.views.StickyHeaderItemDecoration.StickyHeaderAdapter
    public boolean isHeader(int position) {
        return _Collections.getOrNull(getInternalData(), position) instanceof HeaderItem;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return onCreateViewHolder(viewGroup, i);
    }

    @Override // com.discord.widgets.chat.input.expression.WidgetExpressionPickerAdapter
    public HeaderViewHolder createStickyHeaderViewHolder(WidgetExpressionPickerAdapter adapter) {
        Intrinsics3.checkNotNullParameter(adapter, "adapter");
        return new HeaderViewHolder((WidgetEmojiAdapter) adapter);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public MGRecyclerViewHolder<WidgetEmojiAdapter, MGRecyclerDataPayload> onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics3.checkNotNullParameter(parent, "parent");
        if (viewType == 0) {
            return new HeaderViewHolder(this);
        }
        if (viewType == 1) {
            return new EmojiViewHolder(this);
        }
        if (viewType == 2) {
            return new PremiumEmojiUpsellViewHolder(this);
        }
        throw invalidViewTypeException(viewType);
    }

    /* compiled from: WidgetEmojiAdapter.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0012\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\r\u001a\u00020\u0005\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u000f\u001a\u00020\t¢\u0006\u0004\b&\u0010'J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\b\u0010\u0004J\u0010\u0010\n\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ:\u0010\u0010\u001a\u00020\u00002\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\r\u001a\u00020\u00052\b\b\u0002\u0010\u000e\u001a\u00020\u00022\b\b\u0002\u0010\u000f\u001a\u00020\tHÆ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0004J\u0010\u0010\u0014\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u001a\u0010\u0018\u001a\u00020\t2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016HÖ\u0003¢\u0006\u0004\b\u0018\u0010\u0019R\u001c\u0010\u001a\u001a\u00020\u00138\u0016@\u0016X\u0096D¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u0015R\u0019\u0010\u000e\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u001d\u001a\u0004\b\u001e\u0010\u0004R\u0019\u0010\u000f\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u001f\u001a\u0004\b \u0010\u000bR\u0019\u0010\r\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010!\u001a\u0004\b\"\u0010\u0007R\u001c\u0010#\u001a\u00020\u00028\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b#\u0010\u001d\u001a\u0004\b$\u0010\u0004R\u001b\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\u001d\u001a\u0004\b%\u0010\u0004¨\u0006("}, d2 = {"Lcom/discord/widgets/chat/input/emoji/WidgetEmojiAdapter$EmojiItem;", "Lcom/discord/utilities/mg_recycler/MGRecyclerDataPayload;", "", "component1", "()Ljava/lang/String;", "Lcom/discord/models/domain/emoji/Emoji;", "component2", "()Lcom/discord/models/domain/emoji/Emoji;", "component3", "", "component4", "()Z", "guildName", "emoji", "emojiName", "allowEmojisToAnimate", "copy", "(Ljava/lang/String;Lcom/discord/models/domain/emoji/Emoji;Ljava/lang/String;Z)Lcom/discord/widgets/chat/input/emoji/WidgetEmojiAdapter$EmojiItem;", "toString", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "type", "I", "getType", "Ljava/lang/String;", "getEmojiName", "Z", "getAllowEmojisToAnimate", "Lcom/discord/models/domain/emoji/Emoji;", "getEmoji", "key", "getKey", "getGuildName", "<init>", "(Ljava/lang/String;Lcom/discord/models/domain/emoji/Emoji;Ljava/lang/String;Z)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class EmojiItem implements MGRecyclerDataPayload {
        private final boolean allowEmojisToAnimate;
        private final Emoji emoji;
        private final String emojiName;
        private final String guildName;
        private final String key;
        private final int type;

        public EmojiItem(String str, Emoji emoji, String str2, boolean z2) {
            Intrinsics3.checkNotNullParameter(emoji, "emoji");
            Intrinsics3.checkNotNullParameter(str2, "emojiName");
            this.guildName = str;
            this.emoji = emoji;
            this.emojiName = str2;
            this.allowEmojisToAnimate = z2;
            this.type = 1;
            String uniqueId = emoji.getUniqueId();
            Intrinsics3.checkNotNullExpressionValue(uniqueId, "emoji.uniqueId");
            this.key = uniqueId;
        }

        public static /* synthetic */ EmojiItem copy$default(EmojiItem emojiItem, String str, Emoji emoji, String str2, boolean z2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = emojiItem.guildName;
            }
            if ((i & 2) != 0) {
                emoji = emojiItem.emoji;
            }
            if ((i & 4) != 0) {
                str2 = emojiItem.emojiName;
            }
            if ((i & 8) != 0) {
                z2 = emojiItem.allowEmojisToAnimate;
            }
            return emojiItem.copy(str, emoji, str2, z2);
        }

        /* renamed from: component1, reason: from getter */
        public final String getGuildName() {
            return this.guildName;
        }

        /* renamed from: component2, reason: from getter */
        public final Emoji getEmoji() {
            return this.emoji;
        }

        /* renamed from: component3, reason: from getter */
        public final String getEmojiName() {
            return this.emojiName;
        }

        /* renamed from: component4, reason: from getter */
        public final boolean getAllowEmojisToAnimate() {
            return this.allowEmojisToAnimate;
        }

        public final EmojiItem copy(String guildName, Emoji emoji, String emojiName, boolean allowEmojisToAnimate) {
            Intrinsics3.checkNotNullParameter(emoji, "emoji");
            Intrinsics3.checkNotNullParameter(emojiName, "emojiName");
            return new EmojiItem(guildName, emoji, emojiName, allowEmojisToAnimate);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof EmojiItem)) {
                return false;
            }
            EmojiItem emojiItem = (EmojiItem) other;
            return Intrinsics3.areEqual(this.guildName, emojiItem.guildName) && Intrinsics3.areEqual(this.emoji, emojiItem.emoji) && Intrinsics3.areEqual(this.emojiName, emojiItem.emojiName) && this.allowEmojisToAnimate == emojiItem.allowEmojisToAnimate;
        }

        public final boolean getAllowEmojisToAnimate() {
            return this.allowEmojisToAnimate;
        }

        public final Emoji getEmoji() {
            return this.emoji;
        }

        public final String getEmojiName() {
            return this.emojiName;
        }

        public final String getGuildName() {
            return this.guildName;
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
        public String getKey() {
            return this.key;
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload
        public int getType() {
            return this.type;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            String str = this.guildName;
            int iHashCode = (str != null ? str.hashCode() : 0) * 31;
            Emoji emoji = this.emoji;
            int iHashCode2 = (iHashCode + (emoji != null ? emoji.hashCode() : 0)) * 31;
            String str2 = this.emojiName;
            int iHashCode3 = (iHashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31;
            boolean z2 = this.allowEmojisToAnimate;
            int i = z2;
            if (z2 != 0) {
                i = 1;
            }
            return iHashCode3 + i;
        }

        public String toString() {
            StringBuilder sbU = outline.U("EmojiItem(guildName=");
            sbU.append(this.guildName);
            sbU.append(", emoji=");
            sbU.append(this.emoji);
            sbU.append(", emojiName=");
            sbU.append(this.emojiName);
            sbU.append(", allowEmojisToAnimate=");
            return outline.O(sbU, this.allowEmojisToAnimate, ")");
        }

        public /* synthetic */ EmojiItem(String str, Emoji emoji, String str2, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, emoji, str2, (i & 8) != 0 ? false : z2);
        }
    }
}

package com.discord.widgets.chat.input.autocomplete.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.R;
import com.discord.api.user.User;
import com.discord.databinding.WidgetChatInputCommandApplicationHeaderItemBinding;
import com.discord.models.commands.Application;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.drawable.DrawableCompat;
import com.discord.utilities.error.Error;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.images.MGImagesBitmap;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.widgets.chat.input.autocomplete.ApplicationPlaceholder;
import d0.g0.StringsJVM;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.HashSet;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* compiled from: CommandHeaderViewHolder.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\t\u001a\u00020\b8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nR\u001c\u0010\f\u001a\u00020\u000b8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR$\u0010\u0010\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0007¨\u0006\u0017"}, d2 = {"Lcom/discord/widgets/chat/input/autocomplete/adapter/CommandHeaderViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/discord/widgets/chat/input/autocomplete/adapter/StickyHeaderHolder;", "Lcom/discord/widgets/chat/input/autocomplete/ApplicationPlaceholder;", "item", "", "bind", "(Lcom/discord/widgets/chat/input/autocomplete/ApplicationPlaceholder;)V", "Lcom/discord/databinding/WidgetChatInputCommandApplicationHeaderItemBinding;", "binding", "Lcom/discord/databinding/WidgetChatInputCommandApplicationHeaderItemBinding;", "Landroid/view/View;", "itemView", "Landroid/view/View;", "getItemView", "()Landroid/view/View;", "currentItem", "Lcom/discord/widgets/chat/input/autocomplete/ApplicationPlaceholder;", "getCurrentItem", "()Lcom/discord/widgets/chat/input/autocomplete/ApplicationPlaceholder;", "setCurrentItem", "<init>", "(Lcom/discord/databinding/WidgetChatInputCommandApplicationHeaderItemBinding;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class CommandHeaderViewHolder extends RecyclerView.ViewHolder implements StickyHeaderManager2 {
    private final WidgetChatInputCommandApplicationHeaderItemBinding binding;
    private ApplicationPlaceholder currentItem;
    private final View itemView;

    /* compiled from: CommandHeaderViewHolder.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/utilities/images/MGImagesBitmap$CloseableBitmaps;", "closeableBitmaps", "", "invoke", "(Lcom/discord/utilities/images/MGImagesBitmap$CloseableBitmaps;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.chat.input.autocomplete.adapter.CommandHeaderViewHolder$bind$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<MGImagesBitmap.CloseableBitmaps, Unit> {
        public final /* synthetic */ String $iconUrl;
        public final /* synthetic */ ApplicationPlaceholder $item;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(ApplicationPlaceholder applicationPlaceholder, String str) {
            super(1);
            this.$item = applicationPlaceholder;
            this.$iconUrl = str;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(MGImagesBitmap.CloseableBitmaps closeableBitmaps) {
            invoke2(closeableBitmaps);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(MGImagesBitmap.CloseableBitmaps closeableBitmaps) {
            Application application;
            Intrinsics3.checkNotNullParameter(closeableBitmaps, "closeableBitmaps");
            ApplicationPlaceholder currentItem = CommandHeaderViewHolder.this.getCurrentItem();
            if (StringsJVM.equals$default((currentItem == null || (application = currentItem.getApplication()) == null) ? null : application.getIcon(), this.$item.getApplication().getIcon(), false, 2, null)) {
                CommandHeaderViewHolder.access$getBinding$p(CommandHeaderViewHolder.this).f2305b.setImageBitmap((Bitmap) closeableBitmaps.get((Object) this.$iconUrl));
            }
        }
    }

    /* compiled from: CommandHeaderViewHolder.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/utilities/error/Error;", "<anonymous parameter 0>", "", "invoke", "(Lcom/discord/utilities/error/Error;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.chat.input.autocomplete.adapter.CommandHeaderViewHolder$bind$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function1<Error, Unit> {
        public final /* synthetic */ int $tint;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(int i) {
            super(1);
            this.$tint = i;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Error error) {
            invoke2(error);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Error error) {
            Intrinsics3.checkNotNullParameter(error, "<anonymous parameter 0>");
            ImageView imageView = CommandHeaderViewHolder.access$getBinding$p(CommandHeaderViewHolder.this).f2305b;
            Intrinsics3.checkNotNullExpressionValue(imageView, "binding.chatInputApplicationAvatar");
            Context context = imageView.getContext();
            Intrinsics3.checkNotNullExpressionValue(context, "binding.chatInputApplicationAvatar.context");
            Drawable drawable$default = DrawableCompat.getDrawable$default(context, R.drawable.ic_slash_command_24dp, this.$tint, false, 4, null);
            if (drawable$default != null) {
                CommandHeaderViewHolder.access$getBinding$p(CommandHeaderViewHolder.this).f2305b.setImageDrawable(drawable$default);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CommandHeaderViewHolder(WidgetChatInputCommandApplicationHeaderItemBinding widgetChatInputCommandApplicationHeaderItemBinding) {
        super(widgetChatInputCommandApplicationHeaderItemBinding.a);
        Intrinsics3.checkNotNullParameter(widgetChatInputCommandApplicationHeaderItemBinding, "binding");
        this.binding = widgetChatInputCommandApplicationHeaderItemBinding;
        ConstraintLayout constraintLayout = widgetChatInputCommandApplicationHeaderItemBinding.a;
        Intrinsics3.checkNotNullExpressionValue(constraintLayout, "binding.root");
        this.itemView = constraintLayout;
    }

    public static final /* synthetic */ WidgetChatInputCommandApplicationHeaderItemBinding access$getBinding$p(CommandHeaderViewHolder commandHeaderViewHolder) {
        return commandHeaderViewHolder.binding;
    }

    @Override // com.discord.widgets.chat.input.autocomplete.adapter.StickyHeaderManager2
    public void bind(ApplicationPlaceholder item) {
        String name;
        Intrinsics3.checkNotNullParameter(item, "item");
        if (Intrinsics3.areEqual(this.currentItem, item)) {
            return;
        }
        this.currentItem = item;
        User bot = item.getApplication().getBot();
        if (bot == null || (name = bot.getUsername()) == null) {
            name = item.getApplication().getName();
        }
        TextView textView = this.binding.c;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.chatInputApplicationName");
        textView.setText(name);
        ImageView imageView = this.binding.f2305b;
        Intrinsics3.checkNotNullExpressionValue(imageView, "binding.chatInputApplicationAvatar");
        int themedColor = ColorCompat.getThemedColor(imageView, R.attr.colorTextMuted);
        if (item.getApplication().getIconRes() == null) {
            String applicationIcon$default = IconUtils.getApplicationIcon$default(IconUtils.INSTANCE, item.getApplication(), 0, 2, (Object) null);
            HashSet hashSet = new HashSet();
            hashSet.add(new MGImagesBitmap.ImageRequest(applicationIcon$default, true));
            this.binding.f2305b.setImageBitmap(null);
            ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui(MGImagesBitmap.getBitmaps(hashSet)), CommandHeaderViewHolder.class, (Context) null, (Function1) null, new AnonymousClass2(themedColor), (Function0) null, (Function0) null, new AnonymousClass1(item, applicationIcon$default), 54, (Object) null);
            return;
        }
        ImageView imageView2 = this.binding.f2305b;
        Intrinsics3.checkNotNullExpressionValue(imageView2, "binding.chatInputApplicationAvatar");
        Context context = imageView2.getContext();
        Intrinsics3.checkNotNullExpressionValue(context, "binding.chatInputApplicationAvatar.context");
        Drawable drawable$default = DrawableCompat.getDrawable$default(context, item.getApplication().getIconRes().intValue(), themedColor, false, 4, null);
        if (drawable$default != null) {
            this.binding.f2305b.setImageDrawable(drawable$default);
        } else {
            this.binding.f2305b.setImageResource(item.getApplication().getIconRes().intValue());
        }
    }

    public final ApplicationPlaceholder getCurrentItem() {
        return this.currentItem;
    }

    @Override // com.discord.widgets.chat.input.autocomplete.adapter.StickyHeaderManager2
    public View getItemView() {
        return this.itemView;
    }

    public final void setCurrentItem(ApplicationPlaceholder applicationPlaceholder) {
        this.currentItem = applicationPlaceholder;
    }
}

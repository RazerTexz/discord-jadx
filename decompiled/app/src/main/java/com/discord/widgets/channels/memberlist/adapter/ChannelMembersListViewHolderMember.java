package com.discord.widgets.channels.memberlist.adapter;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import b.a.d.AppToast;
import b.a.k.FormatUtils;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.databinding.WidgetChannelMembersListItemUserBinding;
import com.discord.models.presence.Presence;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.images.MGImages;
import com.discord.utilities.presence.PresenceUtils;
import com.discord.utilities.time.TimeUtils;
import com.discord.utilities.user.UserUtils;
import com.discord.utilities.view.text.SimpleDraweeSpanTextView;
import com.discord.views.StatusView;
import com.discord.views.UsernameView;
import com.discord.widgets.channels.memberlist.adapter.ChannelMembersListAdapter;
import com.facebook.drawee.view.SimpleDraweeView;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* compiled from: ChannelMembersListViewHolderMember.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\f\u0010\rJ#\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0007\u0010\bR\u0016\u0010\n\u001a\u00020\t8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000b¨\u0006\u000e"}, d2 = {"Lcom/discord/widgets/channels/memberlist/adapter/ChannelMembersListViewHolderMember;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/discord/widgets/channels/memberlist/adapter/ChannelMembersListAdapter$Item$Member;", "data", "Lkotlin/Function0;", "", "onClicked", "bind", "(Lcom/discord/widgets/channels/memberlist/adapter/ChannelMembersListAdapter$Item$Member;Lkotlin/jvm/functions/Function0;)V", "Lcom/discord/databinding/WidgetChannelMembersListItemUserBinding;", "binding", "Lcom/discord/databinding/WidgetChannelMembersListItemUserBinding;", "<init>", "(Lcom/discord/databinding/WidgetChannelMembersListItemUserBinding;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class ChannelMembersListViewHolderMember extends RecyclerView.ViewHolder {
    private final WidgetChannelMembersListItemUserBinding binding;

    /* compiled from: ChannelMembersListViewHolderMember.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.channels.memberlist.adapter.ChannelMembersListViewHolderMember$bind$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnClickListener {
        public final /* synthetic */ Function0 $onClicked;

        public AnonymousClass1(Function0 function0) {
            this.$onClicked = function0;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.$onClicked.invoke();
        }
    }

    /* compiled from: ChannelMembersListViewHolderMember.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.channels.memberlist.adapter.ChannelMembersListViewHolderMember$bind$3, reason: invalid class name */
    public static final class AnonymousClass3 implements View.OnClickListener {
        public final /* synthetic */ ChannelMembersListAdapter.Item.Member $data;
        public final /* synthetic */ boolean $isBooster;

        public AnonymousClass3(boolean z2, ChannelMembersListAdapter.Item.Member member) {
            this.$isBooster = z2;
            this.$data = member;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            if (this.$isBooster) {
                String readableTimeString = TimeUtils.getReadableTimeString(outline.x(view, "it", "it.context"), this.$data.getPremiumSince());
                Context context = view.getContext();
                Context context2 = view.getContext();
                Intrinsics3.checkNotNullExpressionValue(context2, "it.context");
                AppToast.h(context, FormatUtils.h(context2, R.string.premium_guild_subscription_tooltip, new Object[]{readableTimeString}, null, 4), 0, null, 12);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChannelMembersListViewHolderMember(WidgetChannelMembersListItemUserBinding widgetChannelMembersListItemUserBinding) {
        super(widgetChannelMembersListItemUserBinding.a);
        Intrinsics3.checkNotNullParameter(widgetChannelMembersListItemUserBinding, "binding");
        this.binding = widgetChannelMembersListItemUserBinding;
    }

    public final void bind(ChannelMembersListAdapter.Item.Member data, Function0<Unit> onClicked) {
        int themedColor;
        Intrinsics3.checkNotNullParameter(data, "data");
        Intrinsics3.checkNotNullParameter(onClicked, "onClicked");
        this.binding.a.setOnClickListener(new AnonymousClass1(onClicked));
        UsernameView usernameView = this.binding.f;
        UsernameView.c(usernameView, data.getName(), null, false, null, null, 30);
        Integer color = data.getColor();
        if (color != null) {
            themedColor = color.intValue();
        } else {
            Intrinsics3.checkNotNullExpressionValue(usernameView, "this");
            themedColor = ColorCompat.getThemedColor(usernameView, R.attr.primary_000);
        }
        usernameView.setUsernameColor(themedColor);
        boolean z2 = data.getPremiumSince() != null;
        UsernameView usernameView2 = this.binding.f;
        boolean zIsBot = data.isBot();
        Integer tagText = data.getTagText();
        usernameView2.a(zIsBot, tagText != null ? tagText.intValue() : R.string.bot_tag_bot, data.getTagVerified());
        ImageView imageView = this.binding.e;
        Intrinsics3.checkNotNullExpressionValue(imageView, "binding.channelMembersListItemGroupOwnerIndicator");
        imageView.setVisibility(data.getShowOwnerIndicator() ? 0 : 8);
        ImageView imageView2 = this.binding.c;
        Intrinsics3.checkNotNullExpressionValue(imageView2, "binding.channelMembersListItemBoostedIndicator");
        imageView2.setVisibility(z2 ? 0 : 8);
        this.binding.c.setOnClickListener(new AnonymousClass3(z2, data));
        this.binding.g.setPresence(data.getPresence());
        StatusView statusView = this.binding.g;
        Intrinsics3.checkNotNullExpressionValue(statusView, "binding.channelMembersListItemPresence");
        statusView.setVisibility(UserUtils.INSTANCE.isStatusVisible(data.getUserFlags(), data.getPresence(), true) ? 0 : 8);
        ImageView imageView3 = this.binding.h;
        Intrinsics3.checkNotNullExpressionValue(imageView3, "binding.channelMembersListItemRichPresenceIv");
        imageView3.setVisibility(PresenceUtils.INSTANCE.shouldShowRichPresenceIcon(data.getPresence()) ? 0 : 8);
        Presence presence = data.getPresence();
        boolean zIsApplicationStreaming = data.isApplicationStreaming();
        SimpleDraweeSpanTextView simpleDraweeSpanTextView = this.binding.d;
        Intrinsics3.checkNotNullExpressionValue(simpleDraweeSpanTextView, "binding.channelMembersListItemGame");
        PresenceUtils.setPresenceText$default(presence, zIsApplicationStreaming, simpleDraweeSpanTextView, false, !data.getCanDisplayStatusEmoji(), 8, null);
        SimpleDraweeView simpleDraweeView = this.binding.f2261b;
        Intrinsics3.checkNotNullExpressionValue(simpleDraweeView, "binding.channelMembersListItemAvatar");
        IconUtils.setIcon$default(simpleDraweeView, data.getAvatarUrl(), R.dimen.avatar_size_standard, (Function1) null, (MGImages.ChangeDetector) null, 24, (Object) null);
    }
}

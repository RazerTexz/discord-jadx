package com.discord.widgets.home;

import android.content.Context;
import android.content.res.Resources;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.DrawableRes;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.NotificationCompat;
import androidx.core.view.ViewKt;
import androidx.fragment.app.FragmentManager;
import b.a.i.WidgetHomePanelCenterChatBinding;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.api.user.NsfwAllowance;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetHomeBinding;
import com.discord.models.presence.Presence;
import com.discord.stores.StoreChannelsSelected;
import com.discord.stores.StoreStream;
import com.discord.utilities.channel.ChannelInviteLaunchUtils;
import com.discord.utilities.channel.GuildChannelIconUtils2;
import com.discord.utilities.device.DeviceUtils;
import com.discord.utilities.drawable.DrawableCompat;
import com.discord.utilities.toolbar.ToolbarUtils2;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.views.StatusView;
import com.discord.views.ToolbarTitleLayout;
import com.discord.widgets.channels.threads.browser.WidgetThreadBrowser;
import com.discord.widgets.friends.WidgetFriendsAdd;
import com.discord.widgets.search.WidgetSearch;
import com.discord.widgets.user.calls.PrivateCallLauncher;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.functions.Action1;
import rx.functions.Action2;

/* compiled from: WidgetHomeHeaderManager.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000{\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006*\u0001\u0011\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001/B\t\b\u0002¢\u0006\u0004\b-\u0010.J5\u0010\u000b\u001a\u00020\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0002¢\u0006\u0004\b\u000b\u0010\fJ#\u0010\u0012\u001a\u00020\u0011*\u00020\u00042\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0012\u0010\u0013J)\u0010\u0019\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u00142\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ!\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001d*\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u001bH\u0002¢\u0006\u0004\b\u001f\u0010 J\u001b\u0010\"\u001a\u00020!*\u00020\u00042\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\"\u0010#J%\u0010(\u001a\u00020\n2\u0006\u0010%\u001a\u00020$2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010'\u001a\u00020&¢\u0006\u0004\b(\u0010)R\u0016\u0010+\u001a\u00020*8\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b+\u0010,¨\u00060"}, d2 = {"Lcom/discord/widgets/home/WidgetHomeHeaderManager;", "", "Landroidx/appcompat/widget/Toolbar;", "toolbar", "Lcom/discord/widgets/home/WidgetHomeModel;", "model", "Lcom/discord/api/channel/Channel;", "channel", "Landroid/content/Context;", "context", "", "configureThreadBrowserIconBehavior", "(Landroidx/appcompat/widget/Toolbar;Lcom/discord/widgets/home/WidgetHomeModel;Lcom/discord/api/channel/Channel;Landroid/content/Context;)V", "Lcom/discord/app/AppFragment;", "appFragment", "Lcom/discord/widgets/home/PanelLayout;", "panelLayout", "com/discord/widgets/home/WidgetHomeHeaderManager$getOnSelectedAction$1", "getOnSelectedAction", "(Lcom/discord/widgets/home/WidgetHomeModel;Lcom/discord/app/AppFragment;Lcom/discord/widgets/home/PanelLayout;)Lcom/discord/widgets/home/WidgetHomeHeaderManager$getOnSelectedAction$1;", "", "isChannelNsfw", "isNsfwUnConsented", "Lcom/discord/api/user/NsfwAllowance;", "nsfwAllowed", "isChannelNSFWGated", "(ZZLcom/discord/api/user/NsfwAllowance;)Z", "Landroid/content/res/Resources;", "resources", "Lrx/functions/Action1;", "Landroid/view/Menu;", "getOnConfigureAction", "(Lcom/discord/widgets/home/WidgetHomeModel;Landroid/content/res/Resources;)Lrx/functions/Action1;", "Lcom/discord/widgets/home/WidgetHomeHeaderManager$HeaderData;", "getHeaderData", "(Lcom/discord/widgets/home/WidgetHomeModel;Landroid/content/Context;)Lcom/discord/widgets/home/WidgetHomeHeaderManager$HeaderData;", "Lcom/discord/widgets/home/WidgetHome;", "widgetHome", "Lcom/discord/databinding/WidgetHomeBinding;", "binding", "configure", "(Lcom/discord/widgets/home/WidgetHome;Lcom/discord/widgets/home/WidgetHomeModel;Lcom/discord/databinding/WidgetHomeBinding;)V", "", "ANALYTICS_SOURCE", "Ljava/lang/String;", "<init>", "()V", "HeaderData", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetHomeHeaderManager {
    private static final String ANALYTICS_SOURCE = "Toolbar";
    public static final WidgetHomeHeaderManager INSTANCE = new WidgetHomeHeaderManager();

    /* compiled from: WidgetHomeHeaderManager.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u0012\b\u0086\b\u0018\u00002\u00020\u0001B?\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0003\u0010\u000f\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0010\u001a\u00020\t\u0012\n\b\u0003\u0010\u0011\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b$\u0010%J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0012\u0010\f\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b\f\u0010\bJJ\u0010\u0012\u001a\u00020\u00002\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00022\n\b\u0003\u0010\u000f\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u0010\u001a\u00020\t2\n\b\u0003\u0010\u0011\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0015\u001a\u00020\u0014HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0017\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0017\u0010\u0018J\u001a\u0010\u001a\u001a\u00020\t2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001a\u0010\u001bR\u001b\u0010\u000e\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u001c\u001a\u0004\b\u001d\u0010\u0004R\u001b\u0010\u0011\u001a\u0004\u0018\u00010\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u001e\u001a\u0004\b\u001f\u0010\bR\u001b\u0010\r\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u001c\u001a\u0004\b \u0010\u0004R\u0019\u0010\u0010\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\b\u0010\u0010!\u001a\u0004\b\"\u0010\u000bR\u001b\u0010\u000f\u001a\u0004\u0018\u00010\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u001e\u001a\u0004\b#\u0010\b¨\u0006&"}, d2 = {"Lcom/discord/widgets/home/WidgetHomeHeaderManager$HeaderData;", "", "", "component1", "()Ljava/lang/CharSequence;", "component2", "", "component3", "()Ljava/lang/Integer;", "", "component4", "()Z", "component5", "title", "subtitle", "drawableRes", "leftButtonIsBack", "trailingDrawable", "copy", "(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/Integer;ZLjava/lang/Integer;)Lcom/discord/widgets/home/WidgetHomeHeaderManager$HeaderData;", "", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/CharSequence;", "getSubtitle", "Ljava/lang/Integer;", "getTrailingDrawable", "getTitle", "Z", "getLeftButtonIsBack", "getDrawableRes", "<init>", "(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/Integer;ZLjava/lang/Integer;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class HeaderData {
        private final Integer drawableRes;
        private final boolean leftButtonIsBack;
        private final CharSequence subtitle;
        private final CharSequence title;
        private final Integer trailingDrawable;

        public HeaderData(CharSequence charSequence, CharSequence charSequence2, @DrawableRes Integer num, boolean z2, @DrawableRes Integer num2) {
            this.title = charSequence;
            this.subtitle = charSequence2;
            this.drawableRes = num;
            this.leftButtonIsBack = z2;
            this.trailingDrawable = num2;
        }

        public static /* synthetic */ HeaderData copy$default(HeaderData headerData, CharSequence charSequence, CharSequence charSequence2, Integer num, boolean z2, Integer num2, int i, Object obj) {
            if ((i & 1) != 0) {
                charSequence = headerData.title;
            }
            if ((i & 2) != 0) {
                charSequence2 = headerData.subtitle;
            }
            CharSequence charSequence3 = charSequence2;
            if ((i & 4) != 0) {
                num = headerData.drawableRes;
            }
            Integer num3 = num;
            if ((i & 8) != 0) {
                z2 = headerData.leftButtonIsBack;
            }
            boolean z3 = z2;
            if ((i & 16) != 0) {
                num2 = headerData.trailingDrawable;
            }
            return headerData.copy(charSequence, charSequence3, num3, z3, num2);
        }

        /* renamed from: component1, reason: from getter */
        public final CharSequence getTitle() {
            return this.title;
        }

        /* renamed from: component2, reason: from getter */
        public final CharSequence getSubtitle() {
            return this.subtitle;
        }

        /* renamed from: component3, reason: from getter */
        public final Integer getDrawableRes() {
            return this.drawableRes;
        }

        /* renamed from: component4, reason: from getter */
        public final boolean getLeftButtonIsBack() {
            return this.leftButtonIsBack;
        }

        /* renamed from: component5, reason: from getter */
        public final Integer getTrailingDrawable() {
            return this.trailingDrawable;
        }

        public final HeaderData copy(CharSequence title, CharSequence subtitle, @DrawableRes Integer drawableRes, boolean leftButtonIsBack, @DrawableRes Integer trailingDrawable) {
            return new HeaderData(title, subtitle, drawableRes, leftButtonIsBack, trailingDrawable);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof HeaderData)) {
                return false;
            }
            HeaderData headerData = (HeaderData) other;
            return Intrinsics3.areEqual(this.title, headerData.title) && Intrinsics3.areEqual(this.subtitle, headerData.subtitle) && Intrinsics3.areEqual(this.drawableRes, headerData.drawableRes) && this.leftButtonIsBack == headerData.leftButtonIsBack && Intrinsics3.areEqual(this.trailingDrawable, headerData.trailingDrawable);
        }

        public final Integer getDrawableRes() {
            return this.drawableRes;
        }

        public final boolean getLeftButtonIsBack() {
            return this.leftButtonIsBack;
        }

        public final CharSequence getSubtitle() {
            return this.subtitle;
        }

        public final CharSequence getTitle() {
            return this.title;
        }

        public final Integer getTrailingDrawable() {
            return this.trailingDrawable;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            CharSequence charSequence = this.title;
            int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
            CharSequence charSequence2 = this.subtitle;
            int iHashCode2 = (iHashCode + (charSequence2 != null ? charSequence2.hashCode() : 0)) * 31;
            Integer num = this.drawableRes;
            int iHashCode3 = (iHashCode2 + (num != null ? num.hashCode() : 0)) * 31;
            boolean z2 = this.leftButtonIsBack;
            int i = z2;
            if (z2 != 0) {
                i = 1;
            }
            int i2 = (iHashCode3 + i) * 31;
            Integer num2 = this.trailingDrawable;
            return i2 + (num2 != null ? num2.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = outline.U("HeaderData(title=");
            sbU.append(this.title);
            sbU.append(", subtitle=");
            sbU.append(this.subtitle);
            sbU.append(", drawableRes=");
            sbU.append(this.drawableRes);
            sbU.append(", leftButtonIsBack=");
            sbU.append(this.leftButtonIsBack);
            sbU.append(", trailingDrawable=");
            return outline.F(sbU, this.trailingDrawable, ")");
        }

        public /* synthetic */ HeaderData(CharSequence charSequence, CharSequence charSequence2, Integer num, boolean z2, Integer num2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(charSequence, (i & 2) != 0 ? null : charSequence2, (i & 4) != 0 ? null : num, (i & 8) != 0 ? false : z2, (i & 16) != 0 ? null : num2);
        }
    }

    /* compiled from: WidgetHomeHeaderManager.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.home.WidgetHomeHeaderManager$configureThreadBrowserIconBehavior$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnClickListener {
        public final /* synthetic */ Channel $channel;
        public final /* synthetic */ Context $context;

        public AnonymousClass1(Context context, Channel channel) {
            this.$context = context;
            this.$channel = channel;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetThreadBrowser.INSTANCE.show(this.$context, this.$channel.getGuildId(), ChannelUtils.H(this.$channel) ? this.$channel.getParentId() : this.$channel.getId(), "Chat List Header");
        }
    }

    /* compiled from: WidgetHomeHeaderManager.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/Menu;", "kotlin.jvm.PlatformType", "menu", "", NotificationCompat.CATEGORY_CALL, "(Landroid/view/Menu;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.home.WidgetHomeHeaderManager$getOnConfigureAction$1, reason: invalid class name */
    public static final class AnonymousClass1<T> implements Action1<Menu> {
        public final /* synthetic */ Resources $resources;
        public final /* synthetic */ WidgetHomeModel $this_getOnConfigureAction;

        public AnonymousClass1(WidgetHomeModel widgetHomeModel, Resources resources) {
            this.$this_getOnConfigureAction = widgetHomeModel;
            this.$resources = resources;
        }

        @Override // rx.functions.Action1
        public /* bridge */ /* synthetic */ void call(Menu menu) {
            call2(menu);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final void call2(Menu menu) {
            boolean z2 = false;
            boolean z3 = this.$this_getOnConfigureAction.getChannel() != null && ChannelUtils.E(this.$this_getOnConfigureAction.getChannel());
            boolean zIsSmallScreen = DeviceUtils.INSTANCE.isSmallScreen(this.$resources);
            boolean z4 = this.$this_getOnConfigureAction.getThreadExperimentEnabled() && this.$this_getOnConfigureAction.getThreadCount() > 0 && !WidgetHomeHeaderManager.access$isChannelNSFWGated(WidgetHomeHeaderManager.INSTANCE, this.$this_getOnConfigureAction.isChannelNsfw(), this.$this_getOnConfigureAction.isNsfwUnConsented(), this.$this_getOnConfigureAction.getNsfwAllowed());
            Channel channel = this.$this_getOnConfigureAction.getChannel();
            Integer numValueOf = channel != null ? Integer.valueOf(channel.getType()) : null;
            if ((numValueOf != null && numValueOf.intValue() == 3) || (numValueOf != null && numValueOf.intValue() == 1)) {
                MenuItem menuItemFindItem = menu.findItem(R.id.menu_chat_search);
                Intrinsics3.checkNotNullExpressionValue(menuItemFindItem, "menu.findItem(R.id.menu_chat_search)");
                menuItemFindItem.setVisible(false);
                MenuItem menuItemFindItem2 = menu.findItem(R.id.menu_chat_side_panel);
                Intrinsics3.checkNotNullExpressionValue(menuItemFindItem2, "menu.findItem(R.id.menu_chat_side_panel)");
                menuItemFindItem2.setVisible(true);
                MenuItem menuItemFindItem3 = menu.findItem(R.id.menu_chat_thread_browser);
                Intrinsics3.checkNotNullExpressionValue(menuItemFindItem3, "menu.findItem(R.id.menu_chat_thread_browser)");
                menuItemFindItem3.setVisible(false);
            } else if ((numValueOf != null && numValueOf.intValue() == 5) || ((numValueOf != null && numValueOf.intValue() == 15) || (numValueOf != null && numValueOf.intValue() == 0))) {
                MenuItem menuItemFindItem4 = menu.findItem(R.id.menu_chat_side_panel);
                Intrinsics3.checkNotNullExpressionValue(menuItemFindItem4, "menu.findItem(R.id.menu_chat_side_panel)");
                menuItemFindItem4.setVisible(true);
                if (zIsSmallScreen) {
                    MenuItem menuItemFindItem5 = menu.findItem(R.id.menu_chat_search);
                    Intrinsics3.checkNotNullExpressionValue(menuItemFindItem5, "menu.findItem(R.id.menu_chat_search)");
                    menuItemFindItem5.setVisible(!this.$this_getOnConfigureAction.getThreadExperimentEnabled());
                    MenuItem menuItemFindItem6 = menu.findItem(R.id.menu_chat_thread_browser);
                    Intrinsics3.checkNotNullExpressionValue(menuItemFindItem6, "menu.findItem(R.id.menu_chat_thread_browser)");
                    menuItemFindItem6.setVisible(z4);
                } else {
                    MenuItem menuItemFindItem7 = menu.findItem(R.id.menu_chat_search);
                    Intrinsics3.checkNotNullExpressionValue(menuItemFindItem7, "menu.findItem(R.id.menu_chat_search)");
                    menuItemFindItem7.setVisible(true);
                    MenuItem menuItemFindItem8 = menu.findItem(R.id.menu_chat_thread_browser);
                    Intrinsics3.checkNotNullExpressionValue(menuItemFindItem8, "menu.findItem(R.id.menu_chat_thread_browser)");
                    menuItemFindItem8.setVisible(z4);
                }
            } else if ((numValueOf != null && numValueOf.intValue() == 10) || ((numValueOf != null && numValueOf.intValue() == 12) || (numValueOf != null && numValueOf.intValue() == 11))) {
                MenuItem menuItemFindItem9 = menu.findItem(R.id.menu_chat_side_panel);
                Intrinsics3.checkNotNullExpressionValue(menuItemFindItem9, "menu.findItem(R.id.menu_chat_side_panel)");
                menuItemFindItem9.setVisible(!ChannelUtils.j(this.$this_getOnConfigureAction.getChannel()));
                MenuItem menuItemFindItem10 = menu.findItem(R.id.menu_chat_search);
                Intrinsics3.checkNotNullExpressionValue(menuItemFindItem10, "menu.findItem(R.id.menu_chat_search)");
                menuItemFindItem10.setVisible(!zIsSmallScreen);
                MenuItem menuItemFindItem11 = menu.findItem(R.id.menu_chat_thread_browser);
                Intrinsics3.checkNotNullExpressionValue(menuItemFindItem11, "menu.findItem(R.id.menu_chat_thread_browser)");
                menuItemFindItem11.setVisible(false);
            } else if (numValueOf != null && numValueOf.intValue() == 14) {
                MenuItem menuItemFindItem12 = menu.findItem(R.id.menu_chat_search);
                Intrinsics3.checkNotNullExpressionValue(menuItemFindItem12, "menu.findItem(R.id.menu_chat_search)");
                menuItemFindItem12.setVisible(false);
                MenuItem menuItemFindItem13 = menu.findItem(R.id.menu_chat_side_panel);
                Intrinsics3.checkNotNullExpressionValue(menuItemFindItem13, "menu.findItem(R.id.menu_chat_side_panel)");
                menuItemFindItem13.setVisible(true);
                MenuItem menuItemFindItem14 = menu.findItem(R.id.menu_chat_thread_browser);
                Intrinsics3.checkNotNullExpressionValue(menuItemFindItem14, "menu.findItem(R.id.menu_chat_thread_browser)");
                menuItemFindItem14.setVisible(false);
            }
            boolean z5 = this.$this_getOnConfigureAction.getChannel() != null && ChannelUtils.B(this.$this_getOnConfigureAction.getChannel());
            MenuItem menuItemFindItem15 = menu.findItem(R.id.menu_chat_start_call);
            Intrinsics3.checkNotNullExpressionValue(menuItemFindItem15, "menu.findItem(R.id.menu_chat_start_call)");
            menuItemFindItem15.setVisible((this.$this_getOnConfigureAction.isCallConnected() || !z5 || z3) ? false : true);
            MenuItem menuItemFindItem16 = menu.findItem(R.id.menu_chat_start_video_call);
            Intrinsics3.checkNotNullExpressionValue(menuItemFindItem16, "menu.findItem(R.id.menu_chat_start_video_call)");
            menuItemFindItem16.setVisible((this.$this_getOnConfigureAction.isCallConnected() || !z5 || z3) ? false : true);
            MenuItem menuItemFindItem17 = menu.findItem(R.id.menu_chat_stop_call);
            Intrinsics3.checkNotNullExpressionValue(menuItemFindItem17, "menu.findItem(R.id.menu_chat_stop_call)");
            if (this.$this_getOnConfigureAction.isCallConnected() && !z3) {
                z2 = true;
            }
            menuItemFindItem17.setVisible(z2);
        }
    }

    /* compiled from: WidgetHomeHeaderManager.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001J\u0013\u0010\u0005\u001a\u00020\u0004*\u00020\u0003H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\t\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"com/discord/widgets/home/WidgetHomeHeaderManager$getOnSelectedAction$1", "Lrx/functions/Action2;", "Landroid/view/MenuItem;", "Landroid/content/Context;", "", "launchForSearch", "(Landroid/content/Context;)V", "menuItem", "context", NotificationCompat.CATEGORY_CALL, "(Landroid/view/MenuItem;Landroid/content/Context;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.home.WidgetHomeHeaderManager$getOnSelectedAction$1, reason: invalid class name */
    public static final class AnonymousClass1 implements Action2<MenuItem, Context> {
        public final /* synthetic */ AppFragment $appFragment;
        public final /* synthetic */ PanelLayout $panelLayout;
        public final /* synthetic */ WidgetHomeModel $this_getOnSelectedAction;

        public AnonymousClass1(WidgetHomeModel widgetHomeModel, AppFragment appFragment, PanelLayout panelLayout) {
            this.$this_getOnSelectedAction = widgetHomeModel;
            this.$appFragment = appFragment;
            this.$panelLayout = panelLayout;
        }

        private final void launchForSearch(Context context) {
            Channel channel = this.$this_getOnSelectedAction.getChannel();
            if (channel != null && ChannelUtils.B(channel)) {
                WidgetSearch.INSTANCE.launchForChannel(this.$this_getOnSelectedAction.getChannelId(), context);
                return;
            }
            Channel channel2 = this.$this_getOnSelectedAction.getChannel();
            if (channel2 == null || !ChannelUtils.v(channel2)) {
                return;
            }
            WidgetSearch.INSTANCE.launchForGuild(this.$this_getOnSelectedAction.getChannel().getGuildId(), context);
        }

        @Override // rx.functions.Action2
        public /* bridge */ /* synthetic */ void call(MenuItem menuItem, Context context) {
            call2(menuItem, context);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public void call2(MenuItem menuItem, Context context) {
            Intrinsics3.checkNotNullParameter(menuItem, "menuItem");
            Intrinsics3.checkNotNullParameter(context, "context");
            AppFragment appFragment = this.$appFragment;
            FragmentManager parentFragmentManager = appFragment.getParentFragmentManager();
            Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "appFragment.parentFragmentManager");
            PrivateCallLauncher privateCallLauncher = new PrivateCallLauncher(appFragment, appFragment, context, parentFragmentManager);
            switch (menuItem.getItemId()) {
                case R.id.menu_chat_add_friend /* 2131364371 */:
                    WidgetFriendsAdd.Companion.show$default(WidgetFriendsAdd.INSTANCE, context, null, WidgetHomeHeaderManager.ANALYTICS_SOURCE, 2, null);
                    break;
                case R.id.menu_chat_search /* 2131364372 */:
                    launchForSearch(context);
                    break;
                case R.id.menu_chat_side_panel /* 2131364373 */:
                    this.$panelLayout.openEndPanel();
                    break;
                case R.id.menu_chat_start_call /* 2131364374 */:
                    privateCallLauncher.launchVoiceCall(this.$this_getOnSelectedAction.getChannelId());
                    break;
                case R.id.menu_chat_start_group /* 2131364375 */:
                    ChannelInviteLaunchUtils.inviteToChannel$default(ChannelInviteLaunchUtils.INSTANCE, this.$appFragment, this.$this_getOnSelectedAction.getChannel(), WidgetHomeHeaderManager.ANALYTICS_SOURCE, null, null, 24, null);
                    break;
                case R.id.menu_chat_start_video_call /* 2131364376 */:
                    privateCallLauncher.launchVideoCall(this.$this_getOnSelectedAction.getChannelId());
                    break;
                case R.id.menu_chat_stop_call /* 2131364377 */:
                    StoreStream.INSTANCE.getVoiceChannelSelected().clear();
                    break;
            }
            AppFragment.hideKeyboard$default(this.$appFragment, null, 1, null);
        }
    }

    private WidgetHomeHeaderManager() {
    }

    public static final /* synthetic */ boolean access$isChannelNSFWGated(WidgetHomeHeaderManager widgetHomeHeaderManager, boolean z2, boolean z3, NsfwAllowance nsfwAllowance) {
        return widgetHomeHeaderManager.isChannelNSFWGated(z2, z3, nsfwAllowance);
    }

    private final void configureThreadBrowserIconBehavior(Toolbar toolbar, WidgetHomeModel model, Channel channel, Context context) {
        View actionView;
        View actionView2;
        Menu menu;
        if (channel != null) {
            boolean z2 = !ChannelUtils.q(channel);
            int threadCount = model.getThreadCount();
            View viewFindViewById = null;
            MenuItem menuItemFindItem = (toolbar == null || (menu = toolbar.getMenu()) == null) ? null : menu.findItem(R.id.menu_chat_thread_browser);
            TextView textView = (menuItemFindItem == null || (actionView2 = menuItemFindItem.getActionView()) == null) ? null : (TextView) actionView2.findViewById(R.id.thread_browser_count);
            if (textView != null) {
                textView.setText(String.valueOf(Math.min(99, threadCount)));
            }
            if (textView != null) {
                ViewKt.setVisible(textView, threadCount != 0 && z2);
            }
            if (menuItemFindItem != null && (actionView = menuItemFindItem.getActionView()) != null) {
                viewFindViewById = actionView.findViewById(R.id.thread_browser_root);
            }
            if (viewFindViewById != null) {
                ViewKt.setVisible(viewFindViewById, z2);
            }
            if (viewFindViewById != null) {
                viewFindViewById.setOnClickListener(new AnonymousClass1(context, channel));
            }
        }
    }

    private final HeaderData getHeaderData(WidgetHomeModel widgetHomeModel, Context context) {
        StoreChannelsSelected.ResolvedSelectedChannel selectedChannel = widgetHomeModel.getSelectedChannel();
        if (!(selectedChannel instanceof StoreChannelsSelected.ResolvedSelectedChannel.Channel)) {
            return selectedChannel instanceof StoreChannelsSelected.ResolvedSelectedChannel.ThreadDraft ? new HeaderData(context.getString(R.string.create_thread), ChannelUtils.d(((StoreChannelsSelected.ResolvedSelectedChannel.ThreadDraft) widgetHomeModel.getSelectedChannel()).getParentChannel(), context, false), null, true, null, 16, null) : new HeaderData(null, null, null, false, null, 30, null);
        }
        Channel channel = widgetHomeModel.getChannel();
        Integer numValueOf = channel != null ? Integer.valueOf(channel.getType()) : null;
        if (numValueOf == null) {
            return new HeaderData(context.getString(R.string.channels_unavailable_title), null, null, false, null, 26, null);
        }
        if (numValueOf.intValue() == 3) {
            return new HeaderData(ChannelUtils.d(widgetHomeModel.getChannel(), context, false), null, Integer.valueOf(R.drawable.ic_group_message_header), false, null, 26, null);
        }
        if (numValueOf.intValue() == 1) {
            return new HeaderData(ChannelUtils.d(widgetHomeModel.getChannel(), context, false), null, Integer.valueOf(R.drawable.ic_direct_message_header), false, null, 26, null);
        }
        if (numValueOf.intValue() == 14) {
            return new HeaderData(ChannelUtils.d(widgetHomeModel.getChannel(), context, false), null, Integer.valueOf(R.drawable.ic_hub_24dp), false, null, 26, null);
        }
        if (widgetHomeModel.getChannel().getId() <= 0) {
            return new HeaderData(null, null, null, false, null, 26, null);
        }
        String strD = ChannelUtils.d(widgetHomeModel.getChannel(), context, false);
        Channel parentChannel = widgetHomeModel.getParentChannel();
        return new HeaderData(strD, parentChannel != null ? ChannelUtils.d(parentChannel, context, false) : null, Integer.valueOf(GuildChannelIconUtils2.guildChannelIcon(widgetHomeModel.getChannel())), ((StoreChannelsSelected.ResolvedSelectedChannel.Channel) widgetHomeModel.getSelectedChannel()).getPeekParent() != null || ChannelUtils.J(widgetHomeModel.getChannel()), null, 16, null);
    }

    private final Action1<Menu> getOnConfigureAction(WidgetHomeModel widgetHomeModel, Resources resources) {
        return new AnonymousClass1(widgetHomeModel, resources);
    }

    private final AnonymousClass1 getOnSelectedAction(WidgetHomeModel widgetHomeModel, AppFragment appFragment, PanelLayout panelLayout) {
        return new AnonymousClass1(widgetHomeModel, appFragment, panelLayout);
    }

    private final boolean isChannelNSFWGated(boolean isChannelNsfw, boolean isNsfwUnConsented, NsfwAllowance nsfwAllowed) {
        return isChannelNsfw && (isNsfwUnConsented || (nsfwAllowed == NsfwAllowance.DISALLOWED));
    }

    public final void configure(WidgetHome widgetHome, WidgetHomeModel model, WidgetHomeBinding binding) {
        int themedDrawableRes$default;
        int i;
        Intrinsics3.checkNotNullParameter(widgetHome, "widgetHome");
        Intrinsics3.checkNotNullParameter(model, "model");
        Intrinsics3.checkNotNullParameter(binding, "binding");
        widgetHome.lockCloseRightPanel(model.getChannel() == null || !(ChannelUtils.B(model.getChannel()) || ChannelUtils.v(model.getChannel())) || ChannelUtils.j(model.getChannel()));
        Channel channel = model.getChannel();
        Integer numValueOf = channel != null ? Integer.valueOf(channel.getType()) : null;
        if (numValueOf != null && numValueOf.intValue() == 14) {
            widgetHome.bindToolbar(binding.d.d);
        } else if (numValueOf != null && numValueOf.intValue() == 15) {
            widgetHome.bindToolbar(binding.d.f136b);
        } else {
            WidgetHomePanelCenterChatBinding widgetHomePanelCenterChatBinding = binding.d.c;
            Intrinsics3.checkNotNullExpressionValue(widgetHomePanelCenterChatBinding, "binding.panelCenter.widgetHomePanelCenterChat");
            widgetHome.bindToolbar(widgetHomePanelCenterChatBinding.a);
        }
        widgetHome.setActionBarTitleLayoutExpandedTappableArea();
        Context context = widgetHome.getContext();
        if (context != null) {
            WidgetHomeHeaderManager widgetHomeHeaderManager = INSTANCE;
            Intrinsics3.checkNotNullExpressionValue(context, "context");
            HeaderData headerData = widgetHomeHeaderManager.getHeaderData(model, context);
            CharSequence title = headerData.getTitle();
            CharSequence subtitle = headerData.getSubtitle();
            Integer drawableRes = headerData.getDrawableRes();
            boolean leftButtonIsBack = headerData.getLeftButtonIsBack();
            Integer trailingDrawable = headerData.getTrailingDrawable();
            if (leftButtonIsBack) {
                themedDrawableRes$default = DrawableCompat.getThemedDrawableRes$default(context, R.attr.ic_action_bar_back, 0, 2, (Object) null);
            } else {
                if (leftButtonIsBack) {
                    throw new NoWhenBranchMatchedException();
                }
                themedDrawableRes$default = R.drawable.ic_menu_24dp;
            }
            Integer numValueOf2 = Integer.valueOf(themedDrawableRes$default);
            if (leftButtonIsBack) {
                i = R.string.back;
            } else {
                if (leftButtonIsBack) {
                    throw new NoWhenBranchMatchedException();
                }
                i = R.string.toggle_drawer;
            }
            widgetHome.setActionBarDisplayHomeAsUpEnabled(true, numValueOf2, Integer.valueOf(i));
            widgetHome.setActionBarTitle(title, drawableRes, trailingDrawable);
            widgetHome.setActionBarSubtitle(subtitle);
            Toolbar toolbar = widgetHome.getToolbar();
            if (toolbar != null) {
                toolbar.setNavigationOnClickListener(new WidgetHomeHeaderManager2(model, widgetHome, model, binding));
            }
        }
        widgetHome.setActionBarTitleClick(new WidgetHomeHeaderManager3(model, widgetHome, model, binding));
        WidgetHomeHeaderManager widgetHomeHeaderManager2 = INSTANCE;
        AnonymousClass1 onSelectedAction = widgetHomeHeaderManager2.getOnSelectedAction(model, widgetHome, widgetHome.getPanelLayout());
        Resources resources = widgetHome.getResources();
        Intrinsics3.checkNotNullExpressionValue(resources, "widgetHome.resources");
        Toolbar actionBarOptionsMenu = widgetHome.setActionBarOptionsMenu(R.menu.menu_chat_toolbar, onSelectedAction, widgetHomeHeaderManager2.getOnConfigureAction(model, resources));
        Channel channel2 = model.getChannel();
        boolean zN = channel2 != null ? ChannelUtils.n(channel2, model.getDmPresence()) : false;
        ToolbarTitleLayout actionBarTitleLayout = widgetHome.getActionBarTitleLayout();
        if (actionBarTitleLayout != null) {
            Presence dmPresence = model.getDmPresence();
            StatusView statusView = actionBarTitleLayout.binding.c;
            Intrinsics3.checkNotNullExpressionValue(statusView, "binding.toolbarPresence");
            statusView.setVisibility(zN ? 0 : 8);
            actionBarTitleLayout.binding.c.setPresence(dmPresence);
        }
        TextView unreadCountView = widgetHome.getUnreadCountView();
        Integer numValueOf3 = Integer.valueOf(model.getUnreadCount());
        if (!(numValueOf3.intValue() > 0)) {
            numValueOf3 = null;
        }
        ViewExtensions.setTextAndVisibilityBy(unreadCountView, numValueOf3 != null ? String.valueOf(numValueOf3.intValue()) : null);
        Toolbar toolbar2 = widgetHome.getToolbar();
        if (toolbar2 != null) {
            ToolbarUtils2.positionUnreadCountView(toolbar2, unreadCountView);
        }
        widgetHomeHeaderManager2.configureThreadBrowserIconBehavior(actionBarOptionsMenu, model, model.getChannel(), widgetHome.getContext());
    }
}

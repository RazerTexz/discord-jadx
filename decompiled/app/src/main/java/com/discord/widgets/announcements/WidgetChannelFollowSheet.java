package com.discord.widgets.announcements;

import a0.a.a.b;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import b.a.d.AppViewModelDelegates3;
import b.a.d.AppViewModelDelegates5;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.app.AppBottomSheet;
import com.discord.app.AppViewFlipper;
import com.discord.databinding.WidgetChannelFollowSheetBinding;
import com.discord.models.guild.Guild;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.images.MGImages;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.widgets.announcements.WidgetChannelFollowSheetViewModel;
import com.discord.widgets.announcements.WidgetChannelFollowSuccessDialog;
import com.discord.widgets.channels.WidgetChannelSelector;
import com.discord.widgets.guilds.WidgetGuildSelector;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.material.button.MaterialButton;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import d0.z.d.Reflection2;
import java.util.Set;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import rx.Observable;

/* compiled from: WidgetChannelFollowSheet.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u001f2\u00020\u0001:\u0002 \u001fB\u0007¢\u0006\u0004\b\u001e\u0010\u0011J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0007\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\b\u0010\u0006J\u000f\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0019\u0010\u000e\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0010\u0010\u0011R\u001d\u0010\u0017\u001a\u00020\u00128B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u001d\u0010\u001d\u001a\u00020\u00188B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c¨\u0006!"}, d2 = {"Lcom/discord/widgets/announcements/WidgetChannelFollowSheet;", "Lcom/discord/app/AppBottomSheet;", "Lcom/discord/widgets/announcements/WidgetChannelFollowSheetViewModel$ViewState$Loaded;", "viewState", "", "configureUI", "(Lcom/discord/widgets/announcements/WidgetChannelFollowSheetViewModel$ViewState$Loaded;)V", "configureGuildSelector", "configureChannelSelector", "", "getContentViewResId", "()I", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "onResume", "()V", "Lcom/discord/databinding/WidgetChannelFollowSheetBinding;", "binding$delegate", "Lcom/discord/utilities/viewbinding/FragmentViewBindingDelegate;", "getBinding", "()Lcom/discord/databinding/WidgetChannelFollowSheetBinding;", "binding", "Lcom/discord/widgets/announcements/WidgetChannelFollowSheetViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "getViewModel", "()Lcom/discord/widgets/announcements/WidgetChannelFollowSheetViewModel;", "viewModel", "<init>", "Companion", "ChannelFollowChannelFilterFunction", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetChannelFollowSheet extends AppBottomSheet {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetChannelFollowSheet.class, "binding", "getBinding()Lcom/discord/databinding/WidgetChannelFollowSheetBinding;", 0)};

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String REQUEST_KEY_CHANNEL_FOLLOW = "REQUEST_KEY_CHANNEL_FOLLOW_CHANNEL";
    private static final int VIEW_INDEX_FOLLOW = 0;
    private static final int VIEW_INDEX_NO_AVAILABLE_GUILDS = 1;

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* compiled from: WidgetChannelFollowSheet.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\n\u0010\u000f\u001a\u00060\u0002j\u0002`\u0003\u0012\u0010\u0010\u0010\u001a\f\u0012\b\u0012\u00060\u0002j\u0002`\u00070\u0006¢\u0006\u0004\b\u001f\u0010 J\u0014\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003HÂ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\b\u001a\f\u0012\b\u0012\u00060\u0002j\u0002`\u00070\u0006HÂ\u0003¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\r\u0010\u000eJ2\u0010\u0011\u001a\u00020\u00002\f\b\u0002\u0010\u000f\u001a\u00060\u0002j\u0002`\u00032\u0012\b\u0002\u0010\u0010\u001a\f\u0012\b\u0012\u00060\u0002j\u0002`\u00070\u0006HÆ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0014\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0017\u001a\u00020\u0016HÖ\u0001¢\u0006\u0004\b\u0017\u0010\u0018J\u001a\u0010\u001b\u001a\u00020\f2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019HÖ\u0003¢\u0006\u0004\b\u001b\u0010\u001cR \u0010\u0010\u001a\f\u0012\b\u0012\u00060\u0002j\u0002`\u00070\u00068\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u001dR\u001a\u0010\u000f\u001a\u00060\u0002j\u0002`\u00038\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u001e¨\u0006!"}, d2 = {"Lcom/discord/widgets/announcements/WidgetChannelFollowSheet$ChannelFollowChannelFilterFunction;", "Lcom/discord/widgets/channels/WidgetChannelSelector$FilterFunction;", "", "Lcom/discord/primitives/GuildId;", "component1", "()J", "", "Lcom/discord/primitives/ChannelId;", "component2", "()Ljava/util/Set;", "Lcom/discord/api/channel/Channel;", "channel", "", "includeChannel", "(Lcom/discord/api/channel/Channel;)Z", "selectedGuildId", "channelIds", "copy", "(JLjava/util/Set;)Lcom/discord/widgets/announcements/WidgetChannelFollowSheet$ChannelFollowChannelFilterFunction;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/util/Set;", "J", "<init>", "(JLjava/util/Set;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class ChannelFollowChannelFilterFunction implements WidgetChannelSelector.FilterFunction {
        private final Set<Long> channelIds;
        private final long selectedGuildId;

        public ChannelFollowChannelFilterFunction(long j, Set<Long> set) {
            Intrinsics3.checkNotNullParameter(set, "channelIds");
            this.selectedGuildId = j;
            this.channelIds = set;
        }

        /* renamed from: component1, reason: from getter */
        private final long getSelectedGuildId() {
            return this.selectedGuildId;
        }

        private final Set<Long> component2() {
            return this.channelIds;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ ChannelFollowChannelFilterFunction copy$default(ChannelFollowChannelFilterFunction channelFollowChannelFilterFunction, long j, Set set, int i, Object obj) {
            if ((i & 1) != 0) {
                j = channelFollowChannelFilterFunction.selectedGuildId;
            }
            if ((i & 2) != 0) {
                set = channelFollowChannelFilterFunction.channelIds;
            }
            return channelFollowChannelFilterFunction.copy(j, set);
        }

        public final ChannelFollowChannelFilterFunction copy(long selectedGuildId, Set<Long> channelIds) {
            Intrinsics3.checkNotNullParameter(channelIds, "channelIds");
            return new ChannelFollowChannelFilterFunction(selectedGuildId, channelIds);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ChannelFollowChannelFilterFunction)) {
                return false;
            }
            ChannelFollowChannelFilterFunction channelFollowChannelFilterFunction = (ChannelFollowChannelFilterFunction) other;
            return this.selectedGuildId == channelFollowChannelFilterFunction.selectedGuildId && Intrinsics3.areEqual(this.channelIds, channelFollowChannelFilterFunction.channelIds);
        }

        public int hashCode() {
            int iA = b.a(this.selectedGuildId) * 31;
            Set<Long> set = this.channelIds;
            return iA + (set != null ? set.hashCode() : 0);
        }

        @Override // com.discord.widgets.channels.WidgetChannelSelector.FilterFunction
        public boolean includeChannel(Channel channel) {
            Intrinsics3.checkNotNullParameter(channel, "channel");
            return this.channelIds.contains(Long.valueOf(channel.getId())) && channel.getGuildId() == this.selectedGuildId;
        }

        public String toString() {
            StringBuilder sbU = outline.U("ChannelFollowChannelFilterFunction(selectedGuildId=");
            sbU.append(this.selectedGuildId);
            sbU.append(", channelIds=");
            return outline.N(sbU, this.channelIds, ")");
        }
    }

    /* compiled from: WidgetChannelFollowSheet.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0013\u0010\u0014J/\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\n\u0010\u0006\u001a\u00060\u0004j\u0002`\u00052\n\u0010\b\u001a\u00060\u0004j\u0002`\u0007H\u0007¢\u0006\u0004\b\n\u0010\u000bR\u0016\u0010\r\u001a\u00020\f8\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u0010\u001a\u00020\u000f8\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0012\u001a\u00020\u000f8\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0012\u0010\u0011¨\u0006\u0015"}, d2 = {"Lcom/discord/widgets/announcements/WidgetChannelFollowSheet$Companion;", "", "Landroidx/fragment/app/FragmentManager;", "fragmentManager", "", "Lcom/discord/primitives/ChannelId;", "channelId", "Lcom/discord/primitives/GuildId;", "guildId", "", "show", "(Landroidx/fragment/app/FragmentManager;JJ)V", "", "REQUEST_KEY_CHANNEL_FOLLOW", "Ljava/lang/String;", "", "VIEW_INDEX_FOLLOW", "I", "VIEW_INDEX_NO_AVAILABLE_GUILDS", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public final void show(FragmentManager fragmentManager, long channelId, long guildId) {
            Intrinsics3.checkNotNullParameter(fragmentManager, "fragmentManager");
            WidgetChannelFollowSheet widgetChannelFollowSheet = new WidgetChannelFollowSheet();
            Bundle bundleT = outline.T("com.discord.intent.extra.EXTRA_CHANNEL_ID", channelId);
            bundleT.putLong("com.discord.intent.extra.EXTRA_GUILD_ID", guildId);
            widgetChannelFollowSheet.setArguments(bundleT);
            widgetChannelFollowSheet.show(fragmentManager, WidgetChannelFollowSheet.class.getName());
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetChannelFollowSheet.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.announcements.WidgetChannelFollowSheet$configureChannelSelector$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnClickListener {
        public final /* synthetic */ Guild $selectedGuild;
        public final /* synthetic */ WidgetChannelFollowSheetViewModel.ViewState.Loaded $viewState;

        public AnonymousClass1(Guild guild, WidgetChannelFollowSheetViewModel.ViewState.Loaded loaded) {
            this.$selectedGuild = guild;
            this.$viewState = loaded;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetChannelSelector.INSTANCE.launch(WidgetChannelFollowSheet.this, this.$selectedGuild.getId(), WidgetChannelFollowSheet.REQUEST_KEY_CHANNEL_FOLLOW, false, R.string.none, new ChannelFollowChannelFilterFunction(this.$selectedGuild.getId(), this.$viewState.getAvailableChannels()));
        }
    }

    /* compiled from: WidgetChannelFollowSheet.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.announcements.WidgetChannelFollowSheet$configureChannelSelector$2, reason: invalid class name */
    public static final class AnonymousClass2 implements View.OnClickListener {
        public final /* synthetic */ Channel $selectedChannel;

        public AnonymousClass2(Channel channel) {
            this.$selectedChannel = channel;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetChannelFollowSheet.access$getViewModel$p(WidgetChannelFollowSheet.this).followChannel(this.$selectedChannel.getId());
        }
    }

    /* compiled from: WidgetChannelFollowSheet.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.announcements.WidgetChannelFollowSheet$configureGuildSelector$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnClickListener {
        public final /* synthetic */ WidgetChannelFollowSheetViewModel.ViewState.Loaded $viewState;

        public AnonymousClass1(WidgetChannelFollowSheetViewModel.ViewState.Loaded loaded) {
            this.$viewState = loaded;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetGuildSelector.Companion.launch$default(WidgetGuildSelector.INSTANCE, WidgetChannelFollowSheet.this, null, false, 0, new WidgetGuildSelector.GuildFilterFunction(this.$viewState.getAvailableGuilds()), 14, null);
        }
    }

    /* compiled from: WidgetChannelFollowSheet.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\b\u001a\u00020\u00052\n\u0010\u0002\u001a\u00060\u0000j\u0002`\u00012\u0006\u0010\u0004\u001a\u00020\u0003H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"", "Lcom/discord/primitives/ChannelId;", "channelId", "", "<anonymous parameter 1>", "", "invoke", "(JLjava/lang/String;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.announcements.WidgetChannelFollowSheet$onCreate$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function2<Long, String, Unit> {
        public AnonymousClass1() {
            super(2);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Long l, String str) {
            invoke(l.longValue(), str);
            return Unit.a;
        }

        public final void invoke(long j, String str) {
            Intrinsics3.checkNotNullParameter(str, "<anonymous parameter 1>");
            WidgetChannelFollowSheet.access$getViewModel$p(WidgetChannelFollowSheet.this).selectChannel(j);
        }
    }

    /* compiled from: WidgetChannelFollowSheet.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\b\u001a\u00020\u00052\n\u0010\u0002\u001a\u00060\u0000j\u0002`\u00012\u0006\u0010\u0004\u001a\u00020\u0003H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"", "Lcom/discord/primitives/GuildId;", "guildId", "", "<anonymous parameter 1>", "", "invoke", "(JLjava/lang/String;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.announcements.WidgetChannelFollowSheet$onCreate$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function2<Long, String, Unit> {
        public AnonymousClass2() {
            super(2);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Long l, String str) {
            invoke(l.longValue(), str);
            return Unit.a;
        }

        public final void invoke(long j, String str) {
            Intrinsics3.checkNotNullParameter(str, "<anonymous parameter 1>");
            WidgetChannelFollowSheet.access$getViewModel$p(WidgetChannelFollowSheet.this).selectGuild(j);
            WidgetChannelFollowSheet.access$getViewModel$p(WidgetChannelFollowSheet.this).selectChannel(0L);
        }
    }

    /* compiled from: WidgetChannelFollowSheet.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/widgets/announcements/WidgetChannelFollowSheetViewModel$ViewState$Loaded;", "p1", "", "invoke", "(Lcom/discord/widgets/announcements/WidgetChannelFollowSheetViewModel$ViewState$Loaded;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.announcements.WidgetChannelFollowSheet$onResume$1, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<WidgetChannelFollowSheetViewModel.ViewState.Loaded, Unit> {
        public AnonymousClass1(WidgetChannelFollowSheet widgetChannelFollowSheet) {
            super(1, widgetChannelFollowSheet, WidgetChannelFollowSheet.class, "configureUI", "configureUI(Lcom/discord/widgets/announcements/WidgetChannelFollowSheetViewModel$ViewState$Loaded;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WidgetChannelFollowSheetViewModel.ViewState.Loaded loaded) {
            invoke2(loaded);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WidgetChannelFollowSheetViewModel.ViewState.Loaded loaded) {
            Intrinsics3.checkNotNullParameter(loaded, "p1");
            WidgetChannelFollowSheet.access$configureUI((WidgetChannelFollowSheet) this.receiver, loaded);
        }
    }

    /* compiled from: WidgetChannelFollowSheet.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/widgets/announcements/WidgetChannelFollowSheetViewModel$Event;", "it", "", "invoke", "(Lcom/discord/widgets/announcements/WidgetChannelFollowSheetViewModel$Event;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.announcements.WidgetChannelFollowSheet$onResume$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function1<WidgetChannelFollowSheetViewModel.Event, Unit> {
        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WidgetChannelFollowSheetViewModel.Event event) {
            invoke2(event);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WidgetChannelFollowSheetViewModel.Event event) {
            Intrinsics3.checkNotNullParameter(event, "it");
            WidgetChannelFollowSheet.this.dismiss();
            WidgetChannelFollowSuccessDialog.Companion companion = WidgetChannelFollowSuccessDialog.INSTANCE;
            FragmentManager parentFragmentManager = WidgetChannelFollowSheet.this.getParentFragmentManager();
            Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
            companion.show(parentFragmentManager);
        }
    }

    public WidgetChannelFollowSheet() {
        super(false, 1, null);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetChannelFollowSheet2.INSTANCE, null, 2, null);
        WidgetChannelFollowSheet3 widgetChannelFollowSheet3 = new WidgetChannelFollowSheet3(this);
        AppViewModelDelegates3 appViewModelDelegates3 = new AppViewModelDelegates3(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection2.getOrCreateKotlinClass(WidgetChannelFollowSheetViewModel.class), new WidgetChannelFollowSheet$appViewModels$$inlined$viewModels$1(appViewModelDelegates3), new AppViewModelDelegates5(widgetChannelFollowSheet3));
    }

    public static final /* synthetic */ void access$configureUI(WidgetChannelFollowSheet widgetChannelFollowSheet, WidgetChannelFollowSheetViewModel.ViewState.Loaded loaded) {
        widgetChannelFollowSheet.configureUI(loaded);
    }

    public static final /* synthetic */ Bundle access$getArgumentsOrDefault$p(WidgetChannelFollowSheet widgetChannelFollowSheet) {
        return widgetChannelFollowSheet.getArgumentsOrDefault();
    }

    public static final /* synthetic */ WidgetChannelFollowSheetViewModel access$getViewModel$p(WidgetChannelFollowSheet widgetChannelFollowSheet) {
        return widgetChannelFollowSheet.getViewModel();
    }

    private final void configureChannelSelector(WidgetChannelFollowSheetViewModel.ViewState.Loaded viewState) {
        int i;
        Guild selectedGuild = viewState.getSelectedGuild();
        Channel selectedChannel = viewState.getSelectedChannel();
        if (selectedGuild != null) {
            getBinding().e.setOnClickListener(new AnonymousClass1(selectedGuild, viewState));
        }
        if (selectedChannel != null) {
            i = R.attr.colorInteractiveActive;
            TextView textView = getBinding().g;
            Intrinsics3.checkNotNullExpressionValue(textView, "binding.channelFollowSelectedChannelName");
            Context contextRequireContext = requireContext();
            Intrinsics3.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
            textView.setText(ChannelUtils.e(selectedChannel, contextRequireContext, false, 2));
            MaterialButton materialButton = getBinding().i;
            Intrinsics3.checkNotNullExpressionValue(materialButton, "binding.createChannelFollowerButton");
            materialButton.setEnabled(true);
            getBinding().i.setOnClickListener(new AnonymousClass2(selectedChannel));
        } else {
            i = R.attr.colorInteractiveNormal;
            TextView textView2 = getBinding().g;
            Intrinsics3.checkNotNullExpressionValue(textView2, "binding.channelFollowSelectedChannelName");
            textView2.setText(getString(R.string.select));
            MaterialButton materialButton2 = getBinding().i;
            Intrinsics3.checkNotNullExpressionValue(materialButton2, "binding.createChannelFollowerButton");
            materialButton2.setEnabled(false);
        }
        TextView textView3 = getBinding().g;
        TextView textView4 = getBinding().h;
        Intrinsics3.checkNotNullExpressionValue(textView4, "binding.channelFollowSelectedGuildName");
        textView3.setTextColor(ColorCompat.getThemedColor(textView4, i));
    }

    private final void configureGuildSelector(WidgetChannelFollowSheetViewModel.ViewState.Loaded viewState) {
        String string;
        getBinding().f.setOnClickListener(new AnonymousClass1(viewState));
        Guild selectedGuild = viewState.getSelectedGuild();
        TextView textView = getBinding().h;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.channelFollowSelectedGuildName");
        if (selectedGuild == null || (string = selectedGuild.getName()) == null) {
            string = getString(R.string.select);
        }
        textView.setText(string);
        int i = selectedGuild != null ? R.attr.colorInteractiveActive : R.attr.colorInteractiveNormal;
        TextView textView2 = getBinding().h;
        TextView textView3 = getBinding().h;
        Intrinsics3.checkNotNullExpressionValue(textView3, "binding.channelFollowSelectedGuildName");
        textView2.setTextColor(ColorCompat.getThemedColor(textView3, i));
    }

    private final void configureUI(WidgetChannelFollowSheetViewModel.ViewState.Loaded viewState) {
        SimpleDraweeView simpleDraweeView = getBinding().d;
        Intrinsics3.checkNotNullExpressionValue(simpleDraweeView, "binding.channelFollowGuildIcon");
        MGImages.setImage$default(simpleDraweeView, IconUtils.getForGuild$default(viewState.getSourceGuild(), null, false, null, 14, null), 0, 0, false, null, null, 124, null);
        Channel sourceChannel = viewState.getSourceChannel();
        if (sourceChannel != null) {
            TextView textView = getBinding().f2255b;
            Intrinsics3.checkNotNullExpressionValue(textView, "binding.channelFollowChannelName");
            Context contextRequireContext = requireContext();
            Intrinsics3.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
            textView.setText(ChannelUtils.d(sourceChannel, contextRequireContext, false));
        }
        if (viewState.getAvailableGuilds().isEmpty()) {
            AppViewFlipper appViewFlipper = getBinding().j;
            Intrinsics3.checkNotNullExpressionValue(appViewFlipper, "binding.followSheetViewFlipper");
            appViewFlipper.setDisplayedChild(1);
        } else {
            AppViewFlipper appViewFlipper2 = getBinding().j;
            Intrinsics3.checkNotNullExpressionValue(appViewFlipper2, "binding.followSheetViewFlipper");
            appViewFlipper2.setDisplayedChild(0);
            configureGuildSelector(viewState);
            configureChannelSelector(viewState);
        }
        if (viewState.getErrorTextRes() == null) {
            TextView textView2 = getBinding().c;
            Intrinsics3.checkNotNullExpressionValue(textView2, "binding.channelFollowErrorText");
            textView2.setVisibility(8);
        } else {
            getBinding().c.setText(viewState.getErrorTextRes().intValue());
            TextView textView3 = getBinding().c;
            Intrinsics3.checkNotNullExpressionValue(textView3, "binding.channelFollowErrorText");
            textView3.setVisibility(0);
        }
    }

    private final WidgetChannelFollowSheetBinding getBinding() {
        return (WidgetChannelFollowSheetBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final WidgetChannelFollowSheetViewModel getViewModel() {
        return (WidgetChannelFollowSheetViewModel) this.viewModel.getValue();
    }

    public static final void show(FragmentManager fragmentManager, long j, long j2) {
        INSTANCE.show(fragmentManager, j, j2);
    }

    @Override // com.discord.app.AppBottomSheet
    public int getContentViewResId() {
        return R.layout.widget_channel_follow_sheet;
    }

    @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        WidgetChannelSelector.INSTANCE.registerForResult(this, REQUEST_KEY_CHANNEL_FOLLOW, true, new AnonymousClass1());
        WidgetGuildSelector.Companion.registerForResult$default(WidgetGuildSelector.INSTANCE, this, null, true, new AnonymousClass2(), 2, null);
    }

    @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        Observable<WidgetChannelFollowSheetViewModel.ViewState> observableR = getViewModel().observeViewState().r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "viewModel\n        .obser…  .distinctUntilChanged()");
        Observable<R> observableG = observableR.y(WidgetChannelFollowSheet$onResume$$inlined$filterIs$1.INSTANCE).G(WidgetChannelFollowSheet$onResume$$inlined$filterIs$2.INSTANCE);
        Intrinsics3.checkNotNullExpressionValue(observableG, "filter { it is T }.map { it as T }");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(observableG, this, null, 2, null), WidgetChannelFollowSheet.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(this), 62, (Object) null);
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeEvents(), this, null, 2, null), WidgetChannelFollowSheet.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass2(), 62, (Object) null);
    }
}

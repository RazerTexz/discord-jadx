package com.discord.utilities.channel;

import android.content.Context;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.FragmentManager;
import com.discord.R;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.stores.Dispatcher;
import com.discord.stores.StoreChannels;
import com.discord.stores.StoreChannelsSelected3;
import com.discord.stores.StoreNavigation;
import com.discord.stores.StoreStream;
import com.discord.stores.updates.ObservationDeck;
import com.discord.utilities.accessibility.AccessibilityUtils;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.permissions.PermissionUtils;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.widgets.chat.list.TextInVoiceFeatureFlag;
import com.discord.widgets.voice.sheet.WidgetVoiceBottomSheet;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import j0.k.Func1;
import j0.l.e.ScalarSynchronousObservable;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* compiled from: ChannelSelector.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 82\u00020\u0001:\u00018B\u001f\u0012\u0006\u00102\u001a\u000201\u0012\u0006\u0010(\u001a\u00020'\u0012\u0006\u0010-\u001a\u00020,¢\u0006\u0004\b6\u00107JA\u0010\u000b\u001a\u00020\n2\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u00032\n\u0010\u0006\u001a\u00060\u0002j\u0002`\u00052\u000e\u0010\u0007\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u00052\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0002¢\u0006\u0004\b\u000b\u0010\fJ5\u0010\u000f\u001a\u00020\n2\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0010\b\u0002\u0010\u0007\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u000f\u0010\u0010JC\u0010\u000f\u001a\u00020\n2\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u00032\n\u0010\u0006\u001a\u00060\u0002j\u0002`\u00052\u0010\b\u0002\u0010\u0007\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u000f\u0010\fJ\u0019\u0010\u0011\u001a\u00020\n2\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003¢\u0006\u0004\b\u0011\u0010\u0012J#\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u00132\f\b\u0002\u0010\u0016\u001a\u00060\u0002j\u0002`\u0015¢\u0006\u0004\b\u0017\u0010\u0018J#\u0010\u0019\u001a\u00020\n2\b\u0010\u0014\u001a\u0004\u0018\u00010\u00132\n\u0010\u0006\u001a\u00060\u0002j\u0002`\u0005¢\u0006\u0004\b\u0019\u0010\u0018J#\u0010\u001a\u001a\u00020\n2\b\u0010\u0014\u001a\u0004\u0018\u00010\u00132\n\u0010\u0006\u001a\u00060\u0002j\u0002`\u0005¢\u0006\u0004\b\u001a\u0010\u0018JA\u0010\u001f\u001a\u00020\n2\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u00032\n\u0010\u0006\u001a\u00060\u0002j\u0002`\u00052\u0010\b\u0002\u0010\u001c\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u001b2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001d¢\u0006\u0004\b\u001f\u0010 J\r\u0010!\u001a\u00020\n¢\u0006\u0004\b!\u0010\"J!\u0010%\u001a\u00020\n2\u0006\u0010$\u001a\u00020#2\n\u0010\u0006\u001a\u00060\u0002j\u0002`\u0005¢\u0006\u0004\b%\u0010&R\u0019\u0010(\u001a\u00020'8\u0006@\u0006¢\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+R\u0019\u0010-\u001a\u00020,8\u0006@\u0006¢\u0006\f\n\u0004\b-\u0010.\u001a\u0004\b/\u00100R\u0019\u00102\u001a\u0002018\u0006@\u0006¢\u0006\f\n\u0004\b2\u00103\u001a\u0004\b4\u00105¨\u00069"}, d2 = {"Lcom/discord/utilities/channel/ChannelSelector;", "", "", "Lcom/discord/primitives/GuildId;", "guildId", "Lcom/discord/primitives/ChannelId;", "channelId", "peekParent", "Lcom/discord/stores/SelectedChannelAnalyticsLocation;", "analyticsLocation", "", "gotoChannel", "(JJLjava/lang/Long;Lcom/discord/stores/SelectedChannelAnalyticsLocation;)V", "Lcom/discord/api/channel/Channel;", "channel", "selectChannel", "(Lcom/discord/api/channel/Channel;Ljava/lang/Long;Lcom/discord/stores/SelectedChannelAnalyticsLocation;)V", "selectPreviousChannel", "(J)V", "Landroid/content/Context;", "context", "Lcom/discord/primitives/UserId;", "userId", "findAndSetDirectMessage", "(Landroid/content/Context;J)V", "findAndSetThread", "findAndSet", "Lcom/discord/primitives/MessageId;", "parentMessageId", "", "startThreadLocation", "openCreateThread", "(JJLjava/lang/Long;Ljava/lang/String;)V", "dismissCreateThread", "()V", "Landroidx/fragment/app/FragmentManager;", "fragmentManager", "previewVoiceChannel", "(Landroidx/fragment/app/FragmentManager;J)V", "Lcom/discord/stores/Dispatcher;", "dispatcher", "Lcom/discord/stores/Dispatcher;", "getDispatcher", "()Lcom/discord/stores/Dispatcher;", "Lcom/discord/stores/updates/ObservationDeck;", "observationDeck", "Lcom/discord/stores/updates/ObservationDeck;", "getObservationDeck", "()Lcom/discord/stores/updates/ObservationDeck;", "Lcom/discord/stores/StoreStream;", "stream", "Lcom/discord/stores/StoreStream;", "getStream", "()Lcom/discord/stores/StoreStream;", "<init>", "(Lcom/discord/stores/StoreStream;Lcom/discord/stores/Dispatcher;Lcom/discord/stores/updates/ObservationDeck;)V", "Companion", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class ChannelSelector {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static ChannelSelector INSTANCE;
    private final Dispatcher dispatcher;
    private final ObservationDeck observationDeck;
    private final StoreStream stream;

    /* compiled from: ChannelSelector.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0003\u0010\u0004J%\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\f\u0010\rR\u0016\u0010\u000e\u001a\u00020\u00028\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f¨\u0006\u0012"}, d2 = {"Lcom/discord/utilities/channel/ChannelSelector$Companion;", "", "Lcom/discord/utilities/channel/ChannelSelector;", "getInstance", "()Lcom/discord/utilities/channel/ChannelSelector;", "Lcom/discord/stores/StoreStream;", "stream", "Lcom/discord/stores/Dispatcher;", "dispatcher", "Lcom/discord/stores/updates/ObservationDeck;", "observationDeck", "", "init", "(Lcom/discord/stores/StoreStream;Lcom/discord/stores/Dispatcher;Lcom/discord/stores/updates/ObservationDeck;)V", "INSTANCE", "Lcom/discord/utilities/channel/ChannelSelector;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public final ChannelSelector getInstance() {
            ChannelSelector channelSelectorAccess$getINSTANCE$cp = ChannelSelector.access$getINSTANCE$cp();
            if (channelSelectorAccess$getINSTANCE$cp == null) {
                Intrinsics3.throwUninitializedPropertyAccessException("INSTANCE");
            }
            return channelSelectorAccess$getINSTANCE$cp;
        }

        public final void init(StoreStream stream, Dispatcher dispatcher, ObservationDeck observationDeck) {
            Intrinsics3.checkNotNullParameter(stream, "stream");
            Intrinsics3.checkNotNullParameter(dispatcher, "dispatcher");
            Intrinsics3.checkNotNullParameter(observationDeck, "observationDeck");
            ChannelSelector.access$setINSTANCE$cp(new ChannelSelector(stream, dispatcher, observationDeck));
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: ChannelSelector.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.utilities.channel.ChannelSelector$dismissCreateThread$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public AnonymousClass1() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            ChannelSelector.this.getStream().getChannelsSelected().dismissCreateThread();
        }
    }

    /* compiled from: ChannelSelector.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/discord/api/channel/Channel;", "invoke", "()Lcom/discord/api/channel/Channel;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.utilities.channel.ChannelSelector$findAndSet$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<Channel> {
        public final /* synthetic */ long $channelId;
        public final /* synthetic */ Context $context;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(long j, Context context) {
            super(0);
            this.$channelId = j;
            this.$context = context;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Channel invoke() {
            return invoke();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final Channel invoke() {
            Channel channelFindChannelById = ChannelSelector.this.getStream().getChannels().findChannelById(this.$channelId);
            if (channelFindChannelById != null && PermissionUtils.INSTANCE.hasAccess(channelFindChannelById, ChannelSelector.this.getStream().getPermissions().getPermissionsByChannel().get(Long.valueOf(this.$channelId)))) {
                return channelFindChannelById;
            }
            Context context = this.$context;
            if (context != null) {
                AccessibilityUtils accessibilityUtils = AccessibilityUtils.INSTANCE;
                String string = context.getString(R.string.inaccessible_channel_link_title);
                Intrinsics3.checkNotNullExpressionValue(string, "context.getString(R.stri…sible_channel_link_title)");
                accessibilityUtils.sendAnnouncement(context, string);
            }
            return null;
        }
    }

    /* compiled from: ChannelSelector.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\u0010\u0006\u001a\n \u0003*\u0004\u0018\u00010\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/discord/api/channel/Channel;", "it", "", "kotlin.jvm.PlatformType", NotificationCompat.CATEGORY_CALL, "(Lcom/discord/api/channel/Channel;)Ljava/lang/Boolean;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.utilities.channel.ChannelSelector$findAndSet$2, reason: invalid class name */
    public static final class AnonymousClass2<T, R> implements Func1<Channel, Boolean> {
        public static final AnonymousClass2 INSTANCE = new AnonymousClass2();

        @Override // j0.k.Func1
        public /* bridge */ /* synthetic */ Boolean call(Channel channel) {
            return call2(channel);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final Boolean call2(Channel channel) {
            return Boolean.valueOf(channel != null);
        }
    }

    /* compiled from: ChannelSelector.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/api/channel/Channel;", "it", "", "invoke", "(Lcom/discord/api/channel/Channel;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.utilities.channel.ChannelSelector$findAndSet$3, reason: invalid class name */
    public static final class AnonymousClass3 extends Lambda implements Function1<Channel, Unit> {
        public AnonymousClass3() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Channel channel) {
            invoke2(channel);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Channel channel) {
            ChannelSelector.selectChannel$default(ChannelSelector.this, channel, null, null, 6, null);
        }
    }

    /* compiled from: ChannelSelector.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/api/channel/Channel;", "channel", "", "invoke", "(Lcom/discord/api/channel/Channel;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.utilities.channel.ChannelSelector$findAndSetDirectMessage$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<Channel, Unit> {
        public final /* synthetic */ Context $context;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Context context) {
            super(1);
            this.$context = context;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Channel channel) {
            invoke2(channel);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Channel channel) {
            Intrinsics3.checkNotNullParameter(channel, "channel");
            ChannelSelector.this.findAndSet(this.$context, channel.getId());
        }
    }

    /* compiled from: ChannelSelector.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/api/channel/Channel;", "channel", "", "invoke", "(Lcom/discord/api/channel/Channel;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.utilities.channel.ChannelSelector$findAndSetThread$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<Channel, Unit> {
        public final /* synthetic */ long $channelId;
        public final /* synthetic */ Context $context;

        /* compiled from: ChannelSelector.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.utilities.channel.ChannelSelector$findAndSetThread$1$1, reason: invalid class name and collision with other inner class name */
        public static final class C02111 extends Lambda implements Function0<Unit> {
            public final /* synthetic */ Channel $channel;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C02111(Channel channel) {
                super(0);
                this.$channel = channel;
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                ChannelSelector.this.getStream().handleThreadCreateOrUpdate(this.$channel);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Context context, long j) {
            super(1);
            this.$context = context;
            this.$channelId = j;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Channel channel) {
            invoke2(channel);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Channel channel) {
            Intrinsics3.checkNotNullParameter(channel, "channel");
            ChannelSelector.this.getDispatcher().schedule(new C02111(channel));
            ChannelSelector.this.findAndSet(this.$context, this.$channelId);
        }
    }

    /* compiled from: ChannelSelector.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.utilities.channel.ChannelSelector$gotoChannel$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ StoreChannelsSelected3 $analyticsLocation;
        public final /* synthetic */ long $channelId;
        public final /* synthetic */ long $guildId;
        public final /* synthetic */ Long $peekParent;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(long j, long j2, Long l, StoreChannelsSelected3 storeChannelsSelected3) {
            super(0);
            this.$guildId = j;
            this.$channelId = j2;
            this.$peekParent = l;
            this.$analyticsLocation = storeChannelsSelected3;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            ChannelSelector.this.getStream().handleGuildSelected(this.$guildId);
            ChannelSelector.this.getStream().getChannelsSelected().trySelectChannel(this.$guildId, this.$channelId, this.$peekParent, this.$analyticsLocation);
        }
    }

    /* compiled from: ChannelSelector.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.utilities.channel.ChannelSelector$openCreateThread$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ long $channelId;
        public final /* synthetic */ long $guildId;
        public final /* synthetic */ Long $parentMessageId;
        public final /* synthetic */ String $startThreadLocation;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(long j, long j2, Long l, String str) {
            super(0);
            this.$guildId = j;
            this.$channelId = j2;
            this.$parentMessageId = l;
            this.$startThreadLocation = str;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            ChannelSelector.this.getStream().getThreadDraft().clearDraftState();
            ChannelSelector.this.getStream().getChannelsSelected().openCreateThread(this.$guildId, this.$channelId, this.$parentMessageId, this.$startThreadLocation);
            AnalyticsTracker.INSTANCE.threadCreationStarted(this.$channelId, this.$guildId, this.$startThreadLocation);
        }
    }

    /* compiled from: ChannelSelector.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/discord/api/channel/Channel;", "invoke", "()Lcom/discord/api/channel/Channel;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.utilities.channel.ChannelSelector$previewVoiceChannel$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<Channel> {
        public final /* synthetic */ long $channelId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(long j) {
            super(0);
            this.$channelId = j;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Channel invoke() {
            return invoke();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final Channel invoke() {
            Channel channelFindChannelById = ChannelSelector.this.getStream().getChannels().findChannelById(this.$channelId);
            if (channelFindChannelById != null && PermissionUtils.INSTANCE.hasAccess(channelFindChannelById, ChannelSelector.this.getStream().getPermissions().getPermissionsByChannel().get(Long.valueOf(this.$channelId)))) {
                return channelFindChannelById;
            }
            return null;
        }
    }

    /* compiled from: ChannelSelector.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/discord/api/channel/Channel;", "kotlin.jvm.PlatformType", "channel", "", "invoke", "(Lcom/discord/api/channel/Channel;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.utilities.channel.ChannelSelector$previewVoiceChannel$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function1<Channel, Unit> {
        public final /* synthetic */ long $channelId;
        public final /* synthetic */ WeakReference $fragmentManagerRef;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(WeakReference weakReference, long j) {
            super(1);
            this.$fragmentManagerRef = weakReference;
            this.$channelId = j;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Channel channel) {
            invoke2(channel);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Channel channel) {
            FragmentManager fragmentManager = (FragmentManager) this.$fragmentManagerRef.get();
            if (fragmentManager != null) {
                Intrinsics3.checkNotNullExpressionValue(fragmentManager, "fragmentManagerRef.get() ?: return@appSubscribe");
                StoreStream.INSTANCE.getGuildSelected().set(channel.getGuildId());
                WidgetVoiceBottomSheet.INSTANCE.show(fragmentManager, this.$channelId, true, WidgetVoiceBottomSheet.FeatureContext.HOME);
            }
        }
    }

    /* compiled from: ChannelSelector.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0010\u0001\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "it", "", "invoke", "(Ljava/lang/Void;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.utilities.channel.ChannelSelector$selectChannel$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1 {
        public final /* synthetic */ StoreChannelsSelected3 $analyticsLocation;
        public final /* synthetic */ long $channelId;
        public final /* synthetic */ long $guildId;
        public final /* synthetic */ Long $peekParent;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(long j, long j2, Long l, StoreChannelsSelected3 storeChannelsSelected3) {
            super(1);
            this.$guildId = j;
            this.$channelId = j2;
            this.$peekParent = l;
            this.$analyticsLocation = storeChannelsSelected3;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((Void) obj);
            return Unit.a;
        }

        public final void invoke(Void r8) {
            ChannelSelector.access$gotoChannel(ChannelSelector.this, this.$guildId, this.$channelId, this.$peekParent, this.$analyticsLocation);
        }
    }

    /* compiled from: ChannelSelector.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/discord/api/channel/Channel;", "kotlin.jvm.PlatformType", "channel", "", "invoke", "(Lcom/discord/api/channel/Channel;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.utilities.channel.ChannelSelector$selectChannel$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function1<Channel, Unit> {
        public final /* synthetic */ StoreChannelsSelected3 $analyticsLocation;
        public final /* synthetic */ long $channelId;
        public final /* synthetic */ long $guildId;
        public final /* synthetic */ Long $peekParent;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(long j, long j2, Long l, StoreChannelsSelected3 storeChannelsSelected3) {
            super(1);
            this.$guildId = j;
            this.$channelId = j2;
            this.$peekParent = l;
            this.$analyticsLocation = storeChannelsSelected3;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Channel channel) {
            invoke2(channel);
            return Unit.a;
        }

        /* JADX WARN: Removed duplicated region for block: B:6:0x001f  */
        /* JADX WARN: Removed duplicated region for block: B:8:0x0028  */
        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final void invoke2(Channel channel) {
            boolean z2;
            if (!TextInVoiceFeatureFlag.INSTANCE.getINSTANCE().isEnabled(Long.valueOf(channel.getGuildId()))) {
                Intrinsics3.checkNotNullExpressionValue(channel, "channel");
                if (!ChannelUtils.J(channel)) {
                    Intrinsics3.checkNotNullExpressionValue(channel, "channel");
                    z2 = ChannelUtils.D(channel);
                }
            }
            ChannelSelector.access$gotoChannel(ChannelSelector.this, this.$guildId, z2 ? this.$guildId : this.$channelId, this.$peekParent, this.$analyticsLocation);
            if (z2) {
                ChannelSelector.this.getStream().getVoiceChannelSelected().selectVoiceChannel(this.$channelId);
            }
        }
    }

    /* compiled from: ChannelSelector.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\b\u001a\u001e\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u0005 \u0002*\u000e\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u00040\u00042\u0018\u0010\u0003\u001a\u0014 \u0002*\n\u0018\u00010\u0000j\u0004\u0018\u0001`\u00010\u0000j\u0002`\u0001H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"", "Lcom/discord/primitives/ChannelId;", "kotlin.jvm.PlatformType", "previousChannelId", "Lrx/Observable;", "Lcom/discord/api/channel/Channel;", NotificationCompat.CATEGORY_CALL, "(Ljava/lang/Long;)Lrx/Observable;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.utilities.channel.ChannelSelector$selectPreviousChannel$1, reason: invalid class name */
    public static final class AnonymousClass1<T, R> implements Func1<Long, Observable<? extends Channel>> {
        public AnonymousClass1() {
        }

        @Override // j0.k.Func1
        public /* bridge */ /* synthetic */ Observable<? extends Channel> call(Long l) {
            return call2(l);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final Observable<? extends Channel> call2(Long l) {
            StoreChannels channels = ChannelSelector.this.getStream().getChannels();
            Intrinsics3.checkNotNullExpressionValue(l, "previousChannelId");
            return channels.observeChannel(l.longValue());
        }
    }

    /* compiled from: ChannelSelector.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/api/channel/Channel;", "previousChannel", "", "invoke", "(Lcom/discord/api/channel/Channel;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.utilities.channel.ChannelSelector$selectPreviousChannel$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function1<Channel, Unit> {
        public final /* synthetic */ long $guildId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(long j) {
            super(1);
            this.$guildId = j;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Channel channel) {
            invoke2(channel);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Channel channel) {
            long id2 = 0;
            if (channel != null && !ChannelUtils.J(channel) && channel.getId() >= 0) {
                id2 = channel.getId();
            }
            ChannelSelector.selectChannel$default(ChannelSelector.this, this.$guildId, id2, null, null, 12, null);
        }
    }

    public ChannelSelector(StoreStream storeStream, Dispatcher dispatcher, ObservationDeck observationDeck) {
        Intrinsics3.checkNotNullParameter(storeStream, "stream");
        Intrinsics3.checkNotNullParameter(dispatcher, "dispatcher");
        Intrinsics3.checkNotNullParameter(observationDeck, "observationDeck");
        this.stream = storeStream;
        this.dispatcher = dispatcher;
        this.observationDeck = observationDeck;
    }

    public static final /* synthetic */ ChannelSelector access$getINSTANCE$cp() {
        return INSTANCE;
    }

    public static final /* synthetic */ void access$gotoChannel(ChannelSelector channelSelector, long j, long j2, Long l, StoreChannelsSelected3 storeChannelsSelected3) {
        channelSelector.gotoChannel(j, j2, l, storeChannelsSelected3);
    }

    public static final /* synthetic */ void access$setINSTANCE$cp(ChannelSelector channelSelector) {
        INSTANCE = channelSelector;
    }

    public static /* synthetic */ void findAndSetDirectMessage$default(ChannelSelector channelSelector, Context context, long j, int i, Object obj) {
        if ((i & 2) != 0) {
            j = 0;
        }
        channelSelector.findAndSetDirectMessage(context, j);
    }

    public static final ChannelSelector getInstance() {
        return INSTANCE.getInstance();
    }

    private final void gotoChannel(long guildId, long channelId, Long peekParent, StoreChannelsSelected3 analyticsLocation) {
        this.dispatcher.schedule(new AnonymousClass1(guildId, channelId, peekParent, analyticsLocation));
    }

    public static /* synthetic */ void openCreateThread$default(ChannelSelector channelSelector, long j, long j2, Long l, String str, int i, Object obj) {
        if ((i & 4) != 0) {
            l = null;
        }
        channelSelector.openCreateThread(j, j2, l, str);
    }

    public static /* synthetic */ void selectChannel$default(ChannelSelector channelSelector, Channel channel, Long l, StoreChannelsSelected3 storeChannelsSelected3, int i, Object obj) {
        if ((i & 2) != 0) {
            l = null;
        }
        if ((i & 4) != 0) {
            storeChannelsSelected3 = null;
        }
        channelSelector.selectChannel(channel, l, storeChannelsSelected3);
    }

    public final void dismissCreateThread() {
        this.dispatcher.schedule(new AnonymousClass1());
    }

    public final void findAndSet(Context context, long channelId) {
        if (channelId <= 0) {
            return;
        }
        Observable observableY = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this.stream.getChannels(), this.stream.getPermissions()}, false, null, null, new AnonymousClass1(channelId, context), 14, null).y(AnonymousClass2.INSTANCE);
        Intrinsics3.checkNotNullExpressionValue(observableY, "observationDeck\n        …   .filter { it != null }");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.computationLatest(ObservableExtensionsKt.takeSingleUntilTimeout$default(observableY, 0L, true, 1, null)), ChannelSelector.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass3(), 62, (Object) null);
    }

    public final void findAndSetDirectMessage(Context context, long userId) {
        Intrinsics3.checkNotNullParameter(context, "context");
        if (userId <= 0) {
            return;
        }
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui(ObservableExtensionsKt.computationBuffered(RestAPI.INSTANCE.getApi().createOrFetchDM(userId))), ChannelSelector.class, context, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(context), 60, (Object) null);
    }

    public final void findAndSetThread(Context context, long channelId) {
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui(ObservableExtensionsKt.computationBuffered(RestAPI.INSTANCE.getApi().getChannel(channelId))), ChannelSelector.class, context, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(context, channelId), 60, (Object) null);
    }

    public final Dispatcher getDispatcher() {
        return this.dispatcher;
    }

    public final ObservationDeck getObservationDeck() {
        return this.observationDeck;
    }

    public final StoreStream getStream() {
        return this.stream;
    }

    public final void openCreateThread(long guildId, long channelId, Long parentMessageId, String startThreadLocation) {
        this.dispatcher.schedule(new AnonymousClass1(guildId, channelId, parentMessageId, startThreadLocation));
    }

    public final void previewVoiceChannel(FragmentManager fragmentManager, long channelId) {
        Intrinsics3.checkNotNullParameter(fragmentManager, "fragmentManager");
        WeakReference weakReference = new WeakReference(fragmentManager);
        Observable observableG = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this.stream.getChannels(), this.stream.getPermissions()}, false, null, null, new AnonymousClass1(channelId), 14, null).y(ObservableExtensionsKt.AnonymousClass1.INSTANCE).G(ObservableExtensionsKt.AnonymousClass2.INSTANCE);
        Intrinsics3.checkNotNullExpressionValue(observableG, "filter { it != null }.map { it!! }");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui(ObservableExtensionsKt.takeSingleUntilTimeout$default(observableG, 0L, false, 3, null)), ChannelSelector.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass2(weakReference, channelId), 62, (Object) null);
    }

    public final void selectChannel(Channel channel, Long peekParent, StoreChannelsSelected3 analyticsLocation) {
        if (channel != null) {
            selectChannel(channel.getGuildId(), channel.getId(), peekParent, analyticsLocation);
        }
    }

    public final void selectPreviousChannel(long guildId) {
        Observable<R> observableY = this.stream.getChannelsSelected().observePreviousId().Y(new AnonymousClass1());
        Intrinsics3.checkNotNullExpressionValue(observableY, "stream.channelsSelected.…nnel(previousChannelId) }");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.takeSingleUntilTimeout$default(observableY, 0L, false, 3, null), ChannelSelector.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass2(guildId), 62, (Object) null);
    }

    public static /* synthetic */ void selectChannel$default(ChannelSelector channelSelector, long j, long j2, Long l, StoreChannelsSelected3 storeChannelsSelected3, int i, Object obj) {
        channelSelector.selectChannel(j, j2, (i & 4) != 0 ? null : l, (i & 8) != 0 ? null : storeChannelsSelected3);
    }

    public final void selectChannel(long guildId, long channelId, Long peekParent, StoreChannelsSelected3 analyticsLocation) {
        StoreNavigation.setNavigationPanelAction$default(this.stream.getNavigation(), StoreNavigation.PanelAction.CLOSE, null, 2, null);
        if (guildId == 0 || channelId == 0) {
            ScalarSynchronousObservable scalarSynchronousObservable = new ScalarSynchronousObservable(null);
            Intrinsics3.checkNotNullExpressionValue(scalarSynchronousObservable, "Observable.just(null)");
            ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.computationLatest(scalarSynchronousObservable), ChannelSelector.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(guildId, channelId, peekParent, analyticsLocation), 62, (Object) null);
        } else {
            Observable<R> observableG = this.stream.getChannels().observeChannel(channelId).y(ObservableExtensionsKt.AnonymousClass1.INSTANCE).G(ObservableExtensionsKt.AnonymousClass2.INSTANCE);
            Intrinsics3.checkNotNullExpressionValue(observableG, "filter { it != null }.map { it!! }");
            ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.takeSingleUntilTimeout$default(observableG, 0L, false, 3, null), ChannelSelector.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass2(guildId, channelId, peekParent, analyticsLocation), 62, (Object) null);
        }
    }
}

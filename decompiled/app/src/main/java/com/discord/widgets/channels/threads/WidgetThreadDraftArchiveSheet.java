package com.discord.widgets.channels.threads;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.api.channel.Channel;
import com.discord.app.AppBottomSheet;
import com.discord.databinding.WidgetThreadArchiveActionsSheetBinding;
import com.discord.models.guild.Guild;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreThreadDraft;
import com.discord.utilities.analytics.Traits;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.threads.ThreadUtils;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.google.android.material.radiobutton.MaterialRadioButton;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import rx.Observable;
import rx.subscriptions.CompositeSubscription;

/* compiled from: WidgetThreadDraftArchiveSheet.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u001c2\u00020\u0001:\u0002\u001c\u001dB\u0007¢\u0006\u0004\b\u001b\u0010\u0014J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\u000b\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\tH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0013\u0010\u0014R\u001d\u0010\u001a\u001a\u00020\u00158B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019¨\u0006\u001e"}, d2 = {"Lcom/discord/widgets/channels/threads/WidgetThreadDraftArchiveSheet;", "Lcom/discord/app/AppBottomSheet;", "Lcom/discord/widgets/channels/threads/WidgetThreadDraftArchiveSheet$Model;", "model", "", "configureUI", "(Lcom/discord/widgets/channels/threads/WidgetThreadDraftArchiveSheet$Model;)V", "Lcom/discord/stores/StoreThreadDraft$ThreadDraftState;", "draftState", "", "minutes", "setAutoArchiveDuration", "(Lcom/discord/stores/StoreThreadDraft$ThreadDraftState;I)V", "getContentViewResId", "()I", "Lrx/subscriptions/CompositeSubscription;", "compositeSubscription", "bindSubscriptions", "(Lrx/subscriptions/CompositeSubscription;)V", "onPause", "()V", "Lcom/discord/databinding/WidgetThreadArchiveActionsSheetBinding;", "binding$delegate", "Lcom/discord/utilities/viewbinding/FragmentViewBindingDelegate;", "getBinding", "()Lcom/discord/databinding/WidgetThreadArchiveActionsSheetBinding;", "binding", "<init>", "Companion", ExifInterface.TAG_MODEL, "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetThreadDraftArchiveSheet extends AppBottomSheet {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetThreadDraftArchiveSheet.class, "binding", "getBinding()Lcom/discord/databinding/WidgetThreadArchiveActionsSheetBinding;", 0)};

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String INTENT_EXTRA_GUILD_ID = "INTENT_EXTRA_GUILD_ID";

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* compiled from: WidgetThreadDraftArchiveSheet.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\r\u0010\u000eJ#\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\n\u0010\u0006\u001a\u00060\u0004j\u0002`\u0005H\u0007¢\u0006\u0004\b\b\u0010\tR\u0016\u0010\u000b\u001a\u00020\n8\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000b\u0010\f¨\u0006\u000f"}, d2 = {"Lcom/discord/widgets/channels/threads/WidgetThreadDraftArchiveSheet$Companion;", "", "Landroidx/fragment/app/FragmentManager;", "fragmentManager", "", "Lcom/discord/primitives/GuildId;", "guildId", "", "show", "(Landroidx/fragment/app/FragmentManager;J)V", "", "INTENT_EXTRA_GUILD_ID", "Ljava/lang/String;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public final void show(FragmentManager fragmentManager, long guildId) {
            Intrinsics3.checkNotNullParameter(fragmentManager, "fragmentManager");
            WidgetThreadDraftArchiveSheet widgetThreadDraftArchiveSheet = new WidgetThreadDraftArchiveSheet();
            Bundle bundle = new Bundle();
            bundle.putLong("INTENT_EXTRA_GUILD_ID", guildId);
            widgetThreadDraftArchiveSheet.setArguments(bundle);
            widgetThreadDraftArchiveSheet.show(fragmentManager, WidgetThreadDraftArchiveSheet.class.getName());
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetThreadDraftArchiveSheet.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\f\b\u0082\b\u0018\u0000 \"2\u00020\u0001:\u0001\"B#\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\r\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b \u0010!J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\t\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ2\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u000b\u001a\u00020\u00022\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0014\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u001a\u0010\u0018\u001a\u00020\u00172\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0018\u0010\u0019R\u001b\u0010\r\u001a\u0004\u0018\u00010\b8\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u001a\u001a\u0004\b\u001b\u0010\nR\u001b\u0010\f\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\u001c\u001a\u0004\b\u001d\u0010\u0007R\u0019\u0010\u000b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u001e\u001a\u0004\b\u001f\u0010\u0004¨\u0006#"}, d2 = {"Lcom/discord/widgets/channels/threads/WidgetThreadDraftArchiveSheet$Model;", "", "Lcom/discord/stores/StoreThreadDraft$ThreadDraftState;", "component1", "()Lcom/discord/stores/StoreThreadDraft$ThreadDraftState;", "Lcom/discord/models/guild/Guild;", "component2", "()Lcom/discord/models/guild/Guild;", "Lcom/discord/api/channel/Channel;", "component3", "()Lcom/discord/api/channel/Channel;", "draftState", "guild", "channel", "copy", "(Lcom/discord/stores/StoreThreadDraft$ThreadDraftState;Lcom/discord/models/guild/Guild;Lcom/discord/api/channel/Channel;)Lcom/discord/widgets/channels/threads/WidgetThreadDraftArchiveSheet$Model;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/discord/api/channel/Channel;", "getChannel", "Lcom/discord/models/guild/Guild;", "getGuild", "Lcom/discord/stores/StoreThreadDraft$ThreadDraftState;", "getDraftState", "<init>", "(Lcom/discord/stores/StoreThreadDraft$ThreadDraftState;Lcom/discord/models/guild/Guild;Lcom/discord/api/channel/Channel;)V", "Companion", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class Model {

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final Channel channel;
        private final StoreThreadDraft.ThreadDraftState draftState;
        private final Guild guild;

        /* compiled from: WidgetThreadDraftArchiveSheet.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003¢\u0006\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/discord/widgets/channels/threads/WidgetThreadDraftArchiveSheet$Model$Companion;", "", "", "Lcom/discord/primitives/GuildId;", "guildId", "Lrx/Observable;", "Lcom/discord/widgets/channels/threads/WidgetThreadDraftArchiveSheet$Model;", "get", "(J)Lrx/Observable;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class Companion {
            private Companion() {
            }

            public final Observable<Model> get(long guildId) {
                StoreStream.Companion companion = StoreStream.INSTANCE;
                Observable observableI = Observable.i(companion.getThreadDraft().observeDraftState(), companion.getGuilds().observeGuild(guildId), companion.getChannelsSelected().observeSelectedChannel(), WidgetThreadDraftArchiveSheet2.INSTANCE);
                Intrinsics3.checkNotNullExpressionValue(observableI, "Observable.combineLatest…, guild, channel)\n      }");
                Observable<Model> observableR = ObservableExtensionsKt.computationLatest(observableI).r();
                Intrinsics3.checkNotNullExpressionValue(observableR, "Observable.combineLatest…  .distinctUntilChanged()");
                return observableR;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public Model(StoreThreadDraft.ThreadDraftState threadDraftState, Guild guild, Channel channel) {
            Intrinsics3.checkNotNullParameter(threadDraftState, "draftState");
            this.draftState = threadDraftState;
            this.guild = guild;
            this.channel = channel;
        }

        public static /* synthetic */ Model copy$default(Model model, StoreThreadDraft.ThreadDraftState threadDraftState, Guild guild, Channel channel, int i, Object obj) {
            if ((i & 1) != 0) {
                threadDraftState = model.draftState;
            }
            if ((i & 2) != 0) {
                guild = model.guild;
            }
            if ((i & 4) != 0) {
                channel = model.channel;
            }
            return model.copy(threadDraftState, guild, channel);
        }

        /* renamed from: component1, reason: from getter */
        public final StoreThreadDraft.ThreadDraftState getDraftState() {
            return this.draftState;
        }

        /* renamed from: component2, reason: from getter */
        public final Guild getGuild() {
            return this.guild;
        }

        /* renamed from: component3, reason: from getter */
        public final Channel getChannel() {
            return this.channel;
        }

        public final Model copy(StoreThreadDraft.ThreadDraftState draftState, Guild guild, Channel channel) {
            Intrinsics3.checkNotNullParameter(draftState, "draftState");
            return new Model(draftState, guild, channel);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Model)) {
                return false;
            }
            Model model = (Model) other;
            return Intrinsics3.areEqual(this.draftState, model.draftState) && Intrinsics3.areEqual(this.guild, model.guild) && Intrinsics3.areEqual(this.channel, model.channel);
        }

        public final Channel getChannel() {
            return this.channel;
        }

        public final StoreThreadDraft.ThreadDraftState getDraftState() {
            return this.draftState;
        }

        public final Guild getGuild() {
            return this.guild;
        }

        public int hashCode() {
            StoreThreadDraft.ThreadDraftState threadDraftState = this.draftState;
            int iHashCode = (threadDraftState != null ? threadDraftState.hashCode() : 0) * 31;
            Guild guild = this.guild;
            int iHashCode2 = (iHashCode + (guild != null ? guild.hashCode() : 0)) * 31;
            Channel channel = this.channel;
            return iHashCode2 + (channel != null ? channel.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = outline.U("Model(draftState=");
            sbU.append(this.draftState);
            sbU.append(", guild=");
            sbU.append(this.guild);
            sbU.append(", channel=");
            sbU.append(this.channel);
            sbU.append(")");
            return sbU.toString();
        }
    }

    /* compiled from: WidgetThreadDraftArchiveSheet.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/widgets/channels/threads/WidgetThreadDraftArchiveSheet$Model;", "p1", "", "invoke", "(Lcom/discord/widgets/channels/threads/WidgetThreadDraftArchiveSheet$Model;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.channels.threads.WidgetThreadDraftArchiveSheet$bindSubscriptions$1, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<Model, Unit> {
        public AnonymousClass1(WidgetThreadDraftArchiveSheet widgetThreadDraftArchiveSheet) {
            super(1, widgetThreadDraftArchiveSheet, WidgetThreadDraftArchiveSheet.class, "configureUI", "configureUI(Lcom/discord/widgets/channels/threads/WidgetThreadDraftArchiveSheet$Model;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Model model) {
            invoke2(model);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Model model) {
            Intrinsics3.checkNotNullParameter(model, "p1");
            WidgetThreadDraftArchiveSheet.access$configureUI((WidgetThreadDraftArchiveSheet) this.receiver, model);
        }
    }

    /* compiled from: WidgetThreadDraftArchiveSheet.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.channels.threads.WidgetThreadDraftArchiveSheet$configureUI$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnClickListener {
        public final /* synthetic */ StoreThreadDraft.ThreadDraftState $draftState;

        public AnonymousClass1(StoreThreadDraft.ThreadDraftState threadDraftState) {
            this.$draftState = threadDraftState;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetThreadDraftArchiveSheet.access$setAutoArchiveDuration(WidgetThreadDraftArchiveSheet.this, this.$draftState, 60);
        }
    }

    /* compiled from: WidgetThreadDraftArchiveSheet.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.channels.threads.WidgetThreadDraftArchiveSheet$configureUI$2, reason: invalid class name */
    public static final class AnonymousClass2 implements View.OnClickListener {
        public final /* synthetic */ StoreThreadDraft.ThreadDraftState $draftState;

        public AnonymousClass2(StoreThreadDraft.ThreadDraftState threadDraftState) {
            this.$draftState = threadDraftState;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetThreadDraftArchiveSheet.access$setAutoArchiveDuration(WidgetThreadDraftArchiveSheet.this, this.$draftState, 1440);
        }
    }

    /* compiled from: WidgetThreadDraftArchiveSheet.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.channels.threads.WidgetThreadDraftArchiveSheet$configureUI$3, reason: invalid class name */
    public static final class AnonymousClass3 implements View.OnClickListener {
        public final /* synthetic */ StoreThreadDraft.ThreadDraftState $draftState;

        public AnonymousClass3(StoreThreadDraft.ThreadDraftState threadDraftState) {
            this.$draftState = threadDraftState;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetThreadDraftArchiveSheet.access$setAutoArchiveDuration(WidgetThreadDraftArchiveSheet.this, this.$draftState, ThreadUtils.ThreadArchiveDurations.THREE_DAYS_IN_MINUTES);
        }
    }

    /* compiled from: WidgetThreadDraftArchiveSheet.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.channels.threads.WidgetThreadDraftArchiveSheet$configureUI$4, reason: invalid class name */
    public static final class AnonymousClass4 implements View.OnClickListener {
        public final /* synthetic */ StoreThreadDraft.ThreadDraftState $draftState;

        public AnonymousClass4(StoreThreadDraft.ThreadDraftState threadDraftState) {
            this.$draftState = threadDraftState;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetThreadDraftArchiveSheet.access$setAutoArchiveDuration(WidgetThreadDraftArchiveSheet.this, this.$draftState, ThreadUtils.ThreadArchiveDurations.SEVEN_DAYS_IN_MINUTES);
        }
    }

    public WidgetThreadDraftArchiveSheet() {
        super(false, 1, null);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetThreadDraftArchiveSheet3.INSTANCE, null, 2, null);
    }

    public static final /* synthetic */ void access$configureUI(WidgetThreadDraftArchiveSheet widgetThreadDraftArchiveSheet, Model model) {
        widgetThreadDraftArchiveSheet.configureUI(model);
    }

    public static final /* synthetic */ void access$setAutoArchiveDuration(WidgetThreadDraftArchiveSheet widgetThreadDraftArchiveSheet, StoreThreadDraft.ThreadDraftState threadDraftState, int i) {
        widgetThreadDraftArchiveSheet.setAutoArchiveDuration(threadDraftState, i);
    }

    private final void configureUI(Model model) {
        StoreThreadDraft.ThreadDraftState draftState = model.getDraftState();
        model.getGuild();
        model.getChannel();
        Integer autoArchiveDuration = draftState.getAutoArchiveDuration();
        int iIntValue = autoArchiveDuration != null ? autoArchiveDuration.intValue() : 1440;
        new Traits.Location(Traits.Location.Page.GUILD_CHANNEL, Traits.Location.Section.THREAD_ARCHIVAL_DURATION_SHEET, Traits.Location.Obj.LIST_ITEM, null, null, 24, null);
        getBinding().d.setOnClickListener(new AnonymousClass1(draftState));
        MaterialRadioButton materialRadioButton = getBinding().e;
        Intrinsics3.checkNotNullExpressionValue(materialRadioButton, "binding.optionOneHourRadio");
        materialRadioButton.setChecked(iIntValue == 60);
        getBinding().j.setOnClickListener(new AnonymousClass2(draftState));
        MaterialRadioButton materialRadioButton2 = getBinding().k;
        Intrinsics3.checkNotNullExpressionValue(materialRadioButton2, "binding.optionTwentyFourHoursRadio");
        materialRadioButton2.setChecked(iIntValue == 1440);
        getBinding().h.setOnClickListener(new AnonymousClass3(draftState));
        MaterialRadioButton materialRadioButton3 = getBinding().i;
        Intrinsics3.checkNotNullExpressionValue(materialRadioButton3, "binding.optionThreeDaysRadio");
        materialRadioButton3.setChecked(iIntValue == 4320);
        getBinding().f.setOnClickListener(new AnonymousClass4(draftState));
        MaterialRadioButton materialRadioButton4 = getBinding().g;
        Intrinsics3.checkNotNullExpressionValue(materialRadioButton4, "binding.optionSevenDaysRadio");
        materialRadioButton4.setChecked(iIntValue == 10080);
    }

    private final WidgetThreadArchiveActionsSheetBinding getBinding() {
        return (WidgetThreadArchiveActionsSheetBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final void setAutoArchiveDuration(StoreThreadDraft.ThreadDraftState draftState, int minutes) {
        StoreStream.INSTANCE.getThreadDraft().setDraftState(StoreThreadDraft.ThreadDraftState.copy$default(draftState, false, Integer.valueOf(minutes), null, false, false, 29, null));
        dismiss();
    }

    public static final void show(FragmentManager fragmentManager, long j) {
        INSTANCE.show(fragmentManager, j);
    }

    @Override // com.discord.app.AppBottomSheet
    public void bindSubscriptions(CompositeSubscription compositeSubscription) {
        Intrinsics3.checkNotNullParameter(compositeSubscription, "compositeSubscription");
        super.bindSubscriptions(compositeSubscription);
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(Model.INSTANCE.get(getArgumentsOrDefault().getLong("INTENT_EXTRA_GUILD_ID", -1L)), this, null, 2, null), WidgetThreadDraftArchiveSheet.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(this), 62, (Object) null);
    }

    @Override // com.discord.app.AppBottomSheet
    public int getContentViewResId() {
        return R.layout.widget_thread_archive_actions_sheet;
    }

    @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        dismiss();
    }
}

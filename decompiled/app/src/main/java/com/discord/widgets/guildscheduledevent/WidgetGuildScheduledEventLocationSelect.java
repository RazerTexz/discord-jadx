package com.discord.widgets.guildscheduledevent;

import android.content.Context;
import android.content.Intent;
import android.text.Editable;
import android.view.View;
import android.widget.TextView;
import androidx.activity.result.ActivityResultLauncher;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import b.a.d.AppScreen2;
import b.a.d.AppViewModelDelegates2;
import b.a.d.AppViewModelDelegates3;
import b.a.d.AppViewModelDelegates5;
import b.a.k.FormatUtils;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.api.channel.Channel;
import com.discord.api.guildscheduledevent.GuildScheduledEventEntityType;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetGuildScheduledEventLocationSelectBinding;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.views.CheckedSetting;
import com.discord.widgets.channels.WidgetChannelSelector;
import com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventLocationSelectViewModel;
import com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventSettings;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import d0.LazyJVM;
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

/* compiled from: WidgetGuildScheduledEventLocationSelect.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 F2\u00020\u0001:\u0001FB\u0007¢\u0006\u0004\bE\u0010\u001eJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\t\u0010\nJ1\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J+\u0010\u0018\u001a\u0004\u0018\u00010\u000f2\u0010\u0010\u0016\u001a\f\u0012\b\u0012\u00060\u0014j\u0002`\u00150\u00132\u0006\u0010\u0017\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0018\u0010\u0019J!\u0010\u001b\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u001a\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\bH\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001d\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010!\u001a\u00020\u00042\u0006\u0010 \u001a\u00020\u001fH\u0016¢\u0006\u0004\b!\u0010\"J\u000f\u0010#\u001a\u00020\u0004H\u0016¢\u0006\u0004\b#\u0010\u001eR$\u0010'\u001a\u0010\u0012\f\u0012\n &*\u0004\u0018\u00010%0%0$8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b'\u0010(R\u001d\u0010.\u001a\u00020)8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-R#\u00105\u001a\u00020/8B@\u0002X\u0082\u0084\u0002¢\u0006\u0012\n\u0004\b0\u00101\u0012\u0004\b4\u0010\u001e\u001a\u0004\b2\u00103R\u001f\u00109\u001a\u0004\u0018\u00010\u00148B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b6\u00101\u001a\u0004\b7\u00108R\u001d\u0010>\u001a\u00020:8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b;\u00101\u001a\u0004\b<\u0010=R\u0018\u0010?\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b?\u0010@R\u001d\u0010D\u001a\u00020\u00148B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\bA\u00101\u001a\u0004\bB\u0010C¨\u0006G"}, d2 = {"Lcom/discord/widgets/guildscheduledevent/WidgetGuildScheduledEventLocationSelect;", "Lcom/discord/app/AppFragment;", "Lcom/discord/widgets/guildscheduledevent/WidgetGuildScheduledEventLocationSelectViewModel$ViewState;", "viewState", "", "configureUI", "(Lcom/discord/widgets/guildscheduledevent/WidgetGuildScheduledEventLocationSelectViewModel$ViewState;)V", "Lcom/discord/widgets/guildscheduledevent/WidgetGuildScheduledEventLocationSelectViewModel$ViewState$Valid;", "", "isNextEnabled", "(Lcom/discord/widgets/guildscheduledevent/WidgetGuildScheduledEventLocationSelectViewModel$ViewState$Valid;)Z", "Lcom/discord/views/CheckedSetting;", "setting", "Lcom/discord/api/guildscheduledevent/GuildScheduledEventEntityType;", "settingValue", "", "disabledMessage", "configureLocationOption", "(Lcom/discord/widgets/guildscheduledevent/WidgetGuildScheduledEventLocationSelectViewModel$ViewState$Valid;Lcom/discord/views/CheckedSetting;Lcom/discord/api/guildscheduledevent/GuildScheduledEventEntityType;Ljava/lang/CharSequence;)V", "", "", "Lcom/discord/primitives/ChannelId;", "channelIds", "canChangeEntityType", "getDisabledMessageForChannelOption", "(Ljava/util/Set;Z)Ljava/lang/CharSequence;", "canCreateExternalEvent", "getDisabledMessageForExternalOption", "(ZZ)Ljava/lang/CharSequence;", "navigateNext", "()V", "Landroid/view/View;", "view", "onViewBound", "(Landroid/view/View;)V", "onResume", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "kotlin.jvm.PlatformType", "nextStepLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "Lcom/discord/databinding/WidgetGuildScheduledEventLocationSelectBinding;", "binding$delegate", "Lcom/discord/utilities/viewbinding/FragmentViewBindingDelegate;", "getBinding", "()Lcom/discord/databinding/WidgetGuildScheduledEventLocationSelectBinding;", "binding", "Lcom/discord/widgets/guildscheduledevent/GuildScheduledEventDirectoryAssociationViewModel;", "hubViewModel$delegate", "Lkotlin/Lazy;", "getHubViewModel", "()Lcom/discord/widgets/guildscheduledevent/GuildScheduledEventDirectoryAssociationViewModel;", "getHubViewModel$annotations", "hubViewModel", "existingGuildScheduledEventId$delegate", "getExistingGuildScheduledEventId", "()Ljava/lang/Long;", "existingGuildScheduledEventId", "Lcom/discord/widgets/guildscheduledevent/WidgetGuildScheduledEventLocationSelectViewModel;", "viewModel$delegate", "getViewModel", "()Lcom/discord/widgets/guildscheduledevent/WidgetGuildScheduledEventLocationSelectViewModel;", "viewModel", "currentViewState", "Lcom/discord/widgets/guildscheduledevent/WidgetGuildScheduledEventLocationSelectViewModel$ViewState$Valid;", "guildId$delegate", "getGuildId", "()J", "guildId", "<init>", "Companion", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetGuildScheduledEventLocationSelect extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetGuildScheduledEventLocationSelect.class, "binding", "getBinding()Lcom/discord/databinding/WidgetGuildScheduledEventLocationSelectBinding;", 0)};

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String GUILD_SCHEDULED_EVENT_LOCATION_SELECT_REQUEST_KEY = "GUILD_SCHEDULED_EVENT_LOCATION_SELECT_REQUEST_KEY";

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private WidgetGuildScheduledEventLocationSelectViewModel.ViewState.Valid currentViewState;

    /* renamed from: existingGuildScheduledEventId$delegate, reason: from kotlin metadata */
    private final Lazy existingGuildScheduledEventId;

    /* renamed from: guildId$delegate, reason: from kotlin metadata */
    private final Lazy guildId;

    /* renamed from: hubViewModel$delegate, reason: from kotlin metadata */
    private final Lazy hubViewModel;
    private final ActivityResultLauncher<Intent> nextStepLauncher;

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* compiled from: WidgetGuildScheduledEventLocationSelect.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0013\u0010\u0014J3\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\n\u0010\u0006\u001a\u00060\u0004j\u0002`\u00052\u0010\b\u0002\u0010\b\u001a\n\u0018\u00010\u0004j\u0004\u0018\u0001`\u0007¢\u0006\u0004\b\n\u0010\u000bJ-\u0010\u000e\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\n\u0010\u0006\u001a\u00060\u0004j\u0002`\u00052\n\u0010\r\u001a\u00060\u0004j\u0002`\f¢\u0006\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0011\u001a\u00020\u00108\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012¨\u0006\u0015"}, d2 = {"Lcom/discord/widgets/guildscheduledevent/WidgetGuildScheduledEventLocationSelect$Companion;", "", "Landroid/content/Context;", "context", "", "Lcom/discord/primitives/GuildId;", "guildId", "Lcom/discord/primitives/ChannelId;", "channelId", "", "launch", "(Landroid/content/Context;JLjava/lang/Long;)V", "Lcom/discord/primitives/GuildScheduledEventId;", "guildScheduledEventId", "launchForEdit", "(Landroid/content/Context;JJ)V", "", WidgetGuildScheduledEventLocationSelect.GUILD_SCHEDULED_EVENT_LOCATION_SELECT_REQUEST_KEY, "Ljava/lang/String;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public static /* synthetic */ void launch$default(Companion companion, Context context, long j, Long l, int i, Object obj) {
            if ((i & 4) != 0) {
                l = null;
            }
            companion.launch(context, j, l);
        }

        public final void launch(Context context, long guildId, Long channelId) {
            Intrinsics3.checkNotNullParameter(context, "context");
            Intent intent = new Intent();
            intent.putExtra("com.discord.intent.extra.EXTRA_GUILD_ID", guildId);
            if (channelId != null) {
                intent.putExtra("com.discord.intent.extra.EXTRA_CHANNEL_ID", channelId.longValue());
            }
            AppScreen2.d(context, WidgetGuildScheduledEventLocationSelect.class, intent);
        }

        public final void launchForEdit(Context context, long guildId, long guildScheduledEventId) {
            Intrinsics3.checkNotNullParameter(context, "context");
            Intent intent = new Intent();
            intent.putExtra("com.discord.intent.extra.EXTRA_GUILD_ID", guildId);
            intent.putExtra("com.discord.intent.extra.EXTRA_GUILD_SCHEDULED_EVENT_ID", guildScheduledEventId);
            AppScreen2.d(context, WidgetGuildScheduledEventLocationSelect.class, intent);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;
        public static final /* synthetic */ int[] $EnumSwitchMapping$2;

        static {
            GuildScheduledEventEntityType.values();
            int[] iArr = new int[5];
            $EnumSwitchMapping$0 = iArr;
            GuildScheduledEventEntityType guildScheduledEventEntityType = GuildScheduledEventEntityType.VOICE;
            iArr[guildScheduledEventEntityType.ordinal()] = 1;
            GuildScheduledEventEntityType guildScheduledEventEntityType2 = GuildScheduledEventEntityType.STAGE_INSTANCE;
            iArr[guildScheduledEventEntityType2.ordinal()] = 2;
            GuildScheduledEventEntityType.values();
            int[] iArr2 = new int[5];
            $EnumSwitchMapping$1 = iArr2;
            iArr2[guildScheduledEventEntityType2.ordinal()] = 1;
            iArr2[guildScheduledEventEntityType.ordinal()] = 2;
            GuildScheduledEventEntityType guildScheduledEventEntityType3 = GuildScheduledEventEntityType.EXTERNAL;
            iArr2[guildScheduledEventEntityType3.ordinal()] = 3;
            GuildScheduledEventEntityType.values();
            int[] iArr3 = new int[5];
            $EnumSwitchMapping$2 = iArr3;
            iArr3[guildScheduledEventEntityType2.ordinal()] = 1;
            iArr3[guildScheduledEventEntityType.ordinal()] = 2;
            iArr3[guildScheduledEventEntityType3.ordinal()] = 3;
        }
    }

    /* compiled from: WidgetGuildScheduledEventLocationSelect.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventLocationSelect$configureLocationOption$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnClickListener {
        public final /* synthetic */ GuildScheduledEventEntityType $settingValue;

        public AnonymousClass1(GuildScheduledEventEntityType guildScheduledEventEntityType) {
            this.$settingValue = guildScheduledEventEntityType;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetGuildScheduledEventLocationSelect.access$getViewModel$p(WidgetGuildScheduledEventLocationSelect.this).selectLocationOption(this.$settingValue);
        }
    }

    /* compiled from: WidgetGuildScheduledEventLocationSelect.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/widgets/guildscheduledevent/WidgetGuildScheduledEventLocationSelectViewModel$ViewState;", "p1", "", "invoke", "(Lcom/discord/widgets/guildscheduledevent/WidgetGuildScheduledEventLocationSelectViewModel$ViewState;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventLocationSelect$onResume$1, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<WidgetGuildScheduledEventLocationSelectViewModel.ViewState, Unit> {
        public AnonymousClass1(WidgetGuildScheduledEventLocationSelect widgetGuildScheduledEventLocationSelect) {
            super(1, widgetGuildScheduledEventLocationSelect, WidgetGuildScheduledEventLocationSelect.class, "configureUI", "configureUI(Lcom/discord/widgets/guildscheduledevent/WidgetGuildScheduledEventLocationSelectViewModel$ViewState;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WidgetGuildScheduledEventLocationSelectViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WidgetGuildScheduledEventLocationSelectViewModel.ViewState viewState) {
            Intrinsics3.checkNotNullParameter(viewState, "p1");
            WidgetGuildScheduledEventLocationSelect.access$configureUI((WidgetGuildScheduledEventLocationSelect) this.receiver, viewState);
        }
    }

    /* compiled from: WidgetGuildScheduledEventLocationSelect.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventLocationSelect$onViewBound$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnClickListener {
        public AnonymousClass1() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            FragmentActivity activity = WidgetGuildScheduledEventLocationSelect.this.getActivity();
            if (activity != null) {
                activity.finish();
            }
        }
    }

    /* compiled from: WidgetGuildScheduledEventLocationSelect.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventLocationSelect$onViewBound$3, reason: invalid class name */
    public static final class AnonymousClass3 implements View.OnClickListener {
        public AnonymousClass3() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetGuildScheduledEventLocationSelectViewModel.ViewState.Valid validAccess$getCurrentViewState$p = WidgetGuildScheduledEventLocationSelect.access$getCurrentViewState$p(WidgetGuildScheduledEventLocationSelect.this);
            if (validAccess$getCurrentViewState$p != null) {
                int iOrdinal = validAccess$getCurrentViewState$p.getSelectedLocationOption().ordinal();
                if (iOrdinal == 1) {
                    WidgetChannelSelector.Companion companion = WidgetChannelSelector.INSTANCE;
                    WidgetGuildScheduledEventLocationSelect widgetGuildScheduledEventLocationSelect = WidgetGuildScheduledEventLocationSelect.this;
                    WidgetChannelSelector.Companion.launch$default(companion, widgetGuildScheduledEventLocationSelect, WidgetGuildScheduledEventLocationSelect.access$getGuildId$p(widgetGuildScheduledEventLocationSelect), WidgetGuildScheduledEventLocationSelect.GUILD_SCHEDULED_EVENT_LOCATION_SELECT_REQUEST_KEY, false, 0, new WidgetChannelSelector.SetFilterFunction(validAccess$getCurrentViewState$p.getAvailableStageChannelIds()), 24, null);
                } else {
                    if (iOrdinal != 2) {
                        return;
                    }
                    WidgetChannelSelector.Companion companion2 = WidgetChannelSelector.INSTANCE;
                    WidgetGuildScheduledEventLocationSelect widgetGuildScheduledEventLocationSelect2 = WidgetGuildScheduledEventLocationSelect.this;
                    WidgetChannelSelector.Companion.launch$default(companion2, widgetGuildScheduledEventLocationSelect2, WidgetGuildScheduledEventLocationSelect.access$getGuildId$p(widgetGuildScheduledEventLocationSelect2), WidgetGuildScheduledEventLocationSelect.GUILD_SCHEDULED_EVENT_LOCATION_SELECT_REQUEST_KEY, false, 0, new WidgetChannelSelector.SetFilterFunction(validAccess$getCurrentViewState$p.getAvailableVoiceChannelIds()), 24, null);
                }
            }
        }
    }

    /* compiled from: WidgetGuildScheduledEventLocationSelect.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\b\u001a\u00020\u00052\n\u0010\u0002\u001a\u00060\u0000j\u0002`\u00012\u0006\u0010\u0004\u001a\u00020\u0003H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"", "Lcom/discord/primitives/ChannelId;", "channelId", "", "<anonymous parameter 1>", "", "invoke", "(JLjava/lang/String;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventLocationSelect$onViewBound$4, reason: invalid class name */
    public static final class AnonymousClass4 extends Lambda implements Function2<Long, String, Unit> {
        public AnonymousClass4() {
            super(2);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Long l, String str) {
            invoke(l.longValue(), str);
            return Unit.a;
        }

        public final void invoke(long j, String str) {
            Intrinsics3.checkNotNullParameter(str, "<anonymous parameter 1>");
            WidgetGuildScheduledEventLocationSelect.access$getViewModel$p(WidgetGuildScheduledEventLocationSelect.this).selectChannel(j);
        }
    }

    /* compiled from: WidgetGuildScheduledEventLocationSelect.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/widget/TextView;", "it", "", "invoke", "(Landroid/widget/TextView;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventLocationSelect$onViewBound$5, reason: invalid class name */
    public static final class AnonymousClass5 extends Lambda implements Function1<TextView, Unit> {
        public AnonymousClass5() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(TextView textView) {
            invoke2(textView);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(TextView textView) {
            Intrinsics3.checkNotNullParameter(textView, "it");
            WidgetGuildScheduledEventLocationSelect.access$navigateNext(WidgetGuildScheduledEventLocationSelect.this);
        }
    }

    /* compiled from: WidgetGuildScheduledEventLocationSelect.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventLocationSelect$onViewBound$6, reason: invalid class name */
    public static final class AnonymousClass6 implements View.OnClickListener {
        public AnonymousClass6() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetGuildScheduledEventLocationSelect.access$navigateNext(WidgetGuildScheduledEventLocationSelect.this);
        }
    }

    public WidgetGuildScheduledEventLocationSelect() {
        super(R.layout.widget_guild_scheduled_event_location_select);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetGuildScheduledEventLocationSelect2.INSTANCE, null, 2, null);
        this.guildId = LazyJVM.lazy(new WidgetGuildScheduledEventLocationSelect4(this));
        this.existingGuildScheduledEventId = LazyJVM.lazy(new WidgetGuildScheduledEventLocationSelect3(this));
        this.hubViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection2.getOrCreateKotlinClass(GuildScheduledEventDirectoryAssociationViewModel.class), new WidgetGuildScheduledEventLocationSelect$appActivityViewModels$$inlined$activityViewModels$1(this), new AppViewModelDelegates2(new WidgetGuildScheduledEventLocationSelect5(this)));
        WidgetGuildScheduledEventLocationSelect8 widgetGuildScheduledEventLocationSelect8 = new WidgetGuildScheduledEventLocationSelect8(this);
        AppViewModelDelegates3 appViewModelDelegates3 = new AppViewModelDelegates3(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection2.getOrCreateKotlinClass(WidgetGuildScheduledEventLocationSelectViewModel.class), new WidgetGuildScheduledEventLocationSelect$appViewModels$$inlined$viewModels$1(appViewModelDelegates3), new AppViewModelDelegates5(widgetGuildScheduledEventLocationSelect8));
        this.nextStepLauncher = WidgetGuildScheduledEventSettings.INSTANCE.registerForResult(this, new WidgetGuildScheduledEventLocationSelect6(this), new WidgetGuildScheduledEventLocationSelect7(this));
    }

    public static final /* synthetic */ void access$configureUI(WidgetGuildScheduledEventLocationSelect widgetGuildScheduledEventLocationSelect, WidgetGuildScheduledEventLocationSelectViewModel.ViewState viewState) {
        widgetGuildScheduledEventLocationSelect.configureUI(viewState);
    }

    public static final /* synthetic */ WidgetGuildScheduledEventLocationSelectViewModel.ViewState.Valid access$getCurrentViewState$p(WidgetGuildScheduledEventLocationSelect widgetGuildScheduledEventLocationSelect) {
        return widgetGuildScheduledEventLocationSelect.currentViewState;
    }

    public static final /* synthetic */ Long access$getExistingGuildScheduledEventId$p(WidgetGuildScheduledEventLocationSelect widgetGuildScheduledEventLocationSelect) {
        return widgetGuildScheduledEventLocationSelect.getExistingGuildScheduledEventId();
    }

    public static final /* synthetic */ long access$getGuildId$p(WidgetGuildScheduledEventLocationSelect widgetGuildScheduledEventLocationSelect) {
        return widgetGuildScheduledEventLocationSelect.getGuildId();
    }

    public static final /* synthetic */ WidgetGuildScheduledEventLocationSelectViewModel access$getViewModel$p(WidgetGuildScheduledEventLocationSelect widgetGuildScheduledEventLocationSelect) {
        return widgetGuildScheduledEventLocationSelect.getViewModel();
    }

    public static final /* synthetic */ void access$navigateNext(WidgetGuildScheduledEventLocationSelect widgetGuildScheduledEventLocationSelect) {
        widgetGuildScheduledEventLocationSelect.navigateNext();
    }

    public static final /* synthetic */ void access$setCurrentViewState$p(WidgetGuildScheduledEventLocationSelect widgetGuildScheduledEventLocationSelect, WidgetGuildScheduledEventLocationSelectViewModel.ViewState.Valid valid) {
        widgetGuildScheduledEventLocationSelect.currentViewState = valid;
    }

    private final void configureLocationOption(WidgetGuildScheduledEventLocationSelectViewModel.ViewState.Valid viewState, CheckedSetting setting, GuildScheduledEventEntityType settingValue, CharSequence disabledMessage) {
        setting.setChecked(viewState.getSelectedLocationOption() == settingValue);
        if (disabledMessage != null) {
            setting.c(disabledMessage);
        } else {
            setting.e(new AnonymousClass1(settingValue));
        }
    }

    private final void configureUI(WidgetGuildScheduledEventLocationSelectViewModel.ViewState viewState) {
        if (viewState instanceof WidgetGuildScheduledEventLocationSelectViewModel.ViewState.Valid) {
            WidgetGuildScheduledEventLocationSelectViewModel.ViewState.Valid valid = (WidgetGuildScheduledEventLocationSelectViewModel.ViewState.Valid) viewState;
            this.currentViewState = valid;
            CheckedSetting checkedSetting = getBinding().j;
            Intrinsics3.checkNotNullExpressionValue(checkedSetting, "binding.stageChannelOption");
            configureLocationOption(valid, checkedSetting, GuildScheduledEventEntityType.STAGE_INSTANCE, getDisabledMessageForChannelOption(valid.getAvailableStageChannelIds(), valid.getCanChangeChannel()));
            CheckedSetting checkedSetting2 = getBinding().m;
            Intrinsics3.checkNotNullExpressionValue(checkedSetting2, "binding.voiceChannelOption");
            configureLocationOption(valid, checkedSetting2, GuildScheduledEventEntityType.VOICE, getDisabledMessageForChannelOption(valid.getAvailableVoiceChannelIds(), valid.getCanChangeChannel()));
            CheckedSetting checkedSetting3 = getBinding().g;
            Intrinsics3.checkNotNullExpressionValue(checkedSetting3, "binding.externalOption");
            configureLocationOption(valid, checkedSetting3, GuildScheduledEventEntityType.EXTERNAL, getDisabledMessageForExternalOption(valid.getCanCreateExternalEvent(), valid.getCanChangeChannel()));
            boolean z2 = (valid.getAvailableStageChannelIds().isEmpty() ^ true) || valid.getShowStageOptionIfUnavailable();
            CheckedSetting checkedSetting4 = getBinding().j;
            Intrinsics3.checkNotNullExpressionValue(checkedSetting4, "binding.stageChannelOption");
            checkedSetting4.setVisibility(z2 ? 0 : 8);
            View view = getBinding().l;
            Intrinsics3.checkNotNullExpressionValue(view, "binding.voiceChannelDivider");
            view.setVisibility(z2 ? 0 : 8);
            int iOrdinal = valid.getSelectedLocationOption().ordinal();
            if (iOrdinal == 1 || iOrdinal == 2) {
                TextView textView = getBinding().h;
                Intrinsics3.checkNotNullExpressionValue(textView, "binding.locationHeader");
                ViewExtensions.setTextAndVisibilityBy(textView, getString(R.string.guild_event_location_voice_field_label));
                TextInputLayout textInputLayout = getBinding().c;
                Intrinsics3.checkNotNullExpressionValue(textInputLayout, "binding.channelLocationLayout");
                textInputLayout.setVisibility(0);
                TextInputLayout textInputLayout2 = getBinding().f;
                Intrinsics3.checkNotNullExpressionValue(textInputLayout2, "binding.externalLocationLayout");
                textInputLayout2.setVisibility(8);
            } else if (iOrdinal != 3) {
                TextView textView2 = getBinding().h;
                Intrinsics3.checkNotNullExpressionValue(textView2, "binding.locationHeader");
                textView2.setVisibility(8);
                TextInputLayout textInputLayout3 = getBinding().c;
                Intrinsics3.checkNotNullExpressionValue(textInputLayout3, "binding.channelLocationLayout");
                textInputLayout3.setVisibility(8);
                TextInputLayout textInputLayout4 = getBinding().f;
                Intrinsics3.checkNotNullExpressionValue(textInputLayout4, "binding.externalLocationLayout");
                textInputLayout4.setVisibility(8);
            } else {
                TextView textView3 = getBinding().h;
                Intrinsics3.checkNotNullExpressionValue(textView3, "binding.locationHeader");
                ViewExtensions.setTextAndVisibilityBy(textView3, getString(R.string.guild_event_location_elsewhere_field_label));
                TextInputLayout textInputLayout5 = getBinding().c;
                Intrinsics3.checkNotNullExpressionValue(textInputLayout5, "binding.channelLocationLayout");
                textInputLayout5.setVisibility(8);
                TextInputLayout textInputLayout6 = getBinding().f;
                Intrinsics3.checkNotNullExpressionValue(textInputLayout6, "binding.externalLocationLayout");
                textInputLayout6.setVisibility(0);
            }
            TextInputEditText textInputEditText = getBinding().f2447b;
            ViewExtensions.setEnabledAndAlpha$default(textInputEditText, valid.getCanChangeChannel(), 0.0f, 2, null);
            Editable text = textInputEditText.getText();
            String string = text != null ? text.toString() : null;
            if (!Intrinsics3.areEqual(string, valid.getSelectedChannel() != null ? r3.getName() : null)) {
                Channel selectedChannel = valid.getSelectedChannel();
                textInputEditText.setText(selectedChannel != null ? selectedChannel.getName() : null);
            }
            TextInputEditText textInputEditText2 = getBinding().e;
            if (!Intrinsics3.areEqual(textInputEditText2.getText() != null ? r1.toString() : null, valid.getExternalLocation())) {
                textInputEditText2.setText(valid.getExternalLocation());
            }
            MaterialButton materialButton = getBinding().i;
            Intrinsics3.checkNotNullExpressionValue(materialButton, "binding.nextButton");
            materialButton.setEnabled(isNextEnabled(valid));
        }
    }

    private final WidgetGuildScheduledEventLocationSelectBinding getBinding() {
        return (WidgetGuildScheduledEventLocationSelectBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final CharSequence getDisabledMessageForChannelOption(Set<Long> channelIds, boolean canChangeEntityType) {
        if (!canChangeEntityType) {
            return getString(R.string.guild_event_location_disabled_cannot_edit);
        }
        if (channelIds.isEmpty()) {
            return getString(R.string.guild_event_location_disabled_no_available_channel);
        }
        return null;
    }

    private final CharSequence getDisabledMessageForExternalOption(boolean canCreateExternalEvent, boolean canChangeEntityType) {
        if (!canChangeEntityType) {
            return getString(R.string.guild_event_location_disabled_cannot_edit);
        }
        if (canCreateExternalEvent) {
            return null;
        }
        return getString(R.string.guild_event_location_disabled_external_no_permission);
    }

    private final Long getExistingGuildScheduledEventId() {
        return (Long) this.existingGuildScheduledEventId.getValue();
    }

    private final long getGuildId() {
        return ((Number) this.guildId.getValue()).longValue();
    }

    private final GuildScheduledEventDirectoryAssociationViewModel getHubViewModel() {
        return (GuildScheduledEventDirectoryAssociationViewModel) this.hubViewModel.getValue();
    }

    private static /* synthetic */ void getHubViewModel$annotations() {
    }

    private final WidgetGuildScheduledEventLocationSelectViewModel getViewModel() {
        return (WidgetGuildScheduledEventLocationSelectViewModel) this.viewModel.getValue();
    }

    private final boolean isNextEnabled(WidgetGuildScheduledEventLocationSelectViewModel.ViewState.Valid viewState) {
        int iOrdinal = viewState.getSelectedLocationOption().ordinal();
        if (iOrdinal == 1 || iOrdinal == 2) {
            if (viewState.getSelectedChannel() == null) {
                return false;
            }
        } else if (iOrdinal != 3 || viewState.getExternalLocation().length() <= 0) {
            return false;
        }
        return true;
    }

    private final void navigateNext() {
        WidgetGuildScheduledEventLocationSelectViewModel.ViewState.Valid valid = this.currentViewState;
        if (valid != null) {
            WidgetGuildScheduledEventSettings.Companion companion = WidgetGuildScheduledEventSettings.INSTANCE;
            Context contextRequireContext = requireContext();
            ActivityResultLauncher<Intent> activityResultLauncher = this.nextStepLauncher;
            long guildId = getGuildId();
            GuildScheduledEventEntityType selectedLocationOption = valid.getSelectedLocationOption();
            Channel selectedChannel = valid.getSelectedChannel();
            companion.launch(contextRequireContext, activityResultLauncher, guildId, selectedLocationOption, selectedChannel != null ? Long.valueOf(selectedChannel.getId()) : null, valid.getExternalLocation(), getExistingGuildScheduledEventId());
        }
    }

    @Override // com.discord.app.AppFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null), WidgetGuildScheduledEventLocationSelect.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(this), 62, (Object) null);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        TextView textView = getBinding().k;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.stepText");
        FormatUtils.n(textView, R.string.guild_event_step_label, new Object[]{1, 3}, null, 4);
        getBinding().d.setOnClickListener(new AnonymousClass1());
        TextInputEditText textInputEditText = getBinding().e;
        Intrinsics3.checkNotNullExpressionValue(textInputEditText, "binding.externalLocationInput");
        textInputEditText.addTextChangedListener(new WidgetGuildScheduledEventLocationSelect$onViewBound$$inlined$addTextChangedListener$1(this));
        getBinding().f2447b.setOnClickListener(new AnonymousClass3());
        WidgetChannelSelector.INSTANCE.registerForResult(this, GUILD_SCHEDULED_EVENT_LOCATION_SELECT_REQUEST_KEY, false, new AnonymousClass4());
        TextInputLayout textInputLayout = getBinding().f;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout, "binding.externalLocationLayout");
        ViewExtensions.setOnImeActionDone$default(textInputLayout, false, new AnonymousClass5(), 1, null);
        getBinding().i.setOnClickListener(new AnonymousClass6());
    }
}

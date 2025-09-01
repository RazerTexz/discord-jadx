package com.discord.widgets.guildscheduledevent;

import a0.a.a.b;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import b.a.d.AppScreen2;
import b.a.d.AppViewModelDelegates3;
import b.a.d.AppViewModelDelegates5;
import b.a.k.FormatUtils;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.api.channel.Channel;
import com.discord.app.AppFragment;
import com.discord.app.AppTransitionActivity;
import com.discord.databinding.WidgetPreviewGuildScheduledEventBinding;
import com.discord.i18n.Hook;
import com.discord.i18n.RenderContext;
import com.discord.models.guild.UserGuildMember;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUser;
import com.discord.utilities.dimen.DimenUtils;
import com.discord.utilities.guildscheduledevent.GuildScheduledEventUtilities5;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.views.CheckedSetting;
import com.discord.widgets.guildscheduledevent.GuildScheduledEventLocationInfo;
import com.discord.widgets.guildscheduledevent.PreviewGuildScheduledEventViewModel;
import com.google.android.material.button.MaterialButton;
import d0.LazyJVM;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import d0.z.d.Reflection2;
import java.io.Serializable;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;

/* compiled from: WidgetPreviewGuildScheduledEvent.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 #2\u00020\u0001:\u0001#B\u0007¢\u0006\u0004\b\"\u0010\fJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\n\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\n\u0010\tJ\u000f\u0010\u000b\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000f\u0010\u0010R\u001d\u0010\u0016\u001a\u00020\u00118B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001d\u0010\u001c\u001a\u00020\u00178B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u001d\u0010!\u001a\u00020\u001d8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001e\u0010\u0019\u001a\u0004\b\u001f\u0010 ¨\u0006$"}, d2 = {"Lcom/discord/widgets/guildscheduledevent/WidgetPreviewGuildScheduledEvent;", "Lcom/discord/app/AppFragment;", "Lcom/discord/widgets/guildscheduledevent/PreviewGuildScheduledEventViewModel$ViewState;", "viewState", "", "configureUi", "(Lcom/discord/widgets/guildscheduledevent/PreviewGuildScheduledEventViewModel$ViewState;)V", "Lcom/discord/widgets/guildscheduledevent/PreviewGuildScheduledEventViewModel$ViewState$Initialized;", "configureTextForCreation", "(Lcom/discord/widgets/guildscheduledevent/PreviewGuildScheduledEventViewModel$ViewState$Initialized;)V", "configureTextForStart", "onResume", "()V", "Landroid/view/View;", "view", "onViewBound", "(Landroid/view/View;)V", "Lcom/discord/databinding/WidgetPreviewGuildScheduledEventBinding;", "binding$delegate", "Lcom/discord/utilities/viewbinding/FragmentViewBindingDelegate;", "getBinding", "()Lcom/discord/databinding/WidgetPreviewGuildScheduledEventBinding;", "binding", "Lcom/discord/widgets/guildscheduledevent/GuildScheduledEventModel;", "eventModel$delegate", "Lkotlin/Lazy;", "getEventModel", "()Lcom/discord/widgets/guildscheduledevent/GuildScheduledEventModel;", "eventModel", "Lcom/discord/widgets/guildscheduledevent/PreviewGuildScheduledEventViewModel;", "viewModel$delegate", "getViewModel", "()Lcom/discord/widgets/guildscheduledevent/PreviewGuildScheduledEventViewModel;", "viewModel", "<init>", "Companion", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetPreviewGuildScheduledEvent extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetPreviewGuildScheduledEvent.class, "binding", "getBinding()Lcom/discord/databinding/WidgetPreviewGuildScheduledEventBinding;", 0)};

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final String EXTRA_EVENT_CREATED = "INTENT_EXTRA_EVENT_CREATED";
    private static final String EXTRA_EVENT_MODEL = "INTENT_EXTRA_EVENT_MODEL";
    private static final String EXTRA_EXISTING_EVENT_DATA = "INTENT_EXTRA_EXISTING_EVENT_DATA";
    private static final int RESULT_QUIT = 2;

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* renamed from: eventModel$delegate, reason: from kotlin metadata */
    private final Lazy eventModel;

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* compiled from: WidgetPreviewGuildScheduledEvent.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001:\u0002)*B\t\b\u0002¢\u0006\u0004\b'\u0010(JE\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b2\b\b\u0002\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\u000e\u0010\u000fJ1\u0010\u0015\u001a\u0010\u0012\f\u0012\n \u0014*\u0004\u0018\u00010\t0\t0\b2\u0006\u0010\u0011\u001a\u00020\u00102\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\r0\u0012¢\u0006\u0004\b\u0015\u0010\u0016JY\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\u0011\u001a\u00020\u00102*\u0010\u001b\u001a&\u0012\f\u0012\n\u0018\u00010\u0018j\u0004\u0018\u0001`\u0019\u0012\b\u0012\u00060\u0018j\u0002`\u001a\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\r0\u00172\u0010\b\u0002\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u0012¢\u0006\u0004\b\u001d\u0010\u001eR\u0016\u0010 \u001a\u00020\u001f8\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010\"\u001a\u00020\u001f8\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\"\u0010!R\u0016\u0010#\u001a\u00020\u001f8\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b#\u0010!R\u0016\u0010%\u001a\u00020$8\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b%\u0010&¨\u0006+"}, d2 = {"Lcom/discord/widgets/guildscheduledevent/WidgetPreviewGuildScheduledEvent$Companion;", "", "Landroid/content/Context;", "context", "Lcom/discord/widgets/guildscheduledevent/GuildScheduledEventModel;", "eventModel", "Lcom/discord/widgets/guildscheduledevent/WidgetPreviewGuildScheduledEvent$Companion$ExistingEventData;", "existingEventData", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "launcher", "", "fromSettings", "", "launch", "(Landroid/content/Context;Lcom/discord/widgets/guildscheduledevent/GuildScheduledEventModel;Lcom/discord/widgets/guildscheduledevent/WidgetPreviewGuildScheduledEvent$Companion$ExistingEventData;Landroidx/activity/result/ActivityResultLauncher;Z)V", "Landroidx/fragment/app/Fragment;", "fragment", "Lkotlin/Function0;", "onEventStarted", "kotlin.jvm.PlatformType", "createJoinOnStartActivityRegistration", "(Landroidx/fragment/app/Fragment;Lkotlin/jvm/functions/Function0;)Landroidx/activity/result/ActivityResultLauncher;", "Lkotlin/Function3;", "", "Lcom/discord/primitives/ChannelId;", "Lcom/discord/primitives/GuildScheduledEventId;", "onEventCreated", "onQuit", "registerForResult", "(Landroidx/fragment/app/Fragment;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function0;)Landroidx/activity/result/ActivityResultLauncher;", "", "EXTRA_EVENT_CREATED", "Ljava/lang/String;", "EXTRA_EVENT_MODEL", "EXTRA_EXISTING_EVENT_DATA", "", "RESULT_QUIT", "I", "<init>", "()V", "Action", "ExistingEventData", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {

        /* compiled from: WidgetPreviewGuildScheduledEvent.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/discord/widgets/guildscheduledevent/WidgetPreviewGuildScheduledEvent$Companion$Action;", "", "<init>", "(Ljava/lang/String;I)V", "EDIT_EVENT", "START_EVENT", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public enum Action {
            EDIT_EVENT,
            START_EVENT
        }

        /* compiled from: WidgetPreviewGuildScheduledEvent.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\n\u0010\t\u001a\u00060\u0002j\u0002`\u0003\u0012\u0006\u0010\n\u001a\u00020\u0006¢\u0006\u0004\b\u001c\u0010\u001dJ\u0014\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ(\u0010\u000b\u001a\u00020\u00002\f\b\u0002\u0010\t\u001a\u00060\u0002j\u0002`\u00032\b\b\u0002\u0010\n\u001a\u00020\u0006HÆ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u001a\u0010\u0016\u001a\u00020\u00152\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013HÖ\u0003¢\u0006\u0004\b\u0016\u0010\u0017R\u0019\u0010\n\u001a\u00020\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010\u0018\u001a\u0004\b\u0019\u0010\bR\u001d\u0010\t\u001a\u00060\u0002j\u0002`\u00038\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\u001a\u001a\u0004\b\u001b\u0010\u0005¨\u0006\u001e"}, d2 = {"Lcom/discord/widgets/guildscheduledevent/WidgetPreviewGuildScheduledEvent$Companion$ExistingEventData;", "Ljava/io/Serializable;", "", "Lcom/discord/primitives/GuildScheduledEventId;", "component1", "()J", "Lcom/discord/widgets/guildscheduledevent/WidgetPreviewGuildScheduledEvent$Companion$Action;", "component2", "()Lcom/discord/widgets/guildscheduledevent/WidgetPreviewGuildScheduledEvent$Companion$Action;", "guildScheduledEventId", "action", "copy", "(JLcom/discord/widgets/guildscheduledevent/WidgetPreviewGuildScheduledEvent$Companion$Action;)Lcom/discord/widgets/guildscheduledevent/WidgetPreviewGuildScheduledEvent$Companion$ExistingEventData;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/discord/widgets/guildscheduledevent/WidgetPreviewGuildScheduledEvent$Companion$Action;", "getAction", "J", "getGuildScheduledEventId", "<init>", "(JLcom/discord/widgets/guildscheduledevent/WidgetPreviewGuildScheduledEvent$Companion$Action;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final /* data */ class ExistingEventData implements Serializable {
            private final Action action;
            private final long guildScheduledEventId;

            public ExistingEventData(long j, Action action) {
                Intrinsics3.checkNotNullParameter(action, "action");
                this.guildScheduledEventId = j;
                this.action = action;
            }

            public static /* synthetic */ ExistingEventData copy$default(ExistingEventData existingEventData, long j, Action action, int i, Object obj) {
                if ((i & 1) != 0) {
                    j = existingEventData.guildScheduledEventId;
                }
                if ((i & 2) != 0) {
                    action = existingEventData.action;
                }
                return existingEventData.copy(j, action);
            }

            /* renamed from: component1, reason: from getter */
            public final long getGuildScheduledEventId() {
                return this.guildScheduledEventId;
            }

            /* renamed from: component2, reason: from getter */
            public final Action getAction() {
                return this.action;
            }

            public final ExistingEventData copy(long guildScheduledEventId, Action action) {
                Intrinsics3.checkNotNullParameter(action, "action");
                return new ExistingEventData(guildScheduledEventId, action);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof ExistingEventData)) {
                    return false;
                }
                ExistingEventData existingEventData = (ExistingEventData) other;
                return this.guildScheduledEventId == existingEventData.guildScheduledEventId && Intrinsics3.areEqual(this.action, existingEventData.action);
            }

            public final Action getAction() {
                return this.action;
            }

            public final long getGuildScheduledEventId() {
                return this.guildScheduledEventId;
            }

            public int hashCode() {
                int iA = b.a(this.guildScheduledEventId) * 31;
                Action action = this.action;
                return iA + (action != null ? action.hashCode() : 0);
            }

            public String toString() {
                StringBuilder sbU = outline.U("ExistingEventData(guildScheduledEventId=");
                sbU.append(this.guildScheduledEventId);
                sbU.append(", action=");
                sbU.append(this.action);
                sbU.append(")");
                return sbU.toString();
            }
        }

        private Companion() {
        }

        public static /* synthetic */ void launch$default(Companion companion, Context context, GuildScheduledEventModel guildScheduledEventModel, ExistingEventData existingEventData, ActivityResultLauncher activityResultLauncher, boolean z2, int i, Object obj) {
            companion.launch(context, guildScheduledEventModel, (i & 4) != 0 ? null : existingEventData, (i & 8) != 0 ? null : activityResultLauncher, (i & 16) != 0 ? false : z2);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ ActivityResultLauncher registerForResult$default(Companion companion, Fragment fragment, Function3 function3, Function0 function0, int i, Object obj) {
            if ((i & 4) != 0) {
                function0 = null;
            }
            return companion.registerForResult(fragment, function3, function0);
        }

        public final ActivityResultLauncher<Intent> createJoinOnStartActivityRegistration(Fragment fragment, Function0<Unit> onEventStarted) {
            Intrinsics3.checkNotNullParameter(fragment, "fragment");
            Intrinsics3.checkNotNullParameter(onEventStarted, "onEventStarted");
            ActivityResultLauncher<Intent> activityResultLauncherRegisterForActivityResult = fragment.registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new WidgetPreviewGuildScheduledEvent2(fragment, onEventStarted));
            Intrinsics3.checkNotNullExpressionValue(activityResultLauncherRegisterForActivityResult, "fragment.registerForActi…entStarted)\n      }\n    }");
            return activityResultLauncherRegisterForActivityResult;
        }

        public final void launch(Context context, GuildScheduledEventModel eventModel, ExistingEventData existingEventData, ActivityResultLauncher<Intent> launcher, boolean fromSettings) {
            Intrinsics3.checkNotNullParameter(context, "context");
            Intrinsics3.checkNotNullParameter(eventModel, "eventModel");
            Intent intent = new Intent();
            intent.putExtra(WidgetPreviewGuildScheduledEvent.EXTRA_EVENT_MODEL, eventModel);
            if (existingEventData != null) {
                intent.putExtra(WidgetPreviewGuildScheduledEvent.EXTRA_EXISTING_EVENT_DATA, existingEventData);
            }
            if (fromSettings) {
                intent.putExtra("transition", AppTransitionActivity.Transition.TYPE_SLIDE_HORIZONTAL);
            }
            if (launcher != null) {
                AppScreen2.g.f(context, launcher, WidgetPreviewGuildScheduledEvent.class, intent);
            } else {
                AppScreen2.d(context, WidgetPreviewGuildScheduledEvent.class, intent);
            }
        }

        public final ActivityResultLauncher<Intent> registerForResult(Fragment fragment, Function3<? super Long, ? super Long, ? super Boolean, Unit> onEventCreated, Function0<Unit> onQuit) {
            Intrinsics3.checkNotNullParameter(fragment, "fragment");
            Intrinsics3.checkNotNullParameter(onEventCreated, "onEventCreated");
            ActivityResultLauncher<Intent> activityResultLauncherRegisterForActivityResult = fragment.registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new WidgetPreviewGuildScheduledEvent3(onEventCreated, onQuit));
            Intrinsics3.checkNotNullExpressionValue(activityResultLauncherRegisterForActivityResult, "fragment.registerForActi…  }\n          }\n        }");
            return activityResultLauncherRegisterForActivityResult;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            Companion.Action.values();
            int[] iArr = new int[2];
            $EnumSwitchMapping$0 = iArr;
            iArr[Companion.Action.START_EVENT.ordinal()] = 1;
            iArr[Companion.Action.EDIT_EVENT.ordinal()] = 2;
        }
    }

    /* compiled from: WidgetPreviewGuildScheduledEvent.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/widgets/guildscheduledevent/PreviewGuildScheduledEventViewModel$ViewState;", "p1", "", "invoke", "(Lcom/discord/widgets/guildscheduledevent/PreviewGuildScheduledEventViewModel$ViewState;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.guildscheduledevent.WidgetPreviewGuildScheduledEvent$onResume$1, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<PreviewGuildScheduledEventViewModel.ViewState, Unit> {
        public AnonymousClass1(WidgetPreviewGuildScheduledEvent widgetPreviewGuildScheduledEvent) {
            super(1, widgetPreviewGuildScheduledEvent, WidgetPreviewGuildScheduledEvent.class, "configureUi", "configureUi(Lcom/discord/widgets/guildscheduledevent/PreviewGuildScheduledEventViewModel$ViewState;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(PreviewGuildScheduledEventViewModel.ViewState viewState) throws Resources.NotFoundException {
            invoke2(viewState);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(PreviewGuildScheduledEventViewModel.ViewState viewState) throws Resources.NotFoundException {
            Intrinsics3.checkNotNullParameter(viewState, "p1");
            WidgetPreviewGuildScheduledEvent.access$configureUi((WidgetPreviewGuildScheduledEvent) this.receiver, viewState);
        }
    }

    /* compiled from: WidgetPreviewGuildScheduledEvent.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.guildscheduledevent.WidgetPreviewGuildScheduledEvent$onViewBound$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnClickListener {
        public AnonymousClass1() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            FragmentActivity activity = WidgetPreviewGuildScheduledEvent.this.getActivity();
            if (activity != null) {
                activity.finish();
            }
        }
    }

    /* compiled from: WidgetPreviewGuildScheduledEvent.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.guildscheduledevent.WidgetPreviewGuildScheduledEvent$onViewBound$2, reason: invalid class name */
    public static final class AnonymousClass2 implements View.OnClickListener {
        public AnonymousClass2() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            FragmentActivity activity = WidgetPreviewGuildScheduledEvent.this.getActivity();
            if (activity != null) {
                activity.setResult(2);
                activity.finish();
            }
        }
    }

    /* compiled from: WidgetPreviewGuildScheduledEvent.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.guildscheduledevent.WidgetPreviewGuildScheduledEvent$onViewBound$3, reason: invalid class name */
    public static final class AnonymousClass3 implements View.OnClickListener {

        /* compiled from: WidgetPreviewGuildScheduledEvent.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n\u0018\u00010\u0000j\u0004\u0018\u0001`\u0001H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "Lcom/discord/primitives/GuildScheduledEventId;", "it", "", "invoke", "(Ljava/lang/Long;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.widgets.guildscheduledevent.WidgetPreviewGuildScheduledEvent$onViewBound$3$2, reason: invalid class name */
        public static final class AnonymousClass2 extends Lambda implements Function1<Long, Unit> {
            public AnonymousClass2() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Long l) {
                invoke2(l);
                return Unit.a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Long l) {
                FragmentActivity activity = WidgetPreviewGuildScheduledEvent.this.getActivity();
                if (activity != null) {
                    if (WidgetPreviewGuildScheduledEvent.access$getViewModel$p(WidgetPreviewGuildScheduledEvent.this).isCreate()) {
                        Intent intent = new Intent();
                        intent.putExtra("com.discord.intent.extra.EXTRA_CHANNEL_ID", WidgetPreviewGuildScheduledEvent.access$getEventModel$p(WidgetPreviewGuildScheduledEvent.this).getChannelId());
                        intent.putExtra("com.discord.intent.extra.EXTRA_GUILD_SCHEDULED_EVENT_ID", l);
                        intent.putExtra(WidgetPreviewGuildScheduledEvent.EXTRA_EVENT_CREATED, true);
                        activity.setResult(-1, intent);
                    } else {
                        Intent intent2 = new Intent();
                        intent2.putExtra("com.discord.intent.extra.EXTRA_CHANNEL_ID", WidgetPreviewGuildScheduledEvent.access$getEventModel$p(WidgetPreviewGuildScheduledEvent.this).getChannelId());
                        intent2.putExtra("com.discord.intent.extra.EXTRA_GUILD_SCHEDULED_EVENT_ID", l);
                        activity.setResult(-1, intent2);
                    }
                    activity.finish();
                }
            }
        }

        public AnonymousClass3() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            PreviewGuildScheduledEventViewModel previewGuildScheduledEventViewModelAccess$getViewModel$p = WidgetPreviewGuildScheduledEvent.access$getViewModel$p(WidgetPreviewGuildScheduledEvent.this);
            CheckedSetting checkedSetting = WidgetPreviewGuildScheduledEvent.access$getBinding$p(WidgetPreviewGuildScheduledEvent.this).d;
            Intrinsics3.checkNotNullExpressionValue(checkedSetting, "checkedSetting");
            previewGuildScheduledEventViewModelAccess$getViewModel$p.onBottomButtonClicked(WidgetPreviewGuildScheduledEvent.this.requireContext(), (checkedSetting.getVisibility() == 0) && checkedSetting.isChecked(), new AnonymousClass2());
        }
    }

    public WidgetPreviewGuildScheduledEvent() {
        super(R.layout.widget_preview_guild_scheduled_event);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetPreviewGuildScheduledEvent4.INSTANCE, null, 2, null);
        this.eventModel = LazyJVM.lazy(new WidgetPreviewGuildScheduledEvent5(this));
        WidgetPreviewGuildScheduledEvent6 widgetPreviewGuildScheduledEvent6 = new WidgetPreviewGuildScheduledEvent6(this);
        AppViewModelDelegates3 appViewModelDelegates3 = new AppViewModelDelegates3(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection2.getOrCreateKotlinClass(PreviewGuildScheduledEventViewModel.class), new WidgetPreviewGuildScheduledEvent$appViewModels$$inlined$viewModels$1(appViewModelDelegates3), new AppViewModelDelegates5(widgetPreviewGuildScheduledEvent6));
    }

    public static final /* synthetic */ void access$configureUi(WidgetPreviewGuildScheduledEvent widgetPreviewGuildScheduledEvent, PreviewGuildScheduledEventViewModel.ViewState viewState) throws Resources.NotFoundException {
        widgetPreviewGuildScheduledEvent.configureUi(viewState);
    }

    public static final /* synthetic */ WidgetPreviewGuildScheduledEventBinding access$getBinding$p(WidgetPreviewGuildScheduledEvent widgetPreviewGuildScheduledEvent) {
        return widgetPreviewGuildScheduledEvent.getBinding();
    }

    public static final /* synthetic */ GuildScheduledEventModel access$getEventModel$p(WidgetPreviewGuildScheduledEvent widgetPreviewGuildScheduledEvent) {
        return widgetPreviewGuildScheduledEvent.getEventModel();
    }

    public static final /* synthetic */ PreviewGuildScheduledEventViewModel access$getViewModel$p(WidgetPreviewGuildScheduledEvent widgetPreviewGuildScheduledEvent) {
        return widgetPreviewGuildScheduledEvent.getViewModel();
    }

    private final void configureTextForCreation(PreviewGuildScheduledEventViewModel.ViewState.Initialized viewState) {
        TextView textView = getBinding().f;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.confirmGuildScheduledEventSubtitle");
        textView.setVisibility(8);
        TextView textView2 = getBinding().g;
        ViewGroup.LayoutParams layoutParams = textView2.getLayoutParams();
        Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        marginLayoutParams.setMargins(DimenUtils.dpToPixels(16), DimenUtils.dpToPixels(24), DimenUtils.dpToPixels(16), 0);
        textView2.setLayoutParams(marginLayoutParams);
        textView2.setText(FormatUtils.j(textView2, R.string.guild_event_preview_title, new Object[0], null, 4));
        TextView textView3 = getBinding().h;
        Intrinsics3.checkNotNullExpressionValue(textView3, "binding.createEventSubtitle");
        textView3.setVisibility(0);
        GuildScheduledEventLocationInfo locationInfo = viewState.getLocationInfo();
        if (locationInfo instanceof GuildScheduledEventLocationInfo.ChannelLocation) {
            String locationName = viewState.getLocationInfo().getLocationName();
            TextView textView4 = getBinding().h;
            Intrinsics3.checkNotNullExpressionValue(textView4, "binding.createEventSubtitle");
            FormatUtils.m(textView4, R.string.guild_event_preview_body, new Object[0], new AnonymousClass2(locationName, viewState));
            return;
        }
        if (locationInfo instanceof GuildScheduledEventLocationInfo.ExternalLocation) {
            TextView textView5 = getBinding().h;
            Intrinsics3.checkNotNullExpressionValue(textView5, "binding.createEventSubtitle");
            textView5.setText(getString(R.string.guild_event_preview_external_event_body));
        }
    }

    private final void configureTextForStart(PreviewGuildScheduledEventViewModel.ViewState.Initialized viewState) {
        TextView textView = getBinding().f;
        textView.setVisibility(0);
        textView.setText(getString(R.string.start_event_confirmation_no_hook));
        getBinding().g.setText(viewState.getEventModel().getName());
        TextView textView2 = getBinding().h;
        Intrinsics3.checkNotNullExpressionValue(textView2, "binding.createEventSubtitle");
        textView2.setVisibility(8);
    }

    private final void configureUi(PreviewGuildScheduledEventViewModel.ViewState viewState) throws Resources.NotFoundException {
        int i;
        if (viewState instanceof PreviewGuildScheduledEventViewModel.ViewState.Invalid) {
            FragmentActivity activity = getActivity();
            if (activity != null) {
                activity.finish();
                return;
            }
            return;
        }
        if (viewState instanceof PreviewGuildScheduledEventViewModel.ViewState.Initialized) {
            PreviewGuildScheduledEventViewModel.ViewState.Initialized initialized = (PreviewGuildScheduledEventViewModel.ViewState.Initialized) viewState;
            GuildScheduledEventLocationInfo locationInfo = initialized.getLocationInfo();
            if (!(locationInfo instanceof GuildScheduledEventLocationInfo.ChannelLocation)) {
                locationInfo = null;
            }
            GuildScheduledEventLocationInfo.ChannelLocation channelLocation = (GuildScheduledEventLocationInfo.ChannelLocation) locationInfo;
            Channel channel = channelLocation != null ? channelLocation.getChannel() : null;
            UserGuildMember creatorUserGuildMember$default = GuildScheduledEventUtilities5.getCreatorUserGuildMember$default(initialized.getEventModel(), (StoreGuilds) null, (StoreUser) null, 3, (Object) null);
            GuildScheduledEventItemView guildScheduledEventItemView = getBinding().e;
            GuildScheduledEventModel eventModel = initialized.getEventModel();
            if (creatorUserGuildMember$default == null) {
                creatorUserGuildMember$default = new UserGuildMember(StoreStream.INSTANCE.getUsers().getMeSnapshot(), null);
            }
            guildScheduledEventItemView.configureAsPreview(eventModel, channel, creatorUserGuildMember$default);
            MaterialButton materialButton = getBinding().i;
            materialButton.setEnabled(!initialized.getRequestProcessing());
            materialButton.setBackgroundTintList(ContextCompat.getColorStateList(materialButton.getContext(), initialized.getIsStartingEvent() ? R.color.uikit_btn_bg_color_selector_green : R.color.uikit_btn_bg_color_selector_brand));
            Context context = materialButton.getContext();
            Intrinsics3.checkNotNullExpressionValue(context, "context");
            Companion.Action existingEventAction = initialized.getExistingEventAction();
            if (existingEventAction == null) {
                i = R.string.schedule_event;
            } else {
                int iOrdinal = existingEventAction.ordinal();
                if (iOrdinal == 0) {
                    i = R.string.edit_event;
                } else {
                    if (iOrdinal != 1) {
                        throw new NoWhenBranchMatchedException();
                    }
                    i = R.string.start_event;
                }
            }
            materialButton.setText(FormatUtils.h(context, i, new Object[0], null, 4));
            ImageView imageView = getBinding().f2512b;
            Intrinsics3.checkNotNullExpressionValue(imageView, "binding.backButton");
            imageView.setVisibility(initialized.getIsStartingEvent() ^ true ? 0 : 8);
            TextView textView = getBinding().j;
            Intrinsics3.checkNotNullExpressionValue(textView, "binding.stepText");
            textView.setVisibility(initialized.getIsStartingEvent() ^ true ? 0 : 8);
            if (initialized.getIsStartingEvent()) {
                configureTextForStart(initialized);
            } else {
                configureTextForCreation(initialized);
            }
            CheckedSetting checkedSetting = getBinding().d;
            Intrinsics3.checkNotNullExpressionValue(checkedSetting, "binding.confirmGuildScheduledEventNotify");
            checkedSetting.setVisibility(initialized.getCanNotifyEveryone() ? 0 : 8);
        }
    }

    private final WidgetPreviewGuildScheduledEventBinding getBinding() {
        return (WidgetPreviewGuildScheduledEventBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final GuildScheduledEventModel getEventModel() {
        return (GuildScheduledEventModel) this.eventModel.getValue();
    }

    private final PreviewGuildScheduledEventViewModel getViewModel() {
        return (PreviewGuildScheduledEventViewModel) this.viewModel.getValue();
    }

    @Override // com.discord.app.AppFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null), WidgetPreviewGuildScheduledEvent.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(this), 62, (Object) null);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        TextView textView = getBinding().j;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.stepText");
        FormatUtils.n(textView, R.string.guild_event_step_label, new Object[]{3, 3}, null, 4);
        getBinding().f2512b.setOnClickListener(new AnonymousClass1());
        getBinding().c.setOnClickListener(new AnonymousClass2());
        getBinding().i.setOnClickListener(new AnonymousClass3());
    }

    /* compiled from: WidgetPreviewGuildScheduledEvent.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/discord/i18n/RenderContext;", "", "invoke", "(Lcom/discord/i18n/RenderContext;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.guildscheduledevent.WidgetPreviewGuildScheduledEvent$configureTextForCreation$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function1<RenderContext, Unit> {
        public final /* synthetic */ String $channelName;
        public final /* synthetic */ PreviewGuildScheduledEventViewModel.ViewState.Initialized $viewState;

        /* compiled from: WidgetPreviewGuildScheduledEvent.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/discord/i18n/Hook;", "", "invoke", "(Lcom/discord/i18n/Hook;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.widgets.guildscheduledevent.WidgetPreviewGuildScheduledEvent$configureTextForCreation$2$1, reason: invalid class name */
        public static final class AnonymousClass1 extends Lambda implements Function1<Hook, Unit> {
            public AnonymousClass1() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Hook hook) {
                invoke2(hook);
                return Unit.a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Hook hook) {
                Intrinsics3.checkNotNullParameter(hook, "$receiver");
                StringBuilder sbU = outline.U(". ");
                sbU.append(AnonymousClass2.this.$channelName);
                SpannableString spannableString = new SpannableString(sbU.toString());
                int iDpToPixels = DimenUtils.dpToPixels(20);
                Drawable drawable = ContextCompat.getDrawable(WidgetPreviewGuildScheduledEvent.this.requireContext(), AnonymousClass2.this.$viewState.getLocationInfo().getLocationIcon());
                Intrinsics3.checkNotNull(drawable);
                drawable.setBounds(0, 0, iDpToPixels, iDpToPixels);
                Intrinsics3.checkNotNullExpressionValue(drawable, "ContextCompat.getDrawabl…ze)\n                    }");
                spannableString.setSpan(new ImageSpan(drawable), 0, 1, 17);
                hook.replacementText = spannableString;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(String str, PreviewGuildScheduledEventViewModel.ViewState.Initialized initialized) {
            super(1);
            this.$channelName = str;
            this.$viewState = initialized;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(RenderContext renderContext) {
            Intrinsics3.checkNotNullParameter(renderContext, "$receiver");
            renderContext.args.put("channelName", this.$channelName);
            renderContext.a("channelHook", new AnonymousClass1());
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(RenderContext renderContext) {
            invoke2(renderContext);
            return Unit.a;
        }
    }
}

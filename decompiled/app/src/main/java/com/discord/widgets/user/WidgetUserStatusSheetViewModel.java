package com.discord.widgets.user;

import android.content.Context;
import b.a.d.AppViewModel;
import b.d.b.a.outline;
import com.discord.api.activity.Activity;
import com.discord.api.activity.ActivityEmoji;
import com.discord.api.presence.ClientStatus;
import com.discord.models.domain.ModelUserSettings;
import com.discord.models.domain.emoji.ModelEmojiUnicode;
import com.discord.restapi.RestAPIParams;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUserPresence;
import com.discord.stores.StoreUserSettings;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.analytics.Traits;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.widgets.user.profile.UserStatusPresenceCustomView;
import d0.c0.Random;
import d0.t._Arrays;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* compiled from: WidgetUserStatusSheetViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 (2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0003()*B5\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0017\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0012\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u001c\u0012\u000e\b\u0002\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00030$¢\u0006\u0004\b&\u0010'J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\b\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\b\u0010\u0007J\u000f\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0015\u0010\u000e\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000e\u0010\u000fJ\r\u0010\u0010\u001a\u00020\u0005¢\u0006\u0004\b\u0010\u0010\u0011R\u0019\u0010\u0013\u001a\u00020\u00128\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0019\u0010\u0018\u001a\u00020\u00178\u0006@\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u0019\u0010\u001d\u001a\u00020\u001c8\u0006@\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u0016\u0010\"\u001a\u00020!8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\"\u0010#¨\u0006+"}, d2 = {"Lcom/discord/widgets/user/WidgetUserStatusSheetViewModel;", "Lb/a/d/d0;", "Lcom/discord/widgets/user/WidgetUserStatusSheetViewModel$ViewState;", "Lcom/discord/widgets/user/WidgetUserStatusSheetViewModel$StoreState;", "storeState", "", "handleStoreState", "(Lcom/discord/widgets/user/WidgetUserStatusSheetViewModel$StoreState;)V", "trackOpen", "Lcom/discord/models/domain/emoji/ModelEmojiUnicode;", "getPlaceholderEmoji", "()Lcom/discord/models/domain/emoji/ModelEmojiUnicode;", "Lcom/discord/api/presence/ClientStatus;", "status", "setStatus", "(Lcom/discord/api/presence/ClientStatus;)V", "clearCustomStatus", "()V", "Lcom/discord/stores/StoreUserPresence;", "storePresences", "Lcom/discord/stores/StoreUserPresence;", "getStorePresences", "()Lcom/discord/stores/StoreUserPresence;", "Lcom/discord/stores/StoreUserSettings;", "storeUserSettings", "Lcom/discord/stores/StoreUserSettings;", "getStoreUserSettings", "()Lcom/discord/stores/StoreUserSettings;", "Lcom/discord/utilities/rest/RestAPI;", "restAPI", "Lcom/discord/utilities/rest/RestAPI;", "getRestAPI", "()Lcom/discord/utilities/rest/RestAPI;", "", "hasTrackedOpenPopout", "Z", "Lrx/Observable;", "storeObservable", "<init>", "(Lcom/discord/stores/StoreUserSettings;Lcom/discord/stores/StoreUserPresence;Lcom/discord/utilities/rest/RestAPI;Lrx/Observable;)V", "Companion", "StoreState", "ViewState", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final class WidgetUserStatusSheetViewModel extends AppViewModel<ViewState> {
    private boolean hasTrackedOpenPopout;
    private final RestAPI restAPI;
    private final StoreUserPresence storePresences;
    private final StoreUserSettings storeUserSettings;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String[] CUSTOM_EMOJI_PLACEHOLDER_EMOJIS = {"grinning", "grimacing", "grin", "joy", "smiley", "smile", "sweat_smile", "laughing", "innocent", "wink", "blush", "slight_smile", "upside_down", "relaxed", "yum", "relieved", "heart_eyes", "kissing_heart", "kissing", "kissing_smiling_eyes", "kissing_closed_eyes", "stuck_out_tongue_winking_eye", "stuck_out_tongue_closed_eyes", "stuck_out_tongue", "money_mouth", "nerd", "sunglasses", "hugging", "smirk", "no_mouth", "neutral_face", "expressionless", "unamused", "rolling_eyes", "thinking", "flushed", "disappointed", "worried", "angry", "rage", "pensive", "confused", "slight_frown", "frowning2", "persevere", "confounded", "tired_face", "weary", "triumph", "open_mouth", "eggplant"};

    /* compiled from: WidgetUserStatusSheetViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/widgets/user/WidgetUserStatusSheetViewModel$StoreState;", "storeState", "", "invoke", "(Lcom/discord/widgets/user/WidgetUserStatusSheetViewModel$StoreState;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.user.WidgetUserStatusSheetViewModel$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<StoreState, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(StoreState storeState) {
            invoke2(storeState);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(StoreState storeState) {
            Intrinsics3.checkNotNullParameter(storeState, "storeState");
            WidgetUserStatusSheetViewModel.access$handleStoreState(WidgetUserStatusSheetViewModel.this, storeState);
        }
    }

    /* compiled from: WidgetUserStatusSheetViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\f\u0010\rJ\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u001c\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000b¨\u0006\u000e"}, d2 = {"Lcom/discord/widgets/user/WidgetUserStatusSheetViewModel$Companion;", "", "Lcom/discord/stores/StoreUserPresence;", "storePresences", "Lrx/Observable;", "Lcom/discord/widgets/user/WidgetUserStatusSheetViewModel$StoreState;", "observeStoreState", "(Lcom/discord/stores/StoreUserPresence;)Lrx/Observable;", "", "", "CUSTOM_EMOJI_PLACEHOLDER_EMOJIS", "[Ljava/lang/String;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public static final /* synthetic */ Observable access$observeStoreState(Companion companion, StoreUserPresence storeUserPresence) {
            return companion.observeStoreState(storeUserPresence);
        }

        private final Observable<StoreState> observeStoreState(StoreUserPresence storePresences) {
            Observable observableG = storePresences.observeLocalPresence().G(WidgetUserStatusSheetViewModel2.INSTANCE);
            Intrinsics3.checkNotNullExpressionValue(observableG, "storePresences\n         …          )\n            }");
            return observableG;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetUserStatusSheetViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001c\u0010\u0006\u001a\u00020\u00002\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011R\u001b\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0012\u001a\u0004\b\u0013\u0010\u0004¨\u0006\u0016"}, d2 = {"Lcom/discord/widgets/user/WidgetUserStatusSheetViewModel$StoreState;", "", "Lcom/discord/api/activity/Activity;", "component1", "()Lcom/discord/api/activity/Activity;", "customStatusActivity", "copy", "(Lcom/discord/api/activity/Activity;)Lcom/discord/widgets/user/WidgetUserStatusSheetViewModel$StoreState;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/discord/api/activity/Activity;", "getCustomStatusActivity", "<init>", "(Lcom/discord/api/activity/Activity;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class StoreState {
        private final Activity customStatusActivity;

        public StoreState(Activity activity) {
            this.customStatusActivity = activity;
        }

        public static /* synthetic */ StoreState copy$default(StoreState storeState, Activity activity, int i, Object obj) {
            if ((i & 1) != 0) {
                activity = storeState.customStatusActivity;
            }
            return storeState.copy(activity);
        }

        /* renamed from: component1, reason: from getter */
        public final Activity getCustomStatusActivity() {
            return this.customStatusActivity;
        }

        public final StoreState copy(Activity customStatusActivity) {
            return new StoreState(customStatusActivity);
        }

        public boolean equals(Object other) {
            if (this != other) {
                return (other instanceof StoreState) && Intrinsics3.areEqual(this.customStatusActivity, ((StoreState) other).customStatusActivity);
            }
            return true;
        }

        public final Activity getCustomStatusActivity() {
            return this.customStatusActivity;
        }

        public int hashCode() {
            Activity activity = this.customStatusActivity;
            if (activity != null) {
                return activity.hashCode();
            }
            return 0;
        }

        public String toString() {
            StringBuilder sbU = outline.U("StoreState(customStatusActivity=");
            sbU.append(this.customStatusActivity);
            sbU.append(")");
            return sbU.toString();
        }
    }

    /* compiled from: WidgetUserStatusSheetViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0002\u0006\u0007¨\u0006\b"}, d2 = {"Lcom/discord/widgets/user/WidgetUserStatusSheetViewModel$ViewState;", "", "<init>", "()V", "Loaded", "Uninitialized", "Lcom/discord/widgets/user/WidgetUserStatusSheetViewModel$ViewState$Loaded;", "Lcom/discord/widgets/user/WidgetUserStatusSheetViewModel$ViewState$Uninitialized;", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static abstract class ViewState {

        /* compiled from: WidgetUserStatusSheetViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u0019\u0010\u0005\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0013\u001a\u0004\b\u0014\u0010\u0004¨\u0006\u0017"}, d2 = {"Lcom/discord/widgets/user/WidgetUserStatusSheetViewModel$ViewState$Loaded;", "Lcom/discord/widgets/user/WidgetUserStatusSheetViewModel$ViewState;", "Lcom/discord/widgets/user/profile/UserStatusPresenceCustomView$ViewState;", "component1", "()Lcom/discord/widgets/user/profile/UserStatusPresenceCustomView$ViewState;", "customStatusViewState", "copy", "(Lcom/discord/widgets/user/profile/UserStatusPresenceCustomView$ViewState;)Lcom/discord/widgets/user/WidgetUserStatusSheetViewModel$ViewState$Loaded;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/discord/widgets/user/profile/UserStatusPresenceCustomView$ViewState;", "getCustomStatusViewState", "<init>", "(Lcom/discord/widgets/user/profile/UserStatusPresenceCustomView$ViewState;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final /* data */ class Loaded extends ViewState {
            private final UserStatusPresenceCustomView.ViewState customStatusViewState;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Loaded(UserStatusPresenceCustomView.ViewState viewState) {
                super(null);
                Intrinsics3.checkNotNullParameter(viewState, "customStatusViewState");
                this.customStatusViewState = viewState;
            }

            public static /* synthetic */ Loaded copy$default(Loaded loaded, UserStatusPresenceCustomView.ViewState viewState, int i, Object obj) {
                if ((i & 1) != 0) {
                    viewState = loaded.customStatusViewState;
                }
                return loaded.copy(viewState);
            }

            /* renamed from: component1, reason: from getter */
            public final UserStatusPresenceCustomView.ViewState getCustomStatusViewState() {
                return this.customStatusViewState;
            }

            public final Loaded copy(UserStatusPresenceCustomView.ViewState customStatusViewState) {
                Intrinsics3.checkNotNullParameter(customStatusViewState, "customStatusViewState");
                return new Loaded(customStatusViewState);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof Loaded) && Intrinsics3.areEqual(this.customStatusViewState, ((Loaded) other).customStatusViewState);
                }
                return true;
            }

            public final UserStatusPresenceCustomView.ViewState getCustomStatusViewState() {
                return this.customStatusViewState;
            }

            public int hashCode() {
                UserStatusPresenceCustomView.ViewState viewState = this.customStatusViewState;
                if (viewState != null) {
                    return viewState.hashCode();
                }
                return 0;
            }

            public String toString() {
                StringBuilder sbU = outline.U("Loaded(customStatusViewState=");
                sbU.append(this.customStatusViewState);
                sbU.append(")");
                return sbU.toString();
            }
        }

        /* compiled from: WidgetUserStatusSheetViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/widgets/user/WidgetUserStatusSheetViewModel$ViewState$Uninitialized;", "Lcom/discord/widgets/user/WidgetUserStatusSheetViewModel$ViewState;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class Uninitialized extends ViewState {
            public static final Uninitialized INSTANCE = new Uninitialized();

            private Uninitialized() {
                super(null);
            }
        }

        private ViewState() {
        }

        public /* synthetic */ ViewState(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetUserStatusSheetViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/models/domain/ModelUserSettings;", "it", "", "invoke", "(Lcom/discord/models/domain/ModelUserSettings;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.user.WidgetUserStatusSheetViewModel$clearCustomStatus$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<ModelUserSettings, Unit> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ModelUserSettings modelUserSettings) {
            invoke2(modelUserSettings);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ModelUserSettings modelUserSettings) {
            Intrinsics3.checkNotNullParameter(modelUserSettings, "it");
        }
    }

    /* compiled from: WidgetUserStatusSheetViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/models/domain/ModelUserSettings;", "it", "", "invoke", "(Lcom/discord/models/domain/ModelUserSettings;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.user.WidgetUserStatusSheetViewModel$setStatus$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<ModelUserSettings, Unit> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ModelUserSettings modelUserSettings) {
            invoke2(modelUserSettings);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ModelUserSettings modelUserSettings) {
            Intrinsics3.checkNotNullParameter(modelUserSettings, "it");
        }
    }

    public WidgetUserStatusSheetViewModel() {
        this(null, null, null, null, 15, null);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ WidgetUserStatusSheetViewModel(StoreUserSettings storeUserSettings, StoreUserPresence storeUserPresence, RestAPI restAPI, Observable observable, int i, DefaultConstructorMarker defaultConstructorMarker) {
        storeUserSettings = (i & 1) != 0 ? StoreStream.INSTANCE.getUserSettings() : storeUserSettings;
        storeUserPresence = (i & 2) != 0 ? StoreStream.INSTANCE.getPresences() : storeUserPresence;
        this(storeUserSettings, storeUserPresence, (i & 4) != 0 ? RestAPI.INSTANCE.getApi() : restAPI, (i & 8) != 0 ? Companion.access$observeStoreState(INSTANCE, storeUserPresence) : observable);
    }

    public static final /* synthetic */ void access$handleStoreState(WidgetUserStatusSheetViewModel widgetUserStatusSheetViewModel, StoreState storeState) {
        widgetUserStatusSheetViewModel.handleStoreState(storeState);
    }

    private final ModelEmojiUnicode getPlaceholderEmoji() {
        Map<String, ModelEmojiUnicode> unicodeEmojisNamesMap = StoreStream.INSTANCE.getEmojis().getUnicodeEmojisNamesMap();
        String[] strArr = CUSTOM_EMOJI_PLACEHOLDER_EMOJIS;
        Random.a aVar = Random.k;
        ModelEmojiUnicode modelEmojiUnicode = unicodeEmojisNamesMap.get(_Arrays.random(strArr, aVar));
        return modelEmojiUnicode != null ? modelEmojiUnicode : (ModelEmojiUnicode) _Collections.random(unicodeEmojisNamesMap.values(), aVar);
    }

    private final void handleStoreState(StoreState storeState) {
        UserStatusPresenceCustomView.ViewState withPlaceholder;
        if (!this.hasTrackedOpenPopout) {
            trackOpen(storeState);
            this.hasTrackedOpenPopout = true;
        }
        Activity customStatusActivity = storeState.getCustomStatusActivity();
        if (customStatusActivity != null) {
            ActivityEmoji emoji = customStatusActivity.getEmoji();
            String id2 = emoji != null ? emoji.getId() : null;
            ActivityEmoji emoji2 = customStatusActivity.getEmoji();
            String name = emoji2 != null ? emoji2.getName() : null;
            ActivityEmoji emoji3 = customStatusActivity.getEmoji();
            withPlaceholder = new UserStatusPresenceCustomView.ViewState.WithStatus(new UserStatusPresenceCustomView.Emoji(id2, name, emoji3 != null ? emoji3.getAnimated() : false), customStatusActivity.getState());
        } else {
            withPlaceholder = new UserStatusPresenceCustomView.ViewState.WithPlaceholder(getPlaceholderEmoji());
        }
        updateViewState(new ViewState.Loaded(withPlaceholder));
    }

    private final void trackOpen(StoreState storeState) {
        AnalyticsTracker.INSTANCE.openUserStatusSheet(new Traits.Location(null, "Account Panel", "Avatar", null, null, 25, null), storeState.getCustomStatusActivity() != null);
    }

    public final void clearCustomStatus() {
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.restSubscribeOn$default(this.storeUserSettings.updateCustomStatus(null), false, 1, null), WidgetUserStatusSheetViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, AnonymousClass1.INSTANCE, 62, (Object) null);
    }

    public final RestAPI getRestAPI() {
        return this.restAPI;
    }

    public final StoreUserPresence getStorePresences() {
        return this.storePresences;
    }

    public final StoreUserSettings getStoreUserSettings() {
        return this.storeUserSettings;
    }

    public final void setStatus(ClientStatus status) {
        Intrinsics3.checkNotNullParameter(status, "status");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.restSubscribeOn$default(this.restAPI.updateUserSettings(RestAPIParams.UserSettings.INSTANCE.createWithStatus(status)), false, 1, null), WidgetUserStatusSheetViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, AnonymousClass1.INSTANCE, 62, (Object) null);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetUserStatusSheetViewModel(StoreUserSettings storeUserSettings, StoreUserPresence storeUserPresence, RestAPI restAPI, Observable<StoreState> observable) {
        super(ViewState.Uninitialized.INSTANCE);
        Intrinsics3.checkNotNullParameter(storeUserSettings, "storeUserSettings");
        Intrinsics3.checkNotNullParameter(storeUserPresence, "storePresences");
        Intrinsics3.checkNotNullParameter(restAPI, "restAPI");
        Intrinsics3.checkNotNullParameter(observable, "storeObservable");
        this.storeUserSettings = storeUserSettings;
        this.storePresences = storeUserPresence;
        this.restAPI = restAPI;
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(observable), this, null, 2, null), WidgetUserStatusSheetViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(), 62, (Object) null);
    }
}

package com.discord.widgets.user;

import android.content.Context;
import androidx.core.app.NotificationCompat;
import b.a.d.AppViewModel;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.models.domain.ModelCustomStatusSetting;
import com.discord.models.domain.ModelUserSettings;
import com.discord.models.domain.emoji.Emoji;
import com.discord.models.domain.emoji.EmojiSet;
import com.discord.models.domain.emoji.ModelEmojiCustom;
import com.discord.models.domain.emoji.ModelEmojiUnicode;
import com.discord.stores.StoreEmoji;
import com.discord.stores.StoreGuildScheduledEvents;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUserSettings;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.analytics.Traits;
import com.discord.utilities.error.Error;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.time.Clock;
import com.discord.utilities.time.ClockFactory;
import com.discord.utilities.time.TimeUtils;
import d0.g0.Strings4;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.Calendar;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.subjects.PublishSubject;

/* compiled from: WidgetUserSetCustomStatusViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 >2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0005>?@ABB+\u0012\b\b\u0002\u0010.\u001a\u00020-\u0012\b\b\u0002\u00103\u001a\u000202\u0012\u000e\b\u0002\u0010;\u001a\b\u0012\u0004\u0012\u00020\u00030\u001e¢\u0006\u0004\b<\u0010=J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\n\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u001f\u0010\u0010\u001a\n\u0018\u00010\u000ej\u0004\u0018\u0001`\u000f2\u0006\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J!\u0010\u0017\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0014H\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u0019\u0010\u0019\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0013\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001b\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001d\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u001d\u0010\u001cJ\u0013\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001f0\u001e¢\u0006\u0004\b \u0010!J\u0015\u0010#\u001a\u00020\u00052\u0006\u0010\"\u001a\u00020\u0016¢\u0006\u0004\b#\u0010$J\u0015\u0010&\u001a\u00020\u00052\u0006\u0010%\u001a\u00020\u000e¢\u0006\u0004\b&\u0010'J\r\u0010(\u001a\u00020\u0005¢\u0006\u0004\b(\u0010\u001cJ\u0015\u0010*\u001a\u00020\u00052\u0006\u0010)\u001a\u00020\f¢\u0006\u0004\b*\u0010+J\r\u0010,\u001a\u00020\u0005¢\u0006\u0004\b,\u0010\u001cR\u0019\u0010.\u001a\u00020-8\u0006@\u0006¢\u0006\f\n\u0004\b.\u0010/\u001a\u0004\b0\u00101R\u0019\u00103\u001a\u0002028\u0006@\u0006¢\u0006\f\n\u0004\b3\u00104\u001a\u0004\b5\u00106R:\u00109\u001a&\u0012\f\u0012\n 8*\u0004\u0018\u00010\u001f0\u001f 8*\u0012\u0012\f\u0012\n 8*\u0004\u0018\u00010\u001f0\u001f\u0018\u000107078\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b9\u0010:¨\u0006C"}, d2 = {"Lcom/discord/widgets/user/WidgetUserSetCustomStatusViewModel;", "Lb/a/d/d0;", "Lcom/discord/widgets/user/WidgetUserSetCustomStatusViewModel$ViewState;", "Lcom/discord/widgets/user/WidgetUserSetCustomStatusViewModel$StoreState;", "storeState", "", "handleStoreState", "(Lcom/discord/widgets/user/WidgetUserSetCustomStatusViewModel$StoreState;)V", "Lcom/discord/widgets/user/WidgetUserSetCustomStatusViewModel$FormState;", "formState", "updateFormState", "(Lcom/discord/widgets/user/WidgetUserSetCustomStatusViewModel$FormState;)V", "Lcom/discord/widgets/user/WidgetUserSetCustomStatusViewModel$FormState$Expiration;", "expiresAt", "", "Lcom/discord/primitives/UtcTimestamp;", "getExpirationUTCDateString", "(Lcom/discord/widgets/user/WidgetUserSetCustomStatusViewModel$FormState$Expiration;)Ljava/lang/String;", "Lcom/discord/models/domain/ModelCustomStatusSetting;", "customStatusSetting", "Lcom/discord/models/domain/emoji/EmojiSet;", "emojiSet", "Lcom/discord/models/domain/emoji/Emoji;", "getEmojiFromSetting", "(Lcom/discord/models/domain/ModelCustomStatusSetting;Lcom/discord/models/domain/emoji/EmojiSet;)Lcom/discord/models/domain/emoji/Emoji;", "getStatusTextFromSetting", "(Lcom/discord/models/domain/ModelCustomStatusSetting;)Ljava/lang/String;", "emitSetStatusSuccessEvent", "()V", "emitSetStatusFailureEvent", "Lrx/Observable;", "Lcom/discord/widgets/user/WidgetUserSetCustomStatusViewModel$Event;", "observeEvents", "()Lrx/Observable;", "emoji", "setStatusEmoji", "(Lcom/discord/models/domain/emoji/Emoji;)V", NotificationCompat.MessagingStyle.Message.KEY_TEXT, "setStatusText", "(Ljava/lang/String;)V", "clearStatusTextAndEmoji", "expiration", "setExpiration", "(Lcom/discord/widgets/user/WidgetUserSetCustomStatusViewModel$FormState$Expiration;)V", "saveStatus", "Lcom/discord/stores/StoreUserSettings;", "storeUserSettings", "Lcom/discord/stores/StoreUserSettings;", "getStoreUserSettings", "()Lcom/discord/stores/StoreUserSettings;", "Lcom/discord/utilities/time/Clock;", "clock", "Lcom/discord/utilities/time/Clock;", "getClock", "()Lcom/discord/utilities/time/Clock;", "Lrx/subjects/PublishSubject;", "kotlin.jvm.PlatformType", "eventSubject", "Lrx/subjects/PublishSubject;", "storeObservable", "<init>", "(Lcom/discord/stores/StoreUserSettings;Lcom/discord/utilities/time/Clock;Lrx/Observable;)V", "Companion", "Event", "FormState", "StoreState", "ViewState", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final class WidgetUserSetCustomStatusViewModel extends AppViewModel<ViewState> {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final FormState.Expiration DEFAULT_EXPIRATION = FormState.Expiration.TOMORROW;
    private final Clock clock;
    private final PublishSubject<Event> eventSubject;
    private final StoreUserSettings storeUserSettings;

    /* compiled from: WidgetUserSetCustomStatusViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/widgets/user/WidgetUserSetCustomStatusViewModel$StoreState;", "storeState", "", "invoke", "(Lcom/discord/widgets/user/WidgetUserSetCustomStatusViewModel$StoreState;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.user.WidgetUserSetCustomStatusViewModel$1, reason: invalid class name */
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
            WidgetUserSetCustomStatusViewModel.access$handleStoreState(WidgetUserSetCustomStatusViewModel.this, storeState);
        }
    }

    /* compiled from: WidgetUserSetCustomStatusViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000f\u0010\u0010J%\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\b\u0010\tR\u0019\u0010\u000b\u001a\u00020\n8\u0006@\u0006¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e¨\u0006\u0011"}, d2 = {"Lcom/discord/widgets/user/WidgetUserSetCustomStatusViewModel$Companion;", "", "Lcom/discord/stores/StoreUserSettings;", "storeUserSettings", "Lcom/discord/stores/StoreEmoji;", "storeEmoji", "Lrx/Observable;", "Lcom/discord/widgets/user/WidgetUserSetCustomStatusViewModel$StoreState;", "observeStoreState", "(Lcom/discord/stores/StoreUserSettings;Lcom/discord/stores/StoreEmoji;)Lrx/Observable;", "Lcom/discord/widgets/user/WidgetUserSetCustomStatusViewModel$FormState$Expiration;", "DEFAULT_EXPIRATION", "Lcom/discord/widgets/user/WidgetUserSetCustomStatusViewModel$FormState$Expiration;", "getDEFAULT_EXPIRATION", "()Lcom/discord/widgets/user/WidgetUserSetCustomStatusViewModel$FormState$Expiration;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public static final /* synthetic */ Observable access$observeStoreState(Companion companion, StoreUserSettings storeUserSettings, StoreEmoji storeEmoji) {
            return companion.observeStoreState(storeUserSettings, storeEmoji);
        }

        private final Observable<StoreState> observeStoreState(StoreUserSettings storeUserSettings, StoreEmoji storeEmoji) {
            Observable<StoreState> observableZ = Observable.j(storeUserSettings.observeCustomStatus(), storeEmoji.getEmojiSet(StoreEmoji.EmojiContext.Global.INSTANCE, false, false), WidgetUserSetCustomStatusViewModel2.INSTANCE).Z(1);
            Intrinsics3.checkNotNullExpressionValue(observableZ, "Observable.combineLatest…        )\n      }.take(1)");
            return observableZ;
        }

        public final FormState.Expiration getDEFAULT_EXPIRATION() {
            return WidgetUserSetCustomStatusViewModel.access$getDEFAULT_EXPIRATION$cp();
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetUserSetCustomStatusViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0002\u0006\u0007¨\u0006\b"}, d2 = {"Lcom/discord/widgets/user/WidgetUserSetCustomStatusViewModel$Event;", "", "<init>", "()V", "SetStatusFailure", "SetStatusSuccess", "Lcom/discord/widgets/user/WidgetUserSetCustomStatusViewModel$Event$SetStatusSuccess;", "Lcom/discord/widgets/user/WidgetUserSetCustomStatusViewModel$Event$SetStatusFailure;", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static abstract class Event {

        /* compiled from: WidgetUserSetCustomStatusViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000b\u0010\u0004J\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fHÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010R\u0019\u0010\u0005\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0011\u001a\u0004\b\u0012\u0010\u0004¨\u0006\u0015"}, d2 = {"Lcom/discord/widgets/user/WidgetUserSetCustomStatusViewModel$Event$SetStatusFailure;", "Lcom/discord/widgets/user/WidgetUserSetCustomStatusViewModel$Event;", "", "component1", "()I", "failureMessageStringRes", "copy", "(I)Lcom/discord/widgets/user/WidgetUserSetCustomStatusViewModel$Event$SetStatusFailure;", "", "toString", "()Ljava/lang/String;", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "I", "getFailureMessageStringRes", "<init>", "(I)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final /* data */ class SetStatusFailure extends Event {
            private final int failureMessageStringRes;

            public SetStatusFailure(int i) {
                super(null);
                this.failureMessageStringRes = i;
            }

            public static /* synthetic */ SetStatusFailure copy$default(SetStatusFailure setStatusFailure, int i, int i2, Object obj) {
                if ((i2 & 1) != 0) {
                    i = setStatusFailure.failureMessageStringRes;
                }
                return setStatusFailure.copy(i);
            }

            /* renamed from: component1, reason: from getter */
            public final int getFailureMessageStringRes() {
                return this.failureMessageStringRes;
            }

            public final SetStatusFailure copy(int failureMessageStringRes) {
                return new SetStatusFailure(failureMessageStringRes);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof SetStatusFailure) && this.failureMessageStringRes == ((SetStatusFailure) other).failureMessageStringRes;
                }
                return true;
            }

            public final int getFailureMessageStringRes() {
                return this.failureMessageStringRes;
            }

            public int hashCode() {
                return this.failureMessageStringRes;
            }

            public String toString() {
                return outline.B(outline.U("SetStatusFailure(failureMessageStringRes="), this.failureMessageStringRes, ")");
            }
        }

        /* compiled from: WidgetUserSetCustomStatusViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000b\u0010\u0004J\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fHÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010R\u0019\u0010\u0005\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0011\u001a\u0004\b\u0012\u0010\u0004¨\u0006\u0015"}, d2 = {"Lcom/discord/widgets/user/WidgetUserSetCustomStatusViewModel$Event$SetStatusSuccess;", "Lcom/discord/widgets/user/WidgetUserSetCustomStatusViewModel$Event;", "", "component1", "()I", "successMessageStringRes", "copy", "(I)Lcom/discord/widgets/user/WidgetUserSetCustomStatusViewModel$Event$SetStatusSuccess;", "", "toString", "()Ljava/lang/String;", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "I", "getSuccessMessageStringRes", "<init>", "(I)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final /* data */ class SetStatusSuccess extends Event {
            private final int successMessageStringRes;

            public SetStatusSuccess(int i) {
                super(null);
                this.successMessageStringRes = i;
            }

            public static /* synthetic */ SetStatusSuccess copy$default(SetStatusSuccess setStatusSuccess, int i, int i2, Object obj) {
                if ((i2 & 1) != 0) {
                    i = setStatusSuccess.successMessageStringRes;
                }
                return setStatusSuccess.copy(i);
            }

            /* renamed from: component1, reason: from getter */
            public final int getSuccessMessageStringRes() {
                return this.successMessageStringRes;
            }

            public final SetStatusSuccess copy(int successMessageStringRes) {
                return new SetStatusSuccess(successMessageStringRes);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof SetStatusSuccess) && this.successMessageStringRes == ((SetStatusSuccess) other).successMessageStringRes;
                }
                return true;
            }

            public final int getSuccessMessageStringRes() {
                return this.successMessageStringRes;
            }

            public int hashCode() {
                return this.successMessageStringRes;
            }

            public String toString() {
                return outline.B(outline.U("SetStatusSuccess(successMessageStringRes="), this.successMessageStringRes, ")");
            }
        }

        private Event() {
        }

        public /* synthetic */ Event(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetUserSetCustomStatusViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001:\u0001 B!\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\f\u001a\u00020\u0005\u0012\u0006\u0010\r\u001a\u00020\b¢\u0006\u0004\b\u001e\u0010\u001fJ\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ0\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\f\u001a\u00020\u00052\b\b\u0002\u0010\r\u001a\u00020\bHÆ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0007J\u0010\u0010\u0012\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u001a\u0010\u0016\u001a\u00020\u00152\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0016\u0010\u0017R\u001b\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u0018\u001a\u0004\b\u0019\u0010\u0004R\u0019\u0010\f\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\u001a\u001a\u0004\b\u001b\u0010\u0007R\u0019\u0010\r\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u001c\u001a\u0004\b\u001d\u0010\n¨\u0006!"}, d2 = {"Lcom/discord/widgets/user/WidgetUserSetCustomStatusViewModel$FormState;", "", "Lcom/discord/models/domain/emoji/Emoji;", "component1", "()Lcom/discord/models/domain/emoji/Emoji;", "", "component2", "()Ljava/lang/String;", "Lcom/discord/widgets/user/WidgetUserSetCustomStatusViewModel$FormState$Expiration;", "component3", "()Lcom/discord/widgets/user/WidgetUserSetCustomStatusViewModel$FormState$Expiration;", "emoji", NotificationCompat.MessagingStyle.Message.KEY_TEXT, "expiration", "copy", "(Lcom/discord/models/domain/emoji/Emoji;Ljava/lang/String;Lcom/discord/widgets/user/WidgetUserSetCustomStatusViewModel$FormState$Expiration;)Lcom/discord/widgets/user/WidgetUserSetCustomStatusViewModel$FormState;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/discord/models/domain/emoji/Emoji;", "getEmoji", "Ljava/lang/String;", "getText", "Lcom/discord/widgets/user/WidgetUserSetCustomStatusViewModel$FormState$Expiration;", "getExpiration", "<init>", "(Lcom/discord/models/domain/emoji/Emoji;Ljava/lang/String;Lcom/discord/widgets/user/WidgetUserSetCustomStatusViewModel$FormState$Expiration;)V", "Expiration", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class FormState {
        private final Emoji emoji;
        private final Expiration expiration;
        private final String text;

        /* compiled from: WidgetUserSetCustomStatusViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/discord/widgets/user/WidgetUserSetCustomStatusViewModel$FormState$Expiration;", "", "<init>", "(Ljava/lang/String;I)V", "NEVER", "IN_30_MINUTES", "IN_1_HOUR", "IN_4_HOURS", "TOMORROW", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public enum Expiration {
            NEVER,
            IN_30_MINUTES,
            IN_1_HOUR,
            IN_4_HOURS,
            TOMORROW
        }

        public FormState(Emoji emoji, String str, Expiration expiration) {
            Intrinsics3.checkNotNullParameter(str, NotificationCompat.MessagingStyle.Message.KEY_TEXT);
            Intrinsics3.checkNotNullParameter(expiration, "expiration");
            this.emoji = emoji;
            this.text = str;
            this.expiration = expiration;
        }

        public static /* synthetic */ FormState copy$default(FormState formState, Emoji emoji, String str, Expiration expiration, int i, Object obj) {
            if ((i & 1) != 0) {
                emoji = formState.emoji;
            }
            if ((i & 2) != 0) {
                str = formState.text;
            }
            if ((i & 4) != 0) {
                expiration = formState.expiration;
            }
            return formState.copy(emoji, str, expiration);
        }

        /* renamed from: component1, reason: from getter */
        public final Emoji getEmoji() {
            return this.emoji;
        }

        /* renamed from: component2, reason: from getter */
        public final String getText() {
            return this.text;
        }

        /* renamed from: component3, reason: from getter */
        public final Expiration getExpiration() {
            return this.expiration;
        }

        public final FormState copy(Emoji emoji, String text, Expiration expiration) {
            Intrinsics3.checkNotNullParameter(text, NotificationCompat.MessagingStyle.Message.KEY_TEXT);
            Intrinsics3.checkNotNullParameter(expiration, "expiration");
            return new FormState(emoji, text, expiration);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof FormState)) {
                return false;
            }
            FormState formState = (FormState) other;
            return Intrinsics3.areEqual(this.emoji, formState.emoji) && Intrinsics3.areEqual(this.text, formState.text) && Intrinsics3.areEqual(this.expiration, formState.expiration);
        }

        public final Emoji getEmoji() {
            return this.emoji;
        }

        public final Expiration getExpiration() {
            return this.expiration;
        }

        public final String getText() {
            return this.text;
        }

        public int hashCode() {
            Emoji emoji = this.emoji;
            int iHashCode = (emoji != null ? emoji.hashCode() : 0) * 31;
            String str = this.text;
            int iHashCode2 = (iHashCode + (str != null ? str.hashCode() : 0)) * 31;
            Expiration expiration = this.expiration;
            return iHashCode2 + (expiration != null ? expiration.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = outline.U("FormState(emoji=");
            sbU.append(this.emoji);
            sbU.append(", text=");
            sbU.append(this.text);
            sbU.append(", expiration=");
            sbU.append(this.expiration);
            sbU.append(")");
            return sbU.toString();
        }
    }

    /* compiled from: WidgetUserSetCustomStatusViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J$\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015R\u0019\u0010\b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\u0016\u001a\u0004\b\u0017\u0010\u0004R\u0019\u0010\t\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\u0018\u001a\u0004\b\u0019\u0010\u0007¨\u0006\u001c"}, d2 = {"Lcom/discord/widgets/user/WidgetUserSetCustomStatusViewModel$StoreState;", "", "Lcom/discord/models/domain/ModelCustomStatusSetting;", "component1", "()Lcom/discord/models/domain/ModelCustomStatusSetting;", "Lcom/discord/models/domain/emoji/EmojiSet;", "component2", "()Lcom/discord/models/domain/emoji/EmojiSet;", "customStatusSetting", "emojiSet", "copy", "(Lcom/discord/models/domain/ModelCustomStatusSetting;Lcom/discord/models/domain/emoji/EmojiSet;)Lcom/discord/widgets/user/WidgetUserSetCustomStatusViewModel$StoreState;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/discord/models/domain/ModelCustomStatusSetting;", "getCustomStatusSetting", "Lcom/discord/models/domain/emoji/EmojiSet;", "getEmojiSet", "<init>", "(Lcom/discord/models/domain/ModelCustomStatusSetting;Lcom/discord/models/domain/emoji/EmojiSet;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class StoreState {
        private final ModelCustomStatusSetting customStatusSetting;
        private final EmojiSet emojiSet;

        public StoreState(ModelCustomStatusSetting modelCustomStatusSetting, EmojiSet emojiSet) {
            Intrinsics3.checkNotNullParameter(modelCustomStatusSetting, "customStatusSetting");
            Intrinsics3.checkNotNullParameter(emojiSet, "emojiSet");
            this.customStatusSetting = modelCustomStatusSetting;
            this.emojiSet = emojiSet;
        }

        public static /* synthetic */ StoreState copy$default(StoreState storeState, ModelCustomStatusSetting modelCustomStatusSetting, EmojiSet emojiSet, int i, Object obj) {
            if ((i & 1) != 0) {
                modelCustomStatusSetting = storeState.customStatusSetting;
            }
            if ((i & 2) != 0) {
                emojiSet = storeState.emojiSet;
            }
            return storeState.copy(modelCustomStatusSetting, emojiSet);
        }

        /* renamed from: component1, reason: from getter */
        public final ModelCustomStatusSetting getCustomStatusSetting() {
            return this.customStatusSetting;
        }

        /* renamed from: component2, reason: from getter */
        public final EmojiSet getEmojiSet() {
            return this.emojiSet;
        }

        public final StoreState copy(ModelCustomStatusSetting customStatusSetting, EmojiSet emojiSet) {
            Intrinsics3.checkNotNullParameter(customStatusSetting, "customStatusSetting");
            Intrinsics3.checkNotNullParameter(emojiSet, "emojiSet");
            return new StoreState(customStatusSetting, emojiSet);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof StoreState)) {
                return false;
            }
            StoreState storeState = (StoreState) other;
            return Intrinsics3.areEqual(this.customStatusSetting, storeState.customStatusSetting) && Intrinsics3.areEqual(this.emojiSet, storeState.emojiSet);
        }

        public final ModelCustomStatusSetting getCustomStatusSetting() {
            return this.customStatusSetting;
        }

        public final EmojiSet getEmojiSet() {
            return this.emojiSet;
        }

        public int hashCode() {
            ModelCustomStatusSetting modelCustomStatusSetting = this.customStatusSetting;
            int iHashCode = (modelCustomStatusSetting != null ? modelCustomStatusSetting.hashCode() : 0) * 31;
            EmojiSet emojiSet = this.emojiSet;
            return iHashCode + (emojiSet != null ? emojiSet.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = outline.U("StoreState(customStatusSetting=");
            sbU.append(this.customStatusSetting);
            sbU.append(", emojiSet=");
            sbU.append(this.emojiSet);
            sbU.append(")");
            return sbU.toString();
        }
    }

    /* compiled from: WidgetUserSetCustomStatusViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0002\u0006\u0007¨\u0006\b"}, d2 = {"Lcom/discord/widgets/user/WidgetUserSetCustomStatusViewModel$ViewState;", "", "<init>", "()V", "Loaded", "Uninitialized", "Lcom/discord/widgets/user/WidgetUserSetCustomStatusViewModel$ViewState$Loaded;", "Lcom/discord/widgets/user/WidgetUserSetCustomStatusViewModel$ViewState$Uninitialized;", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static abstract class ViewState {

        /* compiled from: WidgetUserSetCustomStatusViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u0019\u0010\u0005\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0013\u001a\u0004\b\u0014\u0010\u0004R\u0013\u0010\u0017\u001a\u00020\u00108F@\u0006¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u001a"}, d2 = {"Lcom/discord/widgets/user/WidgetUserSetCustomStatusViewModel$ViewState$Loaded;", "Lcom/discord/widgets/user/WidgetUserSetCustomStatusViewModel$ViewState;", "Lcom/discord/widgets/user/WidgetUserSetCustomStatusViewModel$FormState;", "component1", "()Lcom/discord/widgets/user/WidgetUserSetCustomStatusViewModel$FormState;", "formState", "copy", "(Lcom/discord/widgets/user/WidgetUserSetCustomStatusViewModel$FormState;)Lcom/discord/widgets/user/WidgetUserSetCustomStatusViewModel$ViewState$Loaded;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/discord/widgets/user/WidgetUserSetCustomStatusViewModel$FormState;", "getFormState", "getShowStatusClear", "()Z", "showStatusClear", "<init>", "(Lcom/discord/widgets/user/WidgetUserSetCustomStatusViewModel$FormState;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final /* data */ class Loaded extends ViewState {
            private final FormState formState;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Loaded(FormState formState) {
                super(null);
                Intrinsics3.checkNotNullParameter(formState, "formState");
                this.formState = formState;
            }

            public static /* synthetic */ Loaded copy$default(Loaded loaded, FormState formState, int i, Object obj) {
                if ((i & 1) != 0) {
                    formState = loaded.formState;
                }
                return loaded.copy(formState);
            }

            /* renamed from: component1, reason: from getter */
            public final FormState getFormState() {
                return this.formState;
            }

            public final Loaded copy(FormState formState) {
                Intrinsics3.checkNotNullParameter(formState, "formState");
                return new Loaded(formState);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof Loaded) && Intrinsics3.areEqual(this.formState, ((Loaded) other).formState);
                }
                return true;
            }

            public final FormState getFormState() {
                return this.formState;
            }

            public final boolean getShowStatusClear() {
                if (this.formState.getEmoji() == null) {
                    if (!(this.formState.getText().length() > 0)) {
                        return false;
                    }
                }
                return true;
            }

            public int hashCode() {
                FormState formState = this.formState;
                if (formState != null) {
                    return formState.hashCode();
                }
                return 0;
            }

            public String toString() {
                StringBuilder sbU = outline.U("Loaded(formState=");
                sbU.append(this.formState);
                sbU.append(")");
                return sbU.toString();
            }
        }

        /* compiled from: WidgetUserSetCustomStatusViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/widgets/user/WidgetUserSetCustomStatusViewModel$ViewState$Uninitialized;", "Lcom/discord/widgets/user/WidgetUserSetCustomStatusViewModel$ViewState;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
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

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            FormState.Expiration.values();
            int[] iArr = new int[5];
            $EnumSwitchMapping$0 = iArr;
            iArr[FormState.Expiration.NEVER.ordinal()] = 1;
            iArr[FormState.Expiration.IN_30_MINUTES.ordinal()] = 2;
            iArr[FormState.Expiration.IN_1_HOUR.ordinal()] = 3;
            iArr[FormState.Expiration.IN_4_HOURS.ordinal()] = 4;
            iArr[FormState.Expiration.TOMORROW.ordinal()] = 5;
        }
    }

    /* compiled from: WidgetUserSetCustomStatusViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/models/domain/ModelUserSettings;", "it", "", "invoke", "(Lcom/discord/models/domain/ModelUserSettings;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.user.WidgetUserSetCustomStatusViewModel$saveStatus$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<ModelUserSettings, Unit> {
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
            WidgetUserSetCustomStatusViewModel.access$emitSetStatusSuccessEvent(WidgetUserSetCustomStatusViewModel.this);
        }
    }

    /* compiled from: WidgetUserSetCustomStatusViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/utilities/error/Error;", "it", "", "invoke", "(Lcom/discord/utilities/error/Error;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.user.WidgetUserSetCustomStatusViewModel$saveStatus$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function1<Error, Unit> {
        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Error error) {
            invoke2(error);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Error error) {
            Intrinsics3.checkNotNullParameter(error, "it");
            WidgetUserSetCustomStatusViewModel.access$emitSetStatusFailureEvent(WidgetUserSetCustomStatusViewModel.this);
        }
    }

    public WidgetUserSetCustomStatusViewModel() {
        this(null, null, null, 7, null);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ WidgetUserSetCustomStatusViewModel(StoreUserSettings storeUserSettings, Clock clock, Observable observable, int i, DefaultConstructorMarker defaultConstructorMarker) {
        storeUserSettings = (i & 1) != 0 ? StoreStream.INSTANCE.getUserSettings() : storeUserSettings;
        clock = (i & 2) != 0 ? ClockFactory.get() : clock;
        if ((i & 4) != 0) {
            Companion companion = INSTANCE;
            StoreStream.Companion companion2 = StoreStream.INSTANCE;
            observable = Companion.access$observeStoreState(companion, companion2.getUserSettings(), companion2.getEmojis());
        }
        this(storeUserSettings, clock, observable);
    }

    public static final /* synthetic */ void access$emitSetStatusFailureEvent(WidgetUserSetCustomStatusViewModel widgetUserSetCustomStatusViewModel) {
        widgetUserSetCustomStatusViewModel.emitSetStatusFailureEvent();
    }

    public static final /* synthetic */ void access$emitSetStatusSuccessEvent(WidgetUserSetCustomStatusViewModel widgetUserSetCustomStatusViewModel) {
        widgetUserSetCustomStatusViewModel.emitSetStatusSuccessEvent();
    }

    public static final /* synthetic */ FormState.Expiration access$getDEFAULT_EXPIRATION$cp() {
        return DEFAULT_EXPIRATION;
    }

    public static final /* synthetic */ void access$handleStoreState(WidgetUserSetCustomStatusViewModel widgetUserSetCustomStatusViewModel, StoreState storeState) {
        widgetUserSetCustomStatusViewModel.handleStoreState(storeState);
    }

    private final void emitSetStatusFailureEvent() {
        PublishSubject<Event> publishSubject = this.eventSubject;
        publishSubject.k.onNext(new Event.SetStatusFailure(R.string.default_failure_to_perform_action_message));
    }

    private final void emitSetStatusSuccessEvent() {
        PublishSubject<Event> publishSubject = this.eventSubject;
        publishSubject.k.onNext(new Event.SetStatusSuccess(R.string.custom_status_update_success));
    }

    private final Emoji getEmojiFromSetting(ModelCustomStatusSetting customStatusSetting, EmojiSet emojiSet) {
        String emojiName;
        if (customStatusSetting == ModelCustomStatusSetting.INSTANCE.getCLEAR()) {
            return null;
        }
        Long emojiId = customStatusSetting.getEmojiId();
        if (emojiId == null || (emojiName = String.valueOf(emojiId.longValue())) == null) {
            emojiName = customStatusSetting.getEmojiName();
        }
        return emojiSet.emojiIndex.get(emojiName);
    }

    private final String getExpirationUTCDateString(FormState.Expiration expiresAt) {
        Long lValueOf;
        long jCurrentTimeMillis = this.clock.currentTimeMillis();
        int iOrdinal = expiresAt.ordinal();
        if (iOrdinal == 0) {
            lValueOf = null;
        } else if (iOrdinal == 1) {
            lValueOf = Long.valueOf(jCurrentTimeMillis + StoreGuildScheduledEvents.FETCH_GUILD_EVENTS_THRESHOLD);
        } else if (iOrdinal == 2) {
            lValueOf = Long.valueOf(jCurrentTimeMillis + 3600000);
        } else if (iOrdinal == 3) {
            lValueOf = Long.valueOf(jCurrentTimeMillis + 14400000);
        } else {
            if (iOrdinal != 4) {
                throw new NoWhenBranchMatchedException();
            }
            Calendar calendar = TimeUtils.toCalendar(jCurrentTimeMillis);
            calendar.add(5, 1);
            calendar.set(11, 0);
            calendar.set(12, 0);
            calendar.set(13, 0);
            calendar.set(14, 0);
            lValueOf = Long.valueOf(calendar.getTimeInMillis());
        }
        return TimeUtils.toUTCDateTime$default(lValueOf, null, 2, null);
    }

    private final String getStatusTextFromSetting(ModelCustomStatusSetting customStatusSetting) {
        if (customStatusSetting != ModelCustomStatusSetting.INSTANCE.getCLEAR()) {
            return customStatusSetting.getText();
        }
        return null;
    }

    private final void handleStoreState(StoreState storeState) {
        if (getViewState() instanceof ViewState.Loaded) {
            return;
        }
        Emoji emojiFromSetting = getEmojiFromSetting(storeState.getCustomStatusSetting(), storeState.getEmojiSet());
        String statusTextFromSetting = getStatusTextFromSetting(storeState.getCustomStatusSetting());
        if (statusTextFromSetting == null) {
            statusTextFromSetting = "";
        }
        updateViewState(new ViewState.Loaded(new FormState(emojiFromSetting, statusTextFromSetting, DEFAULT_EXPIRATION)));
    }

    private final void updateFormState(FormState formState) {
        ViewState viewState = getViewState();
        if (!(viewState instanceof ViewState.Loaded)) {
            viewState = null;
        }
        ViewState.Loaded loaded = (ViewState.Loaded) viewState;
        if (loaded != null) {
            updateViewState(loaded.copy(formState));
        }
    }

    public final void clearStatusTextAndEmoji() {
        ViewState viewState = getViewState();
        if (!(viewState instanceof ViewState.Loaded)) {
            viewState = null;
        }
        ViewState.Loaded loaded = (ViewState.Loaded) viewState;
        if (loaded != null) {
            updateFormState(FormState.copy$default(loaded.getFormState(), null, "", null, 4, null));
        }
    }

    public final Clock getClock() {
        return this.clock;
    }

    public final StoreUserSettings getStoreUserSettings() {
        return this.storeUserSettings;
    }

    public final Observable<Event> observeEvents() {
        PublishSubject<Event> publishSubject = this.eventSubject;
        Intrinsics3.checkNotNullExpressionValue(publishSubject, "eventSubject");
        return publishSubject;
    }

    public final void saveStatus() {
        ModelCustomStatusSetting modelCustomStatusSetting;
        ViewState viewState = getViewState();
        if (!(viewState instanceof ViewState.Loaded)) {
            viewState = null;
        }
        ViewState.Loaded loaded = (ViewState.Loaded) viewState;
        if (loaded != null) {
            FormState formState = loaded.getFormState();
            String text = formState.getText();
            Objects.requireNonNull(text, "null cannot be cast to non-null type kotlin.CharSequence");
            String string = Strings4.trim(text).toString();
            if (!(string.length() > 0)) {
                string = null;
            }
            FormState formState2 = string != null || formState.getEmoji() != null ? formState : null;
            if (formState2 != null) {
                Emoji emoji = formState2.getEmoji();
                if (!(emoji instanceof ModelEmojiCustom)) {
                    emoji = null;
                }
                ModelEmojiCustom modelEmojiCustom = (ModelEmojiCustom) emoji;
                Long lValueOf = modelEmojiCustom != null ? Long.valueOf(modelEmojiCustom.getId()) : null;
                Emoji emoji2 = formState2.getEmoji();
                if (!(emoji2 instanceof ModelEmojiUnicode)) {
                    emoji2 = null;
                }
                ModelEmojiUnicode modelEmojiUnicode = (ModelEmojiUnicode) emoji2;
                modelCustomStatusSetting = new ModelCustomStatusSetting(string, lValueOf, modelEmojiUnicode != null ? modelEmojiUnicode.getSurrogates() : null, getExpirationUTCDateString(formState2.getExpiration()));
            } else {
                modelCustomStatusSetting = null;
            }
            ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(this.storeUserSettings.updateCustomStatus(modelCustomStatusSetting), false, 1, null), this, null, 2, null), WidgetUserSetCustomStatusViewModel.class, (Context) null, (Function1) null, new AnonymousClass2(), (Function0) null, (Function0) null, new AnonymousClass1(), 54, (Object) null);
            if (modelCustomStatusSetting != null) {
                AnalyticsTracker.INSTANCE.customStatusUpdated(formState, new Traits.Location(null, "Account Panel", "Avatar", null, null, 25, null));
            }
        }
    }

    public final void setExpiration(FormState.Expiration expiration) {
        Intrinsics3.checkNotNullParameter(expiration, "expiration");
        ViewState viewState = getViewState();
        if (!(viewState instanceof ViewState.Loaded)) {
            viewState = null;
        }
        ViewState.Loaded loaded = (ViewState.Loaded) viewState;
        if (loaded != null) {
            updateFormState(FormState.copy$default(loaded.getFormState(), null, null, expiration, 3, null));
        }
    }

    public final void setStatusEmoji(Emoji emoji) {
        Intrinsics3.checkNotNullParameter(emoji, "emoji");
        ViewState viewState = getViewState();
        if (!(viewState instanceof ViewState.Loaded)) {
            viewState = null;
        }
        ViewState.Loaded loaded = (ViewState.Loaded) viewState;
        if (loaded != null) {
            updateFormState(FormState.copy$default(loaded.getFormState(), emoji, null, null, 6, null));
        }
    }

    public final void setStatusText(String text) {
        Intrinsics3.checkNotNullParameter(text, NotificationCompat.MessagingStyle.Message.KEY_TEXT);
        ViewState viewState = getViewState();
        if (!(viewState instanceof ViewState.Loaded)) {
            viewState = null;
        }
        ViewState.Loaded loaded = (ViewState.Loaded) viewState;
        if (loaded != null) {
            updateFormState(FormState.copy$default(loaded.getFormState(), null, text, null, 5, null));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetUserSetCustomStatusViewModel(StoreUserSettings storeUserSettings, Clock clock, Observable<StoreState> observable) {
        super(ViewState.Uninitialized.INSTANCE);
        Intrinsics3.checkNotNullParameter(storeUserSettings, "storeUserSettings");
        Intrinsics3.checkNotNullParameter(clock, "clock");
        Intrinsics3.checkNotNullParameter(observable, "storeObservable");
        this.storeUserSettings = storeUserSettings;
        this.clock = clock;
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(observable), this, null, 2, null), WidgetUserSetCustomStatusViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(), 62, (Object) null);
        this.eventSubject = PublishSubject.k0();
    }
}

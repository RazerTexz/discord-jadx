package com.discord.widgets.user;

import android.content.Context;
import androidx.core.app.NotificationCompat;
import b.a.d.AppViewModel;
import b.d.b.a.outline;
import com.discord.api.guild.PruneCountResponse;
import com.discord.models.guild.Guild;
import com.discord.models.user.MeUser;
import com.discord.restapi.RestAPIParams;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StorePermissions;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUser;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeck4;
import com.discord.utilities.error.Error;
import com.discord.utilities.permissions.PermissionUtils;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import j0.k.Func1;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.Subscription;
import rx.functions.Action1;
import rx.subjects.PublishSubject;

/* compiled from: WidgetPruneUsersViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 32\b\u0012\u0004\u0012\u00020\u00020\u0001:\u000534567BG\u0012\u0006\u0010\u001b\u001a\u00020\u001a\u0012\b\b\u0002\u0010!\u001a\u00020 \u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0017\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u001d\u0012\b\b\u0002\u0010$\u001a\u00020#\u0012\u000e\b\u0002\u00100\u001a\b\u0012\u0004\u0012\u00020/0\n¢\u0006\u0004\b1\u00102J\u000f\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\b\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\b\u0010\tJ\u0013\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\u0004\b\f\u0010\rJ\u0015\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0010\u0010\u0011J\r\u0010\u0012\u001a\u00020\u0003¢\u0006\u0004\b\u0012\u0010\u0005R\u0016\u0010\u0016\u001a\u00020\u00138B@\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0018\u001a\u00020\u00178\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001b\u001a\u00020\u001a8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010\u001e\u001a\u00020\u001d8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010!\u001a\u00020 8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010$\u001a\u00020#8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010&\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b&\u0010'R\u0018\u0010)\u001a\u0004\u0018\u00010(8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b)\u0010*R:\u0010-\u001a&\u0012\f\u0012\n ,*\u0004\u0018\u00010\u000b0\u000b ,*\u0012\u0012\f\u0012\n ,*\u0004\u0018\u00010\u000b0\u000b\u0018\u00010+0+8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b-\u0010.¨\u00068"}, d2 = {"Lcom/discord/widgets/user/WidgetPruneUsersViewModel;", "Lb/a/d/d0;", "Lcom/discord/widgets/user/WidgetPruneUsersViewModel$ViewState;", "", "getUpdatedPruneCount", "()V", "", "inProgress", "pruneInProgress", "(Z)V", "Lrx/Observable;", "Lcom/discord/widgets/user/WidgetPruneUsersViewModel$Event;", "observeEvents", "()Lrx/Observable;", "Lcom/discord/widgets/user/WidgetPruneUsersViewModel$PruneDays;", "days", "pruneDaysSelected", "(Lcom/discord/widgets/user/WidgetPruneUsersViewModel$PruneDays;)V", "pruneClicked", "Lcom/discord/widgets/user/WidgetPruneUsersViewModel$ViewState$Loading;", "getLoadingState", "()Lcom/discord/widgets/user/WidgetPruneUsersViewModel$ViewState$Loading;", "loadingState", "Lcom/discord/stores/StoreUser;", "storeUsers", "Lcom/discord/stores/StoreUser;", "", "guildId", "J", "", "guildName", "Ljava/lang/String;", "Lcom/discord/stores/StoreGuilds;", "storeGuilds", "Lcom/discord/stores/StoreGuilds;", "Lcom/discord/utilities/rest/RestAPI;", "restAPI", "Lcom/discord/utilities/rest/RestAPI;", "whichPruneDays", "Lcom/discord/widgets/user/WidgetPruneUsersViewModel$PruneDays;", "Lrx/Subscription;", "pruneCountRequest", "Lrx/Subscription;", "Lrx/subjects/PublishSubject;", "kotlin.jvm.PlatformType", "eventSubject", "Lrx/subjects/PublishSubject;", "Lcom/discord/widgets/user/WidgetPruneUsersViewModel$StoreData;", "storeDataObservable", "<init>", "(JLcom/discord/stores/StoreGuilds;Lcom/discord/stores/StoreUser;Ljava/lang/String;Lcom/discord/utilities/rest/RestAPI;Lrx/Observable;)V", "Companion", "Event", "PruneDays", "StoreData", "ViewState", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final class WidgetPruneUsersViewModel extends AppViewModel<ViewState> {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final PruneDays DEFAULT_DAYS = PruneDays.Thirty;
    private final PublishSubject<Event> eventSubject;
    private final long guildId;
    private final String guildName;
    private Subscription pruneCountRequest;
    private final RestAPI restAPI;
    private final StoreGuilds storeGuilds;
    private final StoreUser storeUsers;
    private PruneDays whichPruneDays;

    /* compiled from: WidgetPruneUsersViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\u0006\u001a\n \u0001*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/discord/widgets/user/WidgetPruneUsersViewModel$StoreData;", "kotlin.jvm.PlatformType", "storeData", "", NotificationCompat.CATEGORY_CALL, "(Lcom/discord/widgets/user/WidgetPruneUsersViewModel$StoreData;)Ljava/lang/Boolean;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.user.WidgetPruneUsersViewModel$1, reason: invalid class name */
    public static final class AnonymousClass1<T, R> implements Func1<StoreData, Boolean> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        @Override // j0.k.Func1
        public /* bridge */ /* synthetic */ Boolean call(StoreData storeData) {
            return call2(storeData);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final Boolean call2(StoreData storeData) {
            return Boolean.valueOf((storeData.getPermission() == null || storeData.getUser() == null || storeData.getGuild() == null || !PermissionUtils.canAndIsElevated(2L, storeData.getPermission(), storeData.getUser().getMfaEnabled(), storeData.getGuild().getMfaLevel())) ? false : true);
        }
    }

    /* compiled from: WidgetPruneUsersViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "kotlin.jvm.PlatformType", "canKick", "", "invoke", "(Ljava/lang/Boolean;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.user.WidgetPruneUsersViewModel$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function1<Boolean, Unit> {
        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
            invoke2(bool);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Boolean bool) {
            Intrinsics3.checkNotNullExpressionValue(bool, "canKick");
            if (bool.booleanValue()) {
                WidgetPruneUsersViewModel.access$getUpdatedPruneCount(WidgetPruneUsersViewModel.this);
            } else {
                WidgetPruneUsersViewModel.access$updateViewState(WidgetPruneUsersViewModel.this, new ViewState.LoadFailed(true));
            }
        }
    }

    /* compiled from: WidgetPruneUsersViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0014\u0010\u0015J?\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0012\u001a\u00020\u00118\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013¨\u0006\u0016"}, d2 = {"Lcom/discord/widgets/user/WidgetPruneUsersViewModel$Companion;", "", "", "Lcom/discord/primitives/GuildId;", "guildId", "Lcom/discord/stores/updates/ObservationDeck;", "observationDeck", "Lcom/discord/stores/StorePermissions;", "storePermissions", "Lcom/discord/stores/StoreGuilds;", "storeGuilds", "Lcom/discord/stores/StoreUser;", "storeUsers", "Lrx/Observable;", "Lcom/discord/widgets/user/WidgetPruneUsersViewModel$StoreData;", "observeStoreState", "(JLcom/discord/stores/updates/ObservationDeck;Lcom/discord/stores/StorePermissions;Lcom/discord/stores/StoreGuilds;Lcom/discord/stores/StoreUser;)Lrx/Observable;", "Lcom/discord/widgets/user/WidgetPruneUsersViewModel$PruneDays;", "DEFAULT_DAYS", "Lcom/discord/widgets/user/WidgetPruneUsersViewModel$PruneDays;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public final Observable<StoreData> observeStoreState(long guildId, ObservationDeck observationDeck, StorePermissions storePermissions, StoreGuilds storeGuilds, StoreUser storeUsers) {
            Intrinsics3.checkNotNullParameter(observationDeck, "observationDeck");
            Intrinsics3.checkNotNullParameter(storePermissions, "storePermissions");
            Intrinsics3.checkNotNullParameter(storeGuilds, "storeGuilds");
            Intrinsics3.checkNotNullParameter(storeUsers, "storeUsers");
            return ObservationDeck.connectRx$default(observationDeck, new ObservationDeck.UpdateSource[]{storePermissions, storeGuilds, storeUsers}, false, null, null, new WidgetPruneUsersViewModel2(storePermissions, guildId, storeGuilds, storeUsers), 14, null);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetPruneUsersViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0002\u0006\u0007¨\u0006\b"}, d2 = {"Lcom/discord/widgets/user/WidgetPruneUsersViewModel$Event;", "", "<init>", "()V", "Dismiss", "RestClientFailed", "Lcom/discord/widgets/user/WidgetPruneUsersViewModel$Event$Dismiss;", "Lcom/discord/widgets/user/WidgetPruneUsersViewModel$Event$RestClientFailed;", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static abstract class Event {

        /* compiled from: WidgetPruneUsersViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/widgets/user/WidgetPruneUsersViewModel$Event$Dismiss;", "Lcom/discord/widgets/user/WidgetPruneUsersViewModel$Event;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class Dismiss extends Event {
            public static final Dismiss INSTANCE = new Dismiss();

            private Dismiss() {
                super(null);
            }
        }

        /* compiled from: WidgetPruneUsersViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u0019\u0010\u0005\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0013\u001a\u0004\b\u0014\u0010\u0004¨\u0006\u0017"}, d2 = {"Lcom/discord/widgets/user/WidgetPruneUsersViewModel$Event$RestClientFailed;", "Lcom/discord/widgets/user/WidgetPruneUsersViewModel$Event;", "", "component1", "()Ljava/lang/Throwable;", "throwable", "copy", "(Ljava/lang/Throwable;)Lcom/discord/widgets/user/WidgetPruneUsersViewModel$Event$RestClientFailed;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/Throwable;", "getThrowable", "<init>", "(Ljava/lang/Throwable;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final /* data */ class RestClientFailed extends Event {
            private final Throwable throwable;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public RestClientFailed(Throwable th) {
                super(null);
                Intrinsics3.checkNotNullParameter(th, "throwable");
                this.throwable = th;
            }

            public static /* synthetic */ RestClientFailed copy$default(RestClientFailed restClientFailed, Throwable th, int i, Object obj) {
                if ((i & 1) != 0) {
                    th = restClientFailed.throwable;
                }
                return restClientFailed.copy(th);
            }

            /* renamed from: component1, reason: from getter */
            public final Throwable getThrowable() {
                return this.throwable;
            }

            public final RestClientFailed copy(Throwable throwable) {
                Intrinsics3.checkNotNullParameter(throwable, "throwable");
                return new RestClientFailed(throwable);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof RestClientFailed) && Intrinsics3.areEqual(this.throwable, ((RestClientFailed) other).throwable);
                }
                return true;
            }

            public final Throwable getThrowable() {
                return this.throwable;
            }

            public int hashCode() {
                Throwable th = this.throwable;
                if (th != null) {
                    return th.hashCode();
                }
                return 0;
            }

            public String toString() {
                StringBuilder sbU = outline.U("RestClientFailed(throwable=");
                sbU.append(this.throwable);
                sbU.append(")");
                return sbU.toString();
            }
        }

        private Event() {
        }

        public /* synthetic */ Event(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetPruneUsersViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0019\u0010\u0003\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/discord/widgets/user/WidgetPruneUsersViewModel$PruneDays;", "", "", "count", "I", "getCount", "()I", "<init>", "(Ljava/lang/String;II)V", "Seven", "Thirty", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public enum PruneDays {
        Seven(7),
        Thirty(30);

        private final int count;

        PruneDays(int i) {
            this.count = i;
        }

        public final int getCount() {
            return this.count;
        }
    }

    /* compiled from: WidgetPruneUsersViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\u000e\u0010\f\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u0003\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b!\u0010\"J\u0018\u0010\u0004\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u0003HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0012\u0010\n\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ:\u0010\u000f\u001a\u00020\u00002\u0010\b\u0002\u0010\f\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\tHÆ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0012\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0015\u001a\u00020\u0014HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u001a\u0010\u0019\u001a\u00020\u00182\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0019\u0010\u001aR\u001b\u0010\u000e\u001a\u0004\u0018\u00010\t8\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u001b\u001a\u0004\b\u001c\u0010\u000bR\u001b\u0010\r\u001a\u0004\u0018\u00010\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u001d\u001a\u0004\b\u001e\u0010\bR!\u0010\f\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u00038\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\u001f\u001a\u0004\b \u0010\u0005¨\u0006#"}, d2 = {"Lcom/discord/widgets/user/WidgetPruneUsersViewModel$StoreData;", "", "", "Lcom/discord/api/permission/PermissionBit;", "component1", "()Ljava/lang/Long;", "Lcom/discord/models/guild/Guild;", "component2", "()Lcom/discord/models/guild/Guild;", "Lcom/discord/models/user/MeUser;", "component3", "()Lcom/discord/models/user/MeUser;", "permission", "guild", "user", "copy", "(Ljava/lang/Long;Lcom/discord/models/guild/Guild;Lcom/discord/models/user/MeUser;)Lcom/discord/widgets/user/WidgetPruneUsersViewModel$StoreData;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/discord/models/user/MeUser;", "getUser", "Lcom/discord/models/guild/Guild;", "getGuild", "Ljava/lang/Long;", "getPermission", "<init>", "(Ljava/lang/Long;Lcom/discord/models/guild/Guild;Lcom/discord/models/user/MeUser;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class StoreData {
        private final Guild guild;
        private final Long permission;
        private final MeUser user;

        public StoreData(Long l, Guild guild, MeUser meUser) {
            this.permission = l;
            this.guild = guild;
            this.user = meUser;
        }

        public static /* synthetic */ StoreData copy$default(StoreData storeData, Long l, Guild guild, MeUser meUser, int i, Object obj) {
            if ((i & 1) != 0) {
                l = storeData.permission;
            }
            if ((i & 2) != 0) {
                guild = storeData.guild;
            }
            if ((i & 4) != 0) {
                meUser = storeData.user;
            }
            return storeData.copy(l, guild, meUser);
        }

        /* renamed from: component1, reason: from getter */
        public final Long getPermission() {
            return this.permission;
        }

        /* renamed from: component2, reason: from getter */
        public final Guild getGuild() {
            return this.guild;
        }

        /* renamed from: component3, reason: from getter */
        public final MeUser getUser() {
            return this.user;
        }

        public final StoreData copy(Long permission, Guild guild, MeUser user) {
            return new StoreData(permission, guild, user);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof StoreData)) {
                return false;
            }
            StoreData storeData = (StoreData) other;
            return Intrinsics3.areEqual(this.permission, storeData.permission) && Intrinsics3.areEqual(this.guild, storeData.guild) && Intrinsics3.areEqual(this.user, storeData.user);
        }

        public final Guild getGuild() {
            return this.guild;
        }

        public final Long getPermission() {
            return this.permission;
        }

        public final MeUser getUser() {
            return this.user;
        }

        public int hashCode() {
            Long l = this.permission;
            int iHashCode = (l != null ? l.hashCode() : 0) * 31;
            Guild guild = this.guild;
            int iHashCode2 = (iHashCode + (guild != null ? guild.hashCode() : 0)) * 31;
            MeUser meUser = this.user;
            return iHashCode2 + (meUser != null ? meUser.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = outline.U("StoreData(permission=");
            sbU.append(this.permission);
            sbU.append(", guild=");
            sbU.append(this.guild);
            sbU.append(", user=");
            sbU.append(this.user);
            sbU.append(")");
            return sbU.toString();
        }
    }

    /* compiled from: WidgetPruneUsersViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0003\u0007\b\t¨\u0006\n"}, d2 = {"Lcom/discord/widgets/user/WidgetPruneUsersViewModel$ViewState;", "", "<init>", "()V", "LoadFailed", "Loaded", "Loading", "Lcom/discord/widgets/user/WidgetPruneUsersViewModel$ViewState$Loading;", "Lcom/discord/widgets/user/WidgetPruneUsersViewModel$ViewState$Loaded;", "Lcom/discord/widgets/user/WidgetPruneUsersViewModel$ViewState$LoadFailed;", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static abstract class ViewState {

        /* compiled from: WidgetPruneUsersViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0010\u001a\u00020\u00022\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011R\u0019\u0010\u0005\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0012\u001a\u0004\b\u0013\u0010\u0004¨\u0006\u0016"}, d2 = {"Lcom/discord/widgets/user/WidgetPruneUsersViewModel$ViewState$LoadFailed;", "Lcom/discord/widgets/user/WidgetPruneUsersViewModel$ViewState;", "", "component1", "()Z", "dismiss", "copy", "(Z)Lcom/discord/widgets/user/WidgetPruneUsersViewModel$ViewState$LoadFailed;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "Z", "getDismiss", "<init>", "(Z)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final /* data */ class LoadFailed extends ViewState {
            private final boolean dismiss;

            public LoadFailed(boolean z2) {
                super(null);
                this.dismiss = z2;
            }

            public static /* synthetic */ LoadFailed copy$default(LoadFailed loadFailed, boolean z2, int i, Object obj) {
                if ((i & 1) != 0) {
                    z2 = loadFailed.dismiss;
                }
                return loadFailed.copy(z2);
            }

            /* renamed from: component1, reason: from getter */
            public final boolean getDismiss() {
                return this.dismiss;
            }

            public final LoadFailed copy(boolean dismiss) {
                return new LoadFailed(dismiss);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof LoadFailed) && this.dismiss == ((LoadFailed) other).dismiss;
                }
                return true;
            }

            public final boolean getDismiss() {
                return this.dismiss;
            }

            public int hashCode() {
                boolean z2 = this.dismiss;
                if (z2) {
                    return 1;
                }
                return z2 ? 1 : 0;
            }

            public String toString() {
                return outline.O(outline.U("LoadFailed(dismiss="), this.dismiss, ")");
            }
        }

        /* compiled from: WidgetPruneUsersViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u000b\u001a\u00020\u0005\u0012\u0006\u0010\f\u001a\u00020\b\u0012\b\b\u0002\u0010\r\u001a\u00020\u0002¢\u0006\u0004\b\u001f\u0010 J\u0010\u0010\u0003\u001a\u00020\u0002HÂ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ.\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u000b\u001a\u00020\u00052\b\b\u0002\u0010\f\u001a\u00020\b2\b\b\u0002\u0010\r\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\u0013\u0010\nJ\u001a\u0010\u0016\u001a\u00020\u00022\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014HÖ\u0003¢\u0006\u0004\b\u0016\u0010\u0017R\u0016\u0010\r\u001a\u00020\u00028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u0018R\u0013\u0010\u001a\u001a\u00020\u00028F@\u0006¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u0004R\u0019\u0010\f\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\u001b\u001a\u0004\b\u001c\u0010\nR\u0019\u0010\u000b\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u001d\u001a\u0004\b\u001e\u0010\u0007¨\u0006!"}, d2 = {"Lcom/discord/widgets/user/WidgetPruneUsersViewModel$ViewState$Loaded;", "Lcom/discord/widgets/user/WidgetPruneUsersViewModel$ViewState;", "", "component3", "()Z", "Lcom/discord/widgets/user/WidgetPruneUsersViewModel$PruneDays;", "component1", "()Lcom/discord/widgets/user/WidgetPruneUsersViewModel$PruneDays;", "", "component2", "()I", "pruneDays", "pruneCount", "pruneInProgress", "copy", "(Lcom/discord/widgets/user/WidgetPruneUsersViewModel$PruneDays;IZ)Lcom/discord/widgets/user/WidgetPruneUsersViewModel$ViewState$Loaded;", "", "toString", "()Ljava/lang/String;", "hashCode", "", "other", "equals", "(Ljava/lang/Object;)Z", "Z", "getPruneButtonEnabled", "pruneButtonEnabled", "I", "getPruneCount", "Lcom/discord/widgets/user/WidgetPruneUsersViewModel$PruneDays;", "getPruneDays", "<init>", "(Lcom/discord/widgets/user/WidgetPruneUsersViewModel$PruneDays;IZ)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final /* data */ class Loaded extends ViewState {
            private final int pruneCount;
            private final PruneDays pruneDays;
            private final boolean pruneInProgress;

            public /* synthetic */ Loaded(PruneDays pruneDays, int i, boolean z2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
                this(pruneDays, i, (i2 & 4) != 0 ? false : z2);
            }

            /* renamed from: component3, reason: from getter */
            private final boolean getPruneInProgress() {
                return this.pruneInProgress;
            }

            public static /* synthetic */ Loaded copy$default(Loaded loaded, PruneDays pruneDays, int i, boolean z2, int i2, Object obj) {
                if ((i2 & 1) != 0) {
                    pruneDays = loaded.pruneDays;
                }
                if ((i2 & 2) != 0) {
                    i = loaded.pruneCount;
                }
                if ((i2 & 4) != 0) {
                    z2 = loaded.pruneInProgress;
                }
                return loaded.copy(pruneDays, i, z2);
            }

            /* renamed from: component1, reason: from getter */
            public final PruneDays getPruneDays() {
                return this.pruneDays;
            }

            /* renamed from: component2, reason: from getter */
            public final int getPruneCount() {
                return this.pruneCount;
            }

            public final Loaded copy(PruneDays pruneDays, int pruneCount, boolean pruneInProgress) {
                Intrinsics3.checkNotNullParameter(pruneDays, "pruneDays");
                return new Loaded(pruneDays, pruneCount, pruneInProgress);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Loaded)) {
                    return false;
                }
                Loaded loaded = (Loaded) other;
                return Intrinsics3.areEqual(this.pruneDays, loaded.pruneDays) && this.pruneCount == loaded.pruneCount && this.pruneInProgress == loaded.pruneInProgress;
            }

            public final boolean getPruneButtonEnabled() {
                return this.pruneCount > 0 && !this.pruneInProgress;
            }

            public final int getPruneCount() {
                return this.pruneCount;
            }

            public final PruneDays getPruneDays() {
                return this.pruneDays;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public int hashCode() {
                PruneDays pruneDays = this.pruneDays;
                int iHashCode = (((pruneDays != null ? pruneDays.hashCode() : 0) * 31) + this.pruneCount) * 31;
                boolean z2 = this.pruneInProgress;
                int i = z2;
                if (z2 != 0) {
                    i = 1;
                }
                return iHashCode + i;
            }

            public String toString() {
                StringBuilder sbU = outline.U("Loaded(pruneDays=");
                sbU.append(this.pruneDays);
                sbU.append(", pruneCount=");
                sbU.append(this.pruneCount);
                sbU.append(", pruneInProgress=");
                return outline.O(sbU, this.pruneInProgress, ")");
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Loaded(PruneDays pruneDays, int i, boolean z2) {
                super(null);
                Intrinsics3.checkNotNullParameter(pruneDays, "pruneDays");
                this.pruneDays = pruneDays;
                this.pruneCount = i;
                this.pruneInProgress = z2;
            }
        }

        /* compiled from: WidgetPruneUsersViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J$\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\f\u0010\u0007J\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014R\u0019\u0010\t\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\u0015\u001a\u0004\b\u0016\u0010\u0007R\u0019\u0010\b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\u0017\u001a\u0004\b\u0018\u0010\u0004¨\u0006\u001b"}, d2 = {"Lcom/discord/widgets/user/WidgetPruneUsersViewModel$ViewState$Loading;", "Lcom/discord/widgets/user/WidgetPruneUsersViewModel$ViewState;", "Lcom/discord/widgets/user/WidgetPruneUsersViewModel$PruneDays;", "component1", "()Lcom/discord/widgets/user/WidgetPruneUsersViewModel$PruneDays;", "", "component2", "()Ljava/lang/String;", "whichPruneDays", "guildName", "copy", "(Lcom/discord/widgets/user/WidgetPruneUsersViewModel$PruneDays;Ljava/lang/String;)Lcom/discord/widgets/user/WidgetPruneUsersViewModel$ViewState$Loading;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getGuildName", "Lcom/discord/widgets/user/WidgetPruneUsersViewModel$PruneDays;", "getWhichPruneDays", "<init>", "(Lcom/discord/widgets/user/WidgetPruneUsersViewModel$PruneDays;Ljava/lang/String;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final /* data */ class Loading extends ViewState {
            private final String guildName;
            private final PruneDays whichPruneDays;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Loading(PruneDays pruneDays, String str) {
                super(null);
                Intrinsics3.checkNotNullParameter(pruneDays, "whichPruneDays");
                Intrinsics3.checkNotNullParameter(str, "guildName");
                this.whichPruneDays = pruneDays;
                this.guildName = str;
            }

            public static /* synthetic */ Loading copy$default(Loading loading, PruneDays pruneDays, String str, int i, Object obj) {
                if ((i & 1) != 0) {
                    pruneDays = loading.whichPruneDays;
                }
                if ((i & 2) != 0) {
                    str = loading.guildName;
                }
                return loading.copy(pruneDays, str);
            }

            /* renamed from: component1, reason: from getter */
            public final PruneDays getWhichPruneDays() {
                return this.whichPruneDays;
            }

            /* renamed from: component2, reason: from getter */
            public final String getGuildName() {
                return this.guildName;
            }

            public final Loading copy(PruneDays whichPruneDays, String guildName) {
                Intrinsics3.checkNotNullParameter(whichPruneDays, "whichPruneDays");
                Intrinsics3.checkNotNullParameter(guildName, "guildName");
                return new Loading(whichPruneDays, guildName);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Loading)) {
                    return false;
                }
                Loading loading = (Loading) other;
                return Intrinsics3.areEqual(this.whichPruneDays, loading.whichPruneDays) && Intrinsics3.areEqual(this.guildName, loading.guildName);
            }

            public final String getGuildName() {
                return this.guildName;
            }

            public final PruneDays getWhichPruneDays() {
                return this.whichPruneDays;
            }

            public int hashCode() {
                PruneDays pruneDays = this.whichPruneDays;
                int iHashCode = (pruneDays != null ? pruneDays.hashCode() : 0) * 31;
                String str = this.guildName;
                return iHashCode + (str != null ? str.hashCode() : 0);
            }

            public String toString() {
                StringBuilder sbU = outline.U("Loading(whichPruneDays=");
                sbU.append(this.whichPruneDays);
                sbU.append(", guildName=");
                return outline.J(sbU, this.guildName, ")");
            }
        }

        private ViewState() {
        }

        public /* synthetic */ ViewState(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetPruneUsersViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u0010\u0006\u001a\n \u0001*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/discord/api/guild/PruneCountResponse;", "kotlin.jvm.PlatformType", "response", "", NotificationCompat.CATEGORY_CALL, "(Lcom/discord/api/guild/PruneCountResponse;)Ljava/lang/Integer;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.user.WidgetPruneUsersViewModel$getUpdatedPruneCount$1, reason: invalid class name */
    public static final class AnonymousClass1<T, R> implements Func1<PruneCountResponse, Integer> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        @Override // j0.k.Func1
        public /* bridge */ /* synthetic */ Integer call(PruneCountResponse pruneCountResponse) {
            return call2(pruneCountResponse);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final Integer call2(PruneCountResponse pruneCountResponse) {
            return Integer.valueOf(pruneCountResponse.getPruned());
        }
    }

    /* compiled from: WidgetPruneUsersViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0006\u001a\n \u0001*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "kotlin.jvm.PlatformType", "count", "Lcom/discord/widgets/user/WidgetPruneUsersViewModel$ViewState;", NotificationCompat.CATEGORY_CALL, "(Ljava/lang/Integer;)Lcom/discord/widgets/user/WidgetPruneUsersViewModel$ViewState;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.user.WidgetPruneUsersViewModel$getUpdatedPruneCount$2, reason: invalid class name */
    public static final class AnonymousClass2<T, R> implements Func1<Integer, ViewState> {
        public AnonymousClass2() {
        }

        @Override // j0.k.Func1
        public /* bridge */ /* synthetic */ ViewState call(Integer num) {
            return call2(num);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final ViewState call2(Integer num) {
            PruneDays pruneDaysAccess$getWhichPruneDays$p = WidgetPruneUsersViewModel.access$getWhichPruneDays$p(WidgetPruneUsersViewModel.this);
            Intrinsics3.checkNotNullExpressionValue(num, "count");
            return new ViewState.Loaded(pruneDaysAccess$getWhichPruneDays$p, num.intValue(), false, 4, null);
        }
    }

    /* compiled from: WidgetPruneUsersViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "kotlin.jvm.PlatformType", "it", "", NotificationCompat.CATEGORY_CALL, "(Ljava/lang/Throwable;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.user.WidgetPruneUsersViewModel$getUpdatedPruneCount$3, reason: invalid class name */
    public static final class AnonymousClass3<T> implements Action1<Throwable> {
        public AnonymousClass3() {
        }

        @Override // rx.functions.Action1
        public /* bridge */ /* synthetic */ void call(Throwable th) {
            call2(th);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final void call2(Throwable th) {
            PublishSubject publishSubjectAccess$getEventSubject$p = WidgetPruneUsersViewModel.access$getEventSubject$p(WidgetPruneUsersViewModel.this);
            Intrinsics3.checkNotNullExpressionValue(th, "it");
            publishSubjectAccess$getEventSubject$p.k.onNext(new Event.RestClientFailed(th));
        }
    }

    /* compiled from: WidgetPruneUsersViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0006\u001a\n \u0001*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "kotlin.jvm.PlatformType", "it", "Lcom/discord/widgets/user/WidgetPruneUsersViewModel$ViewState;", NotificationCompat.CATEGORY_CALL, "(Ljava/lang/Throwable;)Lcom/discord/widgets/user/WidgetPruneUsersViewModel$ViewState;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.user.WidgetPruneUsersViewModel$getUpdatedPruneCount$4, reason: invalid class name */
    public static final class AnonymousClass4<T, R> implements Func1<Throwable, ViewState> {
        public static final AnonymousClass4 INSTANCE = new AnonymousClass4();

        @Override // j0.k.Func1
        public /* bridge */ /* synthetic */ ViewState call(Throwable th) {
            return call2(th);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final ViewState call2(Throwable th) {
            return new ViewState.LoadFailed(false);
        }
    }

    /* compiled from: WidgetPruneUsersViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lrx/Subscription;", "request", "", "invoke", "(Lrx/Subscription;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.user.WidgetPruneUsersViewModel$getUpdatedPruneCount$5, reason: invalid class name */
    public static final class AnonymousClass5 extends Lambda implements Function1<Subscription, Unit> {
        public AnonymousClass5() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Subscription subscription) {
            invoke2(subscription);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Subscription subscription) {
            Intrinsics3.checkNotNullParameter(subscription, "request");
            Subscription subscriptionAccess$getPruneCountRequest$p = WidgetPruneUsersViewModel.access$getPruneCountRequest$p(WidgetPruneUsersViewModel.this);
            if (subscriptionAccess$getPruneCountRequest$p != null) {
                subscriptionAccess$getPruneCountRequest$p.unsubscribe();
            }
            WidgetPruneUsersViewModel.access$setPruneCountRequest$p(WidgetPruneUsersViewModel.this, subscription);
        }
    }

    /* compiled from: WidgetPruneUsersViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/widgets/user/WidgetPruneUsersViewModel$ViewState;", "p1", "", "invoke", "(Lcom/discord/widgets/user/WidgetPruneUsersViewModel$ViewState;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.user.WidgetPruneUsersViewModel$getUpdatedPruneCount$6, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass6 extends FunctionReferenceImpl implements Function1<ViewState, Unit> {
        public AnonymousClass6(WidgetPruneUsersViewModel widgetPruneUsersViewModel) {
            super(1, widgetPruneUsersViewModel, WidgetPruneUsersViewModel.class, "updateViewState", "updateViewState(Ljava/lang/Object;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ViewState viewState) {
            invoke2(viewState);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ViewState viewState) {
            Intrinsics3.checkNotNullParameter(viewState, "p1");
            WidgetPruneUsersViewModel.access$updateViewState((WidgetPruneUsersViewModel) this.receiver, viewState);
        }
    }

    /* compiled from: WidgetPruneUsersViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Ljava/lang/Void;", "it", "", "invoke", "(Ljava/lang/Void;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.user.WidgetPruneUsersViewModel$pruneClicked$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<Void, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Void r1) {
            invoke2(r1);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Void r2) {
            PublishSubject publishSubjectAccess$getEventSubject$p = WidgetPruneUsersViewModel.access$getEventSubject$p(WidgetPruneUsersViewModel.this);
            publishSubjectAccess$getEventSubject$p.k.onNext(Event.Dismiss.INSTANCE);
        }
    }

    /* compiled from: WidgetPruneUsersViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.user.WidgetPruneUsersViewModel$pruneClicked$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function0<Unit> {
        public AnonymousClass2() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            WidgetPruneUsersViewModel.access$pruneInProgress(WidgetPruneUsersViewModel.this, false);
        }
    }

    /* compiled from: WidgetPruneUsersViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/utilities/error/Error;", "it", "", "invoke", "(Lcom/discord/utilities/error/Error;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.user.WidgetPruneUsersViewModel$pruneClicked$3, reason: invalid class name */
    public static final class AnonymousClass3 extends Lambda implements Function1<Error, Unit> {
        public AnonymousClass3() {
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
            PublishSubject publishSubjectAccess$getEventSubject$p = WidgetPruneUsersViewModel.access$getEventSubject$p(WidgetPruneUsersViewModel.this);
            Throwable throwable = error.getThrowable();
            Intrinsics3.checkNotNullExpressionValue(throwable, "it.throwable");
            publishSubjectAccess$getEventSubject$p.k.onNext(new Event.RestClientFailed(throwable));
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ WidgetPruneUsersViewModel(long j, StoreGuilds storeGuilds, StoreUser storeUser, String str, RestAPI restAPI, Observable observable, int i, DefaultConstructorMarker defaultConstructorMarker) {
        String str2;
        Observable observableObserveStoreState;
        StoreGuilds guilds = (i & 2) != 0 ? StoreStream.INSTANCE.getGuilds() : storeGuilds;
        StoreUser users = (i & 4) != 0 ? StoreStream.INSTANCE.getUsers() : storeUser;
        if ((i & 8) != 0) {
            Guild guild = guilds.getGuilds().get(Long.valueOf(j));
            String name = guild != null ? guild.getName() : null;
            str2 = name == null ? "" : name;
        } else {
            str2 = str;
        }
        RestAPI api = (i & 16) != 0 ? RestAPI.INSTANCE.getApi() : restAPI;
        if ((i & 32) != 0) {
            Companion companion = INSTANCE;
            ObservationDeck observationDeck = ObservationDeck4.get();
            StoreStream.Companion companion2 = StoreStream.INSTANCE;
            observableObserveStoreState = companion.observeStoreState(j, observationDeck, companion2.getPermissions(), companion2.getGuilds(), users);
        } else {
            observableObserveStoreState = observable;
        }
        this(j, guilds, users, str2, api, observableObserveStoreState);
    }

    public static final /* synthetic */ PublishSubject access$getEventSubject$p(WidgetPruneUsersViewModel widgetPruneUsersViewModel) {
        return widgetPruneUsersViewModel.eventSubject;
    }

    public static final /* synthetic */ Subscription access$getPruneCountRequest$p(WidgetPruneUsersViewModel widgetPruneUsersViewModel) {
        return widgetPruneUsersViewModel.pruneCountRequest;
    }

    public static final /* synthetic */ void access$getUpdatedPruneCount(WidgetPruneUsersViewModel widgetPruneUsersViewModel) {
        widgetPruneUsersViewModel.getUpdatedPruneCount();
    }

    public static final /* synthetic */ PruneDays access$getWhichPruneDays$p(WidgetPruneUsersViewModel widgetPruneUsersViewModel) {
        return widgetPruneUsersViewModel.whichPruneDays;
    }

    public static final /* synthetic */ void access$pruneInProgress(WidgetPruneUsersViewModel widgetPruneUsersViewModel, boolean z2) {
        widgetPruneUsersViewModel.pruneInProgress(z2);
    }

    public static final /* synthetic */ void access$setPruneCountRequest$p(WidgetPruneUsersViewModel widgetPruneUsersViewModel, Subscription subscription) {
        widgetPruneUsersViewModel.pruneCountRequest = subscription;
    }

    public static final /* synthetic */ void access$setWhichPruneDays$p(WidgetPruneUsersViewModel widgetPruneUsersViewModel, PruneDays pruneDays) {
        widgetPruneUsersViewModel.whichPruneDays = pruneDays;
    }

    public static final /* synthetic */ void access$updateViewState(WidgetPruneUsersViewModel widgetPruneUsersViewModel, ViewState viewState) {
        widgetPruneUsersViewModel.updateViewState(viewState);
    }

    private final ViewState.Loading getLoadingState() {
        return new ViewState.Loading(this.whichPruneDays, this.guildName);
    }

    private final void getUpdatedPruneCount() {
        updateViewState(getLoadingState());
        Observable observableM = ObservableExtensionsKt.restSubscribeOn$default(this.restAPI.getPruneCount(this.guildId, this.whichPruneDays.getCount()), false, 1, null).G(AnonymousClass1.INSTANCE).G(new AnonymousClass2()).t(new AnonymousClass3()).M(AnonymousClass4.INSTANCE);
        Intrinsics3.checkNotNullExpressionValue(observableM, "restAPI.getPruneCount(gu…Failed(dismiss = false) }");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(observableM, this, null, 2, null), WidgetPruneUsersViewModel.class, (Context) null, new AnonymousClass5(), (Function1) null, (Function0) null, (Function0) null, new AnonymousClass6(this), 58, (Object) null);
    }

    private final void pruneInProgress(boolean inProgress) {
        ViewState.Loaded loadedCopy$default;
        ViewState viewState = getViewState();
        if (!(viewState instanceof ViewState.Loaded)) {
            viewState = null;
        }
        ViewState.Loaded loaded = (ViewState.Loaded) viewState;
        if (loaded == null || (loadedCopy$default = ViewState.Loaded.copy$default(loaded, null, 0, inProgress, 3, null)) == null) {
            return;
        }
        updateViewState(loadedCopy$default);
    }

    public final Observable<Event> observeEvents() {
        PublishSubject<Event> publishSubject = this.eventSubject;
        Intrinsics3.checkNotNullExpressionValue(publishSubject, "eventSubject");
        return publishSubject;
    }

    public final void pruneClicked() {
        pruneInProgress(true);
        Observable observableUi$default = ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(this.restAPI.pruneMembers(this.guildId, new RestAPIParams.PruneGuild(Integer.valueOf(this.whichPruneDays.getCount()), Boolean.FALSE)), false, 1, null), this, null, 2, null);
        AnonymousClass1 anonymousClass1 = new AnonymousClass1();
        ObservableExtensionsKt.appSubscribe$default(observableUi$default, WidgetPruneUsersViewModel.class, (Context) null, (Function1) null, new AnonymousClass3(), (Function0) null, new AnonymousClass2(), anonymousClass1, 22, (Object) null);
    }

    public final void pruneDaysSelected(PruneDays days) {
        Intrinsics3.checkNotNullParameter(days, "days");
        this.whichPruneDays = days;
        getUpdatedPruneCount();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetPruneUsersViewModel(long j, StoreGuilds storeGuilds, StoreUser storeUser, String str, RestAPI restAPI, Observable<StoreData> observable) {
        super(new ViewState.Loading(DEFAULT_DAYS, str));
        Intrinsics3.checkNotNullParameter(storeGuilds, "storeGuilds");
        Intrinsics3.checkNotNullParameter(storeUser, "storeUsers");
        Intrinsics3.checkNotNullParameter(str, "guildName");
        Intrinsics3.checkNotNullParameter(restAPI, "restAPI");
        Intrinsics3.checkNotNullParameter(observable, "storeDataObservable");
        this.guildId = j;
        this.storeGuilds = storeGuilds;
        this.storeUsers = storeUser;
        this.guildName = str;
        this.restAPI = restAPI;
        this.eventSubject = PublishSubject.k0();
        ViewState viewState = getViewState();
        Objects.requireNonNull(viewState, "null cannot be cast to non-null type com.discord.widgets.user.WidgetPruneUsersViewModel.ViewState.Loading");
        this.whichPruneDays = ((ViewState.Loading) viewState).getWhichPruneDays();
        Observable observableR = observable.G(AnonymousClass1.INSTANCE).r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "storeDataObservable\n    …  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(observableR), this, null, 2, null), WidgetPruneUsersViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass2(), 62, (Object) null);
    }
}

package com.discord.widgets.guilds;

import android.content.Context;
import b.a.d.AppViewModel;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.domain.ModelGuildFolder;
import com.discord.models.domain.ModelUserSettings;
import com.discord.restapi.RestAPIParams;
import com.discord.stores.StoreGuildsSorted;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUserSettings;
import com.discord.utilities.error.Error;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.t.Iterables2;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.subjects.PublishSubject;

/* compiled from: WidgetGuildFolderSettingsViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 82\b\u0012\u0004\u0012\u00020\u00020\u0001:\u000589:;<B'\u0012\n\u0010'\u001a\u00060%j\u0002`&\u0012\b\b\u0002\u0010!\u001a\u00020 \u0012\b\b\u0002\u00105\u001a\u000204¢\u0006\u0004\b6\u00107J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\n\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u000e\u0010\rJ\u001f\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0004\u001a\u00020\u000f2\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u0013\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013¢\u0006\u0004\b\u0015\u0010\u0016J\u0015\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u0017¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u001d\u001a\u00020\u00052\b\u0010\u001c\u001a\u0004\u0018\u00010\u001b¢\u0006\u0004\b\u001d\u0010\u001eJ\r\u0010\u001f\u001a\u00020\u0005¢\u0006\u0004\b\u001f\u0010\rR\u0019\u0010!\u001a\u00020 8\u0006@\u0006¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$R\u001d\u0010'\u001a\u00060%j\u0002`&8\u0006@\u0006¢\u0006\f\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*R$\u0010+\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.\"\u0004\b/\u0010\u0007R:\u00102\u001a&\u0012\f\u0012\n 1*\u0004\u0018\u00010\u00140\u0014 1*\u0012\u0012\f\u0012\n 1*\u0004\u0018\u00010\u00140\u0014\u0018\u000100008\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b2\u00103¨\u0006="}, d2 = {"Lcom/discord/widgets/guilds/WidgetGuildFolderSettingsViewModel;", "Lb/a/d/d0;", "Lcom/discord/widgets/guilds/WidgetGuildFolderSettingsViewModel$ViewState;", "Lcom/discord/widgets/guilds/WidgetGuildFolderSettingsViewModel$StoreState;", "storeState", "", "handleStoreState", "(Lcom/discord/widgets/guilds/WidgetGuildFolderSettingsViewModel$StoreState;)V", "Lcom/discord/widgets/guilds/WidgetGuildFolderSettingsViewModel$FormState;", "formState", "updateFormState", "(Lcom/discord/widgets/guilds/WidgetGuildFolderSettingsViewModel$FormState;)V", "emitUpdateSuccessEvent", "()V", "emitUpdateFailureEvent", "Lcom/discord/widgets/guilds/WidgetGuildFolderSettingsViewModel$StoreState$Valid;", "", "shouldShowSave", "(Lcom/discord/widgets/guilds/WidgetGuildFolderSettingsViewModel$StoreState$Valid;Lcom/discord/widgets/guilds/WidgetGuildFolderSettingsViewModel$FormState;)Z", "Lrx/Observable;", "Lcom/discord/widgets/guilds/WidgetGuildFolderSettingsViewModel$Event;", "observeEvents", "()Lrx/Observable;", "", ModelAuditLogEntry.CHANGE_KEY_NAME, "setName", "(Ljava/lang/String;)V", "", ModelAuditLogEntry.CHANGE_KEY_COLOR, "setColor", "(Ljava/lang/Integer;)V", "saveFolder", "Lcom/discord/stores/StoreUserSettings;", "storeUserSettings", "Lcom/discord/stores/StoreUserSettings;", "getStoreUserSettings", "()Lcom/discord/stores/StoreUserSettings;", "", "Lcom/discord/primitives/FolderId;", "folderId", "J", "getFolderId", "()J", "previousStoreState", "Lcom/discord/widgets/guilds/WidgetGuildFolderSettingsViewModel$StoreState;", "getPreviousStoreState", "()Lcom/discord/widgets/guilds/WidgetGuildFolderSettingsViewModel$StoreState;", "setPreviousStoreState", "Lrx/subjects/PublishSubject;", "kotlin.jvm.PlatformType", "eventSubject", "Lrx/subjects/PublishSubject;", "Lcom/discord/stores/StoreGuildsSorted;", "storeGuildsSorted", "<init>", "(JLcom/discord/stores/StoreUserSettings;Lcom/discord/stores/StoreGuildsSorted;)V", "Companion", "Event", "FormState", "StoreState", "ViewState", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetGuildFolderSettingsViewModel extends AppViewModel<ViewState> {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final PublishSubject<Event> eventSubject;
    private final long folderId;
    private StoreState previousStoreState;
    private final StoreUserSettings storeUserSettings;

    /* compiled from: WidgetGuildFolderSettingsViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/widgets/guilds/WidgetGuildFolderSettingsViewModel$StoreState;", "storeState", "", "invoke", "(Lcom/discord/widgets/guilds/WidgetGuildFolderSettingsViewModel$StoreState;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.guilds.WidgetGuildFolderSettingsViewModel$1, reason: invalid class name */
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
            WidgetGuildFolderSettingsViewModel.access$handleStoreState(WidgetGuildFolderSettingsViewModel.this, storeState);
        }
    }

    /* compiled from: WidgetGuildFolderSettingsViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\r\u0010\u000eJ1\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u000b\u0010\f¨\u0006\u000f"}, d2 = {"Lcom/discord/widgets/guilds/WidgetGuildFolderSettingsViewModel$Companion;", "", "", "Lcom/discord/primitives/FolderId;", "folderId", "Lcom/discord/stores/StoreUserSettings;", "storeUserSettings", "Lcom/discord/stores/StoreGuildsSorted;", "storeGuildsSorted", "Lrx/Observable;", "Lcom/discord/widgets/guilds/WidgetGuildFolderSettingsViewModel$StoreState;", "observeStoreState", "(JLcom/discord/stores/StoreUserSettings;Lcom/discord/stores/StoreGuildsSorted;)Lrx/Observable;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public static final /* synthetic */ Observable access$observeStoreState(Companion companion, long j, StoreUserSettings storeUserSettings, StoreGuildsSorted storeGuildsSorted) {
            return companion.observeStoreState(j, storeUserSettings, storeGuildsSorted);
        }

        private final Observable<StoreState> observeStoreState(long folderId, StoreUserSettings storeUserSettings, StoreGuildsSorted storeGuildsSorted) {
            Observable<StoreState> observableJ = Observable.j(storeUserSettings.observeGuildFolders(), storeGuildsSorted.observeEntries(), new WidgetGuildFolderSettingsViewModel2(folderId));
            Intrinsics3.checkNotNullExpressionValue(observableJ, "Observable.combineLatest…Guilds)\n        }\n      }");
            return observableJ;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetGuildFolderSettingsViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0002\u0006\u0007¨\u0006\b"}, d2 = {"Lcom/discord/widgets/guilds/WidgetGuildFolderSettingsViewModel$Event;", "", "<init>", "()V", "UpdateFolderSettingsFailure", "UpdateFolderSettingsSuccess", "Lcom/discord/widgets/guilds/WidgetGuildFolderSettingsViewModel$Event$UpdateFolderSettingsSuccess;", "Lcom/discord/widgets/guilds/WidgetGuildFolderSettingsViewModel$Event$UpdateFolderSettingsFailure;", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static abstract class Event {

        /* compiled from: WidgetGuildFolderSettingsViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000b\u0010\u0004J\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fHÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010R\u0019\u0010\u0005\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0011\u001a\u0004\b\u0012\u0010\u0004¨\u0006\u0015"}, d2 = {"Lcom/discord/widgets/guilds/WidgetGuildFolderSettingsViewModel$Event$UpdateFolderSettingsFailure;", "Lcom/discord/widgets/guilds/WidgetGuildFolderSettingsViewModel$Event;", "", "component1", "()I", "failureMessageStringRes", "copy", "(I)Lcom/discord/widgets/guilds/WidgetGuildFolderSettingsViewModel$Event$UpdateFolderSettingsFailure;", "", "toString", "()Ljava/lang/String;", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "I", "getFailureMessageStringRes", "<init>", "(I)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final /* data */ class UpdateFolderSettingsFailure extends Event {
            private final int failureMessageStringRes;

            public UpdateFolderSettingsFailure(int i) {
                super(null);
                this.failureMessageStringRes = i;
            }

            public static /* synthetic */ UpdateFolderSettingsFailure copy$default(UpdateFolderSettingsFailure updateFolderSettingsFailure, int i, int i2, Object obj) {
                if ((i2 & 1) != 0) {
                    i = updateFolderSettingsFailure.failureMessageStringRes;
                }
                return updateFolderSettingsFailure.copy(i);
            }

            /* renamed from: component1, reason: from getter */
            public final int getFailureMessageStringRes() {
                return this.failureMessageStringRes;
            }

            public final UpdateFolderSettingsFailure copy(int failureMessageStringRes) {
                return new UpdateFolderSettingsFailure(failureMessageStringRes);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof UpdateFolderSettingsFailure) && this.failureMessageStringRes == ((UpdateFolderSettingsFailure) other).failureMessageStringRes;
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
                return outline.B(outline.U("UpdateFolderSettingsFailure(failureMessageStringRes="), this.failureMessageStringRes, ")");
            }
        }

        /* compiled from: WidgetGuildFolderSettingsViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000b\u0010\u0004J\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fHÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010R\u0019\u0010\u0005\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0011\u001a\u0004\b\u0012\u0010\u0004¨\u0006\u0015"}, d2 = {"Lcom/discord/widgets/guilds/WidgetGuildFolderSettingsViewModel$Event$UpdateFolderSettingsSuccess;", "Lcom/discord/widgets/guilds/WidgetGuildFolderSettingsViewModel$Event;", "", "component1", "()I", "successMessageStringRes", "copy", "(I)Lcom/discord/widgets/guilds/WidgetGuildFolderSettingsViewModel$Event$UpdateFolderSettingsSuccess;", "", "toString", "()Ljava/lang/String;", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "I", "getSuccessMessageStringRes", "<init>", "(I)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final /* data */ class UpdateFolderSettingsSuccess extends Event {
            private final int successMessageStringRes;

            public UpdateFolderSettingsSuccess(int i) {
                super(null);
                this.successMessageStringRes = i;
            }

            public static /* synthetic */ UpdateFolderSettingsSuccess copy$default(UpdateFolderSettingsSuccess updateFolderSettingsSuccess, int i, int i2, Object obj) {
                if ((i2 & 1) != 0) {
                    i = updateFolderSettingsSuccess.successMessageStringRes;
                }
                return updateFolderSettingsSuccess.copy(i);
            }

            /* renamed from: component1, reason: from getter */
            public final int getSuccessMessageStringRes() {
                return this.successMessageStringRes;
            }

            public final UpdateFolderSettingsSuccess copy(int successMessageStringRes) {
                return new UpdateFolderSettingsSuccess(successMessageStringRes);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof UpdateFolderSettingsSuccess) && this.successMessageStringRes == ((UpdateFolderSettingsSuccess) other).successMessageStringRes;
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
                return outline.B(outline.U("UpdateFolderSettingsSuccess(successMessageStringRes="), this.successMessageStringRes, ")");
            }
        }

        private Event() {
        }

        public /* synthetic */ Event(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetGuildFolderSettingsViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0017\u0010\u0018J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J(\u0010\n\u001a\u00020\u00002\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\f\u0010\u0004J\u0010\u0010\r\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u001b\u0010\t\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\u0013\u001a\u0004\b\u0014\u0010\u0007R\u001b\u0010\b\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\u0015\u001a\u0004\b\u0016\u0010\u0004¨\u0006\u0019"}, d2 = {"Lcom/discord/widgets/guilds/WidgetGuildFolderSettingsViewModel$FormState;", "", "", "component1", "()Ljava/lang/String;", "", "component2", "()Ljava/lang/Integer;", ModelAuditLogEntry.CHANGE_KEY_NAME, ModelAuditLogEntry.CHANGE_KEY_COLOR, "copy", "(Ljava/lang/String;Ljava/lang/Integer;)Lcom/discord/widgets/guilds/WidgetGuildFolderSettingsViewModel$FormState;", "toString", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/Integer;", "getColor", "Ljava/lang/String;", "getName", "<init>", "(Ljava/lang/String;Ljava/lang/Integer;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class FormState {
        private final Integer color;
        private final String name;

        public FormState(String str, Integer num) {
            this.name = str;
            this.color = num;
        }

        public static /* synthetic */ FormState copy$default(FormState formState, String str, Integer num, int i, Object obj) {
            if ((i & 1) != 0) {
                str = formState.name;
            }
            if ((i & 2) != 0) {
                num = formState.color;
            }
            return formState.copy(str, num);
        }

        /* renamed from: component1, reason: from getter */
        public final String getName() {
            return this.name;
        }

        /* renamed from: component2, reason: from getter */
        public final Integer getColor() {
            return this.color;
        }

        public final FormState copy(String name, Integer color) {
            return new FormState(name, color);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof FormState)) {
                return false;
            }
            FormState formState = (FormState) other;
            return Intrinsics3.areEqual(this.name, formState.name) && Intrinsics3.areEqual(this.color, formState.color);
        }

        public final Integer getColor() {
            return this.color;
        }

        public final String getName() {
            return this.name;
        }

        public int hashCode() {
            String str = this.name;
            int iHashCode = (str != null ? str.hashCode() : 0) * 31;
            Integer num = this.color;
            return iHashCode + (num != null ? num.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = outline.U("FormState(name=");
            sbU.append(this.name);
            sbU.append(", color=");
            return outline.F(sbU, this.color, ")");
        }
    }

    /* compiled from: WidgetGuildFolderSettingsViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0002\u0006\u0007¨\u0006\b"}, d2 = {"Lcom/discord/widgets/guilds/WidgetGuildFolderSettingsViewModel$StoreState;", "", "<init>", "()V", "Invalid", "Valid", "Lcom/discord/widgets/guilds/WidgetGuildFolderSettingsViewModel$StoreState$Valid;", "Lcom/discord/widgets/guilds/WidgetGuildFolderSettingsViewModel$StoreState$Invalid;", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static abstract class StoreState {

        /* compiled from: WidgetGuildFolderSettingsViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/widgets/guilds/WidgetGuildFolderSettingsViewModel$StoreState$Invalid;", "Lcom/discord/widgets/guilds/WidgetGuildFolderSettingsViewModel$StoreState;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class Invalid extends StoreState {
            public static final Invalid INSTANCE = new Invalid();

            private Invalid() {
                super(null);
            }
        }

        /* compiled from: WidgetGuildFolderSettingsViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ*\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\t\u001a\u00020\u00022\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u001a\u0010\u0016\u001a\u00020\u00152\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013HÖ\u0003¢\u0006\u0004\b\u0016\u0010\u0017R\u001f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010\u0018\u001a\u0004\b\u0019\u0010\bR\u0019\u0010\t\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\u001a\u001a\u0004\b\u001b\u0010\u0004¨\u0006\u001e"}, d2 = {"Lcom/discord/widgets/guilds/WidgetGuildFolderSettingsViewModel$StoreState$Valid;", "Lcom/discord/widgets/guilds/WidgetGuildFolderSettingsViewModel$StoreState;", "Lcom/discord/models/domain/ModelGuildFolder;", "component1", "()Lcom/discord/models/domain/ModelGuildFolder;", "", "Lcom/discord/stores/StoreGuildsSorted$Entry;", "component2", "()Ljava/util/List;", "folder", "sortedGuilds", "copy", "(Lcom/discord/models/domain/ModelGuildFolder;Ljava/util/List;)Lcom/discord/widgets/guilds/WidgetGuildFolderSettingsViewModel$StoreState$Valid;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/util/List;", "getSortedGuilds", "Lcom/discord/models/domain/ModelGuildFolder;", "getFolder", "<init>", "(Lcom/discord/models/domain/ModelGuildFolder;Ljava/util/List;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final /* data */ class Valid extends StoreState {
            private final ModelGuildFolder folder;
            private final List<StoreGuildsSorted.Entry> sortedGuilds;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            public Valid(ModelGuildFolder modelGuildFolder, List<? extends StoreGuildsSorted.Entry> list) {
                super(null);
                Intrinsics3.checkNotNullParameter(modelGuildFolder, "folder");
                Intrinsics3.checkNotNullParameter(list, "sortedGuilds");
                this.folder = modelGuildFolder;
                this.sortedGuilds = list;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ Valid copy$default(Valid valid, ModelGuildFolder modelGuildFolder, List list, int i, Object obj) {
                if ((i & 1) != 0) {
                    modelGuildFolder = valid.folder;
                }
                if ((i & 2) != 0) {
                    list = valid.sortedGuilds;
                }
                return valid.copy(modelGuildFolder, list);
            }

            /* renamed from: component1, reason: from getter */
            public final ModelGuildFolder getFolder() {
                return this.folder;
            }

            public final List<StoreGuildsSorted.Entry> component2() {
                return this.sortedGuilds;
            }

            public final Valid copy(ModelGuildFolder folder, List<? extends StoreGuildsSorted.Entry> sortedGuilds) {
                Intrinsics3.checkNotNullParameter(folder, "folder");
                Intrinsics3.checkNotNullParameter(sortedGuilds, "sortedGuilds");
                return new Valid(folder, sortedGuilds);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Valid)) {
                    return false;
                }
                Valid valid = (Valid) other;
                return Intrinsics3.areEqual(this.folder, valid.folder) && Intrinsics3.areEqual(this.sortedGuilds, valid.sortedGuilds);
            }

            public final ModelGuildFolder getFolder() {
                return this.folder;
            }

            public final List<StoreGuildsSorted.Entry> getSortedGuilds() {
                return this.sortedGuilds;
            }

            public int hashCode() {
                ModelGuildFolder modelGuildFolder = this.folder;
                int iHashCode = (modelGuildFolder != null ? modelGuildFolder.hashCode() : 0) * 31;
                List<StoreGuildsSorted.Entry> list = this.sortedGuilds;
                return iHashCode + (list != null ? list.hashCode() : 0);
            }

            public String toString() {
                StringBuilder sbU = outline.U("Valid(folder=");
                sbU.append(this.folder);
                sbU.append(", sortedGuilds=");
                return outline.L(sbU, this.sortedGuilds, ")");
            }
        }

        private StoreState() {
        }

        public /* synthetic */ StoreState(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetGuildFolderSettingsViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0002\u0006\u0007¨\u0006\b"}, d2 = {"Lcom/discord/widgets/guilds/WidgetGuildFolderSettingsViewModel$ViewState;", "", "<init>", "()V", "Loaded", "Uninitialized", "Lcom/discord/widgets/guilds/WidgetGuildFolderSettingsViewModel$ViewState$Loaded;", "Lcom/discord/widgets/guilds/WidgetGuildFolderSettingsViewModel$ViewState$Uninitialized;", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static abstract class ViewState {

        /* compiled from: WidgetGuildFolderSettingsViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J$\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0014\u001a\u00020\u00052\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015R\u0019\u0010\b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\u0016\u001a\u0004\b\u0017\u0010\u0004R\u0019\u0010\t\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\u0018\u001a\u0004\b\u0019\u0010\u0007¨\u0006\u001c"}, d2 = {"Lcom/discord/widgets/guilds/WidgetGuildFolderSettingsViewModel$ViewState$Loaded;", "Lcom/discord/widgets/guilds/WidgetGuildFolderSettingsViewModel$ViewState;", "Lcom/discord/widgets/guilds/WidgetGuildFolderSettingsViewModel$FormState;", "component1", "()Lcom/discord/widgets/guilds/WidgetGuildFolderSettingsViewModel$FormState;", "", "component2", "()Z", "formState", "showSave", "copy", "(Lcom/discord/widgets/guilds/WidgetGuildFolderSettingsViewModel$FormState;Z)Lcom/discord/widgets/guilds/WidgetGuildFolderSettingsViewModel$ViewState$Loaded;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "Lcom/discord/widgets/guilds/WidgetGuildFolderSettingsViewModel$FormState;", "getFormState", "Z", "getShowSave", "<init>", "(Lcom/discord/widgets/guilds/WidgetGuildFolderSettingsViewModel$FormState;Z)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final /* data */ class Loaded extends ViewState {
            private final FormState formState;
            private final boolean showSave;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Loaded(FormState formState, boolean z2) {
                super(null);
                Intrinsics3.checkNotNullParameter(formState, "formState");
                this.formState = formState;
                this.showSave = z2;
            }

            public static /* synthetic */ Loaded copy$default(Loaded loaded, FormState formState, boolean z2, int i, Object obj) {
                if ((i & 1) != 0) {
                    formState = loaded.formState;
                }
                if ((i & 2) != 0) {
                    z2 = loaded.showSave;
                }
                return loaded.copy(formState, z2);
            }

            /* renamed from: component1, reason: from getter */
            public final FormState getFormState() {
                return this.formState;
            }

            /* renamed from: component2, reason: from getter */
            public final boolean getShowSave() {
                return this.showSave;
            }

            public final Loaded copy(FormState formState, boolean showSave) {
                Intrinsics3.checkNotNullParameter(formState, "formState");
                return new Loaded(formState, showSave);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Loaded)) {
                    return false;
                }
                Loaded loaded = (Loaded) other;
                return Intrinsics3.areEqual(this.formState, loaded.formState) && this.showSave == loaded.showSave;
            }

            public final FormState getFormState() {
                return this.formState;
            }

            public final boolean getShowSave() {
                return this.showSave;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public int hashCode() {
                FormState formState = this.formState;
                int iHashCode = (formState != null ? formState.hashCode() : 0) * 31;
                boolean z2 = this.showSave;
                int i = z2;
                if (z2 != 0) {
                    i = 1;
                }
                return iHashCode + i;
            }

            public String toString() {
                StringBuilder sbU = outline.U("Loaded(formState=");
                sbU.append(this.formState);
                sbU.append(", showSave=");
                return outline.O(sbU, this.showSave, ")");
            }
        }

        /* compiled from: WidgetGuildFolderSettingsViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/widgets/guilds/WidgetGuildFolderSettingsViewModel$ViewState$Uninitialized;", "Lcom/discord/widgets/guilds/WidgetGuildFolderSettingsViewModel$ViewState;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
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

    /* compiled from: WidgetGuildFolderSettingsViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/models/domain/ModelUserSettings;", "it", "", "invoke", "(Lcom/discord/models/domain/ModelUserSettings;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.guilds.WidgetGuildFolderSettingsViewModel$saveFolder$1, reason: invalid class name */
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
            WidgetGuildFolderSettingsViewModel.access$emitUpdateSuccessEvent(WidgetGuildFolderSettingsViewModel.this);
        }
    }

    /* compiled from: WidgetGuildFolderSettingsViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/utilities/error/Error;", "it", "", "invoke", "(Lcom/discord/utilities/error/Error;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.guilds.WidgetGuildFolderSettingsViewModel$saveFolder$2, reason: invalid class name */
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
            WidgetGuildFolderSettingsViewModel.access$emitUpdateFailureEvent(WidgetGuildFolderSettingsViewModel.this);
        }
    }

    public /* synthetic */ WidgetGuildFolderSettingsViewModel(long j, StoreUserSettings storeUserSettings, StoreGuildsSorted storeGuildsSorted, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, (i & 2) != 0 ? StoreStream.INSTANCE.getUserSettings() : storeUserSettings, (i & 4) != 0 ? StoreStream.INSTANCE.getGuildsSorted() : storeGuildsSorted);
    }

    public static final /* synthetic */ void access$emitUpdateFailureEvent(WidgetGuildFolderSettingsViewModel widgetGuildFolderSettingsViewModel) {
        widgetGuildFolderSettingsViewModel.emitUpdateFailureEvent();
    }

    public static final /* synthetic */ void access$emitUpdateSuccessEvent(WidgetGuildFolderSettingsViewModel widgetGuildFolderSettingsViewModel) {
        widgetGuildFolderSettingsViewModel.emitUpdateSuccessEvent();
    }

    public static final /* synthetic */ void access$handleStoreState(WidgetGuildFolderSettingsViewModel widgetGuildFolderSettingsViewModel, StoreState storeState) {
        widgetGuildFolderSettingsViewModel.handleStoreState(storeState);
    }

    private final void emitUpdateFailureEvent() {
        PublishSubject<Event> publishSubject = this.eventSubject;
        publishSubject.k.onNext(new Event.UpdateFolderSettingsFailure(R.string.default_failure_to_perform_action_message));
    }

    private final void emitUpdateSuccessEvent() {
        PublishSubject<Event> publishSubject = this.eventSubject;
        publishSubject.k.onNext(new Event.UpdateFolderSettingsSuccess(R.string.guild_folder_updated_success));
    }

    private final void handleStoreState(StoreState storeState) {
        this.previousStoreState = storeState;
        if (storeState instanceof StoreState.Valid) {
            StoreState.Valid valid = (StoreState.Valid) storeState;
            FormState formState = new FormState(valid.getFolder().getName(), valid.getFolder().getColor());
            updateViewState(new ViewState.Loaded(formState, shouldShowSave(valid, formState)));
        }
    }

    private final boolean shouldShowSave(StoreState.Valid storeState, FormState formState) {
        return (Intrinsics3.areEqual(storeState.getFolder().getColor(), formState.getColor()) ^ true) || (Intrinsics3.areEqual(storeState.getFolder().getName(), formState.getName()) ^ true);
    }

    private final void updateFormState(FormState formState) {
        ViewState viewState = getViewState();
        if (!(viewState instanceof ViewState.Loaded)) {
            viewState = null;
        }
        ViewState.Loaded loaded = (ViewState.Loaded) viewState;
        if (loaded != null) {
            StoreState storeState = this.previousStoreState;
            updateViewState(loaded.copy(formState, storeState instanceof StoreState.Valid ? shouldShowSave((StoreState.Valid) storeState, formState) : false));
        }
    }

    public final long getFolderId() {
        return this.folderId;
    }

    public final StoreState getPreviousStoreState() {
        return this.previousStoreState;
    }

    public final StoreUserSettings getStoreUserSettings() {
        return this.storeUserSettings;
    }

    public final Observable<Event> observeEvents() {
        PublishSubject<Event> publishSubject = this.eventSubject;
        Intrinsics3.checkNotNullExpressionValue(publishSubject, "eventSubject");
        return publishSubject;
    }

    public final void saveFolder() {
        ModelGuildFolder modelGuildFolderAsModelGuildFolder;
        StoreState storeState = this.previousStoreState;
        if (!(storeState instanceof StoreState.Valid)) {
            storeState = null;
        }
        StoreState.Valid valid = (StoreState.Valid) storeState;
        if (valid != null) {
            ViewState viewState = getViewState();
            if (!(viewState instanceof ViewState.Loaded)) {
                viewState = null;
            }
            ViewState.Loaded loaded = (ViewState.Loaded) viewState;
            if (loaded != null) {
                FormState formState = loaded.getFormState();
                List<StoreGuildsSorted.Entry> sortedGuilds = valid.getSortedGuilds();
                ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(sortedGuilds, 10));
                for (StoreGuildsSorted.Entry entry : sortedGuilds) {
                    if (entry instanceof StoreGuildsSorted.Entry.SingletonGuild) {
                        modelGuildFolderAsModelGuildFolder = entry.asModelGuildFolder();
                    } else {
                        if (!(entry instanceof StoreGuildsSorted.Entry.Folder)) {
                            throw new NoWhenBranchMatchedException();
                        }
                        StoreGuildsSorted.Entry.Folder folder = (StoreGuildsSorted.Entry.Folder) entry;
                        modelGuildFolderAsModelGuildFolder = folder.getId() == this.folderId ? StoreGuildsSorted.Entry.Folder.copy$default(folder, 0L, null, formState.getColor(), formState.getName(), 3, null).asModelGuildFolder() : entry.asModelGuildFolder();
                    }
                    arrayList.add(modelGuildFolderAsModelGuildFolder);
                }
                ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApi().updateUserSettings(RestAPIParams.UserSettings.INSTANCE.createWithGuildFolders(arrayList)), false, 1, null), this, null, 2, null), WidgetGuildFolderSettingsViewModel.class, (Context) null, (Function1) null, new AnonymousClass2(), (Function0) null, (Function0) null, new AnonymousClass1(), 54, (Object) null);
            }
        }
    }

    public final void setColor(Integer color) {
        ViewState viewState = getViewState();
        if (!(viewState instanceof ViewState.Loaded)) {
            viewState = null;
        }
        ViewState.Loaded loaded = (ViewState.Loaded) viewState;
        if (loaded != null) {
            updateFormState(FormState.copy$default(loaded.getFormState(), null, color, 1, null));
        }
    }

    public final void setName(String name) {
        Intrinsics3.checkNotNullParameter(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
        ViewState viewState = getViewState();
        if (!(viewState instanceof ViewState.Loaded)) {
            viewState = null;
        }
        ViewState.Loaded loaded = (ViewState.Loaded) viewState;
        if (loaded != null) {
            updateFormState(FormState.copy$default(loaded.getFormState(), name, null, 2, null));
        }
    }

    public final void setPreviousStoreState(StoreState storeState) {
        this.previousStoreState = storeState;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetGuildFolderSettingsViewModel(long j, StoreUserSettings storeUserSettings, StoreGuildsSorted storeGuildsSorted) {
        super(ViewState.Uninitialized.INSTANCE);
        Intrinsics3.checkNotNullParameter(storeUserSettings, "storeUserSettings");
        Intrinsics3.checkNotNullParameter(storeGuildsSorted, "storeGuildsSorted");
        this.folderId = j;
        this.storeUserSettings = storeUserSettings;
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(Companion.access$observeStoreState(INSTANCE, j, storeUserSettings, storeGuildsSorted)), this, null, 2, null), WidgetGuildFolderSettingsViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(), 62, (Object) null);
        this.eventSubject = PublishSubject.k0();
    }
}

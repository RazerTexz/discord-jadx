package com.discord.stores;

import android.content.Context;
import b.d.b.a.outline;
import com.discord.models.domain.ModelUserNote;
import com.discord.restapi.RestAPIParams;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeck4;
import com.discord.utilities.error.Error;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.g0.StringsJVM;
import d0.t.Maps6;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* compiled from: StoreUserNotes.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u00011B#\u0012\u0006\u0010*\u001a\u00020)\u0012\b\b\u0002\u0010-\u001a\u00020,\u0012\b\b\u0002\u0010#\u001a\u00020\"¢\u0006\u0004\b/\u00100J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u001b\u0010\n\u001a\u00020\u00042\n\u0010\t\u001a\u00060\u0007j\u0002`\bH\u0003¢\u0006\u0004\b\n\u0010\u000bJ#\u0010\r\u001a\u00020\u00042\n\u0010\t\u001a\u00060\u0007j\u0002`\b2\u0006\u0010\u0003\u001a\u00020\fH\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u001d\u0010\u0011\u001a\u0012\u0012\b\u0012\u00060\u0007j\u0002`\b\u0012\u0004\u0012\u00020\u00100\u000f¢\u0006\u0004\b\u0011\u0010\u0012J\u001f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00100\u00132\n\u0010\t\u001a\u00060\u0007j\u0002`\b¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u0018H\u0007¢\u0006\u0004\b\u001a\u0010\u001bJ\u0019\u0010\u001c\u001a\u00020\u00042\n\u0010\t\u001a\u00060\u0007j\u0002`\b¢\u0006\u0004\b\u001c\u0010\u000bJ+\u0010\u001f\u001a\u00020\u00042\b\u0010\u001e\u001a\u0004\u0018\u00010\u001d2\n\u0010\t\u001a\u00060\u0007j\u0002`\b2\u0006\u0010\u0003\u001a\u00020\f¢\u0006\u0004\b\u001f\u0010 J\u000f\u0010!\u001a\u00020\u0004H\u0016¢\u0006\u0004\b!\u0010\u0017R\u0016\u0010#\u001a\u00020\"8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b#\u0010$R&\u0010&\u001a\u0012\u0012\b\u0012\u00060\u0007j\u0002`\b\u0012\u0004\u0012\u00020\u00100%8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b&\u0010'R&\u0010(\u001a\u0012\u0012\b\u0012\u00060\u0007j\u0002`\b\u0012\u0004\u0012\u00020\u00100\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b(\u0010'R\u0016\u0010*\u001a\u00020)8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b*\u0010+R\u0016\u0010-\u001a\u00020,8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b-\u0010.¨\u00062"}, d2 = {"Lcom/discord/stores/StoreUserNotes;", "Lcom/discord/stores/StoreV2;", "Lcom/discord/models/domain/ModelUserNote;", "note", "", "handleRequestUserNoteSuccess", "(Lcom/discord/models/domain/ModelUserNote;)V", "", "Lcom/discord/primitives/UserId;", "userId", "handleRequestUserNoteError", "(J)V", "", "updateNoteInternal", "(JLjava/lang/String;)V", "", "Lcom/discord/stores/StoreUserNotes$UserNoteState;", "getNotesByUserId", "()Ljava/util/Map;", "Lrx/Observable;", "observeUserNote", "(J)Lrx/Observable;", "handleConnectionOpen", "()V", "Lcom/discord/models/domain/ModelUserNote$Update;", "update", "handleNoteUpdate", "(Lcom/discord/models/domain/ModelUserNote$Update;)V", "loadNote", "Landroid/content/Context;", "context", "saveNote", "(Landroid/content/Context;JLjava/lang/String;)V", "snapshotData", "Lcom/discord/stores/updates/ObservationDeck;", "observationDeck", "Lcom/discord/stores/updates/ObservationDeck;", "", "notesByUserId", "Ljava/util/Map;", "notesByUserIdSnapshot", "Lcom/discord/stores/Dispatcher;", "dispatcher", "Lcom/discord/stores/Dispatcher;", "Lcom/discord/utilities/rest/RestAPI;", "restAPI", "Lcom/discord/utilities/rest/RestAPI;", "<init>", "(Lcom/discord/stores/Dispatcher;Lcom/discord/utilities/rest/RestAPI;Lcom/discord/stores/updates/ObservationDeck;)V", "UserNoteState", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class StoreUserNotes extends StoreV2 {
    private final Dispatcher dispatcher;
    private final Map<Long, UserNoteState> notesByUserId;
    private Map<Long, ? extends UserNoteState> notesByUserIdSnapshot;
    private final ObservationDeck observationDeck;
    private final RestAPI restAPI;

    /* compiled from: StoreUserNotes.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0003\u0007\b\t¨\u0006\n"}, d2 = {"Lcom/discord/stores/StoreUserNotes$UserNoteState;", "", "<init>", "()V", "Empty", "Loaded", "Loading", "Lcom/discord/stores/StoreUserNotes$UserNoteState$Loading;", "Lcom/discord/stores/StoreUserNotes$UserNoteState$Empty;", "Lcom/discord/stores/StoreUserNotes$UserNoteState$Loaded;", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static abstract class UserNoteState {

        /* compiled from: StoreUserNotes.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/stores/StoreUserNotes$UserNoteState$Empty;", "Lcom/discord/stores/StoreUserNotes$UserNoteState;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class Empty extends UserNoteState {
            public static final Empty INSTANCE = new Empty();

            private Empty() {
                super(null);
            }
        }

        /* compiled from: StoreUserNotes.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u0019\u0010\u0005\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0013\u001a\u0004\b\u0014\u0010\u0004¨\u0006\u0017"}, d2 = {"Lcom/discord/stores/StoreUserNotes$UserNoteState$Loaded;", "Lcom/discord/stores/StoreUserNotes$UserNoteState;", "Lcom/discord/models/domain/ModelUserNote;", "component1", "()Lcom/discord/models/domain/ModelUserNote;", "note", "copy", "(Lcom/discord/models/domain/ModelUserNote;)Lcom/discord/stores/StoreUserNotes$UserNoteState$Loaded;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/discord/models/domain/ModelUserNote;", "getNote", "<init>", "(Lcom/discord/models/domain/ModelUserNote;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final /* data */ class Loaded extends UserNoteState {
            private final ModelUserNote note;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Loaded(ModelUserNote modelUserNote) {
                super(null);
                Intrinsics3.checkNotNullParameter(modelUserNote, "note");
                this.note = modelUserNote;
            }

            public static /* synthetic */ Loaded copy$default(Loaded loaded, ModelUserNote modelUserNote, int i, Object obj) {
                if ((i & 1) != 0) {
                    modelUserNote = loaded.note;
                }
                return loaded.copy(modelUserNote);
            }

            /* renamed from: component1, reason: from getter */
            public final ModelUserNote getNote() {
                return this.note;
            }

            public final Loaded copy(ModelUserNote note) {
                Intrinsics3.checkNotNullParameter(note, "note");
                return new Loaded(note);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof Loaded) && Intrinsics3.areEqual(this.note, ((Loaded) other).note);
                }
                return true;
            }

            public final ModelUserNote getNote() {
                return this.note;
            }

            public int hashCode() {
                ModelUserNote modelUserNote = this.note;
                if (modelUserNote != null) {
                    return modelUserNote.hashCode();
                }
                return 0;
            }

            public String toString() {
                StringBuilder sbU = outline.U("Loaded(note=");
                sbU.append(this.note);
                sbU.append(")");
                return sbU.toString();
            }
        }

        /* compiled from: StoreUserNotes.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/stores/StoreUserNotes$UserNoteState$Loading;", "Lcom/discord/stores/StoreUserNotes$UserNoteState;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class Loading extends UserNoteState {
            public static final Loading INSTANCE = new Loading();

            private Loading() {
                super(null);
            }
        }

        private UserNoteState() {
        }

        public /* synthetic */ UserNoteState(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: StoreUserNotes.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreUserNotes$loadNote$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ long $userId;

        /* compiled from: StoreUserNotes.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/models/domain/ModelUserNote;", "note", "", "invoke", "(Lcom/discord/models/domain/ModelUserNote;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.stores.StoreUserNotes$loadNote$1$1, reason: invalid class name and collision with other inner class name */
        public static final class C01851 extends Lambda implements Function1<ModelUserNote, Unit> {

            /* compiled from: StoreUserNotes.kt */
            @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
            /* renamed from: com.discord.stores.StoreUserNotes$loadNote$1$1$1, reason: invalid class name and collision with other inner class name */
            public static final class C01861 extends Lambda implements Function0<Unit> {
                public final /* synthetic */ ModelUserNote $note;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public C01861(ModelUserNote modelUserNote) {
                    super(0);
                    this.$note = modelUserNote;
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.a;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    StoreUserNotes.access$handleRequestUserNoteSuccess(StoreUserNotes.this, this.$note);
                }
            }

            public C01851() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ModelUserNote modelUserNote) {
                invoke2(modelUserNote);
                return Unit.a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(ModelUserNote modelUserNote) {
                Intrinsics3.checkNotNullParameter(modelUserNote, "note");
                StoreUserNotes.access$getDispatcher$p(StoreUserNotes.this).schedule(new C01861(modelUserNote));
            }
        }

        /* compiled from: StoreUserNotes.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/utilities/error/Error;", "it", "", "invoke", "(Lcom/discord/utilities/error/Error;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.stores.StoreUserNotes$loadNote$1$2, reason: invalid class name */
        public static final class AnonymousClass2 extends Lambda implements Function1<Error, Unit> {

            /* compiled from: StoreUserNotes.kt */
            @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
            /* renamed from: com.discord.stores.StoreUserNotes$loadNote$1$2$1, reason: invalid class name and collision with other inner class name */
            public static final class C01871 extends Lambda implements Function0<Unit> {
                public C01871() {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.a;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                    StoreUserNotes.access$handleRequestUserNoteError(StoreUserNotes.this, anonymousClass1.$userId);
                }
            }

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
                StoreUserNotes.access$getDispatcher$p(StoreUserNotes.this).schedule(new C01871());
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(long j) {
            super(0);
            this.$userId = j;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            if (StoreUserNotes.access$getNotesByUserId$p(StoreUserNotes.this).containsKey(Long.valueOf(this.$userId))) {
                return;
            }
            StoreUserNotes.access$getNotesByUserId$p(StoreUserNotes.this).put(Long.valueOf(this.$userId), UserNoteState.Loading.INSTANCE);
            ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.restSubscribeOn$default(StoreUserNotes.access$getRestAPI$p(StoreUserNotes.this).getUserNote(this.$userId), false, 1, null), StoreUserNotes.this.getClass(), (Context) null, (Function1) null, new AnonymousClass2(), (Function0) null, (Function0) null, new C01851(), 54, (Object) null);
        }
    }

    /* compiled from: StoreUserNotes.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/discord/stores/StoreUserNotes$UserNoteState;", "invoke", "()Lcom/discord/stores/StoreUserNotes$UserNoteState;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreUserNotes$observeUserNote$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<UserNoteState> {
        public final /* synthetic */ long $userId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(long j) {
            super(0);
            this.$userId = j;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ UserNoteState invoke() {
            return invoke();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final UserNoteState invoke() {
            UserNoteState userNoteState = StoreUserNotes.this.getNotesByUserId().get(Long.valueOf(this.$userId));
            return userNoteState != null ? userNoteState : UserNoteState.Loading.INSTANCE;
        }
    }

    /* compiled from: StoreUserNotes.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Ljava/lang/Void;", "it", "", "invoke", "(Ljava/lang/Void;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreUserNotes$saveNote$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<Void, Unit> {
        public final /* synthetic */ String $note;
        public final /* synthetic */ long $userId;

        /* compiled from: StoreUserNotes.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.stores.StoreUserNotes$saveNote$1$1, reason: invalid class name and collision with other inner class name */
        public static final class C01881 extends Lambda implements Function0<Unit> {
            public C01881() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                StoreUserNotes.access$updateNoteInternal(StoreUserNotes.this, anonymousClass1.$userId, anonymousClass1.$note);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(long j, String str) {
            super(1);
            this.$userId = j;
            this.$note = str;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Void r1) {
            invoke2(r1);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Void r2) {
            StoreUserNotes.access$getDispatcher$p(StoreUserNotes.this).schedule(new C01881());
        }
    }

    public /* synthetic */ StoreUserNotes(Dispatcher dispatcher, RestAPI restAPI, ObservationDeck observationDeck, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(dispatcher, (i & 2) != 0 ? RestAPI.INSTANCE.getApi() : restAPI, (i & 4) != 0 ? ObservationDeck4.get() : observationDeck);
    }

    public static final /* synthetic */ Dispatcher access$getDispatcher$p(StoreUserNotes storeUserNotes) {
        return storeUserNotes.dispatcher;
    }

    public static final /* synthetic */ Map access$getNotesByUserId$p(StoreUserNotes storeUserNotes) {
        return storeUserNotes.notesByUserId;
    }

    public static final /* synthetic */ RestAPI access$getRestAPI$p(StoreUserNotes storeUserNotes) {
        return storeUserNotes.restAPI;
    }

    public static final /* synthetic */ void access$handleRequestUserNoteError(StoreUserNotes storeUserNotes, long j) {
        storeUserNotes.handleRequestUserNoteError(j);
    }

    public static final /* synthetic */ void access$handleRequestUserNoteSuccess(StoreUserNotes storeUserNotes, ModelUserNote modelUserNote) {
        storeUserNotes.handleRequestUserNoteSuccess(modelUserNote);
    }

    public static final /* synthetic */ void access$updateNoteInternal(StoreUserNotes storeUserNotes, long j, String str) {
        storeUserNotes.updateNoteInternal(j, str);
    }

    @Store3
    private final void handleRequestUserNoteError(long userId) {
        this.notesByUserId.put(Long.valueOf(userId), UserNoteState.Empty.INSTANCE);
        markChanged();
    }

    @Store3
    private final void handleRequestUserNoteSuccess(ModelUserNote note) {
        long noteUserId = note.getNoteUserId();
        String note2 = note.getNote();
        if (note2 == null) {
            note2 = "";
        }
        updateNoteInternal(noteUserId, note2);
    }

    @Store3
    private final void updateNoteInternal(long userId, String note) {
        if (StringsJVM.isBlank(note)) {
            this.notesByUserId.put(Long.valueOf(userId), UserNoteState.Empty.INSTANCE);
        } else {
            this.notesByUserId.put(Long.valueOf(userId), new UserNoteState.Loaded(new ModelUserNote(userId, note)));
        }
        markChanged();
    }

    public final Map<Long, UserNoteState> getNotesByUserId() {
        return this.notesByUserIdSnapshot;
    }

    @Store3
    public final void handleConnectionOpen() {
        this.notesByUserId.clear();
        markChanged();
    }

    @Store3
    public final void handleNoteUpdate(ModelUserNote.Update update) {
        Intrinsics3.checkNotNullParameter(update, "update");
        updateNoteInternal(update.getId(), update.getNote());
    }

    public final void loadNote(long userId) {
        this.dispatcher.schedule(new AnonymousClass1(userId));
    }

    public final Observable<UserNoteState> observeUserNote(long userId) {
        Observable<UserNoteState> observableR = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new AnonymousClass1(userId), 14, null).r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "observationDeck.connectR… }.distinctUntilChanged()");
        return observableR;
    }

    public final void saveNote(Context context, long userId, String note) {
        Intrinsics3.checkNotNullParameter(note, "note");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.restSubscribeOn$default(this.restAPI.updateUserNotes(userId, new RestAPIParams.UserNoteUpdate(note)), false, 1, null), StoreUserNotes.class, context, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(userId, note), 60, (Object) null);
    }

    @Override // com.discord.stores.StoreV2
    public void snapshotData() {
        super.snapshotData();
        this.notesByUserIdSnapshot = new HashMap(this.notesByUserId);
    }

    public StoreUserNotes(Dispatcher dispatcher, RestAPI restAPI, ObservationDeck observationDeck) {
        Intrinsics3.checkNotNullParameter(dispatcher, "dispatcher");
        Intrinsics3.checkNotNullParameter(restAPI, "restAPI");
        Intrinsics3.checkNotNullParameter(observationDeck, "observationDeck");
        this.dispatcher = dispatcher;
        this.restAPI = restAPI;
        this.observationDeck = observationDeck;
        this.notesByUserId = new HashMap();
        this.notesByUserIdSnapshot = Maps6.emptyMap();
    }
}

package com.discord.stores;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.core.app.NotificationCompat;
import com.discord.BuildConfig;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import j0.k.Func1;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import rx.Observable;
import rx.subjects.BehaviorSubject;
import rx.subjects.SerializedSubject;

/* compiled from: StoreClientVersion.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0013\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eR2\u0010\u0011\u001a\u001e\u0012\f\u0012\n \u0010*\u0004\u0018\u00010\b0\b\u0012\f\u0012\n \u0010*\u0004\u0018\u00010\b0\b0\u000f8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0013\u001a\u00020\u00028\u0002@\u0002X\u0082D¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0016\u001a\u00020\u00158\u0002@\u0002X\u0082D¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0014¨\u0006\u001a"}, d2 = {"Lcom/discord/stores/StoreClientVersion;", "Lcom/discord/stores/Store;", "", "clientMinVersion", "", "setClientMinVersion", "(I)V", "Lrx/Observable;", "", "getClientOutdated", "()Lrx/Observable;", "Landroid/content/Context;", "context", "init", "(Landroid/content/Context;)V", "Lrx/subjects/SerializedSubject;", "kotlin.jvm.PlatformType", "clientOutdatedSubject", "Lrx/subjects/SerializedSubject;", "clientVersion", "I", "", "clientMinVersionKey", "Ljava/lang/String;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class StoreClientVersion extends Store {
    private int clientMinVersion;
    private final int clientVersion = BuildConfig.VERSION_CODE;
    private final String clientMinVersionKey = "CLIENT_OUTDATED_KEY";
    private final SerializedSubject<Boolean, Boolean> clientOutdatedSubject = new SerializedSubject<>(BehaviorSubject.l0(Boolean.FALSE));

    /* compiled from: StoreClientVersion.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u0010\u0007\u001a*\u0012\u000e\b\u0001\u0012\n \u0001*\u0004\u0018\u00010\u00040\u0004 \u0001*\u0014\u0012\u000e\b\u0001\u0012\n \u0001*\u0004\u0018\u00010\u00040\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"", "kotlin.jvm.PlatformType", "it", "Lrx/Observable;", "", NotificationCompat.CATEGORY_CALL, "(Ljava/lang/Long;)Lrx/Observable;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreClientVersion$init$1, reason: invalid class name */
    public static final class AnonymousClass1<T, R> implements Func1<Long, Observable<? extends Integer>> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        @Override // j0.k.Func1
        public /* bridge */ /* synthetic */ Observable<? extends Integer> call(Long l) {
            return call2(l);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final Observable<? extends Integer> call2(Long l) {
            return RestAPI.INSTANCE.getApi().getClientVersion();
        }
    }

    /* compiled from: StoreClientVersion.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "p1", "", "invoke", "(I)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreClientVersion$init$2, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass2 extends FunctionReferenceImpl implements Function1<Integer, Unit> {
        public AnonymousClass2(StoreClientVersion storeClientVersion) {
            super(1, storeClientVersion, StoreClientVersion.class, "setClientMinVersion", "setClientMinVersion(I)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
            invoke(num.intValue());
            return Unit.a;
        }

        public final void invoke(int i) {
            StoreClientVersion.access$setClientMinVersion((StoreClientVersion) this.receiver, i);
        }
    }

    public static final /* synthetic */ void access$setClientMinVersion(StoreClientVersion storeClientVersion, int i) {
        storeClientVersion.setClientMinVersion(i);
    }

    private final synchronized void setClientMinVersion(int clientMinVersion) {
        if (this.clientMinVersion != clientMinVersion) {
            this.clientMinVersion = clientMinVersion;
            this.clientOutdatedSubject.k.onNext(Boolean.valueOf(this.clientVersion < clientMinVersion));
            SharedPreferences.Editor editorEdit = getPrefs().edit();
            Intrinsics3.checkNotNullExpressionValue(editorEdit, "editor");
            editorEdit.putInt(this.clientMinVersionKey, clientMinVersion);
            editorEdit.apply();
        }
    }

    public final Observable<Boolean> getClientOutdated() {
        Observable<Boolean> observableR = ObservableExtensionsKt.computationLatest(this.clientOutdatedSubject).r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "clientOutdatedSubject\n  …  .distinctUntilChanged()");
        return observableR;
    }

    @Override // com.discord.stores.Store
    public synchronized void init(Context context) {
        Intrinsics3.checkNotNullParameter(context, "context");
        super.init(context);
        int i = getPrefs().getInt(this.clientMinVersionKey, 0);
        this.clientMinVersion = i;
        setClientMinVersion(i);
        Observable<R> observableA = Observable.E(0L, 1L, TimeUnit.HOURS).A(AnonymousClass1.INSTANCE);
        Intrinsics3.checkNotNullExpressionValue(observableA, "Observable\n        .inte…ClientVersion()\n        }");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.computationBuffered(observableA), getClass(), (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass2(this), 62, (Object) null);
    }
}

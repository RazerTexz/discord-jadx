package com.discord.stores;

import android.content.Intent;
import android.net.Uri;
import androidx.core.app.NotificationCompat;
import b.i.a.f.n.e;
import b.i.c.FirebaseApp2;
import b.i.c.o.a;
import com.google.firebase.dynamiclinks.PendingDynamicLinkData;
import com.google.firebase.dynamiclinks.internal.DynamicLinkData;
import d0.z.d.FunctionReferenceImpl;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import rx.Emitter;
import rx.functions.Action1;

/* compiled from: StoreDynamicLink.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0007\u001a\u00020\u00042*\u0010\u0003\u001a&\u0012\f\u0012\n \u0002*\u0004\u0018\u00010\u00010\u0001 \u0002*\u0012\u0012\f\u0012\n \u0002*\u0004\u0018\u00010\u00010\u0001\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lrx/Emitter;", "Landroid/net/Uri;", "kotlin.jvm.PlatformType", "it", "", NotificationCompat.CATEGORY_CALL, "(Lrx/Emitter;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.stores.StoreDynamicLink$getDynamicLinkObservable$firebaseDynamicLinks$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class StoreDynamicLink2<T> implements Action1<Emitter<Uri>> {
    public final /* synthetic */ Intent $intent;

    /* compiled from: StoreDynamicLink.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "kotlin.jvm.PlatformType", "p1", "", "invoke", "(Ljava/lang/Throwable;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreDynamicLink$getDynamicLinkObservable$firebaseDynamicLinks$1$1, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<Throwable, Unit> {
        public AnonymousClass1(Emitter emitter) {
            super(1, emitter, Emitter.class, "onError", "onError(Ljava/lang/Throwable;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
            invoke2(th);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Throwable th) {
            ((Emitter) this.receiver).onError(th);
        }
    }

    /* compiled from: StoreDynamicLink.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/google/firebase/dynamiclinks/PendingDynamicLinkData;", "kotlin.jvm.PlatformType", "pendingDynamicLinkData", "", "onSuccess", "(Lcom/google/firebase/dynamiclinks/PendingDynamicLinkData;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreDynamicLink$getDynamicLinkObservable$firebaseDynamicLinks$1$2, reason: invalid class name */
    public static final class AnonymousClass2<TResult> implements e<PendingDynamicLinkData> {
        public final /* synthetic */ Emitter $it;

        public AnonymousClass2(Emitter emitter) {
            this.$it = emitter;
        }

        @Override // b.i.a.f.n.e
        public /* bridge */ /* synthetic */ void onSuccess(PendingDynamicLinkData pendingDynamicLinkData) {
            onSuccess2(pendingDynamicLinkData);
        }

        /* JADX WARN: Removed duplicated region for block: B:12:0x0015  */
        /* renamed from: onSuccess, reason: avoid collision after fix types in other method */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final void onSuccess2(PendingDynamicLinkData pendingDynamicLinkData) {
            Uri uri;
            String str;
            Emitter emitter = this.$it;
            if (pendingDynamicLinkData != null) {
                DynamicLinkData dynamicLinkData = pendingDynamicLinkData.a;
                uri = null;
                if (dynamicLinkData != null && (str = dynamicLinkData.k) != null) {
                    uri = Uri.parse(str);
                }
                if (uri == null) {
                    uri = Uri.EMPTY;
                }
            }
            emitter.onNext(uri);
            this.$it.onCompleted();
        }
    }

    public StoreDynamicLink2(Intent intent) {
        this.$intent = intent;
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final void call2(Emitter<Uri> emitter) {
        a aVar;
        synchronized (a.class) {
            FirebaseApp2 firebaseApp2B = FirebaseApp2.b();
            synchronized (a.class) {
                firebaseApp2B.a();
                aVar = (a) firebaseApp2B.g.a(a.class);
            }
            aVar.a(this.$intent).d(new StoreDynamicLink3(new AnonymousClass1(emitter))).f(new AnonymousClass2(emitter));
        }
        aVar.a(this.$intent).d(new StoreDynamicLink3(new AnonymousClass1(emitter))).f(new AnonymousClass2(emitter));
    }

    @Override // rx.functions.Action1
    public /* bridge */ /* synthetic */ void call(Emitter<Uri> emitter) {
        call2(emitter);
    }
}

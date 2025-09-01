package com.discord.utilities.coroutines;

import b.d.b.a.outline;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;

/* compiled from: AppCoroutineScope.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\u001aB\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\b\u0010\u0004J\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fHÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010R\"\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00000\u00118\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0019\u0010\u0005\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0016\u001a\u0004\b\u0017\u0010\u0004¨\u0006\u001b"}, d2 = {"Lcom/discord/utilities/coroutines/AppErrorTag;", "Lkotlin/coroutines/CoroutineContext$Element;", "", "component1", "()Ljava/lang/String;", "errorTag", "copy", "(Ljava/lang/String;)Lcom/discord/utilities/coroutines/AppErrorTag;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lkotlin/coroutines/CoroutineContext$Key;", "key", "Lkotlin/coroutines/CoroutineContext$Key;", "getKey", "()Lkotlin/coroutines/CoroutineContext$Key;", "Ljava/lang/String;", "getErrorTag", "<init>", "(Ljava/lang/String;)V", "Key", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* renamed from: com.discord.utilities.coroutines.AppErrorTag, reason: use source file name */
/* loaded from: classes2.dex */
public final /* data */ class AppCoroutineScope2 implements CoroutineContext.Element {
    private final String errorTag;
    private final CoroutineContext.Key<AppCoroutineScope2> key;

    /* compiled from: AppCoroutineScope.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/discord/utilities/coroutines/AppErrorTag$Key;", "Lkotlin/coroutines/CoroutineContext$Key;", "Lcom/discord/utilities/coroutines/AppErrorTag;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    /* renamed from: com.discord.utilities.coroutines.AppErrorTag$Key */
    public static final class Key implements CoroutineContext.Key<AppCoroutineScope2> {
        public static final Key INSTANCE = new Key();

        private Key() {
        }
    }

    public AppCoroutineScope2(String str) {
        Intrinsics3.checkNotNullParameter(str, "errorTag");
        this.errorTag = str;
        this.key = Key.INSTANCE;
    }

    public static /* synthetic */ AppCoroutineScope2 copy$default(AppCoroutineScope2 appCoroutineScope2, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = appCoroutineScope2.errorTag;
        }
        return appCoroutineScope2.copy(str);
    }

    /* renamed from: component1, reason: from getter */
    public final String getErrorTag() {
        return this.errorTag;
    }

    public final AppCoroutineScope2 copy(String errorTag) {
        Intrinsics3.checkNotNullParameter(errorTag, "errorTag");
        return new AppCoroutineScope2(errorTag);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof AppCoroutineScope2) && Intrinsics3.areEqual(this.errorTag, ((AppCoroutineScope2) other).errorTag);
        }
        return true;
    }

    @Override // kotlin.coroutines.CoroutineContext
    public <R> R fold(R r, Function2<? super R, ? super CoroutineContext.Element, ? extends R> function2) {
        Intrinsics3.checkNotNullParameter(function2, "operation");
        return (R) CoroutineContext.Element.a.fold(this, r, function2);
    }

    @Override // kotlin.coroutines.CoroutineContext.Element, kotlin.coroutines.CoroutineContext
    public <E extends CoroutineContext.Element> E get(CoroutineContext.Key<E> key) {
        Intrinsics3.checkNotNullParameter(key, "key");
        return (E) CoroutineContext.Element.a.get(this, key);
    }

    public final String getErrorTag() {
        return this.errorTag;
    }

    @Override // kotlin.coroutines.CoroutineContext.Element
    public CoroutineContext.Key<AppCoroutineScope2> getKey() {
        return this.key;
    }

    public int hashCode() {
        String str = this.errorTag;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    @Override // kotlin.coroutines.CoroutineContext
    public CoroutineContext minusKey(CoroutineContext.Key<?> key) {
        Intrinsics3.checkNotNullParameter(key, "key");
        return CoroutineContext.Element.a.minusKey(this, key);
    }

    @Override // kotlin.coroutines.CoroutineContext
    public CoroutineContext plus(CoroutineContext coroutineContext) {
        Intrinsics3.checkNotNullParameter(coroutineContext, "context");
        return CoroutineContext.Element.a.plus(this, coroutineContext);
    }

    public String toString() {
        return outline.J(outline.U("AppErrorTag(errorTag="), this.errorTag, ")");
    }
}

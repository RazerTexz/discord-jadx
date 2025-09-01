package com.discord.utilities.rx;

import kotlin.Metadata;

/* compiled from: ObservableCombineLatestOverloads.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0000\n\u0002\b\u0017\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u0002*\u0004\b\u0002\u0010\u0003*\u0004\b\u0003\u0010\u0004*\u0004\b\u0004\u0010\u0005*\u0004\b\u0005\u0010\u0006*\u0004\b\u0006\u0010\u0007*\u0004\b\u0007\u0010\b*\u0004\b\b\u0010\t2\u00020\nBO\u0012\u0006\u0010\u0015\u001a\u00028\u0000\u0012\u0006\u0010\u000b\u001a\u00028\u0001\u0012\u0006\u0010\u000f\u001a\u00028\u0002\u0012\u0006\u0010\u001d\u001a\u00028\u0003\u0012\u0006\u0010\u0017\u001a\u00028\u0004\u0012\u0006\u0010\u001b\u001a\u00028\u0005\u0012\u0006\u0010\u0019\u001a\u00028\u0006\u0012\u0006\u0010\u0013\u001a\u00028\u0007\u0012\u0006\u0010\u0011\u001a\u00028\b¢\u0006\u0004\b\u001f\u0010 R\u0019\u0010\u000b\u001a\u00028\u00018\u0006@\u0006¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0019\u0010\u000f\u001a\u00028\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010\f\u001a\u0004\b\u0010\u0010\u000eR\u0019\u0010\u0011\u001a\u00028\b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010\f\u001a\u0004\b\u0012\u0010\u000eR\u0019\u0010\u0013\u001a\u00028\u00078\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010\f\u001a\u0004\b\u0014\u0010\u000eR\u0019\u0010\u0015\u001a\u00028\u00008\u0006@\u0006¢\u0006\f\n\u0004\b\u0015\u0010\f\u001a\u0004\b\u0016\u0010\u000eR\u0019\u0010\u0017\u001a\u00028\u00048\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010\f\u001a\u0004\b\u0018\u0010\u000eR\u0019\u0010\u0019\u001a\u00028\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u0019\u0010\f\u001a\u0004\b\u001a\u0010\u000eR\u0019\u0010\u001b\u001a\u00028\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u001b\u0010\f\u001a\u0004\b\u001c\u0010\u000eR\u0019\u0010\u001d\u001a\u00028\u00038\u0006@\u0006¢\u0006\f\n\u0004\b\u001d\u0010\f\u001a\u0004\b\u001e\u0010\u000e¨\u0006!"}, d2 = {"Lcom/discord/utilities/rx/Holder;", "T1", "T2", "T3", "T4", "T5", "T6", "T7", "T8", "T9", "", "t2", "Ljava/lang/Object;", "getT2", "()Ljava/lang/Object;", "t3", "getT3", "t9", "getT9", "t8", "getT8", "t1", "getT1", "t5", "getT5", "t7", "getT7", "t6", "getT6", "t4", "getT4", "<init>", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V", "utils_release"}, k = 1, mv = {1, 4, 2})
/* renamed from: com.discord.utilities.rx.Holder, reason: use source file name */
/* loaded from: classes2.dex */
public final class ObservableCombineLatestOverloads<T1, T2, T3, T4, T5, T6, T7, T8, T9> {
    private final T1 t1;
    private final T2 t2;
    private final T3 t3;
    private final T4 t4;
    private final T5 t5;
    private final T6 t6;
    private final T7 t7;
    private final T8 t8;
    private final T9 t9;

    public ObservableCombineLatestOverloads(T1 t1, T2 t2, T3 t3, T4 t4, T5 t5, T6 t6, T7 t7, T8 t8, T9 t9) {
        this.t1 = t1;
        this.t2 = t2;
        this.t3 = t3;
        this.t4 = t4;
        this.t5 = t5;
        this.t6 = t6;
        this.t7 = t7;
        this.t8 = t8;
        this.t9 = t9;
    }

    public final T1 getT1() {
        return this.t1;
    }

    public final T2 getT2() {
        return this.t2;
    }

    public final T3 getT3() {
        return this.t3;
    }

    public final T4 getT4() {
        return this.t4;
    }

    public final T5 getT5() {
        return this.t5;
    }

    public final T6 getT6() {
        return this.t6;
    }

    public final T7 getT7() {
        return this.t7;
    }

    public final T8 getT8() {
        return this.t8;
    }

    public final T9 getT9() {
        return this.t9;
    }
}

package com.google.firebase.messaging.ktx;

import b.i.a.f.e.o.f;
import b.i.c.l.Component4;
import b.i.c.l.ComponentRegistrar;
import d0.t.CollectionsJVM;
import java.util.List;
import kotlin.Metadata;

/* compiled from: Messaging.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0006\u0010\u0007J\u0019\u0010\u0004\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00030\u0002H\u0016¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/google/firebase/messaging/ktx/FirebaseMessagingKtxRegistrar;", "Lb/i/c/l/g;", "", "Lb/i/c/l/d;", "getComponents", "()Ljava/util/List;", "<init>", "()V", "com.google.firebase-firebase-messaging-ktx"}, k = 1, mv = {1, 4, 0})
/* renamed from: com.google.firebase.messaging.ktx.FirebaseMessagingKtxRegistrar, reason: use source file name */
/* loaded from: classes3.dex */
public final class Messaging implements ComponentRegistrar {
    @Override // b.i.c.l.ComponentRegistrar
    public List<Component4<?>> getComponents() {
        return CollectionsJVM.listOf(f.N("fire-fcm-ktx", "21.0.0"));
    }
}

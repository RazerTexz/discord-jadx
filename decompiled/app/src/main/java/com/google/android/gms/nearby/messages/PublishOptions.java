package com.google.android.gms.nearby.messages;

import androidx.annotation.Nullable;
import b.i.a.f.j.b.b;
import b.i.a.f.j.b.i;

/* loaded from: classes3.dex */
public final class PublishOptions {
    public final Strategy a;

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    public final b f3017b;

    static {
        Strategy strategy = Strategy.j;
    }

    public PublishOptions(Strategy strategy, b bVar, i iVar) {
        this.a = strategy;
        this.f3017b = bVar;
    }
}

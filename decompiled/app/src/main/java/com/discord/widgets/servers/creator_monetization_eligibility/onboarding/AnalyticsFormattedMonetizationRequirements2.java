package com.discord.widgets.servers.creator_monetization_eligibility.onboarding;

import b.a.b.TypeAdapterRegistrar;
import b.i.d.GsonBuilder;
import com.google.gson.Gson;
import d0.z.d.Lambda;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

/* compiled from: AnalyticsFormattedMonetizationRequirements.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0004\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/google/gson/Gson;", "kotlin.jvm.PlatformType", "invoke", "()Lcom/google/gson/Gson;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.servers.creator_monetization_eligibility.onboarding.AnalyticsFormattedMonetizationRequirements$Companion$gsonInstance$2, reason: use source file name */
/* loaded from: classes2.dex */
public final class AnalyticsFormattedMonetizationRequirements2 extends Lambda implements Function0<Gson> {
    public static final AnalyticsFormattedMonetizationRequirements2 INSTANCE = new AnalyticsFormattedMonetizationRequirements2();

    public AnalyticsFormattedMonetizationRequirements2() {
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Gson invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final Gson invoke() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        TypeAdapterRegistrar.a(gsonBuilder);
        return gsonBuilder.a();
    }
}

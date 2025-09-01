package com.discord.utilities.sms;

import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import b.c.a.a0.AnimatableValueParser;
import b.i.a.f.e.h.j.k0;
import b.i.a.f.e.h.j.p;
import b.i.a.f.h.b.b;
import b.i.a.f.h.b.h;
import b.i.a.f.h.b.j;
import com.discord.utilities.lifecycle.ApplicationProvider;
import com.discord.widgets.auth.SmsAuthCodeBroadcastReceiver;
import com.google.android.gms.common.Feature;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: SmsListener.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u0000 \u00042\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/discord/utilities/sms/SmsListener;", "", "<init>", "()V", "Companion", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class SmsListener {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static BroadcastReceiver broadcastReceiver;

    /* compiled from: SmsListener.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0011\u0010\tJ!\u0010\u0006\u001a\u00020\u00042\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\r\u0010\b\u001a\u00020\u0004¢\u0006\u0004\b\b\u0010\tR$\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u0012"}, d2 = {"Lcom/discord/utilities/sms/SmsListener$Companion;", "", "Lkotlin/Function1;", "", "", "onSuccess", "startSmsListener", "(Lkotlin/jvm/functions/Function1;)V", "stopSmsListener", "()V", "Landroid/content/BroadcastReceiver;", "broadcastReceiver", "Landroid/content/BroadcastReceiver;", "getBroadcastReceiver", "()Landroid/content/BroadcastReceiver;", "setBroadcastReceiver", "(Landroid/content/BroadcastReceiver;)V", "<init>", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public final BroadcastReceiver getBroadcastReceiver() {
            return SmsListener.access$getBroadcastReceiver$cp();
        }

        public final void setBroadcastReceiver(BroadcastReceiver broadcastReceiver) {
            SmsListener.access$setBroadcastReceiver$cp(broadcastReceiver);
        }

        public final void startSmsListener(Function1<? super String, Unit> onSuccess) {
            Intrinsics3.checkNotNullParameter(onSuccess, "onSuccess");
            Application application = ApplicationProvider.INSTANCE.get();
            h hVar = new h(application);
            p.a aVar = new p.a(null);
            aVar.a = new j(hVar);
            aVar.f1370b = new Feature[]{b.f1404b};
            AnimatableValueParser.o(true, "execute parameter required");
            hVar.c(new k0(aVar, aVar.f1370b, true));
            setBroadcastReceiver(new SmsAuthCodeBroadcastReceiver(onSuccess));
            application.registerReceiver(getBroadcastReceiver(), new IntentFilter("com.google.android.gms.auth.api.phone.SMS_RETRIEVED"));
        }

        public final void stopSmsListener() {
            try {
                ApplicationProvider.INSTANCE.get().unregisterReceiver(getBroadcastReceiver());
            } catch (Exception unused) {
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public static final /* synthetic */ BroadcastReceiver access$getBroadcastReceiver$cp() {
        return broadcastReceiver;
    }

    public static final /* synthetic */ void access$setBroadcastReceiver$cp(BroadcastReceiver broadcastReceiver2) {
        broadcastReceiver = broadcastReceiver2;
    }
}

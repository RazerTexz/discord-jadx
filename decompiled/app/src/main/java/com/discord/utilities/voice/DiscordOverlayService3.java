package com.discord.utilities.voice;

import android.content.Context;
import com.discord.utilities.voice.DiscordOverlayService;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: DiscordOverlayService.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "kotlin.jvm.PlatformType", "action", "", "invoke", "(Ljava/lang/String;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.utilities.voice.DiscordOverlayService$Companion$launchForConnect$2, reason: use source file name */
/* loaded from: classes2.dex */
public final class DiscordOverlayService3 extends Lambda implements Function1<String, Unit> {
    public final /* synthetic */ WeakReference $weakContext;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DiscordOverlayService3(WeakReference weakReference) {
        super(1);
        this.$weakContext = weakReference;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(String str) {
        invoke2(str);
        return Unit.a;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(String str) {
        Context context = (Context) this.$weakContext.get();
        if (context != null) {
            DiscordOverlayService.Companion companion = DiscordOverlayService.INSTANCE;
            Intrinsics3.checkNotNullExpressionValue(str, "action");
            DiscordOverlayService.Companion.tryStartOverlayService$default(companion, context, str, false, 4, null);
        }
    }
}

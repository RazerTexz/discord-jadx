package com.discord.utilities.intent;

import android.net.Uri;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.channel.ChannelSelector;
import d0.g0.StringNumberConversions;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: RouteHandlers.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroidx/fragment/app/FragmentActivity;", "ctx", "", "invoke", "(Landroidx/fragment/app/FragmentActivity;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class RouteHandlers$selectFeature$settingMap$12 extends Lambda implements Function1<FragmentActivity, Unit> {
    public final /* synthetic */ Uri $uri;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RouteHandlers$selectFeature$settingMap$12(Uri uri) {
        super(1);
        this.$uri = uri;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(FragmentActivity fragmentActivity) {
        invoke2(fragmentActivity);
        return Unit.a;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(FragmentActivity fragmentActivity) {
        Intrinsics3.checkNotNullParameter(fragmentActivity, "ctx");
        String queryParameter = this.$uri.getQueryParameter(ModelAuditLogEntry.CHANGE_KEY_CHANNEL_ID);
        Long longOrNull = queryParameter != null ? StringNumberConversions.toLongOrNull(queryParameter) : null;
        if (longOrNull != null) {
            ChannelSelector companion = ChannelSelector.INSTANCE.getInstance();
            FragmentManager supportFragmentManager = fragmentActivity.getSupportFragmentManager();
            Intrinsics3.checkNotNullExpressionValue(supportFragmentManager, "ctx.supportFragmentManager");
            companion.previewVoiceChannel(supportFragmentManager, longOrNull.longValue());
        }
    }
}

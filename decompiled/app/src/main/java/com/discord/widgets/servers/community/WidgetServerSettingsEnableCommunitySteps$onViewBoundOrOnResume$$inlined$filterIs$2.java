package com.discord.widgets.servers.community;

import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import com.discord.widgets.servers.community.WidgetServerSettingsEnableCommunityViewModel;
import j0.k.Func1;
import java.util.Objects;
import kotlin.Metadata;

/* compiled from: ObservableExtensions.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0006\u0010\u0007\u001a\n \u0002*\u0004\u0018\u00018\u00008\u0000\"\u0006\b\u0000\u0010\u0000\u0018\u00012\u000e\u0010\u0003\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "", "kotlin.jvm.PlatformType", "it", NotificationCompat.CATEGORY_CALL, "(Ljava/lang/Object;)Ljava/lang/Object;", "com/discord/utilities/rx/ObservableExtensionsKt$filterIs$2", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetServerSettingsEnableCommunitySteps$onViewBoundOrOnResume$$inlined$filterIs$2<T, R> implements Func1<Object, T> {
    public static final WidgetServerSettingsEnableCommunitySteps$onViewBoundOrOnResume$$inlined$filterIs$2 INSTANCE = new WidgetServerSettingsEnableCommunitySteps$onViewBoundOrOnResume$$inlined$filterIs$2();

    @Override // j0.k.Func1
    public final T call(Object obj) {
        Objects.requireNonNull(obj, "null cannot be cast to non-null type com.discord.widgets.servers.community.WidgetServerSettingsEnableCommunityViewModel.ViewState.Loaded");
        return (T) ((WidgetServerSettingsEnableCommunityViewModel.ViewState.Loaded) obj);
    }
}

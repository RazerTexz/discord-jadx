package com.discord.utilities.views;

import androidx.annotation.MainThread;
import d0.z.d.Intrinsics3;
import java.lang.ref.WeakReference;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;

/* compiled from: ViewVisibilityObserverProvider.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006R(\u0010\t\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\b0\u00078\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0016\u0010\u000b\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000b\u0010\f¨\u0006\u000f"}, d2 = {"Lcom/discord/utilities/views/ViewVisibilityObserverProvider;", "", "", "featureName", "Lcom/discord/utilities/views/ViewVisibilityObserver;", "get", "(Ljava/lang/String;)Lcom/discord/utilities/views/ViewVisibilityObserver;", "", "Ljava/lang/ref/WeakReference;", "featureNameToObserverRefMap", "Ljava/util/Map;", ViewVisibilityObserverProvider.INLINE_VOICE_FEATURE, "Ljava/lang/String;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class ViewVisibilityObserverProvider {
    public static final String INLINE_VOICE_FEATURE = "INLINE_VOICE_FEATURE";
    public static final ViewVisibilityObserverProvider INSTANCE = new ViewVisibilityObserverProvider();
    private static final Map<String, WeakReference<ViewVisibilityObserver>> featureNameToObserverRefMap = new LinkedHashMap();

    private ViewVisibilityObserverProvider() {
    }

    @MainThread
    public final ViewVisibilityObserver get(String featureName) {
        Intrinsics3.checkNotNullParameter(featureName, "featureName");
        Map<String, WeakReference<ViewVisibilityObserver>> map = featureNameToObserverRefMap;
        WeakReference<ViewVisibilityObserver> weakReference = map.get(featureName);
        ViewVisibilityObserver viewVisibilityObserver = weakReference != null ? weakReference.get() : null;
        if (viewVisibilityObserver != null) {
            return viewVisibilityObserver;
        }
        ViewVisibilityObserver viewVisibilityObserver2 = new ViewVisibilityObserver();
        map.put(featureName, new WeakReference<>(viewVisibilityObserver2));
        return viewVisibilityObserver2;
    }
}

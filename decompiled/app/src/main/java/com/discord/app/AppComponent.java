package com.discord.app;

import kotlin.Metadata;
import rx.subjects.Subject;

/* compiled from: AppComponent.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001R\"\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0007"}, d2 = {"Lcom/discord/app/AppComponent;", "", "Lrx/subjects/Subject;", "Ljava/lang/Void;", "getUnsubscribeSignal", "()Lrx/subjects/Subject;", "unsubscribeSignal", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public interface AppComponent {
    Subject<Void, Void> getUnsubscribeSignal();
}

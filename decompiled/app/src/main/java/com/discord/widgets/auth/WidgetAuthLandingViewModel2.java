package com.discord.widgets.auth;

import androidx.core.app.NotificationCompat;
import com.discord.stores.StoreGuildTemplates;
import j0.k.Func1;
import j0.l.e.ScalarSynchronousObservable;
import kotlin.Metadata;
import rx.Observable;
import rx.functions.Action0;

/* compiled from: WidgetAuthLandingViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0007\u001a*\u0012\u000e\b\u0001\u0012\n \u0004*\u0004\u0018\u00010\u00030\u0003 \u0004*\u0014\u0012\u000e\b\u0001\u0012\n \u0004*\u0004\u0018\u00010\u00030\u0003\u0018\u00010\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"", "guildTemplateCode", "Lrx/Observable;", "Lcom/discord/stores/StoreGuildTemplates$GuildTemplateState;", "kotlin.jvm.PlatformType", NotificationCompat.CATEGORY_CALL, "(Ljava/lang/String;)Lrx/Observable;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.auth.WidgetAuthLandingViewModel$Companion$observeStoreState$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetAuthLandingViewModel2<T, R> implements Func1<String, Observable<? extends StoreGuildTemplates.GuildTemplateState>> {
    public final /* synthetic */ StoreGuildTemplates $storeGuildTemplates;

    /* compiled from: WidgetAuthLandingViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", NotificationCompat.CATEGORY_CALL, "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.auth.WidgetAuthLandingViewModel$Companion$observeStoreState$1$1, reason: invalid class name */
    public static final class AnonymousClass1 implements Action0 {
        public final /* synthetic */ String $guildTemplateCode;

        public AnonymousClass1(String str) {
            this.$guildTemplateCode = str;
        }

        @Override // rx.functions.Action0
        public final void call() {
            WidgetAuthLandingViewModel2.this.$storeGuildTemplates.maybeInitTemplateState(this.$guildTemplateCode);
        }
    }

    public WidgetAuthLandingViewModel2(StoreGuildTemplates storeGuildTemplates) {
        this.$storeGuildTemplates = storeGuildTemplates;
    }

    @Override // j0.k.Func1
    public /* bridge */ /* synthetic */ Observable<? extends StoreGuildTemplates.GuildTemplateState> call(String str) {
        return call2(str);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends StoreGuildTemplates.GuildTemplateState> call2(String str) {
        return str != null ? this.$storeGuildTemplates.observeGuildTemplate(str).v(new AnonymousClass1(str)) : new ScalarSynchronousObservable(StoreGuildTemplates.GuildTemplateState.None.INSTANCE);
    }
}

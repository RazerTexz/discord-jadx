package com.discord.widgets.settings;

import com.discord.models.domain.ModelUserSettings;
import com.discord.stores.StoreStream;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import rx.subjects.BehaviorSubject;

/* compiled from: WidgetSettingsAppearance.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\u0010\u0005\u001a&\u0012\f\u0012\n \u0002*\u0004\u0018\u00010\u00010\u0001 \u0002*\u0012\u0012\f\u0012\n \u0002*\u0004\u0018\u00010\u00010\u0001\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lrx/subjects/BehaviorSubject;", "", "kotlin.jvm.PlatformType", "invoke", "()Lrx/subjects/BehaviorSubject;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.settings.WidgetSettingsAppearance$pureEvilEasterEggSubject$2, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetSettingsAppearance4 extends Lambda implements Function0<BehaviorSubject<Boolean>> {
    public static final WidgetSettingsAppearance4 INSTANCE = new WidgetSettingsAppearance4();

    public WidgetSettingsAppearance4() {
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ BehaviorSubject<Boolean> invoke() {
        return invoke2();
    }

    @Override // kotlin.jvm.functions.Function0
    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final BehaviorSubject<Boolean> invoke2() {
        return BehaviorSubject.l0(Boolean.valueOf(Intrinsics3.areEqual(StoreStream.INSTANCE.getUserSettingsSystem().getTheme(), ModelUserSettings.THEME_PURE_EVIL)));
    }
}

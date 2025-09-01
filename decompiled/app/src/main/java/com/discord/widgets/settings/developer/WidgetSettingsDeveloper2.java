package com.discord.widgets.settings.developer;

import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.experiments.ExperimentRegistry2;
import com.discord.widgets.settings.developer.ExperimentOverridesAdapter;
import com.discord.widgets.settings.developer.WidgetSettingsDeveloper;
import d0.z.d.Lambda;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* compiled from: WidgetSettingsDeveloper.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000-\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001R\"\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R(\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u001c\u0010\u000f\u001a\u00020\u00038\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0013\u001a\u00020\u00038\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0010\u001a\u0004\b\u0014\u0010\u0012R\u001e\u0010\u0015\u001a\u0004\u0018\u00010\t8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\"\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\n0\u00198\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d¨\u0006\u001e¸\u0006\u0000"}, d2 = {"com/discord/widgets/settings/developer/WidgetSettingsDeveloper$setupExperimentSection$1$1$1", "Lcom/discord/widgets/settings/developer/ExperimentOverridesAdapter$Item;", "", "", "bucketDescriptions", "Ljava/util/List;", "getBucketDescriptions", "()Ljava/util/List;", "Lkotlin/Function1;", "", "", "onOverrideBucketSelected", "Lkotlin/jvm/functions/Function1;", "getOnOverrideBucketSelected", "()Lkotlin/jvm/functions/Function1;", "apiName", "Ljava/lang/String;", "getApiName", "()Ljava/lang/String;", ModelAuditLogEntry.CHANGE_KEY_NAME, "getName", "overrideBucket", "Ljava/lang/Integer;", "getOverrideBucket", "()Ljava/lang/Integer;", "Lkotlin/Function0;", "onOverrideBucketCleared", "Lkotlin/jvm/functions/Function0;", "getOnOverrideBucketCleared", "()Lkotlin/jvm/functions/Function0;", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.settings.developer.WidgetSettingsDeveloper$setupExperimentSection$1$$special$$inlined$map$lambda$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetSettingsDeveloper2 implements ExperimentOverridesAdapter.Item {
    public final /* synthetic */ Map $allOverrides$inlined;
    public final /* synthetic */ ExperimentRegistry2 $registeredExperiment;
    private final String apiName;
    private final List<String> bucketDescriptions;
    private final String name;
    private final Integer overrideBucket;
    public final /* synthetic */ WidgetSettingsDeveloper.AnonymousClass1 this$0;
    private final Function1<Integer, Unit> onOverrideBucketSelected = new AnonymousClass1();
    private final Function0<Unit> onOverrideBucketCleared = new AnonymousClass2();

    /* compiled from: WidgetSettingsDeveloper.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"", "it", "", "invoke", "(I)V", "com/discord/widgets/settings/developer/WidgetSettingsDeveloper$setupExperimentSection$1$1$1$onOverrideBucketSelected$1", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.settings.developer.WidgetSettingsDeveloper$setupExperimentSection$1$$special$$inlined$map$lambda$1$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<Integer, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
            invoke(num.intValue());
            return Unit.a;
        }

        public final void invoke(int i) {
            WidgetSettingsDeveloper2 widgetSettingsDeveloper2 = WidgetSettingsDeveloper2.this;
            widgetSettingsDeveloper2.this$0.$experimentStore.setOverride(widgetSettingsDeveloper2.$registeredExperiment.getName(), i);
        }
    }

    /* compiled from: WidgetSettingsDeveloper.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0004\u0010\u0004\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002¨\u0006\u0003"}, d2 = {"", "invoke", "()V", "com/discord/widgets/settings/developer/WidgetSettingsDeveloper$setupExperimentSection$1$1$1$onOverrideBucketCleared$1", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.settings.developer.WidgetSettingsDeveloper$setupExperimentSection$1$$special$$inlined$map$lambda$1$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function0<Unit> {
        public AnonymousClass2() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            WidgetSettingsDeveloper2 widgetSettingsDeveloper2 = WidgetSettingsDeveloper2.this;
            widgetSettingsDeveloper2.this$0.$experimentStore.clearOverride(widgetSettingsDeveloper2.$registeredExperiment.getName());
        }
    }

    public WidgetSettingsDeveloper2(ExperimentRegistry2 experimentRegistry2, WidgetSettingsDeveloper.AnonymousClass1 anonymousClass1, Map map) {
        this.$registeredExperiment = experimentRegistry2;
        this.this$0 = anonymousClass1;
        this.$allOverrides$inlined = map;
        this.name = experimentRegistry2.getReadableName();
        this.apiName = experimentRegistry2.getName();
        this.overrideBucket = (Integer) map.get(experimentRegistry2.getName());
        this.bucketDescriptions = experimentRegistry2.getBuckets();
    }

    @Override // com.discord.widgets.settings.developer.ExperimentOverridesAdapter.Item
    public String getApiName() {
        return this.apiName;
    }

    @Override // com.discord.widgets.settings.developer.ExperimentOverridesAdapter.Item
    public List<String> getBucketDescriptions() {
        return this.bucketDescriptions;
    }

    @Override // com.discord.widgets.settings.developer.ExperimentOverridesAdapter.Item
    public String getName() {
        return this.name;
    }

    @Override // com.discord.widgets.settings.developer.ExperimentOverridesAdapter.Item
    public Function0<Unit> getOnOverrideBucketCleared() {
        return this.onOverrideBucketCleared;
    }

    @Override // com.discord.widgets.settings.developer.ExperimentOverridesAdapter.Item
    public Function1<Integer, Unit> getOnOverrideBucketSelected() {
        return this.onOverrideBucketSelected;
    }

    @Override // com.discord.widgets.settings.developer.ExperimentOverridesAdapter.Item
    public Integer getOverrideBucket() {
        return this.overrideBucket;
    }
}

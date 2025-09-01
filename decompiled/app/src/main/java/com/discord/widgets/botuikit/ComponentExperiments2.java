package com.discord.widgets.botuikit;

import com.discord.api.botuikit.Component6;
import com.discord.models.experiments.domain.Experiment;
import com.discord.stores.StoreExperiments;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: ComponentExperiments.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u000f\u0012\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nR\u0019\u0010\f\u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0013"}, d2 = {"Lcom/discord/widgets/botuikit/BotComponentExperiments;", "Lcom/discord/widgets/botuikit/ComponentExperiments;", "Lcom/discord/api/botuikit/ComponentType;", "componentType", "", "isEnabled", "(Lcom/discord/api/botuikit/ComponentType;)Z", "", "experimentName", "isExperimentEnabled", "(Ljava/lang/String;)Z", "Lcom/discord/stores/StoreExperiments;", "storeExperiments", "Lcom/discord/stores/StoreExperiments;", "getStoreExperiments", "()Lcom/discord/stores/StoreExperiments;", "<init>", "(Lcom/discord/stores/StoreExperiments;)V", "Companion", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.botuikit.BotComponentExperiments, reason: use source file name */
/* loaded from: classes2.dex */
public final class ComponentExperiments2 implements ComponentExperiments {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static ComponentExperiments2 botComponentExperiments;
    private final StoreExperiments storeExperiments;

    /* compiled from: ComponentExperiments.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006R$\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u0010"}, d2 = {"Lcom/discord/widgets/botuikit/BotComponentExperiments$Companion;", "", "Lcom/discord/stores/StoreExperiments;", "storeExperiments", "Lcom/discord/widgets/botuikit/ComponentExperiments;", "get", "(Lcom/discord/stores/StoreExperiments;)Lcom/discord/widgets/botuikit/ComponentExperiments;", "Lcom/discord/widgets/botuikit/BotComponentExperiments;", "botComponentExperiments", "Lcom/discord/widgets/botuikit/BotComponentExperiments;", "getBotComponentExperiments", "()Lcom/discord/widgets/botuikit/BotComponentExperiments;", "setBotComponentExperiments", "(Lcom/discord/widgets/botuikit/BotComponentExperiments;)V", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.botuikit.BotComponentExperiments$Companion, reason: from kotlin metadata */
    public static final class Companion {
        private Companion() {
        }

        public final ComponentExperiments get(StoreExperiments storeExperiments) {
            Intrinsics3.checkNotNullParameter(storeExperiments, "storeExperiments");
            ComponentExperiments2 botComponentExperiments = getBotComponentExperiments();
            if (botComponentExperiments != null) {
                return botComponentExperiments;
            }
            ComponentExperiments2 componentExperiments2 = new ComponentExperiments2(storeExperiments);
            setBotComponentExperiments(componentExperiments2);
            return componentExperiments2;
        }

        public final ComponentExperiments2 getBotComponentExperiments() {
            return ComponentExperiments2.access$getBotComponentExperiments$cp();
        }

        public final void setBotComponentExperiments(ComponentExperiments2 componentExperiments2) {
            ComponentExperiments2.access$setBotComponentExperiments$cp(componentExperiments2);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.botuikit.BotComponentExperiments$WhenMappings */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            Component6.values();
            int[] iArr = new int[5];
            $EnumSwitchMapping$0 = iArr;
            iArr[Component6.UNKNOWN.ordinal()] = 1;
            iArr[Component6.ACTION_ROW.ordinal()] = 2;
            iArr[Component6.BUTTON.ordinal()] = 3;
            iArr[Component6.SELECT.ordinal()] = 4;
            iArr[Component6.TEXT.ordinal()] = 5;
        }
    }

    public ComponentExperiments2(StoreExperiments storeExperiments) {
        Intrinsics3.checkNotNullParameter(storeExperiments, "storeExperiments");
        this.storeExperiments = storeExperiments;
    }

    public static final /* synthetic */ ComponentExperiments2 access$getBotComponentExperiments$cp() {
        return botComponentExperiments;
    }

    public static final /* synthetic */ void access$setBotComponentExperiments$cp(ComponentExperiments2 componentExperiments2) {
        botComponentExperiments = componentExperiments2;
    }

    public final StoreExperiments getStoreExperiments() {
        return this.storeExperiments;
    }

    @Override // com.discord.widgets.botuikit.ComponentExperiments
    public boolean isEnabled(Component6 componentType) {
        Intrinsics3.checkNotNullParameter(componentType, "componentType");
        int iOrdinal = componentType.ordinal();
        if (iOrdinal == 0) {
            return false;
        }
        if (iOrdinal == 1 || iOrdinal == 2 || iOrdinal == 3 || iOrdinal == 4) {
            return true;
        }
        throw new NoWhenBranchMatchedException();
    }

    public final boolean isExperimentEnabled(String experimentName) {
        Intrinsics3.checkNotNullParameter(experimentName, "experimentName");
        Experiment userExperiment = this.storeExperiments.getUserExperiment(experimentName, false);
        return userExperiment != null && userExperiment.getBucket() == 1;
    }
}

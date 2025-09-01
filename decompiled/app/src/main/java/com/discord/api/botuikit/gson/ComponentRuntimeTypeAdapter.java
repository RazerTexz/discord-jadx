package com.discord.api.botuikit.gson;

import com.discord.api.botuikit.Component;
import com.discord.api.botuikit.Component6;
import com.discord.api.botuikit.Component9;
import com.discord.gsonutils.RuntimeTypeAdapterFactory;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: ComponentRuntimeTypeAdapter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\b\u0010\tR\u001f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Lcom/discord/api/botuikit/gson/ComponentRuntimeTypeAdapter;", "", "Lcom/discord/gsonutils/RuntimeTypeAdapterFactory;", "Lcom/discord/api/botuikit/Component;", "componentRuntimeTypeAdapterFactory", "Lcom/discord/gsonutils/RuntimeTypeAdapterFactory;", "a", "()Lcom/discord/gsonutils/RuntimeTypeAdapterFactory;", "<init>", "()V", "discord_api"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final class ComponentRuntimeTypeAdapter {
    public static final ComponentRuntimeTypeAdapter INSTANCE = new ComponentRuntimeTypeAdapter();
    private static final RuntimeTypeAdapterFactory<Component> componentRuntimeTypeAdapterFactory;

    static {
        RuntimeTypeAdapterFactory<Component> runtimeTypeAdapterFactory = new RuntimeTypeAdapterFactory<>(Component.class, "type", true, Component9.class);
        Component6[] component6ArrValues = Component6.values();
        for (int i = 0; i < 5; i++) {
            Component6 component6 = component6ArrValues[i];
            Class<? extends Component> clazz = component6.getClazz();
            String strValueOf = String.valueOf(component6.getType());
            if (clazz == null || strValueOf == null) {
                throw null;
            }
            if (runtimeTypeAdapterFactory.m.containsKey(clazz) || runtimeTypeAdapterFactory.l.containsKey(strValueOf)) {
                throw new IllegalArgumentException("types and labels must be unique");
            }
            runtimeTypeAdapterFactory.l.put(strValueOf, clazz);
            runtimeTypeAdapterFactory.m.put(clazz, strValueOf);
        }
        Intrinsics3.checkNotNullExpressionValue(runtimeTypeAdapterFactory, "RuntimeTypeAdapterFactor…ype.toString())\n    }\n  }");
        componentRuntimeTypeAdapterFactory = runtimeTypeAdapterFactory;
    }

    public final RuntimeTypeAdapterFactory<Component> a() {
        return componentRuntimeTypeAdapterFactory;
    }
}
